package com.baidu.adp.lib.debug.a;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
public class m extends a implements Runnable {
    private ActivityManager gE;
    private String mPackageName;

    public m(Context context) {
        this.gE = null;
        this.mPackageName = null;
        this.mPackageName = context.getPackageName();
        this.gE = (ActivityManager) context.getSystemService("activity");
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0039: IGET  (r0v5 int A[REMOVE]) = (r0v4 android.app.ActivityManager$RunningAppProcessInfo) android.app.ActivityManager.RunningAppProcessInfo.importance int)] */
    public String cM() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.gE.getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            int i2 = runningAppProcessInfo.pid;
            String str = runningAppProcessInfo.processName;
            int i3 = this.gE.getProcessMemoryInfo(new int[]{i2})[0].dalvikPrivateDirty;
            if (this.mPackageName.contains(str)) {
                Log.i("processInfo", new StringBuilder().append(runningAppProcessInfo.importance).toString());
                return String.valueOf(i3) + "kb";
            }
        }
        return "null";
    }

    @Override // java.lang.Runnable
    public void run() {
        super.start();
        while (true) {
            try {
                com.baidu.adp.lib.debug.d.L(cM());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!cJ()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
