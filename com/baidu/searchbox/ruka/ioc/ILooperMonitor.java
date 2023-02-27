package com.baidu.searchbox.ruka.ioc;

import android.content.Context;
/* loaded from: classes2.dex */
public interface ILooperMonitor {
    boolean enableMonitor();

    boolean isMonitorStarted();

    void startLooperMonitor(Context context, int i);

    void stopLooperMonitor();
}
