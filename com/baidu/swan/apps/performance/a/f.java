package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f dpe;
    private volatile d dpf;
    private volatile com.baidu.swan.apps.performance.d.a dpg;

    public static f aDP() {
        if (dpe == null) {
            synchronized (f.class) {
                if (dpe == null) {
                    dpe = new f();
                }
            }
        }
        return dpe;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.dpf == null) {
            this.dpf = new b();
        }
        if (this.dpg == null) {
            this.dpg = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aDQ() {
        return this.dpg;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.dpf.start(j);
            this.dpg.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cx(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.dpf.cx(j);
            this.dpg.cx(j);
            cA(j);
        }
    }

    private void cA(long j) {
        com.baidu.swan.apps.al.e.dMb.ab(Long.valueOf(j));
    }

    public boolean isOn() {
        return aDR();
    }

    private boolean aDR() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null) {
            return false;
        }
        String appId = aIs.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.lj(appId) == 0) ? false : true;
    }
}
