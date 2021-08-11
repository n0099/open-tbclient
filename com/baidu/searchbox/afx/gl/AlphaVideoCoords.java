package com.baidu.searchbox.afx.gl;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlphaVideoCoords {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    public static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 28;
    public static final int TRIANGLE_VERTICES_DATA_UV_ALPHA_OFFSET = 3;
    public static final int TRIANGLE_VERTICES_DATA_UV_COLOR_OFFSET = 5;
    public static final float[] VERTICES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-880171732, "Lcom/baidu/searchbox/afx/gl/AlphaVideoCoords;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-880171732, "Lcom/baidu/searchbox/afx/gl/AlphaVideoCoords;");
                return;
            }
        }
        VERTICES = new float[]{-1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.0f};
    }

    public AlphaVideoCoords() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
