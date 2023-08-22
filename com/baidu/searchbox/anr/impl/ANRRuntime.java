package com.baidu.searchbox.anr.impl;

import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ioc.IANRRegister_ANRRuntime_ListProvider;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.jk1;
import com.baidu.tieba.lk1;
/* loaded from: classes3.dex */
public class ANRRuntime {
    public static ANRRuntime sInstance;
    @Inject
    public lk1<IANRRegister> mIANRMonitorList;

    public void initmIANRMonitorList() {
        jk1 b = jk1.b();
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

    public lk1<IANRRegister> getIANRUploadList() {
        return this.mIANRMonitorList;
    }

    public boolean enableANR() {
        lk1<IANRRegister> lk1Var = this.mIANRMonitorList;
        if (lk1Var != null && lk1Var.getList() != null) {
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
