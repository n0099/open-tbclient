package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes3.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f cJe;
    private volatile d cJf;
    private volatile com.baidu.swan.apps.performance.d.a cJg;

    public static f awK() {
        if (cJe == null) {
            synchronized (f.class) {
                if (cJe == null) {
                    cJe = new f();
                }
            }
        }
        return cJe;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.cJf == null) {
            this.cJf = new b();
        }
        if (this.cJg == null) {
            this.cJg = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a awL() {
        return this.cJg;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.cJf.start(j);
            this.cJg.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void br(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.cJf.br(j);
            this.cJg.br(j);
            bu(j);
        }
    }

    private void bu(long j) {
        com.baidu.swan.apps.am.e.dcp.X(Long.valueOf(j));
    }

    public boolean isOn() {
        return awM();
    }

    private boolean awM() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null) {
            return false;
        }
        String appId = aAs.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.kG(appId) == 0) ? false : true;
    }
}
