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
import com.baidu.adp.lib.util.k;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements com.baidu.adp.framework.b<M, T> {
    private static com.baidu.adp.framework.listener.d<Message<?>> qr = null;
    protected MessageManager od;
    private final SparseArray<T> ql = new SparseArray<>();
    private final SparseArray<N> qm = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> qn = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qo = null;
    private boolean qp = false;
    private final SparseIntArray qq = new SparseIntArray();

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.od = null;
        this.od = messageManager;
    }

    public void registerTask(T t) {
        if (t != null) {
            this.ql.put(t.getCmd(), t);
        }
    }

    public void unRegisterTask(int i) {
        this.ql.remove(i);
    }

    public T findTask(int i) {
        return this.ql.get(i);
    }

    public ArrayList<T> eR() {
        k.ja();
        ArrayList<T> arrayList = new ArrayList<>();
        int size = this.ql.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.ql.valueAt(i));
        }
        return arrayList;
    }

    private void B(int i) {
        if (E(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.ja();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            B(i);
            LinkedList<MessageListener<N>> linkedList = this.qn.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.qn.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qm.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.ja();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.qn.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.qn.valueAt(i);
                    int keyAt = this.qn.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        B(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            B(cmd);
            LinkedList<MessageListener<N>> linkedList = this.qn.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.ja();
        if (bdUniqueId != null) {
            int size = this.qn.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.qn.keyAt(i);
                Iterator<MessageListener<N>> it = this.qn.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        B(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean d(M m, T t) {
        k.ja();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.qo != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qo.eW());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qo.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qr != null) {
            qr.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qm.indexOfKey(i) < 0) {
            this.qm.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qm.remove(i);
    }

    public void abort() {
        this.qp = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.ja();
        if (n != null) {
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qm.indexOfKey(cmd) >= 0) {
                this.qm.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.qn.get(cmd);
            if (linkedList != null) {
                this.qp = false;
                C(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.qp) {
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
                    D(cmd);
                }
            }
        }
    }

    private synchronized void C(int i) {
        this.qq.put(i, this.qq.get(i, 0) + 1);
    }

    private synchronized void D(int i) {
        int i2 = this.qq.get(i, 0);
        if (i2 <= 1) {
            this.qq.delete(i);
        } else {
            this.qq.put(i, i2 - 1);
        }
    }

    private synchronized boolean E(int i) {
        boolean z;
        synchronized (this) {
            z = this.qq.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qr = dVar;
    }
}
