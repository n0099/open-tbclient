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
    private static com.baidu.adp.framework.listener.b<Message<?>> aeD = null;
    protected MessageManager acn;
    private final SparseArray<T> aex = new SparseArray<>();
    private final SparseArray<N> aey = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> aez = new SparseArray<>();
    protected com.baidu.adp.framework.c.d aeA = null;
    private boolean aeB = false;
    private final SparseIntArray aeC = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.acn = null;
        this.acn = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.aex.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.aex.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.aex.get(i);
    }

    public synchronized ArrayList<T> kU() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.aex.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.aex.valueAt(i));
        }
        return arrayList;
    }

    private void cI(int i) {
        if (cL(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        l.oY();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            cI(i);
            LinkedList<MessageListener<N>> linkedList = this.aez.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.aez.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.aey.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        l.oY();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.aez.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.aez.valueAt(i);
                    int keyAt = this.aez.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        cI(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            cI(cmd);
            LinkedList<MessageListener<N>> linkedList = this.aez.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        l.oY();
        if (bdUniqueId != null) {
            int size = this.aez.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.aez.keyAt(i);
                Iterator<MessageListener<N>> it = this.aez.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        cI(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        l.oY();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.aeA != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.aeA.kZ());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.aeA.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (aeD != null) {
            aeD.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.aey.indexOfKey(i) < 0) {
            this.aey.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.aey.remove(i);
    }

    public void abort() {
        this.aeB = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.oY();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.aey.indexOfKey(cmd) >= 0) {
                this.aey.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.aez.get(cmd);
            if (linkedList != null) {
                this.aeB = false;
                cJ(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.aeB) {
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
                    cK(cmd);
                }
            }
        }
    }

    private synchronized void cJ(int i) {
        this.aeC.put(i, this.aeC.get(i, 0) + 1);
    }

    private synchronized void cK(int i) {
        int i2 = this.aeC.get(i, 0);
        if (i2 <= 1) {
            this.aeC.delete(i);
        } else {
            this.aeC.put(i, i2 - 1);
        }
    }

    private synchronized boolean cL(int i) {
        boolean z;
        synchronized (this) {
            z = this.aeC.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.b<Message<?>> bVar) {
        aeD = bVar;
    }
}
