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
    private static com.baidu.adp.framework.listener.d<Message<?>> qC = null;
    protected MessageManager og;
    private final SparseArray<T> qw = new SparseArray<>();
    private final SparseArray<N> qx = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> qy = new SparseArray<>();
    protected com.baidu.adp.framework.c.d qz = null;
    private boolean qA = false;
    private final SparseIntArray qB = new SparseIntArray();

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.og = null;
        this.og = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.qw.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.qw.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.qw.get(i);
    }

    public synchronized ArrayList<T> eY() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.qw.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.qw.valueAt(i));
        }
        return arrayList;
    }

    private void L(int i) {
        if (P(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.ju();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            L(i);
            LinkedList<MessageListener<N>> linkedList = this.qy.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.qy.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.qx.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.ju();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.qy.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.qy.valueAt(i);
                    int keyAt = this.qy.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        L(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            L(cmd);
            LinkedList<MessageListener<N>> linkedList = this.qy.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.ju();
        if (bdUniqueId != null) {
            int size = this.qy.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.qy.keyAt(i);
                Iterator<MessageListener<N>> it = this.qy.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        L(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean d(M m, T t) {
        k.ju();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.qz != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.qz.fe());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.qz.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (qC != null) {
            qC.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.qx.indexOfKey(i) < 0) {
            this.qx.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.qx.remove(i);
    }

    public void abort() {
        this.qA = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.ju();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.qx.indexOfKey(cmd) >= 0) {
                this.qx.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.qy.get(cmd);
            if (linkedList != null) {
                this.qA = false;
                M(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.qA) {
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
                    O(cmd);
                }
            }
        }
    }

    private synchronized void M(int i) {
        this.qB.put(i, this.qB.get(i, 0) + 1);
    }

    private synchronized void O(int i) {
        int i2 = this.qB.get(i, 0);
        if (i2 <= 1) {
            this.qB.delete(i);
        } else {
            this.qB.put(i, i2 - 1);
        }
    }

    private synchronized boolean P(int i) {
        boolean z;
        synchronized (this) {
            z = this.qB.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        qC = dVar;
    }
}
