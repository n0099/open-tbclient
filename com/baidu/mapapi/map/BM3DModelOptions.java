package com.baidu.mapapi.map;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class BM3DModelOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public LatLng c;
    public float d;
    public boolean e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public boolean l;
    public BM3DModelType m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BM3DModelType {
        public static /* synthetic */ Interceptable $ic;
        public static final BM3DModelType BM3DModelTypeObj;
        public static final BM3DModelType BM3DModelTypeglTF;
        public static final /* synthetic */ BM3DModelType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(570573297, "Lcom/baidu/mapapi/map/BM3DModelOptions$BM3DModelType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(570573297, "Lcom/baidu/mapapi/map/BM3DModelOptions$BM3DModelType;");
                    return;
                }
            }
            BM3DModelTypeObj = new BM3DModelType("BM3DModelTypeObj", 0);
            BM3DModelType bM3DModelType = new BM3DModelType("BM3DModelTypeglTF", 1);
            BM3DModelTypeglTF = bM3DModelType;
            a = new BM3DModelType[]{BM3DModelTypeObj, bM3DModelType};
        }

        public BM3DModelType(String str, int i) {
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

        public static BM3DModelType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BM3DModelType) Enum.valueOf(BM3DModelType.class, str);
            }
            return (BM3DModelType) invokeL.objValue;
        }

        public static BM3DModelType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BM3DModelType[]) a.clone();
            }
            return (BM3DModelType[]) invokeV.objValue;
        }
    }

    public BM3DModelOptions() {
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
        this.d = 1.0f;
        this.e = false;
        this.l = true;
        this.m = BM3DModelType.BM3DModelTypeObj;
    }

    public BM3DModelType getBM3DModelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return (BM3DModelType) invokeV.objValue;
    }

    public String getModelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String getModelPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public float getOffsetX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.floatValue;
    }

    public float getOffsetY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.floatValue;
    }

    public float getOffsetZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k;
        }
        return invokeV.floatValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (LatLng) invokeV.objValue;
    }

    public float getRotateX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public float getRotateY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return invokeV.floatValue;
    }

    public float getRotateZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return invokeV.floatValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return invokeV.floatValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public boolean isZoomFixed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BM3DModel bM3DModel = new BM3DModel();
            if (!TextUtils.isEmpty(this.a)) {
                bM3DModel.a = this.a;
                if (!TextUtils.isEmpty(this.b)) {
                    bM3DModel.b = this.b;
                    LatLng latLng = this.c;
                    if (latLng != null) {
                        bM3DModel.c = latLng;
                        bM3DModel.d = this.d;
                        bM3DModel.e = this.e;
                        bM3DModel.f = this.f;
                        bM3DModel.g = this.g;
                        bM3DModel.h = this.h;
                        bM3DModel.i = this.i;
                        bM3DModel.j = this.j;
                        bM3DModel.k = this.k;
                        bM3DModel.H = this.l;
                        bM3DModel.l = this.m;
                        return bM3DModel;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
                }
                throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        return (Overlay) invokeV.objValue;
    }

    public BM3DModelOptions setBM3DModelType(BM3DModelType bM3DModelType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bM3DModelType)) == null) {
            this.m = bM3DModelType;
            return this;
        }
        return (BM3DModelOptions) invokeL.objValue;
    }

    public BM3DModelOptions setModelName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
        }
        return (BM3DModelOptions) invokeL.objValue;
    }

    public BM3DModelOptions setModelPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        return (BM3DModelOptions) invokeL.objValue;
    }

    public BM3DModelOptions setPosition(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, latLng)) == null) {
            if (latLng != null) {
                this.c = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
        }
        return (BM3DModelOptions) invokeL.objValue;
    }

    public BM3DModelOptions setScale(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048596, this, f)) == null) {
            this.d = f;
            return this;
        }
        return (BM3DModelOptions) invokeF.objValue;
    }

    public BM3DModelOptions setZoomFixed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            this.e = z;
            return this;
        }
        return (BM3DModelOptions) invokeZ.objValue;
    }

    public BM3DModelOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (BM3DModelOptions) invokeZ.objValue;
    }

    public BM3DModelOptions setOffset(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.i = f;
            this.j = f2;
            this.k = f3;
            return this;
        }
        return (BM3DModelOptions) invokeCommon.objValue;
    }

    public BM3DModelOptions setRotate(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.f = f;
            this.g = f2;
            this.h = f3;
            return this;
        }
        return (BM3DModelOptions) invokeCommon.objValue;
    }
}
