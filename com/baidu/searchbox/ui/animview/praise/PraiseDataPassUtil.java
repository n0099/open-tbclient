package com.baidu.searchbox.ui.animview.praise;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PraiseDataPassUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_PRAISE_EVENT = "com.baidu.channel.praise.event";
    public static final String KEY_FROM = "from";
    public static final String KEY_FROM_OS = "android";
    public static final String KEY_PRAISE_ID = "id";
    public static final String KEY_TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;

    public PraiseDataPassUtil() {
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
