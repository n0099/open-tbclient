package com.baidu.live.adp.base;

import com.baidu.live.adp.lib.interfaces.BdLoadDataCallback;
/* loaded from: classes7.dex */
public abstract class BdBaseModelEx {
    protected BdLoadDataCallback mLoadDataCallback = null;

    public abstract boolean cancelLoadData();

    public void setLoadDataCallback(BdLoadDataCallback bdLoadDataCallback) {
        this.mLoadDataCallback = bdLoadDataCallback;
    }
}
