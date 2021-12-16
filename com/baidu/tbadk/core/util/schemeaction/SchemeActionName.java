package com.baidu.tbadk.core.util.schemeaction;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SchemeActionName {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_ACTION_DEEPLINK = "tiebaapp://router/deeplink";
    public static final String SCHEME_ACTION_DOLINK = "tiebaapp://router/doLink";
    public transient /* synthetic */ FieldHolder $fh;

    public SchemeActionName() {
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
