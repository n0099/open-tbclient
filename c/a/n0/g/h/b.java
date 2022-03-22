package c.a.n0.g.h;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.s1.b.f.e;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (!SwanAppInitHelper.entranceOK()) {
                Log.w("SwanAppLaunchHelper", "entrance not open");
                e.g(AppRuntime.getAppContext(), "not support for this android version").G();
            } else if (TextUtils.isEmpty(str)) {
                e.g(AppRuntime.getAppContext(), "url is empty").G();
            } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
                b(str);
            } else if (str.startsWith("bdswan")) {
                b(str.replace("bdswan", SchemeConfig.getSchemeHead()));
            } else if (!str.startsWith("https") && !str.startsWith("http")) {
                e.g(AppRuntime.getAppContext(), "not support this uri").G();
            } else {
                c(str);
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.e(str);
        }
    }
}
