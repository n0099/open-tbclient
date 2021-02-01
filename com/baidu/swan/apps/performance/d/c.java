package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes9.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b drS;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.drS = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cH(long j) {
        if (isOn() && this.drS != null) {
            this.drS.cK(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cg(long j) {
        if (isOn() && this.drS != null) {
            this.drS.cJ(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cI(long j) {
        if (isOn() && this.drS != null) {
            this.drS.cL(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cf(long j) {
        if (isOn() && this.drS != null) {
            this.drS.cM(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.drS != null) {
            this.mStartTime = j;
            this.drS.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cD(long j) {
        if (isOn() && this.drS != null) {
            this.mCostTime = j;
            this.drS.q(this.mStartTime, this.mCostTime);
            this.drS.done();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aC(View view) {
        if (DEBUG && view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.apps.performance.d.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (c.this.isOn()) {
                        c.this.turnOff();
                        return true;
                    }
                    c.this.turnOn();
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOn() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
        if (this.drS == null) {
            this.drS = new b();
        }
        this.drS.aEH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.drS != null) {
            this.drS.aEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOn() {
        if (DEBUG) {
            return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
        }
        return false;
    }
}
