package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes8.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cHG;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.cHG = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bu(long j) {
        if (isOn() && this.cHG != null) {
            this.cHG.bx(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aT(long j) {
        if (isOn() && this.cHG != null) {
            this.cHG.bw(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bv(long j) {
        if (isOn() && this.cHG != null) {
            this.cHG.by(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aS(long j) {
        if (isOn() && this.cHG != null) {
            this.cHG.bz(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.cHG != null) {
            this.mStartTime = j;
            this.cHG.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bq(long j) {
        if (isOn() && this.cHG != null) {
            this.mCostTime = j;
            this.cHG.m(this.mStartTime, this.mCostTime);
            this.cHG.done();
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
        if (this.cHG == null) {
            this.cHG = new b();
        }
        this.cHG.awy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.cHG != null) {
            this.cHG.awz();
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
