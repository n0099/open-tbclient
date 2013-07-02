package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
/* loaded from: classes.dex */
public interface ICyberPlayerEngineInitBridge {
    String getVersion();

    boolean init(Context context);

    void setAKSK(String str, String str2);

    void setLibPath(String str);
}
