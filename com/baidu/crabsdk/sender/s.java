package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class s extends FileObserver {
    private String amR;
    private JSONObject amS;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.amS = null;
        this.mContext = context;
        this.amR = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dl;
        Thread df;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.dg("File name is: " + (this.amR + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.dg("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.dg("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.dg("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.dg("Crashed thread is main thread.");
                df = Looper.getMainLooper().getThread();
            } else {
                df = com.baidu.crabsdk.b.s.df(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(df);
            com.baidu.crabsdk.c.a.dg("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(df);
            com.baidu.crabsdk.c.a.dg("Key stack is:\n" + c);
            try {
                this.amS = g.c(System.currentTimeMillis(), true);
                this.amS.put("javaLine", c);
                this.amS.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.dg("Dump file is created!");
            if (this.amS == null || (dl = com.baidu.crabsdk.c.d.dl(this.amS.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.dg("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dl.getBytes());
        }
    }
}
