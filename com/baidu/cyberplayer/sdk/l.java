package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static l f4973a;

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (f4973a == null) {
                f4973a = new l();
            }
            lVar = f4973a;
        }
        return lVar;
    }

    public PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        PlayerProvider a2 = (!z || CyberCfgManager.getInstance().a("remote_forbidden", false)) ? null : com.baidu.cyberplayer.sdk.remote.h.a(i, httpDNS);
        if (a2 == null) {
            a2 = d.a(i, httpDNS);
        }
        if (a2 == null && CyberCfgManager.getInstance().getCfgBoolValue("enable_mediaplayer_sub_thread", false)) {
            a2 = j.a();
        }
        return a2 == null ? new k() : a2;
    }
}
