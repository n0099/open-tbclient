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
import com.baidu.live.ae.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private c[] bMA;
    private volatile boolean bMB;
    private volatile boolean bMC;
    private Bitmap bMD;
    private Bitmap bME;
    private PointF bMF;
    private PointF bMG;
    private PointF bMH;
    private PointF bMI;
    private volatile int bMJ;
    private ArrayList<Bitmap> bMK;
    private boolean bML;
    private b bMM;
    private ExecutorService bMN;
    private SurfaceHolder bMz;
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
        void WM();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bMJ;
        heartSurfaceView.bMJ = i - 1;
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
        this.bMB = false;
        this.bMC = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bMF == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0169a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bMF = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0169a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bMG = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0169a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bMH = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bMI = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0169a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bMz = getHolder();
        this.bMz.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bMA = new c[30];
        this.bMD = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bME = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bMB = true;
        this.bMC = false;
        this.bMK = new ArrayList<>();
        this.bMK.add(gs(a.b.liveshow_video_heart_like1));
        this.bMK.add(gs(a.b.liveshow_video_heart_like2));
        this.bMK.add(gs(a.b.liveshow_video_heart_like3));
        this.bMK.add(gs(a.b.liveshow_video_heart_like4));
        this.bMK.add(gs(a.b.liveshow_video_heart_like5));
        this.bMK.add(gs(a.b.liveshow_video_heart_like6));
        this.bMK.add(gs(a.b.liveshow_video_heart_like7));
        this.bMK.add(gs(a.b.liveshow_video_heart_like8));
        this.bMK.add(gs(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bMB = true;
        if (this.bMN == null) {
            this.bMN = Executors.newFixedThreadPool(5);
        }
        WJ();
        WI();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bMA != null) {
            for (c cVar : this.bMA) {
                if (cVar != null && cVar.WL()) {
                    cVar.dn(false);
                }
            }
        }
        this.bMC = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bMC = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bMC = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bMB = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void WI() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bMB) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bMB && HeartSurfaceView.this.bMJ > 0) {
                        if (HeartSurfaceView.this.WK()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bMN != null) {
            this.bMN.execute(runnable);
        }
    }

    private void WJ() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bMB) {
                    try {
                        while (HeartSurfaceView.this.bMB && !HeartSurfaceView.this.bMC) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bMB) {
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
        if (this.bMN != null) {
            this.bMN.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bMJ < 120) {
            this.bMJ += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WK() {
        PointF pointF;
        if (!this.bMC || this.bMH == null || this.bMI == null || this.bMF == null || this.bMG == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bMI.x / 2.0f) * nextFloat) + (this.bMI.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bMH.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bMI.y);
        }
        Bitmap bitmap = this.bMK.get(this.mRandom.nextInt(this.bMK.size()));
        float width = bitmap.getWidth() + ((this.bMG.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bML) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bMG.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bML = false;
        }
        return a(bitmap, this.bMF, new PointF(width, this.bMG.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bMA.length; i++) {
            if (this.bMA[i] == null) {
                this.bMA[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bMA[i].bMM = this.bMM;
                return true;
            } else if (!this.bMA[i].WL()) {
                this.bMA[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bMF != null && this.bMC && (lockCanvas = this.bMz.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bMA) {
                        if (this.bMB && this.bMC) {
                            if (cVar != null && cVar.WL()) {
                                cVar.be(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bMP, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bMz.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bMz.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bMz.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private PointF bMF;
        public b bMM;
        public RectF bMP;
        private f bMQ;
        private g bMR;
        private a bMS;
        public Bitmap bitmap;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bMF = pointF;
            this.bMP = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bMP.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bMS = new a(600);
            this.bMS.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void WM() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.dn(false);
                }
            });
            this.bMQ = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bMQ.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bMP.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bMP.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void WM() {
                    c.this.bMS.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bMM != null) {
                        c.this.bMM.Q((int) c.this.bMP.left, (int) c.this.bMP.top);
                    }
                }
            });
            this.bMQ.start();
            this.bMR = new g(240, 0.75f);
            this.bMR.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bMP.set(c.this.bMF.x, c.this.bMF.y, c.this.bMF.x + (c.this.mWidth * c.this.mScale), c.this.bMF.y + (c.this.mHeight * c.this.mScale));
                    c.this.bMP.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void WM() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bMR.start();
            dn(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bMF = pointF;
            this.bMP.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bMP.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bMQ.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bMQ.start();
            this.bMR.start();
            dn(true);
        }

        public boolean WL() {
            return this.mIsAlive;
        }

        public synchronized void dn(boolean z) {
            this.mIsAlive = z;
        }

        public void be(long j) {
            if (this.bMR.WL()) {
                this.bMR.be(j);
            }
            if (this.bMQ.WL()) {
                this.bMQ.be(j);
            }
            if (this.bMS.WL()) {
                this.bMS.be(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class e {
        private int bMU;
        private volatile boolean bMV;
        private d bMW;
        private volatile boolean bMX = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bMU = i;
        }

        public void gu(int i) {
            this.bMU = i;
        }

        public boolean WL() {
            return this.bMX;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bMV = true;
            this.bMX = true;
        }

        public void a(d dVar) {
            this.bMW = dVar;
        }

        public void be(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bMU;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bMX = false;
                if (this.bMW != null) {
                    this.bMW.onUpdate(getValue(f2));
                    this.bMW.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bMV = true;
            } else if (this.bMV) {
                if (this.bMW != null) {
                    this.bMW.WM();
                }
                this.bMV = false;
            }
            if (this.bMW != null) {
                this.bMW.onUpdate(getValue(f2));
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
        private float bNb;
        private float bNc;
        private float bNd;

        public g(int i, float f) {
            super(i);
            this.bNb = 0.3f;
            this.bNc = 1.0f;
            this.bNd = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bNd) {
                f2 = (((this.bNc - this.bNb) / this.bNd) * f) + this.bNb;
            } else {
                float f3 = (((-this.bNc) / this.bNd) * f) + (2.0f * this.bNc);
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
        private static float bNa = 0.0f;
        private PointF bMF;
        private PointF bMG;
        private PointF bMY;
        private PointF bMZ;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bMF = pointF;
            this.bMG = pointF2;
            this.bMY = pointF3;
            this.bMZ = E(bNa);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            gu(i);
            this.bMF = pointF;
            this.bMG = pointF2;
            this.bMY = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bNa) {
                return E(f);
            }
            return a((f - bNa) / (1.0f - bNa), this.bMZ, this.bMY, this.bMG);
        }

        public PointF E(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bMF.x;
            pointF.y = (1.0f - f) * this.bMF.y;
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
        return this.bMM;
    }

    public void setAnimateEndListener(b bVar) {
        this.bMM = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bML = z;
    }

    private Bitmap gs(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap gt(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bMK = new ArrayList<>();
        this.bMK.add(gt(a.b.liveshow_video_heart_like1));
        this.bMK.add(gt(a.b.liveshow_video_heart_like2));
        this.bMK.add(gt(a.b.liveshow_video_heart_like3));
        this.bMK.add(gt(a.b.liveshow_video_heart_like4));
        this.bMK.add(gt(a.b.liveshow_video_heart_like5));
        this.bMK.add(gt(a.b.liveshow_video_heart_like6));
        this.bMK.add(gt(a.b.liveshow_video_heart_like7));
        this.bMK.add(gt(a.b.liveshow_video_heart_like8));
        this.bMK.add(gt(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bMN != null) {
            this.bMN.shutdown();
            this.bMN = null;
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
