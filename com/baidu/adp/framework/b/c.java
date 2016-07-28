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
    private static com.baidu.adp.framework.listener.d<Message<?>> gR = null;
    protected MessageManager eD;
    private final SparseArray<T> gL = new SparseArray<>();
    private final SparseArray<N> gM = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> gN = new SparseArray<>();
    protected com.baidu.adp.framework.c.d gO = null;
    private boolean gP = false;
    private final SparseIntArray gQ = new SparseIntArray();

    public abstract M d(M m, T t);

    public c(MessageManager messageManager) {
        this.eD = null;
        this.eD = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.gL.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.gL.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.gL.get(i);
    }

    public synchronized ArrayList<T> bo() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.gL.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.gL.valueAt(i));
        }
        return arrayList;
    }

    private void D(int i) {
        if (G(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.fF();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            D(i);
            LinkedList<MessageListener<N>> linkedList = this.gN.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.gN.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.gM.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.fF();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.gN.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.gN.valueAt(i);
                    int keyAt = this.gN.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        D(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            D(cmd);
            LinkedList<MessageListener<N>> linkedList = this.gN.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.fF();
        if (bdUniqueId != null) {
            int size = this.gN.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.gN.keyAt(i);
                Iterator<MessageListener<N>> it = this.gN.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        D(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean e(M m, T t) {
        k.fF();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M d = d(m, t);
            if (this.gO != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.gO.bt());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.gO.getRetryCount());
                }
            }
            if (d != null) {
                a(d, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (gR != null) {
            gR.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.gM.indexOfKey(i) < 0) {
            this.gM.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.gM.remove(i);
    }

    public void abort() {
        this.gP = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.fF();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.gM.indexOfKey(cmd) >= 0) {
                this.gM.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.gN.get(cmd);
            if (linkedList != null) {
                this.gP = false;
                E(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.gP) {
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
                    F(cmd);
                }
            }
        }
    }

    private synchronized void E(int i) {
        this.gQ.put(i, this.gQ.get(i, 0) + 1);
    }

    private synchronized void F(int i) {
        int i2 = this.gQ.get(i, 0);
        if (i2 <= 1) {
            this.gQ.delete(i);
        } else {
            this.gQ.put(i, i2 - 1);
        }
    }

    private synchronized boolean G(int i) {
        boolean z;
        synchronized (this) {
            z = this.gQ.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        gR = dVar;
    }
}
