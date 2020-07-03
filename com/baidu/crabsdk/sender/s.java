package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class s extends FileObserver {
    private String aoj;
    private JSONObject aok;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.aok = null;
        this.mContext = context;
        this.aoj = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dn;
        Thread dh;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.di("File name is: " + (this.aoj + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.di("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.di("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.di("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.di("Crashed thread is main thread.");
                dh = Looper.getMainLooper().getThread();
            } else {
                dh = com.baidu.crabsdk.b.s.dh(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(dh);
            com.baidu.crabsdk.c.a.di("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(dh);
            com.baidu.crabsdk.c.a.di("Key stack is:\n" + c);
            try {
                this.aok = g.c(System.currentTimeMillis(), true);
                this.aok.put("javaLine", c);
                this.aok.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.di("Dump file is created!");
            if (this.aok == null || (dn = com.baidu.crabsdk.c.d.dn(this.aok.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.di("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dn.getBytes());
        }
    }
}
