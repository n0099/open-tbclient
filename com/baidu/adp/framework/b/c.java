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
    private static com.baidu.adp.framework.listener.b<Message<?>> oR = null;
    protected MessageManager mt;
    private final SparseArray<T> oL = new SparseArray<>();
    private final SparseArray<N> oM = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> oN = new SparseArray<>();
    protected com.baidu.adp.framework.c.d oO = null;
    private boolean oP = false;
    private final SparseIntArray oQ = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.mt = null;
        this.mt = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.oL.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.oL.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.oL.get(i);
    }

    public synchronized ArrayList<T> cY() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.oL.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.oL.valueAt(i));
        }
        return arrayList;
    }

    private void I(int i) {
        if (L(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.he();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            I(i);
            LinkedList<MessageListener<N>> linkedList = this.oN.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.oN.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.oM.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.he();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.oN.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.oN.valueAt(i);
                    int keyAt = this.oN.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        I(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            I(cmd);
            LinkedList<MessageListener<N>> linkedList = this.oN.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.he();
        if (bdUniqueId != null) {
            int size = this.oN.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.oN.keyAt(i);
                Iterator<MessageListener<N>> it = this.oN.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        I(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        l.he();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.oO != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.oO.dd());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.oO.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (oR != null) {
            oR.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.oM.indexOfKey(i) < 0) {
            this.oM.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.oM.remove(i);
    }

    public void abort() {
        this.oP = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.he();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.oM.indexOfKey(cmd) >= 0) {
                this.oM.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.oN.get(cmd);
            if (linkedList != null) {
                this.oP = false;
                J(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.oP) {
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
                    K(cmd);
                }
            }
        }
    }

    private synchronized void J(int i) {
        this.oQ.put(i, this.oQ.get(i, 0) + 1);
    }

    private synchronized void K(int i) {
        int i2 = this.oQ.get(i, 0);
        if (i2 <= 1) {
            this.oQ.delete(i);
        } else {
            this.oQ.put(i, i2 - 1);
        }
    }

    private synchronized boolean L(int i) {
        boolean z;
        synchronized (this) {
            z = this.oQ.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        oR = bVar;
    }
}
