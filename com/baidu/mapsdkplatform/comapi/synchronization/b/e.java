package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceDisplayOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class e extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static OnHistoryTraceListener b;
    public transient /* synthetic */ FieldHolder $fh;
    public HistoryTraceDisplayOptions c;
    public BaiduMap d;
    public int e;
    public Marker f;
    public Marker g;
    public Marker h;
    public List i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-879695048, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-879695048, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/e;");
                return;
            }
        }
        a = e.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new CopyOnWriteArrayList();
    }

    private void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, str) == null) {
            OnHistoryTraceListener onHistoryTraceListener = b;
            if (onHistoryTraceListener == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "OnHistoryTraceListener is null");
            } else {
                onHistoryTraceListener.onRenderHistroyTrace(i, str);
            }
        }
    }

    private void a(BitmapDescriptor bitmapDescriptor, int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, this, bitmapDescriptor, i, list) == null) {
            List b2 = b(list);
            if (b2 == null || b2.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Calculate sub section points error");
                return;
            }
            b();
            for (int i2 = 0; i2 < b2.size(); i2++) {
                List list2 = (List) b2.get(i2);
                if (list2 != null && !list2.isEmpty()) {
                    if (list2.size() < 2) {
                        String str = a;
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Error points list, index = " + i2);
                    } else {
                        a((Polyline) this.d.addOverlay(new PolylineOptions().width(i).points(list2).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4)));
                    }
                }
            }
        }
    }

    private void a(Polyline polyline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, polyline) == null) {
            this.i.add(polyline);
        }
    }

    private void a(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, latLng) == null) {
            if (!this.c.isShowStartPositionIcon()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not render start point marker");
            } else if (latLng == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Start point is null");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_NULL, "History trace end point is null, can't render start point marker");
            } else {
                BitmapDescriptor startPositionIcon = this.c.getStartPositionIcon();
                if (startPositionIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no startPositionIcon");
                    a(100019, "History trace end point icon is null, can't render start point marker");
                    return;
                }
                this.f = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(startPositionIcon).zIndex(5));
            }
        }
    }

    private void a(HistoryTraceData historyTraceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, historyTraceData) == null) {
            if (5 != this.e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Current order state not the complete state, render forbidden");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
                return;
            }
            BaiduMap baiduMap = this.d;
            if (baiduMap == null) {
                a(10007, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
                return;
            }
            baiduMap.clear();
            if (this.c == null) {
                a(100015, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_DISPLAY_OPTIONS_NULL);
                this.c = new HistoryTraceDisplayOptions();
            }
            a(historyTraceData.getOrderStartPosition());
            b(historyTraceData.getOrderEndPosition());
            List pointsList = historyTraceData.getPointsList();
            if (pointsList != null && !pointsList.isEmpty()) {
                c(((HistoryTraceData.HistoryTracePoint) pointsList.get(0)).getPoint());
            }
            a(pointsList);
            c();
        }
    }

    private void a(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, list) == null) {
            if (!this.c.isShowRoutePlan()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not render route polyline");
            } else if (list == null || list.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no points data");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_NULL);
            } else if (list.size() < 2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "History trace points less than 2, can't render polyline");
                a(100017, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_LESS);
            } else {
                BitmapDescriptor routeLineTexture = this.c.getRouteLineTexture();
                if (routeLineTexture == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route polyline texture is null");
                    a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_ROUTE_TEXTURE_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_ROUTE_TEXTURE_NULL);
                    return;
                }
                int routeLineWidth = this.c.getRouteLineWidth();
                if (this.c.isRouteLineRenderBySubSection()) {
                    b(routeLineTexture, routeLineWidth, list);
                } else {
                    a(routeLineTexture, routeLineWidth, list);
                }
            }
        }
    }

    private List b(List list) {
        InterceptResult invokeL;
        String str;
        String str2;
        HistoryTraceData.HistoryTracePoint historyTracePoint;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                str = a;
                str2 = "History trace point list is null";
            } else if (list.size() >= 2) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size() - 1; i++) {
                    HistoryTraceData.HistoryTracePoint historyTracePoint2 = (HistoryTraceData.HistoryTracePoint) list.get(i);
                    if (historyTracePoint2 != null && (historyTracePoint = (HistoryTraceData.HistoryTracePoint) list.get(i + 1)) != null) {
                        arrayList.add(historyTracePoint2.getPoint());
                        if (historyTracePoint.getLocationTime() - historyTracePoint2.getLocationTime() > 300) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(arrayList);
                            copyOnWriteArrayList.add(arrayList2);
                            arrayList.clear();
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    arrayList.add(((HistoryTraceData.HistoryTracePoint) list.get(list.size() - 1)).getPoint());
                    copyOnWriteArrayList.add(arrayList);
                }
                return copyOnWriteArrayList;
            } else {
                str = a;
                str2 = "History trace point list size is less than 2, can't render polyline";
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
            return null;
        }
        return (List) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            List list = this.i;
            if (list != null && !list.isEmpty()) {
                this.i.clear();
            }
            if (this.i == null) {
                this.i = new CopyOnWriteArrayList();
            }
        }
    }

    private void b(BitmapDescriptor bitmapDescriptor, int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, this, bitmapDescriptor, i, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2) != null) {
                    arrayList.add(((HistoryTraceData.HistoryTracePoint) list.get(i2)).getPoint());
                }
            }
            PolylineOptions zIndex = new PolylineOptions().width(i).points(arrayList).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4);
            b();
            a((Polyline) this.d.addOverlay(zIndex));
        }
    }

    private void b(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, latLng) == null) {
            if (!this.c.isShowEndPositionIcon()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not render end point marker");
            } else if (latLng == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "End point is null");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_NULL, "History trace end point is null, can't render start point marker");
            } else {
                BitmapDescriptor endPositionIcon = this.c.getEndPositionIcon();
                if (endPositionIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no endPositionIcon");
                    a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                    return;
                }
                this.g = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(endPositionIcon).zIndex(5));
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Marker marker = this.f;
            if (marker != null) {
                builder.include(marker.getPosition());
            }
            Marker marker2 = this.g;
            if (marker2 != null) {
                builder.include(marker2.getPosition());
            }
            Marker marker3 = this.h;
            if (marker3 != null) {
                builder.include(marker3.getPosition());
            }
            List list = this.i;
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < this.i.size(); i++) {
                    Polyline polyline = (Polyline) this.i.get(i);
                    if (polyline != null && polyline.getPoints() != null && !polyline.getPoints().isEmpty()) {
                        for (int i2 = 0; i2 < polyline.getPoints().size(); i2++) {
                            builder.include((LatLng) polyline.getPoints().get(i2));
                        }
                    }
                }
            }
            LatLngBounds build = builder.build();
            if (build == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Visibility span is null");
                return;
            }
            this.d.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, this.c.getPaddingLeft(), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom()));
        }
    }

    private void c(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, latLng) == null) {
            if (!this.c.isShowCarIcon()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not render car marker");
            } else if (latLng == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Car point is null");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_NULL);
            } else {
                BitmapDescriptor carIcon = this.c.getCarIcon();
                if (carIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Car icon is null");
                    a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_ICON_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_ICON_NULL);
                    return;
                }
                this.h = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(carIcon).flat(true).rotate(0.0f).zIndex(5).anchor(0.5f, 0.5f));
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b = null;
            Marker marker = this.f;
            if (marker != null) {
                marker.remove();
                this.f = null;
            }
            Marker marker2 = this.g;
            if (marker2 != null) {
                marker2.remove();
                this.g = null;
            }
            Marker marker3 = this.h;
            if (marker3 != null) {
                marker3.remove();
                this.h = null;
            }
            List list = this.i;
            if (list != null && !list.isEmpty()) {
                this.i.clear();
                this.i = null;
            }
            HistoryTraceDisplayOptions historyTraceDisplayOptions = this.c;
            if (historyTraceDisplayOptions != null) {
                historyTraceDisplayOptions.getCarIcon().recycle();
                this.c.getStartPositionIcon().recycle();
                this.c.getEndPositionIcon().recycle();
                this.c.getRouteLineTexture().recycle();
                this.c = null;
            }
            BaiduMap baiduMap = this.d;
            if (baiduMap != null) {
                baiduMap.clear();
            }
            removeCallbacksAndMessages(null);
        }
    }

    public void a(HistoryTraceDisplayOptions historyTraceDisplayOptions, BaiduMap baiduMap, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, historyTraceDisplayOptions, baiduMap, i) == null) {
            this.c = historyTraceDisplayOptions;
            this.d = baiduMap;
            this.e = i;
        }
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onHistoryTraceListener) == null) {
            b = onHistoryTraceListener;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            String str = a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Render message type = " + message.what);
            if (message.what != 4) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Undefine Render message");
            } else {
                a((HistoryTraceData) message.obj);
            }
        }
    }
}
