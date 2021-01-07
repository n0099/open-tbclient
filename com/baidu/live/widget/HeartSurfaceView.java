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
import com.baidu.live.aj.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private b bXA;
    private ExecutorService bXB;
    private SurfaceHolder bXn;
    private c[] bXo;
    private volatile boolean bXp;
    private volatile boolean bXq;
    private Bitmap bXr;
    private Bitmap bXs;
    private PointF bXt;
    private PointF bXu;
    private PointF bXv;
    private PointF bXw;
    private volatile int bXx;
    private ArrayList<Bitmap> bXy;
    private boolean bXz;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes11.dex */
    public interface b {
        void P(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface d {
        void aaA();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bXx;
        heartSurfaceView.bXx = i - 1;
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
        this.bXp = false;
        this.bXq = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bXt == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0167a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bXt = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0167a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bXu = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0167a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bXv = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bXw = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0167a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bXn = getHolder();
        this.bXn.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bXo = new c[30];
        this.bXr = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bXs = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bXp = true;
        this.bXq = false;
        this.bXy = new ArrayList<>();
        this.bXy.add(gR(a.b.liveshow_video_heart_like1));
        this.bXy.add(gR(a.b.liveshow_video_heart_like2));
        this.bXy.add(gR(a.b.liveshow_video_heart_like3));
        this.bXy.add(gR(a.b.liveshow_video_heart_like4));
        this.bXy.add(gR(a.b.liveshow_video_heart_like5));
        this.bXy.add(gR(a.b.liveshow_video_heart_like6));
        this.bXy.add(gR(a.b.liveshow_video_heart_like7));
        this.bXy.add(gR(a.b.liveshow_video_heart_like8));
        this.bXy.add(gR(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bXp = true;
        if (this.bXB == null) {
            this.bXB = Executors.newFixedThreadPool(5);
        }
        aay();
        aax();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bXo != null) {
            for (c cVar : this.bXo) {
                if (cVar != null && cVar.isAlive()) {
                    cVar.dE(false);
                }
            }
        }
        this.bXq = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bXq = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bXq = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bXp = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void aax() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bXp) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bXp && HeartSurfaceView.this.bXx > 0) {
                        if (HeartSurfaceView.this.aaz()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bXB != null) {
            this.bXB.execute(runnable);
        }
    }

    private void aay() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bXp) {
                    try {
                        while (HeartSurfaceView.this.bXp && !HeartSurfaceView.this.bXq) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bXp) {
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
        if (this.bXB != null) {
            this.bXB.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bXx < 120) {
            this.bXx += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaz() {
        PointF pointF;
        if (!this.bXq || this.bXv == null || this.bXw == null || this.bXt == null || this.bXu == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bXw.x / 2.0f) * nextFloat) + (this.bXw.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bXv.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bXw.y);
        }
        Bitmap bitmap = this.bXy.get(this.mRandom.nextInt(this.bXy.size()));
        float width = bitmap.getWidth() + ((this.bXu.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bXz) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bXu.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bXz = false;
        }
        return a(bitmap, this.bXt, new PointF(width, this.bXu.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bXo.length; i++) {
            if (this.bXo[i] == null) {
                this.bXo[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bXo[i].bXA = this.bXA;
                return true;
            } else if (!this.bXo[i].isAlive()) {
                this.bXo[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bXt != null && this.bXq && (lockCanvas = this.bXn.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bXo) {
                        if (this.bXp && this.bXq) {
                            if (cVar != null && cVar.isAlive()) {
                                cVar.bC(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bXD, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bXn.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bXn.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bXn.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        public b bXA;
        public RectF bXD;
        private f bXE;
        private g bXF;
        private a bXG;
        private PointF bXt;
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
            this.bXt = pointF;
            this.bXD = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bXD.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bXG = new a(600);
            this.bXG.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void aaA() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.dE(false);
                }
            });
            this.bXE = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bXE.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bXD.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bXD.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void aaA() {
                    c.this.bXG.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bXA != null) {
                        c.this.bXA.P((int) c.this.bXD.left, (int) c.this.bXD.top);
                    }
                }
            });
            this.bXE.start();
            this.bXF = new g(240, 0.75f);
            this.bXF.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bXD.set(c.this.bXt.x, c.this.bXt.y, c.this.bXt.x + (c.this.mWidth * c.this.mScale), c.this.bXt.y + (c.this.mHeight * c.this.mScale));
                    c.this.bXD.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void aaA() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bXF.start();
            dE(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bXt = pointF;
            this.bXD.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bXD.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bXE.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bXE.start();
            this.bXF.start();
            dE(true);
        }

        public boolean isAlive() {
            return this.mIsAlive;
        }

        public synchronized void dE(boolean z) {
            this.mIsAlive = z;
        }

        public void bC(long j) {
            if (this.bXF.isAlive()) {
                this.bXF.bC(j);
            }
            if (this.bXE.isAlive()) {
                this.bXE.bC(j);
            }
            if (this.bXG.isAlive()) {
                this.bXG.bC(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static abstract class e {
        private volatile boolean bXI;
        private d bXJ;
        private volatile boolean bXK = false;
        private long mStartTime;
        private int mTotalDuration;

        protected abstract Object D(float f);

        public e(int i) {
            this.mTotalDuration = i;
        }

        public void gT(int i) {
            this.mTotalDuration = i;
        }

        public boolean isAlive() {
            return this.bXK;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bXI = true;
            this.bXK = true;
        }

        public void a(d dVar) {
            this.bXJ = dVar;
        }

        public void bC(long j) {
            float f = ((float) (j - this.mStartTime)) / this.mTotalDuration;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bXK = false;
                if (this.bXJ != null) {
                    this.bXJ.onUpdate(D(f2));
                    this.bXJ.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bXI = true;
            } else if (this.bXI) {
                if (this.bXJ != null) {
                    this.bXJ.aaA();
                }
                this.bXI = false;
            }
            if (this.bXJ != null) {
                this.bXJ.onUpdate(D(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends e {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
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
    /* loaded from: classes11.dex */
    public static class g extends e {
        private float bXO;
        private float bXP;
        private float bXQ;

        public g(int i, float f) {
            super(i);
            this.bXO = 0.3f;
            this.bXP = 1.0f;
            this.bXQ = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            float f2 = 1.0f;
            if (f < this.bXQ) {
                f2 = (((this.bXP - this.bXO) / this.bXQ) * f) + this.bXO;
            } else {
                float f3 = (((-this.bXP) / this.bXQ) * f) + (2.0f * this.bXP);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class f extends e {
        private static float bXN = 0.0f;
        private PointF bXL;
        private PointF bXM;
        private PointF bXt;
        private PointF bXu;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bXt = pointF;
            this.bXu = pointF2;
            this.bXL = pointF3;
            this.bXM = E(bXN);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            gT(i);
            this.bXt = pointF;
            this.bXu = pointF2;
            this.bXL = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            if (f < bXN) {
                return E(f);
            }
            return a((f - bXN) / (1.0f - bXN), this.bXM, this.bXL, this.bXu);
        }

        public PointF E(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bXt.x;
            pointF.y = (1.0f - f) * this.bXt.y;
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
        return this.bXA;
    }

    public void setAnimateEndListener(b bVar) {
        this.bXA = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bXz = z;
    }

    private Bitmap gR(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap gS(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bXy = new ArrayList<>();
        this.bXy.add(gS(a.b.liveshow_video_heart_like1));
        this.bXy.add(gS(a.b.liveshow_video_heart_like2));
        this.bXy.add(gS(a.b.liveshow_video_heart_like3));
        this.bXy.add(gS(a.b.liveshow_video_heart_like4));
        this.bXy.add(gS(a.b.liveshow_video_heart_like5));
        this.bXy.add(gS(a.b.liveshow_video_heart_like6));
        this.bXy.add(gS(a.b.liveshow_video_heart_like7));
        this.bXy.add(gS(a.b.liveshow_video_heart_like8));
        this.bXy.add(gS(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bXB != null) {
            this.bXB.shutdown();
            this.bXB = null;
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
