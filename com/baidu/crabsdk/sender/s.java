package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class s extends FileObserver {
    private String ali;
    private JSONObject alj;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.alj = null;
        this.mContext = context;
        this.ali = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dj;
        Thread dd;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.de("File name is: " + (this.ali + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.de("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.de("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.de("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.de("Crashed thread is main thread.");
                dd = Looper.getMainLooper().getThread();
            } else {
                dd = com.baidu.crabsdk.b.s.dd(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(dd);
            com.baidu.crabsdk.c.a.de("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(dd);
            com.baidu.crabsdk.c.a.de("Key stack is:\n" + c);
            try {
                this.alj = g.c(System.currentTimeMillis(), true);
                this.alj.put("javaLine", c);
                this.alj.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.f("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.de("Dump file is created!");
            if (this.alj == null || (dj = com.baidu.crabsdk.c.d.dj(this.alj.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.de("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dj.getBytes());
        }
    }
}
