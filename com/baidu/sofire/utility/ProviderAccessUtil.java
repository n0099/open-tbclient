package com.baidu.sofire.utility;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.MyProvider;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ProviderAccessUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_KEY = "30212102dicudiab";
    public static final String[] PLATFORM_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1678967570, "Lcom/baidu/sofire/utility/ProviderAccessUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1678967570, "Lcom/baidu/sofire/utility/ProviderAccessUtil;");
                return;
            }
        }
        PLATFORM_ARRAY = new String[]{"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "xbOAOB93VGI-kwCx1KZxzESB35X3hv9xe1VSXGErZbY=", "WtGvBTWjt2PyMX5rQclkgiNR3aDxFtoBNe1UnNpbL1I="};
    }

    public ProviderAccessUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Bundle callPrivateProvider(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, bundle)) == null) ? callTargetSharedProvider(context, str, bundle, "sofire") : (Bundle) invokeLLL.objValue;
    }

    public static Bundle callSharedProvider(Context context, String str, Bundle bundle, boolean z, String str2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, bundle, Boolean.valueOf(z), str2, Boolean.valueOf(z2)})) == null) {
            try {
                ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
                if (providerInfoArr != null && providerInfoArr.length > 0) {
                    boolean z3 = false;
                    for (String str3 : PLATFORM_ARRAY) {
                        String str4 = new String(EncryptUtil.aesDecrypt("30212102dicudiab".getBytes(), Base64.decode(str3, 10), true), "UTF-8");
                        if (!TextUtils.isEmpty(str4)) {
                            if ("sofire".equals(str4)) {
                                if (!z) {
                                    return null;
                                }
                                z3 = true;
                            }
                            StringBuilder sb = new StringBuilder("content://");
                            sb.append(context.getPackageName());
                            sb.append(".");
                            sb.append(str4);
                            sb.append(".ac.provider");
                            String sb2 = sb.toString();
                            for (ProviderInfo providerInfo : providerInfoArr) {
                                if (sb2.contains(providerInfo.authority)) {
                                    Bundle callTargetSharedProvider = callTargetSharedProvider(context, str, bundle, Uri.parse(sb.toString()));
                                    if (z2) {
                                        boolean z4 = callTargetSharedProvider.getBoolean(MyProvider.BUNDLE_KEY_HANDLE_FLAG);
                                        String string = callTargetSharedProvider.getString(MyProvider.BUNDLE_KEY_SERVER_VERSION);
                                        if (z4) {
                                            if (!compareVersion(string, str2)) {
                                            }
                                        }
                                    }
                                    return callTargetSharedProvider;
                                }
                            }
                            if (z3) {
                                break;
                            }
                        }
                    }
                    return null;
                }
                return null;
            }
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static Bundle callTargetSharedProvider(Context context, String str, Bundle bundle, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, str, bundle, str2)) == null) {
            try {
                context.getApplicationContext().getContentResolver();
                return callTargetSharedProvider(context, str, bundle, Uri.parse("content://" + context.getPackageName() + "." + str2 + ".ac.provider"));
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public static boolean compareVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (str.equals(str2)) {
                return true;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            for (int i = 0; i < split.length && i < split2.length; i++) {
                int intValue = Integer.valueOf(split[i]).intValue() - Integer.valueOf(split2[i]).intValue();
                if (intValue != 0) {
                    return intValue > 0;
                }
            }
            return split.length > split2.length;
        }
        return invokeLL.booleanValue;
    }

    public static Bundle callTargetSharedProvider(Context context, String str, Bundle bundle, Uri uri) {
        InterceptResult invokeLLLL;
        ContentProviderClient contentProviderClient;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, bundle, uri)) != null) {
            return (Bundle) invokeLLLL.objValue;
        }
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    try {
                        Bundle call = contentProviderClient.call(str, null, bundle);
                        if (contentProviderClient != null) {
                            if (Build.VERSION.SDK_INT < 24) {
                                contentProviderClient.release();
                            } else {
                                contentProviderClient.close();
                            }
                        }
                        return call;
                    } catch (Throwable th) {
                        th = th;
                        CommonMethods.handleNuLException(th);
                        if (contentProviderClient != null) {
                            if (Build.VERSION.SDK_INT < 24) {
                                contentProviderClient.release();
                            } else {
                                contentProviderClient.close();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    contentProviderClient = null;
                }
            } else {
                return contentResolver.call(uri, str, (String) null, bundle);
            }
        } catch (Throwable th3) {
            CommonMethods.handleNuLException(th3);
            return null;
        }
    }
}
