package com.baidu.adp.base;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class b {
    public static final int MODE_INVALID = 0;
    protected int mLoadDataMode = 0;
    protected int unique_id = 0;
    protected e mLoadDataCallBack = null;
    protected int mErrorCode = 0;
    protected String mErrorString = null;

    protected abstract boolean LoadData();

    public abstract boolean cancelLoadData();

    public int getLoadDataMode() {
        return this.mLoadDataMode;
    }

    public void setLoadDataCallBack(e eVar) {
        this.mLoadDataCallBack = eVar;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }

    public void setUniqueId(int i) {
        this.unique_id = i;
    }

    public void sendMessage(Message<?> message) {
        check();
        message.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(message);
    }

    public void cancelMessage() {
        check();
        MessageManager.getInstance().removeCustomMessage(this.unique_id);
    }

    public void registerListener(MessageListener<?> messageListener) {
        check();
        if (messageListener != null && messageListener.getTag() == 0) {
            messageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        check();
        if (messageListener != null && messageListener.getTag() == 0) {
            messageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    private void check() {
        if (this.unique_id == 0) {
            BdLog.e(String.valueOf(getClass().getName()) + "'s unique_id wasn't seted!");
        }
    }
}
