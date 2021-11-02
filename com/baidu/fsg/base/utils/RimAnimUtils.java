package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class RimAnimUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f37613a;

    /* renamed from: b  reason: collision with root package name */
    public static int f37614b;

    /* renamed from: c  reason: collision with root package name */
    public static int f37615c;

    /* renamed from: d  reason: collision with root package name */
    public static int f37616d;
    public transient /* synthetic */ FieldHolder $fh;

    public RimAnimUtils() {
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

    public static void finishActivityAnim(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null) {
            return;
        }
        if (f37615c == 0 || f37616d == 0) {
            f37615c = ResUtils.anim(context, "rim_base_slide_from_left");
            f37616d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f37615c, f37616d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f37615c + ", mCloseExit:" + f37616d);
    }

    public static void overridePendingTransitionNoAnim(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, activity) == null) || activity == null) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public static void startActivityAnim(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || context == null) {
            return;
        }
        if (f37613a == 0 || f37614b == 0) {
            f37613a = ResUtils.anim(context, "rim_base_slide_from_right");
            f37614b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f37613a, f37614b);
        }
    }
}
