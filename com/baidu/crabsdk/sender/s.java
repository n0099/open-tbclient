package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.OnAnrCrashListener;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class s extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f4774a;

    /* renamed from: b  reason: collision with root package name */
    public String f4775b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f4776c;

    public s(Context context, String str) {
        super(str, 8);
        this.f4776c = null;
        this.f4774a = context;
        this.f4775b = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String b2;
        Thread e2;
        if (str == null) {
            com.baidu.crabsdk.c.a.d("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.b("File name is: " + (this.f4775b + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.b("Delete .ydg file: " + i.j(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf("_") + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.b("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.b("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.b("Crashed thread is main thread.");
                e2 = Looper.getMainLooper().getThread();
            } else {
                e2 = com.baidu.crabsdk.b.s.e(substring);
            }
            String c2 = com.baidu.crabsdk.b.s.c(e2);
            com.baidu.crabsdk.c.a.b("Stacktrace is:\n " + c2);
            OnAnrCrashListener onAnrCrashListener = com.baidu.crabsdk.a.P;
            if (onAnrCrashListener != null) {
                onAnrCrashListener.onNativeCrashStarted(c2);
            }
            String d2 = com.baidu.crabsdk.b.s.d(e2);
            com.baidu.crabsdk.c.a.b("Key stack is:\n" + d2);
            try {
                JSONObject g2 = g.g(System.currentTimeMillis(), true);
                this.f4776c = g2;
                g2.put("javaLine", d2);
                this.f4776c.put("errorTrace", c2);
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e3);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.b("Dump file is created!");
            JSONObject jSONObject = this.f4776c;
            if (jSONObject == null || (b2 = com.baidu.crabsdk.c.d.b(jSONObject.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.b("Write .ldg file here!");
            i.d(this.f4774a, str + ".ldg", b2.getBytes());
        }
    }
}
