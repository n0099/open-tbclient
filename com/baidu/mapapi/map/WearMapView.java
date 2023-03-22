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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
@TargetApi(20)
/* loaded from: classes2.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;
    public static String c;
    public static final SparseArray<Integer> x;
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public ScreenShape a;
    public MapSurfaceView f;
    public BaiduMap g;
    public ImageView h;
    public Bitmap i;
    public com.baidu.mapsdkplatform.comapi.map.ad j;
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
    public static final String b = MapView.class.getSimpleName();
    public static int d = 0;
    public static int e = 0;
    public static int s = 0;
    public static int t = 0;
    public static int u = 10;

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

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
    }

    public void setMapCustomStyleEnable(boolean z) {
    }

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
    public class a extends Handler {
        public final WeakReference<Context> b;

        public a(Context context) {
            this.b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.b.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what != 1 || WearMapView.this.j == null) {
                return;
            }
            WearMapView.this.a(true);
        }
    }

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        x = sparseArray;
        sparseArray.append(3, 2000000);
        x.append(4, 1000000);
        x.append(5, 500000);
        x.append(6, 200000);
        x.append(7, Integer.valueOf((int) DefaultOggSeeker.MATCH_BYTE_RANGE));
        x.append(8, 50000);
        x.append(9, 25000);
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
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(int i) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                mapSurfaceView.onResume();
                c();
                return;
            }
            return;
        }
        mapSurfaceView.onPause();
        b();
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str != null && str.length() != 0) {
            if (new File(str).exists()) {
                c = str;
                return;
            }
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
    }

    @Deprecated
    public static void setIconCustom(int i) {
        e = i;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        d = i;
    }

    public final void onEnterAmbient(Bundle bundle) {
        a(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        if (view2 == this.h) {
            return;
        }
        super.removeView(view2);
    }

    public void setMapCustomStylePath(String str) {
        a(str, "");
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.o;
        if (swipeDismissView == null) {
            return;
        }
        swipeDismissView.setCallback(onDismissCallback);
    }

    public void setScaleControlPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.l = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.k = z;
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.m = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        int i;
        RelativeLayout relativeLayout = this.n;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        relativeLayout.setVisibility(i);
        this.z = z;
    }

    public void showZoomControls(boolean z) {
        int i;
        if (this.j.a()) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = this.j;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            adVar.setVisibility(i);
            this.y = z;
        }
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = true;
        this.v = true;
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view2, layoutParams);
        }
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
        if (windowInsets.isRound()) {
            this.a = ScreenShape.ROUND;
        } else {
            this.a = ScreenShape.RECTANGLE;
        }
        return windowInsets;
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.w, customMapStyleId, new ag(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath != null && !localCustomStyleFilePath.isEmpty()) {
            a(localCustomStyleFilePath, "");
        }
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = true;
        this.v = true;
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.k = true;
        this.v = true;
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, baiduMapOptions);
    }

    private int a(int i, int i2) {
        return i - ((int) Math.sqrt(Math.pow(i, 2.0d) - Math.pow(i2, 2.0d)));
    }

    private void b() {
        if (this.f != null && !this.v) {
            d();
            this.v = true;
        }
    }

    private void c() {
        if (this.f != null && this.v) {
            e();
            this.v = false;
        }
    }

    private void d() {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.onBackground();
    }

    private void e() {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.onForeground();
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.g;
        baiduMap.c = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return x.get((int) this.f.getZoomLevel()).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.F;
    }

    public int getScaleControlViewWidth() {
        return this.G;
    }

    public final void onDestroy() {
        if (this.w != null) {
            this.f.unInit();
        }
        Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        this.j.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.j.b();
        AnimationTask animationTask = this.mTask;
        if (animationTask != null) {
            animationTask.cancel();
        }
        this.w = null;
    }

    public final void onDismiss() {
        removeAllViews();
    }

    public void onExitAmbient() {
        a(1);
    }

    public static void a(Context context) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void d(Context context) {
        com.baidu.mapsdkplatform.comapi.map.ad adVar = new com.baidu.mapsdkplatform.comapi.map.ad(context, true);
        this.j = adVar;
        if (!adVar.a()) {
            return;
        }
        this.j.b(new ai(this));
        this.j.a(new aj(this));
        addView(this.j);
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
        com.baidu.mapsdkplatform.comapi.map.j.a();
        BMapManager.init();
        a(context, baiduMapOptions, c);
        this.f.getController().set3DGestureEnable(false);
        this.f.getController().setOverlookGestureEnable(false);
        c(context);
        d(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.j.setVisibility(4);
        }
        e(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.n.setVisibility(4);
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.m = point2;
        }
        if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
            this.l = point;
        }
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

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        this.f = new MapSurfaceView(context);
        if (baiduMapOptions != null) {
            this.g = new BaiduMap(context, this.f, baiduMapOptions.a());
        } else {
            this.g = new BaiduMap(context, this.f, (com.baidu.mapsdkplatform.comapi.map.v) null);
        }
        addView(this.f);
        this.f.getBaseMap().a(new ah(this));
    }

    private void a(View view2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i2 = layoutParams.height;
        if (i2 > 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view2.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    private void a(View view2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view2, "TranslationY", 0.0f, -50.0f), ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f));
            animatorSet.addListener(new ak(this, view2));
            animatorSet.setDuration(IMLikeRequest.TIME_INTERVAL);
            animatorSet.start();
            return;
        }
        view2.setVisibility(0);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view2, "TranslationY", -50.0f, 0.0f), ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.0f, 1.0f));
        animatorSet2.setDuration(IMLikeRequest.TIME_INTERVAL);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "");
            setMapCustomStyleEnable(true);
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (!TextUtils.isEmpty(localCustomStyleFilePath)) {
            a(localCustomStyleFilePath, "");
            setMapCustomStyleEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView != null && mapSurfaceView.getBaseMap() != null) {
            if (TextUtils.isEmpty(str)) {
                Log.e(b, "customStyleFilePath is empty or null, please check!");
            } else if (!str.endsWith(".sty")) {
                Log.e(b, "customStyleFile format is incorrect , please check!");
            } else if (!new File(str).exists()) {
                Log.e(b, "customStyleFile does not exist , please check!");
            } else {
                this.f.getBaseMap().b(str, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!this.k) {
            return;
        }
        a(this.j, z);
    }

    private void b(Context context) {
        this.o = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), t);
        this.o.setBackgroundColor(Color.argb(0, 0, 0, 0));
        this.o.setLayoutParams(layoutParams);
        addView(this.o);
    }

    private void c(Context context) {
        String str;
        int densityDpi = SysOSUtil.getDensityDpi();
        if (densityDpi < 180) {
            str = "logo_l.png";
        } else {
            str = "logo_h.png";
        }
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi > 320 && densityDpi <= 480) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        } else {
            this.i = a2;
        }
        if (this.i != null) {
            ImageView imageView = new ImageView(context);
            this.h = imageView;
            imageView.setImageBitmap(this.i);
            addView(this.h);
        }
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

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(20)
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        Point point;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int childCount = getChildCount();
        a(this.h);
        float f2 = 1.0f;
        if (((getWidth() - this.B) - this.C) - this.h.getMeasuredWidth() > 0 && ((getHeight() - this.D) - this.E) - this.h.getMeasuredHeight() > 0) {
            float width = ((getWidth() - this.B) - this.C) / getWidth();
            f2 = ((getHeight() - this.D) - this.E) / getHeight();
            f = width;
        } else {
            this.B = 0;
            this.C = 0;
            this.E = 0;
            this.D = 0;
            f = 1.0f;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            MapSurfaceView mapSurfaceView = this.f;
            if (childAt == mapSurfaceView) {
                mapSurfaceView.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.h) {
                int i11 = (int) (this.E + (12.0f * f2));
                if (this.a == ScreenShape.ROUND) {
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
                int measuredWidth = i14 - this.h.getMeasuredWidth();
                this.h.layout(measuredWidth, i13 - this.h.getMeasuredHeight(), i14, i13);
            } else {
                com.baidu.mapsdkplatform.comapi.map.ad adVar = this.j;
                if (childAt == adVar) {
                    if (adVar.a()) {
                        a(this.j);
                        Point point2 = this.m;
                        if (point2 == null) {
                            if (this.a == ScreenShape.ROUND) {
                                i7 = a(t / 2, this.j.getMeasuredWidth() / 2);
                            } else {
                                i7 = 0;
                            }
                            int i15 = (int) ((12.0f * f2) + this.D + i7);
                            int measuredWidth2 = (s - this.j.getMeasuredWidth()) / 2;
                            this.j.layout(measuredWidth2, i15, this.j.getMeasuredWidth() + measuredWidth2, this.j.getMeasuredHeight() + i15);
                        } else {
                            com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.j;
                            int i16 = point2.x;
                            adVar2.layout(i16, point2.y, adVar2.getMeasuredWidth() + i16, this.m.y + this.j.getMeasuredHeight());
                        }
                    }
                } else if (childAt == this.n) {
                    if (this.a == ScreenShape.ROUND) {
                        a(adVar);
                        int i17 = s / 2;
                        i5 = a(i17, this.j.getMeasuredWidth() / 2);
                        i6 = ((s / 2) - a(i17, i17 - i5)) + u;
                    } else {
                        i5 = 0;
                        i6 = 0;
                    }
                    a(this.n);
                    Point point3 = this.l;
                    if (point3 == null) {
                        this.G = this.n.getMeasuredWidth();
                        this.F = this.n.getMeasuredHeight();
                        int i18 = (int) (this.B + (5.0f * f) + i6);
                        int i19 = (t - ((int) (this.E + (12.0f * f2)))) - i5;
                        int measuredHeight = i19 - this.n.getMeasuredHeight();
                        this.n.layout(i18, measuredHeight, this.G + i18, i19);
                    } else {
                        RelativeLayout relativeLayout = this.n;
                        int i20 = point3.x;
                        relativeLayout.layout(i20, point3.y, relativeLayout.getMeasuredWidth() + i20, this.l.y + this.n.getMeasuredHeight());
                    }
                } else {
                    View view2 = this.o;
                    if (childAt == view2) {
                        a(view2);
                        this.o.layout(0, 0, this.o.getMeasuredWidth(), t);
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams instanceof MapViewLayoutParams) {
                            MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                            if (mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {
                                point = mapViewLayoutParams.b;
                            } else {
                                GeoPoint ll2mc = CoordUtil.ll2mc(mapViewLayoutParams.a);
                                if (this.f.getBaseMap() != null) {
                                    point = this.f.getBaseMap().a(ll2mc);
                                } else {
                                    point = new Point();
                                }
                            }
                            a(childAt);
                            int measuredWidth3 = childAt.getMeasuredWidth();
                            int measuredHeight2 = childAt.getMeasuredHeight();
                            float f3 = mapViewLayoutParams.d;
                            float f4 = mapViewLayoutParams.e;
                            int i21 = (int) (point.x - (f3 * measuredWidth3));
                            int i22 = ((int) (point.y - (f4 * measuredHeight2))) + mapViewLayoutParams.f;
                            childAt.layout(i21, i22, measuredWidth3 + i21, measuredHeight2 + i22);
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle != null && (baiduMap = this.g) != null) {
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
            bundle.putInt("paddingLeft", this.B);
            bundle.putInt("paddingTop", this.D);
            bundle.putInt("paddingRight", this.C);
            bundle.putInt("paddingBottom", this.E);
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.B = i;
        this.D = i2;
        this.C = i3;
        this.E = i4;
    }
}
