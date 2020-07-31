package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class f implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f cze;
    private d czf;
    private boolean czg;
    private long mCostTime;
    private long mStartTime;

    private void QC() {
        if (this.czf == null) {
            this.czf = new b(new c() { // from class: com.baidu.swan.apps.performance.a.f.1
                @Override // com.baidu.swan.apps.performance.a.c
                public boolean a(a aVar) {
                    if (aVar == null || aVar.aog() < 0) {
                        return false;
                    }
                    return (f.DEBUG || !d.czd.contains(aVar.aof())) && aVar.getStart() <= f.this.aoi();
                }
            });
        }
    }

    public static f aoh() {
        if (cze == null) {
            synchronized (f.class) {
                if (cze == null) {
                    cze = new f();
                }
            }
        }
        return cze;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        this.czg = true;
        if (isOn()) {
            QC();
            this.mStartTime = j;
            this.czf.start(j);
            com.baidu.swan.apps.performance.d.b.aoz().start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bl(long j) {
        this.czg = false;
        if (isOn()) {
            QC();
            this.mCostTime = j;
            this.czf.bl(j);
            aoj();
            com.baidu.swan.apps.performance.d.b.aoz().bl(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public void iI(String str) {
        if (this.czf != null) {
            this.czf.iI(str);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public void iJ(String str) {
        if (this.czf != null) {
            this.czf.iJ(str);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public String format() {
        return this.czf != null ? this.czf.format() : "";
    }

    public long aoi() {
        return this.mStartTime + this.mCostTime;
    }

    private void aoj() {
        com.baidu.swan.apps.an.e.cRj.T(Long.valueOf(this.mCostTime));
        com.baidu.swan.apps.an.e.cRk.T(this.czf.format());
    }

    public boolean isOn() {
        return aok();
    }

    private boolean aok() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null) {
            return false;
        }
        String appId = arw.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.e.a.iM(appId) == 0) ? false : true;
    }

    public boolean aol() {
        return this.czg;
    }
}
