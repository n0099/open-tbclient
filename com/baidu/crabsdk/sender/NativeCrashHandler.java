package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import java.io.File;
/* loaded from: classes6.dex */
public class NativeCrashHandler {
    private static NativeCrashHandler bL = null;
    private static Context mContext;
    private boolean bM = false;

    private NativeCrashHandler(Context context) {
        mContext = context;
    }

    public static NativeCrashHandler ae() {
        return bL;
    }

    private native boolean nClearVarParams();

    private native boolean nRequiredVarParams(String str);

    private native boolean nSetLogcatLineCount(int i);

    public static NativeCrashHandler s(Context context) {
        if (bL == null) {
            bL = new NativeCrashHandler(context);
        }
        return bL;
    }

    public final void af() {
        try {
            com.baidu.crabsdk.c.a.cH("加载系统库，调用native接口");
            if (mContext == null) {
                com.baidu.crabsdk.c.a.cG("NativeCrashHandler openNativeCrashHandler failed context is null!");
            } else {
                String str = mContext.getApplicationInfo().nativeLibraryDir + "/" + System.mapLibraryName("crab_native");
                if (TextUtils.isEmpty(str) || new File(str).exists()) {
                    System.loadLibrary("crab_native");
                    this.bM = true;
                    CrabSDK.NDK_VERSION = "3.1.2";
                    com.baidu.crabsdk.c.a.cG("NativeCrashHandler openNativeCrashHandler success!  CPU_ABI is " + Build.CPU_ABI);
                } else {
                    com.baidu.crabsdk.c.a.cG("NativeCrashHandler openNativeCrashHandler failed so file is not exists! dir is " + str + " " + Build.CPU_ABI);
                }
            }
        } catch (Exception e) {
            this.bM = false;
            CrabSDK.NDK_VERSION = AiAppsAudioPlayer.ERROR_UNKNOWN;
            com.baidu.crabsdk.c.a.f("loadSysLib Error!!", e);
        }
    }

    public final void ag() {
        if (this.bM) {
            nClearVarParams();
        } else {
            com.baidu.crabsdk.c.a.cJ("call after failed! native lib init failed");
        }
    }

    public final void b(int i) {
        if (this.bM) {
            nSetLogcatLineCount(i);
        }
    }

    public final void q(String str) {
        if (this.bM) {
            nRequiredVarParams(str);
        } else {
            com.baidu.crabsdk.c.a.cJ("call before failed! native lib init failed");
        }
    }
}
