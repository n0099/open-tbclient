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
import com.baidu.android.imsdk.IMConstants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
@TargetApi(20)
/* loaded from: classes2.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;

    /* renamed from: c  reason: collision with root package name */
    public static String f7340c;
    public static final SparseArray<Integer> w;
    public com.baidu.mapsdkplatform.comapi.map.l A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;

    /* renamed from: a  reason: collision with root package name */
    public ScreenShape f7342a;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f7343e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduMap f7344f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f7345g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f7346h;

    /* renamed from: i  reason: collision with root package name */
    public ak f7347i;
    public boolean j;
    public Point k;
    public Point l;
    public RelativeLayout m;
    public AnimationTask mTask;
    public Timer mTimer;
    public a mTimerHandler;
    public SwipeDismissView n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public boolean u;
    public Context v;
    public boolean x;
    public boolean y;
    public float z;

    /* renamed from: b  reason: collision with root package name */
    public static final String f7339b = MapView.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static int f7341d = 0;
    public static int r = 0;
    public static int s = 0;
    public static int t = 10;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    /* loaded from: classes2.dex */
    public enum ScreenShape {
        ROUND,
        RECTANGLE,
        UNDETECTED
    }

    /* loaded from: classes2.dex */
    public class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f7351b;

        public a(Context context) {
            this.f7351b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f7351b.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what == 1 && WearMapView.this.f7347i != null) {
                WearMapView.this.a(true);
            }
        }
    }

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        w = sparseArray;
        sparseArray.append(3, 2000000);
        w.append(4, 1000000);
        w.append(5, 500000);
        w.append(6, 200000);
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
        this.f7342a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.u = true;
        this.f7342a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = true;
        this.u = true;
        this.f7342a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.j = true;
        this.u = true;
        this.f7342a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, baiduMapOptions);
    }

    private int a(int i2, int i3) {
        return i2 - ((int) Math.sqrt(Math.pow(i2, 2.0d) - Math.pow(i3, 2.0d)));
    }

    private void a(int i2) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7343e;
        if (jVar == null) {
            return;
        }
        if (i2 == 0) {
            jVar.onPause();
            b();
        } else if (i2 != 1) {
        } else {
            jVar.onResume();
            c();
        }
    }

    public static void a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        r = point.x;
        s = point.y;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        AnimationTask animationTask;
        a(context);
        setOnApplyWindowInsetsListener(this);
        this.v = context;
        this.mTimerHandler = new a(context);
        Timer timer = new Timer();
        this.mTimer = timer;
        if (timer != null && (animationTask = this.mTask) != null) {
            animationTask.cancel();
        }
        AnimationTask animationTask2 = new AnimationTask();
        this.mTask = animationTask2;
        this.mTimer.schedule(animationTask2, 5000L);
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        a(context, baiduMapOptions, f7340c);
        this.f7344f = new BaiduMap(this.f7343e);
        this.f7343e.a().s(false);
        this.f7343e.a().r(false);
        c(context);
        d(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f7095h) {
            this.f7347i.setVisibility(4);
        }
        e(context);
        if (baiduMapOptions != null && !baiduMapOptions.f7096i) {
            this.m.setVisibility(4);
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.l = point2;
        }
        if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
            return;
        }
        this.k = point;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        if (baiduMapOptions == null) {
            this.f7343e = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, f7341d);
        } else {
            this.f7343e = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, f7341d);
        }
        addView(this.f7343e);
        this.A = new w(this);
        this.f7343e.a().a(this.A);
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

    private void a(View view, boolean z) {
        AnimatorSet animatorSet;
        if (z) {
            animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", 0.0f, -50.0f), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f));
            animatorSet.addListener(new z(this, view));
        } else {
            view.setVisibility(0);
            animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", -50.0f, 0.0f), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f));
        }
        animatorSet.setDuration(IMLikeRequest.TIME_INTERVAL);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.j) {
            a(this.f7347i, z);
        }
    }

    private void b() {
        if (this.f7343e == null || this.u) {
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
        if (this.f7343e != null && this.u) {
            e();
            this.u = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(Context context) {
        Matrix matrix;
        float f2;
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            matrix = new Matrix();
            f2 = 2.0f;
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.f7346h = a2;
            if (this.f7346h == null) {
                ImageView imageView = new ImageView(context);
                this.f7345g = imageView;
                imageView.setImageBitmap(this.f7346h);
                addView(this.f7345g);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f7346h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f7346h == null) {
        }
    }

    private void d() {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7343e;
        if (jVar == null) {
            return;
        }
        jVar.b();
    }

    private void d(Context context) {
        ak akVar = new ak(context, true);
        this.f7347i = akVar;
        if (akVar.a()) {
            this.f7347i.b(new x(this));
            this.f7347i.a(new y(this));
            addView(this.f7347i);
        }
    }

    private void e() {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7343e;
        if (jVar == null) {
            return;
        }
        jVar.c();
    }

    private void e(Context context) {
        this.m = new RelativeLayout(context);
        this.m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.o = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.o.setTextColor(Color.parseColor("#FFFFFF"));
        this.o.setTextSize(2, 11.0f);
        TextView textView = this.o;
        textView.setTypeface(textView.getTypeface(), 1);
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
        f7340c = str;
    }

    public static void setIconCustom(int i2) {
        f7341d = i2;
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
        BaiduMap baiduMap = this.f7344f;
        baiduMap.f7082c = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return w.get((int) this.f7343e.a().E().f7874a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.F;
    }

    public int getScaleControlViewWidth() {
        return this.G;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f7342a = windowInsets.isRound() ? ScreenShape.ROUND : ScreenShape.RECTANGLE;
        return windowInsets;
    }

    public void onCreate(Context context, Bundle bundle) {
        BaiduMapOptions mapStatus;
        if (bundle == null) {
            return;
        }
        f7340c = bundle.getString("customMapPath");
        if (bundle == null) {
            mapStatus = new BaiduMapOptions();
        } else {
            MapStatus mapStatus2 = (MapStatus) bundle.getParcelable("mapstatus");
            if (this.k != null) {
                this.k = (Point) bundle.getParcelable("scalePosition");
            }
            if (this.l != null) {
                this.l = (Point) bundle.getParcelable("zoomPosition");
            }
            this.x = bundle.getBoolean("mZoomControlEnabled");
            this.y = bundle.getBoolean("mScaleControlEnabled");
            setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
            mapStatus = new BaiduMapOptions().mapStatus(mapStatus2);
        }
        a(context, mapStatus);
    }

    public final void onDestroy() {
        Context context = this.v;
        if (context != null) {
            this.f7343e.b(context.hashCode());
        }
        Bitmap bitmap = this.f7346h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7346h.recycle();
            this.f7346h = null;
        }
        this.f7347i.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        AnimationTask animationTask = this.mTask;
        if (animationTask != null) {
            animationTask.cancel();
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
        AnimationTask animationTask;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                Timer timer = new Timer();
                this.mTimer = timer;
                if (timer != null && (animationTask = this.mTask) != null) {
                    animationTask.cancel();
                }
                AnimationTask animationTask2 = new AnimationTask();
                this.mTask = animationTask2;
                this.mTimer.schedule(animationTask2, 5000L);
            }
        } else if (this.f7347i.getVisibility() == 0) {
            Timer timer2 = this.mTimer;
            if (timer2 != null) {
                if (this.mTask != null) {
                    timer2.cancel();
                    this.mTask.cancel();
                }
                this.mTimer = null;
                this.mTask = null;
            }
        } else if (this.f7347i.getVisibility() == 4) {
            if (this.mTimer != null) {
                AnimationTask animationTask3 = this.mTask;
                if (animationTask3 != null) {
                    animationTask3.cancel();
                }
                this.mTimer.cancel();
                this.mTask = null;
                this.mTimer = null;
            }
            a(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(20)
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        int childCount = getChildCount();
        a(this.f7345g);
        float f3 = 1.0f;
        if (((getWidth() - this.B) - this.C) - this.f7345g.getMeasuredWidth() <= 0 || ((getHeight() - this.D) - this.E) - this.f7345g.getMeasuredHeight() <= 0) {
            this.B = 0;
            this.C = 0;
            this.E = 0;
            this.D = 0;
            f2 = 1.0f;
        } else {
            float width = ((getWidth() - this.B) - this.C) / getWidth();
            f3 = ((getHeight() - this.D) - this.E) / getHeight();
            f2 = width;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7343e;
            if (childAt == jVar) {
                jVar.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.f7345g) {
                int i11 = (int) (this.E + (12.0f * f3));
                if (this.f7342a == ScreenShape.ROUND) {
                    a(this.f7347i);
                    int i12 = r / 2;
                    i8 = a(i12, this.f7347i.getMeasuredWidth() / 2);
                    i9 = ((r / 2) - a(i12, i12 - i8)) + t;
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int i13 = (s - i8) - i11;
                int i14 = r - i9;
                this.f7345g.layout(i14 - this.f7345g.getMeasuredWidth(), i13 - this.f7345g.getMeasuredHeight(), i14, i13);
            } else {
                ak akVar = this.f7347i;
                if (childAt == akVar) {
                    if (akVar.a()) {
                        a(this.f7347i);
                        Point point = this.l;
                        if (point == null) {
                            int a2 = (int) ((12.0f * f3) + this.D + (this.f7342a == ScreenShape.ROUND ? a(s / 2, this.f7347i.getMeasuredWidth() / 2) : 0));
                            int measuredWidth = (r - this.f7347i.getMeasuredWidth()) / 2;
                            this.f7347i.layout(measuredWidth, a2, this.f7347i.getMeasuredWidth() + measuredWidth, this.f7347i.getMeasuredHeight() + a2);
                        } else {
                            ak akVar2 = this.f7347i;
                            int i15 = point.x;
                            akVar2.layout(i15, point.y, akVar2.getMeasuredWidth() + i15, this.l.y + this.f7347i.getMeasuredHeight());
                        }
                    }
                } else if (childAt == this.m) {
                    if (this.f7342a == ScreenShape.ROUND) {
                        a(akVar);
                        int i16 = r / 2;
                        i6 = a(i16, this.f7347i.getMeasuredWidth() / 2);
                        i7 = ((r / 2) - a(i16, i16 - i6)) + t;
                    } else {
                        i6 = 0;
                        i7 = 0;
                    }
                    a(this.m);
                    Point point2 = this.k;
                    if (point2 == null) {
                        this.G = this.m.getMeasuredWidth();
                        this.F = this.m.getMeasuredHeight();
                        int i17 = (int) (this.B + (5.0f * f2) + i7);
                        int i18 = (s - ((int) (this.E + (12.0f * f3)))) - i6;
                        this.m.layout(i17, i18 - this.m.getMeasuredHeight(), this.G + i17, i18);
                    } else {
                        RelativeLayout relativeLayout = this.m;
                        int i19 = point2.x;
                        relativeLayout.layout(i19, point2.y, relativeLayout.getMeasuredWidth() + i19, this.k.y + this.m.getMeasuredHeight());
                    }
                } else {
                    View view = this.n;
                    if (childAt == view) {
                        a(view);
                        this.n.layout(0, 0, this.n.getMeasuredWidth(), s);
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams instanceof MapViewLayoutParams) {
                            MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                            Point a3 = mapViewLayoutParams.f7210c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f7209b : this.f7343e.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f7208a));
                            a(childAt);
                            int measuredWidth2 = childAt.getMeasuredWidth();
                            int measuredHeight = childAt.getMeasuredHeight();
                            float f4 = mapViewLayoutParams.f7211d;
                            float f5 = mapViewLayoutParams.f7212e;
                            int i20 = (int) (a3.x - (f4 * measuredWidth2));
                            int i21 = ((int) (a3.y - (f5 * measuredHeight))) + mapViewLayoutParams.f7213f;
                            childAt.layout(i20, i21, measuredWidth2 + i20, measuredHeight + i21);
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f7344f) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.k;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.l;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.x);
        bundle.putBoolean("mScaleControlEnabled", this.y);
        bundle.putInt("paddingLeft", this.B);
        bundle.putInt("paddingTop", this.D);
        bundle.putInt("paddingRight", this.C);
        bundle.putInt("paddingBottom", this.E);
        bundle.putString("customMapPath", f7340c);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f7345g) {
            return;
        }
        super.removeView(view);
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.n;
        if (swipeDismissView == null) {
            return;
        }
        swipeDismissView.setCallback(onDismissCallback);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.B = i2;
        this.D = i3;
        this.C = i4;
        this.E = i5;
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.f7342a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.j = z;
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.l = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
        this.y = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f7347i.a()) {
            this.f7347i.setVisibility(z ? 0 : 8);
            this.x = z;
        }
    }
}
