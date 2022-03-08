package c.a.b0.h0;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, File file, Intent intent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, file, intent)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    if (TextUtils.isEmpty(c.a.b0.h.a.a().o())) {
                        return false;
                    }
                    Uri uriForFile = FileProvider.getUriForFile(context, c.a.b0.h.a.a().o(), file);
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
                        if (activityInfo != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                            context.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 1);
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void b(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, dialog) == null) || dialog == null) {
            return;
        }
        try {
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static boolean c(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) ? d(context, intent, false) : invokeLL.booleanValue;
    }

    public static boolean d(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, context, intent, z)) == null) ? e(context, intent, z, false) : invokeLLZ.booleanValue;
    }

    public static boolean e(Context context, Intent intent, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, intent, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || !(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                if (z2) {
                    Toast.makeText(context, (int) R.string.nad_activity_not_found, 0).show();
                    return false;
                }
                return false;
            } catch (SecurityException unused2) {
                if (z2) {
                    Toast.makeText(context, (int) R.string.nad_activity_not_found, 0).show();
                    return false;
                }
                return false;
            } catch (Exception unused3) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
