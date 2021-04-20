package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
/* loaded from: classes2.dex */
public class RemoteDexLoader {
    public static volatile RemoteDexLoader mInstance;
    public XAdContainerFactoryBuilder adContainerFactoryBuilder;

    public static RemoteDexLoader getInstance() {
        if (mInstance == null) {
            synchronized (RemoteDexLoader.class) {
                if (mInstance == null) {
                    mInstance = new RemoteDexLoader();
                }
            }
        }
        return mInstance;
    }

    public IXAdContainerFactory getContainerFactory() {
        XAdContainerFactoryBuilder xAdContainerFactoryBuilder = this.adContainerFactoryBuilder;
        if (xAdContainerFactoryBuilder != null) {
            try {
                return xAdContainerFactoryBuilder.getXAdContainerFactoryInstance();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void initRemoteDex(Context context) {
        if (this.adContainerFactoryBuilder == null) {
            this.adContainerFactoryBuilder = new XAdContainerFactoryBuilder(context);
        }
    }
}
