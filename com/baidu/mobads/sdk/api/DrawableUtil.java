package com.baidu.mobads.sdk.api;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DrawableUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DrawableUtil() {
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

    public static Integer getDrawableId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("blur_bg_white".equals(str)) {
                return Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08022f);
            }
            if ("rsp_small_red_heart".equals(str)) {
                return Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080260);
            }
            if ("rsp_big_red_heart".equals(str)) {
                return Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08025f);
            }
            if ("cpu_drama_video".equals(str)) {
                return Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080561);
            }
            return null;
        }
        return (Integer) invokeL.objValue;
    }
}
