package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class s extends FileObserver {
    private String aqy;
    private JSONObject aqz;
    private Context mContext;

    public s(Context context, String str) {
        super(str, 8);
        this.aqz = null;
        this.mContext = context;
        this.aqy = str;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2;
        String dH;
        Thread dB;
        if (str == null) {
            com.baidu.crabsdk.c.a.w("file path is null!");
            return;
        }
        com.baidu.crabsdk.c.a.dC("File name is: " + (this.aqy + "/" + str));
        if (str.endsWith(".ydg")) {
            com.baidu.crabsdk.c.a.dC("Delete .ydg file: " + i.deleteFile(str2));
            str = str.substring(4);
            String substring = str.substring(str.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str.lastIndexOf("."));
            com.baidu.crabsdk.c.a.dC("ThreadName is:" + substring);
            com.baidu.crabsdk.c.a.dC("ProcName is:" + CrabSDK.CURRENT_PNAME);
            if (CrabSDK.CURRENT_PNAME.endsWith(substring)) {
                com.baidu.crabsdk.c.a.dC("Crashed thread is main thread.");
                dB = Looper.getMainLooper().getThread();
            } else {
                dB = com.baidu.crabsdk.b.s.dB(substring);
            }
            String b = com.baidu.crabsdk.b.s.b(dB);
            com.baidu.crabsdk.c.a.dC("Stacktrace is:\n " + b);
            if (com.baidu.crabsdk.a.P != null) {
                com.baidu.crabsdk.a.P.onNativeCrashStarted(b);
            }
            String c = com.baidu.crabsdk.b.s.c(dB);
            com.baidu.crabsdk.c.a.dC("Key stack is:\n" + c);
            try {
                this.aqz = g.a(System.currentTimeMillis(), true);
                this.aqz.put("javaLine", c);
                this.aqz.put("errorTrace", b);
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.a("Wrap java stack info error!", e);
            }
        }
        if (str.endsWith(".dmp")) {
            com.baidu.crabsdk.c.a.dC("Dump file is created!");
            if (this.aqz == null || (dH = com.baidu.crabsdk.c.d.dH(this.aqz.toString())) == null) {
                return;
            }
            com.baidu.crabsdk.c.a.dC("Write .ldg file here!");
            i.a(this.mContext, str + ".ldg", dH.getBytes());
        }
    }
}
