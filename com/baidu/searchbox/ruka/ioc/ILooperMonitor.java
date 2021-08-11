package com.baidu.searchbox.ruka.ioc;

import android.content.Context;
/* loaded from: classes5.dex */
public interface ILooperMonitor {
    boolean enableMonitor();

    boolean isMonitorStarted();

    void startLooperMonitor(Context context, int i2);

    void stopLooperMonitor();
}
