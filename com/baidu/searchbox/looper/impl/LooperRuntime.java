package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext_LooperRuntime_Provider;
import com.baidu.searchbox.looper.ioc.ILooperRegister;
import com.baidu.searchbox.looper.ioc.ILooperRegister_LooperRuntime_ListProvider;
import com.baidu.searchbox.looper.ioc.ILooperUIContext;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import d.b.d0.a.b.b;
import d.b.d0.a.b.c;
import d.b.d0.a.b.d;
import d.f.b.a.j.a;
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
    public d<ILooperRegister> mLooperMonitordList;
    @Inject
    public c<ILooperNeedContext> mLooperNeedContext;
    public c<ILooperUIContext> mLooperUIContext;

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

    public void dispatchBlock(Context context, a aVar) {
        d<ILooperRegister> dVar = this.mLooperMonitordList;
        if (dVar == null || dVar.a() == null) {
            return;
        }
        LooperBlock looperBlock = new LooperBlock(aVar.r, aVar.q, aVar.n, aVar.o, aVar.w);
        TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
        if (lastTrackUI != null) {
            if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                looperBlock.setCurrentPage(lastTrackUI.getFragmentPage());
            } else if (!TextUtils.isEmpty(lastTrackUI.getActivityPage())) {
                looperBlock.setCurrentPage(lastTrackUI.getActivityPage());
            }
        }
        looperBlock.setTrackUIs(Track.getInstance().getAllTrackUIs());
        for (ILooperRegister iLooperRegister : this.mLooperMonitordList.a()) {
            iLooperRegister.onBlock(context, looperBlock);
        }
    }

    public boolean enableLooper() {
        d<ILooperRegister> dVar = this.mLooperMonitordList;
        if (dVar == null || dVar.a() == null) {
            return false;
        }
        for (ILooperRegister iLooperRegister : this.mLooperMonitordList.a()) {
            if (iLooperRegister != null && iLooperRegister.checkEnable()) {
                if (AppConfig.isDebug()) {
                    Log.d("Ruka", "enableLooper = true");
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public d<ILooperRegister> getLooperMonitorList() {
        return this.mLooperMonitordList;
    }

    public ILooperNeedContext getLooperNeedContext() {
        return this.mLooperNeedContext.get();
    }

    public ILooperUIContext getLooperUIContext() {
        c<ILooperUIContext> cVar = this.mLooperUIContext;
        if (cVar == null) {
            return EMPTY_RUKA_UI_CONTEXT;
        }
        return cVar.get();
    }

    public void initmLooperMonitordList() {
        b c2 = b.c();
        this.mLooperMonitordList = c2;
        c2.b(new ILooperRegister_LooperRuntime_ListProvider());
    }

    public void initmLooperNeedContext() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.mLooperNeedContext = b2;
        b2.a(new ILooperNeedContext_LooperRuntime_Provider());
    }
}
