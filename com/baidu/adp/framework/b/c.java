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
    private static com.baidu.adp.framework.listener.b<Message<?>> yi = null;
    protected MessageManager vS;
    private final SparseArray<T> yc = new SparseArray<>();
    private final SparseArray<N> yd = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> ye = new SparseArray<>();
    protected com.baidu.adp.framework.c.d yf = null;
    private boolean yg = false;
    private final SparseIntArray yh = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.vS = null;
        this.vS = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.yc.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.yc.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.yc.get(i);
    }

    public synchronized ArrayList<T> hi() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.yc.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.yc.valueAt(i));
        }
        return arrayList;
    }

    private void Q(int i) {
        if (T(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.lm();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            Q(i);
            LinkedList<MessageListener<N>> linkedList = this.ye.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.ye.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.yd.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.lm();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.ye.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.ye.valueAt(i);
                    int keyAt = this.ye.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        Q(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            Q(cmd);
            LinkedList<MessageListener<N>> linkedList = this.ye.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            int size = this.ye.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.ye.keyAt(i);
                Iterator<MessageListener<N>> it = this.ye.valueAt(i).iterator();
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

    public boolean c(M m, T t) {
        l.lm();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.yf != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.yf.hn());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.yf.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (yi != null) {
            yi.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.yd.indexOfKey(i) < 0) {
            this.yd.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.yd.remove(i);
    }

    public void abort() {
        this.yg = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.lm();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.yd.indexOfKey(cmd) >= 0) {
                this.yd.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.ye.get(cmd);
            if (linkedList != null) {
                this.yg = false;
                R(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.yg) {
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
        this.yh.put(i, this.yh.get(i, 0) + 1);
    }

    private synchronized void S(int i) {
        int i2 = this.yh.get(i, 0);
        if (i2 <= 1) {
            this.yh.delete(i);
        } else {
            this.yh.put(i, i2 - 1);
        }
    }

    private synchronized boolean T(int i) {
        boolean z;
        synchronized (this) {
            z = this.yh.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        yi = bVar;
    }
}
