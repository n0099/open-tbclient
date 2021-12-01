package com.badlogic.gdx.graphics;

import c.b.b.n.f;
import c.b.b.n.m.b;
import c.b.b.n.m.g;
import com.badlogic.gdx.graphics.Pixmap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface TextureData {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

        public TextureDataType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextureDataType) Enum.valueOf(TextureDataType.class, str) : (TextureDataType) invokeL.objValue;
        }

        public static TextureDataType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextureDataType[]) $VALUES.clone() : (TextureDataType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static TextureData a(c.b.b.m.a aVar, Pixmap.Format format, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, aVar, format, z)) == null) {
                if (aVar == null) {
                    return null;
                }
                if (aVar.g().endsWith(".cim")) {
                    return new b(aVar, f.a(aVar), format, z);
                }
                if (aVar.g().endsWith(".etc1")) {
                    return new c.b.b.n.m.a(aVar, z);
                }
                if (!aVar.g().endsWith(".ktx") && !aVar.g().endsWith(".zktx")) {
                    return new b(aVar, new Pixmap(aVar), format, z);
                }
                return new g(aVar, z);
            }
            return (TextureData) invokeLLZ.objValue;
        }
    }

    boolean a();

    boolean b();

    void c(int i2);

    Pixmap d();

    Pixmap.Format e();

    boolean g();

    int getHeight();

    TextureDataType getType();

    int getWidth();

    boolean h();

    void prepare();
}
