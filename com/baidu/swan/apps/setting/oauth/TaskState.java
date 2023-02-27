package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes3.dex */
public enum TaskState {
    INIT(0),
    CALLING(1),
    FINISHED(2);
    
    public final int mCode;

    public boolean isCallbackAvailable() {
        if (this.mCode < FINISHED.mCode) {
            return true;
        }
        return false;
    }

    TaskState(int i) {
        this.mCode = i;
    }
}
