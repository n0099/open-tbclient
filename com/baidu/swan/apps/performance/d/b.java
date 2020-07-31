package com.baidu.swan.apps.performance.d;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.performance.a.e;
/* loaded from: classes7.dex */
public class b implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b czs;
    private a czt;
    private long mCostTime;
    private long mStartTime;

    public static b aoz() {
        if (czs == null) {
            synchronized (b.class) {
                if (czs == null) {
                    czs = new b();
                }
            }
        }
        return czs;
    }

    private b() {
        if (isOn()) {
            this.czt = new a();
        }
    }

    public void br(long j) {
        if (isOn() && this.czt != null) {
            this.czt.bo(j - this.mStartTime);
        }
    }

    public void aP(long j) {
        if (isOn() && this.czt != null) {
            this.czt.bn(j - this.mStartTime);
        }
    }

    public void bs(long j) {
        if (isOn() && this.czt != null) {
            this.czt.bp(j - this.mStartTime);
        }
    }

    public void aO(long j) {
        if (isOn() && this.czt != null) {
            this.czt.bq(j - this.mStartTime);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        if (isOn() && this.czt != null) {
            this.mStartTime = j;
            this.czt.reset();
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bl(long j) {
        if (isOn() && this.czt != null) {
            this.mCostTime = j;
            this.czt.m(this.mStartTime, this.mCostTime);
            this.czt.done();
        }
    }

    public void bindView(View view) {
        if (DEBUG && view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.apps.performance.d.b.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.isOn()) {
                        b.this.turnOff();
                        return true;
                    }
                    b.this.turnOn();
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOn() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
        if (this.czt == null) {
            this.czt = new a();
        }
        this.czt.aox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOff() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        if (this.czt != null) {
            this.czt.aoy();
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
