package com.baidu.crashpad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
    public static CrashCallbackExtra mCrashCallbackListener = null;
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

    public static void NotifyCrashStart() {
        CrashCallbackExtra crashCallbackExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && mIsEnabled && (crashCallbackExtra = mCrashCallbackListener) != null) {
            crashCallbackExtra.onBeforeHandleCrash();
        }
    }

    public static synchronized void RecordUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && mNativeIsInitialized) {
                    nativeRecordUrl(str);
                }
            }
        }
    }

    public static synchronized boolean ShouldIgnoreCrash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && mNativeIsInitialized) {
                    return nativeShouldIgnoreCrash();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void clearCrashKey(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, str) == null) && mIsEnabled && mNativeIsInitialized && str != null) {
            nativeClearCrashKey(str);
        }
    }

    public static void crashIntentionally(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i2) == null) {
            if (i2 == 1) {
                if (mNativeIsInitialized) {
                    nativeCrashIntentionally(i2);
                }
            } else if (i2 == 2) {
                setCrashKeyValue("JavaExceptionInfo", "only for test add JavaExceptionInfo for JNI crash");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:8|(3:81|82|(2:86|(22:88|(2:14|(1:16))|(1:80)(1:21)|22|(1:28)|29|(1:79)|35|36|37|38|39|40|(1:15d)(1:44)|45|(1:47)|48|171|55|(1:62)|59|60)))|10|(3:12|14|(0))|(0)|80|22|(3:24|26|28)|29|(1:31)|79|35|36|37|38|39|40|(1:42)|15d) */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void doInit(Context context, String[] strArr) {
        boolean z;
        String str;
        File file;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, context, strArr) == null) || !mIsEnabled || context == null || mIsInitialized) {
            return;
        }
        String str3 = strArr[10];
        mClientDir = str3;
        String str4 = "0";
        boolean z2 = false;
        if (str3 != null) {
            if (!str3.isEmpty() && !mClientDir.equals("0")) {
                String str5 = mClientDir + "/libcrashpad_client.so";
                if (new File(str5).exists()) {
                    str4 = str5;
                    z = true;
                    if (str4 != null && str4.equals("0")) {
                        str2 = context.getFilesDir().getAbsolutePath() + "/zeus/libs/libcrashpad_client.so";
                        if (new File(str2).exists()) {
                            str4 = str2;
                            z = true;
                        }
                    }
                    if (!z && str4 != null && !str4.equals("0")) {
                        System.load(str4);
                        mNativeIsInitialized = true;
                    } else {
                        System.loadLibrary("crashpad_client");
                        mNativeIsInitialized = true;
                    }
                    ZwDebugExtra.init(context);
                    setCyberVersion(strArr[0]);
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
                    return;
                }
            }
        }
        z = false;
        if (str4 != null) {
            str2 = context.getFilesDir().getAbsolutePath() + "/zeus/libs/libcrashpad_client.so";
            if (new File(str2).exists()) {
            }
        }
        if (!z) {
        }
        System.loadLibrary("crashpad_client");
        mNativeIsInitialized = true;
        ZwDebugExtra.init(context);
        setCyberVersion(strArr[0]);
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

    /* JADX WARN: Can't wrap try/catch for region: R(17:(9:12|13|(1:15)|16|(1:18)|19|(1:103)|25|(1:27))|29|30|31|(2:37|(18:39|(2:43|(1:45))|(1:100)(1:50)|51|52|53|54|55|56|(1:16e)(1:60)|61|(1:63)|64|182|71|(1:75)|76|(1:82)(2:80|81)))|101|(3:41|43|(0))|(0)|100|51|52|53|54|55|56|(1:58)|16e) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:12|13|(1:15)|16|(1:18)|19|(1:103)|25|(1:27)|29|30|31|(2:37|(18:39|(2:43|(1:45))|(1:100)(1:50)|51|52|53|54|55|56|(1:16e)(1:60)|61|(1:63)|64|182|71|(1:75)|76|(1:82)(2:80|81)))|101|(3:41|43|(0))|(0)|100|51|52|53|54|55|56|(1:58)|16e) */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb  */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void doInitGeneric(Context context, String str) {
        File file;
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65544, null, context, str) != null) {
            return;
        }
        String str3 = "zwCrashpad.doInitGeneric  mIsEnabled=" + mIsEnabled + ", mIsInitialized=" + mIsInitialized + ", mNativeIsInitialized=" + mNativeIsInitialized;
        if (!mIsEnabled || context == null || mIsInitialized || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("clientDir");
            if (!TextUtils.isEmpty(optString)) {
                mClientDir = optString;
            }
            String optString2 = jSONObject.optString("handlerDir");
            if (!TextUtils.isEmpty(optString2)) {
                mHandlerDir = optString2;
            }
            if (mHandlerDir == null || mHandlerDir.equals("0") || mHandlerDir.isEmpty()) {
                mHandlerDir = context.getApplicationInfo().nativeLibraryDir;
            }
            String optString3 = jSONObject.optString("dumpCopyDir");
            if (!TextUtils.isEmpty(optString3)) {
                mDumpCopyDir = optString3;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String str4 = "0";
        if (mClientDir != null && !mClientDir.isEmpty() && !mClientDir.equals("0")) {
            String str5 = mClientDir + "/libcrashpad_client.so";
            if (new File(str5).exists()) {
                str4 = str5;
                z = true;
                if (str4 != null && str4.equals("0")) {
                    str2 = context.getFilesDir().getAbsolutePath() + "/zeus/libs/libcrashpad_client.so";
                    if (new File(str2).exists()) {
                        str4 = str2;
                        z = true;
                    }
                }
                if (!z && str4 != null && !str4.equals("0")) {
                    System.load(str4);
                    mNativeIsInitialized = true;
                } else {
                    System.loadLibrary("crashpad_client");
                    mNativeIsInitialized = true;
                }
                ZwDebugExtra.init(context);
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
                File externalFilesDir = context.getExternalFilesDir("");
                if (externalFilesDir != null && externalFilesDir.exists()) {
                    ZeusLogUploader.setBDSdcradDir(externalFilesDir.getAbsolutePath());
                }
                ZeusLogUploader.setUploadCrashLogFailedEncrypt(true);
                ZeusLogUploader.setEncryptKey(getEncryptKey());
                File filesDir = context.getFilesDir();
                if (filesDir == null || !filesDir.exists()) {
                    return;
                }
                ZeusLogUploader.UploadLogDirectory(filesDir.getAbsolutePath() + "/zeuslogs/", "crashlog", true, null);
                return;
            }
        }
        z = false;
        if (str4 != null) {
            str2 = context.getFilesDir().getAbsolutePath() + "/zeus/libs/libcrashpad_client.so";
            if (new File(str2).exists()) {
            }
        }
        if (!z) {
        }
        System.loadLibrary("crashpad_client");
        mNativeIsInitialized = true;
        ZwDebugExtra.init(context);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (ZwCrashpad.class) {
                return (mIsEnabled && mNativeIsInitialized) ? nativeGetEncryptKey() : "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String[] getInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
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

    public static native void nativeSetCpu(String str);

    public static native void nativeSetCrashKeyValue(String str, String str2);

    public static native void nativeSetCuid(String str);

    public static native void nativeSetCyberVersion(String str);

    public static native void nativeSetDumpCopyDir(String str);

    public static native void nativeSetEmulator(String str);

    public static native void nativeSetHandlerSoDir(String str);

    public static native void nativeSetHasCallbackListener();

    public static native void nativeSetJavaException(String str);

    public static native void nativeSetKernelInfoToDuliCrashpad(String[] strArr);

    public static native void nativeSetProcessType(String str);

    public static native void nativeSetStatisticParam(String str);

    public static native void nativeSetUploadCrashLogFailedEncrypt(boolean z);

    public static native void nativeSetWebviewNumber(String str);

    public static native void nativeSetZeusVersion(String str);

    public static native boolean nativeShouldIgnoreCrash();

    public static String[] newInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                return new String[]{mAppPackageName, mAppVersion, Integer.toString(mAppVersionCode), mZeusVersion, mCyberVersion, mLocation, mIMEI, Build.MODEL.replace(' ', '_').replace(SignatureImpl.SEP, '_'), Build.VERSION.RELEASE, mCPU, mCuid, mStatisticParam, mEmulator, mCallback, "", "", mChannel, mBaseBand, Build.DISPLAY, mProcessType, mWebviewNumber, mUploadCrashLogFailedEncrypt, mHandlerDir, String.valueOf(Build.VERSION.SDK_INT), Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128)), mDumpCopyDir};
            } catch (Exception unused) {
                return new String[0];
            }
        }
        return (String[]) invokeV.objValue;
    }

    public static synchronized void setCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, str) == null) {
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
        if (interceptable == null || interceptable.invokeL(65572, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mClientDir)) {
                    mClientDir = str;
                }
            }
        }
    }

    public static synchronized void setCpu(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, str) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && !TextUtils.equals(str, mCPU)) {
                    mCPU = str;
                    if (mNativeIsInitialized) {
                        nativeSetCpu(str);
                    }
                }
            }
        }
    }

    public static synchronized void setCrashCallbackListener(CrashCallbackExtra crashCallbackExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, crashCallbackExtra) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled) {
                    mCrashCallbackListener = crashCallbackExtra;
                    if (mNativeIsInitialized) {
                        nativeSetHasCallbackListener();
                    }
                }
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65575, null, str, str2) == null) && mIsEnabled && mNativeIsInitialized && str != null) {
            nativeSetCrashKeyValue(str, str2);
        }
    }

    public static synchronized void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, str) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
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
        if (interceptable == null || interceptable.invokeL(65578, null, str) == null) {
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
        if (interceptable == null || interceptable.invokeL(65579, null, str) == null) {
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
        if (interceptable == null || interceptable.invokeZ(65580, null, z) == null) {
            mIsEnabled = z;
            ZeusLogUploader.setEnabled(z);
        }
    }

    public static synchronized void setHandlerSoDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, str) == null) {
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

    public static synchronized void setKernelInfoToDuliCrashpad(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, null, strArr) == null) {
            synchronized (ZwCrashpad.class) {
                if (mIsEnabled && mNativeIsInitialized) {
                    nativeSetKernelInfoToDuliCrashpad(strArr);
                }
            }
        }
    }

    public static synchronized void setProcessType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, null, str) == null) {
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
        if (interceptable == null || interceptable.invokeL(65584, null, str) == null) {
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
        if (interceptable == null || interceptable.invokeZ(65585, null, z) == null) {
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
        if (interceptable == null || interceptable.invokeL(65586, null, str) == null) {
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
        if (interceptable == null || interceptable.invokeL(65587, null, str) == null) {
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
