package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import com.baidu.cyberplayer.sdk.BCyberPlayerFactory;
/* loaded from: classes.dex */
public class CyberPlayerEngineVersion {

    /* renamed from: a  reason: collision with root package name */
    private static ICyberPlayerEngineVersionBridge f710a = null;

    private static ICyberPlayerEngineVersionBridge a() {
        if (f710a == null) {
            f710a = BCyberPlayerFactory.getProxyFactory().createCyberPlayerEngineVersionProxy();
        }
        return f710a;
    }

    public static String getVersion(Context context) {
        return a().getVersion();
    }
}
