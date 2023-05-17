package com.badlogic.gdx.graphics;

import com.badlogic.gdx.graphics.Pixmap;
import com.baidu.tieba.d3;
import com.baidu.tieba.d5;
import com.baidu.tieba.e5;
import com.baidu.tieba.j5;
import com.baidu.tieba.x2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface TextureData {
    boolean a();

    void b(int i);

    Pixmap c();

    Pixmap.Format d();

    boolean f();

    boolean g();

    int getHeight();

    TextureDataType getType();

    int getWidth();

    boolean isPrepared();

    void prepare();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class TextureDataType {
        public static final /* synthetic */ TextureDataType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TextureDataType Custom;
        public static final TextureDataType Pixmap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1884650287, "Lcom/badlogic/gdx/graphics/TextureData$TextureDataType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1884650287, "Lcom/badlogic/gdx/graphics/TextureData$TextureDataType;");
                    return;
                }
            }
            Pixmap = new TextureDataType("Pixmap", 0);
            TextureDataType textureDataType = new TextureDataType("Custom", 1);
            Custom = textureDataType;
            $VALUES = new TextureDataType[]{Pixmap, textureDataType};
        }

        public TextureDataType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TextureDataType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TextureDataType) Enum.valueOf(TextureDataType.class, str);
            }
            return (TextureDataType) invokeL.objValue;
        }

        public static TextureDataType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TextureDataType[]) $VALUES.clone();
            }
            return (TextureDataType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static TextureData a(x2 x2Var, Pixmap.Format format, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, x2Var, format, z)) == null) {
                if (x2Var == null) {
                    return null;
                }
                if (x2Var.g().endsWith(".cim")) {
                    return new e5(x2Var, d3.a(x2Var), format, z);
                }
                if (x2Var.g().endsWith(".etc1")) {
                    return new d5(x2Var, z);
                }
                if (!x2Var.g().endsWith(".ktx") && !x2Var.g().endsWith(".zktx")) {
                    return new e5(x2Var, new Pixmap(x2Var), format, z);
                }
                return new j5(x2Var, z);
            }
            return (TextureData) invokeLLZ.objValue;
        }
    }
}
