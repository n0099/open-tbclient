package com.baidu.adp.framework.b;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.f;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message, T extends MessageTask, R extends f, N extends ResponsedMessage<?>> implements com.baidu.adp.framework.a<M, T> {
    protected MessageManager a;
    private final SparseArray<T> c = new SparseArray<>();
    private final SparseArray<N> d = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> e = new SparseArray<>();
    protected com.baidu.adp.framework.c.d b = null;
    private boolean f = false;
    private boolean g = false;

    public abstract M b(M m, T t);

    public c(MessageManager messageManager) {
        this.a = null;
        this.a = messageManager;
    }

    public void a(T t) {
        if (t != null) {
            this.c.put(t.getCmd(), t);
        }
    }

    public void a(int i) {
        this.c.remove(i);
    }

    public T b(int i) {
        return this.c.get(i);
    }

    private void b() {
        if (e()) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void a(int i, MessageListener<N> messageListener) {
        b();
        j.a();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            LinkedList<MessageListener<N>> linkedList = this.e.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.e.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.d.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void a(MessageListener messageListener) {
        b();
        j.a();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.e.size();
                for (int i = 0; i < size; i++) {
                    this.e.valueAt(i).remove(messageListener);
                }
                return;
            }
            LinkedList<MessageListener<N>> linkedList = this.e.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        b();
        j.a();
        if (bdUniqueId != null) {
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                Iterator<MessageListener<N>> it = this.e.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        j.a();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = b(cmd);
        }
        if (t != null) {
            M b = b((c<M, T, R, N>) m, (M) t);
            if (this.b != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.b.d());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.b.c());
                }
            }
            if (b != null) {
                a((c<M, T, R, N>) b, (M) t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void c(int i) {
        if (this.d.indexOfKey(i) < 0) {
            this.d.put(i, null);
        }
    }

    public void d(int i) {
        this.d.remove(i);
    }

    public void a() {
        this.f = true;
    }

    public void a(N n) {
        j.a();
        if (n != null) {
            int cmd = n.getCmd();
            if (this.d.indexOfKey(cmd) >= 0) {
                this.d.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.e.get(cmd);
            if (linkedList != null) {
                this.f = false;
                c();
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.f) {
                        MessageListener<N> next = it.next();
                        if (next != null) {
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
                    d();
                }
            }
        }
    }

    private void c() {
        this.g = true;
    }

    private void d() {
        this.g = false;
    }

    private boolean e() {
        return this.g;
    }
}
