package com.baidu.searchbox.ng.ai.apps.performance;

import com.baidu.searchbox.ng.ai.apps.performance.HybridUbcFlow;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class StartupReporter implements HybridUbcFlow.Reporter {
    private static final boolean DEBUG = false;
    private static final String TAG = "StartupReporter";

    @Override // com.baidu.searchbox.ng.ai.apps.performance.HybridUbcFlow.Reporter
    public void report(HybridUbcFlow hybridUbcFlow) {
        AiApp.get();
    }
}
