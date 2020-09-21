package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cJG;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.cJG = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bv(long j) {
        if (isOn() && this.cJG != null) {
            this.cJG.by(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aU(long j) {
        if (isOn() && this.cJG != null) {
            this.cJG.bx(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bw(long j) {
        if (isOn() && this.cJG != null) {
            this.cJG.bz(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aT(long j) {
        if (isOn() && this.cJG != null) {
            this.cJG.bA(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.cJG != null) {
            this.mStartTime = j;
            this.cJG.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void br(long j) {
        if (isOn() && this.cJG != null) {
            this.mCostTime = j;
            this.cJG.i(this.mStartTime, this.mCostTime);
            this.cJG.done();
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
        if (this.cJG == null) {
            this.cJG = new b();
        }
        this.cJG.axh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.cJG != null) {
            this.cJG.axi();
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
