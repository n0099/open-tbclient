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
    private static com.baidu.adp.framework.listener.b<Message<?>> yj = null;
    protected MessageManager vU;
    private final SparseArray<T> yd = new SparseArray<>();
    private final SparseArray<N> ye = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> yf = new SparseArray<>();
    protected com.baidu.adp.framework.c.d yg = null;
    private boolean yh = false;
    private final SparseIntArray yi = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.vU = null;
        this.vU = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.yd.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.yd.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.yd.get(i);
    }

    public synchronized ArrayList<T> hm() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.yd.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.yd.valueAt(i));
        }
        return arrayList;
    }

    private void R(int i) {
        if (U(i)) {
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
            R(i);
            LinkedList<MessageListener<N>> linkedList = this.yf.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.yf.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.ye.get(i);
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
                int size = this.yf.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.yf.valueAt(i);
                    int keyAt = this.yf.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        R(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            R(cmd);
            LinkedList<MessageListener<N>> linkedList = this.yf.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            int size = this.yf.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.yf.keyAt(i);
                Iterator<MessageListener<N>> it = this.yf.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        R(keyAt);
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
            if (this.yg != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.yg.hr());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.yg.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (yj != null) {
            yj.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.ye.indexOfKey(i) < 0) {
            this.ye.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.ye.remove(i);
    }

    public void abort() {
        this.yh = true;
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
            if (this.ye.indexOfKey(cmd) >= 0) {
                this.ye.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.yf.get(cmd);
            if (linkedList != null) {
                this.yh = false;
                S(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.yh) {
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
                    T(cmd);
                }
            }
        }
    }

    private synchronized void S(int i) {
        this.yi.put(i, this.yi.get(i, 0) + 1);
    }

    private synchronized void T(int i) {
        int i2 = this.yi.get(i, 0);
        if (i2 <= 1) {
            this.yi.delete(i);
        } else {
            this.yi.put(i, i2 - 1);
        }
    }

    private synchronized boolean U(int i) {
        boolean z;
        synchronized (this) {
            z = this.yi.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        yj = bVar;
    }
}
