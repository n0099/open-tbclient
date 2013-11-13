package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import com.baidu.cyberplayer.sdk.BEngineManager;
import com.baidu.loginshare.e;
import java.util.Map;
/* loaded from: classes.dex */
public class CyberPlayerEngineManager extends BEngineManager {

    /* renamed from: a  reason: collision with root package name */
    private static CyberPlayerEngineManager f885a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f4a;

    /* renamed from: a  reason: collision with other field name */
    private String f5a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f6a;
    private boolean b;

    public static synchronized CyberPlayerEngineManager getInstance(Context context) {
        CyberPlayerEngineManager cyberPlayerEngineManager;
        synchronized (CyberPlayerEngineManager.class) {
            if (f885a == null && context != null) {
                f885a = new CyberPlayerEngineManager(context);
            }
            cyberPlayerEngineManager = f885a;
        }
        return cyberPlayerEngineManager;
    }

    private CyberPlayerEngineManager(Context context) {
        super(context);
        this.f6a = false;
        this.b = false;
        this.f5a = "http://cybertran.baidu.com/mediasdk/video?method=sdkupdate";
        if (context != null) {
            this.f4a = context.getApplicationContext();
        }
    }

    public synchronized void onInstallCompleted() {
        this.f6a = false;
    }

    public synchronized void onUninstallCompleted() {
        this.b = false;
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager
    public boolean initCyberPlayerEngine(String str, String str2) {
        boolean initCyberPlayer = CyberPlayerEngineInit.initCyberPlayer(this.f4a);
        if (initCyberPlayer) {
            a(str, str2);
        }
        return initCyberPlayer;
    }

    private void a(String str, String str2) {
        CyberPlayerEngineInit.setAKSK(str, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager
    public synchronized void installAsync(BEngineManager.OnEngineListener onEngineListener) {
        a(onEngineListener, true, null);
    }

    @Override // com.baidu.cyberplayer.sdk.BEngineManager
    public boolean EngineInstalled() {
        return d.m16a(this.f4a);
    }

    private synchronized void a(BEngineManager.OnEngineListener onEngineListener, boolean z, Map<String, String> map) {
        if (onEngineListener != null) {
            if (EngineInstalled()) {
                onEngineListener.onInstalled(8);
            } else if (this.f6a) {
                onEngineListener.onInstalled(6);
            } else {
                this.f6a = true;
                a a2 = a(this.f5a, onEngineListener, z, map);
                if (a2 != null) {
                    a2.m6a();
                } else {
                    onEngineListener.onInstalled(7);
                }
            }
        }
    }

    private a a(String str, BEngineManager.OnEngineListener onEngineListener, boolean z, Map<String, String> map) {
        if (str.startsWith(e.f)) {
            return new c(this.f4a, str, this, onEngineListener, z, map);
        }
        if (!str.startsWith("file://")) {
            return null;
        }
        return new b(this.f4a, str, this, onEngineListener, z);
    }
}
