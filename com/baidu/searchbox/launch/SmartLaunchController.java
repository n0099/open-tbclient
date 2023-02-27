package com.baidu.searchbox.launch;
/* loaded from: classes2.dex */
public class SmartLaunchController {
    public static boolean isSmartLaunchEnable;

    public static boolean isSmartLaunchEnabled() {
        return false;
    }

    public static boolean isSmartLaunchScheduleEnd() {
        return SmartLaunchScheduler.getInstance().isScheduleEnd();
    }

    public static boolean isSmartLaunchScheduleInterrupted() {
        return SmartLaunchScheduler.getInstance().isScheduleInterrupted();
    }

    public static void scheduleIdleTask() {
        SmartLaunchScheduler.getInstance().scheduleIdleTask();
    }

    public static void register(SmartLaunchTask smartLaunchTask) {
        SmartLaunchScheduler.getInstance().register(smartLaunchTask);
    }
}
