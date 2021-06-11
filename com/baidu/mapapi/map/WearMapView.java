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
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.mapsdkplatform.comapi.util.CustomMapStyleLoader;
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
    public static String f7099c;
    public static final SparseArray<Integer> x;
    public float A;
    public com.baidu.mapsdkplatform.comapi.map.l B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;

    /* renamed from: a  reason: collision with root package name */
    public ScreenShape f7102a;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f7103f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduMap f7104g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f7105h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f7106i;
    public ak j;
    public boolean k;
    public Point l;
    public Point m;
    public AnimationTask mTask;
    public Timer mTimer;
    public a mTimerHandler;
    public RelativeLayout n;
    public SwipeDismissView o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public boolean v;
    public Context w;
    public boolean y;
    public boolean z;

    /* renamed from: b  reason: collision with root package name */
    public static final String f7098b = MapView.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static int f7100d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f7101e = 0;
    public static int s = 0;
    public static int t = 0;
    public static int u = 10;

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
        public final WeakReference<Context> f7110b;

        public a(Context context) {
            this.f7110b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f7110b.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what == 1 && WearMapView.this.j != null) {
                WearMapView.this.a(true);
            }
        }
    }

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        x = sparseArray;
        sparseArray.append(3, 2000000);
        x.append(4, 1000000);
        x.append(5, 500000);
        x.append(6, 200000);
        x.append(7, 100000);
        x.append(8, 50000);
        x.append(9, Integer.valueOf((int) BdNetTask.TIMEOUT_READ));
        x.append(10, 20000);
        x.append(11, 10000);
        x.append(12, 5000);
        x.append(13, 2000);
        x.append(14, 1000);
        x.append(15, 500);
        x.append(16, 200);
        x.append(17, 100);
        x.append(18, 50);
        x.append(19, 20);
        x.append(20, 10);
        x.append(21, 5);
        x.append(22, 2);
    }

    public WearMapView(Context context) {
        super(context);
        this.k = true;
        this.v = true;
        this.f7102a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = true;
        this.v = true;
        this.f7102a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = true;
        this.v = true;
        this.f7102a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.k = true;
        this.v = true;
        this.f7102a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        a(context, baiduMapOptions);
    }

    private int a(int i2, int i3) {
        return i2 - ((int) Math.sqrt(Math.pow(i2, 2.0d) - Math.pow(i3, 2.0d)));
    }

    private void a(int i2) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7103f;
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
        s = point.x;
        t = point.y;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        AnimationTask animationTask;
        a(context);
        setOnApplyWindowInsetsListener(this);
        this.w = context;
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
        a(context, baiduMapOptions, f7100d == 0 ? f7099c : CustomMapStyleLoader.getCustomStyleFilePath());
        this.f7104g = new BaiduMap(this.f7103f);
        this.f7103f.a().t(false);
        this.f7103f.a().s(false);
        c(context);
        d(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6849h) {
            this.j.setVisibility(4);
        }
        e(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6850i) {
            this.n.setVisibility(4);
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.m = point2;
        }
        if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
            return;
        }
        this.l = point;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        if (baiduMapOptions == null) {
            this.f7103f = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, f7101e);
        } else {
            this.f7103f = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, f7101e);
        }
        addView(this.f7103f);
        this.B = new x(this);
        this.f7103f.a().a(this.B);
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
            animatorSet.addListener(new aa(this, view));
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
        if (this.k) {
            a(this.j, z);
        }
    }

    private void b() {
        if (this.f7103f == null || this.v) {
            return;
        }
        d();
        this.v = true;
    }

    private void b(Context context) {
        this.o = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), t);
        this.o.setBackgroundColor(Color.argb(0, 0, 0, 0));
        this.o.setLayoutParams(layoutParams);
        addView(this.o);
    }

    private void c() {
        if (this.f7103f != null && this.v) {
            e();
            this.v = false;
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
            this.f7106i = a2;
            if (this.f7106i == null) {
                ImageView imageView = new ImageView(context);
                this.f7105h = imageView;
                imageView.setImageBitmap(this.f7106i);
                addView(this.f7105h);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f7106i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f7106i == null) {
        }
    }

    private void d() {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7103f;
        if (jVar == null) {
            return;
        }
        jVar.b();
    }

    private void d(Context context) {
        ak akVar = new ak(context, true);
        this.j = akVar;
        if (akVar.a()) {
            this.j.b(new y(this));
            this.j.a(new z(this));
            addView(this.j);
        }
    }

    private void e() {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7103f;
        if (jVar == null) {
            return;
        }
        jVar.c();
    }

    private void e(Context context) {
        this.n = new RelativeLayout(context);
        this.n.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.p = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.p.setTextColor(Color.parseColor("#FFFFFF"));
        this.p.setTextSize(2, 11.0f);
        TextView textView = this.p;
        textView.setTypeface(textView.getTypeface(), 1);
        this.p.setLayoutParams(layoutParams);
        this.p.setId(Integer.MAX_VALUE);
        this.n.addView(this.p);
        this.q = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.q.setTextColor(Color.parseColor("#000000"));
        this.q.setTextSize(2, 11.0f);
        this.q.setLayoutParams(layoutParams2);
        this.n.addView(this.q);
        this.r = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.p.getId());
        this.r.setLayoutParams(layoutParams3);
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.r.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        this.n.addView(this.r);
        addView(this.n);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        f7099c = str;
    }

    @Deprecated
    public static void setIconCustom(int i2) {
        f7101e = i2;
    }

    public static void setLoadCustomMapStyleFileMode(int i2) {
        f7100d = i2;
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

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f7104g;
        baiduMap.f6836c = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return x.get((int) this.f7103f.a().E().f7614a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.G;
    }

    public int getScaleControlViewWidth() {
        return this.H;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f7102a = windowInsets.isRound() ? ScreenShape.ROUND : ScreenShape.RECTANGLE;
        return windowInsets;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.l != null) {
            this.l = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.m != null) {
            this.m = (Point) bundle.getParcelable("zoomPosition");
        }
        this.y = bundle.getBoolean("mZoomControlEnabled");
        this.z = bundle.getBoolean("mScaleControlEnabled");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        Context context = this.w;
        if (context != null) {
            this.f7103f.b(context.hashCode());
        }
        Bitmap bitmap = this.f7106i;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7106i.recycle();
            this.f7106i = null;
        }
        this.j.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        AnimationTask animationTask = this.mTask;
        if (animationTask != null) {
            animationTask.cancel();
        }
        this.w = null;
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
        } else if (this.j.getVisibility() == 0) {
            Timer timer2 = this.mTimer;
            if (timer2 != null) {
                if (this.mTask != null) {
                    timer2.cancel();
                    this.mTask.cancel();
                }
                this.mTimer = null;
                this.mTask = null;
            }
        } else if (this.j.getVisibility() == 4) {
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
        a(this.f7105h);
        float f3 = 1.0f;
        if (((getWidth() - this.C) - this.D) - this.f7105h.getMeasuredWidth() <= 0 || ((getHeight() - this.E) - this.F) - this.f7105h.getMeasuredHeight() <= 0) {
            this.C = 0;
            this.D = 0;
            this.F = 0;
            this.E = 0;
            f2 = 1.0f;
        } else {
            float width = ((getWidth() - this.C) - this.D) / getWidth();
            f3 = ((getHeight() - this.E) - this.F) / getHeight();
            f2 = width;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            com.baidu.mapsdkplatform.comapi.map.j jVar = this.f7103f;
            if (childAt == jVar) {
                jVar.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.f7105h) {
                int i11 = (int) (this.F + (12.0f * f3));
                if (this.f7102a == ScreenShape.ROUND) {
                    a(this.j);
                    int i12 = s / 2;
                    i8 = a(i12, this.j.getMeasuredWidth() / 2);
                    i9 = ((s / 2) - a(i12, i12 - i8)) + u;
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int i13 = (t - i8) - i11;
                int i14 = s - i9;
                this.f7105h.layout(i14 - this.f7105h.getMeasuredWidth(), i13 - this.f7105h.getMeasuredHeight(), i14, i13);
            } else {
                ak akVar = this.j;
                if (childAt == akVar) {
                    if (akVar.a()) {
                        a(this.j);
                        Point point = this.m;
                        if (point == null) {
                            int a2 = (int) ((12.0f * f3) + this.E + (this.f7102a == ScreenShape.ROUND ? a(t / 2, this.j.getMeasuredWidth() / 2) : 0));
                            int measuredWidth = (s - this.j.getMeasuredWidth()) / 2;
                            this.j.layout(measuredWidth, a2, this.j.getMeasuredWidth() + measuredWidth, this.j.getMeasuredHeight() + a2);
                        } else {
                            ak akVar2 = this.j;
                            int i15 = point.x;
                            akVar2.layout(i15, point.y, akVar2.getMeasuredWidth() + i15, this.m.y + this.j.getMeasuredHeight());
                        }
                    }
                } else if (childAt == this.n) {
                    if (this.f7102a == ScreenShape.ROUND) {
                        a(akVar);
                        int i16 = s / 2;
                        i6 = a(i16, this.j.getMeasuredWidth() / 2);
                        i7 = ((s / 2) - a(i16, i16 - i6)) + u;
                    } else {
                        i6 = 0;
                        i7 = 0;
                    }
                    a(this.n);
                    Point point2 = this.l;
                    if (point2 == null) {
                        this.H = this.n.getMeasuredWidth();
                        this.G = this.n.getMeasuredHeight();
                        int i17 = (int) (this.C + (5.0f * f2) + i7);
                        int i18 = (t - ((int) (this.F + (12.0f * f3)))) - i6;
                        this.n.layout(i17, i18 - this.n.getMeasuredHeight(), this.H + i17, i18);
                    } else {
                        RelativeLayout relativeLayout = this.n;
                        int i19 = point2.x;
                        relativeLayout.layout(i19, point2.y, relativeLayout.getMeasuredWidth() + i19, this.l.y + this.n.getMeasuredHeight());
                    }
                } else {
                    View view = this.o;
                    if (childAt == view) {
                        a(view);
                        this.o.layout(0, 0, this.o.getMeasuredWidth(), t);
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams instanceof MapViewLayoutParams) {
                            MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                            Point a3 = mapViewLayoutParams.f6969c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f6968b : this.f7103f.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f6967a));
                            a(childAt);
                            int measuredWidth2 = childAt.getMeasuredWidth();
                            int measuredHeight = childAt.getMeasuredHeight();
                            float f4 = mapViewLayoutParams.f6970d;
                            float f5 = mapViewLayoutParams.f6971e;
                            int i20 = (int) (a3.x - (f4 * measuredWidth2));
                            int i21 = ((int) (a3.y - (f5 * measuredHeight))) + mapViewLayoutParams.f6972f;
                            childAt.layout(i20, i21, measuredWidth2 + i20, measuredHeight + i21);
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f7104g) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.l;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.m;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.y);
        bundle.putBoolean("mScaleControlEnabled", this.z);
        bundle.putInt("paddingLeft", this.C);
        bundle.putInt("paddingTop", this.E);
        bundle.putInt("paddingRight", this.D);
        bundle.putInt("paddingBottom", this.F);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f7105h) {
            return;
        }
        super.removeView(view);
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.o;
        if (swipeDismissView == null) {
            return;
        }
        swipeDismissView.setCallback(onDismissCallback);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.C = i2;
        this.E = i3;
        this.D = i4;
        this.F = i5;
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.l = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.f7102a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.k = z;
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.m = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.n.setVisibility(z ? 0 : 8);
        this.z = z;
    }

    public void showZoomControls(boolean z) {
        if (this.j.a()) {
            this.j.setVisibility(z ? 0 : 8);
            this.y = z;
        }
    }
}
