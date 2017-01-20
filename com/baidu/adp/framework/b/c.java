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
    private static com.baidu.adp.framework.listener.d<Message<?>> je = null;
    protected MessageManager gN;
    private final SparseArray<T> iY = new SparseArray<>();
    private final SparseArray<N> iZ = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> ja = new SparseArray<>();
    protected com.baidu.adp.framework.c.d jb = null;
    private boolean jc = false;
    private final SparseIntArray jd = new SparseIntArray();

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.gN = null;
        this.gN = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.iY.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.iY.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.iY.get(i);
    }

    public synchronized ArrayList<T> ch() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.iY.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.iY.valueAt(i));
        }
        return arrayList;
    }

    private void R(int i) {
        if (U(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.gz();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            R(i);
            LinkedList<MessageListener<N>> linkedList = this.ja.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.ja.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.iZ.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.gz();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.ja.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.ja.valueAt(i);
                    int keyAt = this.ja.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        R(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            R(cmd);
            LinkedList<MessageListener<N>> linkedList = this.ja.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.gz();
        if (bdUniqueId != null) {
            int size = this.ja.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.ja.keyAt(i);
                Iterator<MessageListener<N>> it = this.ja.valueAt(i).iterator();
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
        k.gz();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.jb != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.jb.cm());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.jb.getRetryCount());
                }
            }
            if (b != null) {
                a(b, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (je != null) {
            je.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.iZ.indexOfKey(i) < 0) {
            this.iZ.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.iZ.remove(i);
    }

    public void abort() {
        this.jc = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.gz();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.iZ.indexOfKey(cmd) >= 0) {
                this.iZ.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.ja.get(cmd);
            if (linkedList != null) {
                this.jc = false;
                S(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.jc) {
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
        this.jd.put(i, this.jd.get(i, 0) + 1);
    }

    private synchronized void T(int i) {
        int i2 = this.jd.get(i, 0);
        if (i2 <= 1) {
            this.jd.delete(i);
        } else {
            this.jd.put(i, i2 - 1);
        }
    }

    private synchronized boolean U(int i) {
        boolean z;
        synchronized (this) {
            z = this.jd.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        je = dVar;
    }
}
