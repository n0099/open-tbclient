package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes9.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b duw;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.duw = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cB(long j) {
        if (isOn() && this.duw != null) {
            this.duw.cE(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void ca(long j) {
        if (isOn() && this.duw != null) {
            this.duw.cD(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cC(long j) {
        if (isOn() && this.duw != null) {
            this.duw.cF(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bZ(long j) {
        if (isOn() && this.duw != null) {
            this.duw.cG(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.duw != null) {
            this.mStartTime = j;
            this.duw.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cx(long j) {
        if (isOn() && this.duw != null) {
            this.mCostTime = j;
            this.duw.m(this.mStartTime, this.mCostTime);
            this.duw.done();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void aG(View view) {
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
        if (this.duw == null) {
            this.duw = new b();
        }
        this.duw.aIg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.duw != null) {
            this.duw.aIh();
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
