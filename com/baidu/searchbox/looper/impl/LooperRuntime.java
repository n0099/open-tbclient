package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext_LooperRuntime_Provider;
import com.baidu.searchbox.looper.ioc.ILooperRegister;
import com.baidu.searchbox.looper.ioc.ILooperRegister_LooperRuntime_ListProvider;
import com.baidu.searchbox.looper.ioc.ILooperUIContext;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tieba.cdb;
import com.baidu.tieba.hl1;
import com.baidu.tieba.il1;
import com.baidu.tieba.jl1;
import com.baidu.tieba.kl1;
/* loaded from: classes4.dex */
public class LooperRuntime {
    public static final ILooperUIContext EMPTY_RUKA_UI_CONTEXT = new ILooperUIContext() { // from class: com.baidu.searchbox.looper.impl.LooperRuntime.1
        @Override // com.baidu.searchbox.looper.ioc.ILooperUIContext
        public boolean displayNotification() {
            return false;
        }
    };
    public static LooperRuntime sInstance;
    @Inject
    public kl1<ILooperRegister> mLooperMonitordList;
    @Inject
    public jl1<ILooperNeedContext> mLooperNeedContext;
    public jl1<ILooperUIContext> mLooperUIContext;

    public void initmLooperMonitordList() {
        il1 b = il1.b();
        this.mLooperMonitordList = b;
        b.a(new ILooperRegister_LooperRuntime_ListProvider());
    }

    public void initmLooperNeedContext() {
        hl1 b = hl1.b();
        this.mLooperNeedContext = b;
        b.a(new ILooperNeedContext_LooperRuntime_Provider());
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

    public kl1<ILooperRegister> getLooperMonitorList() {
        return this.mLooperMonitordList;
    }

    public ILooperNeedContext getLooperNeedContext() {
        return this.mLooperNeedContext.get();
    }

    public ILooperUIContext getLooperUIContext() {
        jl1<ILooperUIContext> jl1Var = this.mLooperUIContext;
        if (jl1Var == null) {
            return EMPTY_RUKA_UI_CONTEXT;
        }
        return jl1Var.get();
    }

    public void dispatchBlock(Context context, cdb cdbVar) {
        kl1<ILooperRegister> kl1Var = this.mLooperMonitordList;
        if (kl1Var != null && kl1Var.getList() != null) {
            LooperBlock looperBlock = new LooperBlock(cdbVar.r, cdbVar.q, cdbVar.n, cdbVar.o, cdbVar.w);
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

    public boolean enableLooper() {
        kl1<ILooperRegister> kl1Var = this.mLooperMonitordList;
        if (kl1Var != null && kl1Var.getList() != null) {
            for (ILooperRegister iLooperRegister : this.mLooperMonitordList.getList()) {
                if (iLooperRegister != null && iLooperRegister.checkEnable()) {
                    if (AppConfig.isDebug()) {
                        Log.d(BlockMonitor.TAG, "enableLooper = true");
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
