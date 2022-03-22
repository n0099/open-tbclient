package c.a.p0.c4;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13532b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1704465557, "Lc/a/p0/c4/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1704465557, "Lc/a/p0/c4/e;");
        }
    }

    public static boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() || intent == null) {
                return false;
            }
            String action = intent.getAction();
            Set<String> categories = intent.getCategories();
            boolean z = !AdToMainTabActivitySwitch.getIsOn() && action != null && categories != null && TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER") && PermissionUtil.isAgreePrivacyPolicy() && a;
            a = false;
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            if (intent == null) {
                return false;
            }
            String action = intent.getAction();
            Set<String> categories = intent.getCategories();
            boolean z = AdToMainTabActivitySwitch.getIsOn() && f13532b && action != null && categories != null && TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER");
            f13532b = false;
            return z;
        }
        return invokeL.booleanValue;
    }
}
