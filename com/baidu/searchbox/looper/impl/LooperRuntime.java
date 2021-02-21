package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.a.a.a;
import com.baidu.pyramid.a.a.b;
import com.baidu.pyramid.a.a.c;
import com.baidu.pyramid.a.a.d;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext_LooperRuntime_Provider;
import com.baidu.searchbox.looper.ioc.ILooperRegister;
import com.baidu.searchbox.looper.ioc.ILooperRegister_LooperRuntime_ListProvider;
import com.baidu.searchbox.looper.ioc.ILooperUIContext;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
/* loaded from: classes7.dex */
public class LooperRuntime {
    private static final ILooperUIContext EMPTY_RUKA_UI_CONTEXT = new ILooperUIContext() { // from class: com.baidu.searchbox.looper.impl.LooperRuntime.1
        @Override // com.baidu.searchbox.looper.ioc.ILooperUIContext
        public boolean displayNotification() {
            return false;
        }
    };
    private static LooperRuntime sInstance;
    private d<ILooperRegister> mLooperMonitordList;
    private c<ILooperNeedContext> mLooperNeedContext;
    private c<ILooperUIContext> mLooperUIContext;

    public void initmLooperMonitordList() {
        this.mLooperMonitordList = b.adY();
        this.mLooperMonitordList.b(new ILooperRegister_LooperRuntime_ListProvider());
    }

    public void initmLooperNeedContext() {
        this.mLooperNeedContext = a.adX();
        this.mLooperNeedContext.a(new ILooperNeedContext_LooperRuntime_Provider());
    }

    public LooperRuntime() {
        initmLooperNeedContext();
        initmLooperMonitordList();
    }

    public static LooperRuntime getInstance() {
        if (sInstance == null) {
            synchronized (LooperRuntime.class) {
                if (sInstance == null) {
                    sInstance = new LooperRuntime();
                }
            }
        }
        return sInstance;
    }

    public ILooperUIContext getLooperUIContext() {
        return this.mLooperUIContext == null ? EMPTY_RUKA_UI_CONTEXT : this.mLooperUIContext.get();
    }

    public ILooperNeedContext getLooperNeedContext() {
        return this.mLooperNeedContext.get();
    }

    public d<ILooperRegister> getLooperMonitorList() {
        return this.mLooperMonitordList;
    }

    public boolean enableLooper() {
        if (this.mLooperMonitordList != null && this.mLooperMonitordList.getList() != null) {
            for (ILooperRegister iLooperRegister : this.mLooperMonitordList.getList()) {
                if (iLooperRegister != null && iLooperRegister.checkEnable()) {
                    if (AppConfig.isDebug()) {
                        Log.d("Ruka", "enableLooper = true");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void dispatchBlock(Context context, com.github.a.a.a.a aVar) {
        if (this.mLooperMonitordList != null && this.mLooperMonitordList.getList() != null) {
            LooperBlock looperBlock = new LooperBlock(aVar.duration, aVar.pRF, aVar.pRC, aVar.pRD, aVar.pRK);
            TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
            if (lastTrackUI != null) {
                if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                    looperBlock.setCurrentPage(lastTrackUI.getFragmentPage());
                } else if (!TextUtils.isEmpty(lastTrackUI.getActivityPage())) {
                    looperBlock.setCurrentPage(lastTrackUI.getActivityPage());
                }
            }
            looperBlock.setTrackUIs(Track.getInstance().getAllTrackUIs());
            for (ILooperRegister iLooperRegister : this.mLooperMonitordList.getList()) {
                iLooperRegister.onBlock(context, looperBlock);
            }
        }
    }
}
