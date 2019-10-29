package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
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
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ac;
import com.baidu.mapsdkplatform.comapi.map.ak;
import java.io.File;
/* loaded from: classes5.dex */
public final class TextureMapView extends ViewGroup {
    private static String i;
    private int A;
    private ac b;
    private BaiduMap c;
    private ImageView d;
    private Bitmap e;
    private ak f;
    private Point g;
    private Point h;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private Context o;
    private float q;
    private com.baidu.mapsdkplatform.comapi.map.l r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;
    private static final String a = TextureMapView.class.getSimpleName();
    private static int j = 0;
    private static final SparseArray<Integer> p = new SparseArray<>();

    static {
        p.append(3, 2000000);
        p.append(4, Integer.valueOf((int) MessageConfig.BASE_SEGMENT_LENGTH));
        p.append(5, 500000);
        p.append(6, 200000);
        p.append(7, 100000);
        p.append(8, Integer.valueOf((int) IMConstants.ERROR_BASE));
        p.append(9, 25000);
        p.append(10, Integer.valueOf((int) MessageConfig.SOCKET_TIME_OUT_MS_2G));
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
    }

    public TextureMapView(Context context) {
        super(context);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        a(context, baiduMapOptions);
    }

    private void a(Context context) {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.e = a2;
        } else {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        }
        if (this.e != null) {
            this.d = new ImageView(context);
            this.d.setImageBitmap(this.e);
            addView(this.d);
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        setBackgroundColor(-1);
        this.o = context;
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        a(context, baiduMapOptions, i, j);
        this.c = new BaiduMap(this.b);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.f.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.k.setVisibility(4);
        }
        if (baiduMapOptions != null && baiduMapOptions.j != null) {
            this.s = baiduMapOptions.j.ordinal();
        }
        if (baiduMapOptions != null && baiduMapOptions.l != null) {
            this.h = baiduMapOptions.l;
        }
        if (baiduMapOptions == null || baiduMapOptions.k == null) {
            return;
        }
        this.g = baiduMapOptions.k;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i2) {
        i = str;
        if (baiduMapOptions == null) {
            this.b = new ac(context, null, str, i2);
        } else {
            this.b = new ac(context, baiduMapOptions.a(), str, i2);
        }
        addView(this.b);
        this.r = new s(this);
        this.b.b().a(this.r);
    }

    private void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i2 = layoutParams.width;
        int makeMeasureSpec = i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
        int i3 = layoutParams.height;
        view.measure(makeMeasureSpec, i3 > 0 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f.a()) {
            float f = this.b.b().E().a;
            this.f.b(f > this.b.b().b);
            this.f.a(f < this.b.b().a);
        }
    }

    private void b(Context context) {
        this.f = new ak(context);
        if (this.f.a()) {
            this.f.b(new t(this));
            this.f.a(new u(this));
            addView(this.f);
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
        this.l.setTypeface(this.l.getTypeface(), 1);
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
        i = str;
    }

    public static void setIconCustom(int i2) {
        j = i2;
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

    public final LogoPosition getLogoPosition() {
        switch (this.s) {
            case 1:
                return LogoPosition.logoPostionleftTop;
            case 2:
                return LogoPosition.logoPostionCenterBottom;
            case 3:
                return LogoPosition.logoPostionCenterTop;
            case 4:
                return LogoPosition.logoPostionRightBottom;
            case 5:
                return LogoPosition.logoPostionRightTop;
            default:
                return LogoPosition.logoPostionleftBottom;
        }
    }

    public final BaiduMap getMap() {
        this.c.b = this;
        return this.c;
    }

    public final int getMapLevel() {
        return p.get((int) this.b.b().E().a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.A;
    }

    public int getScaleControlViewWidth() {
        return this.A;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        i = bundle.getString("customMapPath");
        if (bundle == null) {
            a(context, new BaiduMapOptions());
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.g != null) {
            this.g = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.h != null) {
            this.h = (Point) bundle.getParcelable("zoomPosition");
        }
        this.t = bundle.getBoolean("mZoomControlEnabled");
        this.u = bundle.getBoolean("mScaleControlEnabled");
        this.s = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        if (this.o != null) {
            this.b.a(this.o.hashCode());
        }
        if (this.e != null && !this.e.isRecycled()) {
            this.e.recycle();
        }
        this.f.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        this.o = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    protected final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f;
        float f2;
        int measuredHeight;
        int width;
        int childCount = getChildCount();
        a(this.d);
        if (((getWidth() - this.v) - this.w) - this.d.getMeasuredWidth() <= 0 || ((getHeight() - this.x) - this.y) - this.d.getMeasuredHeight() <= 0) {
            this.v = 0;
            this.w = 0;
            this.y = 0;
            this.x = 0;
            f = 1.0f;
            f2 = 1.0f;
        } else {
            f = ((getWidth() - this.v) - this.w) / getWidth();
            f2 = ((getHeight() - this.x) - this.y) / getHeight();
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt == this.b) {
                this.b.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.d) {
                int i7 = (int) (this.v + (5.0f * f));
                int i8 = (int) (this.w + (5.0f * f));
                int i9 = (int) (this.x + (5.0f * f2));
                int i10 = (int) (this.y + (5.0f * f2));
                switch (this.s) {
                    case 1:
                        measuredHeight = i9 + this.d.getMeasuredHeight();
                        width = this.d.getMeasuredWidth() + i7;
                        break;
                    case 2:
                        measuredHeight = getHeight() - i10;
                        i9 = measuredHeight - this.d.getMeasuredHeight();
                        i7 = (((getWidth() - this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                        width = (((getWidth() + this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                        break;
                    case 3:
                        measuredHeight = i9 + this.d.getMeasuredHeight();
                        i7 = (((getWidth() - this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                        width = (((getWidth() + this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                        break;
                    case 4:
                        measuredHeight = getHeight() - i10;
                        i9 = measuredHeight - this.d.getMeasuredHeight();
                        width = getWidth() - i8;
                        i7 = width - this.d.getMeasuredWidth();
                        break;
                    case 5:
                        measuredHeight = i9 + this.d.getMeasuredHeight();
                        width = getWidth() - i8;
                        i7 = width - this.d.getMeasuredWidth();
                        break;
                    default:
                        measuredHeight = getHeight() - i10;
                        width = this.d.getMeasuredWidth() + i7;
                        i9 = measuredHeight - this.d.getMeasuredHeight();
                        break;
                }
                this.d.layout(i7, i9, width, measuredHeight);
            } else if (childAt == this.f) {
                if (this.f.a()) {
                    a(this.f);
                    if (this.h == null) {
                        int height = (int) (((getHeight() - 15) * f2) + this.x);
                        int width2 = (int) (((getWidth() - 15) * f) + this.v);
                        int measuredWidth = width2 - this.f.getMeasuredWidth();
                        int measuredHeight2 = height - this.f.getMeasuredHeight();
                        if (this.s == 4) {
                            height -= this.d.getMeasuredHeight();
                            measuredHeight2 -= this.d.getMeasuredHeight();
                        }
                        this.f.layout(measuredWidth, measuredHeight2, width2, height);
                    } else {
                        this.f.layout(this.h.x, this.h.y, this.h.x + this.f.getMeasuredWidth(), this.h.y + this.f.getMeasuredHeight());
                    }
                }
            } else if (childAt == this.k) {
                a(this.k);
                if (this.g == null) {
                    this.A = this.k.getMeasuredWidth();
                    this.z = this.k.getMeasuredHeight();
                    int i11 = (int) (this.v + (5.0f * f));
                    int height2 = (getHeight() - ((int) ((this.y + (5.0f * f2)) + 56.0f))) - this.d.getMeasuredHeight();
                    this.k.layout(i11, height2, this.A + i11, this.z + height2);
                } else {
                    this.k.layout(this.g.x, this.g.y, this.g.x + this.k.getMeasuredWidth(), this.g.y + this.k.getMeasuredHeight());
                }
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof MapViewLayoutParams) {
                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                    Point a2 = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.b : this.b.b().a(CoordUtil.ll2mc(mapViewLayoutParams.a));
                    a(childAt);
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    int measuredHeight3 = childAt.getMeasuredHeight();
                    int i12 = (int) (a2.x - (mapViewLayoutParams.d * measuredWidth2));
                    int i13 = mapViewLayoutParams.f + ((int) (a2.y - (mapViewLayoutParams.e * measuredHeight3)));
                    childAt.layout(i12, i13, i12 + measuredWidth2, i13 + measuredHeight3);
                }
            }
        }
    }

    public final void onPause() {
        this.b.d();
    }

    public final void onResume() {
        this.b.c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null || this.c == null) {
            return;
        }
        bundle.putParcelable("mapstatus", this.c.getMapStatus());
        if (this.g != null) {
            bundle.putParcelable("scalePosition", this.g);
        }
        if (this.h != null) {
            bundle.putParcelable("zoomPosition", this.h);
        }
        bundle.putBoolean("mZoomControlEnabled", this.t);
        bundle.putBoolean("mScaleControlEnabled", this.u);
        bundle.putInt("logoPosition", this.s);
        bundle.putInt("paddingLeft", this.v);
        bundle.putInt("paddingTop", this.x);
        bundle.putInt("paddingRight", this.w);
        bundle.putInt("paddingBottom", this.y);
        bundle.putString("customMapPath", i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.d) {
            return;
        }
        super.removeView(view);
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.s = LogoPosition.logoPostionleftBottom.ordinal();
        }
        this.s = logoPosition.ordinal();
        requestLayout();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.v = i2;
        this.x = i3;
        this.w = i4;
        this.y = i5;
    }

    public void setScaleControlPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.g = point;
            requestLayout();
        }
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.h = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
        this.u = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f.a()) {
            this.f.setVisibility(z ? 0 : 8);
            this.t = z;
        }
    }
}
