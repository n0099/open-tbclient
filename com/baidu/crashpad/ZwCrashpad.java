package com.baidu.crashpad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes3.dex */
public class ZwCrashpad {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final Object sCyberVersionLock;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(694147421, "Lcom/baidu/crashpad/ZwCrashpad;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(694147421, "Lcom/baidu/crashpad/ZwCrashpad;");
                return;
            }
        }
        sCyberVersionLock = new Object();
    }

    public ZwCrashpad() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized void RecordUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && mNativeIsInitialized) {
                    nativeRecordUrl(str);
                }
            }
        }
    }

    public static void clearCrashKey(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && mIsEnabled && mNativeIsInitialized && str != null) {
            nativeClearCrashKey(str);
        }
    }

    public static void crashIntentionally(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65540, null, i2) == null) {
            if (i2 == 1) {
                if (mNativeIsInitialized) {
                    nativeCrashIntentionally(i2);
                }
            } else if (i2 == 2) {
                setCrashKeyValue("JavaExceptionInfo", "only for test add JavaExceptionInfo for JNI crash");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:8|(3:80|81|(22:85|(1:87)|(1:78)(1:17)|18|(1:24)|25|(1:77)|31|32|33|35|36|37|(1:177)(1:41)|42|(1:44)|45|18b|52|(1:59)|56|57))|10|(1:12)(1:79)|(0)|78|18|(3:20|22|24)|25|(1:27)|77|31|32|33|35|36|37|(1:39)|177) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0127, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0128, code lost:
        android.util.Log.e(com.baidu.crashpad.ZwCrashpad.TAG, "", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0136, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0137, code lost:
        android.util.Log.e(com.baidu.crashpad.ZwCrashpad.TAG, "", r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void doInit(Context context, String[] strArr) {
        boolean exists;
        String str;
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, strArr) == null) || !mIsEnabled || context == null || mIsInitialized) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (ZwCrashpad.class) {
                return (mIsEnabled && mNativeIsInitialized) ? nativeGetEncryptKey() : "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String[] getInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String[] newInfos = newInfos();
            synchronized (ZwCrashpad.class) {
                mNativeIsInitialized = true;
            }
            return newInfos;
        }
        return (String[]) invokeV.objValue;
    }

    public static boolean isCyberVersionReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (sCyberVersionLock) {
                z = mCyberVersionIsReady;
            }
            return z;
        }
        return invokeV.booleanValue;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                return new String[]{mAppPackageName, mAppVersion, Integer.toString(mAppVersionCode), mZeusVersion, mCyberVersion, mLocation, mIMEI, Build.MODEL.replace(' ', '_').replace(SignatureImpl.SEP, '_'), Build.VERSION.RELEASE, mCPU, mCuid, mStatisticParam, mEmulator, mCallback, " ", " ", mChannel, mBaseBand, Build.DISPLAY, mProcessType, mWebviewNumber, mUploadCrashLogFailedEncrypt, mHandlerDir, String.valueOf(Build.VERSION.SDK_INT), Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128)), mDumpCopyDir};
            } catch (Exception e2) {
                Log.e(TAG, "newInfos error maybe BUILD get errors");
                Log.e(TAG, "", e2);
                return new String[0];
            }
        }
        return (String[]) invokeV.objValue;
    }

    public static synchronized void setCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mCallback)) {
                    mCallback = str;
                    if (mNativeIsInitialized) {
                        nativeSetCallback(str);
                    }
                }
            }
        }
    }

    public static synchronized void setClientSoDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mClientDir)) {
                    mClientDir = str;
                }
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65566, null, str, str2) == null) && mIsEnabled && mNativeIsInitialized && str != null) {
            nativeSetCrashKeyValue(str, str2);
        }
    }

    public static synchronized void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mCuid)) {
                    mCuid = str;
                    if (mNativeIsInitialized) {
                        nativeSetCuid(str);
                    }
                }
            }
        }
    }

    public static boolean setCyberVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static synchronized void setDumpCopyDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mDumpCopyDir)) {
                    mDumpCopyDir = str;
                    if (mNativeIsInitialized) {
                        nativeSetDumpCopyDir(str);
                    }
                }
            }
        }
    }

    public static synchronized void setEmulator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mEmulator)) {
                    mEmulator = str;
                    if (mNativeIsInitialized) {
                        nativeSetEmulator(str);
                    }
                }
            }
        }
    }

    public static void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65571, null, z) == null) {
            mIsEnabled = z;
            ZeusLogUploader.setEnabled(z);
        }
    }

    public static synchronized void setHandlerSoDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mHandlerDir)) {
                    mHandlerDir = str;
                    if (mNativeIsInitialized) {
                        nativeSetHandlerSoDir(str);
                    }
                }
            }
        }
    }

    public static synchronized void setProcessType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mProcessType)) {
                    mProcessType = str;
                    if (mNativeIsInitialized) {
                        nativeSetProcessType(str);
                    }
                }
            }
        }
    }

    public static synchronized void setStatisticParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mStatisticParam)) {
                    mStatisticParam = str;
                    if (mNativeIsInitialized) {
                        nativeSetStatisticParam(str);
                    }
                }
            }
        }
    }

    public static synchronized void setUploadCrashLogFailedEncrypt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65575, null, z) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled) {
                    mUploadCrashLogFailedEncrypt = z ? "true" : "false";
                    if (mNativeIsInitialized) {
                        nativeSetUploadCrashLogFailedEncrypt(z);
                    }
                }
            }
        }
    }

    public static synchronized void setWebviewNumber(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mWebviewNumber)) {
                    mWebviewNumber = str;
                    if (mNativeIsInitialized) {
                        nativeSetWebviewNumber(str);
                    }
                }
            }
        }
    }

    public static synchronized void setZeusVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, str) == null) {
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
}
