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
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
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
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
/* loaded from: classes3.dex */
public final class TextureMapView extends ViewGroup {
    private static String i;
    private int A;
    private boolean B;
    private MapTextureView b;
    private BaiduMap c;
    private ImageView d;
    private Bitmap e;
    private com.baidu.mapsdkplatform.comapi.map.ab f;
    private Point g;
    private Point h;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private Context p;
    private float r;
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
    private static int k = 0;
    private static final SparseArray<Integer> q = new SparseArray<>();

    static {
        q.append(3, 2000000);
        q.append(4, Integer.valueOf((int) MessageConfig.BASE_SEGMENT_LENGTH));
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
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
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
        this.p = context;
        com.baidu.mapsdkplatform.comapi.map.j.a();
        BMapManager.init();
        a(context, baiduMapOptions, i, k);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.f.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.l.setVisibility(4);
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
        this.b = new MapTextureView(context);
        addView(this.b);
        if (baiduMapOptions != null) {
            this.c = new BaiduMap(context, this.b, baiduMapOptions.a());
        } else {
            this.c = new BaiduMap(context, this.b, (com.baidu.mapsdkplatform.comapi.map.u) null);
        }
        this.b.getBaseMap().a(new z(this));
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
    public void a(String str, int i2) {
        if (this.b == null || this.b.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(a, "customStyleFilePath is empty or null, please check!");
        } else if (!str.endsWith(".sty")) {
            Log.e(a, "customStyleFile format is incorrect , please check!");
        } else if (new File(str).exists()) {
            this.b.getBaseMap().a(str, i2);
        } else {
            Log.e(a, "customStyleFile does not exist , please check!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        if (!TextUtils.isEmpty(str)) {
            a(str, 1);
            setMapCustomStyleEnable(true);
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (TextUtils.isEmpty(localCustomStyleFilePath)) {
            return;
        }
        a(localCustomStyleFilePath, 0);
        setMapCustomStyleEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f.a()) {
            float f = this.b.getBaseMap().B().a;
            this.f.b(f > this.b.getBaseMap().b);
            this.f.a(f < this.b.getBaseMap().a);
        }
    }

    private void b(Context context) {
        this.f = new com.baidu.mapsdkplatform.comapi.map.ab(context);
        if (this.f.a()) {
            this.f.b(new aa(this));
            this.f.a(new ab(this));
            addView(this.f);
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
        this.m.setTypeface(this.m.getTypeface(), 1);
        this.m.setLayoutParams(layoutParams);
        this.m.setId(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        i = str;
    }

    @Deprecated
    public static void setIconCustom(int i2) {
        k = i2;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i2) {
        j = i2;
    }

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.j.a(z);
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
        return q.get((int) this.b.getBaseMap().B().a).intValue();
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
        if (this.p != null) {
            this.b.onDestroy();
        }
        if (this.e != null && !this.e.isRecycled()) {
            this.e.recycle();
        }
        this.f.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.j.b();
        this.p = null;
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
            if (childAt != null) {
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
                } else if (childAt == this.l) {
                    a(this.l);
                    if (this.g == null) {
                        this.A = this.l.getMeasuredWidth();
                        this.z = this.l.getMeasuredHeight();
                        int i11 = (int) (this.v + (5.0f * f));
                        int height2 = (getHeight() - ((int) ((this.y + (5.0f * f2)) + 56.0f))) - this.d.getMeasuredHeight();
                        this.l.layout(i11, height2, this.A + i11, this.z + height2);
                    } else {
                        this.l.layout(this.g.x, this.g.y, this.g.x + this.l.getMeasuredWidth(), this.g.y + this.l.getMeasuredHeight());
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof MapViewLayoutParams) {
                        MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                        Point a2 = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.b : this.b.getBaseMap().a(CoordUtil.ll2mc(mapViewLayoutParams.a));
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
    }

    public final void onPause() {
        this.b.onPause();
    }

    public final void onResume() {
        this.b.onResume();
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
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.d) {
            return;
        }
        super.removeView(view);
    }

    public void setCustomStyleFilePathAndMode(String str, int i2) {
        a(str, i2);
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.s = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.s = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.p, customMapStyleId, new y(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath == null || localCustomStyleFilePath.isEmpty()) {
            return;
        }
        a(localCustomStyleFilePath, 0);
    }

    public void setMapCustomStyleEnable(boolean z) {
        if (this.b == null) {
            return;
        }
        this.b.getBaseMap().n(z);
    }

    public void setMapCustomStylePath(String str) {
        a(str, 0);
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
        this.l.setVisibility(z ? 0 : 8);
        this.u = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f.a()) {
            this.f.setVisibility(z ? 0 : 8);
            this.t = z;
        }
    }
}
