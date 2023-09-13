package com.badlogic.gdx.graphics.g3d.model.data;

import com.baidu.tieba.e3;
import com.baidu.tieba.u6;
import com.baidu.tieba.w4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ModelMaterial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public e3 b;
    public e3 c;
    public e3 d;
    public e3 e;
    public e3 f;
    public float g;
    public float h;
    public u6<w4> i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class MaterialType {
        public static final /* synthetic */ MaterialType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaterialType Lambert;
        public static final MaterialType Phong;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(380310418, "Lcom/badlogic/gdx/graphics/g3d/model/data/ModelMaterial$MaterialType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(380310418, "Lcom/badlogic/gdx/graphics/g3d/model/data/ModelMaterial$MaterialType;");
                    return;
                }
            }
            Lambert = new MaterialType("Lambert", 0);
            MaterialType materialType = new MaterialType("Phong", 1);
            Phong = materialType;
            $VALUES = new MaterialType[]{Lambert, materialType};
        }

        public MaterialType(String str, int i) {
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

        public static MaterialType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MaterialType) Enum.valueOf(MaterialType.class, str);
            }
            return (MaterialType) invokeL.objValue;
        }

        public static MaterialType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MaterialType[]) $VALUES.clone();
            }
            return (MaterialType[]) invokeV.objValue;
        }
    }

    public ModelMaterial() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 1.0f;
    }
}
