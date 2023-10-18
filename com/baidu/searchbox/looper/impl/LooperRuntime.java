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
import com.baidu.tieba.iqb;
import com.baidu.tieba.ve1;
import com.baidu.tieba.we1;
import com.baidu.tieba.xe1;
import com.baidu.tieba.ye1;
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
    public ye1<ILooperRegister> mLooperMonitordList;
    @Inject
    public xe1<ILooperNeedContext> mLooperNeedContext;
    public xe1<ILooperUIContext> mLooperUIContext;

    public void initmLooperMonitordList() {
        we1 b = we1.b();
        this.mLooperMonitordList = b;
        b.a(new ILooperRegister_LooperRuntime_ListProvider());
    }

    public void initmLooperNeedContext() {
        ve1 b = ve1.b();
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

    public ye1<ILooperRegister> getLooperMonitorList() {
        return this.mLooperMonitordList;
    }

    public ILooperNeedContext getLooperNeedContext() {
        return this.mLooperNeedContext.get();
    }

    public ILooperUIContext getLooperUIContext() {
        xe1<ILooperUIContext> xe1Var = this.mLooperUIContext;
        if (xe1Var == null) {
            return EMPTY_RUKA_UI_CONTEXT;
        }
        return xe1Var.get();
    }

    public void dispatchBlock(Context context, iqb iqbVar) {
        ye1<ILooperRegister> ye1Var = this.mLooperMonitordList;
        if (ye1Var != null && ye1Var.getList() != null) {
            LooperBlock looperBlock = new LooperBlock(iqbVar.r, iqbVar.q, iqbVar.n, iqbVar.o, iqbVar.w);
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
        ye1<ILooperRegister> ye1Var = this.mLooperMonitordList;
        if (ye1Var != null && ye1Var.getList() != null) {
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
