package com.baidu.helios.bridge.multiprocess;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.helios.bridge.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends com.baidu.helios.bridge.a {
    private com.baidu.helios.bridge.a aqF;
    private boolean f;

    public a(boolean z) {
        this.f = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a() {
        BufferedReader bufferedReader;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        BufferedReader bufferedReader2;
        String readLine;
        BufferedReader bufferedReader3 = null;
        try {
            bufferedReader2 = new BufferedReader(new FileReader(new File("/proc/self/cmdline")));
        } catch (IOException e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            readLine = bufferedReader2.readLine();
        } catch (IOException e2) {
            bufferedReader = bufferedReader2;
            com.baidu.helios.common.b.a.c.b(bufferedReader);
            runningAppProcesses = ((ActivityManager) this.aqh.applicationContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader2;
            com.baidu.helios.common.b.a.c.b(bufferedReader3);
            throw th;
        }
        if (!TextUtils.isEmpty(readLine)) {
            com.baidu.helios.common.b.a.c.b(bufferedReader2);
            return readLine;
        }
        com.baidu.helios.common.b.a.c.b(bufferedReader2);
        runningAppProcesses = ((ActivityManager) this.aqh.applicationContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    private boolean b() {
        String a = a();
        return a != null && a.contains(":helios");
    }

    private boolean c() {
        String a = a();
        if (a == null) {
            return true;
        }
        Context context = this.aqh.applicationContext;
        String str = context.getApplicationInfo().processName;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
        }
        return a.startsWith(str) && (a.length() == str.length() || a.charAt(str.length()) != ':');
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        this.aqF.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        com.baidu.helios.bridge.a cVar;
        if (this.f ? c() : b()) {
            cVar = new com.baidu.helios.bridge.a.a();
        } else {
            cVar = new c(this.f ? ".helios.ipc.default" : ".helios.ipc.isolate");
        }
        this.aqF = cVar;
        this.aqF.a(this.aqh);
        this.aqF.a(bVar);
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        return this.aqF.d(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dW(String str) {
        return this.aqF.dW(str);
    }
}
