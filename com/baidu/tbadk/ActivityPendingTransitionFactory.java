package com.baidu.tbadk;

import android.app.Activity;
import c.a.u0.a4.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ActivityPendingTransitionFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean IS_CUSTOM_FROM_THIRD_PARTY = false;
    public static int RES_BIG_IMAGE_IN_FROM_RIGHT = 0;
    public static int RES_BIG_IMAGE_OUT_TO_RIGHT = 0;
    public static int RES_CUSTOM_FADE_IN = 0;
    public static int RES_CUSTOM_FADE_OUT = 0;
    public static int RES_CUSTOM_IN_FROM_RIGHT = 0;
    public static int RES_CUSTOM_OUT_TO_RIGHT = 0;
    public static int RES_FADE_OUT = 0;
    public static int RES_NFADE_IN = 0;
    public static int RES_NORMAL_IN_FROM_BOTTOM = 0;
    public static int RES_NORMAL_IN_FROM_RIGHT = 0;
    public static int RES_NORMAL_OUT_TO_BOTTOM = 0;
    public static int RES_NORMAL_OUT_TO_RIGHT = 0;
    public static final int TYPE_BIG_IMAGE = 2;
    public static final int TYPE_BOTTOM = 4;
    public static final int TYPE_CUSTOM_FROM_THIRD_PARTY = 3;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_ANIMATION = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(327323211, "Lcom/baidu/tbadk/ActivityPendingTransitionFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(327323211, "Lcom/baidu/tbadk/ActivityPendingTransitionFactory;");
                return;
            }
        }
        RES_NFADE_IN = a.fade_in;
        RES_FADE_OUT = a.fade_out;
        RES_NORMAL_IN_FROM_RIGHT = a.in_from_right;
        RES_NORMAL_IN_FROM_BOTTOM = a.in_from_bottom;
        RES_NORMAL_OUT_TO_RIGHT = a.out_to_right;
        RES_NORMAL_OUT_TO_BOTTOM = a.out_to_bottom;
        RES_BIG_IMAGE_IN_FROM_RIGHT = a.anim_alpha_0_to_1_duration_300;
        RES_BIG_IMAGE_OUT_TO_RIGHT = a.anim_alpha_1_to_0_duration_300;
    }

    public ActivityPendingTransitionFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void closeAnimation(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, tbPageContext, i2) == null) || tbPageContext == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (IS_CUSTOM_FROM_THIRD_PARTY) {
            i2 = 3;
        }
        if (i2 == 0) {
            pageActivity.overridePendingTransition(0, 0);
        } else if (i2 == 1) {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_RIGHT);
        } else if (i2 == 2) {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_BIG_IMAGE_OUT_TO_RIGHT);
        } else if (i2 == 3) {
            pageActivity.overridePendingTransition(RES_CUSTOM_FADE_IN, RES_CUSTOM_OUT_TO_RIGHT);
        } else if (i2 != 4) {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_RIGHT);
        } else {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_BOTTOM);
        }
    }

    public static void enterExitAnimation(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, tbPageContext, i2) == null) || tbPageContext == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (IS_CUSTOM_FROM_THIRD_PARTY) {
            i2 = 3;
        }
        if (i2 == 0) {
            pageActivity.overridePendingTransition(0, 0);
        } else if (i2 == 1) {
            pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_RIGHT, RES_FADE_OUT);
        } else if (i2 == 2) {
            pageActivity.overridePendingTransition(RES_BIG_IMAGE_IN_FROM_RIGHT, RES_FADE_OUT);
        } else if (i2 == 3) {
            pageActivity.overridePendingTransition(RES_CUSTOM_IN_FROM_RIGHT, RES_CUSTOM_FADE_OUT);
        } else if (i2 != 4) {
            pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_RIGHT, RES_FADE_OUT);
        } else {
            pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_BOTTOM, RES_FADE_OUT);
        }
    }
}
