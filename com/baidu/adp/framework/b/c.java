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
    private static com.baidu.adp.framework.listener.b<Message<?>> vT = null;
    protected MessageManager tC;
    private final SparseArray<T> vN = new SparseArray<>();
    private final SparseArray<N> vO = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> vP = new SparseArray<>();
    protected com.baidu.adp.framework.c.d vQ = null;
    private boolean vR = false;
    private final SparseIntArray vS = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.tC = null;
        this.tC = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.vN.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.vN.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.vN.get(i);
    }

    public synchronized ArrayList<T> gl() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.vN.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.vN.valueAt(i));
        }
        return arrayList;
    }

    private void J(int i) {
        if (M(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.kr();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            J(i);
            LinkedList<MessageListener<N>> linkedList = this.vP.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.vP.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.vO.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.kr();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.vP.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.vP.valueAt(i);
                    int keyAt = this.vP.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        J(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            J(cmd);
            LinkedList<MessageListener<N>> linkedList = this.vP.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.kr();
        if (bdUniqueId != null) {
            int size = this.vP.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.vP.keyAt(i);
                Iterator<MessageListener<N>> it = this.vP.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        J(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        l.kr();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.vQ != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.vQ.gq());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.vQ.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (vT != null) {
            vT.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.vO.indexOfKey(i) < 0) {
            this.vO.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.vO.remove(i);
    }

    public void abort() {
        this.vR = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.kr();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.vO.indexOfKey(cmd) >= 0) {
                this.vO.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.vP.get(cmd);
            if (linkedList != null) {
                this.vR = false;
                K(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.vR) {
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
                    L(cmd);
                }
            }
        }
    }

    private synchronized void K(int i) {
        this.vS.put(i, this.vS.get(i, 0) + 1);
    }

    private synchronized void L(int i) {
        int i2 = this.vS.get(i, 0);
        if (i2 <= 1) {
            this.vS.delete(i);
        } else {
            this.vS.put(i, i2 - 1);
        }
    }

    private synchronized boolean M(int i) {
        boolean z;
        synchronized (this) {
            z = this.vS.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        vT = bVar;
    }
}
