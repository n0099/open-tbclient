package com.baidu.searchbox.perfframe.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister_PerfFrameRuntime_ListProvider;
import d.a.e0.a.b.b;
import d.a.e0.a.b.d;
/* loaded from: classes2.dex */
public class PerfFrameRuntime {
    public static PerfFrameRuntime sInstance;
    @Inject
    public d<IPerfFrameRegister> mIPerfFrameMonitorList;

    public PerfFrameRuntime() {
        initmIPerfFrameMonitorList();
    }

    public static PerfFrameRuntime getInstance() {
        if (sInstance == null) {
            synchronized (PerfFrameRuntime.class) {
                if (sInstance == null) {
                    sInstance = new PerfFrameRuntime();
                }
            }
        }
        return sInstance;
    }

    public d<IPerfFrameRegister> getPerfFrameRegister() {
        return this.mIPerfFrameMonitorList;
    }

    public void initmIPerfFrameMonitorList() {
        b b2 = b.b();
        this.mIPerfFrameMonitorList = b2;
        b2.a(new IPerfFrameRegister_PerfFrameRuntime_ListProvider());
    }
}
