package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class s extends FileObserver {
    private String arQ;
    private JSONObject arR;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.arR = null;
        this.mContext = context;
        this.arQ = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dC;
        Thread dw;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.dx("File name is: " + (this.arQ + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.dx("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.dx("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.dx("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.dx("Crashed thread is main thread.");
                dw = Looper.getMainLooper().getThread();
            } else {
                dw = com.baidu.crabsdk.b.s.dw(substring);
            }
            String b2 = com.baidu.crabsdk.b.s.b(dw);
            com.baidu.crabsdk.c.a.dx("Stacktrace is:\n " + b2);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b2);
            }
            String c = com.baidu.crabsdk.b.s.c(dw);
            com.baidu.crabsdk.c.a.dx("Key stack is:\n" + c);
            try {
                this.arR = g.b(System.currentTimeMillis(), true);
                this.arR.put("javaLine", c);
                this.arR.put("errorTrace", b2);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.dx("Dump file is created!");
            if (this.arR == null || (dC = com.baidu.crabsdk.c.d.dC(this.arR.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.dx("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dC.getBytes());
        }
    }
}
