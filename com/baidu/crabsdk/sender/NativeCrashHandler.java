package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.crabsdk.CrabSDK;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import java.io.File;
/* loaded from: classes2.dex */
public class NativeCrashHandler {
    private static NativeCrashHandler bM = null;
    private static Context mContext;
    private boolean bN = false;

    private NativeCrashHandler(Context context) {
        mContext = context;
    }

    public static NativeCrashHandler ae() {
        return bM;
    }

    private native boolean nClearVarParams();

    private native boolean nRequiredVarParams(String str);

    private native boolean nSetLogcatLineCount(int i);

    public static NativeCrashHandler s(Context context) {
        if (bM == null) {
            bM = new NativeCrashHandler(context);
        }
        return bM;
    }

    public final void af() {
        try {
            com.baidu.crabsdk.c.a.cc("加载系统库，调用native接口");
            if (mContext == null) {
                com.baidu.crabsdk.c.a.cb("NativeCrashHandler openNativeCrashHandler failed context is null!");
            } else {
                String str = mContext.getApplicationInfo().nativeLibraryDir + "/" + System.mapLibraryName("crab_native");
                if (TextUtils.isEmpty(str) || new File(str).exists()) {
                    System.loadLibrary("crab_native");
                    this.bN = true;
                    CrabSDK.NDK_VERSION = "3.1.0";
                    com.baidu.crabsdk.c.a.cb("NativeCrashHandler openNativeCrashHandler success!  CPU_ABI is " + Build.CPU_ABI);
                } else {
                    com.baidu.crabsdk.c.a.cb("NativeCrashHandler openNativeCrashHandler failed so file is not exists! dir is " + str + " " + Build.CPU_ABI);
                }
            }
        } catch (Exception e) {
            this.bN = false;
            CrabSDK.NDK_VERSION = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
            com.baidu.crabsdk.c.a.b("loadSysLib Error!!", e);
        }
    }

    public final void ag() {
        if (this.bN) {
            nClearVarParams();
        } else {
            com.baidu.crabsdk.c.a.ce("call after failed! native lib init failed");
        }
    }

    public final void b(int i) {
        if (this.bN) {
            nSetLogcatLineCount(i);
        }
    }

    public final void p(String str) {
        if (this.bN) {
            nRequiredVarParams(str);
        } else {
            com.baidu.crabsdk.c.a.ce("call before failed! native lib init failed");
        }
    }
}
