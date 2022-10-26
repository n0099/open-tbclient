package com.badlogic.gdx.graphics.g2d;

import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class PixmapPackerIO$ImageFormat {
    public static final /* synthetic */ PixmapPackerIO$ImageFormat[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PixmapPackerIO$ImageFormat CIM;
    public static final PixmapPackerIO$ImageFormat PNG;
    public transient /* synthetic */ FieldHolder $fh;
    public final String extension;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1568417990, "Lcom/badlogic/gdx/graphics/g2d/PixmapPackerIO$ImageFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1568417990, "Lcom/badlogic/gdx/graphics/g2d/PixmapPackerIO$ImageFormat;");
                return;
            }
        }
        CIM = new PixmapPackerIO$ImageFormat("CIM", 0, ".cim");
        PixmapPackerIO$ImageFormat pixmapPackerIO$ImageFormat = new PixmapPackerIO$ImageFormat("PNG", 1, EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
        PNG = pixmapPackerIO$ImageFormat;
        $VALUES = new PixmapPackerIO$ImageFormat[]{CIM, pixmapPackerIO$ImageFormat};
    }

    public PixmapPackerIO$ImageFormat(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.extension = str2;
    }

    public static PixmapPackerIO$ImageFormat valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PixmapPackerIO$ImageFormat) Enum.valueOf(PixmapPackerIO$ImageFormat.class, str);
        }
        return (PixmapPackerIO$ImageFormat) invokeL.objValue;
    }

    public static PixmapPackerIO$ImageFormat[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PixmapPackerIO$ImageFormat[]) $VALUES.clone();
        }
        return (PixmapPackerIO$ImageFormat[]) invokeV.objValue;
    }

    public String getExtension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.extension;
        }
        return (String) invokeV.objValue;
    }
}
