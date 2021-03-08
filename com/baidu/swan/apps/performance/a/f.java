package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f dsS;
    private volatile d dsT;
    private volatile com.baidu.swan.apps.performance.d.a dsU;

    public static f aEn() {
        if (dsS == null) {
            synchronized (f.class) {
                if (dsS == null) {
                    dsS = new f();
                }
            }
        }
        return dsS;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.dsT == null) {
            this.dsT = new b();
        }
        if (this.dsU == null) {
            this.dsU = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aEo() {
        return this.dsU;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.dsT.start(j);
            this.dsU.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cD(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.dsT.cD(j);
            this.dsU.cD(j);
            cG(j);
        }
    }

    private void cG(long j) {
        com.baidu.swan.apps.al.e.dPG.ad(Long.valueOf(j));
    }

    public boolean isOn() {
        return aEp();
    }

    private boolean aEp() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null) {
            return false;
        }
        String appId = aIO.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.lI(appId) == 0) ? false : true;
    }
}
