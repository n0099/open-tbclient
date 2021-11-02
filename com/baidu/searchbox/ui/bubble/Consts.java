package com.baidu.searchbox.ui.bubble;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class Consts {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ANIMATION_OFFSET = 11.0f;
    public static final int AUTO_DISMISS_INTERVAL = 7000;
    public static final float BUBBLE_BETWEEN_PADDING = 2.0f;
    public static final float BUBBLE_SCREEN_PADDING = 15.0f;
    public static final float BUBBLE_SCREEN_PADDING_D20 = 0.0f;
    public static final int DEFAULT_BG_COLOR = -1;
    public static final String DEFAULT_DAY_BG_COLOR = "#CC000000";
    public static final String DEFAULT_DAY_TEXT_COLOR = "#FFFFFF";
    public static final String DEFAULT_NIGHT_BG_COLOR = "#CC000000";
    public static final String DEFAULT_NIGHT_TEXT_COLOR = "#666666";
    public static final int DEFAULT_TEXT_COLOR = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public Consts() {
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
