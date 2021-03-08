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
/* loaded from: classes4.dex */
class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2242a = e.class.getSimpleName();
    private static OnHistoryTraceListener b;
    private HistoryTraceDisplayOptions c;
    private BaiduMap d;
    private int e;
    private Marker f;
    private Marker g;
    private Marker h;
    private List<Polyline> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Looper looper) {
        super(looper);
        this.i = new CopyOnWriteArrayList();
    }

    private void a(int i, String str) {
        if (b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "OnHistoryTraceListener is null");
        } else {
            b.onRenderHistroyTrace(i, str);
        }
    }

    private void a(BitmapDescriptor bitmapDescriptor, int i, List<HistoryTraceData.HistoryTracePoint> list) {
        List<List<LatLng>> b2 = b(list);
        if (b2 == null || b2.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Calculate sub section points error");
            return;
        }
        b();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= b2.size()) {
                return;
            }
            List<LatLng> list2 = b2.get(i3);
            if (list2 != null && !list2.isEmpty()) {
                if (list2.size() < 2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Error points list, index = " + i3);
                } else {
                    a((Polyline) this.d.addOverlay(new PolylineOptions().width(i).points(list2).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4)));
                }
            }
            i2 = i3 + 1;
        }
    }

    private void a(Polyline polyline) {
        this.i.add(polyline);
    }

    private void a(LatLng latLng) {
        if (!this.c.isShowStartPositionIcon()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "User set not render start point marker");
        } else if (latLng == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Start point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor startPositionIcon = this.c.getStartPositionIcon();
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "There is no startPositionIcon");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.f = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(startPositionIcon).zIndex(5));
        }
    }

    private void a(HistoryTraceData historyTraceData) {
        if (5 != this.e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Current order state not the complete state, render forbidden");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
        } else if (this.d == null) {
            a(10007, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
        } else {
            this.d.clear();
            if (this.c == null) {
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_DISPLAY_OPTIONS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_DISPLAY_OPTIONS_NULL);
                this.c = new HistoryTraceDisplayOptions();
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
    }

    private void a(List<HistoryTraceData.HistoryTracePoint> list) {
        if (!this.c.isShowRoutePlan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "User set not render route polyline");
        } else if (list == null || list.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "There is no points data");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_NULL);
        } else if (list.size() < 2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "History trace points less than 2, can't render polyline");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_LESS, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_LESS);
        } else {
            BitmapDescriptor routeLineTexture = this.c.getRouteLineTexture();
            if (routeLineTexture == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Route polyline texture is null");
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

    private List<List<LatLng>> b(List<HistoryTraceData.HistoryTracePoint> list) {
        HistoryTraceData.HistoryTracePoint historyTracePoint;
        if (list == null || list.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "History trace point list is null");
            return null;
        } else if (list.size() < 2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "History trace point list size is less than 2, can't render polyline");
            return null;
        } else {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size() - 1) {
                    break;
                }
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
                i = i2 + 1;
            }
            if (!arrayList.isEmpty()) {
                arrayList.add(list.get(list.size() - 1).getPoint());
                copyOnWriteArrayList.add(arrayList);
            }
            return copyOnWriteArrayList;
        }
    }

    private void b() {
        if (this.i != null && !this.i.isEmpty()) {
            this.i.clear();
        }
        if (this.i == null) {
            this.i = new CopyOnWriteArrayList();
        }
    }

    private void b(BitmapDescriptor bitmapDescriptor, int i, List<HistoryTraceData.HistoryTracePoint> list) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                PolylineOptions zIndex = new PolylineOptions().width(i).points(arrayList).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4);
                b();
                a((Polyline) this.d.addOverlay(zIndex));
                return;
            }
            if (list.get(i3) != null) {
                arrayList.add(list.get(i3).getPoint());
            }
            i2 = i3 + 1;
        }
    }

    private void b(LatLng latLng) {
        if (!this.c.isShowEndPositionIcon()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "User set not render end point marker");
        } else if (latLng == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "End point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor endPositionIcon = this.c.getEndPositionIcon();
            if (endPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "There is no endPositionIcon");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.g = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(endPositionIcon).zIndex(5));
        }
    }

    private void c() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        if (this.f != null) {
            builder.include(this.f.getPosition());
        }
        if (this.g != null) {
            builder.include(this.g.getPosition());
        }
        if (this.h != null) {
            builder.include(this.h.getPosition());
        }
        if (this.i != null && !this.i.isEmpty()) {
            for (int i = 0; i < this.i.size(); i++) {
                Polyline polyline = this.i.get(i);
                if (polyline != null && polyline.getPoints() != null && !polyline.getPoints().isEmpty()) {
                    for (int i2 = 0; i2 < polyline.getPoints().size(); i2++) {
                        builder.include(polyline.getPoints().get(i2));
                    }
                }
            }
        }
        LatLngBounds build = builder.build();
        if (build == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Visibility span is null");
            return;
        }
        this.d.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, this.c.getPaddingLeft(), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom()));
    }

    private void c(LatLng latLng) {
        if (!this.c.isShowCarIcon()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "User set not render car marker");
        } else if (latLng == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Car point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_NULL);
        } else {
            BitmapDescriptor carIcon = this.c.getCarIcon();
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Car icon is null");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_ICON_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_ICON_NULL);
                return;
            }
            this.h = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(carIcon).flat(true).rotate(0.0f).zIndex(5).anchor(0.5f, 0.5f));
        }
    }

    public void a() {
        b = null;
        if (this.f != null) {
            this.f.remove();
            this.f = null;
        }
        if (this.g != null) {
            this.g.remove();
            this.g = null;
        }
        if (this.h != null) {
            this.h.remove();
            this.h = null;
        }
        if (this.i != null && !this.i.isEmpty()) {
            this.i.clear();
            this.i = null;
        }
        if (this.c != null) {
            this.c.getCarIcon().recycle();
            this.c.getStartPositionIcon().recycle();
            this.c.getEndPositionIcon().recycle();
            this.c.getRouteLineTexture().recycle();
            this.c = null;
        }
        if (this.d != null) {
            this.d.clear();
        }
        removeCallbacksAndMessages(null);
    }

    public void a(HistoryTraceDisplayOptions historyTraceDisplayOptions, BaiduMap baiduMap, int i) {
        this.c = historyTraceDisplayOptions;
        this.d = baiduMap;
        this.e = i;
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        b = onHistoryTraceListener;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Render message type = " + message.what);
        switch (message.what) {
            case 4:
                a((HistoryTraceData) message.obj);
                return;
            default:
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2242a, "Undefine Render message");
                return;
        }
    }
}
