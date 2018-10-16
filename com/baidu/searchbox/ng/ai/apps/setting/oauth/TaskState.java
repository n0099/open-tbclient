package com.baidu.searchbox.ng.ai.apps.setting.oauth;
/* loaded from: classes2.dex */
public enum TaskState {
    INIT(0),
    CALLING(1),
    FINISHED(2);
    
    public final int mCode;

    TaskState(int i) {
        this.mCode = i;
    }

    public boolean isCallbackAvailable() {
        return this.mCode < FINISHED.mCode;
    }
}
