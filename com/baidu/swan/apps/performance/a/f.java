package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f ddH;
    private volatile d ddI;
    private volatile com.baidu.swan.apps.performance.d.a ddJ;

    public static f aBp() {
        if (ddH == null) {
            synchronized (f.class) {
                if (ddH == null) {
                    ddH = new f();
                }
            }
        }
        return ddH;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.ddI == null) {
            this.ddI = new b();
        }
        if (this.ddJ == null) {
            this.ddJ = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aBq() {
        return this.ddJ;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.ddI.start(j);
            this.ddJ.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bB(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.ddI.bB(j);
            this.ddJ.bB(j);
            bE(j);
        }
    }

    private void bE(long j) {
        com.baidu.swan.apps.am.e.dwZ.aa(Long.valueOf(j));
    }

    public boolean isOn() {
        return aBr();
    }

    private boolean aBr() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null) {
            return false;
        }
        String appId = aEV.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.lL(appId) == 0) ? false : true;
    }
}
