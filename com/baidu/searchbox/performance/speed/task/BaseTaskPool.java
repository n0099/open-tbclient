package com.baidu.searchbox.performance.speed.task;

import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseTaskPool {
    public abstract List<LaunchTask> onAppCreateFirst(int i);

    public abstract List<LaunchTask> onAppCreateSecond(int i);

    public abstract List<LaunchTask> onPrivacyPolicyGranted(int i);

    public abstract List<LaunchTask> viewOnActivity();

    public abstract List<LaunchTask> viewOnAppCreateView();

    public List<LaunchTask> getTaskList(int i, int i2) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return viewOnActivity();
                    }
                    return viewOnAppCreateView();
                }
                return onPrivacyPolicyGranted(i2);
            }
            return onAppCreateSecond(i2);
        }
        return onAppCreateFirst(i2);
    }
}
