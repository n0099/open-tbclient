package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class s extends FileObserver {
    private String aru;
    private JSONObject arv;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.arv = null;
        this.mContext = context;
        this.aru = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dJ;
        Thread dD;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.dE("File name is: " + (this.aru + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.dE("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.dE("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.dE("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.dE("Crashed thread is main thread.");
                dD = Looper.getMainLooper().getThread();
            } else {
                dD = com.baidu.crabsdk.b.s.dD(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(dD);
            com.baidu.crabsdk.c.a.dE("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(dD);
            com.baidu.crabsdk.c.a.dE("Key stack is:\n" + c);
            try {
                this.arv = g.a(System.currentTimeMillis(), true);
                this.arv.put("javaLine", c);
                this.arv.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.dE("Dump file is created!");
            if (this.arv == null || (dJ = com.baidu.crabsdk.c.d.dJ(this.arv.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.dE("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dJ.getBytes());
        }
    }
}
