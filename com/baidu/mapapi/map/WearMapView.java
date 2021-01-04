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
import androidx.appcompat.widget.ActivityChooserView;
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
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
@TargetApi(20)
/* loaded from: classes15.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;
    private static String c;
    private float A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;

    /* renamed from: a  reason: collision with root package name */
    ScreenShape f2892a;
    private MapSurfaceView f;
    private BaiduMap g;
    private ImageView h;
    private Bitmap i;
    private com.baidu.mapsdkplatform.comapi.map.ab j;
    private boolean k;
    private Point l;
    private Point m;
    public AnimationTask mTask;
    public Timer mTimer;
    public a mTimerHandler;
    private RelativeLayout n;
    private SwipeDismissView o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private boolean v;
    private Context w;
    private boolean y;
    private boolean z;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2891b = MapView.class.getSimpleName();
    private static int d = 0;
    private static int e = 0;
    private static int s = 0;
    private static int t = 0;
    private static int u = 10;
    private static final SparseArray<Integer> x = new SparseArray<>();

    /* loaded from: classes15.dex */
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

    /* loaded from: classes15.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    /* loaded from: classes15.dex */
    public enum ScreenShape {
        ROUND,
        RECTANGLE,
        UNDETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<Context> f2896b;

        public a(Context context) {
            this.f2896b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f2896b.get() == null) {
                return;
            }
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (WearMapView.this.j != null) {
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
        x.append(3, 2000000);
        x.append(4, Integer.valueOf((int) MessageConfig.BASE_SEGMENT_LENGTH));
        x.append(5, 500000);
        x.append(6, Integer.valueOf((int) AlaRecorderLog.ErrCodeSeg.ERROR_BASE_RTMP));
        x.append(7, 100000);
        x.append(8, Integer.valueOf((int) IMConstants.ERROR_BASE));
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
        this.f2892a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = true;
        this.v = true;
        this.f2892a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = true;
        this.v = true;
        this.f2892a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.k = true;
        this.v = true;
        this.f2892a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, baiduMapOptions);
    }

    private int a(int i, int i2) {
        return i - ((int) Math.sqrt(Math.pow(i, 2.0d) - Math.pow(i2, 2.0d)));
    }

    private void a(int i) {
        if (this.f == null) {
            return;
        }
        switch (i) {
            case 0:
                this.f.onPause();
                b();
                return;
            case 1:
                this.f.onResume();
                c();
                return;
            default:
                return;
        }
    }

    private static void a(Context context) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        a(context);
        setOnApplyWindowInsetsListener(this);
        this.w = context;
        this.mTimerHandler = new a(context);
        this.mTimer = new Timer();
        if (this.mTimer != null && this.mTask != null) {
            this.mTask.cancel();
        }
        this.mTask = new AnimationTask();
        this.mTimer.schedule(this.mTask, 5000L);
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
        if (baiduMapOptions != null && baiduMapOptions.l != null) {
            this.m = baiduMapOptions.l;
        }
        if (baiduMapOptions == null || baiduMapOptions.k == null) {
            return;
        }
        this.l = baiduMapOptions.k;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        this.f = new MapSurfaceView(context);
        if (baiduMapOptions != null) {
            this.g = new BaiduMap(context, this.f, baiduMapOptions.a());
        } else {
            this.g = new BaiduMap(context, this.f, (com.baidu.mapsdkplatform.comapi.map.u) null);
        }
        addView(this.f);
        this.f.getBaseMap().a(new ae(this));
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
            animatorSet.addListener(new ah(this, view));
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
    public void a(String str, int i) {
        if (this.f == null || this.f.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f2891b, "customStyleFilePath is empty or null, please check!");
        } else if (!str.endsWith(".sty")) {
            Log.e(f2891b, "customStyleFile format is incorrect , please check!");
        } else if (new File(str).exists()) {
            this.f.getBaseMap().a(str, i);
        } else {
            Log.e(f2891b, "customStyleFile does not exist , please check!");
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
    public void a(boolean z) {
        if (this.k) {
            a(this.j, z);
        }
    }

    private void b() {
        if (this.f == null || this.v) {
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
        if (this.f != null && this.v) {
            e();
            this.v = false;
        }
    }

    private void c(Context context) {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.i = a2;
        } else {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        }
        if (this.i != null) {
            this.h = new ImageView(context);
            this.h.setImageBitmap(this.i);
            addView(this.h);
        }
    }

    private void d() {
        if (this.f == null) {
            return;
        }
        this.f.onBackground();
    }

    private void d(Context context) {
        this.j = new com.baidu.mapsdkplatform.comapi.map.ab(context, true);
        if (this.j.a()) {
            this.j.b(new af(this));
            this.j.a(new ag(this));
            addView(this.j);
        }
    }

    private void e() {
        if (this.f == null) {
            return;
        }
        this.f.onForeground();
    }

    private void e(Context context) {
        this.n = new RelativeLayout(context);
        this.n.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.p = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.p.setTextColor(Color.parseColor("#FFFFFF"));
        this.p.setTextSize(2, 11.0f);
        this.p.setTypeface(this.p.getTypeface(), 1);
        this.p.setLayoutParams(layoutParams);
        this.p.setId(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        c = str;
    }

    @Deprecated
    public static void setIconCustom(int i) {
        e = i;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        d = i;
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

    public final BaiduMap getMap() {
        this.g.c = this;
        return this.g;
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

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (windowInsets.isRound()) {
            this.f2892a = ScreenShape.ROUND;
        } else {
            this.f2892a = ScreenShape.RECTANGLE;
        }
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
        if (this.w != null) {
            this.f.unInit();
        }
        if (this.i != null && !this.i.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        this.j.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.j.b();
        if (this.mTask != null) {
            this.mTask.cancel();
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
        switch (motionEvent.getAction()) {
            case 0:
                if (this.j.getVisibility() != 0) {
                    if (this.j.getVisibility() == 4) {
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
        a(this.h);
        if (((getWidth() - this.B) - this.C) - this.h.getMeasuredWidth() <= 0 || ((getHeight() - this.D) - this.E) - this.h.getMeasuredHeight() <= 0) {
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
            if (childAt == this.f) {
                this.f.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.h) {
                int i6 = (int) (this.E + (12.0f * f));
                int i7 = 0;
                int i8 = 0;
                if (this.f2892a == ScreenShape.ROUND) {
                    a(this.j);
                    int i9 = s / 2;
                    i8 = a(i9, this.j.getMeasuredWidth() / 2);
                    i7 = ((s / 2) - a(i9, i9 - i8)) + u;
                }
                int i10 = (t - i8) - i6;
                int i11 = s - i7;
                this.h.layout(i11 - this.h.getMeasuredWidth(), i10 - this.h.getMeasuredHeight(), i11, i10);
            } else if (childAt == this.j) {
                if (this.j.a()) {
                    a(this.j);
                    if (this.m == null) {
                        int a2 = (int) ((this.f2892a == ScreenShape.ROUND ? a(t / 2, this.j.getMeasuredWidth() / 2) : 0) + (12.0f * f) + this.D);
                        int measuredWidth = (s - this.j.getMeasuredWidth()) / 2;
                        this.j.layout(measuredWidth, a2, this.j.getMeasuredWidth() + measuredWidth, this.j.getMeasuredHeight() + a2);
                    } else {
                        this.j.layout(this.m.x, this.m.y, this.m.x + this.j.getMeasuredWidth(), this.m.y + this.j.getMeasuredHeight());
                    }
                }
            } else if (childAt == this.n) {
                int i12 = 0;
                int i13 = 0;
                if (this.f2892a == ScreenShape.ROUND) {
                    a(this.j);
                    int i14 = s / 2;
                    i13 = a(i14, this.j.getMeasuredWidth() / 2);
                    i12 = ((s / 2) - a(i14, i14 - i13)) + u;
                }
                a(this.n);
                if (this.l == null) {
                    this.G = this.n.getMeasuredWidth();
                    this.F = this.n.getMeasuredHeight();
                    int i15 = (int) (i12 + this.B + (5.0f * f2));
                    int i16 = (t - ((int) (this.E + (12.0f * f)))) - i13;
                    this.n.layout(i15, i16 - this.n.getMeasuredHeight(), this.G + i15, i16);
                } else {
                    this.n.layout(this.l.x, this.l.y, this.l.x + this.n.getMeasuredWidth(), this.l.y + this.n.getMeasuredHeight());
                }
            } else if (childAt == this.o) {
                a(this.o);
                this.o.layout(0, 0, this.o.getMeasuredWidth(), t);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof MapViewLayoutParams) {
                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                    Point a3 = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f2847b : this.f.getBaseMap().a(CoordUtil.ll2mc(mapViewLayoutParams.f2846a));
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
        if (bundle == null || this.g == null) {
            return;
        }
        bundle.putParcelable("mapstatus", this.g.getMapStatus());
        if (this.l != null) {
            bundle.putParcelable("scalePosition", this.l);
        }
        if (this.m != null) {
            bundle.putParcelable("zoomPosition", this.m);
        }
        bundle.putBoolean("mZoomControlEnabled", this.y);
        bundle.putBoolean("mScaleControlEnabled", this.z);
        bundle.putInt("paddingLeft", this.B);
        bundle.putInt("paddingTop", this.D);
        bundle.putInt("paddingRight", this.C);
        bundle.putInt("paddingBottom", this.E);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.h) {
            return;
        }
        super.removeView(view);
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
        a(str, i);
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.w, customMapStyleId, new ad(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath == null || localCustomStyleFilePath.isEmpty()) {
            return;
        }
        a(localCustomStyleFilePath, 0);
    }

    public void setMapCustomStyleEnable(boolean z) {
    }

    public void setMapCustomStylePath(String str) {
        a(str, 0);
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        if (this.o == null) {
            return;
        }
        this.o.setCallback(onDismissCallback);
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
            this.l = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.f2892a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.k = z;
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
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
