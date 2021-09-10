package com.baidu.tbadk.core.elementsMaven;

import android.text.TextUtils;
import c.a.q0.s.u.a;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EMABTest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_ARRAY = "array";
    public static final String TYPE_COLOR = "color";
    public static final String TYPE_DIMEN = "dimen";
    public static final String TYPE_STRING = "string";
    public transient /* synthetic */ FieldHolder $fh;

    public EMABTest() {
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

    public static int getIdByABTest(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
            String q = a.q(i2);
            if (TextUtils.isEmpty(q)) {
                return 0;
            }
            String a2 = c.a.r0.l0.a.a(q);
            if (TextUtils.isEmpty(a2)) {
                return 0;
            }
            return a.u(a2, str);
        }
        return invokeIL.intValue;
    }

    public static boolean isAbNightColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? TbSingleton.getInstance().isAbNightModeColor() : invokeV.booleanValue;
    }

    private boolean testMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
