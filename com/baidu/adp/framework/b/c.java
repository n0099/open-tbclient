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
    private static com.baidu.adp.framework.listener.d<Message<?>> qZ = null;
    protected MessageManager oI;
    private final SparseArray<T> qT = new SparseArray<>();
    private final SparseArray<N> qU = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> qV = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qW = null;
    private boolean qX = false;
    private final SparseIntArray qY = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.oI = null;
        this.oI = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.qT.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.qT.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.qT.get(i);
    }

    public synchronized ArrayList<T> dq() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.qT.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.qT.valueAt(i));
        }
        return arrayList;
    }

    private void R(int i) {
        if (U(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.ht();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            R(i);
            LinkedList<MessageListener<N>> linkedList = this.qV.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.qV.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qU.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.ht();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.qV.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.qV.valueAt(i);
                    int keyAt = this.qV.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        R(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            R(cmd);
            LinkedList<MessageListener<N>> linkedList = this.qV.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.ht();
        if (bdUniqueId != null) {
            int size = this.qV.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.qV.keyAt(i);
                Iterator<MessageListener<N>> it = this.qV.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        R(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        k.ht();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.qW != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qW.dv());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qW.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qZ != null) {
            qZ.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qU.indexOfKey(i) < 0) {
            this.qU.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qU.remove(i);
    }

    public void abort() {
        this.qX = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.ht();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qU.indexOfKey(cmd) >= 0) {
                this.qU.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.qV.get(cmd);
            if (linkedList != null) {
                this.qX = false;
                S(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.qX) {
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
                    T(cmd);
                }
            }
        }
    }

    private synchronized void S(int i) {
        this.qY.put(i, this.qY.get(i, 0) + 1);
    }

    private synchronized void T(int i) {
        int i2 = this.qY.get(i, 0);
        if (i2 <= 1) {
            this.qY.delete(i);
        } else {
            this.qY.put(i, i2 - 1);
        }
    }

    private synchronized boolean U(int i) {
        boolean z;
        synchronized (this) {
            z = this.qY.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qZ = dVar;
    }
}
