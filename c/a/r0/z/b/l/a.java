package c.a.r0.z.b.l;

import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.p0.a.c1.a.M().a() : invokeV.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
            int i2 = a() ? 2 : 1;
            if (defaultNightMode != i2) {
                AppCompatDelegate.setDefaultNightMode(i2);
            }
        }
    }

    public static void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
            intent.putExtra("key_night_mode", z);
            LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
        }
    }
}
