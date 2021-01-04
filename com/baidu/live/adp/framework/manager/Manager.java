package com.baidu.live.adp.framework.manager;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.IMessageProcess;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.controller.MessageRule;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NotFindTaskListener;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.settings.TaskSetting;
import com.baidu.live.adp.framework.task.MessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public abstract class Manager<M extends Message<?>, T extends MessageTask, R extends MessageRule<?, ?>, N extends ResponsedMessage<?>> implements IMessageProcess<M, T> {
    private static NotFindTaskListener<Message<?>> mNotFindTaskListener = null;
    protected MessageManager mMessageManager;
    private final SparseArray<T> mTasks = new SparseArray<>();
    private final SparseArray<N> mStickyResponsedMessage = new SparseArray<>();
    private final SparseArray<LinkedList<MessageListener<N>>> mListeners = new SparseArray<>();
    protected TaskSetting mMessageSetting = null;
    private boolean mAborted = false;
    private final SparseIntArray mListenerLocked = new SparseIntArray();

    public abstract M processRule(M m, T t);

    public Manager(MessageManager messageManager) {
        this.mMessageManager = null;
        this.mMessageManager = messageManager;
    }

    public MessageManager getMessageManager() {
        return this.mMessageManager;
    }

    public synchronized void registerTask(T t) {
        if (t != null) {
            this.mTasks.put(t.getCmd(), t);
        }
    }

    public synchronized void unRegisterTask(int i) {
        this.mTasks.remove(i);
    }

    public synchronized T findTask(int i) {
        return this.mTasks.get(i);
    }

    public synchronized ArrayList<T> findTasks() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.mTasks.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.mTasks.valueAt(i));
        }
        return arrayList;
    }

    private void checkListenerLock(int i) {
        if (isListenerLocked(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void registerListener(int i, MessageListener<N> messageListener) {
        BdUtilHelper.checkMainThread();
        if (messageListener != null) {
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            checkListenerLock(i);
            LinkedList<MessageListener<N>> linkedList = this.mListeners.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mListeners.put(i, linkedList);
            }
            FrameHelper.insert(linkedList, messageListener);
            N n = this.mStickyResponsedMessage.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }

    public void unRegisterListener(MessageListener messageListener) {
        BdUtilHelper.checkMainThread();
        if (messageListener != null) {
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.mListeners.valueAt(i);
                    int keyAt = this.mListeners.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        checkListenerLock(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            checkListenerLock(cmd);
            LinkedList<MessageListener<N>> linkedList = this.mListeners.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        BdUtilHelper.checkMainThread();
        if (bdUniqueId != null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.mListeners.keyAt(i);
                Iterator<MessageListener<N>> it = this.mListeners.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        checkListenerLock(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean dispatchMessage(M m, T t) {
        BdUtilHelper.checkMainThread();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = findTask(cmd);
        }
        if (t != null) {
            M processRule = processRule(m, t);
            if (this.mMessageSetting != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.mMessageSetting.getTimeOutData());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.mMessageSetting.getRetryCount());
                } else if (t.getRetry() < 0) {
                    t.setRetry(1);
                }
            }
            if (processRule != null) {
                sendMessage(processRule, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        if (mNotFindTaskListener != null) {
            mNotFindTaskListener.onNotFindTask(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void registerStickyMode(int i) {
        if (this.mStickyResponsedMessage.indexOfKey(i) < 0) {
            this.mStickyResponsedMessage.put(i, null);
        }
    }

    public void unRegisterStickyMode(int i) {
        this.mStickyResponsedMessage.remove(i);
    }

    public void abort() {
        this.mAborted = true;
    }

    public void dispatchResponsedMessage(N n) {
        BdUniqueId bdUniqueId;
        BdUtilHelper.checkMainThread();
        if (n != null) {
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage == null) {
                bdUniqueId = null;
            } else {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.mStickyResponsedMessage.indexOfKey(cmd) >= 0) {
                this.mStickyResponsedMessage.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.mListeners.get(cmd);
            if (linkedList != null) {
                this.mAborted = false;
                lockListener(cmd);
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
                    unLockListener(cmd);
                }
            }
        }
    }

    private synchronized void lockListener(int i) {
        this.mListenerLocked.put(i, this.mListenerLocked.get(i, 0) + 1);
    }

    private synchronized void unLockListener(int i) {
        int i2 = this.mListenerLocked.get(i, 0);
        if (i2 <= 1) {
            this.mListenerLocked.delete(i);
        } else {
            this.mListenerLocked.put(i, i2 - 1);
        }
    }

    private synchronized boolean isListenerLocked(int i) {
        boolean z;
        synchronized (this) {
            z = this.mListenerLocked.get(i, 0) != 0;
        }
        return z;
    }

    public static void setNotFindTaskListener(NotFindTaskListener<Message<?>> notFindTaskListener) {
        mNotFindTaskListener = notFindTaskListener;
    }
}
