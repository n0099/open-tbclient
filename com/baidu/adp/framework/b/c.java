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
import com.baidu.adp.lib.util.l;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements com.baidu.adp.framework.a<M, T> {
    private static com.baidu.adp.framework.listener.d<Message<?>> eU = null;
    protected MessageManager cN;
    private final SparseArray<T> eP = new SparseArray<>();
    private final SparseArray<N> eQ = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> eR = new SparseArray<>();
    protected com.baidu.adp.framework.c.d eS = null;
    private boolean mAborted = false;
    private boolean eT = false;

    public abstract M c(M m, T t);

    public c(MessageManager messageManager) {
        this.cN = null;
        this.cN = messageManager;
    }

    public void registerTask(T t) {
        if (t != null) {
            this.eP.put(t.getCmd(), t);
        }
    }

    public void unRegisterTask(int i) {
        this.eP.remove(i);
    }

    public T findTask(int i) {
        return this.eP.get(i);
    }

    private void br() {
        if (bu()) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        br();
        l.ft();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            LinkedList<MessageListener<N>> linkedList = this.eR.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.eR.put(i, linkedList);
            }
            FrameHelper.a(linkedList, messageListener);
            N n = this.eQ.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        br();
        l.ft();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.eR.size();
                for (int i = 0; i < size; i++) {
                    this.eR.valueAt(i).remove(messageListener);
                }
                return;
            }
            LinkedList<MessageListener<N>> linkedList = this.eR.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        br();
        l.ft();
        if (bdUniqueId != null) {
            int size = this.eR.size();
            for (int i = 0; i < size; i++) {
                Iterator<MessageListener<N>> it = this.eR.valueAt(i).iterator();
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
        l.ft();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M c = c(m, t);
            if (this.eS != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.eS.bz());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.eS.getRetryCount());
                }
            }
            if (c != null) {
                sendMessage(c, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (eU != null) {
            eU.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.eQ.indexOfKey(i) < 0) {
            this.eQ.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.eQ.remove(i);
    }

    public void abort() {
        this.mAborted = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        l.ft();
        if (n != null) {
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.eQ.indexOfKey(cmd) >= 0) {
                this.eQ.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.eR.get(cmd);
            if (linkedList != null) {
                this.mAborted = false;
                bs();
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.mAborted) {
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
                    bt();
                }
            }
        }
    }

    private void bs() {
        this.eT = true;
    }

    private void bt() {
        this.eT = false;
    }

    private boolean bu() {
        return this.eT;
    }

    public static void setNotFindTaskListener(com.baidu.adp.framework.listener.d<Message<?>> dVar) {
        eU = dVar;
    }
}
