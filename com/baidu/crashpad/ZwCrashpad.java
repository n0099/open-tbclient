package com.baidu.crashpad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
/* loaded from: classes2.dex */
public class ZwCrashpad {
    public static final String TAG = "ZwCrashpad CRASHPAD";
    public static String mAppPackageName = "0";
    public static String mAppVersion = "0";
    public static int mAppVersionCode = -1;
    public static String mBaseBand = "0";
    public static String mCPU = "0";
    public static String mCallback = "";
    public static String mChannel = "0";
    public static String mClientDir = "0";
    public static String mCuid = "0";
    public static String mCyberVersion = "0";
    public static boolean mCyberVersionIsReady = false;
    public static String mDumpCopyDir = "0";
    public static String mEmulator = "0";
    public static String mHandlerDir = "0";
    public static String mIMEI = "0";
    public static boolean mIsEnabled = true;
    public static boolean mIsInitialized = false;
    public static String mLocation = "0";
    public static boolean mLocationIsReady = false;
    public static boolean mNativeIsInitialized = false;
    public static String mProcessType = "0";
    public static String mStatisticParam = "";
    public static String mUploadCrashLogFailedEncrypt = "true";
    public static String mWebviewNumber = "-1";
    public static String mZeusVersion = "0";
    public static final Object sCyberVersionLock = new Object();

