package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static m f4927a;

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (f4927a == null) {
                f4927a = new m();
            }
            mVar = f4927a;
        }
        return mVar;
    }

    public PlayerProvider a(int i2, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        PlayerProvider a2 = (!z || CyberCfgManager.getInstance().a("remote_forbidden", false)) ? null : com.baidu.cyberplayer.sdk.remote.h.a(i2, httpDNS);
        if (a2 == null) {
            a2 = d.a(i2, httpDNS);
        }
        if (a2 == null && CyberCfgManager.getInstance().getCfgBoolValue("enable_mediaplayer_sub_thread", false)) {
            a2 = j.a();
        }
        return a2 == null ? new k() : a2;
    }
}
