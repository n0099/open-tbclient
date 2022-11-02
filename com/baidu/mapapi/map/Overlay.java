package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String F;
    public int G;
    public boolean H;
    public Bundle I;
    public a listener;
    public com.baidu.mapsdkplatform.comapi.map.i type;

    /* loaded from: classes2.dex */
    public interface a {
        LatLngBounds a(Overlay overlay);

        void b(Overlay overlay);

        void c(Overlay overlay);

        boolean d(Overlay overlay);
    }

    public Overlay() {
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
        this.F = System.currentTimeMillis() + "_" + hashCode();
    }

    public static void a(int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i, bundle) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
            bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
            bundle2.putFloat("blue", (i & 255) / 255.0f);
            bundle2.putFloat(Key.ALPHA, (i >>> 24) / 255.0f);
            bundle.putBundle("color", bundle2);
        }
    }

    public static void b(int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, bundle) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
            bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
            bundle2.putFloat("blue", (i & 255) / 255.0f);
            bundle2.putFloat(Key.ALPHA, (i >>> 24) / 255.0f);
            bundle.putBundle("m_topFaceColor", bundle2);
        }
    }

    public static void c(int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, bundle) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
            bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
            bundle2.putFloat("blue", (i & 255) / 255.0f);
            bundle2.putFloat(Key.ALPHA, (i >>> 24) / 255.0f);
            bundle.putBundle("m_sideFaceColor", bundle2);
        }
    }

    public static void a(List<LatLng> list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, list, bundle) == null) {
            int size = list.size();
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            for (int i = 0; i < size; i++) {
                GeoPoint ll2mc = CoordUtil.ll2mc(list.get(i));
                dArr[i] = ll2mc.getLongitudeE6();
                dArr2[i] = ll2mc.getLatitudeE6();
            }
            bundle.putDoubleArray("x_array", dArr);
            bundle.putDoubleArray("y_array", dArr2);
        }
    }

    public static boolean b(List<HoleOptions> list, Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, bundle)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (HoleOptions holeOptions : list) {
                if (holeOptions instanceof CircleHoleOptions) {
                    arrayList.add((CircleHoleOptions) holeOptions);
                } else if (holeOptions instanceof PolygonHoleOptions) {
                    arrayList2.add((PolygonHoleOptions) holeOptions);
                }
            }
            if (arrayList.size() != 0) {
                z = c(arrayList, bundle);
                bundle.putInt("has_circle_hole", z ? 1 : 0);
            } else {
                bundle.putInt("has_circle_hole", 0);
                z = false;
            }
            if (arrayList2.size() != 0) {
                z2 = d(arrayList2, bundle);
                bundle.putInt("has_polygon_hole", z2 ? 1 : 0);
            } else {
                bundle.putInt("has_polygon_hole", 0);
                z2 = false;
            }
            if (!z && !z2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(List<PolygonHoleOptions> list, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, bundle)) == null) {
            int size = list.size();
            int[] iArr = new int[size];
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                List<LatLng> holePoints = list.get(i).getHolePoints();
                if (holePoints == null) {
                    return false;
                }
                arrayList.addAll(holePoints);
                iArr[i] = holePoints.size();
            }
            int size2 = arrayList.size();
            if (size2 == 0) {
                return false;
            }
            bundle.putIntArray("polygon_hole_count_array", iArr);
            double[] dArr = new double[size2];
            double[] dArr2 = new double[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(i2));
                dArr[i2] = ll2mc.getLongitudeE6();
                dArr2[i2] = ll2mc.getLatitudeE6();
            }
            bundle.putDoubleArray("polygon_hole_x_array", dArr);
            bundle.putDoubleArray("polygon_hole_y_array", dArr2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(List<CircleHoleOptions> list, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, list, bundle)) == null) {
            int size = list.size();
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                LatLng holeCenter = list.get(i).getHoleCenter();
                int holeRadius = list.get(i).getHoleRadius();
                if (holeCenter == null || holeRadius <= 0) {
                    return false;
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(holeCenter);
                dArr[i] = ll2mc.getLongitudeE6();
                dArr2[i] = ll2mc.getLatitudeE6();
                iArr[i] = holeRadius;
            }
            bundle.putDoubleArray("circle_hole_x_array", dArr);
            bundle.putDoubleArray("circle_hole_y_array", dArr2);
            bundle.putIntArray("circle_hole_radius_array", iArr);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("id", this.F);
            bundle.putInt("type", this.type.ordinal());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.I;
        }
        return (Bundle) invokeV.objValue;
    }

    public LatLngBounds getOverlayLatLngBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.listener.a(this);
        }
        return (LatLngBounds) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G;
        }
        return invokeV.intValue;
    }

    public boolean isRemoved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.listener.d(this);
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.listener.b(this);
        }
    }

    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            bundle.putString("id", this.F);
            bundle.putInt("type", this.type.ordinal());
            bundle.putInt("visibility", this.H ? 1 : 0);
            bundle.putInt("z_index", this.G);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void setExtraInfo(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            this.I = bundle;
        }
    }

    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.H = z;
            this.listener.c(this);
        }
    }

    public void setZIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.G = i;
            this.listener.c(this);
        }
    }
}
