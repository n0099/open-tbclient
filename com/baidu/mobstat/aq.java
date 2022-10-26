package com.baidu.mobstat;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.MtjConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class aq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65536, null, activity, z) != null) || !z || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().a(activity);
    }

    public static void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65541, null, activity, z) != null) || !z || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().b(activity);
    }

    public static void c(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65542, null, activity, z) != null) || !z || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().c(activity);
    }

    public static void a(KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, keyEvent) != null) || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().a(keyEvent);
    }

    public static void a(View view2, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, view2, activity) != null) || ar.a().b() || as.a().b()) {
            return;
        }
        as.a().a(view2, activity);
    }

    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, feedTrackStrategy) == null) {
            as.a().a(feedTrackStrategy);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || as.a().b()) {
            return;
        }
        as.a().a(str);
    }
}
