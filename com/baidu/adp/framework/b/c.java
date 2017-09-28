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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements com.baidu.adp.framework.b<M, T> {
    private static com.baidu.adp.framework.listener.b<Message<?>> qb = null;
    protected MessageManager nB;
    private final SparseArray<T> pV = new SparseArray<>();
    private final SparseArray<N> pW = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> pX = new SparseArray<>();
    protected com.baidu.adp.framework.c.d pY = null;
    private boolean pZ = false;
    private final SparseIntArray qa = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.nB = null;
        this.nB = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.pV.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.pV.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.pV.get(i);
    }

    public synchronized ArrayList<T> dq() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.pV.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.pV.valueAt(i));
        }
        return arrayList;
    }

    private void P(int i) {
        if (S(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.hw();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            P(i);
            LinkedList<MessageListener<N>> linkedList = this.pX.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.pX.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.pW.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.hw();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.pX.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.pX.valueAt(i);
                    int keyAt = this.pX.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        P(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            P(cmd);
            LinkedList<MessageListener<N>> linkedList = this.pX.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.hw();
        if (bdUniqueId != null) {
            int size = this.pX.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.pX.keyAt(i);
                Iterator<MessageListener<N>> it = this.pX.valueAt(i).iterator();
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
        l.hw();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.pY != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.pY.dv());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.pY.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qb != null) {
            qb.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.pW.indexOfKey(i) < 0) {
            this.pW.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.pW.remove(i);
    }

    public void abort() {
        this.pZ = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.hw();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.pW.indexOfKey(cmd) >= 0) {
                this.pW.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.pX.get(cmd);
            if (linkedList != null) {
                this.pZ = false;
                Q(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.pZ) {
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
        this.qa.put(i, this.qa.get(i, 0) + 1);
    }

    private synchronized void R(int i) {
        int i2 = this.qa.get(i, 0);
        if (i2 <= 1) {
            this.qa.delete(i);
        } else {
            this.qa.put(i, i2 - 1);
        }
    }

    private synchronized boolean S(int i) {
        boolean z;
        synchronized (this) {
            z = this.qa.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        qb = bVar;
    }
}
