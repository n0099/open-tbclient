package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import com.baidu.crabsdk.CrabSDK;
/* loaded from: classes8.dex */
public class NativeCrashHandler {
    private static NativeCrashHandler bZ = null;
    private boolean ca = false;
    private s cb;
    private Context mContext;

    private NativeCrashHandler(Context context) {
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
        try {
            if (this.mContext == null) {
                com.baidu.crabsdk.c.a.de("NativeCrashHandler openNativeCrashHandler failed context is null!");
            } else {
                System.loadLibrary("crab_native");
                this.ca = true;
                com.baidu.crabsdk.c.a.de("Native version is:" + CrabSDK.NDK_VERSION);
                if (CrabSDK.NDK_VERSION.equals("-1")) {
                    CrabSDK.NDK_VERSION = "3.2.0";
                }
                com.baidu.crabsdk.c.a.de("NativeCrashHandler openNativeCrashHandler success!  CPU_ABI is " + Build.CPU_ABI);
            }
        } catch (Exception e) {
            this.ca = false;
            CrabSDK.NDK_VERSION = "-1";
            com.baidu.crabsdk.c.a.a("loadSysLib Error!", e);
        } catch (UnsatisfiedLinkError e2) {
            this.ca = false;
            CrabSDK.NDK_VERSION = "-1";
            com.baidu.crabsdk.c.a.w("loadSysLib Error! " + e2.getMessage());
        }
        if (this.ca) {
            try {
                this.cb.startWatching();
                nRequiredVarParams(com.baidu.crabsdk.c.d.dj(g.h(this.mContext).toString()));
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("Init gather java info error!", e3);
            }
        }
    }

    public final void b(int i) {
        if (this.ca) {
            try {
                nSetLogcatLineCount(i);
            } catch (UnsatisfiedLinkError e) {
                com.baidu.crabsdk.c.a.w("nSetLogcatLineCount Error! " + e.getMessage());
            }
        }
    }
}
