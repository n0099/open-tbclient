package com.baidu.adp.framework.b;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.f;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements com.baidu.adp.framework.a<M, T> {
    private static com.baidu.adp.framework.listener.d<Message<?>> qo = null;
    protected MessageManager nY;
    private final SparseArray<T> qj = new SparseArray<>();
    private final SparseArray<N> qk = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> ql = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qm = null;
    private boolean mAborted = false;
    private final SparseIntArray qn = new SparseIntArray();

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.nY = null;
        this.nY = messageManager;
    }

    public void registerTask(T t) {
        if (t != null) {
            this.qj.put(t.getCmd(), t);
        }
    }

    public void unRegisterTask(int i) {
        this.qj.remove(i);
    }

    public T findTask(int i) {
        return this.qj.get(i);
    }

    private void y(int i) {
        if (B(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        n.iV();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            y(i);
            LinkedList<MessageListener<N>> linkedList = this.ql.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.ql.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qk.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        n.iV();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.ql.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.ql.valueAt(i);
                    int keyAt = this.ql.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        y(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            y(cmd);
            LinkedList<MessageListener<N>> linkedList = this.ql.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        n.iV();
        if (bdUniqueId != null) {
            int size = this.ql.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.ql.keyAt(i);
                Iterator<MessageListener<N>> it = this.ql.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        y(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean d(M m, T t) {
        n.iV();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.qm != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qm.eU());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qm.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qo != null) {
            qo.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qk.indexOfKey(i) < 0) {
            this.qk.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qk.remove(i);
    }

    public void abort() {
        this.mAborted = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        n.iV();
        if (n != null) {
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qk.indexOfKey(cmd) >= 0) {
                this.qk.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.ql.get(cmd);
            if (linkedList != null) {
                this.mAborted = false;
                z(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.mAborted) {
                        MessageListener<N> next = it.next();
                        if (next != null && (!next.isSelfListener() || next.getTag() == bdUniqueId)) {
                            try {
                                next.onMessage(n);
                            } catch (Exception e) {
                                BdLog.detailException(n.getClass().getName(), e);
                            }
                        }
                    }
                } catch (Exception e2) {
                    BdLog.detailException(n.getClass().getName(), e2);
                } finally {
                    A(cmd);
                }
            }
        }
    }

    private synchronized void z(int i) {
        this.qn.put(i, this.qn.get(i, 0) + 1);
    }

    private synchronized void A(int i) {
        int i2 = this.qn.get(i, 0);
        if (i2 <= 1) {
            this.qn.delete(i);
        } else {
            this.qn.put(i, i2 - 1);
        }
    }

    private synchronized boolean B(int i) {
        boolean z;
        synchronized (this) {
            z = this.qn.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qo = dVar;
    }
}
