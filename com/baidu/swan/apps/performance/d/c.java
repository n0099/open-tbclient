package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cVJ;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.cVJ = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bD(long j) {
        if (isOn() && this.cVJ != null) {
            this.cVJ.bG(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bc(long j) {
        if (isOn() && this.cVJ != null) {
            this.cVJ.bF(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bE(long j) {
        if (isOn() && this.cVJ != null) {
            this.cVJ.bH(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bb(long j) {
        if (isOn() && this.cVJ != null) {
            this.cVJ.bI(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.cVJ != null) {
            this.mStartTime = j;
            this.cVJ.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bz(long j) {
        if (isOn() && this.cVJ != null) {
            this.mCostTime = j;
            this.cVJ.i(this.mStartTime, this.mCostTime);
            this.cVJ.done();
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
        if (this.cVJ == null) {
            this.cVJ = new b();
        }
        this.cVJ.azS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.cVJ != null) {
            this.cVJ.azT();
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
