package com.baidu.android.bdutil.cuid.api;

import com.baidu.android.bdutil.cuid.sdk.IAppCuidManager;
/* loaded from: classes3.dex */
public class IAppCuidManagerImpl implements IAppCuidManager {
    @Override // com.baidu.android.bdutil.cuid.sdk.IAppCuidManager
    public String getCuid() {
        return AppCuidHelper.getInstance().getmUid();
    }

    @Override // com.baidu.android.bdutil.cuid.sdk.IAppCuidManager
    public String getEnCuid() {
        return AppCuidHelper.getInstance().getmEnUid();
    }
}
