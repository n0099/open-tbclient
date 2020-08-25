package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f cHa;
    private volatile d cHb;
    private volatile com.baidu.swan.apps.performance.d.a cHc;

    public static f awb() {
        if (cHa == null) {
            synchronized (f.class) {
                if (cHa == null) {
                    cHa = new f();
                }
            }
        }
        return cHa;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.cHb == null) {
            this.cHb = new b();
        }
        if (this.cHc == null) {
            this.cHc = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a awc() {
        return this.cHc;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.cHb.start(j);
            this.cHc.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bq(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.cHb.bq(j);
            this.cHc.bq(j);
            bt(j);
        }
    }

    private void bt(long j) {
        com.baidu.swan.apps.am.e.daj.W(Long.valueOf(j));
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
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.km(appId) == 0) ? false : true;
    }
}
