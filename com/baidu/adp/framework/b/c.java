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
import com.baidu.adp.lib.util.l;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements com.baidu.adp.framework.a<M, T> {
    private static com.baidu.adp.framework.listener.d<Message<?>> eW = null;
    protected MessageManager cO;
    private final SparseArray<T> eR = new SparseArray<>();
    private final SparseArray<N> eS = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> eT = new SparseArray<>();
    protected com.baidu.adp.framework.c.d eU = null;
    private boolean mAborted = false;
    private final SparseIntArray eV = new SparseIntArray();

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.cO = null;
        this.cO = messageManager;
    }

    public void registerTask(T t) {
        if (t != null) {
            this.eR.put(t.getCmd(), t);
        }
    }

    public void unRegisterTask(int i) {
        this.eR.remove(i);
    }

    public T findTask(int i) {
        return this.eR.get(i);
    }

    private void x(int i) {
        if (A(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.fs();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            x(i);
            LinkedList<MessageListener<N>> linkedList = this.eT.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.eT.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.eS.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.fs();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.eT.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.eT.valueAt(i);
                    int keyAt = this.eT.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        x(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            x(cmd);
            LinkedList<MessageListener<N>> linkedList = this.eT.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.fs();
        if (bdUniqueId != null) {
            int size = this.eT.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.eT.keyAt(i);
                Iterator<MessageListener<N>> it = this.eT.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        x(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean d(M m, T t) {
        l.fs();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.eU != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.eU.bx());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.eU.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (eW != null) {
            eW.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.eS.indexOfKey(i) < 0) {
            this.eS.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.eS.remove(i);
    }

    public void abort() {
        this.mAborted = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.fs();
        if (n != null) {
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.eS.indexOfKey(cmd) >= 0) {
                this.eS.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.eT.get(cmd);
            if (linkedList != null) {
                this.mAborted = false;
                y(cmd);
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
                    z(cmd);
                }
            }
        }
    }

    private synchronized void y(int i) {
        this.eV.put(i, this.eV.get(i, 0) + 1);
    }

    private synchronized void z(int i) {
        int i2 = this.eV.get(i, 0);
        if (i2 <= 1) {
            this.eV.delete(i);
        } else {
            this.eV.put(i, i2 - 1);
        }
    }

    private synchronized boolean A(int i) {
        boolean z;
        synchronized (this) {
            z = this.eV.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        eW = dVar;
    }
}
