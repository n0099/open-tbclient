package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes12.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f1393a = null;

    private l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (f1393a == null) {
                f1393a = new l();
            }
            lVar = f1393a;
        }
        return lVar;
    }

    public PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        PlayerProvider playerProvider = null;
        if (z && !CyberCfgManager.getInstance().a("remote_forbidden", false)) {
            playerProvider = com.baidu.cyberplayer.sdk.remote.h.a(i, httpDNS);
        }
        if (playerProvider == null) {
            playerProvider = d.a(i, httpDNS);
        }
        if (playerProvider == null && CyberCfgManager.getInstance().getCfgBoolValue("enable_mediaplayer_sub_thread", false)) {
            playerProvider = j.a();
        }
        return playerProvider == null ? new k() : playerProvider;
    }
}
