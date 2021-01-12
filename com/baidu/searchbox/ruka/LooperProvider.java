package com.baidu.searchbox.ruka;

import android.content.Context;
import com.baidu.searchbox.looper.impl.LooperMonitor_Factory;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
/* loaded from: classes6.dex */
public class LooperProvider {
    public static final ILooperMonitor EMPTY = new ILooperMonitor() { // from class: com.baidu.searchbox.ruka.LooperProvider.1
        @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
        public void startLooperMonitor(Context context, int i) {
        }

        @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
        public void stopLooperMonitor() {
        }

        @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
        public boolean enableMonitor() {
            return false;
        }

        @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
        public boolean isMonitorStarted() {
            return false;
        }
    };

    public static ILooperMonitor getLooperMonitor() {
        return LooperMonitor_Factory.get();
    }
}
