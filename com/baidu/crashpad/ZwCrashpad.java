package com.baidu.crashpad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
/* loaded from: classes15.dex */
public class ZwCrashpad {
    private static final String TAG = "ZwCrashpad CRASHPAD";
    private static boolean mCyberVersionIsReady;
    private static boolean mIsInitialized;
    private static boolean mLocationIsReady;
    private static boolean mNativeIsInitialized;
    private static String mEmulator = "0";
    private static String mCuid = "0";
    private static String mCallback = "";
    private static String mCPU = "0";
    private static String mStatisticParam = "";
    private static String mAppPackageName = "0";
    private static String mAppVersion = "0";
    private static int mAppVersionCode = -1;
    private static String mZeusVersion = "0";
    private static String mCyberVersion = "0";
    private static String mIMEI = "0";
    private static String mChannel = "0";
    private static String mBaseBand = "0";
    private static String mLocation = "0";
    private static String mProcessType = "0";
    private static String mWebviewNumber = "-1";
    private static String mUploadCrashLogFailedEncrypt = "true";
    private static String mHandlerDir = "0";
    private static String mClientDir = "0";
    private static String mDumpCopyDir = "0";
    private static final Object sCyberVersionLock = new Object();
    private static boolean mIsEnabled = true;

    private static native void nativeClearCrashKey(String str);

    private static native void nativeCrashIntentionally(int i);

    private static native String nativeGetEncryptKey();

    private static native void nativeInit(String[] strArr);

    private static native void nativeRecordUrl(String str);

    private static native void nativeSetCallback(String str);

    private static native void nativeSetCrashKeyValue(String str, String str2);

    private static native void nativeSetCuid(String str);

    private static native void nativeSetCyberVersion(String str);

    private static native void nativeSetDumpCopyDir(String str);

    private static native void nativeSetEmulator(String str);

    private static native void nativeSetHandlerSoDir(String str);

    private static native void nativeSetJavaException(String str);

    private static native void nativeSetProcessType(String str);

    private static native void nativeSetStatisticParam(String str);

    private static native void nativeSetUploadCrashLogFailedEncrypt(boolean z);

    private static native void nativeSetWebviewNumber(String str);

