package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes8.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cHC;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.cHC = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bu(long j) {
        if (isOn() && this.cHC != null) {
            this.cHC.bx(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aT(long j) {
        if (isOn() && this.cHC != null) {
            this.cHC.bw(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bv(long j) {
        if (isOn() && this.cHC != null) {
            this.cHC.by(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aS(long j) {
        if (isOn() && this.cHC != null) {
            this.cHC.bz(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.cHC != null) {
            this.mStartTime = j;
            this.cHC.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bq(long j) {
        if (isOn() && this.cHC != null) {
            this.mCostTime = j;
            this.cHC.m(this.mStartTime, this.mCostTime);
            this.cHC.done();
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
        if (this.cHC == null) {
            this.cHC = new b();
        }
        this.cHC.awy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.cHC != null) {
            this.cHC.awz();
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
