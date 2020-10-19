package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f cVh;
    private volatile d cVi;
    private volatile com.baidu.swan.apps.performance.d.a cVj;

    public static f azv() {
        if (cVh == null) {
            synchronized (f.class) {
                if (cVh == null) {
                    cVh = new f();
                }
            }
        }
        return cVh;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.cVi == null) {
            this.cVi = new b();
        }
        if (this.cVj == null) {
            this.cVj = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a azw() {
        return this.cVj;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.cVi.start(j);
            this.cVj.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bz(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.cVi.bz(j);
            this.cVj.bz(j);
            bC(j);
        }
    }

    private void bC(long j) {
        com.baidu.swan.apps.am.e.doz.aa(Long.valueOf(j));
    }

    public boolean isOn() {
        return azx();
    }

    private boolean azx() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null) {
            return false;
        }
        String appId = aDb.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.ls(appId) == 0) ? false : true;
    }
}