    private static native void nativeSetZeusVersion(String str);

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static void doInit(Context context, String[] strArr) {
        String str;
        boolean z;
        boolean z2 = false;
        if (mIsEnabled && context != null && !mIsInitialized) {
            mClientDir = strArr[10];
            try {
                if (mClientDir != null && !mClientDir.isEmpty() && !mClientDir.equals("0")) {
                    str = mClientDir + "/libcrashpad_client.so";
                    if (new File(str).exists()) {
                        z = true;
                    }
                    str = "0";
                    z = false;
                } else {
                    str = context.getFilesDir().getAbsolutePath() + "/zeus/libs/libcrashpad_client.so";
                    if (new File(str).exists()) {
                        z = true;
                    }
                    str = "0";
                    z = false;
                }
                if (z && str != null && !str.equals("0")) {
                    System.load(str);
                    mNativeIsInitialized = true;
                    Log.i(TAG, "load crashpad_client from custom path sucess");
                } else {
                    System.loadLibrary("crashpad_client");
                    mNativeIsInitialized = true;
                    Log.i(TAG, "loadlibrary crashpad_client sucess");
                }
            } catch (Throwable th) {
                Log.e(TAG, "failed to load crashpad_client library ");
            }
            ZwDebugExtra.init(context);
            mCyberVersion = strArr[0];
            mCyberVersionIsReady = true;
            mCPU = strArr[1];
            mCuid = strArr[2];
            mEmulator = strArr[3];
            mCallback = strArr[4];
            mChannel = strArr[5];
            if (strArr[6] != null && !strArr[6].isEmpty() && !TextUtils.equals(strArr[6], "-1")) {
                mProcessType = strArr[6];
            }
            mUploadCrashLogFailedEncrypt = strArr[7];
            mZeusVersion = strArr[9];
            mHandlerDir = strArr[11];
            if (mHandlerDir == null || mHandlerDir.equals("0") || mHandlerDir.isEmpty()) {
                mHandlerDir = context.getApplicationInfo().nativeLibraryDir;
            }
            mDumpCopyDir = strArr[12];
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                mAppVersion = packageInfo.versionName;
                mAppVersionCode = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "", e);
            }
            try {
                mAppPackageName = context.getPackageName();
            } catch (Exception e2) {
                Log.e(TAG, "", e2);
            }
            mLocation = context.getFilesDir().getAbsolutePath() + "/zeuslogs/";
            File file = new File(mLocation);
            if (!file.exists() && !file.mkdirs()) {
                mLocation = context.getFilesDir().getAbsolutePath();
            } else {
                synchronized (ZwCrashpad.class) {
                    mLocationIsReady = true;
                }
            }
            mBaseBand = Build.getRadioVersion();
            if (mBaseBand == null) {
                mBaseBand = "no message";
            }
            String[] newInfos = newInfos();
            synchronized (ZwCrashpad.class) {
                if (mNativeIsInitialized) {
                    nativeInit(newInfos);
                    mIsInitialized = true;
                }
            }
            setCrashKeyValue("USER", Build.USER);
            ZeusLogUploader.setBDSdcradDir(strArr[8]);
            if (strArr[7] == null || Boolean.valueOf(strArr[7]).booleanValue()) {
                z2 = true;
            }
            ZeusLogUploader.setUploadCrashLogFailedEncrypt(z2);
            ZeusLogUploader.setEncryptKey(getEncryptKey());
            ZeusLogUploader.UploadLogDirectory(context.getFilesDir().getAbsolutePath() + "/zeuslogs/", "crashlog", true, null);
            Log.i(TAG, "zwbreakpd.doinit  end");
        }
    }

    public static void setEnabled(boolean z) {
        mIsEnabled = z;
        ZeusLogUploader.setEnabled(z);
    }

    public static boolean setCyberVersion(String str) {
        if (mIsEnabled && str != null && !str.equals("0")) {
            synchronized (sCyberVersionLock) {
                if (mCyberVersion == null || !mCyberVersion.equals(str)) {
                    mCyberVersion = str;
                    mCyberVersionIsReady = true;
                    if (mNativeIsInitialized) {
                        nativeSetCyberVersion(mCyberVersion);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyberVersionReady() {
        boolean z;
        synchronized (sCyberVersionLock) {
            z = mCyberVersionIsReady;
        }
        return z;
    }

    public static synchronized void setZeusVersion(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mZeusVersion)) {
                mZeusVersion = str;
                if (mNativeIsInitialized) {
                    nativeSetZeusVersion(mZeusVersion);
                }
            }
        }
    }

    public static synchronized void setCuid(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mCuid)) {
                mCuid = str;
                if (mNativeIsInitialized) {
                    nativeSetCuid(mCuid);
                }
            }
        }
    }

    public static synchronized void setStatisticParam(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mStatisticParam)) {
                mStatisticParam = str;
                if (mNativeIsInitialized) {
                    nativeSetStatisticParam(mStatisticParam);
                }
            }
        }
    }

    public static synchronized void setEmulator(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mEmulator)) {
                mEmulator = str;
                if (mNativeIsInitialized) {
                    nativeSetEmulator(str);
                }
            }
        }
    }

    public static synchronized void setCallback(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mCallback)) {
                mCallback = str;
                if (mNativeIsInitialized) {
                    nativeSetCallback(mCallback);
                }
            }
        }
    }

    public static synchronized void setProcessType(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mProcessType)) {
                mProcessType = str;
                if (mNativeIsInitialized) {
                    nativeSetProcessType(mProcessType);
                }
            }
        }
    }

    public static synchronized void setUploadCrashLogFailedEncrypt(boolean z) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled) {
                mUploadCrashLogFailedEncrypt = z ? "true" : "false";
                if (mNativeIsInitialized) {
                    nativeSetUploadCrashLogFailedEncrypt(z);
                }
            }
        }
    }

    public static synchronized void setWebviewNumber(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mWebviewNumber)) {
                mWebviewNumber = str;
                if (mNativeIsInitialized) {
                    nativeSetWebviewNumber(mWebviewNumber);
                }
            }
        }
    }

    public static void crashIntentionally(int i) {
        if (i == 1) {
            if (mNativeIsInitialized) {
                nativeCrashIntentionally(i);
            }
        } else if (i == 2) {
            setCrashKeyValue("JavaExceptionInfo", "only for test add JavaExceptionInfo for JNI crash");
        }
    }

    public static String[] getInfos() {
        String[] newInfos = newInfos();
        synchronized (ZwCrashpad.class) {
            mNativeIsInitialized = true;
        }
        return newInfos;
    }

    public static synchronized String getEncryptKey() {
        String nativeGetEncryptKey;
        synchronized (ZwCrashpad.class) {
            nativeGetEncryptKey = (mIsEnabled && mNativeIsInitialized) ? nativeGetEncryptKey() : "";
        }
        return nativeGetEncryptKey;
    }

    public static synchronized void RecordUrl(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && mNativeIsInitialized) {
                nativeRecordUrl(str);
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        if (mIsEnabled && mNativeIsInitialized && str != null) {
            nativeSetCrashKeyValue(str, str2);
        }
    }

    public static void clearCrashKey(String str) {
        if (mIsEnabled && mNativeIsInitialized && str != null) {
            nativeClearCrashKey(str);
        }
    }

    public static synchronized void setHandlerSoDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mHandlerDir)) {
                mHandlerDir = str;
                if (mNativeIsInitialized) {
                    nativeSetHandlerSoDir(str);
                }
            }
        }
    }

    public static synchronized void setClientSoDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mClientDir)) {
                mClientDir = str;
            }
        }
    }

    public static synchronized void setDumpCopyDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mDumpCopyDir)) {
                mDumpCopyDir = str;
                if (mNativeIsInitialized) {
                    nativeSetDumpCopyDir(str);
                }
            }
        }
    }

    private static String[] newInfos() {
        try {
            return new String[]{mAppPackageName, mAppVersion, Integer.toString(mAppVersionCode), mZeusVersion, mCyberVersion, mLocation, mIMEI, Build.MODEL.replace(' ', '_').replace('-', '_'), Build.VERSION.RELEASE, mCPU, mCuid, mStatisticParam, mEmulator, mCallback, " ", " ", mChannel, mBaseBand, Build.DISPLAY, mProcessType, mWebviewNumber, mUploadCrashLogFailedEncrypt, mHandlerDir, String.valueOf(Build.VERSION.SDK_INT), Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128)), mDumpCopyDir};
        } catch (Exception e) {
            Log.e(TAG, "newInfos error maybe BUILD get errors");
            Log.e(TAG, "", e);
            return new String[0];
        }
    }
}
