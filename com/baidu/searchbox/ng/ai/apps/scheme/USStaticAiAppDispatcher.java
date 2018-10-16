package com.baidu.searchbox.ng.ai.apps.scheme;

import com.baidu.searchbox.ng.ai.apps.console.debugger.DebuggerLaunchAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.LaunchAction;
/* loaded from: classes2.dex */
public class USStaticAiAppDispatcher extends UnitedSchemeAiAppDispatcher {
    private static final boolean DEBUG = false;
    private static final String TAG = "USStaticAiAppDispatcher";

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher
    protected void initActionMap() {
        this.mActionMap.clear();
        regAction(new LaunchAction(this));
        regAction(new DebuggerLaunchAction(this));
    }
}
