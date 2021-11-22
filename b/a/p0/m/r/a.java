package b.a.p0.m.r;

import android.graphics.Color;
import android.os.Bundle;
import b.a.p0.a.k;
import b.a.p0.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f11678i;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public DrivingRouteLine f11679h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721802463, "Lb/a/p0/m/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721802463, "Lb/a/p0/m/r/a;");
                return;
            }
        }
        f11678i = k.f6863a;
        j = Color.argb(178, 0, 78, 255);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BaiduMap baiduMap) {
        super(baiduMap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BaiduMap) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11679h = null;
    }

    @Override // b.a.p0.m.r.c
    public final List<OverlayOptions> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f11679h == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<DrivingRouteLine.DrivingStep> allStep = this.f11679h.getAllStep();
            if (allStep != null && allStep.size() > 0) {
                for (DrivingRouteLine.DrivingStep drivingStep : allStep) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("index", allStep.indexOf(drivingStep));
                    if (drivingStep.getEntrance() != null) {
                        arrayList.add(new MarkerOptions().position(drivingStep.getEntrance().getLocation()).anchor(0.5f, 0.5f).zIndex(10).rotate(360 - drivingStep.getDirection()).extraInfo(bundle).icon(BitmapDescriptorFactory.fromResource(e.aiapps_icon_line_node)));
                    }
                    if (allStep.indexOf(drivingStep) == allStep.size() - 1 && drivingStep.getExit() != null) {
                        arrayList.add(new MarkerOptions().position(drivingStep.getExit().getLocation()).anchor(0.5f, 0.5f).zIndex(10).icon(BitmapDescriptorFactory.fromResource(e.aiapps_icon_line_node)));
                    }
                }
            }
            if (allStep != null && allStep.size() > 0) {
                int size = allStep.size();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    List<LatLng> wayPoints = allStep.get(i2).getWayPoints();
                    if (i2 == size - 1) {
                        arrayList2.addAll(wayPoints);
                    } else {
                        arrayList2.addAll(wayPoints.subList(0, wayPoints.size() - 1));
                    }
                    wayPoints.size();
                    int[] trafficList = allStep.get(i2).getTrafficList();
                    if (trafficList != null && trafficList.length > 0) {
                        for (int i3 : trafficList) {
                            arrayList3.add(Integer.valueOf(i3));
                        }
                    }
                }
                boolean z = arrayList3.size() > 0;
                PolylineOptions zIndex = new PolylineOptions().points(arrayList2).textureIndex(arrayList3).width(14).dottedLine(z).focus(true).color(f() != 0 ? f() : j).zIndex(0);
                if (z) {
                    zIndex.customTextureList(e());
                }
                arrayList.add(zIndex);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<BitmapDescriptor> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_blue_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_green_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_yellow_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_red_arrow.png"));
            arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_nofocus.png"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public abstract int f();

    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f11679h.getAllStep() == null || this.f11679h.getAllStep().get(i2) == null) {
                return false;
            }
            boolean z = f11678i;
            return false;
        }
        return invokeI.booleanValue;
    }

    public void h(DrivingRouteLine drivingRouteLine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drivingRouteLine) == null) {
            this.f11679h = drivingRouteLine;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            for (Overlay overlay : this.f11682g) {
                if (overlay instanceof Polyline) {
                    ((Polyline) overlay).setFocus(z);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public final boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, marker)) == null) {
            for (Overlay overlay : this.f11682g) {
                if ((overlay instanceof Marker) && overlay.equals(marker) && marker.getExtraInfo() != null) {
                    g(marker.getExtraInfo().getInt("index"));
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnPolylineClickListener
    public boolean onPolylineClick(Polyline polyline) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, polyline)) == null) {
            Iterator<Overlay> it = this.f11682g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Overlay next = it.next();
                if ((next instanceof Polyline) && next.equals(polyline)) {
                    z = true;
                    break;
                }
            }
            i(z);
            return true;
        }
        return invokeL.booleanValue;
    }
}
