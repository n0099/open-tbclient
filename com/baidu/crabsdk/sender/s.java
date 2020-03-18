package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class s extends FileObserver {
    private String SW;
    private JSONObject SX;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.SX = null;
        this.mContext = context;
        this.SW = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String co;
        Thread ci;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.cj("File name is: " + (this.SW + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.cj("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.cj("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.cj("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.cj("Crashed thread is main thread.");
                ci = Looper.getMainLooper().getThread();
            } else {
                ci = com.baidu.crabsdk.b.s.ci(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(ci);
            com.baidu.crabsdk.c.a.cj("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(ci);
            com.baidu.crabsdk.c.a.cj("Key stack is:\n" + c);
            try {
                this.SX = g.c(System.currentTimeMillis(), true);
                this.SX.put("javaLine", c);
                this.SX.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.f("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.cj("Dump file is created!");
            if (this.SX == null || (co = com.baidu.crabsdk.c.d.co(this.SX.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.cj("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", co.getBytes());
        }
    }
}
