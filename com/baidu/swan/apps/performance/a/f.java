package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes7.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f dhT;
    private volatile d dhU;
    private volatile com.baidu.swan.apps.performance.d.a dhV;

    public static f aDh() {
        if (dhT == null) {
            synchronized (f.class) {
                if (dhT == null) {
                    dhT = new f();
                }
            }
        }
        return dhT;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.dhU == null) {
            this.dhU = new b();
        }
        if (this.dhV == null) {
            this.dhV = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aDi() {
        return this.dhV;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.dhU.start(j);
            this.dhV.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bX(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.dhU.bX(j);
            this.dhV.bX(j);
            ca(j);
        }
    }

    private void ca(long j) {
        com.baidu.swan.apps.am.e.dBk.aa(Long.valueOf(j));
    }

    public boolean isOn() {
        return aDj();
    }

    private boolean aDj() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN == null) {
            return false;
        }
        String appId = aGN.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.lU(appId) == 0) ? false : true;
    }
}
