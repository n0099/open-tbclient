package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes25.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b dpx;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.dpx = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cA(long j) {
        if (isOn() && this.dpx != null) {
            this.dpx.cD(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bZ(long j) {
        if (isOn() && this.dpx != null) {
            this.dpx.cC(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cB(long j) {
        if (isOn() && this.dpx != null) {
            this.dpx.cE(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bY(long j) {
        if (isOn() && this.dpx != null) {
            this.dpx.cF(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.dpx != null) {
            this.mStartTime = j;
            this.dpx.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cw(long j) {
        if (isOn() && this.dpx != null) {
            this.mCostTime = j;
            this.dpx.j(this.mStartTime, this.mCostTime);
            this.dpx.done();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bindView(View view) {
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
        if (this.dpx == null) {
            this.dpx = new b();
        }
        this.dpx.aGM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.dpx != null) {
            this.dpx.aGN();
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
