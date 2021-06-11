package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7772a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static OnHistoryTraceListener f7773b;

    /* renamed from: c  reason: collision with root package name */
    public HistoryTraceDisplayOptions f7774c;

    /* renamed from: d  reason: collision with root package name */
    public BaiduMap f7775d;

    /* renamed from: e  reason: collision with root package name */
    public int f7776e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f7777f;

    /* renamed from: g  reason: collision with root package name */
    public Marker f7778g;

    /* renamed from: h  reason: collision with root package name */
    public Marker f7779h;

    /* renamed from: i  reason: collision with root package name */
    public List<Polyline> f7780i;

    public e(Looper looper) {
        super(looper);
        this.f7780i = new CopyOnWriteArrayList();
    }

    private void a(int i2, String str) {
        OnHistoryTraceListener onHistoryTraceListener = f7773b;
        if (onHistoryTraceListener == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "OnHistoryTraceListener is null");
        } else {
            onHistoryTraceListener.onRenderHistroyTrace(i2, str);
        }
    }

    private void a(BitmapDescriptor bitmapDescriptor, int i2, List<HistoryTraceData.HistoryTracePoint> list) {
        List<List<LatLng>> b2 = b(list);
        if (b2 == null || b2.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Calculate sub section points error");
            return;
        }
        b();
        for (int i3 = 0; i3 < b2.size(); i3++) {
            List<LatLng> list2 = b2.get(i3);
            if (list2 != null && !list2.isEmpty()) {
                if (list2.size() < 2) {
                    String str = f7772a;
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Error points list, index = " + i3);
                } else {
                    a((Polyline) this.f7775d.addOverlay(new PolylineOptions().width(i2).points(list2).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4)));
                }
            }
        }
    }

    private void a(Polyline polyline) {
        this.f7780i.add(polyline);
    }

    private void a(LatLng latLng) {
        if (!this.f7774c.isShowStartPositionIcon()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "User set not render start point marker");
        } else if (latLng == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Start point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor startPositionIcon = this.f7774c.getStartPositionIcon();
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "There is no startPositionIcon");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.f7777f = (Marker) this.f7775d.addOverlay(new MarkerOptions().position(latLng).icon(startPositionIcon).zIndex(5));
        }
    }

    private void a(HistoryTraceData historyTraceData) {
        if (5 != this.f7776e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Current order state not the complete state, render forbidden");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
            return;
        }
        BaiduMap baiduMap = this.f7775d;
        if (baiduMap == null) {
            a(10007, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
            return;
        }
        baiduMap.clear();
        if (this.f7774c == null) {
            a(100015, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_DISPLAY_OPTIONS_NULL);
            this.f7774c = new HistoryTraceDisplayOptions();
        }
        a(historyTraceData.getOrderStartPosition());
        b(historyTraceData.getOrderEndPosition());
        List<HistoryTraceData.HistoryTracePoint> pointsList = historyTraceData.getPointsList();
        if (pointsList != null && !pointsList.isEmpty()) {
            c(pointsList.get(0).getPoint());
        }
        a(pointsList);
        c();
    }

    private void a(List<HistoryTraceData.HistoryTracePoint> list) {
        if (!this.f7774c.isShowRoutePlan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "User set not render route polyline");
        } else if (list == null || list.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "There is no points data");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_NULL);
        } else if (list.size() < 2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "History trace points less than 2, can't render polyline");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_LESS, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_LESS);
        } else {
            BitmapDescriptor routeLineTexture = this.f7774c.getRouteLineTexture();
            if (routeLineTexture == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Route polyline texture is null");
                a(100018, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_ROUTE_TEXTURE_NULL);
                return;
            }
            int routeLineWidth = this.f7774c.getRouteLineWidth();
            if (this.f7774c.isRouteLineRenderBySubSection()) {
                b(routeLineTexture, routeLineWidth, list);
            } else {
                a(routeLineTexture, routeLineWidth, list);
            }
        }
    }

    private List<List<LatLng>> b(List<HistoryTraceData.HistoryTracePoint> list) {
        String str;
        String str2;
        HistoryTraceData.HistoryTracePoint historyTracePoint;
        if (list == null || list.isEmpty()) {
            str = f7772a;
            str2 = "History trace point list is null";
        } else if (list.size() >= 2) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size() - 1; i2++) {
                HistoryTraceData.HistoryTracePoint historyTracePoint2 = list.get(i2);
                if (historyTracePoint2 != null && (historyTracePoint = list.get(i2 + 1)) != null) {
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
                arrayList.add(list.get(list.size() - 1).getPoint());
                copyOnWriteArrayList.add(arrayList);
            }
            return copyOnWriteArrayList;
        } else {
            str = f7772a;
            str2 = "History trace point list size is less than 2, can't render polyline";
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
        return null;
    }

    private void b() {
        List<Polyline> list = this.f7780i;
        if (list != null && !list.isEmpty()) {
            this.f7780i.clear();
        }
        if (this.f7780i == null) {
            this.f7780i = new CopyOnWriteArrayList();
        }
    }

    private void b(BitmapDescriptor bitmapDescriptor, int i2, List<HistoryTraceData.HistoryTracePoint> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) != null) {
                arrayList.add(list.get(i3).getPoint());
            }
        }
        PolylineOptions zIndex = new PolylineOptions().width(i2).points(arrayList).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4);
        b();
        a((Polyline) this.f7775d.addOverlay(zIndex));
    }

    private void b(LatLng latLng) {
        if (!this.f7774c.isShowEndPositionIcon()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "User set not render end point marker");
        } else if (latLng == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "End point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor endPositionIcon = this.f7774c.getEndPositionIcon();
            if (endPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "There is no endPositionIcon");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.f7778g = (Marker) this.f7775d.addOverlay(new MarkerOptions().position(latLng).icon(endPositionIcon).zIndex(5));
        }
    }

    private void c() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Marker marker = this.f7777f;
        if (marker != null) {
            builder.include(marker.getPosition());
        }
        Marker marker2 = this.f7778g;
        if (marker2 != null) {
            builder.include(marker2.getPosition());
        }
        Marker marker3 = this.f7779h;
        if (marker3 != null) {
            builder.include(marker3.getPosition());
        }
        List<Polyline> list = this.f7780i;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f7780i.size(); i2++) {
                Polyline polyline = this.f7780i.get(i2);
                if (polyline != null && polyline.getPoints() != null && !polyline.getPoints().isEmpty()) {
                    for (int i3 = 0; i3 < polyline.getPoints().size(); i3++) {
                        builder.include(polyline.getPoints().get(i3));
                    }
                }
            }
        }
        LatLngBounds build = builder.build();
        if (build == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Visibility span is null");
            return;
        }
        this.f7775d.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, this.f7774c.getPaddingLeft(), this.f7774c.getPaddingTop(), this.f7774c.getPaddingRight(), this.f7774c.getPaddingBottom()));
    }

    private void c(LatLng latLng) {
        if (!this.f7774c.isShowCarIcon()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "User set not render car marker");
        } else if (latLng == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Car point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_NULL);
        } else {
            BitmapDescriptor carIcon = this.f7774c.getCarIcon();
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Car icon is null");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_ICON_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_ICON_NULL);
                return;
            }
            this.f7779h = (Marker) this.f7775d.addOverlay(new MarkerOptions().position(latLng).icon(carIcon).flat(true).rotate(0.0f).zIndex(5).anchor(0.5f, 0.5f));
        }
    }

    public void a() {
        f7773b = null;
        Marker marker = this.f7777f;
        if (marker != null) {
            marker.remove();
            this.f7777f = null;
        }
        Marker marker2 = this.f7778g;
        if (marker2 != null) {
            marker2.remove();
            this.f7778g = null;
        }
        Marker marker3 = this.f7779h;
        if (marker3 != null) {
            marker3.remove();
            this.f7779h = null;
        }
        List<Polyline> list = this.f7780i;
        if (list != null && !list.isEmpty()) {
            this.f7780i.clear();
            this.f7780i = null;
        }
        HistoryTraceDisplayOptions historyTraceDisplayOptions = this.f7774c;
        if (historyTraceDisplayOptions != null) {
            historyTraceDisplayOptions.getCarIcon().recycle();
            this.f7774c.getStartPositionIcon().recycle();
            this.f7774c.getEndPositionIcon().recycle();
            this.f7774c.getRouteLineTexture().recycle();
            this.f7774c = null;
        }
        BaiduMap baiduMap = this.f7775d;
        if (baiduMap != null) {
            baiduMap.clear();
        }
        removeCallbacksAndMessages(null);
    }

    public void a(HistoryTraceDisplayOptions historyTraceDisplayOptions, BaiduMap baiduMap, int i2) {
        this.f7774c = historyTraceDisplayOptions;
        this.f7775d = baiduMap;
        this.f7776e = i2;
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        f7773b = onHistoryTraceListener;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str = f7772a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Render message type = " + message.what);
        if (message.what != 4) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7772a, "Undefine Render message");
        } else {
            a((HistoryTraceData) message.obj);
        }
    }
}
