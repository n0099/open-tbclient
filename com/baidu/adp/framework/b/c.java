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
    private static com.baidu.adp.framework.listener.d<Message<?>> jl = null;
    protected MessageManager gQ;
    private final SparseArray<T> jf = new SparseArray<>();
    private final SparseArray<N> jg = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> jh = new SparseArray<>();
    protected com.baidu.adp.framework.c.d ji = null;
    private boolean jj = false;
    private final SparseIntArray jk = new SparseIntArray();

    public abstract M d(M m, T t);

    public c(MessageManager messageManager) {
        this.gQ = null;
        this.gQ = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.jf.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.jf.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.jf.get(i);
    }

    public synchronized ArrayList<T> cj() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.jf.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.jf.valueAt(i));
        }
        return arrayList;
    }

    private void Q(int i) {
        if (T(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.gB();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            Q(i);
            LinkedList<MessageListener<N>> linkedList = this.jh.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.jh.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.jg.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.gB();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.jh.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.jh.valueAt(i);
                    int keyAt = this.jh.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        Q(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            Q(cmd);
            LinkedList<MessageListener<N>> linkedList = this.jh.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.gB();
        if (bdUniqueId != null) {
            int size = this.jh.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.jh.keyAt(i);
                Iterator<MessageListener<N>> it = this.jh.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        Q(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean e(M m, T t) {
        k.gB();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M d = d(m, t);
            if (this.ji != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.ji.co());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.ji.getRetryCount());
                }
            }
            if (d != null) {
                a(d, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (jl != null) {
            jl.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.jg.indexOfKey(i) < 0) {
            this.jg.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.jg.remove(i);
    }

    public void abort() {
        this.jj = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.gB();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.jg.indexOfKey(cmd) >= 0) {
                this.jg.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.jh.get(cmd);
            if (linkedList != null) {
                this.jj = false;
                R(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.jj) {
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
                    S(cmd);
                }
            }
        }
    }

    private synchronized void R(int i) {
        this.jk.put(i, this.jk.get(i, 0) + 1);
    }

    private synchronized void S(int i) {
        int i2 = this.jk.get(i, 0);
        if (i2 <= 1) {
            this.jk.delete(i);
        } else {
            this.jk.put(i, i2 - 1);
        }
    }

    private synchronized boolean T(int i) {
        boolean z;
        synchronized (this) {
            z = this.jk.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        jl = dVar;
    }
}
