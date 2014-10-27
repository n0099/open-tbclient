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
import com.baidu.adp.lib.util.m;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements com.baidu.adp.framework.a<M, T> {
    private static com.baidu.adp.framework.listener.d<Message<?>> cO = null;
    protected MessageManager aH;
    private final SparseArray<T> cI = new SparseArray<>();
    private final SparseArray<N> cJ = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> cK = new SparseArray<>();
    protected com.baidu.adp.framework.c.d cL = null;
    private boolean cM = false;
    private boolean cN = false;

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.aH = null;
        this.aH = messageManager;
    }

    public void registerTask(T t) {
        if (t != null) {
            this.cI.put(t.getCmd(), t);
        }
    }

    public void unRegisterTask(int i) {
        this.cI.remove(i);
    }

    public T findTask(int i) {
        return this.cI.get(i);
    }

    private void aQ() {
        if (aT()) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        aQ();
        m.ft();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            LinkedList<MessageListener<N>> linkedList = this.cK.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.cK.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.cJ.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        aQ();
        m.ft();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.cK.size();
                for (int i = 0; i < size; i++) {
                    this.cK.valueAt(i).remove(messageListener);
                }
                return;
            }
            LinkedList<MessageListener<N>> linkedList = this.cK.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        aQ();
        m.ft();
        if (bdUniqueId != null) {
            int size = this.cK.size();
            for (int i = 0; i < size; i++) {
                Iterator<MessageListener<N>> it = this.cK.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean d(M m, T t) {
        m.ft();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.cL != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.cL.aY());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.cL.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (cO != null) {
            cO.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.cJ.indexOfKey(i) < 0) {
            this.cJ.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.cJ.remove(i);
    }

    public void abort() {
        this.cM = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        m.ft();
        if (n != null) {
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.cJ.indexOfKey(cmd) >= 0) {
                this.cJ.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.cK.get(cmd);
            if (linkedList != null) {
                this.cM = false;
                aR();
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.cM) {
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
                    aS();
                }
            }
        }
    }

    private void aR() {
        this.cN = true;
    }

    private void aS() {
        this.cN = false;
    }

    private boolean aT() {
        return this.cN;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        cO = dVar;
    }
}
