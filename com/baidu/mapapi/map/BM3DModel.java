package com.baidu.mapapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class BM3DModel extends Overlay {
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
    public BM3DModelOptions.BM3DModelType l;

    public BM3DModel() {
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
        this.l = BM3DModelOptions.BM3DModelType.BM3DModelTypeObj;
        this.type = com.baidu.mapsdkplatform.comapi.map.i.m;
    }

    public BM3DModelOptions.BM3DModelType getBM3DModelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (BM3DModelOptions.BM3DModelType) invokeV.objValue;
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

    public boolean isZoomFixed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            if (!TextUtils.isEmpty(this.a)) {
                bundle.putString("modelPath", this.a);
                if (!TextUtils.isEmpty(this.b)) {
                    bundle.putString("modelName", this.b);
                    LatLng latLng = this.c;
                    if (latLng != null) {
                        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                        bundle.putInt("modelType", this.l.ordinal());
                        bundle.putFloat("scale", this.d);
                        bundle.putInt("zoomFixed", this.e ? 1 : 0);
                        bundle.putFloat("rotateX", this.f);
                        bundle.putFloat("rotateY", this.g);
                        bundle.putFloat("rotateZ", this.h);
                        bundle.putFloat("offsetX", this.i);
                        bundle.putFloat("offsetY", this.j);
                        bundle.putFloat("offsetZ", this.k);
                        return bundle;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
                }
                throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        return (Bundle) invokeL.objValue;
    }

    public void setBM3DModelType(BM3DModelOptions.BM3DModelType bM3DModelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bM3DModelType) == null) {
            this.l = bM3DModelType;
            this.listener.c(this);
        }
    }

    public void setModelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
        }
    }

    public void setModelPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, latLng) == null) {
            if (latLng != null) {
                this.c = latLng;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
        }
    }

    public void setScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
            this.d = f;
            this.listener.c(this);
        }
    }

    public void setZoomFixed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.e = z;
            this.listener.c(this);
        }
    }

    public void setOffset(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.i = f;
            this.j = f2;
            this.k = f3;
            this.listener.c(this);
        }
    }

    public void setRotate(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f = f;
            this.g = f2;
            this.h = f3;
            this.listener.c(this);
        }
    }
}
