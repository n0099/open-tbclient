package com.baidu.adp.base;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
/* loaded from: classes.dex */
public abstract class e {
    public static final int MODE_INVALID = 0;
    protected int mErrorCode;
    protected String mErrorString;
    protected h mLoadDataCallBack;
    protected int mLoadDataMode;
    protected BdUniqueId unique_id;

    protected abstract boolean LoadData();

    public abstract boolean cancelLoadData();

    public int getLoadDataMode() {
        return this.mLoadDataMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public e() {
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context) {
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
        if (context != null) {
            if (context instanceof BdBaseActivity) {
                this.unique_id = ((BdBaseActivity) context).getUniqueId();
            } else if (context instanceof BdBaseFragmentActivity) {
                this.unique_id = ((BdBaseFragmentActivity) context).getUniqueId();
            }
        }
    }

    public void setLoadDataCallBack(h hVar) {
        this.mLoadDataCallBack = hVar;
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

    public void registerListener(com.baidu.adp.framework.listener.a aVar) {
        check();
        if (aVar != null && aVar.c() == null) {
            aVar.a(this.unique_id);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        check();
        if (aVar != null && aVar.c() == null) {
            aVar.a(this.unique_id);
        }
        MessageManager.getInstance().registerListener(i, aVar);
    }

    private void check() {
    }
}
