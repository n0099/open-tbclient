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
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.aa.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder byZ;
    private c[] bza;
    private volatile boolean bzb;
    private volatile boolean bzc;
    private Bitmap bzd;
    private Bitmap bze;
    private PointF bzf;
    private PointF bzg;
    private PointF bzh;
    private PointF bzi;
    private volatile int bzj;
    private ArrayList<Bitmap> bzk;
    private boolean bzl;
    private b bzm;
    private ExecutorService bzn;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void Q(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface d {
        void RR();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bzj;
        heartSurfaceView.bzj = i - 1;
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
        this.bzb = false;
        this.bzc = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bzf == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0164a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bzf = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0164a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bzg = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0164a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bzh = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bzi = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0164a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.byZ = getHolder();
        this.byZ.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bza = new c[30];
        this.bzd = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bze = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bzb = true;
        this.bzc = false;
        this.bzk = new ArrayList<>();
        this.bzk.add(fK(a.b.liveshow_video_heart_like1));
        this.bzk.add(fK(a.b.liveshow_video_heart_like2));
        this.bzk.add(fK(a.b.liveshow_video_heart_like3));
        this.bzk.add(fK(a.b.liveshow_video_heart_like4));
        this.bzk.add(fK(a.b.liveshow_video_heart_like5));
        this.bzk.add(fK(a.b.liveshow_video_heart_like6));
        this.bzk.add(fK(a.b.liveshow_video_heart_like7));
        this.bzk.add(fK(a.b.liveshow_video_heart_like8));
        this.bzk.add(fK(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bzb = true;
        if (this.bzn == null) {
            this.bzn = Executors.newFixedThreadPool(5);
        }
        RO();
        RN();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bza != null) {
            for (c cVar : this.bza) {
                if (cVar != null && cVar.RQ()) {
                    cVar.cO(false);
                }
            }
        }
        this.bzc = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bzc = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bzc = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bzb = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void RN() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bzb) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bzb && HeartSurfaceView.this.bzj > 0) {
                        if (HeartSurfaceView.this.RP()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bzn != null) {
            this.bzn.execute(runnable);
        }
    }

    private void RO() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bzb) {
                    try {
                        while (HeartSurfaceView.this.bzb && !HeartSurfaceView.this.bzc) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bzb) {
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
        if (this.bzn != null) {
            this.bzn.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bzj < 120) {
            this.bzj += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RP() {
        PointF pointF;
        if (!this.bzc || this.bzh == null || this.bzi == null || this.bzf == null || this.bzg == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bzi.x / 2.0f) * nextFloat) + (this.bzi.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bzh.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bzi.y);
        }
        Bitmap bitmap = this.bzk.get(this.mRandom.nextInt(this.bzk.size()));
        float width = bitmap.getWidth() + ((this.bzg.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bzl) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bzg.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bzl = false;
        }
        return a(bitmap, this.bzf, new PointF(width, this.bzg.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bza.length; i++) {
            if (this.bza[i] == null) {
                this.bza[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bza[i].bzm = this.bzm;
                return true;
            } else if (!this.bza[i].RQ()) {
                this.bza[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bzf != null && this.bzc && (lockCanvas = this.byZ.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bza) {
                        if (this.bzb && this.bzc) {
                            if (cVar != null && cVar.RQ()) {
                                cVar.aE(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bzp, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.byZ.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.byZ.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.byZ.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        public Bitmap bitmap;
        private PointF bzf;
        public b bzm;
        public RectF bzp;
        private f bzq;
        private g bzr;
        private a bzs;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bzf = pointF;
            this.bzp = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bzp.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bzs = new a(600);
            this.bzs.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void RR() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.cO(false);
                }
            });
            this.bzq = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bzq.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bzp.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bzp.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void RR() {
                    c.this.bzs.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bzm != null) {
                        c.this.bzm.Q((int) c.this.bzp.left, (int) c.this.bzp.top);
                    }
                }
            });
            this.bzq.start();
            this.bzr = new g(240, 0.75f);
            this.bzr.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bzp.set(c.this.bzf.x, c.this.bzf.y, c.this.bzf.x + (c.this.mWidth * c.this.mScale), c.this.bzf.y + (c.this.mHeight * c.this.mScale));
                    c.this.bzp.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void RR() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bzr.start();
            cO(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bzf = pointF;
            this.bzp.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bzp.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bzq.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bzq.start();
            this.bzr.start();
            cO(true);
        }

        public boolean RQ() {
            return this.mIsAlive;
        }

        public synchronized void cO(boolean z) {
            this.mIsAlive = z;
        }

        public void aE(long j) {
            if (this.bzr.RQ()) {
                this.bzr.aE(j);
            }
            if (this.bzq.RQ()) {
                this.bzq.aE(j);
            }
            if (this.bzs.RQ()) {
                this.bzs.aE(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class e {
        private int bzu;
        private volatile boolean bzv;
        private d bzw;
        private volatile boolean bzx = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bzu = i;
        }

        public void fM(int i) {
            this.bzu = i;
        }

        public boolean RQ() {
            return this.bzx;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bzv = true;
            this.bzx = true;
        }

        public void a(d dVar) {
            this.bzw = dVar;
        }

        public void aE(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bzu;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bzx = false;
                if (this.bzw != null) {
                    this.bzw.onUpdate(getValue(f2));
                    this.bzw.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bzv = true;
            } else if (this.bzv) {
                if (this.bzw != null) {
                    this.bzw.RR();
                }
                this.bzv = false;
            }
            if (this.bzw != null) {
                this.bzw.onUpdate(getValue(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends e {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
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
    /* loaded from: classes4.dex */
    public static class g extends e {
        private float bzB;
        private float bzC;
        private float bzD;

        public g(int i, float f) {
            super(i);
            this.bzB = 0.3f;
            this.bzC = 1.0f;
            this.bzD = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bzD) {
                f2 = (((this.bzC - this.bzB) / this.bzD) * f) + this.bzB;
            } else {
                float f3 = (((-this.bzC) / this.bzD) * f) + (2.0f * this.bzC);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends e {
        private static float bzA = 0.0f;
        private PointF bzf;
        private PointF bzg;
        private PointF bzy;
        private PointF bzz;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bzf = pointF;
            this.bzg = pointF2;
            this.bzy = pointF3;
            this.bzz = A(bzA);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            fM(i);
            this.bzf = pointF;
            this.bzg = pointF2;
            this.bzy = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bzA) {
                return A(f);
            }
            return a((f - bzA) / (1.0f - bzA), this.bzz, this.bzy, this.bzg);
        }

        public PointF A(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bzf.x;
            pointF.y = (1.0f - f) * this.bzf.y;
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
        return this.bzm;
    }

    public void setAnimateEndListener(b bVar) {
        this.bzm = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bzl = z;
    }

    private Bitmap fK(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap fL(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bzk = new ArrayList<>();
        this.bzk.add(fL(a.b.liveshow_video_heart_like1));
        this.bzk.add(fL(a.b.liveshow_video_heart_like2));
        this.bzk.add(fL(a.b.liveshow_video_heart_like3));
        this.bzk.add(fL(a.b.liveshow_video_heart_like4));
        this.bzk.add(fL(a.b.liveshow_video_heart_like5));
        this.bzk.add(fL(a.b.liveshow_video_heart_like6));
        this.bzk.add(fL(a.b.liveshow_video_heart_like7));
        this.bzk.add(fL(a.b.liveshow_video_heart_like8));
        this.bzk.add(fL(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bzn != null) {
            this.bzn.shutdown();
            this.bzn = null;
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return drawableToBitmap(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public static Bitmap drawableToBitmap(Drawable drawable, int i, int i2) {
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
