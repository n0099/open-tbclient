package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class c implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b dej;
    private long mCostTime;
    private long mStartTime;

    public c() {
        if (isOn()) {
            this.dej = new b();
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bF(long j) {
        if (isOn() && this.dej != null) {
            this.dej.bI(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void be(long j) {
        if (isOn() && this.dej != null) {
            this.dej.bH(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bG(long j) {
        if (isOn() && this.dej != null) {
            this.dej.bJ(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.d.a
    public void bd(long j) {
        if (isOn() && this.dej != null) {
            this.dej.bK(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.dej != null) {
            this.mStartTime = j;
            this.dej.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bB(long j) {
        if (isOn() && this.dej != null) {
            this.mCostTime = j;
            this.dej.i(this.mStartTime, this.mCostTime);
            this.dej.done();
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
        if (this.dej == null) {
            this.dej = new b();
        }
        this.dej.aBM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.dej != null) {
            this.dej.aBN();
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
