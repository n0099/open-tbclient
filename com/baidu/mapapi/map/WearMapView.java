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
    public static String f7051c;
    public static final SparseArray<Integer> w;
    public com.baidu.mapsdkplatform.comapi.map.l A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;

    /* renamed from: a  reason: collision with root package name */
    public ScreenShape f7053a;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f7054e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduMap f7055f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f7056g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f7057h;
    public ak i;
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
    public static final String f7050b = MapView.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static int f7052d = 0;
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
        public final WeakReference<Context> f7061b;

        public a(Context context) {
            this.f7061b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f7061b.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what == 1 && WearMapView.this.i != null) {
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
        this.f7053a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.u = true;
        this.f7053a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        this.u = true;
        this.f7053a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.j = true;
        this.u = true;
        this.f7053a = ScreenShape.ROUND;
        this.x = true;
        this.y = true;
        a(context, baiduMapOptions);
    }

    private int a(int i, int i2) {
        return i - ((int) Math.sqrt(Math.pow(i, 2.0d) - Math.pow(i2, 2.0d)));
    }

    private void a(int i) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7054e;
        if (jVar == null) {
            return;
        }
        if (i == 0) {
            jVar.onPause();
            b();
        } else if (i != 1) {
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
        a(context, baiduMapOptions, f7051c);
        this.f7055f = new BaiduMap(this.f7054e);
        this.f7054e.a().s(false);
        this.f7054e.a().r(false);
        c(context);
        d(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6822h) {
            this.i.setVisibility(4);
        }
        e(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
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
            this.f7054e = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, f7052d);
        } else {
            this.f7054e = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, f7052d);
        }
        addView(this.f7054e);
        this.A = new w(this);
        this.f7054e.a().a(this.A);
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
            a(this.i, z);
        }
    }

    private void b() {
        if (this.f7054e == null || this.u) {
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
        if (this.f7054e != null && this.u) {
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
            this.f7057h = a2;
            if (this.f7057h == null) {
                ImageView imageView = new ImageView(context);
                this.f7056g = imageView;
                imageView.setImageBitmap(this.f7057h);
                addView(this.f7056g);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f7057h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f7057h == null) {
        }
    }

    private void d() {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7054e;
        if (jVar == null) {
            return;
        }
        jVar.b();
    }

    private void d(Context context) {
        ak akVar = new ak(context, true);
        this.i = akVar;
        if (akVar.a()) {
            this.i.b(new x(this));
            this.i.a(new y(this));
            addView(this.i);
        }
    }

    private void e() {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7054e;
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
        f7051c = str;
    }

    public static void setIconCustom(int i) {
        f7052d = i;
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
        BaiduMap baiduMap = this.f7055f;
        baiduMap.f6810c = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return w.get((int) this.f7054e.a().E().f7570a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.F;
    }

    public int getScaleControlViewWidth() {
        return this.G;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f7053a = windowInsets.isRound() ? ScreenShape.ROUND : ScreenShape.RECTANGLE;
        return windowInsets;
    }

    public void onCreate(Context context, Bundle bundle) {
        BaiduMapOptions mapStatus;
        if (bundle == null) {
            return;
        }
        f7051c = bundle.getString("customMapPath");
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
            this.f7054e.b(context.hashCode());
        }
        Bitmap bitmap = this.f7057h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7057h.recycle();
            this.f7057h = null;
        }
        this.i.b();
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
        } else if (this.i.getVisibility() == 0) {
            Timer timer2 = this.mTimer;
            if (timer2 != null) {
                if (this.mTask != null) {
                    timer2.cancel();
                    this.mTask.cancel();
                }
                this.mTimer = null;
                this.mTask = null;
            }
        } else if (this.i.getVisibility() == 4) {
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
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f2;
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        a(this.f7056g);
        float f3 = 1.0f;
        if (((getWidth() - this.B) - this.C) - this.f7056g.getMeasuredWidth() <= 0 || ((getHeight() - this.D) - this.E) - this.f7056g.getMeasuredHeight() <= 0) {
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
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7054e;
            if (childAt == jVar) {
                jVar.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.f7056g) {
                int i10 = (int) (this.E + (12.0f * f3));
                if (this.f7053a == ScreenShape.ROUND) {
                    a(this.i);
                    int i11 = r / 2;
                    i7 = a(i11, this.i.getMeasuredWidth() / 2);
                    i8 = ((r / 2) - a(i11, i11 - i7)) + t;
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i12 = (s - i7) - i10;
                int i13 = r - i8;
                this.f7056g.layout(i13 - this.f7056g.getMeasuredWidth(), i12 - this.f7056g.getMeasuredHeight(), i13, i12);
            } else {
                ak akVar = this.i;
                if (childAt == akVar) {
                    if (akVar.a()) {
                        a(this.i);
                        Point point = this.l;
                        if (point == null) {
                            int a2 = (int) ((12.0f * f3) + this.D + (this.f7053a == ScreenShape.ROUND ? a(s / 2, this.i.getMeasuredWidth() / 2) : 0));
                            int measuredWidth = (r - this.i.getMeasuredWidth()) / 2;
                            this.i.layout(measuredWidth, a2, this.i.getMeasuredWidth() + measuredWidth, this.i.getMeasuredHeight() + a2);
                        } else {
                            ak akVar2 = this.i;
                            int i14 = point.x;
                            akVar2.layout(i14, point.y, akVar2.getMeasuredWidth() + i14, this.l.y + this.i.getMeasuredHeight());
                        }
                    }
                } else if (childAt == this.m) {
                    if (this.f7053a == ScreenShape.ROUND) {
                        a(akVar);
                        int i15 = r / 2;
                        i5 = a(i15, this.i.getMeasuredWidth() / 2);
                        i6 = ((r / 2) - a(i15, i15 - i5)) + t;
                    } else {
                        i5 = 0;
                        i6 = 0;
                    }
                    a(this.m);
                    Point point2 = this.k;
                    if (point2 == null) {
                        this.G = this.m.getMeasuredWidth();
                        this.F = this.m.getMeasuredHeight();
                        int i16 = (int) (this.B + (5.0f * f2) + i6);
                        int i17 = (s - ((int) (this.E + (12.0f * f3)))) - i5;
                        this.m.layout(i16, i17 - this.m.getMeasuredHeight(), this.G + i16, i17);
                    } else {
                        RelativeLayout relativeLayout = this.m;
                        int i18 = point2.x;
                        relativeLayout.layout(i18, point2.y, relativeLayout.getMeasuredWidth() + i18, this.k.y + this.m.getMeasuredHeight());
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
                            Point a3 = mapViewLayoutParams.f6930c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f6929b : this.f7054e.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f6928a));
                            a(childAt);
                            int measuredWidth2 = childAt.getMeasuredWidth();
                            int measuredHeight = childAt.getMeasuredHeight();
                            float f4 = mapViewLayoutParams.f6931d;
                            float f5 = mapViewLayoutParams.f6932e;
                            int i19 = (int) (a3.x - (f4 * measuredWidth2));
                            int i20 = ((int) (a3.y - (f5 * measuredHeight))) + mapViewLayoutParams.f6933f;
                            childAt.layout(i19, i20, measuredWidth2 + i19, measuredHeight + i20);
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f7055f) == null) {
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
        bundle.putString("customMapPath", f7051c);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f7056g) {
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
    public void setPadding(int i, int i2, int i3, int i4) {
        this.B = i;
        this.D = i2;
        this.C = i3;
        this.E = i4;
    }

    public void setScaleControlPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.f7053a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.j = z;
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
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
