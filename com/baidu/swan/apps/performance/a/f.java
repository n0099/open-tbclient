package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class f implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f cwP;
    private d cwQ;
    private long mCostTime;
    private long mStartTime;

    private void Qn() {
        if (this.cwQ == null) {
            this.cwQ = new b(new c() { // from class: com.baidu.swan.apps.performance.a.f.1
                @Override // com.baidu.swan.apps.performance.a.c
                public boolean a(a aVar) {
                    if (aVar == null || aVar.amM() < 0) {
                        return false;
                    }
                    return (f.DEBUG || !d.cwO.contains(aVar.amL())) && aVar.getStart() <= f.this.amO();
                }
            });
        }
    }

    public static f amN() {
        if (cwP == null) {
            synchronized (f.class) {
                if (cwP == null) {
                    cwP = new f();
                }
            }
        }
        return cwP;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            Qn();
            this.mStartTime = j;
            this.cwQ.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bh(long j) {
        if (isOn()) {
            Qn();
            this.mCostTime = j;
            this.cwQ.bh(j);
            amP();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public void iy(String str) {
        if (this.cwQ != null) {
            this.cwQ.iy(str);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public void iz(String str) {
        if (this.cwQ != null) {
            this.cwQ.iz(str);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public String format() {
        return this.cwQ != null ? this.cwQ.format() : "";
    }

    public long amO() {
        return this.mStartTime + this.mCostTime;
    }

    private void amP() {
        com.baidu.swan.apps.an.e.cNO.T(Long.valueOf(this.mCostTime));
        com.baidu.swan.apps.an.e.cNP.T(this.cwQ.format());
    }

    public boolean isOn() {
        return amQ();
    }

    private boolean amQ() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null) {
            return false;
        }
        String appId = apN.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.e.a.iC(appId) == 0) ? false : true;
    }
}
