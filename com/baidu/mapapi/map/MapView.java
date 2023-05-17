package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.io.File;
/* loaded from: classes3.dex */
public final class MapView extends ViewGroup {
    public static String b;
    public static final SparseIntArray q;
    public int A;
    public boolean B;
    public MapSurfaceView e;
    public BaiduMap f;
    public ImageView g;
    public Bitmap h;
    public com.baidu.mapsdkplatform.comapi.map.ad i;
    public Point j;
    public Point k;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public Context p;
    public int r;
    public boolean s;
    public boolean t;
    public float u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;
    public static final String a = MapView.class.getSimpleName();
    public static int c = 0;
    public static int d = 0;

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
    }

    public void cancelRenderMap() {
    }

    public boolean handleMultiTouch(float f, float f2, float f3, float f4) {
        return false;
    }

    public boolean handleTouchMove(float f, float f2) {
        return false;
    }

    public void renderMap() {
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.append(3, 2000000);
        q.append(4, 1000000);
        q.append(5, 500000);
        q.append(6, 200000);
        q.append(7, DefaultOggSeeker.MATCH_BYTE_RANGE);
        q.append(8, 50000);
        q.append(9, 25000);
        q.append(10, 20000);
        q.append(11, 10000);
        q.append(12, 5000);
        q.append(13, 2000);
        q.append(14, 1000);
        q.append(15, 500);
        q.append(16, 200);
        q.append(17, 100);
        q.append(18, 50);
        q.append(19, 20);
        q.append(20, 10);
        q.append(21, 5);
        q.append(22, 2);
        q.append(23, 2);
        q.append(24, 2);
        q.append(25, 2);
        q.append(26, 2);
    }

    public MapView(Context context) {
        super(context);
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(View view2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i2 = layoutParams.height;
        if (i2 > 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view2.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str != null && str.length() != 0) {
            if (new File(str).exists()) {
                b = str;
                return;
            }
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
    }

    @Deprecated
    public static void setIconCustom(int i) {
        d = i;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        c = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        if (view2 == this.g) {
            return;
        }
        if (c()) {
            super.removeView(view2);
        } else {
            com.baidu.platform.comapi.util.j.a(new u(this, view2), 0L);
        }
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.r = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.r = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyleEnable(boolean z) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView != null && mapSurfaceView.getBaseMap() != null) {
            this.e.getBaseMap().p(z);
        }
    }

    public void setMapCustomStylePath(String str) {
        a(str, "");
    }

    public void setScaleControlPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.j = point;
            requestLayout();
        }
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.e.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        int i;
        RelativeLayout relativeLayout = this.l;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        relativeLayout.setVisibility(i);
        this.t = z;
    }

    public void showZoomControls(boolean z) {
        int i;
        if (this.i.a()) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = this.i;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            adVar.setVisibility(i);
            this.s = z;
        }
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            super.addView(view2, layoutParams);
        }
    }

    public void handleTouchDown(float f, float f2) {
        if (this.e == null) {
        }
    }

    public boolean handleTouchUp(float f, float f2) {
        if (this.e == null) {
        }
        return false;
    }

    public boolean inRangeOfView(float f, float f2) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView != null && mapSurfaceView.inRangeOfView(f, f2)) {
            return true;
        }
        return false;
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, baiduMapOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "");
            setMapCustomStyleEnable(true);
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (!TextUtils.isEmpty(localCustomStyleFilePath)) {
            a(localCustomStyleFilePath, "");
            setMapCustomStyleEnable(true);
        }
    }

    private boolean c() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public final LogoPosition getLogoPosition() {
        int i = this.r;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return LogoPosition.logoPostionleftBottom;
                        }
                        return LogoPosition.logoPostionRightTop;
                    }
                    return LogoPosition.logoPostionRightBottom;
                }
                return LogoPosition.logoPostionCenterTop;
            }
            return LogoPosition.logoPostionCenterBottom;
        }
        return LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f;
        baiduMap.a = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return q.get(Math.round(this.e.getZoomLevel()));
    }

    public Point getScaleControlPosition() {
        return this.j;
    }

    public int getScaleControlViewHeight() {
        return this.z;
    }

    public int getScaleControlViewWidth() {
        return this.A;
    }

    public Point getZoomControlsPosition() {
        return this.k;
    }

    public boolean isShowScaleControl() {
        return this.t;
    }

    public final void onPause() {
        this.e.onPause();
    }

    public final void onResume() {
        this.e.onResume();
    }

    private void a(Context context) {
        String str;
        int densityDpi = SysOSUtil.getDensityDpi();
        if (densityDpi < 180) {
            str = "logo_l.png";
        } else {
            str = "logo_h.png";
        }
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
        if (a2 == null) {
            return;
        }
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi > 320) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        } else {
            this.h = a2;
        }
        if (this.h != null) {
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.h);
            addView(this.g);
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        this.p = context;
        com.baidu.mapsdkplatform.comapi.map.j.a();
        BMapManager.init();
        a(context, baiduMapOptions, b, c);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.i.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.l.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
            this.r = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.k = point2;
        }
        if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
            this.j = point;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        this.e = new MapSurfaceView(context);
        if (baiduMapOptions != null) {
            this.f = new BaiduMap(context, this.e, baiduMapOptions.a());
        } else {
            this.f = new BaiduMap(context, this.e, (com.baidu.mapsdkplatform.comapi.map.v) null);
        }
        addView(this.e);
        r rVar = new r(this);
        if (this.e.getBaseMap() != null) {
            this.e.getBaseMap().a(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView != null && mapSurfaceView.getBaseMap() != null) {
            if (TextUtils.isEmpty(str)) {
                Log.e(a, "customStyleFilePath is empty or null, please check!");
            } else if (!str.endsWith(".sty")) {
                Log.e(a, "customStyleFile format is incorrect , please check!");
            } else if (!new File(str).exists()) {
                Log.e(a, "customStyleFile does not exist , please check!");
            } else {
                this.e.getBaseMap().b(str, str2);
            }
        }
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.p, customMapStyleId, new q(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath != null && !localCustomStyleFilePath.isEmpty()) {
            a(localCustomStyleFilePath, "");
            setMapCustomStyleEnable(true);
        }
    }

    private void b(Context context) {
        com.baidu.mapsdkplatform.comapi.map.ad adVar = new com.baidu.mapsdkplatform.comapi.map.ad(context, false);
        this.i = adVar;
        if (!adVar.a()) {
            return;
        }
        this.i.b(new s(this));
        this.i.a(new t(this));
        addView(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        com.baidu.mapsdkplatform.comapi.map.ad adVar = this.i;
        if (adVar != null && adVar.a() && this.e.getBaseMap() != null) {
            float f = this.e.getBaseMap().D().a;
            com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.i;
            boolean z2 = true;
            if (f > this.e.getBaseMap().b) {
                z = true;
            } else {
                z = false;
            }
            adVar2.b(z);
            com.baidu.mapsdkplatform.comapi.map.ad adVar3 = this.i;
            if (f >= this.e.getBaseMap().a) {
                z2 = false;
            }
            adVar3.a(z2);
        }
    }

    private void c(Context context) {
        this.l = new RelativeLayout(context);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.m = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.m.setTextColor(Color.parseColor("#FFFFFF"));
        this.m.setTextSize(2, 11.0f);
        TextView textView = this.m;
        textView.setTypeface(textView.getTypeface(), 1);
        this.m.setLayoutParams(layoutParams);
        this.m.setId(Integer.MAX_VALUE);
        this.l.addView(this.m);
        this.n = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.n.setTextColor(Color.parseColor("#000000"));
        this.n.setTextSize(2, 11.0f);
        this.n.setLayoutParams(layoutParams2);
        this.l.addView(this.n);
        this.o = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.m.getId());
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams3);
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
            if (a2 != null) {
                byte[] ninePatchChunk = a2.getNinePatchChunk();
                if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
                }
            }
            this.l.addView(this.o);
        }
        addView(this.l);
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.j != null) {
            this.j = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.k != null) {
            this.k = (Point) bundle.getParcelable("zoomPosition");
        }
        this.s = bundle.getBoolean("mZoomControlEnabled");
        this.t = bundle.getBoolean("mScaleControlEnabled");
        this.r = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        BaiduMap baiduMap = this.f;
        if (baiduMap != null) {
            baiduMap.c();
        }
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView != null) {
            mapSurfaceView.unInit();
        }
        Bitmap bitmap = this.h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        if (b != null) {
            b = null;
        }
        this.i.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.j.b();
        this.p = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        Point point;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        int childCount = getChildCount();
        a(this.g);
        float f2 = 1.0f;
        if (((getWidth() - this.v) - this.w) - this.g.getMeasuredWidth() > 0 && ((getHeight() - this.x) - this.y) - this.g.getMeasuredHeight() > 0) {
            f2 = ((getWidth() - this.v) - this.w) / getWidth();
            f = ((getHeight() - this.x) - this.y) / getHeight();
        } else {
            this.v = 0;
            this.w = 0;
            this.y = 0;
            this.x = 0;
            f = 1.0f;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                MapSurfaceView mapSurfaceView = this.e;
                if (childAt == mapSurfaceView) {
                    mapSurfaceView.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.g;
                    if (childAt == imageView) {
                        float f3 = f2 * 5.0f;
                        int i6 = (int) (this.v + f3);
                        int i7 = (int) (this.w + f3);
                        float f4 = 5.0f * f;
                        int i8 = (int) (this.x + f4);
                        int i9 = (int) (this.y + f4);
                        int i10 = this.r;
                        if (i10 != 1) {
                            if (i10 != 2) {
                                if (i10 != 3) {
                                    if (i10 != 4) {
                                        if (i10 != 5) {
                                            measuredHeight = getHeight() - i9;
                                            measuredWidth = this.g.getMeasuredWidth() + i6;
                                            i8 = measuredHeight - this.g.getMeasuredHeight();
                                        } else {
                                            measuredHeight = i8 + imageView.getMeasuredHeight();
                                            measuredWidth = getWidth() - i7;
                                            measuredWidth2 = this.g.getMeasuredWidth();
                                        }
                                    } else {
                                        measuredHeight = getHeight() - i9;
                                        i8 = measuredHeight - this.g.getMeasuredHeight();
                                        measuredWidth = getWidth() - i7;
                                        measuredWidth2 = this.g.getMeasuredWidth();
                                    }
                                    i6 = measuredWidth - measuredWidth2;
                                } else {
                                    measuredHeight = i8 + imageView.getMeasuredHeight();
                                    i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                                    measuredWidth = (((getWidth() + this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                                }
                            } else {
                                measuredHeight = getHeight() - i9;
                                i8 = measuredHeight - this.g.getMeasuredHeight();
                                i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                                measuredWidth = (((getWidth() + this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                            }
                        } else {
                            measuredHeight = imageView.getMeasuredHeight() + i8;
                            measuredWidth = this.g.getMeasuredWidth() + i6;
                        }
                        this.g.layout(i6, i8, measuredWidth, measuredHeight);
                    } else {
                        com.baidu.mapsdkplatform.comapi.map.ad adVar = this.i;
                        if (childAt == adVar) {
                            if (adVar.a()) {
                                a(this.i);
                                Point point2 = this.k;
                                if (point2 == null) {
                                    int height = (int) (((getHeight() - 15) * f) + this.x);
                                    int width = (int) (((getWidth() - 15) * f2) + this.v);
                                    int measuredWidth3 = width - this.i.getMeasuredWidth();
                                    int measuredHeight2 = height - this.i.getMeasuredHeight();
                                    if (this.r == 4) {
                                        height -= this.g.getMeasuredHeight();
                                        measuredHeight2 -= this.g.getMeasuredHeight();
                                    }
                                    this.i.layout(measuredWidth3, measuredHeight2, width, height);
                                } else {
                                    com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.i;
                                    int i11 = point2.x;
                                    adVar2.layout(i11, point2.y, adVar2.getMeasuredWidth() + i11, this.k.y + this.i.getMeasuredHeight());
                                }
                            }
                        } else {
                            RelativeLayout relativeLayout = this.l;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point3 = this.j;
                                if (point3 == null) {
                                    this.A = this.l.getMeasuredWidth();
                                    this.z = this.l.getMeasuredHeight();
                                    int i12 = (int) (this.v + (5.0f * f2));
                                    int height2 = (getHeight() - ((int) ((this.y + (f * 5.0f)) + 56.0f))) - this.g.getMeasuredHeight();
                                    this.l.layout(i12, height2, this.A + i12, this.z + height2);
                                } else {
                                    RelativeLayout relativeLayout2 = this.l;
                                    int i13 = point3.x;
                                    relativeLayout2.layout(i13, point3.y, relativeLayout2.getMeasuredWidth() + i13, this.j.y + this.l.getMeasuredHeight());
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    if (mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {
                                        point = mapViewLayoutParams.b;
                                    } else {
                                        GeoPoint ll2mc = CoordUtil.ll2mc(mapViewLayoutParams.a);
                                        if (this.e.getBaseMap() != null) {
                                            point = this.e.getBaseMap().a(ll2mc);
                                        } else {
                                            point = new Point();
                                        }
                                    }
                                    a(childAt);
                                    int measuredWidth4 = childAt.getMeasuredWidth();
                                    int measuredHeight3 = childAt.getMeasuredHeight();
                                    float f5 = mapViewLayoutParams.d;
                                    float f6 = mapViewLayoutParams.e;
                                    int i14 = (int) (point.x - (f5 * measuredWidth4));
                                    int i15 = ((int) (point.y - (f6 * measuredHeight3))) + mapViewLayoutParams.f;
                                    childAt.layout(i14, i15, measuredWidth4 + i14, measuredHeight3 + i15);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle != null && (baiduMap = this.f) != null) {
            bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
            bundle.putBoolean("mZoomControlEnabled", this.s);
            bundle.putBoolean("mScaleControlEnabled", this.t);
            bundle.putInt("logoPosition", this.r);
            bundle.putInt("paddingLeft", this.v);
            bundle.putInt("paddingTop", this.x);
            bundle.putInt("paddingRight", this.w);
            bundle.putInt("paddingBottom", this.y);
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.v = i;
        this.x = i2;
        this.w = i3;
        this.y = i4;
    }
}
