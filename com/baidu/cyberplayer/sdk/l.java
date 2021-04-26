package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static l f5135a;

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (f5135a == null) {
                f5135a = new l();
            }
            lVar = f5135a;
        }
        return lVar;
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
