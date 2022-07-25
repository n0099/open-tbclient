package com.badlogic.gdx.graphics;

import com.badlogic.gdx.graphics.Pixmap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j3;
import com.repackage.p3;
import com.repackage.p5;
import com.repackage.q5;
import com.repackage.v5;
/* loaded from: classes.dex */
public interface TextureData {

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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextureDataType) Enum.valueOf(TextureDataType.class, str) : (TextureDataType) invokeL.objValue;
        }

        public static TextureDataType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextureDataType[]) $VALUES.clone() : (TextureDataType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static TextureData a(j3 j3Var, Pixmap.Format format, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, j3Var, format, z)) == null) {
                if (j3Var == null) {
                    return null;
                }
                if (j3Var.g().endsWith(".cim")) {
                    return new q5(j3Var, p3.a(j3Var), format, z);
                }
                if (j3Var.g().endsWith(".etc1")) {
                    return new p5(j3Var, z);
                }
                if (!j3Var.g().endsWith(".ktx") && !j3Var.g().endsWith(".zktx")) {
                    return new q5(j3Var, new Pixmap(j3Var), format, z);
                }
                return new v5(j3Var, z);
            }
            return (TextureData) invokeLLZ.objValue;
        }
    }

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
}
