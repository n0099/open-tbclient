package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f cHe;
    private volatile d cHf;
    private volatile com.baidu.swan.apps.performance.d.a cHg;

    public static f awb() {
        if (cHe == null) {
            synchronized (f.class) {
                if (cHe == null) {
                    cHe = new f();
                }
            }
        }
        return cHe;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.cHf == null) {
            this.cHf = new b();
        }
        if (this.cHg == null) {
            this.cHg = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a awc() {
        return this.cHg;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.cHf.start(j);
            this.cHg.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bq(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.cHf.bq(j);
            this.cHg.bq(j);
            bt(j);
        }
    }

    private void bt(long j) {
        com.baidu.swan.apps.am.e.dan.W(Long.valueOf(j));
    }

    public boolean isOn() {
        return awd();
    }

    private boolean awd() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return false;
        }
        String appId = azJ.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.kn(appId) == 0) ? false : true;
    }
}
