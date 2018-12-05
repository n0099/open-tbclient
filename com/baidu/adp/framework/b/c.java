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
    private static com.baidu.adp.framework.listener.b<Message<?>> ym = null;
    protected MessageManager vW;
    private final SparseArray<T> yg = new SparseArray<>();
    private final SparseArray<N> yh = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> yi = new SparseArray<>();
    protected com.baidu.adp.framework.c.d yj = null;
    private boolean yk = false;
    private final SparseIntArray yl = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.vW = null;
        this.vW = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.yg.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.yg.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.yg.get(i);
    }

    public synchronized ArrayList<T> hl() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.yg.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.yg.valueAt(i));
        }
        return arrayList;
    }

    private void ai(int i) {
        if (al(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.lj();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            ai(i);
            LinkedList<MessageListener<N>> linkedList = this.yi.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.yi.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.yh.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.lj();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.yi.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.yi.valueAt(i);
                    int keyAt = this.yi.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        ai(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            ai(cmd);
            LinkedList<MessageListener<N>> linkedList = this.yi.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.lj();
        if (bdUniqueId != null) {
            int size = this.yi.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.yi.keyAt(i);
                Iterator<MessageListener<N>> it = this.yi.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        ai(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        l.lj();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.yj != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.yj.hq());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.yj.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (ym != null) {
            ym.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.yh.indexOfKey(i) < 0) {
            this.yh.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.yh.remove(i);
    }

    public void abort() {
        this.yk = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.lj();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.yh.indexOfKey(cmd) >= 0) {
                this.yh.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.yi.get(cmd);
            if (linkedList != null) {
                this.yk = false;
                aj(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.yk) {
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
                    ak(cmd);
                }
            }
        }
    }

    private synchronized void aj(int i) {
        this.yl.put(i, this.yl.get(i, 0) + 1);
    }

    private synchronized void ak(int i) {
        int i2 = this.yl.get(i, 0);
        if (i2 <= 1) {
            this.yl.delete(i);
        } else {
            this.yl.put(i, i2 - 1);
        }
    }

    private synchronized boolean al(int i) {
        boolean z;
        synchronized (this) {
            z = this.yl.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        ym = bVar;
    }
}
