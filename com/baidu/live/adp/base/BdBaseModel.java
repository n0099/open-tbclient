package com.baidu.live.adp.base;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
/* loaded from: classes7.dex */
public abstract class BdBaseModel<T> {
    public static final int MODE_INVALID = 0;
    protected int mErrorCode;
    protected String mErrorString;
    protected BdLoadDataCallBack mLoadDataCallBack;
    protected int mLoadDataMode;
    protected BdUniqueId unique_id;

    public abstract boolean cancelLoadData();

    protected abstract boolean loadData();

    public BdBaseModel() {
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
    }

    public int getLoadDataMode() {
        return this.mLoadDataMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdBaseModel(BdPageContext<T> bdPageContext) {
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
        if (bdPageContext != null) {
            this.unique_id = bdPageContext.getUniqueId();
        }
    }

    public void setLoadDataCallBack(BdLoadDataCallBack bdLoadDataCallBack) {
        this.mLoadDataCallBack = bdLoadDataCallBack;
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

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }

    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public void sendMessage(Message<?> message) {
        if (message != null) {
            if (message.getTag() == null) {
                message.setTag(this.unique_id);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == null) {
                netMessage.setTag(this.unique_id);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }

    public void cancelMessage() {
        check();
        MessageManager.getInstance().removeMessage(this.unique_id);
    }

    public void registerListener(MessageListener<?> messageListener) {
        check();
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        check();
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    public void registerListener(NetMessageListener netMessageListener) {
        check();
        if (netMessageListener != null && netMessageListener.getTag() == null) {
            netMessageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(netMessageListener);
    }

    public void registerListener(int i, NetMessageListener netMessageListener) {
        check();
        if (netMessageListener != null && netMessageListener.getTag() == null) {
            netMessageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(i, netMessageListener);
    }

    private void check() {
    }
}
