package com.baidu.sofire.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.sofire.core.PluginloaderDexClassLoader;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.core.PluginloaderIntentFilter;
import com.baidu.sofire.d.D;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.DbUtil;
import com.baidu.sofire.utility.EncryptUtil;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.PrivacyOperationUtil;
import com.baidu.sofire.utility.PrivacyPolicyUtil;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.Map;
/* loaded from: classes2.dex */
public class F implements FI {
    public static /* synthetic */ Interceptable $ic;
    public static F instance;
    public static Asc sAsc;
    public transient /* synthetic */ FieldHolder $fh;

    public F() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized F getInstance() {
        InterceptResult invokeV;
        F f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (F.class) {
                if (instance == null) {
                    instance = new F();
                }
                f = instance;
            }
            return f;
        }
        return (F) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] aesDecrypt = EncryptUtil.aesDecrypt(bArr2, bArr, true);
                        if (aesDecrypt != null && aesDecrypt.length != 0) {
                            return aesDecrypt;
                        }
                        return new byte[0];
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] aesEncrypt = EncryptUtil.aesEncrypt(bArr2, bArr, true);
                        if (aesEncrypt != null && aesEncrypt.length != 0) {
                            return aesEncrypt;
                        }
                        return new byte[0];
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        r8.onEnd(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        return;
     */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, callback, clsArr, objArr}) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                    if (peekInstance == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                            return;
                        }
                        return;
                    }
                    ApkInfo apkInfoByPackageName = peekInstance.getApkInfoByPackageName(str2);
                    if (peekInstance.getApkInfoByPackageName(str) == null || apkInfoByPackageName == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                            return;
                        }
                        return;
                    }
                    Class<?> loadClassWithoutParentClass = ((PluginloaderDexClassLoader) apkInfoByPackageName.classLoader).loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                    Object callMethodOfClass = CommonMethods.callMethodOfClass(loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, null), str3, clsArr, objArr);
                    if (callback != null) {
                        callback.onEnd(callMethodOfClass);
                    }
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            try {
                ForHostApp peekInstance = ForHostApp.peekInstance();
                if (peekInstance == null) {
                    return new Pair<>(4, null);
                }
                return peekInstance.execEngineImplSync(i, str, clsArr, objArr);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean cp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (context == null) {
                return false;
            }
            return PrivacyPolicyUtil.check(context);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) {
            if (context == null) {
                return null;
            }
            return SharedPreferenceManager.getInstance(context).getCustomMutiProcessSharedPreferences(str);
        }
        return (SharedPreferences) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Boolean, DeviceInfoCallback> getDeviceInfoCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new Pair<>(Boolean.FALSE, PrivacyOperationUtil.getDeviceInfoCallback()) : (Pair) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformPrivateSharedPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return SharedPreferenceManager.getInstance(context).getPlatformPrivateSharedPreferences();
        }
        return (SharedPreferences) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformSharedSharedPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return SharedPreferenceManager.getInstance(context).getPlatformSharedSharedPreferences();
        }
        return (SharedPreferences) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gm(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                    if (peekInstance == null) {
                        return "-2";
                    }
                    ApkInfo apkInfoByPackageName = peekInstance.getApkInfoByPackageName(str);
                    if (apkInfoByPackageName == null) {
                        return "-3";
                    }
                    if (str2.equals(apkInfoByPackageName.versionName)) {
                        String str3 = apkInfoByPackageName.apkMD5;
                        if (U.sRealtimeMd5Map != null) {
                            String str4 = U.sRealtimeMd5Map.get(apkInfoByPackageName.key + apkInfoByPackageName.versionName);
                            return !TextUtils.isEmpty(str4) ? str4 : str3;
                        }
                        return str3;
                    }
                    return EventType.PayEventID.QUERY_PRODUCT_LIST_FAIL;
                }
                return "-1";
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return EventType.PayEventID.QUERY_PRODUCT_LIST_SUCCESS;
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Integer, String> gpd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                D peekInstance = D.peekInstance();
                if (peekInstance != null) {
                    return peekInstance.getInitSuceedPluginKeys();
                }
                return null;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        InterceptResult invokeL;
        ApkInfo apkInfoByPackageName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            try {
                PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                return (peekInstance == null || (apkInfoByPackageName = peekInstance.getApkInfoByPackageName(str)) == null) ? "" : apkInfoByPackageName.libPath;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gta(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gzd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) ? context == null ? "" : DbUtil.getCUID(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                return PluginloaderHub.peekInstance().getApkPathByPackageName(str);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        PluginloaderHub peekInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, intentFilter, str2, str3) == null) {
            try {
                if (TextUtils.isEmpty(str) || intentFilter == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (peekInstance = PluginloaderHub.peekInstance()) == null) {
                    return;
                }
                peekInstance.addOneRegisterReceiver(new PluginloaderIntentFilter(str, intentFilter, str2, str3));
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] rc4Decrypt = EncryptUtil.rc4Decrypt(bArr, bArr2);
                        if (rc4Decrypt != null && rc4Decrypt.length != 0) {
                            return rc4Decrypt;
                        }
                        return new byte[0];
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] rc4Encrypt = EncryptUtil.rc4Encrypt(bArr, bArr2);
                        if (rc4Encrypt != null && rc4Encrypt.length != 0) {
                            return rc4Encrypt;
                        }
                        return new byte[0];
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, context) == null) || context == null) {
            return;
        }
        try {
            ThreadPoolManager.getInstance(context).executeCore(new U(context.getApplicationContext(), 5, true));
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                D peekInstance = D.peekInstance();
                if (peekInstance != null) {
                    peekInstance.changePluginBusyStatus(i, z ? 1 : 0);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            try {
                D peekInstance = D.peekInstance();
                if (peekInstance != null) {
                    peekInstance.changePluginBusyStatusByPkg(str, z ? 1 : 0);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            try {
                ForHostApp.peekInstance().unloadPlugin(str);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        PluginloaderHub peekInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048599, this, str, intentFilter, str2, str3) == null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (peekInstance = PluginloaderHub.peekInstance()) == null) {
                    return;
                }
                peekInstance.removeOneRegisterReceiver(new PluginloaderIntentFilter(str, intentFilter, str2, str3));
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}
