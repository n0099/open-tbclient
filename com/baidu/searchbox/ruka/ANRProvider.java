package com.baidu.searchbox.ruka;

import com.baidu.searchbox.anr.impl.ANRMonitor_Factory;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
/* loaded from: classes7.dex */
public class ANRProvider {
    public static final IANRMonitor EMPTY = new IANRMonitor() { // from class: com.baidu.searchbox.ruka.ANRProvider.1
        @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
        public boolean enableMonitor() {
            return false;
        }

        @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
        public void startANRMonitor(int i) {
        }

        @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
        public void startANRMonitor() {
        }

        @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
        public void stopANRMonitor() {
        }
    };

    public static IANRMonitor getANRMonitor() {
        return ANRMonitor_Factory.get();
    }
}
