package com.baidu.searchbox.live.data.constant;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MixTagConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENTER_ROOM = "MixLiveCell_fake_list";
    public static final String MIX_ACT = "MixLiveCell_fake_act";
    public static final String MIX_BASE_LIVE = "MixLiveCell_fake_base";
    public static final String MIX_LIST = "MixLiveCell_fake_list";
    public static final String MIX_MEDIA_LIVE = "MixLiveCell_fake_media";
    public static final String MIX_PAGER = "MixLiveCell_fake_pager";
    public static final String MIX_REAL_ACT = "MixLiveCell_real_act";
    public static final String MIX_YY_LIVE = "MixLiveCell_fake_yy";
    public transient /* synthetic */ FieldHolder $fh;

    public MixTagConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
