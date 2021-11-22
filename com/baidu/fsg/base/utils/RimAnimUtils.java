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
    public static int f38443a;

    /* renamed from: b  reason: collision with root package name */
    public static int f38444b;

    /* renamed from: c  reason: collision with root package name */
    public static int f38445c;

    /* renamed from: d  reason: collision with root package name */
    public static int f38446d;
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
        if (f38445c == 0 || f38446d == 0) {
            f38445c = ResUtils.anim(context, "rim_base_slide_from_left");
            f38446d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f38445c, f38446d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f38445c + ", mCloseExit:" + f38446d);
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
        if (f38443a == 0 || f38444b == 0) {
            f38443a = ResUtils.anim(context, "rim_base_slide_from_right");
            f38444b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f38443a, f38444b);
        }
    }
}
