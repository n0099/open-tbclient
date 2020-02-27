package com.baidu.live.adp.lib.network.http;

import com.baidu.live.adp.lib.network.http.interfaces.INetWork;
import com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder;
/* loaded from: classes3.dex */
public class BdNetWorkManager {
    private static volatile BdNetWorkManager mInstance = null;
    private INetWorkBuilder mNetBuilder;

    private BdNetWorkManager() {
    }

    public static BdNetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (BdNetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new BdNetWorkManager();
                }
            }
        }
        return mInstance;
    }

    public void init(INetWorkBuilder iNetWorkBuilder) {
        this.mNetBuilder = iNetWorkBuilder;
    }

    public INetWork buildNetWork() {
        if (this.mNetBuilder != null) {
            return this.mNetBuilder.buildNetWork();
        }
        return null;
    }
}
