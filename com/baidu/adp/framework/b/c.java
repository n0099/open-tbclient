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
    private static com.baidu.adp.framework.listener.b<Message<?>> sk = null;
    protected MessageManager pT;
    private final SparseArray<T> se = new SparseArray<>();
    private final SparseArray<N> sf = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> sg = new SparseArray<>();
    protected com.baidu.adp.framework.c.d sh = null;
    private boolean si = false;
    private final SparseIntArray sj = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.pT = null;
        this.pT = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.se.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.se.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.se.get(i);
    }

    public synchronized ArrayList<T> dA() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.se.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.se.valueAt(i));
        }
        return arrayList;
    }

    private void S(int i) {
        if (V(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.hG();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            S(i);
            LinkedList<MessageListener<N>> linkedList = this.sg.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.sg.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.sf.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.hG();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.sg.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.sg.valueAt(i);
                    int keyAt = this.sg.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        S(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            S(cmd);
            LinkedList<MessageListener<N>> linkedList = this.sg.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.hG();
        if (bdUniqueId != null) {
            int size = this.sg.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.sg.keyAt(i);
                Iterator<MessageListener<N>> it = this.sg.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        S(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        k.hG();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.sh != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.sh.dF());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.sh.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (sk != null) {
            sk.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.sf.indexOfKey(i) < 0) {
            this.sf.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.sf.remove(i);
    }

    public void abort() {
        this.si = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.hG();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.sf.indexOfKey(cmd) >= 0) {
                this.sf.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.sg.get(cmd);
            if (linkedList != null) {
                this.si = false;
                T(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.si) {
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
                    U(cmd);
                }
            }
        }
    }

    private synchronized void T(int i) {
        this.sj.put(i, this.sj.get(i, 0) + 1);
    }

    private synchronized void U(int i) {
        int i2 = this.sj.get(i, 0);
        if (i2 <= 1) {
            this.sj.delete(i);
        } else {
            this.sj.put(i, i2 - 1);
        }
    }

    private synchronized boolean V(int i) {
        boolean z;
        synchronized (this) {
            z = this.sj.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        sk = bVar;
    }
}
