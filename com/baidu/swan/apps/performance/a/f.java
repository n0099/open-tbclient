package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f djD;
    private volatile d djE;
    private volatile com.baidu.swan.apps.performance.d.a djF;

    public static f aDP() {
        if (djD == null) {
            synchronized (f.class) {
                if (djD == null) {
                    djD = new f();
                }
            }
        }
        return djD;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.djE == null) {
            this.djE = new b();
        }
        if (this.djF == null) {
            this.djF = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aDQ() {
        return this.djF;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.djE.start(j);
            this.djF.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bX(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.djE.bX(j);
            this.djF.bX(j);
            ca(j);
        }
    }

    private void ca(long j) {
        com.baidu.swan.apps.am.e.dCR.aa(Long.valueOf(j));
    }

    public boolean isOn() {
        return aDR();
    }

    private boolean aDR() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null) {
            return false;
        }
        String appId = aHv.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.ma(appId) == 0) ? false : true;
    }
}
