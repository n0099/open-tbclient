package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class InnerOverlay extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public Bundle c;
    public AppBaseMap mBaseMap;

    public boolean getDefaultShowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getLayerTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "default" : (String) invokeV.objValue;
    }

    public int getUpdateTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public InnerOverlay() {
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
        this.mBaseMap = null;
        this.b = null;
        this.c = null;
        this.a = true;
    }

    public boolean IsOverlayShow() {
        InterceptResult invokeV;
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mLayerID != 0 && (appBaseMap = this.mBaseMap) != null && appBaseMap.GetId() != 0 && this.mBaseMap.LayersIsShow(this.mLayerID)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public Bundle getParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (Bundle) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public InnerOverlay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBaseMap = null;
        this.b = null;
        this.c = null;
        this.a = true;
        setType(i);
    }

    public InnerOverlay(int i, AppBaseMap appBaseMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), appBaseMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mBaseMap = null;
        this.b = null;
        this.c = null;
        this.a = true;
        setType(i);
        this.mBaseMap = appBaseMap;
    }

    public void SetMapParam(long j, AppBaseMap appBaseMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, appBaseMap) == null) {
            this.mLayerID = j;
            this.mBaseMap = appBaseMap;
        }
    }

    public void setFocus(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            setFocus(i, z, null);
        }
    }

    public void SetOverlayShow(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            long j = 0;
            if (this.mLayerID != 0 && (appBaseMap = this.mBaseMap) != null && appBaseMap.GetId() != 0) {
                if (z.a) {
                    j = System.currentTimeMillis();
                }
                this.mBaseMap.ShowLayers(this.mLayerID, z);
                if (z.a) {
                    z.a("InnerOverlay", "ShowLayer:" + this.mLayerID + ":" + z + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
                }
            }
        }
    }

    public void UpdateOverlay() {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j = 0;
            if (this.mLayerID != 0 && (appBaseMap = this.mBaseMap) != null && appBaseMap.GetId() != 0) {
                if (z.a) {
                    j = System.currentTimeMillis();
                }
                this.mBaseMap.UpdateLayers(this.mLayerID);
                if (z.a) {
                    z.a("InnerOverlay", "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
                }
            }
        }
    }

    public void clear() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (z.a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            if (!TextUtils.isEmpty(this.b)) {
                this.b = null;
                AppBaseMap appBaseMap = this.mBaseMap;
                if (appBaseMap != null) {
                    appBaseMap.ClearLayer(this.mLayerID);
                }
            }
            if (z.a) {
                z.a("InnerOverlay", "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
            }
        }
    }

    public boolean addedToMapView() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AppBaseMap appBaseMap = this.mBaseMap;
            if (appBaseMap != null && appBaseMap.GetId() != 0) {
                if (z.a) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
                if (z.a) {
                    z.a("InnerOverlay", "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
                }
                long j2 = this.mLayerID;
                if (j2 != 0) {
                    this.mBaseMap.SetLayersClickable(j2, this.a);
                    SetOverlayShow(getDefaultShowStatus());
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setClickAble(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.a = z;
            AppBaseMap appBaseMap = this.mBaseMap;
            if (appBaseMap != null && appBaseMap.GetId() != 0) {
                long j = this.mLayerID;
                if (j != 0) {
                    this.mBaseMap.SetLayersClickable(j, z);
                }
            }
        }
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && str != null) {
            this.b = str;
        }
    }

    public void setParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            this.c = bundle;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mType = i;
        }
    }

    public void setFocus(int i, boolean z, String str) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), str}) == null) && (appBaseMap = this.mBaseMap) != null && appBaseMap.GetId() != 0) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("uid", str);
            }
            this.mBaseMap.SetFocus(this.mLayerID, i, z, bundle);
        }
    }
}
