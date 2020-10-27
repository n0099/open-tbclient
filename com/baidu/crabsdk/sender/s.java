package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class s extends FileObserver {
    private String aqs;
    private JSONObject aqt;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.aqt = null;
        this.mContext = context;
        this.aqs = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dF;
        Thread dz;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.dA("File name is: " + (this.aqs + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.dA("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.dA("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.dA("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.dA("Crashed thread is main thread.");
                dz = Looper.getMainLooper().getThread();
            } else {
                dz = com.baidu.crabsdk.b.s.dz(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(dz);
            com.baidu.crabsdk.c.a.dA("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(dz);
            com.baidu.crabsdk.c.a.dA("Key stack is:\n" + c);
            try {
                this.aqt = g.a(System.currentTimeMillis(), true);
                this.aqt.put("javaLine", c);
                this.aqt.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.dA("Dump file is created!");
            if (this.aqt == null || (dF = com.baidu.crabsdk.c.d.dF(this.aqt.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.dA("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dF.getBytes());
        }
    }
}
