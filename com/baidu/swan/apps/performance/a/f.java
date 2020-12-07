package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes25.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f doV;
    private volatile d doW;
    private volatile com.baidu.swan.apps.performance.d.a doX;

    public static f aGp() {
        if (doV == null) {
            synchronized (f.class) {
                if (doV == null) {
                    doV = new f();
                }
            }
        }
        return doV;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.doW == null) {
            this.doW = new b();
        }
        if (this.doX == null) {
            this.doX = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aGq() {
        return this.doX;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.doW.start(j);
            this.doX.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cw(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.doW.cw(j);
            this.doX.cw(j);
            cz(j);
        }
    }

    private void cz(long j) {
        com.baidu.swan.apps.am.e.dIi.aa(Long.valueOf(j));
    }

    public boolean isOn() {
        return aGr();
    }

    private boolean aGr() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null) {
            return false;
        }
        String appId = aJV.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.mB(appId) == 0) ? false : true;
    }
}
