package c.a.n0.a.i.a;

import android.content.Context;
import android.os.Bundle;
import c.a.n0.a.p2.o0;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) || context == null) {
            return;
        }
        CookieManager.getInstance().setCookie(".baidu.com", o0.k(".baidu.com", "OPENBDUSS", str, 31449600L));
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            if (ProcessUtils.isMainProcess()) {
                a(context, str);
            } else {
                c(context, str);
            }
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("bduss", str);
            c.a.n0.a.o1.b.e.b(b.class, bundle);
        }
    }
}
