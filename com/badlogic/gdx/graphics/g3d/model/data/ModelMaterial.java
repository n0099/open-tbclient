package com.badlogic.gdx.graphics.g3d.model.data;

import c.b.b.n.a;
import c.b.b.n.l.g.g.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ModelMaterial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public a f31977b;

    /* renamed from: c  reason: collision with root package name */
    public a f31978c;

    /* renamed from: d  reason: collision with root package name */
    public a f31979d;

    /* renamed from: e  reason: collision with root package name */
    public a f31980e;

    /* renamed from: f  reason: collision with root package name */
    public a f31981f;

    /* renamed from: g  reason: collision with root package name */
    public float f31982g;

    /* renamed from: h  reason: collision with root package name */
    public float f31983h;

    /* renamed from: i  reason: collision with root package name */
    public c.b.b.q.a<i> f31984i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

        public MaterialType(String str, int i2) {
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

        public static MaterialType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaterialType) Enum.valueOf(MaterialType.class, str) : (MaterialType) invokeL.objValue;
        }

        public static MaterialType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaterialType[]) $VALUES.clone() : (MaterialType[]) invokeV.objValue;
        }
    }

    public ModelMaterial() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31983h = 1.0f;
    }
}
