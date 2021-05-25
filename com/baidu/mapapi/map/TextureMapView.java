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
import com.baidu.mapsdkplatform.comapi.util.CustomMapStyleLoader;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
/* loaded from: classes2.dex */
public final class TextureMapView extends ViewGroup {

    /* renamed from: i  reason: collision with root package name */
    public static String f7027i;
    public static final SparseArray<Integer> q;
    public int A;
    public int B;

    /* renamed from: b  reason: collision with root package name */
    public ac f7028b;

    /* renamed from: c  reason: collision with root package name */
    public BaiduMap f7029c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f7030d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f7031e;

    /* renamed from: f  reason: collision with root package name */
    public ak f7032f;

    /* renamed from: g  reason: collision with root package name */
    public Point f7033g;

    /* renamed from: h  reason: collision with root package name */
    public Point f7034h;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public Context p;
    public float r;
    public com.baidu.mapsdkplatform.comapi.map.l s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7026a = TextureMapView.class.getSimpleName();
    public static int j = 0;
    public static int k = 0;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        q = sparseArray;
        sparseArray.append(3, 2000000);
        q.append(4, 1000000);
        q.append(5, 500000);
        q.append(6, 200000);
        q.append(7, 100000);
        q.append(8, Integer.valueOf((int) IMConstants.ERROR_BASE));
        q.append(9, Integer.valueOf((int) BdNetTask.TIMEOUT_READ));
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
    }

    public TextureMapView(Context context) {
        super(context);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
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
            this.f7031e = a2;
            if (this.f7031e == null) {
                ImageView imageView = new ImageView(context);
                this.f7030d = imageView;
                imageView.setImageBitmap(this.f7031e);
                addView(this.f7030d);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f7031e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f7031e == null) {
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        setBackgroundColor(-1);
        this.p = context;
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        a(context, baiduMapOptions, j == 0 ? f7027i : CustomMapStyleLoader.getCustomStyleFilePath(), k);
        this.f7029c = new BaiduMap(this.f7028b);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6806h) {
            this.f7032f.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6807i) {
            this.l.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
            this.t = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.f7034h = point2;
        }
        if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
            return;
        }
        this.f7033g = point;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i2) {
        if (baiduMapOptions == null) {
            this.f7028b = new ac(context, null, str, i2);
        } else {
            this.f7028b = new ac(context, baiduMapOptions.a(), str, i2);
        }
        addView(this.f7028b);
        this.s = new t(this);
        this.f7028b.b().a(this.s);
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
        if (this.f7032f.a()) {
            float f2 = this.f7028b.b().E().f7571a;
            this.f7032f.b(f2 > this.f7028b.b().f7619b);
            this.f7032f.a(f2 < this.f7028b.b().f7618a);
        }
    }

    private void b(Context context) {
        ak akVar = new ak(context);
        this.f7032f = akVar;
        if (akVar.a()) {
            this.f7032f.b(new u(this));
            this.f7032f.a(new v(this));
            addView(this.f7032f);
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
        this.o.setLayoutParams(layoutParams3);
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        this.l.addView(this.o);
        addView(this.l);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        f7027i = str;
    }

    @Deprecated
    public static void setIconCustom(int i2) {
        k = i2;
    }

    public static void setLoadCustomMapStyleFileMode(int i2) {
        j = i2;
    }

    @Deprecated
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
        int i2 = this.t;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f7029c;
        baiduMap.f6792b = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return q.get((int) this.f7028b.b().E().f7571a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.B;
    }

    public int getScaleControlViewWidth() {
        return this.B;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.f7033g != null) {
            this.f7033g = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.f7034h != null) {
            this.f7034h = (Point) bundle.getParcelable("zoomPosition");
        }
        this.u = bundle.getBoolean("mZoomControlEnabled");
        this.v = bundle.getBoolean("mScaleControlEnabled");
        this.t = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        Context context = this.p;
        if (context != null) {
            this.f7028b.a(context.hashCode());
        }
        Bitmap bitmap = this.f7031e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7031e.recycle();
        }
        this.f7032f.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        this.p = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int measuredHeight;
        int measuredWidth;
        int childCount = getChildCount();
        a(this.f7030d);
        float f3 = 1.0f;
        if (((getWidth() - this.w) - this.x) - this.f7030d.getMeasuredWidth() <= 0 || ((getHeight() - this.y) - this.z) - this.f7030d.getMeasuredHeight() <= 0) {
            this.w = 0;
            this.x = 0;
            this.z = 0;
            this.y = 0;
            f2 = 1.0f;
        } else {
            f3 = ((getWidth() - this.w) - this.x) / getWidth();
            f2 = ((getHeight() - this.y) - this.z) / getHeight();
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            ac acVar = this.f7028b;
            if (childAt == acVar) {
                acVar.layout(0, 0, getWidth(), getHeight());
            } else {
                ImageView imageView = this.f7030d;
                if (childAt == imageView) {
                    float f4 = f3 * 5.0f;
                    int i7 = (int) (this.w + f4);
                    int i8 = (int) (this.x + f4);
                    float f5 = 5.0f * f2;
                    int i9 = (int) (this.y + f5);
                    int i10 = (int) (this.z + f5);
                    int i11 = this.t;
                    if (i11 != 1) {
                        if (i11 == 2) {
                            measuredHeight = getHeight() - i10;
                            i9 = measuredHeight - this.f7030d.getMeasuredHeight();
                        } else if (i11 != 3) {
                            if (i11 == 4) {
                                measuredHeight = getHeight() - i10;
                                i9 = measuredHeight - this.f7030d.getMeasuredHeight();
                            } else if (i11 != 5) {
                                measuredHeight = getHeight() - i10;
                                measuredWidth = this.f7030d.getMeasuredWidth() + i7;
                                i9 = measuredHeight - this.f7030d.getMeasuredHeight();
                            } else {
                                measuredHeight = i9 + imageView.getMeasuredHeight();
                            }
                            measuredWidth = getWidth() - i8;
                            i7 = measuredWidth - this.f7030d.getMeasuredWidth();
                        } else {
                            measuredHeight = i9 + imageView.getMeasuredHeight();
                        }
                        i7 = (((getWidth() - this.f7030d.getMeasuredWidth()) + this.w) - this.x) / 2;
                        measuredWidth = (((getWidth() + this.f7030d.getMeasuredWidth()) + this.w) - this.x) / 2;
                    } else {
                        measuredHeight = imageView.getMeasuredHeight() + i9;
                        measuredWidth = this.f7030d.getMeasuredWidth() + i7;
                    }
                    this.f7030d.layout(i7, i9, measuredWidth, measuredHeight);
                } else {
                    ak akVar = this.f7032f;
                    if (childAt != akVar) {
                        RelativeLayout relativeLayout = this.l;
                        if (childAt == relativeLayout) {
                            a(relativeLayout);
                            Point point = this.f7033g;
                            if (point == null) {
                                this.B = this.l.getMeasuredWidth();
                                this.A = this.l.getMeasuredHeight();
                                int i12 = (int) (this.w + (5.0f * f3));
                                int height = (getHeight() - ((int) ((this.z + (f2 * 5.0f)) + 56.0f))) - this.f7030d.getMeasuredHeight();
                                this.l.layout(i12, height, this.B + i12, this.A + height);
                            } else {
                                RelativeLayout relativeLayout2 = this.l;
                                int i13 = point.x;
                                relativeLayout2.layout(i13, point.y, relativeLayout2.getMeasuredWidth() + i13, this.f7033g.y + this.l.getMeasuredHeight());
                            }
                        } else {
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            if (layoutParams instanceof MapViewLayoutParams) {
                                MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                Point a2 = mapViewLayoutParams.f6926c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f6925b : this.f7028b.b().a(CoordUtil.ll2mc(mapViewLayoutParams.f6924a));
                                a(childAt);
                                int measuredWidth2 = childAt.getMeasuredWidth();
                                int measuredHeight2 = childAt.getMeasuredHeight();
                                float f6 = mapViewLayoutParams.f6927d;
                                int i14 = (int) (a2.x - (f6 * measuredWidth2));
                                int i15 = ((int) (a2.y - (mapViewLayoutParams.f6928e * measuredHeight2))) + mapViewLayoutParams.f6929f;
                                childAt.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
                            }
                        }
                    } else if (akVar.a()) {
                        a(this.f7032f);
                        Point point2 = this.f7034h;
                        if (point2 == null) {
                            int height2 = (int) (((getHeight() - 15) * f2) + this.y);
                            int width = (int) (((getWidth() - 15) * f3) + this.w);
                            int measuredWidth3 = width - this.f7032f.getMeasuredWidth();
                            int measuredHeight3 = height2 - this.f7032f.getMeasuredHeight();
                            if (this.t == 4) {
                                height2 -= this.f7030d.getMeasuredHeight();
                                measuredHeight3 -= this.f7030d.getMeasuredHeight();
                            }
                            this.f7032f.layout(measuredWidth3, measuredHeight3, width, height2);
                        } else {
                            ak akVar2 = this.f7032f;
                            int i16 = point2.x;
                            akVar2.layout(i16, point2.y, akVar2.getMeasuredWidth() + i16, this.f7034h.y + this.f7032f.getMeasuredHeight());
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f7028b.d();
    }

    public final void onResume() {
        this.f7028b.c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f7029c) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f7033g;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f7034h;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.u);
        bundle.putBoolean("mScaleControlEnabled", this.v);
        bundle.putInt("logoPosition", this.t);
        bundle.putInt("paddingLeft", this.w);
        bundle.putInt("paddingTop", this.y);
        bundle.putInt("paddingRight", this.x);
        bundle.putInt("paddingBottom", this.z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f7030d) {
            return;
        }
        super.removeView(view);
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            logoPosition = LogoPosition.logoPostionleftBottom;
        }
        this.t = logoPosition.ordinal();
        requestLayout();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.w = i2;
        this.y = i3;
        this.x = i4;
        this.z = i5;
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.f7033g = point;
            requestLayout();
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.f7034h = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
        this.v = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f7032f.a()) {
            this.f7032f.setVisibility(z ? 0 : 8);
            this.u = z;
        }
    }
}
