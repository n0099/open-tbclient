package com.baidu.searchbox.anr.impl;

import android.util.Log;
import com.baidu.pyramid.a.a.b;
import com.baidu.pyramid.a.a.d;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ioc.IANRRegister_ANRRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes6.dex */
public class ANRRuntime {
    private static ANRRuntime sInstance;
    private d<IANRRegister> mIANRMonitorList;

    public void initmIANRMonitorList() {
        this.mIANRMonitorList = b.adH();
        this.mIANRMonitorList.b(new IANRRegister_ANRRuntime_ListProvider());
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

    public boolean enableANR() {
        if (this.mIANRMonitorList != null && this.mIANRMonitorList.getList() != null) {
            for (IANRRegister iANRRegister : this.mIANRMonitorList.getList()) {
                if (iANRRegister != null && iANRRegister.checkEnable()) {
                    if (AppConfig.isDebug()) {
                        Log.d("Ruka", "enableANR = true");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public d<IANRRegister> getIANRUploadList() {
        return this.mIANRMonitorList;
    }
}
