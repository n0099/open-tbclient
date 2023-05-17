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
import com.baidu.tieba.dya;
import com.baidu.tieba.uj1;
import com.baidu.tieba.vj1;
import com.baidu.tieba.wj1;
import com.baidu.tieba.xj1;
/* loaded from: classes3.dex */
public class LooperRuntime {
    public static final ILooperUIContext EMPTY_RUKA_UI_CONTEXT = new ILooperUIContext() { // from class: com.baidu.searchbox.looper.impl.LooperRuntime.1
        @Override // com.baidu.searchbox.looper.ioc.ILooperUIContext
        public boolean displayNotification() {
            return false;
        }
    };
    public static LooperRuntime sInstance;
    @Inject
    public xj1<ILooperRegister> mLooperMonitordList;
    @Inject
    public wj1<ILooperNeedContext> mLooperNeedContext;
    public wj1<ILooperUIContext> mLooperUIContext;

    public void initmLooperMonitordList() {
        vj1 b = vj1.b();
        this.mLooperMonitordList = b;
        b.a(new ILooperRegister_LooperRuntime_ListProvider());
    }

    public void initmLooperNeedContext() {
        uj1 b = uj1.b();
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

    public xj1<ILooperRegister> getLooperMonitorList() {
        return this.mLooperMonitordList;
    }

    public ILooperNeedContext getLooperNeedContext() {
        return this.mLooperNeedContext.get();
    }

    public ILooperUIContext getLooperUIContext() {
        wj1<ILooperUIContext> wj1Var = this.mLooperUIContext;
        if (wj1Var == null) {
            return EMPTY_RUKA_UI_CONTEXT;
        }
        return wj1Var.get();
    }

    public void dispatchBlock(Context context, dya dyaVar) {
        xj1<ILooperRegister> xj1Var = this.mLooperMonitordList;
        if (xj1Var != null && xj1Var.getList() != null) {
            LooperBlock looperBlock = new LooperBlock(dyaVar.r, dyaVar.q, dyaVar.n, dyaVar.o, dyaVar.w);
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
        xj1<ILooperRegister> xj1Var = this.mLooperMonitordList;
        if (xj1Var != null && xj1Var.getList() != null) {
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
