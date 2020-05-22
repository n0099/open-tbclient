package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class f implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f csb;
    private d csc;
    private long mCostTime;
    private long mStartTime;

    private void Ph() {
        if (this.csc == null) {
            this.csc = new b(new c() { // from class: com.baidu.swan.apps.performance.a.f.1
                @Override // com.baidu.swan.apps.performance.a.c
                public boolean a(a aVar) {
                    if (aVar == null || aVar.alG() < 0) {
                        return false;
                    }
                    return (f.DEBUG || !d.csa.contains(aVar.alF())) && aVar.getStart() <= f.this.alI();
                }
            });
        }
    }

    public static f alH() {
        if (csb == null) {
            synchronized (f.class) {
                if (csb == null) {
                    csb = new f();
                }
            }
        }
        return csb;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn()) {
            Ph();
            this.mStartTime = j;
            this.csc.start(j);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bh(long j) {
        if (isOn()) {
            Ph();
            this.mCostTime = j;
            this.csc.bh(j);
            alJ();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public void iq(String str) {
        if (this.csc != null) {
            this.csc.iq(str);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public void ir(String str) {
        if (this.csc != null) {
            this.csc.ir(str);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public String format() {
        return this.csc != null ? this.csc.format() : "";
    }

    public long alI() {
        return this.mStartTime + this.mCostTime;
    }

    private void alJ() {
        com.baidu.swan.apps.an.e.cJe.T(Long.valueOf(this.mCostTime));
        com.baidu.swan.apps.an.e.cJf.T(this.csc.format());
    }

    public boolean isOn() {
        return alK();
    }

    private boolean alK() {
        if (DEBUG) {
            return true;
        }
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null) {
            return false;
        }
        String appId = aoG.getAppId();
        return (TextUtils.isEmpty(appId) || com.baidu.swan.apps.e.a.iu(appId) == 0) ? false : true;
    }
}
