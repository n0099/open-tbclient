package com.baidu.tbadk.core.elementsMaven;

import android.text.TextUtils;
import com.baidu.tieba.su4;
import com.baidu.tieba.v76;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getIdByABTest(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
            String o = su4.o(i);
            if (TextUtils.isEmpty(o)) {
                return 0;
            }
            String a = v76.a(o);
            if (TextUtils.isEmpty(a)) {
                return 0;
            }
            return su4.s(a, str);
        }
        return invokeIL.intValue;
    }

    private boolean testMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
