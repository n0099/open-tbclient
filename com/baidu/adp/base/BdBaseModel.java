package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import d.b.b.a.e;
import d.b.b.a.f;
import d.b.b.c.g.a;
/* loaded from: classes.dex */
public abstract class BdBaseModel<T> extends OrmObject {
    public static final int MODE_INVALID = 0;
    public int mErrorCode;
    public String mErrorString;
    public e mLoadDataCallBack;
    public int mLoadDataMode;
    public BdUniqueId unique_id;

    public BdBaseModel() {
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
    }

    private void check() {
    }

    public abstract boolean LoadData();

    public abstract boolean cancelLoadData();

    public void cancelMessage() {
        check();
        MessageManager.getInstance().removeMessage(this.unique_id);
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public int getLoadDataMode() {
        return this.mLoadDataMode;
    }

    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public void registerListener(MessageListener<?> messageListener) {
        check();
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void sendMessage(Message<?> message) {
        if (message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.unique_id);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }

    public void setLoadDataCallBack(e eVar) {
        this.mLoadDataCallBack = eVar;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }

    public void sendMessage(NetMessage netMessage) {
        if (netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.unique_id);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        check();
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    public BdBaseModel(f<T> fVar) {
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
        if (fVar == null) {
            return;
        }
        this.unique_id = fVar.getUniqueId();
    }

    public void registerListener(a aVar) {
        check();
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void registerListener(int i, a aVar) {
        check();
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.unique_id);
        }
        MessageManager.getInstance().registerListener(i, aVar);
    }
}
