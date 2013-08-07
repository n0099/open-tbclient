package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import com.baidu.cyberplayer.sdk.BCyberPlayerFactory;
/* loaded from: classes.dex */
public class CyberPlayerEngineVersion {

    /* renamed from: a  reason: collision with root package name */
    private static ICyberPlayerEngineVersionBridge f708a = null;

    private static ICyberPlayerEngineVersionBridge a() {
        if (f708a == null) {
            f708a = BCyberPlayerFactory.getProxyFactory().createCyberPlayerEngineVersionProxy();
        }
        return f708a;
    }

    public static String getVersion(Context context) {
        return a().getVersion();
    }
}
