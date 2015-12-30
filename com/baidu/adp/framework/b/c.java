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
    private static com.baidu.adp.framework.listener.d<Message<?>> qs = null;
    protected MessageManager od;
    private final SparseArray<T> qm = new SparseArray<>();
    private final SparseArray<N> qn = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> qo = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qp = null;
    private boolean qq = false;
    private final SparseIntArray qr = new SparseIntArray();

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.od = null;
        this.od = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.qm.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.qm.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.qm.get(i);
    }

    public synchronized ArrayList<T> eR() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.qm.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.qm.valueAt(i));
        }
        return arrayList;
    }

    private void C(int i) {
        if (F(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.jf();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            C(i);
            LinkedList<MessageListener<N>> linkedList = this.qo.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.qo.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qn.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.jf();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.qo.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.qo.valueAt(i);
                    int keyAt = this.qo.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        C(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            C(cmd);
            LinkedList<MessageListener<N>> linkedList = this.qo.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.jf();
        if (bdUniqueId != null) {
            int size = this.qo.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.qo.keyAt(i);
                Iterator<MessageListener<N>> it = this.qo.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        C(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean d(M m, T t) {
        k.jf();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.qp != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qp.eW());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qp.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qs != null) {
            qs.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qn.indexOfKey(i) < 0) {
            this.qn.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qn.remove(i);
    }

    public void abort() {
        this.qq = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.jf();
        if (n != null) {
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qn.indexOfKey(cmd) >= 0) {
                this.qn.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.qo.get(cmd);
            if (linkedList != null) {
                this.qq = false;
                D(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.qq) {
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
                    E(cmd);
                }
            }
        }
    }

    private synchronized void D(int i) {
        this.qr.put(i, this.qr.get(i, 0) + 1);
    }

    private synchronized void E(int i) {
        int i2 = this.qr.get(i, 0);
        if (i2 <= 1) {
            this.qr.delete(i);
        } else {
            this.qr.put(i, i2 - 1);
        }
    }

    private synchronized boolean F(int i) {
        boolean z;
        synchronized (this) {
            z = this.qr.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qs = dVar;
    }
}
