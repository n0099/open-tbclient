package com.baidu.searchbox.anr.impl;

import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ioc.IANRRegister_ANRRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
import d.a.f0.a.b.b;
import d.a.f0.a.b.d;
/* loaded from: classes2.dex */
public class ANRRuntime {
    public static ANRRuntime sInstance;
    @Inject
    public d<IANRRegister> mIANRMonitorList;

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

    public boolean enableANR() {
        d<IANRRegister> dVar = this.mIANRMonitorList;
        if (dVar == null || dVar.getList() == null) {
            return false;
        }
        for (IANRRegister iANRRegister : this.mIANRMonitorList.getList()) {
            if (iANRRegister != null && iANRRegister.checkEnable()) {
                if (AppConfig.isDebug()) {
                    Log.d("Ruka", "enableANR = true");
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public d<IANRRegister> getIANRUploadList() {
        return this.mIANRMonitorList;
    }

    public void initmIANRMonitorList() {
        b b2 = b.b();
        this.mIANRMonitorList = b2;
        b2.a(new IANRRegister_ANRRuntime_ListProvider());
    }
}
