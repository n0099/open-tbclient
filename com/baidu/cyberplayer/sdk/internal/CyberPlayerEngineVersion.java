package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import com.baidu.cyberplayer.sdk.BCyberPlayerFactory;
/* loaded from: classes.dex */
public class CyberPlayerEngineVersion {
    private static ICyberPlayerEngineVersionBridge a = null;

    private static ICyberPlayerEngineVersionBridge a() {
        if (a == null) {
            a = BCyberPlayerFactory.getProxyFactory().createCyberPlayerEngineVersionProxy();
        }
        return a;
    }

    public static String getVersion(Context context) {
        return a().getVersion();
    }
}
