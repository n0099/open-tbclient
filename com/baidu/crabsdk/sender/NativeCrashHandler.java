package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import com.baidu.crabsdk.CrabSDK;
/* loaded from: classes.dex */
public class NativeCrashHandler {
    public static NativeCrashHandler bZ;
    public boolean ca = false;
    public s cb;
    public Context mContext;

    public NativeCrashHandler(Context context) {
        this.mContext = context;
        this.cb = new s(context, context.getFilesDir().getPath());
    }

    public static NativeCrashHandler ai() {
        return bZ;
    }

    private native boolean nRequiredVarParams(String str);

    private native boolean nSetLogcatLineCount(int i);

    public static NativeCrashHandler r(Context context) {
        if (bZ == null) {
            bZ = new NativeCrashHandler(context);
        }
        return bZ;
    }

    public final void aj() {
        String str;
        try {
            if (this.mContext == null) {
                str = "NativeCrashHandler openNativeCrashHandler failed context is null!";
            } else {
                System.loadLibrary("crab_native");
                this.ca = true;
                com.baidu.crabsdk.c.a.b("Native version is:" + CrabSDK.NDK_VERSION);
                if (CrabSDK.NDK_VERSION.equals("-1")) {
                    CrabSDK.NDK_VERSION = "3.2.0";
                }
                str = "NativeCrashHandler openNativeCrashHandler success!  CPU_ABI is " + Build.CPU_ABI;
            }
            com.baidu.crabsdk.c.a.b(str);
        } catch (Exception e2) {
            this.ca = false;
            CrabSDK.NDK_VERSION = "-1";
            com.baidu.crabsdk.c.a.a("loadSysLib Error!", e2);
        } catch (UnsatisfiedLinkError e3) {
            this.ca = false;
            CrabSDK.NDK_VERSION = "-1";
            com.baidu.crabsdk.c.a.d("loadSysLib Error! " + e3.getMessage());
        }
        if (this.ca) {
            try {
                this.cb.startWatching();
                nRequiredVarParams(com.baidu.crabsdk.c.d.b(g.j(this.mContext).toString()));
            } catch (Exception e4) {
                com.baidu.crabsdk.c.a.a("Init gather java info error!", e4);
            }
        }
    }

    public final void b(int i) {
        if (this.ca) {
            try {
                nSetLogcatLineCount(i);
            } catch (UnsatisfiedLinkError e2) {
                com.baidu.crabsdk.c.a.d("nSetLogcatLineCount Error! " + e2.getMessage());
            }
        }
    }
}
