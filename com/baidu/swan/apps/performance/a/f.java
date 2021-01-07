package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes9.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f dtU;
    private volatile d dtV;
    private volatile com.baidu.swan.apps.performance.d.a dtW;

    public static f aHJ() {
        if (dtU == null) {
            synchronized (f.class) {
                if (dtU == null) {
                    dtU = new f();
                }
            }
        }
        return dtU;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.dtV == null) {
            this.dtV = new b();
        }
        if (this.dtW == null) {
            this.dtW = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aHK() {
        return this.dtW;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.dtV.start(j);
            this.dtW.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cx(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.dtV.cx(j);
            this.dtW.cx(j);
            cA(j);
        }
    }

    private void cA(long j) {
        com.baidu.swan.apps.al.e.dQN.ab(Long.valueOf(j));
    }

    public boolean isOn() {
        return aHL();
    }

    private boolean aHL() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm == null) {
            return false;
        }
        String appId = aMm.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.mu(appId) == 0) ? false : true;
    }
}
