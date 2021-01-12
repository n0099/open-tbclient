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
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
/* loaded from: classes6.dex */
public final class MapView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private static String f2739b;
    private int A;
    private com.baidu.mapsdkplatform.comapi.map.j d;
    private BaiduMap e;
    private ImageView f;
    private Bitmap g;
    private ak h;
    private Point i;
    private Point j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private Context o;
    private int q;
    private boolean r;
    private boolean s;
    private float t;
    private com.baidu.mapsdkplatform.comapi.map.l u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2738a = MapView.class.getSimpleName();
    private static int c = 0;
    private static final SparseArray<Integer> p = new SparseArray<>();

    static {
        p.append(3, 2000000);
        p.append(4, Integer.valueOf((int) MessageConfig.BASE_SEGMENT_LENGTH));
        p.append(5, 500000);
        p.append(6, Integer.valueOf((int) AlaRecorderLog.ErrCodeSeg.ERROR_BASE_RTMP));
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

    private void a(Context context) {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.g = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.g = a2;
        } else {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.g = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        }
        if (this.g != null) {
            this.f = new ImageView(context);
            this.f.setImageBitmap(this.g);
            addView(this.f);
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        this.o = context;
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        a(context, baiduMapOptions, f2739b, c);
        this.e = new BaiduMap(this.d);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.h.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.k.setVisibility(4);
        }
        if (baiduMapOptions != null && baiduMapOptions.j != null) {
            this.q = baiduMapOptions.j.ordinal();
        }
        if (baiduMapOptions != null && baiduMapOptions.l != null) {
            this.j = baiduMapOptions.l;
        }
        if (baiduMapOptions == null || baiduMapOptions.k == null) {
            return;
        }
        this.i = baiduMapOptions.k;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        if (baiduMapOptions == null) {
            this.d = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, i);
        } else {
            this.d = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, i);
        }
        addView(this.d);
        this.u = new k(this);
        this.d.a().a(this.u);
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
        if (this.h.a()) {
            float f = this.d.a().E().f3040a;
            this.h.b(f > this.d.a().f3053b);
            this.h.a(f < this.d.a().f3052a);
        }
    }

    private void b(Context context) {
        this.h = new ak(context, false);
        if (this.h.a()) {
            this.h.b(new l(this));
            this.h.a(new m(this));
            addView(this.h);
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
        this.l.setId(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
        f2739b = str;
    }

    public static void setIconCustom(int i) {
        c = i;
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
        this.d.a().v(false);
        this.d.a().O().clear();
    }

    public final LogoPosition getLogoPosition() {
        switch (this.q) {
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
        this.e.f2694a = this;
        return this.e;
    }

    public final int getMapLevel() {
        return p.get((int) this.d.a().E().f3040a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.z;
    }

    public int getScaleControlViewWidth() {
        return this.A;
    }

    public boolean handleMultiTouch(float f, float f2, float f3, float f4) {
        return this.d != null && this.d.a(f, f2, f3, f4);
    }

    public void handleTouchDown(float f, float f2) {
        if (this.d == null) {
            return;
        }
        this.d.a(f, f2);
    }

    public boolean handleTouchMove(float f, float f2) {
        return this.d != null && this.d.c(f, f2);
    }

    public boolean handleTouchUp(float f, float f2) {
        if (this.d == null) {
            return false;
        }
        return this.d.b(f, f2);
    }

    public boolean inRangeOfView(float f, float f2) {
        return this.d != null && this.d.d(f, f2);
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        f2739b = bundle.getString("customMapPath");
        if (bundle == null) {
            a(context, new BaiduMapOptions());
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
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
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        if (this.o != null) {
            this.d.b(this.o.hashCode());
        }
        if (this.g != null && !this.g.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
        if (f2739b != null) {
            f2739b = null;
        }
        this.h.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        this.o = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int measuredHeight;
        int width;
        int childCount = getChildCount();
        float f2 = 1.0f;
        a(this.f);
        if (((getWidth() - this.v) - this.w) - this.f.getMeasuredWidth() <= 0 || ((getHeight() - this.x) - this.y) - this.f.getMeasuredHeight() <= 0) {
            this.v = 0;
            this.w = 0;
            this.y = 0;
            this.x = 0;
            f = 1.0f;
        } else {
            f2 = ((getWidth() - this.v) - this.w) / getWidth();
            f = ((getHeight() - this.x) - this.y) / getHeight();
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                if (childAt == this.d) {
                    this.d.layout(0, 0, getWidth(), getHeight());
                } else if (childAt == this.f) {
                    int i6 = (int) (this.v + (5.0f * f2));
                    int i7 = (int) (this.w + (5.0f * f2));
                    int i8 = (int) (this.x + (5.0f * f));
                    int i9 = (int) (this.y + (5.0f * f));
                    switch (this.q) {
                        case 1:
                            measuredHeight = i8 + this.f.getMeasuredHeight();
                            width = this.f.getMeasuredWidth() + i6;
                            break;
                        case 2:
                            measuredHeight = getHeight() - i9;
                            i8 = measuredHeight - this.f.getMeasuredHeight();
                            i6 = (((getWidth() - this.f.getMeasuredWidth()) + this.v) - this.w) / 2;
                            width = (((getWidth() + this.f.getMeasuredWidth()) + this.v) - this.w) / 2;
                            break;
                        case 3:
                            measuredHeight = i8 + this.f.getMeasuredHeight();
                            i6 = (((getWidth() - this.f.getMeasuredWidth()) + this.v) - this.w) / 2;
                            width = (((getWidth() + this.f.getMeasuredWidth()) + this.v) - this.w) / 2;
                            break;
                        case 4:
                            measuredHeight = getHeight() - i9;
                            i8 = measuredHeight - this.f.getMeasuredHeight();
                            width = getWidth() - i7;
                            i6 = width - this.f.getMeasuredWidth();
                            break;
                        case 5:
                            measuredHeight = i8 + this.f.getMeasuredHeight();
                            width = getWidth() - i7;
                            i6 = width - this.f.getMeasuredWidth();
                            break;
                        default:
                            measuredHeight = getHeight() - i9;
                            width = this.f.getMeasuredWidth() + i6;
                            i8 = measuredHeight - this.f.getMeasuredHeight();
                            break;
                    }
                    this.f.layout(i6, i8, width, measuredHeight);
                } else if (childAt == this.h) {
                    if (this.h.a()) {
                        a(this.h);
                        if (this.j == null) {
                            int height = (int) (((getHeight() - 15) * f) + this.x);
                            int width2 = (int) (((getWidth() - 15) * f2) + this.v);
                            int measuredWidth = width2 - this.h.getMeasuredWidth();
                            int measuredHeight2 = height - this.h.getMeasuredHeight();
                            if (this.q == 4) {
                                height -= this.f.getMeasuredHeight();
                                measuredHeight2 -= this.f.getMeasuredHeight();
                            }
                            this.h.layout(measuredWidth, measuredHeight2, width2, height);
                        } else {
                            this.h.layout(this.j.x, this.j.y, this.j.x + this.h.getMeasuredWidth(), this.j.y + this.h.getMeasuredHeight());
                        }
                    }
                } else if (childAt == this.k) {
                    a(this.k);
                    if (this.i == null) {
                        this.A = this.k.getMeasuredWidth();
                        this.z = this.k.getMeasuredHeight();
                        int i10 = (int) (this.v + (5.0f * f2));
                        int height2 = (getHeight() - ((int) ((this.y + (5.0f * f)) + 56.0f))) - this.f.getMeasuredHeight();
                        this.k.layout(i10, height2, this.A + i10, this.z + height2);
                    } else {
                        this.k.layout(this.i.x, this.i.y, this.i.x + this.k.getMeasuredWidth(), this.i.y + this.k.getMeasuredHeight());
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams == null) {
                        Log.e("test", "lp == null");
                    }
                    if (layoutParams instanceof MapViewLayoutParams) {
                        MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                        Point a2 = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f2741b : this.d.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f2740a));
                        a(childAt);
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        int measuredHeight3 = childAt.getMeasuredHeight();
                        int i11 = (int) (a2.x - (mapViewLayoutParams.d * measuredWidth2));
                        int i12 = mapViewLayoutParams.f + ((int) (a2.y - (mapViewLayoutParams.e * measuredHeight3)));
                        childAt.layout(i11, i12, i11 + measuredWidth2, i12 + measuredHeight3);
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.d.onPause();
    }

    public final void onResume() {
        this.d.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null || this.e == null) {
            return;
        }
        bundle.putParcelable("mapstatus", this.e.getMapStatus());
        if (this.i != null) {
            bundle.putParcelable("scalePosition", this.i);
        }
        if (this.j != null) {
            bundle.putParcelable("zoomPosition", this.j);
        }
        bundle.putBoolean("mZoomControlEnabled", this.r);
        bundle.putBoolean("mScaleControlEnabled", this.s);
        bundle.putInt("logoPosition", this.q);
        bundle.putInt("paddingLeft", this.v);
        bundle.putInt("paddingTop", this.x);
        bundle.putInt("paddingRight", this.w);
        bundle.putInt("paddingBottom", this.y);
        bundle.putString("customMapPath", f2739b);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f) {
            return;
        }
        super.removeView(view);
    }

    public void renderMap() {
        com.baidu.mapsdkplatform.comapi.map.e a2 = this.d.a();
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
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.i = point;
            requestLayout();
        }
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.d.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        if (this.d == null) {
            return;
        }
        this.d.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.j = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
        this.s = z;
    }

    public void showZoomControls(boolean z) {
        if (this.h.a()) {
            this.h.setVisibility(z ? 0 : 8);
            this.r = z;
        }
    }
}
