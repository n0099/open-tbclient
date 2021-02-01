package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes9.dex */
public class f implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f drp;
    private volatile d drq;
    private volatile com.baidu.swan.apps.performance.d.a drr;

    public static f aEk() {
        if (drp == null) {
            synchronized (f.class) {
                if (drp == null) {
                    drp = new f();
                }
            }
        }
        return drp;
    }

    private f() {
        init();
    }

    private void init() {
        if (this.drq == null) {
            this.drq = new b();
        }
        if (this.drr == null) {
            this.drr = new com.baidu.swan.apps.performance.d.c();
        }
    }

    public com.baidu.swan.apps.performance.d.a aEl() {
        return this.drr;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.drq.start(j);
            this.drr.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cD(long j) {
        if (isOn()) {
            if (DEBUG) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.drq.cD(j);
            this.drr.cD(j);
            cG(j);
        }
    }

    private void cG(long j) {
        com.baidu.swan.apps.al.e.dOf.ab(Long.valueOf(j));
    }

    public boolean isOn() {
        return aEm();
    }

    private boolean aEm() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null) {
            return false;
        }
        String appId = aIL.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.f.a.lB(appId) == 0) ? false : true;
    }
}
