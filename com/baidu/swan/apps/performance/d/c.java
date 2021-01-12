package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes8.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b dpH;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.dpH = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cB(long j) {
        if (isOn() && this.dpH != null) {
            this.dpH.cE(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void ca(long j) {
        if (isOn() && this.dpH != null) {
            this.dpH.cD(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void cC(long j) {
        if (isOn() && this.dpH != null) {
            this.dpH.cF(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bZ(long j) {
        if (isOn() && this.dpH != null) {
            this.dpH.cG(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.dpH != null) {
            this.mStartTime = j;
            this.dpH.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cx(long j) {
        if (isOn() && this.dpH != null) {
            this.mCostTime = j;
            this.dpH.m(this.mStartTime, this.mCostTime);
            this.dpH.done();
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
        if (this.dpH == null) {
            this.dpH = new b();
        }
        this.dpH.aEm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.dpH != null) {
            this.dpH.aEn();
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
