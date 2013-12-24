package com.baidu.adp.lib.debug.a;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a implements Runnable {
    private ActivityManager a;
    private String b;

    public l(Context context) {
        this.a = null;
        this.b = null;
        this.b = context.getPackageName();
        this.a = (ActivityManager) context.getSystemService("activity");
    }

    public String d() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.a.getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            int i2 = runningAppProcessInfo.pid;
            String str = runningAppProcessInfo.processName;
            int i3 = this.a.getProcessMemoryInfo(new int[]{i2})[0].dalvikPrivateDirty;
            if (this.b.contains(str)) {
                Log.i("processInfo", "" + runningAppProcessInfo.importance);
                return i3 + "kb";
            }
        }
        return "null";
    }

    @Override // java.lang.Runnable
    public void run() {
        super.b();
        while (true) {
            try {
                com.baidu.adp.lib.debug.b.a(d());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!a()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
