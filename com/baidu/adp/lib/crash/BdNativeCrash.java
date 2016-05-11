package com.baidu.adp.lib.crash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.g;
/* loaded from: classes.dex */
public class BdNativeCrash {
    private static NativeCrashCallback mCallback;
    private static BdNativeCrash mCrash;
    public static boolean mbLibLoaded;
    private String mCrashLogPath;

    /* loaded from: classes.dex */
    public interface NativeCrashCallback {
        void onNativeCrashed(int i, int i2, int i3, String str);

        boolean onSoFound(String str);
    }

    static native boolean initCrashPath(String str);

    /* loaded from: classes.dex */
    public static class NativeHookTestClass {
        static {
            BdLog.d("test");
        }
    }

    public void setCrashCallback(NativeCrashCallback nativeCrashCallback) {
        mCallback = nativeCrashCallback;
    }

    static {
        mbLibLoaded = false;
        mbLibLoaded = g.fc().i("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash getInstance() {
        if (mCrash == null) {
            synchronized (BdNativeCrash.class) {
                if (mCrash == null) {
                    mCrash = new BdNativeCrash();
                }
            }
        }
        return mCrash;
    }

    public static boolean hasSoInApk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (mCallback == null) {
            return true;
        }
        return mCallback.onSoFound(str);
    }

    public void initCrash(String str, String str2) {
        this.mCrashLogPath = str2;
        d.bG().C(str);
        if (!TextUtils.isEmpty(this.mCrashLogPath)) {
            b bVar = new b();
            bVar.B(str);
            initCrashPath(bVar.b(this.mCrashLogPath, true, true));
        }
    }

    public String getCrashPath() {
        return this.mCrashLogPath;
    }

    public static void onNativeCrashed(int i, int i2, int i3, String str) {
        if (mCallback != null) {
            mCallback.onNativeCrashed(i, i2, i3, str);
        }
    }
}
