package com.baidu.mapapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class RouteOverlay extends ItemizedOverlay {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f538a;
    private MapView b;
    private Context c;
    private DisplayMetrics d;
    private int e;
    private HashMap f;
    public MKRoute mRoute;

    /* loaded from: classes.dex */
    class a {

        /* renamed from: a  reason: collision with root package name */
        public GeoPoint f539a = new GeoPoint(0, 0);
        public ArrayList b = new ArrayList();

        public a() {
        }
    }

    /* loaded from: classes.dex */
    class b {

        /* renamed from: a  reason: collision with root package name */
        public String f540a;
        public GeoPoint b;
        public int c;
        public int d;

        private b() {
        }
    }

    public RouteOverlay(Activity activity, MapView mapView) {
        super(null);
        this.mRoute = null;
        this.f538a = null;
        this.b = null;
        this.c = null;
        this.e = 1;
        this.c = activity;
        this.b = mapView;
        this.d = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(this.d);
        if (Mj.i <= 120) {
            this.e = 0;
        } else if (Mj.i <= 180) {
            this.e = 1;
        } else {
            this.e = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.Overlay
    public void a(int i, int i2, int i3, int i4) {
        this.f.clear();
    }

    public void animateTo() {
        if (size() > 0) {
            onTap(0);
        }
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    protected OverlayItem createItem(int i) {
        Drawable a2;
        char[] cArr = {'l', 'm', 'h'};
        String[] strArr = {"start", "end", "foot", "car", "bus"};
        b bVar = (b) this.f538a.get(i);
        OverlayItem overlayItem = new OverlayItem(bVar.b, bVar.f540a, null);
        StringBuilder sb = new StringBuilder(32);
        if (bVar.c == 0 || bVar.c == 1 || bVar.c == 4) {
            sb.append("icon_nav_").append(strArr[bVar.c]).append('_').append(cArr[this.e]).append(".png");
            a2 = n.a(this.c, sb.toString());
        } else {
            sb.append("icon_direction_").append(cArr[this.e]).append(".png");
            a2 = n.a(this.c, sb.toString(), bVar.d * 30);
        }
        if (bVar.c == 0 || bVar.c == 1) {
            overlayItem.setMarker(boundCenterBottom(a2));
        } else {
            overlayItem.setMarker(boundCenter(a2));
        }
        return overlayItem;
    }

    @Override // com.baidu.mapapi.Overlay
    public boolean draw(Canvas canvas, MapView mapView, boolean z, long j) {
        a aVar;
        boolean z2;
        int i;
        Projection projection = mapView.getProjection();
        ((Activity) this.c).getWindowManager().getDefaultDisplay().getMetrics(this.d);
        int zoomLevel = mapView.getZoomLevel();
        if (this.mRoute != null) {
            ArrayList arrayPoints = this.mRoute.getArrayPoints();
            ArrayList arrayList = this.mRoute.f514a;
            if (arrayPoints != null && arrayPoints.size() > 0) {
                a aVar2 = (a) this.f.get(Integer.valueOf(zoomLevel));
                if (aVar2 == null) {
                    a aVar3 = new a();
                    int size = arrayPoints.size();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        n.a((ArrayList) arrayPoints.get(i2), (ArrayList) arrayList.get(i2), zoomLevel, arrayList2);
                        int size2 = arrayList2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            Point point = new Point();
                            mapView.f524a.a((GeoPoint) arrayList2.get(i3), point);
                            aVar3.b.add(point);
                        }
                    }
                    aVar3.f539a.setLatitudeE6(mapView.getMapCenter().getLatitudeE6());
                    aVar3.f539a.setLongitudeE6(mapView.getMapCenter().getLongitudeE6());
                    this.f.put(Integer.valueOf(zoomLevel), aVar3);
                    aVar = aVar3;
                } else {
                    aVar = aVar2;
                }
                int size3 = aVar.b.size();
                if (size3 > 1) {
                    int i4 = 0;
                    boolean z3 = false;
                    Point point2 = new Point();
                    Point point3 = new Point();
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setStrokeWidth(6.0f);
                    paint.setColor(Color.rgb(58, 107, 189));
                    paint.setAlpha(192);
                    Point point4 = new Point();
                    Point point5 = new Point();
                    projection.toPixels(mapView.getMapCenter(), point4);
                    projection.toPixels(aVar.f539a, point5);
                    int i5 = point4.y - point5.y;
                    int i6 = (point4.x - point5.x) - mapView.b.c;
                    int i7 = i5 - mapView.b.d;
                    point2.x = ((Point) aVar.b.get(0)).x;
                    point2.y = ((Point) aVar.b.get(0)).y;
                    if (this.b.b.e != 1.0d) {
                        point2.x = ((int) (((point2.x - this.b.b.f) * this.b.b.e) + 0.5d)) + this.b.b.f;
                        point2.y = this.b.b.g + ((int) (((point2.y - this.b.b.g) * this.b.b.e) + 0.5d));
                    }
                    point2.x -= i6;
                    point2.y -= i7;
                    int i8 = 1;
                    while (i8 < size3) {
                        point3.x = ((Point) aVar.b.get(i8)).x;
                        point3.y = ((Point) aVar.b.get(i8)).y;
                        if (this.b.b.e != 1.0d) {
                            point3.x = ((int) (((point3.x - this.b.b.f) * this.b.b.e) + 0.5d)) + this.b.b.f;
                            point3.y = this.b.b.g + ((int) (((point3.y - this.b.b.g) * this.b.b.e) + 0.5d));
                        }
                        point3.x -= i6;
                        point3.y -= i7;
                        if (n.a(point2, point3, this.d.widthPixels, this.d.heightPixels)) {
                            canvas.drawLine(point2.x, point2.y, point3.x, point3.y, paint);
                            z2 = true;
                            i = i4;
                        } else if (z3) {
                            int i9 = i4 + 1;
                            if (i9 > 50) {
                                break;
                            }
                            boolean z4 = z3;
                            i = i9;
                            z2 = z4;
                        } else {
                            z2 = z3;
                            i = i4;
                        }
                        point2.x = point3.x;
                        point2.y = point3.y;
                        if (i > 50) {
                            break;
                        }
                        i8++;
                        i4 = i;
                        z3 = z2;
                    }
                }
            }
        }
        if (zoomLevel >= 3) {
            return super.draw(canvas, mapView, z, j);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.ItemizedOverlay
    public boolean onTap(int i) {
        OverlayItem item = getItem(i);
        this.b.getController().animateTo(item.mPoint);
        if (item.mTitle != null) {
            Toast.makeText(this.c, item.mTitle, 1).show();
        }
        super.onTap(i);
        return true;
    }

    public void setData(MKRoute mKRoute) {
        int i = 2;
        if (mKRoute == null) {
            return;
        }
        this.mRoute = mKRoute;
        this.f538a = new ArrayList();
        if (this.mRoute.getRouteType() == 1) {
            i = 3;
        } else if (this.mRoute.getRouteType() != 2) {
            i = this.mRoute.getRouteType() == 3 ? 4 : 0;
        }
        GeoPoint start = this.mRoute.getStart();
        if (start != null) {
            b bVar = new b();
            bVar.b = start;
            bVar.c = 0;
            this.f538a.add(bVar);
        }
        int numSteps = mKRoute.getNumSteps();
        if (numSteps != 0) {
            if (this.f538a.size() > 0) {
                ((b) this.f538a.get(0)).f540a = mKRoute.getStep(0).getContent();
            }
            for (int i2 = 1; i2 < numSteps - 1; i2++) {
                MKStep step = mKRoute.getStep(i2);
                b bVar2 = new b();
                bVar2.b = step.getPoint();
                bVar2.f540a = step.getContent();
                bVar2.c = i;
                bVar2.d = step.a();
                this.f538a.add(bVar2);
            }
        }
        GeoPoint end = this.mRoute.getEnd();
        if (end != null) {
            b bVar3 = new b();
            bVar3.b = end;
            bVar3.c = 1;
            this.f538a.add(bVar3);
        }
        this.f = new HashMap();
        super.populate();
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    public int size() {
        if (this.f538a == null) {
            return 0;
        }
        return this.f538a.size();
    }
}
