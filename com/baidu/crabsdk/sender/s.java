package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class s extends FileObserver {
    private String ard;
    private JSONObject are;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.are = null;
        this.mContext = context;
        this.ard = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dx;
        Thread dr;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.ds("File name is: " + (this.ard + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.ds("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.ds("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.ds("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.ds("Crashed thread is main thread.");
                dr = Looper.getMainLooper().getThread();
            } else {
                dr = com.baidu.crabsdk.b.s.dr(substring);
            }
            String b2 = com.baidu.crabsdk.b.s.b(dr);
            com.baidu.crabsdk.c.a.ds("Stacktrace is:\n " + b2);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b2);
            }
            String c = com.baidu.crabsdk.b.s.c(dr);
            com.baidu.crabsdk.c.a.ds("Key stack is:\n" + c);
            try {
                this.are = g.c(System.currentTimeMillis(), true);
                this.are.put("javaLine", c);
                this.are.put("errorTrace", b2);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.ds("Dump file is created!");
            if (this.are == null || (dx = com.baidu.crabsdk.c.d.dx(this.are.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.ds("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dx.getBytes());
        }
    }
}
