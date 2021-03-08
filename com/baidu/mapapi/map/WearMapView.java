package com.baidu.mapapi.map;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
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
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.webkit.net.BdNetTask;
import com.yy.mediaframework.base.VideoEncoderConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
@TargetApi(20)
/* loaded from: classes4.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;
    private static String c;
    private com.baidu.mapsdkplatform.comapi.map.l A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;

    /* renamed from: a  reason: collision with root package name */
    ScreenShape f2056a;
    private com.baidu.mapsdkplatform.comapi.map.j e;
    private BaiduMap f;
    private ImageView g;
    private Bitmap h;
    private ak i;
    private boolean j;
    private Point k;
    private Point l;
    private RelativeLayout m;
    public AnimationTask mTask;
    public Timer mTimer;
    public a mTimerHandler;
    private SwipeDismissView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private boolean u;
    private Context v;
    private boolean x;
    private boolean y;
    private float z;
    private static final String b = MapView.class.getSimpleName();
    private static int d = 0;
    private static int r = 0;
    private static int s = 0;
    private static int t = 10;
    private static final SparseArray<Integer> w = new SparseArray<>();

    /* loaded from: classes4.dex */
    public class AnimationTask extends TimerTask {
        public AnimationTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            WearMapView.this.mTimerHandler.sendMessage(message);
        }
    }

    /* loaded from: classes4.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    /* loaded from: classes4.dex */
    public enum ScreenShape {
        ROUND,
        RECTANGLE,
        UNDETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends Handler {
        private final WeakReference<Context> b;

        public a(Context context) {
            this.b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.b.get() == null) {
                return;
            }
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (WearMapView.this.i != null) {
                        WearMapView.this.a(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static {
        w.append(3, Integer.valueOf((int) VideoEncoderConfig.SCREEN_RECORD_ENCODE_ULTRA_HIGH_BITRATE));
        w.append(4, Integer.valueOf((int) MessageConfig.BASE_SEGMENT_LENGTH));
        w.append(5, 500000);
        w.append(6, Integer.valueOf((int) AlaRecorderLog.ErrCodeSeg.ERROR_BASE_RTMP));
        w.append(7, 100000);
        w.append(8, Integer.valueOf((int) IMConstants.ERROR_BASE));
        w.append(9, Integer.valueOf((int) BdNetTask.TIMEOUT_READ));
        w.append(10, 20000);
        w.append(11, 10000);
        w.append(12, 5000);
        w.append(13, 2000);
        w.append(14, 1000);
        w.append(15, 500);
        w.append(16, 200);
        w.append(17, 100);
        w.append(18, 50);
        w.append(19, 20);
        w.append(20, 10);
        w.append(21, 5);
        w.append(22, 2);
    }

    public WearMapView(Context context) {
        super(context);
        this.j = true;
        this.u = true;
        this.f2056a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.u = true;
        this.f2056a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        this.u = true;
        this.f2056a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.j = true;
        this.u = true;
        this.f2056a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, baiduMapOptions);
    }

    private int a(int i, int i2) {
        return i - ((int) Math.sqrt(Math.pow(i, 2.0d) - Math.pow(i2, 2.0d)));
    }

    private void a(int i) {
        if (this.e == null) {
            return;
        }
        switch (i) {
            case 0:
                this.e.onPause();
                b();
                return;
            case 1:
                this.e.onResume();
                c();
                return;
            default:
                return;
        }
    }

    private static void a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        r = point.x;
        s = point.y;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        a(context);
        setOnApplyWindowInsetsListener(this);
        this.v = context;
        this.mTimerHandler = new a(context);
        this.mTimer = new Timer();
        if (this.mTimer != null && this.mTask != null) {
            this.mTask.cancel();
        }
        this.mTask = new AnimationTask();
        this.mTimer.schedule(this.mTask, 5000L);
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        a(context, baiduMapOptions, c);
        this.f = new BaiduMap(this.e);
        this.e.a().s(false);
        this.e.a().r(false);
        c(context);
        d(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.i.setVisibility(4);
        }
        e(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.m.setVisibility(4);
        }
        if (baiduMapOptions != null && baiduMapOptions.l != null) {
            this.l = baiduMapOptions.l;
        }
        if (baiduMapOptions == null || baiduMapOptions.k == null) {
            return;
        }
        this.k = baiduMapOptions.k;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        if (baiduMapOptions == null) {
            this.e = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, d);
        } else {
            this.e = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, d);
        }
        addView(this.e);
        this.A = new w(this);
        this.e.a().a(this.A);
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

    private void a(View view, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", 0.0f, -50.0f), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f));
            animatorSet.addListener(new z(this, view));
            animatorSet.setDuration(1200L);
            animatorSet.start();
            return;
        }
        view.setVisibility(0);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", -50.0f, 0.0f), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f));
        animatorSet2.setDuration(1200L);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.j) {
            a(this.i, z);
        }
    }

    private void b() {
        if (this.e == null || this.u) {
            return;
        }
        d();
        this.u = true;
    }

    private void b(Context context) {
        this.n = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), s);
        this.n.setBackgroundColor(Color.argb(0, 0, 0, 0));
        this.n.setLayoutParams(layoutParams);
        addView(this.n);
    }

    private void c() {
        if (this.e != null && this.u) {
            e();
            this.u = false;
        }
    }

    private void c(Context context) {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.h = a2;
        } else {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        }
        if (this.h != null) {
            this.g = new ImageView(context);
            this.g.setImageBitmap(this.h);
            addView(this.g);
        }
    }

    private void d() {
        if (this.e == null) {
            return;
        }
        this.e.b();
    }

    private void d(Context context) {
        this.i = new ak(context, true);
        if (this.i.a()) {
            this.i.b(new x(this));
            this.i.a(new y(this));
            addView(this.i);
        }
    }

    private void e() {
        if (this.e == null) {
            return;
        }
        this.e.c();
    }

    private void e(Context context) {
        this.m = new RelativeLayout(context);
        this.m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.o = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.o.setTextColor(Color.parseColor("#FFFFFF"));
        this.o.setTextSize(2, 11.0f);
        this.o.setTypeface(this.o.getTypeface(), 1);
        this.o.setLayoutParams(layoutParams);
        this.o.setId(Integer.MAX_VALUE);
        this.m.addView(this.o);
        this.p = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.p.setTextColor(Color.parseColor("#000000"));
        this.p.setTextSize(2, 11.0f);
        this.p.setLayoutParams(layoutParams2);
        this.m.addView(this.p);
        this.q = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.o.getId());
        this.q.setLayoutParams(layoutParams3);
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.q.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        this.m.addView(this.q);
        addView(this.m);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
        c = str;
    }

    public static void setIconCustom(int i) {
        d = i;
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

    public final BaiduMap getMap() {
        this.f.c = this;
        return this.f;
    }

    public final int getMapLevel() {
        return w.get((int) this.e.a().E().f2214a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.F;
    }

    public int getScaleControlViewWidth() {
        return this.G;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (windowInsets.isRound()) {
            this.f2056a = ScreenShape.ROUND;
        } else {
            this.f2056a = ScreenShape.RECTANGLE;
        }
        return windowInsets;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        c = bundle.getString("customMapPath");
        if (bundle == null) {
            a(context, new BaiduMapOptions());
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.k != null) {
            this.k = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.l != null) {
            this.l = (Point) bundle.getParcelable("zoomPosition");
        }
        this.x = bundle.getBoolean("mZoomControlEnabled");
        this.y = bundle.getBoolean("mScaleControlEnabled");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        if (this.v != null) {
            this.e.b(this.v.hashCode());
        }
        if (this.h != null && !this.h.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        this.i.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.v = null;
    }

    public final void onDismiss() {
        removeAllViews();
    }

    public final void onEnterAmbient(Bundle bundle) {
        a(0);
    }

    public void onExitAmbient() {
        a(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.i.getVisibility() != 0) {
                    if (this.i.getVisibility() == 4) {
                        if (this.mTimer != null) {
                            if (this.mTask != null) {
                                this.mTask.cancel();
                            }
                            this.mTimer.cancel();
                            this.mTask = null;
                            this.mTimer = null;
                        }
                        a(false);
                        break;
                    }
                } else if (this.mTimer != null) {
                    if (this.mTask != null) {
                        this.mTimer.cancel();
                        this.mTask.cancel();
                    }
                    this.mTimer = null;
                    this.mTask = null;
                    break;
                }
                break;
            case 1:
                this.mTimer = new Timer();
                if (this.mTimer != null && this.mTask != null) {
                    this.mTask.cancel();
                }
                this.mTask = new AnimationTask();
                this.mTimer.schedule(this.mTask, 5000L);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(20)
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int childCount = getChildCount();
        float f2 = 1.0f;
        a(this.g);
        if (((getWidth() - this.B) - this.C) - this.g.getMeasuredWidth() <= 0 || ((getHeight() - this.D) - this.E) - this.g.getMeasuredHeight() <= 0) {
            this.B = 0;
            this.C = 0;
            this.E = 0;
            this.D = 0;
            f = 1.0f;
        } else {
            f2 = ((getWidth() - this.B) - this.C) / getWidth();
            f = ((getHeight() - this.D) - this.E) / getHeight();
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt == this.e) {
                this.e.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.g) {
                int i6 = (int) (this.E + (12.0f * f));
                int i7 = 0;
                int i8 = 0;
                if (this.f2056a == ScreenShape.ROUND) {
                    a(this.i);
                    int i9 = r / 2;
                    i8 = a(i9, this.i.getMeasuredWidth() / 2);
                    i7 = ((r / 2) - a(i9, i9 - i8)) + t;
                }
                int i10 = (s - i8) - i6;
                int i11 = r - i7;
                this.g.layout(i11 - this.g.getMeasuredWidth(), i10 - this.g.getMeasuredHeight(), i11, i10);
            } else if (childAt == this.i) {
                if (this.i.a()) {
                    a(this.i);
                    if (this.l == null) {
                        int a2 = (int) ((this.f2056a == ScreenShape.ROUND ? a(s / 2, this.i.getMeasuredWidth() / 2) : 0) + (12.0f * f) + this.D);
                        int measuredWidth = (r - this.i.getMeasuredWidth()) / 2;
                        this.i.layout(measuredWidth, a2, this.i.getMeasuredWidth() + measuredWidth, this.i.getMeasuredHeight() + a2);
                    } else {
                        this.i.layout(this.l.x, this.l.y, this.l.x + this.i.getMeasuredWidth(), this.l.y + this.i.getMeasuredHeight());
                    }
                }
            } else if (childAt == this.m) {
                int i12 = 0;
                int i13 = 0;
                if (this.f2056a == ScreenShape.ROUND) {
                    a(this.i);
                    int i14 = r / 2;
                    i13 = a(i14, this.i.getMeasuredWidth() / 2);
                    i12 = ((r / 2) - a(i14, i14 - i13)) + t;
                }
                a(this.m);
                if (this.k == null) {
                    this.G = this.m.getMeasuredWidth();
                    this.F = this.m.getMeasuredHeight();
                    int i15 = (int) (i12 + this.B + (5.0f * f2));
                    int i16 = (s - ((int) (this.E + (12.0f * f)))) - i13;
                    this.m.layout(i15, i16 - this.m.getMeasuredHeight(), this.G + i15, i16);
                } else {
                    this.m.layout(this.k.x, this.k.y, this.k.x + this.m.getMeasuredWidth(), this.k.y + this.m.getMeasuredHeight());
                }
            } else if (childAt == this.n) {
                a(this.n);
                this.n.layout(0, 0, this.n.getMeasuredWidth(), s);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof MapViewLayoutParams) {
                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                    Point a3 = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.b : this.e.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f2033a));
                    a(childAt);
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    float f3 = mapViewLayoutParams.d;
                    int i17 = (int) (a3.x - (f3 * measuredWidth2));
                    int i18 = mapViewLayoutParams.f + ((int) (a3.y - (mapViewLayoutParams.e * measuredHeight)));
                    childAt.layout(i17, i18, i17 + measuredWidth2, i18 + measuredHeight);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null || this.f == null) {
            return;
        }
        bundle.putParcelable("mapstatus", this.f.getMapStatus());
        if (this.k != null) {
            bundle.putParcelable("scalePosition", this.k);
        }
        if (this.l != null) {
            bundle.putParcelable("zoomPosition", this.l);
        }
        bundle.putBoolean("mZoomControlEnabled", this.x);
        bundle.putBoolean("mScaleControlEnabled", this.y);
        bundle.putInt("paddingLeft", this.B);
        bundle.putInt("paddingTop", this.D);
        bundle.putInt("paddingRight", this.C);
        bundle.putInt("paddingBottom", this.E);
        bundle.putString("customMapPath", c);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.g) {
            return;
        }
        super.removeView(view);
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        if (this.n == null) {
            return;
        }
        this.n.setCallback(onDismissCallback);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.B = i;
        this.D = i2;
        this.C = i3;
        this.E = i4;
    }

    public void setScaleControlPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.f2056a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.j = z;
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.l = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
        this.y = z;
    }

    public void showZoomControls(boolean z) {
        if (this.i.a()) {
            this.i.setVisibility(z ? 0 : 8);
            this.x = z;
        }
    }
}
