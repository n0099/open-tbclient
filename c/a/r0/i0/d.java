package c.a.r0.i0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Intent a(Context context, String str, String str2, boolean z, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, str2, Boolean.valueOf(z), cVar})) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            int i2 = 0;
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            while (true) {
                if (i2 >= queryIntentActivities.size()) {
                    break;
                }
                String str3 = queryIntentActivities.get(i2).activityInfo.packageName;
                if (TextUtils.equals(str3, str2)) {
                    intent.setPackage(str3);
                    break;
                }
                i2++;
            }
            if (z && !TextUtils.isEmpty(str2) && TextUtils.isEmpty(intent.getPackage())) {
                if (cVar != null) {
                    cVar.onFailed(-104);
                    return null;
                }
                return null;
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static Intent b(@NonNull Context context, String str, String str2, boolean z, @Nullable c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Boolean.valueOf(z), cVar})) == null) {
            if (!d(str) && !e(str)) {
                return a(context, str, str2, z, cVar);
            }
            return c(context, str, str2, cVar);
        }
        return (Intent) invokeCommon.objValue;
    }

    @Nullable
    public static Intent c(Context context, String str, String str2, c cVar) {
        InterceptResult invokeLLLL;
        List<ResolveInfo> queryIntentActivities;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, cVar)) == null) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (parseUri == null) {
                    if (cVar != null) {
                        cVar.onFailed(-103);
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
                    if (parseUri.getComponent() == null && (queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 0)) != null && queryIntentActivities.size() > 0) {
                        parseUri.setComponent(new ComponentName(str3, queryIntentActivities.iterator().next().activityInfo.name));
                    }
                    return parseUri;
                }
                return context.getPackageManager().getLaunchIntentForPackage(str2);
            } catch (URISyntaxException unused) {
                Intent launchIntentForPackage = TextUtils.isEmpty(str2) ? null : context.getPackageManager().getLaunchIntentForPackage(str2);
                if (launchIntentForPackage == null && cVar != null) {
                    cVar.onFailed(-102);
                }
                return launchIntentForPackage;
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("android-app:");
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("intent:") || str.startsWith("#Intent;");
        }
        return invokeL.booleanValue;
    }
}
