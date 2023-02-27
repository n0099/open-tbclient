package com.baidu.searchbox.launch;
/* loaded from: classes2.dex */
public abstract class IdleLaunchTask extends SmartLaunchTask {
    public IdleLaunchTask() {
        this.type = 1;
        this.isMainThreadIdleTask = true;
    }

    public IdleLaunchTask(String str) {
        super(str);
        this.type = 1;
        this.isMainThreadIdleTask = true;
    }

    public IdleLaunchTask(String str, int i) {
        super(null, str);
        this.priority = i;
        this.type = 1;
        this.isMainThreadIdleTask = true;
    }

    public IdleLaunchTask(String str, String str2) {
        super(str, str2);
        this.type = 1;
        this.isMainThreadIdleTask = true;
    }

    public IdleLaunchTask(String str, String str2, int i) {
        super(str, str2);
        this.priority = i;
        this.type = 1;
        this.isMainThreadIdleTask = true;
    }
}
