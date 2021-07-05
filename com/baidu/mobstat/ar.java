package com.baidu.mobstat;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.MtjConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, feedTrackStrategy) == null) {
            at.a().a(feedTrackStrategy);
        }
    }

    public static void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, activity, z) == null) || !z || as.a().b() || at.a().b()) {
            return;
        }
        at.a().b(activity);
    }

    public static void c(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, activity, z) == null) || !z || as.a().b() || at.a().b()) {
            return;
        }
        at.a().c(activity);
    }

    public static void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65536, null, activity, z) == null) || !z || as.a().b() || at.a().b()) {
            return;
        }
        at.a().a(activity);
    }

    public static void a(View view, Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, view, activity) == null) || as.a().b() || at.a().b()) {
            return;
        }
        at.a().a(view, activity);
    }

    public static void a(KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, keyEvent) == null) || as.a().b() || at.a().b()) {
            return;
        }
        at.a().a(keyEvent);
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, str) == null) || at.a().b()) {
            return;
        }
        at.a().a(str);
    }
}
