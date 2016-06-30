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
    private static com.baidu.adp.framework.listener.d<Message<?>> gp = null;
    protected MessageManager ea;
    private final SparseArray<T> gj = new SparseArray<>();
    private final SparseArray<N> gk = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> gl = new SparseArray<>();
    protected com.baidu.adp.framework.c.d gm = null;
    private boolean gn = false;
    private final SparseIntArray go = new SparseIntArray();

    public abstract M d(M m, T t);

    public c(MessageManager messageManager) {
        this.ea = null;
        this.ea = messageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.gj.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.gj.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.gj.get(i);
    }

    public synchronized ArrayList<T> bp() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.gj.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.gj.valueAt(i));
        }
        return arrayList;
    }

    private void A(int i) {
        if (D(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        k.fG();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            A(i);
            LinkedList<MessageListener<N>> linkedList = this.gl.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.gl.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.gk.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        k.fG();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.gl.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.gl.valueAt(i);
                    int keyAt = this.gl.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        A(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            A(cmd);
            LinkedList<MessageListener<N>> linkedList = this.gl.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        k.fG();
        if (bdUniqueId != null) {
            int size = this.gl.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.gl.keyAt(i);
                Iterator<MessageListener<N>> it = this.gl.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        A(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean e(M m, T t) {
        k.fG();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M d = d(m, t);
            if (this.gm != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.gm.bu());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.gm.getRetryCount());
                }
            }
            if (d != null) {
                a(d, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (gp != null) {
            gp.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.gk.indexOfKey(i) < 0) {
            this.gk.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.gk.remove(i);
    }

    public void abort() {
        this.gn = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        k.fG();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.gk.indexOfKey(cmd) >= 0) {
                this.gk.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.gl.get(cmd);
            if (linkedList != null) {
                this.gn = false;
                B(cmd);
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.gn) {
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
                    C(cmd);
                }
            }
        }
    }

    private synchronized void B(int i) {
        this.go.put(i, this.go.get(i, 0) + 1);
    }

    private synchronized void C(int i) {
        int i2 = this.go.get(i, 0);
        if (i2 <= 1) {
            this.go.delete(i);
        } else {
            this.go.put(i, i2 - 1);
        }
    }

    private synchronized boolean D(int i) {
        boolean z;
        synchronized (this) {
            z = this.go.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        gp = dVar;
    }
}
