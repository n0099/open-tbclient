package com.baidu.live.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.live.n.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder aua;
    private c[] aub;
    private volatile boolean auc;
    private volatile boolean aud;
    private Bitmap aue;
    private Bitmap auf;
    private PointF aug;
    private PointF auh;
    private PointF aui;
    private PointF auj;
    private volatile int auk;
    private ArrayList<Bitmap> aul;
    private boolean aum;
    private b aun;
    private ExecutorService auo;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    public interface b {
        void C(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface d {
        void A(Object obj);

        void onOver();

        void wT();
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.auk;
        heartSurfaceView.auk = i - 1;
        return i;
    }

    public HeartSurfaceView(Context context) {
        this(context, null, 0);
    }

    public HeartSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeartSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auc = false;
        this.aud = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.aug == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_start_x);
                    HeartSurfaceView.this.aug = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.auh = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.aui = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.auj = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.aua = getHolder();
        this.aua.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aub = new c[30];
        this.aue = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.auf = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.auc = true;
        this.aud = false;
        this.aul = new ArrayList<>();
        this.aul.add(ct(a.b.liveshow_video_heart_like1));
        this.aul.add(ct(a.b.liveshow_video_heart_like2));
        this.aul.add(ct(a.b.liveshow_video_heart_like3));
        this.aul.add(ct(a.b.liveshow_video_heart_like4));
        this.aul.add(ct(a.b.liveshow_video_heart_like5));
        this.aul.add(ct(a.b.liveshow_video_heart_like6));
        this.aul.add(ct(a.b.liveshow_video_heart_like7));
        this.aul.add(ct(a.b.liveshow_video_heart_like8));
        this.aul.add(ct(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.auc = true;
        if (this.auo == null) {
            this.auo = Executors.newFixedThreadPool(5);
        }
        wQ();
        wP();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.aub != null) {
            for (c cVar : this.aub) {
                if (cVar != null && cVar.wS()) {
                    cVar.aW(false);
                }
            }
        }
        this.aud = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aud = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.aud = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.auc = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void wP() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.auc) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.auc && HeartSurfaceView.this.auk > 0) {
                        if (HeartSurfaceView.this.wR()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.auo != null) {
            this.auo.execute(runnable);
        }
    }

    private void wQ() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.auc) {
                    try {
                        while (HeartSurfaceView.this.auc && !HeartSurfaceView.this.aud) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.auc) {
                            long currentTimeMillis = System.currentTimeMillis();
                            HeartSurfaceView.this.draw();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (currentTimeMillis2 - currentTimeMillis < 30) {
                                try {
                                    Thread.sleep(Math.max(30 - (currentTimeMillis2 - currentTimeMillis), 0L));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else {
                            return;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
            }
        };
        if (this.auo != null) {
            this.auo.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.auk < 120) {
            this.auk += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wR() {
        PointF pointF;
        if (!this.aud || this.aui == null || this.auj == null || this.aug == null || this.auh == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.auj.x / 2.0f) * nextFloat) + (this.auj.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aui.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.auj.y);
        }
        Bitmap bitmap = this.aul.get(this.mRandom.nextInt(this.aul.size()));
        float width = bitmap.getWidth() + ((this.auh.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.aum) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.auh.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.aum = false;
        }
        return a(bitmap, this.aug, new PointF(width, this.auh.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.aub.length; i++) {
            if (this.aub[i] == null) {
                this.aub[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.aub[i].aun = this.aun;
                return true;
            } else if (!this.aub[i].wS()) {
                this.aub[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.aug != null && this.aud && (lockCanvas = this.aua.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.aub) {
                        if (this.auc && this.aud) {
                            if (cVar != null && cVar.wS()) {
                                cVar.K(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.auq, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.aua.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.aua.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.aua.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {
        private PointF aug;
        public b aun;
        public RectF auq;
        private f aur;
        private g aus;
        private a aut;
        private volatile boolean auu;
        public Bitmap bitmap;
        private int mHeight;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.aug = pointF;
            this.auq = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.auq.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aut = new a(600);
            this.aut.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void A(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void wT() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.aW(false);
                }
            });
            this.aur = new f(pointF, pointF2, pointF3, 1200);
            this.aur.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void A(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.auq.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.auq.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void wT() {
                    c.this.aut.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.aun != null) {
                        c.this.aun.C((int) c.this.auq.left, (int) c.this.auq.top);
                    }
                }
            });
            this.aur.start();
            this.aus = new g(240, 0.75f);
            this.aus.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void A(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.auq.set(c.this.aug.x, c.this.aug.y, c.this.aug.x + (c.this.mWidth * c.this.mScale), c.this.aug.y + (c.this.mHeight * c.this.mScale));
                    c.this.auq.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void wT() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aus.start();
            aW(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.aug = pointF;
            this.auq.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.auq.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aur.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.aur.start();
            this.aus.start();
            aW(true);
        }

        public boolean wS() {
            return this.auu;
        }

        public synchronized void aW(boolean z) {
            this.auu = z;
        }

        public void K(long j) {
            if (this.aus.wS()) {
                this.aus.K(j);
            }
            if (this.aur.wS()) {
                this.aur.K(j);
            }
            if (this.aut.wS()) {
                this.aut.K(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static abstract class e {
        private int auw;
        private volatile boolean aux;
        private d auy;
        private volatile boolean auz = false;
        private long mStartTime;

        protected abstract Object L(float f);

        public e(int i) {
            this.auw = i;
        }

        public void cv(int i) {
            this.auw = i;
        }

        public boolean wS() {
            return this.auz;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.aux = true;
            this.auz = true;
        }

        public void a(d dVar) {
            this.auy = dVar;
        }

        public void K(long j) {
            float f = ((float) (j - this.mStartTime)) / this.auw;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.auz = false;
                if (this.auy != null) {
                    this.auy.A(L(f2));
                    this.auy.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.aux = true;
            } else if (this.aux) {
                if (this.auy != null) {
                    this.auy.wT();
                }
                this.aux = false;
            }
            if (this.auy != null) {
                this.auy.A(L(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends e {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object L(float f) {
            float f2;
            if (f < 0.8f) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            return Integer.valueOf((int) (f2 * 255.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class g extends e {
        private float auD;
        private float auE;
        private float auF;

        public g(int i, float f) {
            super(i);
            this.auD = 0.3f;
            this.auE = 1.0f;
            this.auF = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object L(float f) {
            float f2 = 1.0f;
            if (f < this.auF) {
                f2 = (((this.auE - this.auD) / this.auF) * f) + this.auD;
            } else {
                float f3 = (((-this.auE) / this.auF) * f) + (2.0f * this.auE);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class f extends e {
        private static float auC = 0.0f;
        private PointF auA;
        private PointF auB;
        private PointF aug;
        private PointF auh;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.aug = pointF;
            this.auh = pointF2;
            this.auA = pointF3;
            this.auB = M(auC);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            cv(i);
            this.aug = pointF;
            this.auh = pointF2;
            this.auA = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object L(float f) {
            if (f < auC) {
                return M(f);
            }
            return a((f - auC) / (1.0f - auC), this.auB, this.auA, this.auh);
        }

        public PointF M(float f) {
            PointF pointF = new PointF();
            pointF.x = this.aug.x;
            pointF.y = (1.0f - f) * this.aug.y;
            return pointF;
        }

        private PointF a(float f, PointF pointF, PointF pointF2, PointF pointF3) {
            float f2 = 1.0f - f;
            float f3 = f * f;
            float f4 = f2 * f2;
            PointF pointF4 = new PointF();
            pointF4.x = (pointF.x * f4) + (2.0f * f * f2 * pointF2.x) + (pointF3.x * f3);
            pointF4.y = (f2 * 2.0f * f * pointF2.y) + (f4 * pointF.y) + (f3 * pointF3.y);
            return pointF4;
        }
    }

    public b getAnimateEndListener() {
        return this.aun;
    }

    public void setAnimateEndListener(b bVar) {
        this.aun = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.aum = z;
    }

    private Bitmap ct(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap cu(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.aul = new ArrayList<>();
        this.aul.add(cu(a.b.liveshow_video_heart_like1));
        this.aul.add(cu(a.b.liveshow_video_heart_like2));
        this.aul.add(cu(a.b.liveshow_video_heart_like3));
        this.aul.add(cu(a.b.liveshow_video_heart_like4));
        this.aul.add(cu(a.b.liveshow_video_heart_like5));
        this.aul.add(cu(a.b.liveshow_video_heart_like6));
        this.aul.add(cu(a.b.liveshow_video_heart_like7));
        this.aul.add(cu(a.b.liveshow_video_heart_like8));
        this.aul.add(cu(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.auo != null) {
            this.auo.shutdown();
            this.auo = null;
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return a(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public static Bitmap a(Drawable drawable, int i, int i2) {
        Bitmap bitmap = null;
        if (drawable != null && i > 0 && i2 > 0) {
            try {
                bitmap = Bitmap.createBitmap(i, i2, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                if (bitmap != null) {
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, i, i2);
                    drawable.draw(canvas);
                }
            } catch (Exception | OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return bitmap;
    }
}
