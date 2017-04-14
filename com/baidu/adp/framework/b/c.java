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
    private static com.baidu.adp.framework.listener.d<Message<?>> qy = null;
    protected MessageManager od;
    private final SparseArray<T> qs = new SparseArray<>();
    private final SparseArray<N> qt = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> qu = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qv = null;
    private boolean qw = false;
    private final SparseIntArray qx = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.od = null;
        this.od = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.qs.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.qs.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.qs.get(i);
    }

    public synchronized ArrayList<T> dp() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.qs.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.qs.valueAt(i));
        }
        return arrayList;
    }

    private void P(int i) {
        if (S(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.hy();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            P(i);
            LinkedList<MessageListener<N>> linkedList = this.qu.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.qu.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qt.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.hy();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.qu.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.qu.valueAt(i);
                    int keyAt = this.qu.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        P(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            P(cmd);
            LinkedList<MessageListener<N>> linkedList = this.qu.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.hy();
        if (bdUniqueId != null) {
            int size = this.qu.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.qu.keyAt(i);
                Iterator<MessageListener<N>> it = this.qu.valueAt(i).iterator();
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
        k.hy();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.qv != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qv.du());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qv.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qy != null) {
            qy.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qt.indexOfKey(i) < 0) {
            this.qt.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qt.remove(i);
    }

    public void abort() {
        this.qw = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.hy();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qt.indexOfKey(cmd) >= 0) {
                this.qt.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.qu.get(cmd);
            if (linkedList != null) {
                this.qw = false;
                Q(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.qw) {
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
        this.qx.put(i, this.qx.get(i, 0) + 1);
    }

    private synchronized void R(int i) {
        int i2 = this.qx.get(i, 0);
        if (i2 <= 1) {
            this.qx.delete(i);
        } else {
            this.qx.put(i, i2 - 1);
        }
    }

    private synchronized boolean S(int i) {
        boolean z;
        synchronized (this) {
            z = this.qx.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qy = dVar;
    }
}
