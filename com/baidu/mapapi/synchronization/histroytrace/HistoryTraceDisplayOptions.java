package com.baidu.mapapi.synchronization.histroytrace;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HistoryTraceDisplayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f41991a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f41992b;

    /* renamed from: c  reason: collision with root package name */
    public BitmapDescriptor f41993c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f41994d;

    /* renamed from: e  reason: collision with root package name */
    public int f41995e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41996f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41997g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41998h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41999i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f42000j;
    public int k;
    public int l;
    public int m;
    public int n;

    public HistoryTraceDisplayOptions() {
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
        this.f42000j = true;
        this.k = 30;
        this.l = 30;
        this.m = 30;
        this.n = 30;
        this.f41991a = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");
        this.f41992b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");
        this.f41993c = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");
        this.f41994d = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Gray_Arrow.png");
        this.f41995e = 22;
        this.f41996f = true;
        this.f41997g = true;
        this.f41998h = false;
        this.f41999i = true;
    }

    public BitmapDescriptor getCarIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41993c : (BitmapDescriptor) invokeV.objValue;
    }

    public BitmapDescriptor getEndPositionIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41992b : (BitmapDescriptor) invokeV.objValue;
    }

    public int getPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.intValue;
    }

    public int getPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
    }

    public int getPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : invokeV.intValue;
    }

    public int getPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public BitmapDescriptor getRouteLineTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41994d : (BitmapDescriptor) invokeV.objValue;
    }

    public int getRouteLineWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41995e : invokeV.intValue;
    }

    public BitmapDescriptor getStartPositionIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f41991a : (BitmapDescriptor) invokeV.objValue;
    }

    public boolean isRouteLineRenderBySubSection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f42000j : invokeV.booleanValue;
    }

    public boolean isShowCarIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f41998h : invokeV.booleanValue;
    }

    public boolean isShowEndPositionIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f41997g : invokeV.booleanValue;
    }

    public boolean isShowRoutePlan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f41999i : invokeV.booleanValue;
    }

    public boolean isShowStartPositionIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f41996f : invokeV.booleanValue;
    }

    public HistoryTraceDisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bitmapDescriptor)) == null) {
            this.f41993c = bitmapDescriptor;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeL.objValue;
    }

    public HistoryTraceDisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bitmapDescriptor)) == null) {
            this.f41992b = bitmapDescriptor;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeL.objValue;
    }

    public HistoryTraceDisplayOptions setPaddingBottom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.n = i2;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeI.objValue;
    }

    public HistoryTraceDisplayOptions setPaddingLeft(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.k = i2;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeI.objValue;
    }

    public HistoryTraceDisplayOptions setPaddingRight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.l = i2;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeI.objValue;
    }

    public HistoryTraceDisplayOptions setPaddingTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.m = i2;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeI.objValue;
    }

    public void setRouteLineRenderBySubSection(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f42000j = z;
        }
    }

    public HistoryTraceDisplayOptions setRouteLineTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bitmapDescriptor)) == null) {
            this.f41994d = bitmapDescriptor;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeL.objValue;
    }

    public HistoryTraceDisplayOptions setRouteLineWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            int i3 = 5;
            if (i2 >= 5) {
                i3 = 40;
                if (i2 <= 40) {
                    this.f41995e = i2;
                    return this;
                }
            }
            this.f41995e = i3;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeI.objValue;
    }

    public HistoryTraceDisplayOptions setShowCarIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            this.f41998h = z;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeZ.objValue;
    }

    public HistoryTraceDisplayOptions setShowEndPositionIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            this.f41997g = z;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeZ.objValue;
    }

    public HistoryTraceDisplayOptions setShowRoutePlan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            this.f41999i = z;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeZ.objValue;
    }

    public HistoryTraceDisplayOptions setShowStartPositionIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            this.f41996f = z;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeZ.objValue;
    }

    public HistoryTraceDisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, bitmapDescriptor)) == null) {
            this.f41991a = bitmapDescriptor;
            return this;
        }
        return (HistoryTraceDisplayOptions) invokeL.objValue;
    }
}
