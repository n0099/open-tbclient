package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.GradientLineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class GradientLine extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<LatLng> a;
    public int[] b;
    public int[] c;
    public int d;
    public GradientLineOptions.LineDirectionCross180 e;

    public GradientLine() {
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
        this.d = 5;
        this.e = GradientLineOptions.LineDirectionCross180.NONE;
        this.type = com.baidu.mapsdkplatform.comapi.map.i.n;
    }

    public int[] getColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (int[]) invokeV.objValue;
    }

    public int[] getIndexs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (int[]) invokeV.objValue;
    }

    public GradientLineOptions.LineDirectionCross180 getLineDirectionCross180() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (GradientLineOptions.LineDirectionCross180) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public float getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.floatValue;
    }

    public static void a(List<LatLng> list, GradientLineOptions.LineDirectionCross180 lineDirectionCross180, Bundle bundle) {
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, lineDirectionCross180, bundle) == null) {
            int size = list.size();
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            for (int i = 0; i < size; i++) {
                LatLng latLng2 = list.get(i);
                if (lineDirectionCross180 == GradientLineOptions.LineDirectionCross180.FROM_EAST_TO_WEST && latLng2.longitude < 0.0d) {
                    latLng = new LatLng(latLng2.latitude, latLng2.longitude + 360.0d);
                    bundle.putInt("lineDirectionCross180", GradientLineOptions.LineDirectionCross180.FROM_EAST_TO_WEST.ordinal());
                } else if (lineDirectionCross180 == GradientLineOptions.LineDirectionCross180.FROM_WEST_TO_EAST && latLng2.longitude > 0.0d) {
                    latLng = new LatLng(latLng2.latitude, latLng2.longitude - 360.0d);
                    bundle.putInt("lineDirectionCross180", GradientLineOptions.LineDirectionCross180.FROM_WEST_TO_EAST.ordinal());
                } else {
                    bundle.putInt("lineDirectionCross180", GradientLineOptions.LineDirectionCross180.NONE.ordinal());
                    GeoPoint ll2mc = CoordUtil.ll2mc(latLng2);
                    dArr[i] = ll2mc.getLongitudeE6();
                    dArr2[i] = ll2mc.getLatitudeE6();
                }
                latLng2 = latLng;
                GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
                dArr[i] = ll2mc2.getLongitudeE6();
                dArr2[i] = ll2mc2.getLatitudeE6();
            }
            bundle.putDoubleArray("x_array", dArr);
            bundle.putDoubleArray("y_array", dArr2);
        }
    }

    public static void a(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, iArr, bundle) == null) && iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_indexs", iArr);
        }
    }

    public static void b(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, iArr, bundle) == null) && iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_array", iArr);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            List<LatLng> list = this.a;
            if (list != null && list.size() >= 2) {
                GeoPoint ll2mc = CoordUtil.ll2mc(this.a.get(0));
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                bundle.putInt("width", this.d);
                int[] iArr = this.b;
                if (iArr != null) {
                    if (iArr.length != 0) {
                        a(this.a, this.e, bundle);
                        a(this.b, bundle);
                        int[] iArr2 = this.c;
                        if (iArr2 != null) {
                            if (iArr2.length != 0) {
                                b(iArr2, bundle);
                                return bundle;
                            }
                            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
                        }
                        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
                    }
                    throw new IllegalStateException("BDMapSDKException: Indexs array size can not be Equal to zero");
                }
                throw new IllegalStateException("BDMapSDKException: Indexs array can not be null");
            }
            throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
        }
        return (Bundle) invokeL.objValue;
    }

    public void lineDirectionCross180(GradientLineOptions.LineDirectionCross180 lineDirectionCross180) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lineDirectionCross180) == null) {
            this.e = lineDirectionCross180;
        }
    }

    public void setColorIndex(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                this.b = iArr;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
    }

    public void setColorList(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                this.c = iArr;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && i > 0) {
            this.d = i;
            this.listener.c(this);
        }
    }

    public void setPoints(List<LatLng> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null) {
                if (list.size() >= 2) {
                    if (!list.contains(null)) {
                        this.a = list;
                        this.listener.c(this);
                        return;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
    }
}
