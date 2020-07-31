package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class s extends FileObserver {
    private String aof;
    private JSONObject aog;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.aog = null;
        this.mContext = context;
        this.aof = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dm;
        Thread dg;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.dh("File name is: " + (this.aof + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.dh("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.dh("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.dh("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.dh("Crashed thread is main thread.");
                dg = Looper.getMainLooper().getThread();
            } else {
                dg = com.baidu.crabsdk.b.s.dg(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(dg);
            com.baidu.crabsdk.c.a.dh("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(dg);
            com.baidu.crabsdk.c.a.dh("Key stack is:\n" + c);
            try {
                this.aog = g.c(System.currentTimeMillis(), true);
                this.aog.put("javaLine", c);
                this.aog.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.dh("Dump file is created!");
            if (this.aog == null || (dm = com.baidu.crabsdk.c.d.dm(this.aog.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.dh("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dm.getBytes());
        }
    }
}
