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
    private static com.baidu.adp.framework.listener.b<Message<?>> ve = null;
    protected MessageManager sH;
    private final SparseArray<T> uY = new SparseArray<>();
    private final SparseArray<N> uZ = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> va = new SparseArray<>();
    protected com.baidu.adp.framework.c.d vb = null;
    private boolean vc = false;
    private final SparseIntArray vd = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.sH = null;
        this.sH = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.uY.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.uY.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.uY.get(i);
    }

    public synchronized ArrayList<T> fM() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.uY.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.uY.valueAt(i));
        }
        return arrayList;
    }

    private void J(int i) {
        if (M(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.jT();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            J(i);
            LinkedList<MessageListener<N>> linkedList = this.va.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.va.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.uZ.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.jT();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.va.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.va.valueAt(i);
                    int keyAt = this.va.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        J(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            J(cmd);
            LinkedList<MessageListener<N>> linkedList = this.va.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.jT();
        if (bdUniqueId != null) {
            int size = this.va.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.va.keyAt(i);
                Iterator<MessageListener<N>> it = this.va.valueAt(i).iterator();
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
        l.jT();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.vb != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.vb.fR());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.vb.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (ve != null) {
            ve.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.uZ.indexOfKey(i) < 0) {
            this.uZ.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.uZ.remove(i);
    }

    public void abort() {
        this.vc = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.jT();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.uZ.indexOfKey(cmd) >= 0) {
                this.uZ.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.va.get(cmd);
            if (linkedList != null) {
                this.vc = false;
                K(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.vc) {
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
        this.vd.put(i, this.vd.get(i, 0) + 1);
    }

    private synchronized void L(int i) {
        int i2 = this.vd.get(i, 0);
        if (i2 <= 1) {
            this.vd.delete(i);
        } else {
            this.vd.put(i, i2 - 1);
        }
    }

    private synchronized boolean M(int i) {
        boolean z;
        synchronized (this) {
            z = this.vd.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        ve = bVar;
    }
}
