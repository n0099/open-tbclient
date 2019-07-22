package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.vivo.push.PushClientConstants;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NativeCrashHandler {
    private static NativeCrashHandler bQ = null;
    private static Context mContext;
    private boolean bR = false;

    private NativeCrashHandler(Context context) {
        mContext = context;
    }

    public static NativeCrashHandler ad() {
        return bQ;
    }

    private native boolean nRequiredVarParams(String str);

    private native boolean nSetLogcatLineCount(int i);

    public static NativeCrashHandler s(Context context) {
        if (bQ == null) {
            bQ = new NativeCrashHandler(context);
        }
        return bQ;
    }

    public final void ae() {
        try {
            com.baidu.crabsdk.c.a.ci("Load native so.");
            if (mContext == null) {
                com.baidu.crabsdk.c.a.ch("NativeCrashHandler openNativeCrashHandler failed context is null!");
            } else {
                String str = mContext.getApplicationInfo().nativeLibraryDir + "/" + System.mapLibraryName("crab_native");
                if (TextUtils.isEmpty(str) || new File(str).exists()) {
                    System.loadLibrary("crab_native");
                    this.bR = true;
                    CrabSDK.NDK_VERSION = "3.1.2";
                    com.baidu.crabsdk.c.a.ch("NativeCrashHandler openNativeCrashHandler success!  CPU_ABI is " + Build.CPU_ABI);
                } else {
                    com.baidu.crabsdk.c.a.ch("NativeCrashHandler openNativeCrashHandler failed so file is not exists! dir is " + str + " " + Build.CPU_ABI);
                }
            }
        } catch (Exception e) {
            this.bR = false;
            CrabSDK.NDK_VERSION = LivenessStat.TYPE_STRING_DEFAULT;
            com.baidu.crabsdk.c.a.a("loadSysLib Error!", e);
        } catch (UnsatisfiedLinkError e2) {
            this.bR = false;
            CrabSDK.NDK_VERSION = LivenessStat.TYPE_STRING_DEFAULT;
            com.baidu.crabsdk.c.a.w("UnsatisfiedLinkError! " + e2.getMessage());
        }
        if (this.bR) {
            try {
                Context context = mContext;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appVC", com.baidu.crabsdk.b.o.I());
                    jSONObject.put("batVN", "7.3.7");
                    jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
                    jSONObject.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.b.o.F());
                    jSONObject.put("appLabel", com.baidu.crabsdk.b.o.G());
                    if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                        jSONObject.put("appVN", com.baidu.crabsdk.b.o.H());
                    } else {
                        jSONObject.put("appVN", com.baidu.crabsdk.a.o);
                    }
                    jSONObject.put("soLibs", i.cv(context.getApplicationInfo().nativeLibraryDir));
                    jSONObject.put("procName", CrabSDK.CURRENT_PNAME);
                    if (com.baidu.crabsdk.a.L) {
                        jSONObject.put("filter", 2);
                    } else {
                        jSONObject.put("filter", 1);
                    }
                    String cn = com.baidu.crabsdk.c.d.cn(jSONObject.toString());
                    if (cn != null) {
                        NativeCrashHandler nativeCrashHandler = bQ;
                        if (nativeCrashHandler.bR) {
                            nativeCrashHandler.nRequiredVarParams(cn);
                        } else {
                            com.baidu.crabsdk.c.a.w("call before failed! native lib init failed");
                        }
                    }
                } catch (Exception e3) {
                    com.baidu.crabsdk.c.a.a("call native method nRequiredVarParams error!!", e3);
                }
            } catch (Exception e4) {
                com.baidu.crabsdk.c.a.a("Save some var in .crab error!", e4);
            }
        }
    }

    public final void b(int i) {
        if (this.bR) {
            nSetLogcatLineCount(i);
        }
    }
}
