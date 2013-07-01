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
/* loaded from: classes.dex */
public class TransitOverlay extends ItemizedOverlay {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f541a;
    private MapView b;
    private Context c;
    private int d;
    private DisplayMetrics e;
    public MKTransitRoutePlan mPlan;
    public boolean mUseToast;

    /* loaded from: classes.dex */
    class a {

        /* renamed from: a  reason: collision with root package name */
        public String f542a;
        public GeoPoint b;
        public int c;

        private a() {
        }
    }

    public TransitOverlay(Activity activity, MapView mapView) {
        super(null);
        this.mPlan = null;
        this.f541a = null;
        this.b = null;
        this.c = null;
        this.d = 1;
        this.mUseToast = true;
        this.c = activity;
        this.b = mapView;
        this.e = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(this.e);
        if (this.e.widthPixels <= 320 && this.e.heightPixels <= 320) {
            this.d = 0;
        } else if (this.e.widthPixels > 480 || this.e.heightPixels > 480) {
            this.d = 2;
        } else {
            this.d = 1;
        }
    }

    public void animateTo() {
        if (size() > 0) {
            onTap(0);
        }
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    protected OverlayItem createItem(int i) {
        char[] cArr = {'l', 'm', 'h'};
        String[] strArr = {"start", "end", "bus", "foot", "rail", "car"};
        a aVar = (a) this.f541a.get(i);
        OverlayItem overlayItem = new OverlayItem(aVar.b, aVar.f542a, null);
        if (aVar.c != 3) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("icon_nav_").append(strArr[aVar.c]).append('_').append(cArr[this.d]).append(".png");
            Drawable a2 = n.a(this.c, sb.toString());
            if (aVar.c == 0 || aVar.c == 1) {
                overlayItem.setMarker(boundCenterBottom(a2));
            } else {
                overlayItem.setMarker(boundCenter(a2));
            }
        }
        return overlayItem;
    }

    @Override // com.baidu.mapapi.Overlay
    public boolean draw(Canvas canvas, MapView mapView, boolean z, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Projection projection = mapView.getProjection();
        ((Activity) this.c).getWindowManager().getDefaultDisplay().getMetrics(this.e);
        if (this.mPlan != null) {
            int numLines = this.mPlan.getNumLines();
            if (numLines + 1 == this.mPlan.getNumRoute() && numLines != 0) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStrokeWidth(6.0f);
                Point point = new Point();
                Point point2 = new Point();
                ArrayList arrayList3 = new ArrayList();
                int zoomLevel = mapView.getZoomLevel();
                int i = 0;
                while (true) {
                    if (i >= numLines) {
                        break;
                    }
                    MKRoute route = this.mPlan.getRoute(i);
                    ArrayList arrayPoints = route.getArrayPoints();
                    if (arrayPoints != null && arrayPoints.size() > 0 && (arrayList2 = (ArrayList) arrayPoints.get(0)) != null && arrayList2.size() > 0) {
                        n.a(arrayList2, (ArrayList) route.f514a.get(0), zoomLevel, arrayList3);
                        int size = arrayList3.size();
                        if (size > 1) {
                            paint.setColor(Color.rgb(48, 162, 8));
                            paint.setAlpha(192);
                            projection.toPixels((GeoPoint) arrayList3.get(0), point);
                            for (int i2 = 1; i2 < size; i2++) {
                                projection.toPixels((GeoPoint) arrayList3.get(i2), point2);
                                if (n.a(point, point2, this.e.widthPixels, this.e.heightPixels)) {
                                    canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
                                }
                                point.x = point2.x;
                                point.y = point2.y;
                            }
                        }
                    }
                    MKLine line = this.mPlan.getLine(i);
                    ArrayList points = line.getPoints();
                    if (points != null && points.size() > 0) {
                        n.a(points, line.f509a, zoomLevel, arrayList3);
                        int size2 = arrayList3.size();
                        if (size2 > 1) {
                            paint.setColor(Color.rgb(58, 107, 189));
                            paint.setAlpha(192);
                            projection.toPixels((GeoPoint) arrayList3.get(0), point);
                            for (int i3 = 1; i3 < size2; i3++) {
                                projection.toPixels((GeoPoint) arrayList3.get(i3), point2);
                                if (n.a(point, point2, this.e.widthPixels, this.e.heightPixels)) {
                                    canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
                                }
                                point.x = point2.x;
                                point.y = point2.y;
                            }
                        }
                    }
                    if (i == numLines - 1) {
                        MKRoute route2 = this.mPlan.getRoute(i + 1);
                        ArrayList arrayPoints2 = route2.getArrayPoints();
                        if (arrayPoints2 != null && arrayPoints2.size() > 0 && (arrayList = (ArrayList) arrayPoints2.get(0)) != null && arrayList.size() > 0) {
                            n.a(arrayList, (ArrayList) route2.f514a.get(0), zoomLevel, arrayList3);
                            int size3 = arrayList3.size();
                            if (size3 > 1) {
                                paint.setColor(Color.rgb(48, 162, 8));
                                paint.setAlpha(192);
                                projection.toPixels((GeoPoint) arrayList3.get(0), point);
                                for (int i4 = 1; i4 < size3; i4++) {
                                    projection.toPixels((GeoPoint) arrayList3.get(i4), point2);
                                    if (n.a(point, point2, this.e.widthPixels, this.e.heightPixels)) {
                                        canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
                                    }
                                    point.x = point2.x;
                                    point.y = point2.y;
                                }
                            }
                        }
                    } else {
                        i++;
                    }
                }
            }
        }
        return super.draw(canvas, mapView, z, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.ItemizedOverlay
    public boolean onTap(int i) {
        OverlayItem item = getItem(i);
        this.b.getController().animateTo(item.mPoint);
        if (this.mUseToast && item.mTitle != null) {
            Toast.makeText(this.c, item.mTitle, 1).show();
        }
        super.onTap(i);
        return true;
    }

    public void setData(MKTransitRoutePlan mKTransitRoutePlan) {
        if (mKTransitRoutePlan == null) {
            return;
        }
        this.f541a = new ArrayList();
        this.mPlan = mKTransitRoutePlan;
        int numLines = mKTransitRoutePlan.getNumLines();
        if (numLines + 1 != this.mPlan.getNumRoute() || numLines == 0) {
            return;
        }
        GeoPoint start = mKTransitRoutePlan.getStart();
        if (start != null) {
            a aVar = new a();
            aVar.b = start;
            aVar.c = 0;
            this.f541a.add(aVar);
        }
        for (int i = 0; i < numLines; i++) {
            MKLine line = mKTransitRoutePlan.getLine(i);
            a aVar2 = new a();
            aVar2.b = line.getGetOnStop().pt;
            aVar2.f542a = line.a();
            if (line.getType() == 0) {
                aVar2.c = 2;
            } else {
                aVar2.c = 4;
            }
            this.f541a.add(aVar2);
            MKRoute route = this.mPlan.getRoute(i + 1);
            a aVar3 = new a();
            aVar3.b = line.getGetOffStop().pt;
            aVar3.f542a = route.a();
            if (line.getType() == 0) {
                aVar3.c = 2;
            } else {
                aVar3.c = 4;
            }
            this.f541a.add(aVar3);
        }
        GeoPoint end = mKTransitRoutePlan.getEnd();
        if (end != null) {
            a aVar4 = new a();
            aVar4.b = end;
            aVar4.c = 1;
            this.f541a.add(aVar4);
        }
        super.populate();
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    public int size() {
        if (this.f541a == null) {
            return 0;
        }
        return this.f541a.size();
    }
}
