package com.baidu.android.ext.widget.toast;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ToastConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLICKABLE_TOAST_SHOW_LONG_TIME = 5;
    public static final int CLICKABLE_TOAST_SHOW_TIME = 3;
    public static final int DEFAULT_TEXT_SIZE = 14;
    public static final int DEFAULT_TOAST_SHOW_TIME = 2;
    public static final int MAX_TEXT_SIZE = 18;
    public static final int MIN_DURATION = 3;
    public static final int MIN_TEXT_SIZE = 12;
    public static final float NORMAL_STATE_ALPHA = 1.0f;
    public static final float PRESS_STATE_ALPHA = 0.2f;
    public static final int TEMPLATE_A_MARGIN_BOTTOM_DP = 10;
    public static final int TEMPLATE_A_MARGIN_LEFT_DP = 5;
    public static final int TEMPLATE_A_MARGIN_NO_LEFT_VIEW_DP = 14;
    public static final int TEMPLATE_A_MARGIN_RIGHT_DP = 14;
    public static final int TEMPLATE_A_MARGIN_TOP_DP = 9;
    public static final int TEMPLATE_A_ONLY_TEXTVIEW_MAX_WIDTH = 200;
    public static final int TEMPLATE_B_MARGIN_LEFT_DP = 15;
    public static final int TEMPLATE_B_TEXTVIEW_MAX_WIDTH = 175;
    public static final int TOAST_LONG_TIME = 3;
    public static final int TOAST_SHORT_TIME = 2;
    public static final String WHITE_DAY = "#FFFFFF";
    public static final String WHITE_NIGHT = "#666666";
    public transient /* synthetic */ FieldHolder $fh;

    public ToastConstants() {
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
}
