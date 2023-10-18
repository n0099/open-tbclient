package com.badlogic.gdx.graphics.glutils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class ETC1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-531216249, "Lcom/badlogic/gdx/graphics/glutils/ETC1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-531216249, "Lcom/badlogic/gdx/graphics/glutils/ETC1;");
        }
    }

    public static native void decodeImage(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4, int i5);

    public static native ByteBuffer encodeImage(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static native ByteBuffer encodeImagePKM(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static native void formatHeader(ByteBuffer byteBuffer, int i, int i2, int i3);

    public static native int getCompressedDataSize(int i, int i2);

    public static native int getHeightPKM(ByteBuffer byteBuffer, int i);

    public static native int getWidthPKM(ByteBuffer byteBuffer, int i);

    public static native boolean isValidPKM(ByteBuffer byteBuffer, int i);

    public ETC1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
