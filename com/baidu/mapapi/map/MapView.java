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
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
/* loaded from: classes26.dex */
public final class MapView extends ViewGroup {
    private static String b;
    private int A;
    private boolean B;
    private MapSurfaceView e;
    private BaiduMap f;
    private ImageView g;
    private Bitmap h;
    private com.baidu.mapsdkplatform.comapi.map.ab i;
    private Point j;
    private Point k;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private Context p;
    private int r;
    private boolean s;
    private boolean t;
    private float u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2027a = MapView.class.getSimpleName();
    private static int c = 0;
    private static int d = 0;
    private static final SparseIntArray q = new SparseIntArray();

    static {
        q.append(3, 2000000);
        q.append(4, MessageConfig.BASE_SEGMENT_LENGTH);
        q.append(5, 500000);
        q.append(6, AlaRecorderLog.ErrCodeSeg.ERROR_BASE_RTMP);
        q.append(7, 100000);
        q.append(8, IMConstants.ERROR_BASE);
        q.append(9, BdNetTask.TIMEOUT_READ);
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

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
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

    private void a(Context context) {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
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
            this.g = new ImageView(context);
            this.g.setImageBitmap(this.h);
            addView(this.g);
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        this.p = context;
        System.currentTimeMillis();
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
        if (baiduMapOptions != null && baiduMapOptions.j != null) {
            this.r = baiduMapOptions.j.ordinal();
        }
        if (baiduMapOptions != null && baiduMapOptions.l != null) {
            this.k = baiduMapOptions.l;
        }
        if (baiduMapOptions == null || baiduMapOptions.k == null) {
            return;
        }
        this.j = baiduMapOptions.k;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        this.e = new MapSurfaceView(context);
        if (baiduMapOptions != null) {
            this.f = new BaiduMap(context, this.e, baiduMapOptions.a());
        } else {
            this.f = new BaiduMap(context, this.e, (com.baidu.mapsdkplatform.comapi.map.u) null);
        }
        addView(this.e);
        this.e.getBaseMap().a(new q(this));
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
    public void a(String str, int i) {
        if (this.e == null || this.e.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f2027a, "customStyleFilePath is empty or null, please check!");
        } else if (!str.endsWith(".sty")) {
            Log.e(f2027a, "customStyleFile format is incorrect , please check!");
        } else if (new File(str).exists()) {
            this.e.getBaseMap().a(str, i);
        } else {
            Log.e(f2027a, "customStyleFile does not exist , please check!");
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
        if (this.i.a()) {
            float f = this.e.getBaseMap().B().f2244a;
            this.i.b(f > this.e.getBaseMap().b);
            this.i.a(f < this.e.getBaseMap().f2226a);
        }
    }

    private void b(Context context) {
        this.i = new com.baidu.mapsdkplatform.comapi.map.ab(context, false);
        if (this.i.a()) {
            this.i.b(new r(this));
            this.i.a(new s(this));
            addView(this.i);
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
        if (a2 != null) {
            byte[] ninePatchChunk = a2.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
            }
        }
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
        b = str;
    }

    @Deprecated
    public static void setIconCustom(int i) {
        d = i;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        c = i;
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

    public void cancelRenderMap() {
    }

    public final LogoPosition getLogoPosition() {
        switch (this.r) {
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
        this.f.f1999a = this;
        return this.f;
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

    public boolean handleMultiTouch(float f, float f2, float f3, float f4) {
        return false;
    }

    public void handleTouchDown(float f, float f2) {
        if (this.e == null) {
        }
    }

    public boolean handleTouchMove(float f, float f2) {
        return false;
    }

    public boolean handleTouchUp(float f, float f2) {
        if (this.e == null) {
        }
        return false;
    }

    public boolean inRangeOfView(float f, float f2) {
        return this.e != null && this.e.inRangeOfView(f, f2);
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
        if (this.f != null) {
            this.f.c();
        }
        if (this.p != null) {
            this.e.unInit();
        }
        if (this.h != null && !this.h.isRecycled()) {
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
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        int measuredHeight;
        int width;
        int childCount = getChildCount();
        a(this.g);
        if (((getWidth() - this.v) - this.w) - this.g.getMeasuredWidth() <= 0 || ((getHeight() - this.x) - this.y) - this.g.getMeasuredHeight() <= 0) {
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
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                if (childAt == this.e) {
                    this.e.layout(0, 0, getWidth(), getHeight());
                } else if (childAt == this.g) {
                    int i6 = (int) (this.v + (5.0f * f));
                    int i7 = (int) (this.w + (5.0f * f));
                    int i8 = (int) (this.x + (5.0f * f2));
                    int i9 = (int) (this.y + (5.0f * f2));
                    switch (this.r) {
                        case 1:
                            measuredHeight = i8 + this.g.getMeasuredHeight();
                            width = this.g.getMeasuredWidth() + i6;
                            break;
                        case 2:
                            measuredHeight = getHeight() - i9;
                            i8 = measuredHeight - this.g.getMeasuredHeight();
                            i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                            width = (((getWidth() + this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                            break;
                        case 3:
                            measuredHeight = i8 + this.g.getMeasuredHeight();
                            i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                            width = (((getWidth() + this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                            break;
                        case 4:
                            measuredHeight = getHeight() - i9;
                            i8 = measuredHeight - this.g.getMeasuredHeight();
                            width = getWidth() - i7;
                            i6 = width - this.g.getMeasuredWidth();
                            break;
                        case 5:
                            measuredHeight = i8 + this.g.getMeasuredHeight();
                            width = getWidth() - i7;
                            i6 = width - this.g.getMeasuredWidth();
                            break;
                        default:
                            measuredHeight = getHeight() - i9;
                            width = this.g.getMeasuredWidth() + i6;
                            i8 = measuredHeight - this.g.getMeasuredHeight();
                            break;
                    }
                    this.g.layout(i6, i8, width, measuredHeight);
                } else if (childAt == this.i) {
                    if (this.i.a()) {
                        a(this.i);
                        if (this.k == null) {
                            int height = (int) (((getHeight() - 15) * f2) + this.x);
                            int width2 = (int) (((getWidth() - 15) * f) + this.v);
                            int measuredWidth = width2 - this.i.getMeasuredWidth();
                            int measuredHeight2 = height - this.i.getMeasuredHeight();
                            if (this.r == 4) {
                                height -= this.g.getMeasuredHeight();
                                measuredHeight2 -= this.g.getMeasuredHeight();
                            }
                            this.i.layout(measuredWidth, measuredHeight2, width2, height);
                        } else {
                            this.i.layout(this.k.x, this.k.y, this.k.x + this.i.getMeasuredWidth(), this.k.y + this.i.getMeasuredHeight());
                        }
                    }
                } else if (childAt == this.l) {
                    a(this.l);
                    if (this.j == null) {
                        this.A = this.l.getMeasuredWidth();
                        this.z = this.l.getMeasuredHeight();
                        int i10 = (int) (this.v + (5.0f * f));
                        int height2 = (getHeight() - ((int) ((this.y + (5.0f * f2)) + 56.0f))) - this.g.getMeasuredHeight();
                        this.l.layout(i10, height2, this.A + i10, this.z + height2);
                    } else {
                        this.l.layout(this.j.x, this.j.y, this.j.x + this.l.getMeasuredWidth(), this.j.y + this.l.getMeasuredHeight());
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof MapViewLayoutParams) {
                        MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                        Point a2 = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.b : this.e.getBaseMap().a(CoordUtil.ll2mc(mapViewLayoutParams.f2028a));
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
        this.e.onPause();
    }

    public final void onResume() {
        this.e.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null || this.f == null) {
            return;
        }
        bundle.putParcelable("mapstatus", this.f.getMapStatus());
        if (this.j != null) {
        }
        if (this.k != null) {
        }
        bundle.putBoolean("mZoomControlEnabled", this.s);
        bundle.putBoolean("mScaleControlEnabled", this.t);
        bundle.putInt("logoPosition", this.r);
        bundle.putInt("paddingLeft", this.v);
        bundle.putInt("paddingTop", this.x);
        bundle.putInt("paddingRight", this.w);
        bundle.putInt("paddingBottom", this.y);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.g) {
            return;
        }
        super.removeView(view);
    }

    public void renderMap() {
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
        a(str, i);
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.r = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.r = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.p, customMapStyleId, new p(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath == null || localCustomStyleFilePath.isEmpty()) {
            return;
        }
        a(localCustomStyleFilePath, 0);
        setMapCustomStyleEnable(true);
    }

    public void setMapCustomStyleEnable(boolean z) {
        if (this.e == null) {
            return;
        }
        this.e.getBaseMap().n(z);
    }

    public void setMapCustomStylePath(String str) {
        a(str, 0);
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
            this.j = point;
            requestLayout();
        }
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.e.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        if (this.e == null) {
            return;
        }
        this.e.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
        this.t = z;
    }

    public void showZoomControls(boolean z) {
        if (this.i.a()) {
            this.i.setVisibility(z ? 0 : 8);
            this.s = z;
        }
    }
}
