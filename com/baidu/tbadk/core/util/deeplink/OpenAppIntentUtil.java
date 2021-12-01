package com.baidu.tbadk.core.util.deeplink;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class OpenAppIntentUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenAppIntentUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
        r0.setPackage(r2);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent createDefaultIntent(Context context, String str, String str2, boolean z, OpenAppCallback openAppCallback) {
        Intent launchIntent;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Boolean.valueOf(z), openAppCallback})) == null) {
            try {
                launchIntent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                launchIntent.setFlags(268435456);
                int i2 = 0;
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntent, 0);
                while (true) {
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    String str3 = queryIntentActivities.get(i2).activityInfo.packageName;
                    if (TextUtils.equals(str3, str2)) {
                        break;
                    }
                    i2++;
                }
            } catch (Exception unused) {
                launchIntent = getLaunchIntent(context, str2);
            }
            if (launchIntent == null) {
                if (openAppCallback != null) {
                    openAppCallback.onFailed(-102);
                }
                return null;
            } else if (z && !TextUtils.isEmpty(str2) && TextUtils.isEmpty(launchIntent.getPackage())) {
                if (openAppCallback != null) {
                    openAppCallback.onFailed(-104);
                }
                return null;
            } else {
                return launchIntent;
            }
        }
        return (Intent) invokeCommon.objValue;
    }

    @Nullable
    public static Intent createIntent(@NonNull Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) ? createIntent(context, str, str2, z, null) : (Intent) invokeCommon.objValue;
    }

    @Nullable
    public static Intent createSchemeIntent(Context context, String str, String str2, OpenAppCallback openAppCallback) {
        InterceptResult invokeLLLL;
        List<ResolveInfo> queryIntentActivities;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, openAppCallback)) == null) {
            PackageManager packageManager = context.getPackageManager();
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (parseUri == null) {
                    if (openAppCallback != null) {
                        openAppCallback.onFailed(-103);
                    }
                    return null;
                }
                String str3 = parseUri.getPackage();
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    parseUri.setFlags(268435456);
                    Set<String> categories = parseUri.getCategories();
                    if (categories == null || categories.isEmpty()) {
                        parseUri.addCategory("android.intent.category.LAUNCHER");
                    }
                    if (parseUri.getComponent() == null && (queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0)) != null && queryIntentActivities.size() > 0) {
                        parseUri.setComponent(new ComponentName(str3, queryIntentActivities.iterator().next().activityInfo.name));
                    }
                    return parseUri;
                }
                return packageManager.getLaunchIntentForPackage(str2);
            } catch (URISyntaxException unused) {
                Intent launchIntentForPackage = TextUtils.isEmpty(str2) ? null : packageManager.getLaunchIntentForPackage(str2);
                if (launchIntentForPackage == null && openAppCallback != null) {
                    openAppCallback.onFailed(-102);
                }
                return launchIntentForPackage;
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public static Intent getLaunchIntent(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static ResolveInfo getUriResolveInfo(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, uri)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(268435456);
            try {
                return context.getPackageManager().resolveActivity(intent, 65536);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public static boolean isAndroidApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("android-app:");
        }
        return invokeL.booleanValue;
    }

    public static boolean isIntentScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("intent:") || str.startsWith("#Intent;");
        }
        return invokeL.booleanValue;
    }

    public static boolean startAppByPkgName(String str) {
        InterceptResult invokeL;
        Context context;
        Intent launchIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (launchIntent = getLaunchIntent((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
                return false;
            }
            try {
                context.startActivity(launchIntent);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Intent createIntent(@NonNull Context context, String str, String str2, boolean z, @Nullable OpenAppCallback openAppCallback) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Boolean.valueOf(z), openAppCallback})) == null) {
            if (!isAndroidApp(str) && !isIntentScheme(str)) {
                return createDefaultIntent(context, str, str2, z, openAppCallback);
            }
            return createSchemeIntent(context, str, str2, openAppCallback);
        }
        return (Intent) invokeCommon.objValue;
    }
}
