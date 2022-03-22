package com.baidu.pass.face.platform;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ConstPath {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ALIGN = "align";
    public static final String KEY_BLUR = "blur";
    public static final String KEY_DETECT = "detect";
    public static final String KEY_EYES = "eyes";
    public static final String KEY_KEY = "key";
    public static final String KEY_MOUTH = "mouth";
    public static final String KEY_OCCLU = "occlu";
    public transient /* synthetic */ FieldHolder $fh;

    public ConstPath() {
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
