package com.airbnb.lottie.parser.moshi;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class JsonScope {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLOSED = 8;
    public static final int DANGLING_NAME = 4;
    public static final int EMPTY_ARRAY = 1;
    public static final int EMPTY_DOCUMENT = 6;
    public static final int EMPTY_OBJECT = 3;
    public static final int NONEMPTY_ARRAY = 2;
    public static final int NONEMPTY_DOCUMENT = 7;
    public static final int NONEMPTY_OBJECT = 5;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonScope() {
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

    public static String getPath(int i2, int[] iArr, String[] strArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), iArr, strArr, iArr2})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('$');
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = iArr[i3];
                if (i4 == 1 || i4 == 2) {
                    sb.append('[');
                    sb.append(iArr2[i3]);
                    sb.append(']');
                } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                    sb.append(IStringUtil.EXTENSION_SEPARATOR);
                    if (strArr[i3] != null) {
                        sb.append(strArr[i3]);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
