package com.baidu.searchbox.ai;

import android.util.Log;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class Common {
    public static final String TAG = "Common";

    public static native int getJniVersion();

    public static String getSDKVersion() {
        try {
            int jniVersion = getJniVersion();
            return "mml" + jniVersion;
        } catch (UnsatisfiedLinkError unused) {
            SoLoader.load(AppRuntime.getAppContext(), "protobuf-lite");
            SoLoader.load(AppRuntime.getAppContext(), "ai-entry");
            try {
                int jniVersion2 = getJniVersion();
                return "mml" + jniVersion2;
            } catch (Throwable unused2) {
                return null;
            }
        } catch (Throwable th) {
            String str = TAG;
            Log.e(str, "invoke getJniVersion e: " + th.getLocalizedMessage());
            return null;
        }
    }
}
