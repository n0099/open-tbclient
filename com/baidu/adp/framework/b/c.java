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
    private static com.baidu.adp.framework.listener.d<Message<?>> qt = null;
    protected MessageManager od;
    private final SparseArray<T> qn = new SparseArray<>();
    private final SparseArray<N> qo = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> qp = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qq = null;
    private boolean qr = false;
    private final SparseIntArray qs = new SparseIntArray();

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.od = null;
        this.od = messageManager;
    }

    public void registerTask(T t) {
        if (t != null) {
            this.qn.put(t.getCmd(), t);
        }
    }

    public void unRegisterTask(int i) {
        this.qn.remove(i);
    }

    public T findTask(int i) {
        return this.qn.get(i);
    }

    public ArrayList<T> eU() {
        k.jd();
        ArrayList<T> arrayList = new ArrayList<>();
        int size = this.qn.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.qn.valueAt(i));
        }
        return arrayList;
    }

    private void B(int i) {
        if (E(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.jd();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            B(i);
            LinkedList<MessageListener<N>> linkedList = this.qp.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.qp.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qo.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.jd();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.qp.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.qp.valueAt(i);
                    int keyAt = this.qp.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        B(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            B(cmd);
            LinkedList<MessageListener<N>> linkedList = this.qp.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.jd();
        if (bdUniqueId != null) {
            int size = this.qp.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.qp.keyAt(i);
                Iterator<MessageListener<N>> it = this.qp.valueAt(i).iterator();
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
        k.jd();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.qq != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qq.eZ());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qq.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qt != null) {
            qt.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qo.indexOfKey(i) < 0) {
            this.qo.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qo.remove(i);
    }

    public void abort() {
        this.qr = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.jd();
        if (n != null) {
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qo.indexOfKey(cmd) >= 0) {
                this.qo.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.qp.get(cmd);
            if (linkedList != null) {
                this.qr = false;
                C(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.qr) {
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
        this.qs.put(i, this.qs.get(i, 0) + 1);
    }

    private synchronized void D(int i) {
        int i2 = this.qs.get(i, 0);
        if (i2 <= 1) {
            this.qs.delete(i);
        } else {
            this.qs.put(i, i2 - 1);
        }
    }

    private synchronized boolean E(int i) {
        boolean z;
        synchronized (this) {
            z = this.qs.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qt = dVar;
    }
}
