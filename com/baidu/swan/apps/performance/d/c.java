package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b dkf;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.dkf = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cb(long j) {
        if (isOn() && this.dkf != null) {
            this.dkf.ce(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bA(long j) {
        if (isOn() && this.dkf != null) {
            this.dkf.cd(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cc(long j) {
        if (isOn() && this.dkf != null) {
            this.dkf.cf(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bz(long j) {
        if (isOn() && this.dkf != null) {
            this.dkf.cg(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.dkf != null) {
            this.mStartTime = j;
            this.dkf.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bX(long j) {
        if (isOn() && this.dkf != null) {
            this.mCostTime = j;
            this.dkf.j(this.mStartTime, this.mCostTime);
            this.dkf.done();
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
        if (this.dkf == null) {
            this.dkf = new b();
        }
        this.dkf.aEm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.dkf != null) {
            this.dkf.aEn();
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
