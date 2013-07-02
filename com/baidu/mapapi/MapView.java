package com.baidu.mapapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ZoomControls;
import com.baidu.browser.explorer.BdWebErrorView;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes.dex */
public class MapView extends ViewGroup {
    public static final int DRAG_MODE_NONE = 1;
    public static final int DRAG_MODE_SCALE = 0;
    private static int g = 0;
    e a;
    com.baidu.mapapi.a b;
    private GeoPoint c;
    private int d;
    private int e;
    private int f;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private Message l;
    private Runnable m;
    private MapActivity n;
    private MapController o;
    private ZoomControls p;
    private ImageView q;
    private boolean r;

    /* loaded from: classes.dex */
    public class LayoutParams extends ViewGroup.LayoutParams {
        public static final int BOTTOM = 80;
        public static final int BOTTOM_CENTER = 81;
        public static final int CENTER = 17;
        public static final int CENTER_HORIZONTAL = 1;
        public static final int CENTER_VERTICAL = 16;
        public static final int LEFT = 3;
        public static final int MODE_MAP = 0;
        public static final int MODE_VIEW = 1;
        public static final int RIGHT = 5;
        public static final int TOP = 48;
        public static final int TOP_LEFT = 51;
        public int alignment;
        public int mode;
        public GeoPoint point;
        public int x;
        public int y;

        public LayoutParams(int i, int i2, int i3, int i4, int i5) {
            super(i, i2);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
            this.mode = 1;
            this.x = i3;
            this.y = i4;
            this.alignment = i5;
        }

        public LayoutParams(int i, int i2, GeoPoint geoPoint, int i3) {
            this(i, i2, geoPoint, 0, 0, i3);
        }

