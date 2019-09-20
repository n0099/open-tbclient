package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes.dex */
public class j {
    private static j a = null;

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    public PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        PlayerProvider playerProvider = null;
        if (z && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
            playerProvider = com.baidu.cyberplayer.sdk.remote.g.a(i, httpDNS);
        }
        if (playerProvider == null) {
            playerProvider = c.a(i, httpDNS);
        }
        return playerProvider == null ? new i() : playerProvider;
    }
}
