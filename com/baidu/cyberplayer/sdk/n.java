package com.baidu.cyberplayer.sdk;

import android.os.Looper;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes3.dex */
public class n {
    public static n a;

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new n();
            }
            nVar = a;
        }
        return nVar;
    }

    public PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        PlayerProvider playerProvider;
        if (z && !CyberCfgManager.getInstance().a("remote_forbidden", false)) {
            playerProvider = com.baidu.cyberplayer.sdk.remote.i.a(i, httpDNS);
        } else {
            playerProvider = null;
        }
        if (playerProvider == null) {
            playerProvider = f.a(i, httpDNS);
        }
        if (playerProvider == null) {
            if (CyberCfgManager.getInstance().getCfgBoolValue("enable_mediaplayer_sub_thread", true)) {
                playerProvider = l.a();
            } else {
                playerProvider = new m();
            }
        }
        if (playerProvider == null && q.o() && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return new m();
        }
        return playerProvider;
    }
}
