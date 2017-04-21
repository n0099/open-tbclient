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
    private static com.baidu.adp.framework.listener.d<Message<?>> qD = null;
    protected MessageManager od;
    private final SparseArray<T> qx = new SparseArray<>();
    private final SparseArray<N> qy = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> qz = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qA = null;
    private boolean qB = false;
    private final SparseIntArray qC = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.od = null;
        this.od = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.qx.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.qx.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.qx.get(i);
    }

    public synchronized ArrayList<T> dq() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.qx.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.qx.valueAt(i));
        }
        return arrayList;
    }

    private void P(int i) {
        if (S(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.hz();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            P(i);
            LinkedList<MessageListener<N>> linkedList = this.qz.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.qz.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qy.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.hz();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.qz.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.qz.valueAt(i);
                    int keyAt = this.qz.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        P(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            P(cmd);
            LinkedList<MessageListener<N>> linkedList = this.qz.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.hz();
        if (bdUniqueId != null) {
            int size = this.qz.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.qz.keyAt(i);
                Iterator<MessageListener<N>> it = this.qz.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        P(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        k.hz();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.qA != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qA.dv());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qA.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qD != null) {
            qD.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qy.indexOfKey(i) < 0) {
            this.qy.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qy.remove(i);
    }

    public void abort() {
        this.qB = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.hz();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qy.indexOfKey(cmd) >= 0) {
                this.qy.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.qz.get(cmd);
            if (linkedList != null) {
                this.qB = false;
                Q(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.qB) {
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
                    R(cmd);
                }
            }
        }
    }

    private synchronized void Q(int i) {
        this.qC.put(i, this.qC.get(i, 0) + 1);
    }

    private synchronized void R(int i) {
        int i2 = this.qC.get(i, 0);
        if (i2 <= 1) {
            this.qC.delete(i);
        } else {
            this.qC.put(i, i2 - 1);
        }
    }

    private synchronized boolean S(int i) {
        boolean z;
        synchronized (this) {
            z = this.qC.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qD = dVar;
    }
}