    public static synchronized void RecordUrl(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && mNativeIsInitialized) {
                nativeRecordUrl(str);
            }
        }
    }

    public static void clearCrashKey(String str) {
        if (mIsEnabled && mNativeIsInitialized && str != null) {
            nativeClearCrashKey(str);
        }
    }

    public static void crashIntentionally(int i2) {
        if (i2 == 1) {
            if (mNativeIsInitialized) {
                nativeCrashIntentionally(i2);
            }
        } else if (i2 == 2) {
            setCrashKeyValue("JavaExceptionInfo", "only for test add JavaExceptionInfo for JNI crash");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:6|(3:78|79|(22:83|(1:85)|(1:76)(1:15)|16|(1:22)|23|(1:75)|29|30|31|33|34|35|(1:173)(1:39)|40|(1:42)|43|187|50|(1:57)|54|55))|8|(1:10)(1:77)|(0)|76|16|(3:18|20|22)|23|(1:25)|75|29|30|31|33|34|35|(1:37)|173) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0123, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0124, code lost:
        android.util.Log.e(com.baidu.crashpad.ZwCrashpad.TAG, "", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0132, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0133, code lost:
        android.util.Log.e(com.baidu.crashpad.ZwCrashpad.TAG, "", r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void doInit(Context context, String[] strArr) {
        boolean exists;
        String str;
        File file;
        if (!mIsEnabled || context == null || mIsInitialized) {
            return;
        }
        String str2 = strArr[10];
        mClientDir = str2;
        String str3 = "0";
        boolean z = false;
        if (str2 != null) {
            try {
            } catch (Throwable unused) {
                Log.e(TAG, "failed to load crashpad_client library ");
            }
            if (!str2.isEmpty() && !mClientDir.equals("0")) {
                String str4 = mClientDir + "/libcrashpad_client.so";
                exists = new File(str4).exists();
                if (exists) {
                    str3 = str4;
                }
                if (!exists && str3 != null && !str3.equals("0")) {
                    System.load(str3);
                    mNativeIsInitialized = true;
                    Log.i(TAG, "load crashpad_client from custom path sucess");
                } else {
                    System.loadLibrary("crashpad_client");
                    mNativeIsInitialized = true;
                    Log.i(TAG, "loadlibrary crashpad_client sucess");
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
                str = strArr[11];
                mHandlerDir = str;
                if (str != null || str.equals("0") || mHandlerDir.isEmpty()) {
                    mHandlerDir = context.getApplicationInfo().nativeLibraryDir;
                }
                mDumpCopyDir = strArr[12];
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                mAppVersion = packageInfo.versionName;
                mAppVersionCode = packageInfo.versionCode;
                mAppPackageName = context.getPackageName();
                mLocation = context.getFilesDir().getAbsolutePath() + "/zeuslogs/";
                file = new File(mLocation);
                if (file.exists() && !file.mkdirs()) {
                    mLocation = context.getFilesDir().getAbsolutePath();
                } else {
                    synchronized (ZwCrashpad.class) {
                        mLocationIsReady = true;
                    }
                }
                String radioVersion = Build.getRadioVersion();
                mBaseBand = radioVersion;
                if (radioVersion == null) {
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
                ZeusLogUploader.setUploadCrashLogFailedEncrypt((strArr[7] == null || Boolean.valueOf(strArr[7]).booleanValue()) ? true : true);
                ZeusLogUploader.setEncryptKey(getEncryptKey());
                ZeusLogUploader.UploadLogDirectory(context.getFilesDir().getAbsolutePath() + "/zeuslogs/", "crashlog", true, null);
                Log.i(TAG, "zwbreakpd.doinit  end");
                return;
            }
        }
        String str5 = context.getFilesDir().getAbsolutePath() + "/zeus/libs/libcrashpad_client.so";
        if (new File(str5).exists()) {
            str3 = str5;
            exists = true;
        } else {
            exists = false;
        }
        if (!exists) {
        }
        System.loadLibrary("crashpad_client");
        mNativeIsInitialized = true;
        Log.i(TAG, "loadlibrary crashpad_client sucess");
        ZwDebugExtra.init(context);
        mCyberVersion = strArr[0];
        mCyberVersionIsReady = true;
        mCPU = strArr[1];
        mCuid = strArr[2];
        mEmulator = strArr[3];
        mCallback = strArr[4];
        mChannel = strArr[5];
        if (strArr[6] != null) {
            mProcessType = strArr[6];
        }
        mUploadCrashLogFailedEncrypt = strArr[7];
        mZeusVersion = strArr[9];
        str = strArr[11];
        mHandlerDir = str;
        if (str != null) {
        }
        mHandlerDir = context.getApplicationInfo().nativeLibraryDir;
        mDumpCopyDir = strArr[12];
        PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        mAppVersion = packageInfo2.versionName;
        mAppVersionCode = packageInfo2.versionCode;
        mAppPackageName = context.getPackageName();
        mLocation = context.getFilesDir().getAbsolutePath() + "/zeuslogs/";
        file = new File(mLocation);
        if (file.exists()) {
        }
        synchronized (ZwCrashpad.class) {
        }
    }

    public static synchronized String getEncryptKey() {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && mNativeIsInitialized) {
                return nativeGetEncryptKey();
            }
            return "";
        }
    }

    public static String[] getInfos() {
        String[] newInfos = newInfos();
        synchronized (ZwCrashpad.class) {
            mNativeIsInitialized = true;
        }
        return newInfos;
    }

    public static boolean isCyberVersionReady() {
        boolean z;
        synchronized (sCyberVersionLock) {
            z = mCyberVersionIsReady;
        }
        return z;
    }

    public static native void nativeClearCrashKey(String str);

    public static native void nativeCrashIntentionally(int i2);

    public static native String nativeGetEncryptKey();

    public static native void nativeInit(String[] strArr);

    public static native void nativeRecordUrl(String str);

    public static native void nativeSetCallback(String str);

    public static native void nativeSetCrashKeyValue(String str, String str2);

    public static native void nativeSetCuid(String str);

    public static native void nativeSetCyberVersion(String str);

    public static native void nativeSetDumpCopyDir(String str);

    public static native void nativeSetEmulator(String str);

    public static native void nativeSetHandlerSoDir(String str);

    public static native void nativeSetJavaException(String str);

    public static native void nativeSetProcessType(String str);

    public static native void nativeSetStatisticParam(String str);

    public static native void nativeSetUploadCrashLogFailedEncrypt(boolean z);

    public static native void nativeSetWebviewNumber(String str);

    public static native void nativeSetZeusVersion(String str);

    public static String[] newInfos() {
        try {
            return new String[]{mAppPackageName, mAppVersion, Integer.toString(mAppVersionCode), mZeusVersion, mCyberVersion, mLocation, mIMEI, Build.MODEL.replace(' ', '_').replace('-', '_'), Build.VERSION.RELEASE, mCPU, mCuid, mStatisticParam, mEmulator, mCallback, " ", " ", mChannel, mBaseBand, Build.DISPLAY, mProcessType, mWebviewNumber, mUploadCrashLogFailedEncrypt, mHandlerDir, String.valueOf(Build.VERSION.SDK_INT), Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128)), mDumpCopyDir};
        } catch (Exception e2) {
            Log.e(TAG, "newInfos error maybe BUILD get errors");
            Log.e(TAG, "", e2);
            return new String[0];
        }
    }

    public static synchronized void setCallback(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mCallback)) {
                mCallback = str;
                if (mNativeIsInitialized) {
                    nativeSetCallback(str);
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

    public static void setCrashKeyValue(String str, String str2) {
        if (mIsEnabled && mNativeIsInitialized && str != null) {
            nativeSetCrashKeyValue(str, str2);
        }
    }

    public static synchronized void setCuid(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mCuid)) {
                mCuid = str;
                if (mNativeIsInitialized) {
                    nativeSetCuid(str);
                }
            }
        }
    }

    public static boolean setCyberVersion(String str) {
        if (!mIsEnabled || str == null || str.equals("0")) {
            return false;
        }
        synchronized (sCyberVersionLock) {
            if (mCyberVersion != null && mCyberVersion.equals(str)) {
                return false;
            }
            mCyberVersion = str;
            mCyberVersionIsReady = true;
            if (mNativeIsInitialized) {
                nativeSetCyberVersion(str);
            }
            return true;
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

    public static void setEnabled(boolean z) {
        mIsEnabled = z;
        ZeusLogUploader.setEnabled(z);
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

    public static synchronized void setProcessType(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mProcessType)) {
                mProcessType = str;
                if (mNativeIsInitialized) {
                    nativeSetProcessType(str);
                }
            }
        }
    }

    public static synchronized void setStatisticParam(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mStatisticParam)) {
                mStatisticParam = str;
                if (mNativeIsInitialized) {
                    nativeSetStatisticParam(str);
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
                    nativeSetWebviewNumber(str);
                }
            }
        }
    }

    public static synchronized void setZeusVersion(String str) {
        synchronized (ZwCrashpad.class) {
            if (mIsEnabled && !TextUtils.equals(str, mZeusVersion)) {
                mZeusVersion = str;
                if (mNativeIsInitialized) {
                    nativeSetZeusVersion(str);
                }
            }
        }
    }
}
