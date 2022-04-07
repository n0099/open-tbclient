package com.baidu.tbadk;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ActivityPendingTransitionFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean IS_CUSTOM_FROM_THIRD_PARTY = false;
    public static int RES_BIG_IMAGE_IN_FROM_RIGHT = 2130772012;
    public static int RES_BIG_IMAGE_OUT_TO_RIGHT = 2130772022;
    public static int RES_CUSTOM_FADE_IN = 0;
    public static int RES_CUSTOM_FADE_OUT = 0;
    public static int RES_CUSTOM_IN_FROM_RIGHT = 0;
    public static int RES_CUSTOM_OUT_TO_RIGHT = 0;
    public static int RES_FADE_OUT = 2130772068;
    public static int RES_NFADE_IN = 2130772067;
    public static int RES_NORMAL_IN_FROM_BOTTOM = 2130772106;
    public static int RES_NORMAL_IN_FROM_RIGHT = 2130772107;
    public static int RES_NORMAL_OUT_TO_BOTTOM = 2130772149;
    public static int RES_NORMAL_OUT_TO_RIGHT = 2130772151;
    public static final int TYPE_BIG_IMAGE = 2;
    public static final int TYPE_BOTTOM = 4;
    public static final int TYPE_CUSTOM_FROM_THIRD_PARTY = 3;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_ANIMATION = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(327323211, "Lcom/baidu/tbadk/ActivityPendingTransitionFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(327323211, "Lcom/baidu/tbadk/ActivityPendingTransitionFactory;");
        }
    }

    public ActivityPendingTransitionFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void closeAnimation(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, tbPageContext, i) == null) || tbPageContext == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (IS_CUSTOM_FROM_THIRD_PARTY) {
            i = 3;
        }
        if (i == 0) {
            pageActivity.overridePendingTransition(0, 0);
        } else if (i == 1) {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_RIGHT);
        } else if (i == 2) {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_BIG_IMAGE_OUT_TO_RIGHT);
        } else if (i == 3) {
            pageActivity.overridePendingTransition(RES_CUSTOM_FADE_IN, RES_CUSTOM_OUT_TO_RIGHT);
        } else if (i != 4) {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_RIGHT);
        } else {
            pageActivity.overridePendingTransition(RES_NFADE_IN, RES_NORMAL_OUT_TO_BOTTOM);
        }
    }

    public static void enterExitAnimation(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, tbPageContext, i) == null) || tbPageContext == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (IS_CUSTOM_FROM_THIRD_PARTY) {
            i = 3;
        }
        if (i == 0) {
            pageActivity.overridePendingTransition(0, 0);
        } else if (i == 1) {
            pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_RIGHT, RES_FADE_OUT);
        } else if (i == 2) {
            pageActivity.overridePendingTransition(RES_BIG_IMAGE_IN_FROM_RIGHT, RES_FADE_OUT);
        } else if (i == 3) {
            pageActivity.overridePendingTransition(RES_CUSTOM_IN_FROM_RIGHT, RES_CUSTOM_FADE_OUT);
        } else if (i != 4) {
            pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_RIGHT, RES_FADE_OUT);
        } else {
            pageActivity.overridePendingTransition(RES_NORMAL_IN_FROM_BOTTOM, RES_FADE_OUT);
        }
    }
}
