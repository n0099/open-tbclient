package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes.dex */
public class k {
    private static k a = null;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k();
            }
            kVar = a;
        }
        return kVar;
    }

    public PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        PlayerProvider playerProvider = null;
        if (z && !CyberCfgManager.getInstance().a("remote_forbidden", false)) {
            playerProvider = com.baidu.cyberplayer.sdk.remote.h.a(i, httpDNS);
        }
        if (playerProvider == null) {
            playerProvider = d.a(i, httpDNS);
        }
        return playerProvider == null ? new j() : playerProvider;
    }
}
