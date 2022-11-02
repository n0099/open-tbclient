package com.baidu.android.util.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class IntentUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "IntentUtils";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1661348389, "Lcom/baidu/android/util/android/IntentUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1661348389, "Lcom/baidu/android/util/android/IntentUtils;");
        }
    }

    public IntentUtils() {
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

    public static List<ComponentName> getIntentHandlers(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                arrayList.add(new ComponentName(activityInfo.packageName, activityInfo.name));
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static Bundle safeGetBundle(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bundle, str)) == null) {
            try {
                return bundle.getBundle(str);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getBundle failed on bundle " + bundle);
                    return null;
                }
                return null;
            }
        }
        return (Bundle) invokeLL.objValue;
    }

    public static Bundle safeGetBundleExtra(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, intent, str)) == null) {
            try {
                return intent.getBundleExtra(str);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getBundleExtra failed on intent " + intent);
                    return null;
                }
                return null;
            }
        }
        return (Bundle) invokeLL.objValue;
    }

    public static byte[] safeGetByteArrayExtra(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, intent, str)) == null) {
            try {
                return intent.getByteArrayExtra(str);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getByteArrayExtra failed on intent " + intent);
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static <T extends Parcelable> T safeGetParcelableExtra(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, intent, str)) == null) {
            try {
                return (T) intent.getParcelableExtra(str);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getByteArrayExtra failed on intent " + intent);
                    return null;
                }
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public static String safeGetString(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bundle, str)) == null) {
            try {
                return bundle.getString(str);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getString failed on bundle " + bundle);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static ArrayList<String> safeGetStringArrayListExtra(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, intent, str)) == null) {
            try {
                return intent.getStringArrayListExtra(str);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getStringArrayListExtra failed on intent " + intent);
                    return null;
                }
                return null;
            }
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static String safeGetStringExtra(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, intent, str)) == null) {
            try {
                return intent.getStringExtra(str);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getStringExtra failed on intent " + intent);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isAvailable(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) {
            if (intent == null || context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean processFileUriIntent(Context context, File file, Intent intent) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, file, intent)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                    if (uriForFile == null) {
                        return false;
                    }
                    intent.setDataAndType(uriForFile, intent.getType());
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    if (queryIntentActivities == null) {
                        return true;
                    }
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo != null && (str = activityInfo.packageName) != null) {
                            context.grantUriPermission(str, uriForFile, 1);
                        }
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        return false;
                    }
                    throw e;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean safeGetBooleanExtra(Intent intent, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, intent, str, z)) == null) {
            try {
                return intent.getBooleanExtra(str, z);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getBooleanExtra failed on intent " + intent);
                }
                return z;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static int safeGetIntExtra(Intent intent, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, intent, str, i)) == null) {
            try {
                return intent.getIntExtra(str, i);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getIntExtra failed on intent " + intent);
                }
                return i;
            }
        }
        return invokeLLI.intValue;
    }

    public static long safeGetLongExtra(Intent intent, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{intent, str, Long.valueOf(j)})) == null) {
            try {
                return intent.getLongExtra(str, j);
            } catch (Throwable unused) {
                if (DEBUG) {
                    Log.e(TAG, "getLongExtra failed on intent " + intent);
                }
                return j;
            }
        }
        return invokeCommon.longValue;
    }
}
