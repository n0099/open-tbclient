package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
/* loaded from: classes4.dex */
public interface SysUpdateObserver {
    void init();

    void updateNetworkInfo(Context context);

    void updateNetworkProxy(Context context);

    void updatePhoneInfo();
}
