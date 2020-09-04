package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class s extends FileObserver {
    private String ape;
    private JSONObject apf;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.apf = null;
        this.mContext = context;
        this.ape = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dy;
        Thread ds;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.dt("File name is: " + (this.ape + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.dt("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.dt("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.dt("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.dt("Crashed thread is main thread.");
                ds = Looper.getMainLooper().getThread();
            } else {
                ds = com.baidu.crabsdk.b.s.ds(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(ds);
            com.baidu.crabsdk.c.a.dt("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(ds);
            com.baidu.crabsdk.c.a.dt("Key stack is:\n" + c);
            try {
                this.apf = g.a(System.currentTimeMillis(), true);
                this.apf.put("javaLine", c);
                this.apf.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.dt("Dump file is created!");
            if (this.apf == null || (dy = com.baidu.crabsdk.c.d.dy(this.apf.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.dt("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dy.getBytes());
        }
    }
}
