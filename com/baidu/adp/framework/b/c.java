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
    private static com.baidu.adp.framework.listener.b<Message<?>> vQ = null;
    protected MessageManager tz;
    private final SparseArray<T> vK = new SparseArray<>();
    private final SparseArray<N> vL = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> vM = new SparseArray<>();
    protected com.baidu.adp.framework.c.d vN = null;
    private boolean vO = false;
    private final SparseIntArray vP = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.tz = null;
        this.tz = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.vK.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.vK.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.vK.get(i);
    }

    public synchronized ArrayList<T> gb() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.vK.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.vK.valueAt(i));
        }
        return arrayList;
    }

    private void J(int i) {
        if (M(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.kg();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            J(i);
            LinkedList<MessageListener<N>> linkedList = this.vM.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.vM.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.vL.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.kg();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.vM.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.vM.valueAt(i);
                    int keyAt = this.vM.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        J(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            J(cmd);
            LinkedList<MessageListener<N>> linkedList = this.vM.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.kg();
        if (bdUniqueId != null) {
            int size = this.vM.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.vM.keyAt(i);
                Iterator<MessageListener<N>> it = this.vM.valueAt(i).iterator();
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
        l.kg();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.vN != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.vN.gh());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.vN.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (vQ != null) {
            vQ.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.vL.indexOfKey(i) < 0) {
            this.vL.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.vL.remove(i);
    }

    public void abort() {
        this.vO = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.kg();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.vL.indexOfKey(cmd) >= 0) {
                this.vL.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.vM.get(cmd);
            if (linkedList != null) {
                this.vO = false;
                K(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.vO) {
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
        this.vP.put(i, this.vP.get(i, 0) + 1);
    }

    private synchronized void L(int i) {
        int i2 = this.vP.get(i, 0);
        if (i2 <= 1) {
            this.vP.delete(i);
        } else {
            this.vP.put(i, i2 - 1);
        }
    }

    private synchronized boolean M(int i) {
        boolean z;
        synchronized (this) {
            z = this.vP.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        vQ = bVar;
    }
}
