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
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443541898, "Lcom/baidu/sofire/utility/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443541898, "Lcom/baidu/sofire/utility/w;");
                return;
            }
        }
        a = new String[]{"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "xbOAOB93VGI-kwCx1KZxzESB35X3hv9xe1VSXGErZbY="};
    }

    public static Bundle a(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, bundle)) == null) ? b(context, str, bundle, "sofire") : (Bundle) invokeLLL.objValue;
    }

    public static Bundle b(Context context, String str, Bundle bundle, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, str, bundle, str2)) == null) {
            try {
                context.getApplicationContext().getContentResolver();
                return a(context, str, bundle, Uri.parse("content://" + context.getPackageName() + "." + str2 + ".ac.provider"));
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public static Bundle a(Context context, String str, Bundle bundle, String str2) {
        InterceptResult invokeLLLL;
        ProviderInfo[] providerInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, bundle, str2)) == null) {
            try {
                providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
            } catch (Throwable unused) {
                c.a();
            }
            if (providerInfoArr != null && providerInfoArr.length > 0) {
                for (String str3 : a) {
                    String str4 = new String(h.a("30212102dicudiab".getBytes(), Base64.decode(str3, 10)), "UTF-8");
                    if (!TextUtils.isEmpty(str4)) {
                        if ("sofire".equals(str4)) {
                            return null;
                        }
                        StringBuilder sb = new StringBuilder("content://");
                        sb.append(context.getPackageName());
                        sb.append(".");
                        sb.append(str4);
                        sb.append(".ac.provider");
                        String sb2 = sb.toString();
                        for (ProviderInfo providerInfo : providerInfoArr) {
                            if (sb2.contains(providerInfo.authority)) {
                                Bundle a2 = a(context, str, bundle, Uri.parse(sb.toString()));
                                boolean z = a2.getBoolean("handle_flag");
                                String string = a2.getString("server_version");
                                if (z) {
                                    if (a(string, str2)) {
                                        return a2;
                                    }
                                }
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return null;
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public static Bundle a(Context context, String str, Bundle bundle, Uri uri) {
        InterceptResult invokeLLLL;
        ContentProviderClient contentProviderClient;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, bundle, uri)) == null) {
            try {
                ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    } catch (Throwable unused) {
                        contentProviderClient = null;
                    }
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
                    } catch (Throwable unused2) {
                        c.a();
                        if (contentProviderClient != null) {
                            if (Build.VERSION.SDK_INT < 24) {
                                contentProviderClient.release();
                            } else {
                                contentProviderClient.close();
                            }
                        }
                        return null;
                    }
                }
                return contentResolver.call(uri, str, (String) null, bundle);
            } catch (Throwable unused3) {
                c.a();
                return null;
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str.equals(str2)) {
                return true;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
                int intValue = Integer.valueOf(split[i2]).intValue() - Integer.valueOf(split2[i2]).intValue();
                if (intValue != 0) {
                    return intValue > 0;
                }
            }
            return split.length > split2.length;
        }
        return invokeLL.booleanValue;
    }
}
