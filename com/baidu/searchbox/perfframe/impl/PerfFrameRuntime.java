package com.baidu.searchbox.perfframe.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister_PerfFrameRuntime_ListProvider;
import com.baidu.tieba.rf1;
import com.baidu.tieba.tf1;
/* loaded from: classes4.dex */
public class PerfFrameRuntime {
    public static PerfFrameRuntime sInstance;
    @Inject
    public tf1<IPerfFrameRegister> mIPerfFrameMonitorList;

    public void initmIPerfFrameMonitorList() {
        rf1 b = rf1.b();
        this.mIPerfFrameMonitorList = b;
        b.a(new IPerfFrameRegister_PerfFrameRuntime_ListProvider());
    }

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

    public tf1<IPerfFrameRegister> getPerfFrameRegister() {
        return this.mIPerfFrameMonitorList;
    }
}
