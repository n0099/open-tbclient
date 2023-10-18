package com.badlogic.gdx.graphics.g3d.model.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class ModelMaterial$MaterialType {
    public static final /* synthetic */ ModelMaterial$MaterialType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ModelMaterial$MaterialType Lambert;
    public static final ModelMaterial$MaterialType Phong;
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
        Lambert = new ModelMaterial$MaterialType("Lambert", 0);
        ModelMaterial$MaterialType modelMaterial$MaterialType = new ModelMaterial$MaterialType("Phong", 1);
        Phong = modelMaterial$MaterialType;
        $VALUES = new ModelMaterial$MaterialType[]{Lambert, modelMaterial$MaterialType};
    }

    public ModelMaterial$MaterialType(String str, int i) {
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

    public static ModelMaterial$MaterialType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ModelMaterial$MaterialType) Enum.valueOf(ModelMaterial$MaterialType.class, str);
        }
        return (ModelMaterial$MaterialType) invokeL.objValue;
    }

    public static ModelMaterial$MaterialType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ModelMaterial$MaterialType[]) $VALUES.clone();
        }
        return (ModelMaterial$MaterialType[]) invokeV.objValue;
    }
}
