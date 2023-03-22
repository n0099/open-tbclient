package com.baidu.searchbox.anr.impl;

import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ioc.IANRRegister_ANRRuntime_ListProvider;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.bj1;
import com.baidu.tieba.dj1;
/* loaded from: classes2.dex */
public class ANRRuntime {
    public static ANRRuntime sInstance;
    @Inject
    public dj1<IANRRegister> mIANRMonitorList;

    public void initmIANRMonitorList() {
        bj1 b = bj1.b();
        this.mIANRMonitorList = b;
        b.a(new IANRRegister_ANRRuntime_ListProvider());
    }

    public ANRRuntime() {
        initmIANRMonitorList();
    }

    public static ANRRuntime getInstance() {
        if (sInstance == null) {
            synchronized (ANRRuntime.class) {
                if (sInstance == null) {
                    sInstance = new ANRRuntime();
                }
            }
        }
        return sInstance;
    }

    public dj1<IANRRegister> getIANRUploadList() {
        return this.mIANRMonitorList;
    }

    public boolean enableANR() {
        dj1<IANRRegister> dj1Var = this.mIANRMonitorList;
        if (dj1Var != null && dj1Var.getList() != null) {
            for (IANRRegister iANRRegister : this.mIANRMonitorList.getList()) {
                if (iANRRegister != null && iANRRegister.checkEnable()) {
                    if (AppConfig.isDebug()) {
                        Log.d(BlockMonitor.TAG, "enableANR = true");
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
