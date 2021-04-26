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
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ac;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
/* loaded from: classes2.dex */
public final class TextureMapView extends ViewGroup {

    /* renamed from: i  reason: collision with root package name */
    public static String f7311i;
    public static final SparseArray<Integer> p;
    public int A;

    /* renamed from: b  reason: collision with root package name */
    public ac f7312b;

    /* renamed from: c  reason: collision with root package name */
    public BaiduMap f7313c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f7314d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f7315e;

    /* renamed from: f  reason: collision with root package name */
    public ak f7316f;

    /* renamed from: g  reason: collision with root package name */
    public Point f7317g;

    /* renamed from: h  reason: collision with root package name */
    public Point f7318h;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public Context o;
    public float q;
    public com.baidu.mapsdkplatform.comapi.map.l r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7310a = TextureMapView.class.getSimpleName();
    public static int j = 0;

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
            this.f7315e = a2;
            if (this.f7315e == null) {
                ImageView imageView = new ImageView(context);
                this.f7314d = imageView;
                imageView.setImageBitmap(this.f7315e);
                addView(this.f7314d);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f7315e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f7315e == null) {
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        setBackgroundColor(-1);
        this.o = context;
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        a(context, baiduMapOptions, f7311i, j);
        this.f7313c = new BaiduMap(this.f7312b);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f7095h) {
            this.f7316f.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.f7096i) {
            this.k.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
            this.s = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.f7318h = point2;
        }
        if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
            return;
        }
        this.f7317g = point;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i2) {
        f7311i = str;
        if (baiduMapOptions == null) {
            this.f7312b = new ac(context, null, str, i2);
        } else {
            this.f7312b = new ac(context, baiduMapOptions.a(), str, i2);
        }
        addView(this.f7312b);
        this.r = new s(this);
        this.f7312b.b().a(this.r);
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
        if (this.f7316f.a()) {
            float f2 = this.f7312b.b().E().f7874a;
            this.f7316f.b(f2 > this.f7312b.b().f7922b);
            this.f7316f.a(f2 < this.f7312b.b().f7921a);
        }
    }

    private void b(Context context) {
        ak akVar = new ak(context);
        this.f7316f = akVar;
        if (akVar.a()) {
            this.f7316f.b(new t(this));
            this.f7316f.a(new u(this));
            addView(this.f7316f);
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
        f7311i = str;
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
        int i2 = this.s;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f7313c;
        baiduMap.f7081b = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return p.get((int) this.f7312b.b().E().f7874a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.A;
    }

    public int getScaleControlViewWidth() {
        return this.A;
    }

    public void onCreate(Context context, Bundle bundle) {
        BaiduMapOptions mapStatus;
        if (bundle == null) {
            return;
        }
        f7311i = bundle.getString("customMapPath");
        if (bundle == null) {
            mapStatus = new BaiduMapOptions();
        } else {
            MapStatus mapStatus2 = (MapStatus) bundle.getParcelable("mapstatus");
            if (this.f7317g != null) {
                this.f7317g = (Point) bundle.getParcelable("scalePosition");
            }
            if (this.f7318h != null) {
                this.f7318h = (Point) bundle.getParcelable("zoomPosition");
            }
            this.t = bundle.getBoolean("mZoomControlEnabled");
            this.u = bundle.getBoolean("mScaleControlEnabled");
            this.s = bundle.getInt("logoPosition");
            setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
            mapStatus = new BaiduMapOptions().mapStatus(mapStatus2);
        }
        a(context, mapStatus);
    }

    public final void onDestroy() {
        Context context = this.o;
        if (context != null) {
            this.f7312b.a(context.hashCode());
        }
        Bitmap bitmap = this.f7315e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7315e.recycle();
        }
        this.f7316f.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        this.o = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int measuredHeight;
        int measuredWidth;
        int childCount = getChildCount();
        a(this.f7314d);
        float f3 = 1.0f;
        if (((getWidth() - this.v) - this.w) - this.f7314d.getMeasuredWidth() <= 0 || ((getHeight() - this.x) - this.y) - this.f7314d.getMeasuredHeight() <= 0) {
            this.v = 0;
            this.w = 0;
            this.y = 0;
            this.x = 0;
            f2 = 1.0f;
        } else {
            f3 = ((getWidth() - this.v) - this.w) / getWidth();
            f2 = ((getHeight() - this.x) - this.y) / getHeight();
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            ac acVar = this.f7312b;
            if (childAt == acVar) {
                acVar.layout(0, 0, getWidth(), getHeight());
            } else {
                ImageView imageView = this.f7314d;
                if (childAt == imageView) {
                    float f4 = f3 * 5.0f;
                    int i7 = (int) (this.v + f4);
                    int i8 = (int) (this.w + f4);
                    float f5 = 5.0f * f2;
                    int i9 = (int) (this.x + f5);
                    int i10 = (int) (this.y + f5);
                    int i11 = this.s;
                    if (i11 != 1) {
                        if (i11 == 2) {
                            measuredHeight = getHeight() - i10;
                            i9 = measuredHeight - this.f7314d.getMeasuredHeight();
                        } else if (i11 != 3) {
                            if (i11 == 4) {
                                measuredHeight = getHeight() - i10;
                                i9 = measuredHeight - this.f7314d.getMeasuredHeight();
                            } else if (i11 != 5) {
                                measuredHeight = getHeight() - i10;
                                measuredWidth = this.f7314d.getMeasuredWidth() + i7;
                                i9 = measuredHeight - this.f7314d.getMeasuredHeight();
                            } else {
                                measuredHeight = i9 + imageView.getMeasuredHeight();
                            }
                            measuredWidth = getWidth() - i8;
                            i7 = measuredWidth - this.f7314d.getMeasuredWidth();
                        } else {
                            measuredHeight = i9 + imageView.getMeasuredHeight();
                        }
                        i7 = (((getWidth() - this.f7314d.getMeasuredWidth()) + this.v) - this.w) / 2;
                        measuredWidth = (((getWidth() + this.f7314d.getMeasuredWidth()) + this.v) - this.w) / 2;
                    } else {
                        measuredHeight = imageView.getMeasuredHeight() + i9;
                        measuredWidth = this.f7314d.getMeasuredWidth() + i7;
                    }
                    this.f7314d.layout(i7, i9, measuredWidth, measuredHeight);
                } else {
                    ak akVar = this.f7316f;
                    if (childAt != akVar) {
                        RelativeLayout relativeLayout = this.k;
                        if (childAt == relativeLayout) {
                            a(relativeLayout);
                            Point point = this.f7317g;
                            if (point == null) {
                                this.A = this.k.getMeasuredWidth();
                                this.z = this.k.getMeasuredHeight();
                                int i12 = (int) (this.v + (5.0f * f3));
                                int height = (getHeight() - ((int) ((this.y + (f2 * 5.0f)) + 56.0f))) - this.f7314d.getMeasuredHeight();
                                this.k.layout(i12, height, this.A + i12, this.z + height);
                            } else {
                                RelativeLayout relativeLayout2 = this.k;
                                int i13 = point.x;
                                relativeLayout2.layout(i13, point.y, relativeLayout2.getMeasuredWidth() + i13, this.f7317g.y + this.k.getMeasuredHeight());
                            }
                        } else {
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            if (layoutParams instanceof MapViewLayoutParams) {
                                MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                Point a2 = mapViewLayoutParams.f7210c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f7209b : this.f7312b.b().a(CoordUtil.ll2mc(mapViewLayoutParams.f7208a));
                                a(childAt);
                                int measuredWidth2 = childAt.getMeasuredWidth();
                                int measuredHeight2 = childAt.getMeasuredHeight();
                                float f6 = mapViewLayoutParams.f7211d;
                                int i14 = (int) (a2.x - (f6 * measuredWidth2));
                                int i15 = ((int) (a2.y - (mapViewLayoutParams.f7212e * measuredHeight2))) + mapViewLayoutParams.f7213f;
                                childAt.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
                            }
                        }
                    } else if (akVar.a()) {
                        a(this.f7316f);
                        Point point2 = this.f7318h;
                        if (point2 == null) {
                            int height2 = (int) (((getHeight() - 15) * f2) + this.x);
                            int width = (int) (((getWidth() - 15) * f3) + this.v);
                            int measuredWidth3 = width - this.f7316f.getMeasuredWidth();
                            int measuredHeight3 = height2 - this.f7316f.getMeasuredHeight();
                            if (this.s == 4) {
                                height2 -= this.f7314d.getMeasuredHeight();
                                measuredHeight3 -= this.f7314d.getMeasuredHeight();
                            }
                            this.f7316f.layout(measuredWidth3, measuredHeight3, width, height2);
                        } else {
                            ak akVar2 = this.f7316f;
                            int i16 = point2.x;
                            akVar2.layout(i16, point2.y, akVar2.getMeasuredWidth() + i16, this.f7318h.y + this.f7316f.getMeasuredHeight());
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f7312b.d();
    }

    public final void onResume() {
        this.f7312b.c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f7313c) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f7317g;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f7318h;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.t);
        bundle.putBoolean("mScaleControlEnabled", this.u);
        bundle.putInt("logoPosition", this.s);
        bundle.putInt("paddingLeft", this.v);
        bundle.putInt("paddingTop", this.x);
        bundle.putInt("paddingRight", this.w);
        bundle.putInt("paddingBottom", this.y);
        bundle.putString("customMapPath", f7311i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f7314d) {
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
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.f7317g = point;
            requestLayout();
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.f7318h = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
        this.u = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f7316f.a()) {
            this.f7316f.setVisibility(z ? 0 : 8);
            this.t = z;
        }
    }
}
