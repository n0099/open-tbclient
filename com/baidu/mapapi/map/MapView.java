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
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
/* loaded from: classes2.dex */
public final class MapView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public static String f6920b;
    public static final SparseArray<Integer> p;
    public int A;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f6922d;

    /* renamed from: e  reason: collision with root package name */
    public BaiduMap f6923e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f6924f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f6925g;

    /* renamed from: h  reason: collision with root package name */
    public ak f6926h;
    public Point i;
    public Point j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public Context o;
    public int q;
    public boolean r;
    public boolean s;
    public float t;
    public com.baidu.mapsdkplatform.comapi.map.l u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* renamed from: a  reason: collision with root package name */
    public static final String f6919a = MapView.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static int f6921c = 0;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        p = sparseArray;
        sparseArray.append(3, 2000000);
        p.append(4, 1000000);
        p.append(5, 500000);
        p.append(6, 200000);
        p.append(7, 100000);
        p.append(8, Integer.valueOf((int) IMConstants.ERROR_BASE));
        p.append(9, Integer.valueOf((int) BdNetTask.TIMEOUT_READ));
        p.append(10, 20000);
        p.append(11, 10000);
        p.append(12, 5000);
        p.append(13, 2000);
        p.append(14, 1000);
        p.append(15, 500);
        p.append(16, 200);
        p.append(17, 100);
        p.append(18, 50);
        p.append(19, 20);
        p.append(20, 10);
        p.append(21, 5);
        p.append(22, 2);
        p.append(23, 2);
        p.append(24, 2);
        p.append(25, 2);
        p.append(26, 2);
    }

    public MapView(Context context) {
        super(context);
        this.q = LogoPosition.logoPostionleftBottom.ordinal();
        this.r = true;
        this.s = true;
        a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = LogoPosition.logoPostionleftBottom.ordinal();
        this.r = true;
        this.s = true;
        a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = LogoPosition.logoPostionleftBottom.ordinal();
        this.r = true;
        this.s = true;
        a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.q = LogoPosition.logoPostionleftBottom.ordinal();
        this.r = true;
        this.s = true;
        a(context, baiduMapOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context) {
        Matrix matrix;
        float f2;
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            matrix = new Matrix();
            f2 = 2.0f;
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.f6925g = a2;
            if (this.f6925g == null) {
                ImageView imageView = new ImageView(context);
                this.f6924f = imageView;
                imageView.setImageBitmap(this.f6925g);
                addView(this.f6924f);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f6925g = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f6925g == null) {
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        this.o = context;
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        a(context, baiduMapOptions, f6920b, f6921c);
        this.f6923e = new BaiduMap(this.f6922d);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6821h) {
            this.f6926h.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.k.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
            this.q = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.j = point2;
        }
        if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
            return;
        }
        this.i = point;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        if (baiduMapOptions == null) {
            this.f6922d = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, i);
        } else {
            this.f6922d = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, i);
        }
        addView(this.f6922d);
        this.u = new k(this);
        this.f6922d.a().a(this.u);
    }

    private void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        int makeMeasureSpec = i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = layoutParams.height;
        view.measure(makeMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f6926h.a()) {
            float f2 = this.f6922d.a().E().f7569a;
            this.f6926h.b(f2 > this.f6922d.a().f7613b);
            this.f6926h.a(f2 < this.f6922d.a().f7612a);
        }
    }

    private void b(Context context) {
        ak akVar = new ak(context, false);
        this.f6926h = akVar;
        if (akVar.a()) {
            this.f6926h.b(new l(this));
            this.f6926h.a(new m(this));
            addView(this.f6926h);
        }
    }

    private void c(Context context) {
        this.k = new RelativeLayout(context);
        this.k.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.l = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.l.setTextColor(Color.parseColor("#FFFFFF"));
        this.l.setTextSize(2, 11.0f);
        TextView textView = this.l;
        textView.setTypeface(textView.getTypeface(), 1);
        this.l.setLayoutParams(layoutParams);
        this.l.setId(Integer.MAX_VALUE);
        this.k.addView(this.l);
        this.m = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.m.setTextColor(Color.parseColor("#000000"));
        this.m.setTextSize(2, 11.0f);
        this.m.setLayoutParams(layoutParams2);
        this.k.addView(this.m);
        this.n = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.l.getId());
        this.n.setLayoutParams(layoutParams3);
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.n.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        this.k.addView(this.n);
        addView(this.k);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
        f6920b = str;
    }

    public static void setIconCustom(int i) {
        f6921c = i;
    }

    public static void setMapCustomEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.i.a(z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view, layoutParams);
        }
    }

    public void cancelRenderMap() {
        this.f6922d.a().v(false);
        this.f6922d.a().O().clear();
    }

    public final LogoPosition getLogoPosition() {
        int i = this.q;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f6923e;
        baiduMap.f6807a = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return p.get((int) this.f6922d.a().E().f7569a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.z;
    }

    public int getScaleControlViewWidth() {
        return this.A;
    }

    public boolean handleMultiTouch(float f2, float f3, float f4, float f5) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6922d;
        return jVar != null && jVar.a(f2, f3, f4, f5);
    }

    public void handleTouchDown(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6922d;
        if (jVar == null) {
            return;
        }
        jVar.a(f2, f3);
    }

    public boolean handleTouchMove(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6922d;
        return jVar != null && jVar.c(f2, f3);
    }

    public boolean handleTouchUp(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6922d;
        if (jVar == null) {
            return false;
        }
        return jVar.b(f2, f3);
    }

    public boolean inRangeOfView(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6922d;
        return jVar != null && jVar.d(f2, f3);
    }

    public void onCreate(Context context, Bundle bundle) {
        BaiduMapOptions mapStatus;
        if (bundle == null) {
            return;
        }
        f6920b = bundle.getString("customMapPath");
        if (bundle == null) {
            mapStatus = new BaiduMapOptions();
        } else {
            MapStatus mapStatus2 = (MapStatus) bundle.getParcelable("mapstatus");
            if (this.i != null) {
                this.i = (Point) bundle.getParcelable("scalePosition");
            }
            if (this.j != null) {
                this.j = (Point) bundle.getParcelable("zoomPosition");
            }
            this.r = bundle.getBoolean("mZoomControlEnabled");
            this.s = bundle.getBoolean("mScaleControlEnabled");
            this.q = bundle.getInt("logoPosition");
            setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
            mapStatus = new BaiduMapOptions().mapStatus(mapStatus2);
        }
        a(context, mapStatus);
    }

    public final void onDestroy() {
        Context context = this.o;
        if (context != null) {
            this.f6922d.b(context.hashCode());
        }
        Bitmap bitmap = this.f6925g;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f6925g.recycle();
            this.f6925g = null;
        }
        if (f6920b != null) {
            f6920b = null;
        }
        this.f6926h.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        this.o = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f2;
        int measuredHeight;
        int measuredWidth;
        int childCount = getChildCount();
        a(this.f6924f);
        float f3 = 1.0f;
        if (((getWidth() - this.v) - this.w) - this.f6924f.getMeasuredWidth() <= 0 || ((getHeight() - this.x) - this.y) - this.f6924f.getMeasuredHeight() <= 0) {
            this.v = 0;
            this.w = 0;
            this.y = 0;
            this.x = 0;
            f2 = 1.0f;
        } else {
            f3 = ((getWidth() - this.v) - this.w) / getWidth();
            f2 = ((getHeight() - this.x) - this.y) / getHeight();
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6922d;
                if (childAt == jVar) {
                    jVar.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.f6924f;
                    if (childAt == imageView) {
                        float f4 = f3 * 5.0f;
                        int i6 = (int) (this.v + f4);
                        int i7 = (int) (this.w + f4);
                        float f5 = 5.0f * f2;
                        int i8 = (int) (this.x + f5);
                        int i9 = (int) (this.y + f5);
                        int i10 = this.q;
                        if (i10 != 1) {
                            if (i10 == 2) {
                                measuredHeight = getHeight() - i9;
                                i8 = measuredHeight - this.f6924f.getMeasuredHeight();
                            } else if (i10 != 3) {
                                if (i10 == 4) {
                                    measuredHeight = getHeight() - i9;
                                    i8 = measuredHeight - this.f6924f.getMeasuredHeight();
                                } else if (i10 != 5) {
                                    measuredHeight = getHeight() - i9;
                                    measuredWidth = this.f6924f.getMeasuredWidth() + i6;
                                    i8 = measuredHeight - this.f6924f.getMeasuredHeight();
                                } else {
                                    measuredHeight = i8 + imageView.getMeasuredHeight();
                                }
                                measuredWidth = getWidth() - i7;
                                i6 = measuredWidth - this.f6924f.getMeasuredWidth();
                            } else {
                                measuredHeight = i8 + imageView.getMeasuredHeight();
                            }
                            i6 = (((getWidth() - this.f6924f.getMeasuredWidth()) + this.v) - this.w) / 2;
                            measuredWidth = (((getWidth() + this.f6924f.getMeasuredWidth()) + this.v) - this.w) / 2;
                        } else {
                            measuredHeight = imageView.getMeasuredHeight() + i8;
                            measuredWidth = this.f6924f.getMeasuredWidth() + i6;
                        }
                        this.f6924f.layout(i6, i8, measuredWidth, measuredHeight);
                    } else {
                        ak akVar = this.f6926h;
                        if (childAt != akVar) {
                            RelativeLayout relativeLayout = this.k;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point = this.i;
                                if (point == null) {
                                    this.A = this.k.getMeasuredWidth();
                                    this.z = this.k.getMeasuredHeight();
                                    int i11 = (int) (this.v + (5.0f * f3));
                                    int height = (getHeight() - ((int) ((this.y + (f2 * 5.0f)) + 56.0f))) - this.f6924f.getMeasuredHeight();
                                    this.k.layout(i11, height, this.A + i11, this.z + height);
                                } else {
                                    RelativeLayout relativeLayout2 = this.k;
                                    int i12 = point.x;
                                    relativeLayout2.layout(i12, point.y, relativeLayout2.getMeasuredWidth() + i12, this.i.y + this.k.getMeasuredHeight());
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams == null) {
                                    Log.e("test", "lp == null");
                                }
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    Point a2 = mapViewLayoutParams.f6929c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f6928b : this.f6922d.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f6927a));
                                    a(childAt);
                                    int measuredWidth2 = childAt.getMeasuredWidth();
                                    int measuredHeight2 = childAt.getMeasuredHeight();
                                    float f6 = mapViewLayoutParams.f6930d;
                                    int i13 = (int) (a2.x - (f6 * measuredWidth2));
                                    int i14 = ((int) (a2.y - (mapViewLayoutParams.f6931e * measuredHeight2))) + mapViewLayoutParams.f6932f;
                                    childAt.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
                                }
                            }
                        } else if (akVar.a()) {
                            a(this.f6926h);
                            Point point2 = this.j;
                            if (point2 == null) {
                                int height2 = (int) (((getHeight() - 15) * f2) + this.x);
                                int width = (int) (((getWidth() - 15) * f3) + this.v);
                                int measuredWidth3 = width - this.f6926h.getMeasuredWidth();
                                int measuredHeight3 = height2 - this.f6926h.getMeasuredHeight();
                                if (this.q == 4) {
                                    height2 -= this.f6924f.getMeasuredHeight();
                                    measuredHeight3 -= this.f6924f.getMeasuredHeight();
                                }
                                this.f6926h.layout(measuredWidth3, measuredHeight3, width, height2);
                            } else {
                                ak akVar2 = this.f6926h;
                                int i15 = point2.x;
                                akVar2.layout(i15, point2.y, akVar2.getMeasuredWidth() + i15, this.j.y + this.f6926h.getMeasuredHeight());
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f6922d.onPause();
    }

    public final void onResume() {
        this.f6922d.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f6923e) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.i;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.j;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.r);
        bundle.putBoolean("mScaleControlEnabled", this.s);
        bundle.putInt("logoPosition", this.q);
        bundle.putInt("paddingLeft", this.v);
        bundle.putInt("paddingTop", this.x);
        bundle.putInt("paddingRight", this.w);
        bundle.putInt("paddingBottom", this.y);
        bundle.putString("customMapPath", f6920b);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f6924f) {
            return;
        }
        super.removeView(view);
    }

    public void renderMap() {
        com.baidu.mapsdkplatform.comapi.map.e a2 = this.f6922d.a();
        a2.v(true);
        a2.P();
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.q = LogoPosition.logoPostionleftBottom.ordinal();
        }
        this.q = logoPosition.ordinal();
        requestLayout();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.v = i;
        this.x = i2;
        this.w = i3;
        this.y = i4;
    }

    public void setScaleControlPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.i = point;
            requestLayout();
        }
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.f6922d.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6922d;
        if (jVar == null) {
            return;
        }
        jVar.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.j = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
        this.s = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f6926h.a()) {
            this.f6926h.setVisibility(z ? 0 : 8);
            this.r = z;
        }
    }
}
