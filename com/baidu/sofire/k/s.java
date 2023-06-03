package com.baidu.sofire.k;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259419, "Lcom/baidu/sofire/k/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259419, "Lcom/baidu/sofire/k/s;");
                return;
            }
        }
        a = new String[]{"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "xbOAOB93VGI-kwCx1KZxzESB35X3hv9xe1VSXGErZbY=", "WtGvBTWjt2PyMX5rQclkgiNR3aDxFtoBNe1UnNpbL1I="};
        b = f.a(16);
    }

    public static Bundle a(Context context, String str, Bundle bundle, Uri uri) {
        InterceptResult invokeLLLL;
        ContentProviderClient contentProviderClient;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, bundle, uri)) == null) {
            try {
                ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                int i = Build.VERSION.SDK_INT;
                if (i >= 17) {
                    try {
                        contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    } catch (Throwable unused) {
                        contentProviderClient = null;
                    }
                    try {
                        Bundle call = contentProviderClient.call(str, null, bundle);
                        if (i < 24) {
                            contentProviderClient.release();
                        } else {
                            contentProviderClient.close();
                        }
                        return call;
                    } catch (Throwable unused2) {
                        int i2 = com.baidu.sofire.a.b.a;
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
                int i3 = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public static Bundle a(Context context, String str, Bundle bundle, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, bundle, str2)) == null) {
            try {
                context.getApplicationContext().getContentResolver();
                return a(context, str, bundle, Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + context.getPackageName() + "." + str2 + ".ac.provider"));
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }
}