        public LayoutParams(int i, int i2, GeoPoint geoPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
            this.mode = 0;
            this.point = geoPoint;
            this.x = i3;
            this.y = i4;
            this.alignment = i5;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum a {
        DRAW_RETICLE_NEVER,
        DRAW_RETICLE_OVER,
        DRAW_RETICLE_UNDER
    }

    public MapView(Context context) {
        super(context);
        this.c = new GeoPoint(0, 0);
        this.d = 12;
        this.e = 0;
        this.f = 0;
        this.h = 18;
        this.i = 3;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.a = new e(this);
        this.p = new ZoomControls(getContext());
        this.q = new ImageView(getContext());
        this.b = null;
        this.r = false;
        a(context);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new GeoPoint(0, 0);
        this.d = 12;
        this.e = 0;
        this.f = 0;
        this.h = 18;
        this.i = 3;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.a = new e(this);
        this.p = new ZoomControls(getContext());
        this.q = new ImageView(getContext());
        this.b = null;
        this.r = false;
        a(context);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new GeoPoint(0, 0);
        this.d = 12;
        this.e = 0;
        this.f = 0;
        this.h = 18;
        this.i = 3;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.a = new e(this);
        this.p = new ZoomControls(getContext());
        this.q = new ImageView(getContext());
        this.b = null;
        this.r = false;
        a(context);
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        view.measure(this.e, this.f);
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int measuredWidth = i == -1 ? this.e : i == -2 ? view.getMeasuredWidth() : i;
        if (i2 == -1) {
            i2 = this.f;
        } else if (i2 == -2) {
            i2 = view.getMeasuredHeight();
        }
        if (!checkLayoutParams(layoutParams)) {
            view.layout(0, 0, measuredWidth, i2);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i3 = layoutParams2.x;
        int i4 = layoutParams2.y;
        if (layoutParams2.mode == 0 && layoutParams2.point != null) {
            Point pixels = getProjection().toPixels(layoutParams2.point, null);
            i3 = pixels.x + layoutParams2.x;
            i4 = pixels.y + layoutParams2.y;
        }
        switch (layoutParams2.alignment) {
            case 1:
                i3 -= measuredWidth / 2;
                break;
            case 5:
                i3 -= measuredWidth;
                break;
            case 16:
                i4 -= i2 / 2;
                break;
            case 17:
                i3 -= measuredWidth / 2;
                i4 -= i2 / 2;
                break;
            case 80:
                i4 -= i2;
                break;
            case LayoutParams.BOTTOM_CENTER /* 81 */:
                i3 -= measuredWidth / 2;
                i4 -= i2;
                break;
        }
        view.layout(i3, i4, measuredWidth + i3, i2 + i4);
    }

    private boolean a(Context context) {
        MapActivity mapActivity = (MapActivity) context;
        this.e = Mj.g;
        this.f = Mj.h;
        this.n = mapActivity;
        g++;
        return mapActivity.a(this);
    }

    private void d(int i) {
        this.d = i;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h = i;
        if (this.d > i) {
            c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        Mj.MapProc(4354, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        Mj.MapProc(4102, geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint, Message message, Runnable runnable) {
        Mj.MapProc(4353, geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
        this.l = message;
        this.m = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (z) {
            Mj.MapProc(4355, 1, 0);
        } else {
            Mj.MapProc(4355, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097 A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #4 {Exception -> 0x00d1, blocks: (B:17:0x005e, B:19:0x0069, B:22:0x0092, B:24:0x0097, B:36:0x00e4, B:37:0x00e7, B:31:0x00cd), top: B:45:0x005e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() {
        InputStream inputStream;
        InputStream inputStream2 = null;
        Bitmap bitmap = null;
        if (this.b == null) {
            this.b = new com.baidu.mapapi.a(getContext(), this);
        }
        if (this.o == null) {
            this.o = new MapController(this);
        }
        if (this.b.getParent() == null) {
            addView(this.b);
        }
        if (this.p.getParent() == null) {
            this.p.setOnZoomOutClickListener(new View.OnClickListener() { // from class: com.baidu.mapapi.MapView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MapView.this.g();
                }
            });
            this.p.setOnZoomInClickListener(new View.OnClickListener() { // from class: com.baidu.mapapi.MapView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MapView.this.f();
                }
            });
            this.p.setFocusable(true);
            this.p.setVisibility(0);
            this.p.measure(0, 0);
        }
        if (this.q.getParent() == null) {
            try {
                try {
                    inputStream = this.n.getAssets().open("baidumap_logo_" + new char[]{'l', 'h'}[Mj.i > 180 ? (char) 1 : (char) 0] + ".png");
                    try {
                        try {
                            bitmap = BitmapFactory.decodeStream(inputStream);
                            inputStream.close();
                        } catch (OutOfMemoryError e) {
                            e = e;
                            e.printStackTrace();
                            inputStream.close();
                            if (bitmap != null) {
                            }
                            this.b.setFocusable(true);
                            this.b.setFocusableInTouchMode(true);
                            this.d = d();
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        inputStream2.close();
                        throw th;
                    }
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2.close();
                    throw th;
                }
                if (bitmap != null) {
                    this.q.setImageBitmap(bitmap);
                    this.q.setVisibility(0);
                    this.q.measure(0, 0);
                    this.q.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    addView(this.q);
                }
            } catch (Exception e3) {
                Log.d("MapView()", "initMapView() error!");
                Log.d("MapView()", e3.getMessage());
            }
        }
        this.b.setFocusable(true);
        this.b.setFocusableInTouchMode(true);
        this.d = d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, int i3) {
        switch (i) {
            case 9:
                if (this.b != null) {
                    this.b.a = true;
                    this.b.invalidate();
                    return true;
                }
                return true;
            case BdWebErrorView.ERROR_CODE_505 /* 505 */:
                d(i2);
                return true;
            case 8020:
                if (this.l == null) {
                    if (this.m != null) {
                        this.m.run();
                        return true;
                    }
                    return true;
                } else if (this.l.getTarget() != null) {
                    this.l.getTarget().sendMessage(this.l);
                    this.l = null;
                    return true;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (g <= 0) {
            return;
        }
        g--;
        if (g == 0) {
            this.b.a();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.i = i;
        if (this.d < i) {
            c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2) {
        Mj.MapProc(4103, (this.e / 2) + i, (this.f / 2) + i2);
    }

    void c() {
        this.p.setIsZoomOutEnabled(this.d > getMinZoomLevel());
        this.p.setIsZoomInEnabled(this.d < getMaxZoomLevel());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i) {
        this.d = getZoomLevel();
        if (i < this.i) {
            i = this.i;
        } else if (i > this.h) {
            i = this.h;
        }
        if (this.d != i) {
            this.d = i;
            this.b.a(i);
            c();
            return true;
        }
        return false;
    }

    public boolean canCoverCenter() {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010001);
        Mj.sendBundle(bundle);
        return bundle.getInt("r") != 0;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
    }

    int d() {
        Bundle newBundle = Mj.getNewBundle(10030300, 0, 0);
        if (newBundle != null) {
            return newBundle.getInt("mapLevel");
        }
        return 0;
    }

    public void displayZoomControls(boolean z) {
        if (!this.r || this.p.getParent() == null) {
            removeView(this.p);
            addView(this.p);
            this.r = true;
        }
        if (z) {
            requestChildFocus(this.p, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = super.getChildAt(i);
            if (childAt != this.q && childAt != this.p && childAt != this.b) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).mode == 0) {
                    a(childAt, layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (this.d >= this.h) {
            return false;
        }
        this.b.a(1, this.e / 2, this.f / 2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        if (this.d <= this.i) {
            return false;
        }
        this.b.a(-1, this.e / 2, this.f / 2);
        return true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.n, attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public MapController getController() {
        return this.o;
    }

    public int getLatitudeSpan() {
        e eVar = (e) getProjection();
        return Math.abs(eVar.fromPixels(0, 0).getLatitudeE6() - eVar.fromPixels(this.e - 1, this.f - 1).getLatitudeE6());
    }

    public int getLongitudeSpan() {
        e eVar = (e) getProjection();
        return Math.abs(eVar.fromPixels(this.e - 1, this.f - 1).getLongitudeE6() - eVar.fromPixels(0, 0).getLongitudeE6());
    }

    public GeoPoint getMapCenter() {
        Bundle GetMapStatus = Mj.GetMapStatus();
        if (GetMapStatus != null) {
            int i = GetMapStatus.getInt("x");
            int i2 = GetMapStatus.getInt("y");
            this.c.setLongitudeE6(i);
            this.c.setLatitudeE6(i2);
        }
        return this.c;
    }

    public int getMaxZoomLevel() {
        return this.h;
    }

    public int getMinZoomLevel() {
        return this.i;
    }

    public final List getOverlays() {
        if (this.b == null) {
            return null;
        }
        return this.b.c();
    }

    public Projection getProjection() {
        return this.a;
    }

    @Deprecated
    public View getZoomControls() {
        return this.p;
    }

    public int getZoomLevel() {
        int d = d();
        if (this.d != 0) {
            this.d = d;
        }
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double h() {
        return Math.pow(2.0d, 18 - this.d);
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.b != null) {
            this.b.invalidate();
        }
        if (this.p != null) {
            this.p.invalidate();
        }
        super.invalidate();
    }

    public boolean isDoubleClickZooming() {
        return this.b.b();
    }

    public boolean isSatellite() {
        return this.k;
    }

    public boolean isStreetView() {
        return false;
    }

    public boolean isTraffic() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        a();
        if (this.r) {
            setBuiltInZoomControls(true);
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.r && this.p.getParent() != null) {
            removeView(this.p);
        }
        removeView(this.b);
        removeView(this.q);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        this.b.a(z, i, rect);
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.b.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.b.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.e = i3 - i;
        this.f = i4 - i2;
        this.b.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
        this.b.setVisibility(0);
        this.b.layout(0, 0, this.e, this.f);
        this.p.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
        this.p.setVisibility(0);
        this.p.measure(i3 - i, i4 - i2);
        int measuredWidth = this.p.getMeasuredWidth();
        int measuredHeight = this.p.getMeasuredHeight();
        this.p.layout(10, ((i4 - 5) - measuredHeight) - i2, measuredWidth + 10, (i4 - 5) - i2);
        this.q.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
        this.q.setVisibility(0);
        this.q.measure(i3 - i, i4 - i2);
        int measuredWidth2 = this.q.getMeasuredWidth();
        int measuredHeight2 = this.q.getMeasuredHeight();
        if (measuredHeight <= measuredHeight2) {
            measuredHeight = measuredHeight2;
        }
        this.q.layout((i3 - 10) - measuredWidth2, ((i4 - 5) - measuredHeight) - i2, i3 - 10, (i4 - 5) - i2);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = super.getChildAt(i5);
            if (childAt != this.q && childAt != this.p && childAt != this.b) {
                a(childAt, childAt.getLayoutParams());
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        int i = bundle.getInt("lat");
        int i2 = bundle.getInt("lon");
        if (i != 0 && i2 != 0) {
            a(new GeoPoint(i, i2));
        }
        int i3 = bundle.getInt("zoom");
        if (i3 != 0) {
            c(i3);
        }
        setTraffic(bundle.getBoolean("traffic"));
    }

    public void onSaveInstanceState(Bundle bundle) {
        GeoPoint mapCenter = getMapCenter();
        bundle.putInt("lat", mapCenter.getLatitudeE6());
        bundle.putInt("lon", mapCenter.getLongitudeE6());
        bundle.putInt("zoom", getZoomLevel());
        bundle.putBoolean("traffic", isTraffic());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = i;
        this.f = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b == null || !this.b.a(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.b.b(motionEvent)) {
            return true;
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void preLoad() {
    }

    public void regMapViewListener(BMapManager bMapManager, MKMapViewListener mKMapViewListener) {
        if (bMapManager == null || bMapManager.a == null) {
            return;
        }
        bMapManager.a.a(mKMapViewListener);
    }

    public void setBuiltInZoomControls(boolean z) {
        if (!z) {
            removeView(this.p);
            return;
        }
        if (this.r || this.p.getParent() != null) {
            removeView(this.p);
        }
        addView(this.p);
        this.r = true;
    }

    public void setDoubleClickZooming(boolean z) {
        this.b.a(z);
    }

    public void setDragMode(int i) {
        this.b.b(i);
    }

    public void setDrawOverlayWhenZooming(boolean z) {
        this.b.b(z);
    }

    public void setReticleDrawMode(a aVar) {
        throw new RuntimeException("this feature is not implemented!!");
    }

    public void setSatellite(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 1001);
        bundle.putInt("opt", 10020803);
        if (z) {
            bundle.putInt("on", 1);
        } else {
            bundle.putInt("on", 0);
        }
        Mj.sendBundle(bundle);
        this.k = z;
    }

    public void setStreetView(boolean z) {
        throw new RuntimeException("this feature is not implemented!!");
    }

    public void setTraffic(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 1001);
        bundle.putInt("opt", 10020400);
        if (z) {
            bundle.putInt("on", 1);
        } else {
            bundle.putInt("on", 0);
        }
        Mj.sendBundle(bundle);
        this.j = z;
    }
}
