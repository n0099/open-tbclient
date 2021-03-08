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
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.live.ah.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public class HeartSurfaceView2 extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView2.class.getSimpleName();
    private c[] bYF;
    private List<Pair<PointF, PointF>> bYG;
    private b bYH;
    private SurfaceHolder bYd;
    private volatile boolean bYf;
    private volatile boolean bYg;
    private PointF bYj;
    private PointF bYk;
    private volatile int bYl;
    private ArrayList<Bitmap> bYm;
    private boolean bYn;
    private ExecutorService bYp;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes10.dex */
    public interface b {
        void P(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface d {
        void YA();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView2 heartSurfaceView2) {
        int i = heartSurfaceView2.bYl;
        heartSurfaceView2.bYl = i - 1;
        return i;
    }

    public HeartSurfaceView2(Context context) {
        this(context, null, 0);
    }

    public HeartSurfaceView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeartSurfaceView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bYf = false;
        this.bYg = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView2.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView2.this.bYG == null || HeartSurfaceView2.this.mViewWidth != HeartSurfaceView2.this.getWidth() || HeartSurfaceView2.this.mViewHeight != HeartSurfaceView2.this.getHeight()) {
                    HeartSurfaceView2.this.mViewWidth = HeartSurfaceView2.this.getWidth();
                    HeartSurfaceView2.this.mViewHeight = HeartSurfaceView2.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView2.this.getResources().getDimensionPixelSize(a.C0163a.liveshow_heart_start_x);
                    float dimensionPixelSize2 = HeartSurfaceView2.this.getResources().getDimensionPixelSize(a.C0163a.liveshow_heart_start_x1);
                    float dimensionPixelSize3 = HeartSurfaceView2.this.getResources().getDimensionPixelSize(a.C0163a.liveshow_heart_padding_bottom);
                    float dimensionPixelSize4 = HeartSurfaceView2.this.getResources().getDimensionPixelSize(a.C0163a.liveshow_heart_padding_top);
                    PointF pointF = new PointF(dimensionPixelSize, HeartSurfaceView2.this.mViewHeight - dimensionPixelSize3);
                    PointF pointF2 = new PointF(dimensionPixelSize, dimensionPixelSize4);
                    PointF pointF3 = new PointF(dimensionPixelSize2, HeartSurfaceView2.this.mViewHeight - dimensionPixelSize3);
                    PointF pointF4 = new PointF(dimensionPixelSize2, dimensionPixelSize4);
                    HeartSurfaceView2.this.bYG = new ArrayList();
                    HeartSurfaceView2.this.bYG.add(Pair.create(pointF, pointF2));
                    HeartSurfaceView2.this.bYG.add(Pair.create(pointF3, pointF4));
                    HeartSurfaceView2.this.bYj = new PointF(0.0f, HeartSurfaceView2.this.mViewHeight * 0.5f);
                    HeartSurfaceView2.this.bYk = new PointF(HeartSurfaceView2.this.mViewWidth + HeartSurfaceView2.this.getResources().getDimensionPixelSize(a.C0163a.liveshow_heart_padding_right), HeartSurfaceView2.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bYd = getHolder();
        this.bYd.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bYF = new c[30];
        this.mRandom = new Random();
        this.bYf = true;
        this.bYg = false;
        this.bYm = new ArrayList<>();
        this.bYm.add(fr(a.b.liveshow_video_heart_like1));
        this.bYm.add(fr(a.b.liveshow_video_heart_like2));
        this.bYm.add(fr(a.b.liveshow_video_heart_like3));
        this.bYm.add(fr(a.b.liveshow_video_heart_like4));
        this.bYm.add(fr(a.b.liveshow_video_heart_like5));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bYf = true;
        if (this.bYp == null) {
            this.bYp = Executors.newFixedThreadPool(5);
        }
        Yy();
        Yx();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bYF != null) {
            for (c cVar : this.bYF) {
                if (cVar != null && cVar.isAlive()) {
                    cVar.dI(false);
                }
            }
        }
        this.bYg = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bYg = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bYg = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bYf = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void Yx() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView2.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView2.this.bYf) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView2.this.bYf && HeartSurfaceView2.this.bYl > 0) {
                        if (HeartSurfaceView2.this.Yz()) {
                            HeartSurfaceView2.g(HeartSurfaceView2.this);
                        }
                        SystemClock.sleep(120L);
                    }
                }
            }
        };
        if (this.bYp != null) {
            this.bYp.execute(runnable);
        }
    }

    private void Yy() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView2.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView2.this.bYf) {
                    try {
                        while (HeartSurfaceView2.this.bYf && !HeartSurfaceView2.this.bYg) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView2.this.bYf) {
                            long currentTimeMillis = System.currentTimeMillis();
                            HeartSurfaceView2.this.draw();
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
        if (this.bYp != null) {
            this.bYp.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bYl < 120) {
            this.bYl += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yz() {
        PointF pointF;
        if (!this.bYg || this.bYj == null || this.bYk == null || this.bYG == null) {
            return false;
        }
        Pair<PointF, PointF> pair = this.bYG.get(this.mRandom.nextInt(this.bYG.size()));
        PointF pointF2 = (PointF) pair.first;
        PointF pointF3 = (PointF) pair.second;
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bYk.x / 2.0f) * nextFloat) + (this.bYk.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bYj.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bYk.y);
        }
        return a(this.bYm.get(this.mRandom.nextInt(this.bYm.size())), pointF2, pointF3, pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bYF.length; i++) {
            if (this.bYF[i] == null) {
                this.bYF[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bYF[i].bYH = this.bYH;
                return true;
            } else if (!this.bYF[i].isAlive()) {
                this.bYF[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bYG != null && this.bYg && (lockCanvas = this.bYd.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bYF) {
                        if (this.bYf && this.bYg) {
                            if (cVar != null && cVar.isAlive()) {
                                cVar.bG(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bYr, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bYd.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bYd.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bYd.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        public b bYH;
        private f bYJ;
        private g bYK;
        private a bYL;
        private PointF bYh;
        public RectF bYr;
        public Bitmap bitmap;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 128;
        private float mScale = 0.28f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bYh = pointF;
            this.bYr = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bYr.offset((-this.mWidth) / 2.0f, (-this.mHeight) / 2.0f);
            this.bYL = new a(1500);
            this.bYL.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView2.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void YA() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void onOver() {
                    c.this.dI(false);
                }
            });
            this.bYL.start();
            this.bYJ = new f(pointF, pointF2, pointF3, 1500);
            this.bYJ.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView2.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bYr.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bYr.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void YA() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void onOver() {
                    if (c.this.bYH != null) {
                        c.this.bYH.P((int) c.this.bYr.left, (int) c.this.bYr.top);
                    }
                }
            });
            this.bYJ.start();
            this.bYK = new g(300, 1.0f);
            this.bYK.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView2.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bYr.set(c.this.bYh.x, c.this.bYh.y, c.this.bYh.x + (c.this.mWidth * c.this.mScale), c.this.bYh.y + (c.this.mHeight * c.this.mScale));
                    c.this.bYr.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void YA() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView2.d
                public void onOver() {
                }
            });
            this.bYK.start();
            dI(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 128;
            this.mScale = 0.28f;
            this.bYh = pointF;
            this.bYr.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bYr.offset((-this.mWidth) / 2.0f, (-this.mHeight) / 2.0f);
            this.bYJ.a(pointF, pointF2, pointF3, 1500);
            this.bYJ.start();
            this.bYK.start();
            this.bYL.start();
            dI(true);
        }

        public boolean isAlive() {
            return this.mIsAlive;
        }

        public synchronized void dI(boolean z) {
            this.mIsAlive = z;
        }

        public void bG(long j) {
            if (this.bYK.isAlive()) {
                this.bYK.bG(j);
            }
            if (this.bYJ.isAlive()) {
                this.bYJ.bG(j);
            }
            if (this.bYL.isAlive()) {
                this.bYL.bG(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static abstract class e {
        private d bYN;
        private volatile boolean bYw;
        private volatile boolean bYy = false;
        private long mStartTime;
        private int mTotalDuration;

        protected abstract Object H(float f);

        public e(int i) {
            this.mTotalDuration = i;
        }

        public void ft(int i) {
            this.mTotalDuration = i;
        }

        public boolean isAlive() {
            return this.bYy;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bYw = true;
            this.bYy = true;
        }

        public void a(d dVar) {
            this.bYN = dVar;
        }

        public void bG(long j) {
            float f = ((float) (j - this.mStartTime)) / this.mTotalDuration;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bYy = false;
                if (this.bYN != null) {
                    this.bYN.onUpdate(H(f2));
                    this.bYN.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bYw = true;
            } else if (this.bYw) {
                if (this.bYN != null) {
                    this.bYN.YA();
                }
                this.bYw = false;
            }
            if (this.bYN != null) {
                this.bYN.onUpdate(H(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends e {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.live.widget.HeartSurfaceView2.e
        protected Object H(float f) {
            float f2;
            if (f < 0.22f) {
                f2 = 0.5f + f;
            } else if (f < 0.88f) {
                f2 = 0.7f + (0.2f * (f - 0.22f));
            } else if (f < 1.0f) {
                f2 = 0.85f - (7.0f * (f - 0.88f));
            } else {
                f2 = 0.0f;
            }
            return Integer.valueOf((int) (f2 * 255.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class g extends e {
        private float bYC;
        private float bYD;
        private float bYE;

        public g(int i, float f) {
            super(i);
            this.bYC = 0.28f;
            this.bYD = 1.0f;
            this.bYE = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView2.e
        protected Object H(float f) {
            float f2 = 1.0f;
            if (f < this.bYE) {
                f2 = (((this.bYD - this.bYC) / this.bYE) * f) + this.bYC;
            } else {
                float f3 = (((-this.bYD) / this.bYE) * f) + (2.0f * this.bYD);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class f extends e {
        private static float bYB = 1.0f;
        private PointF bYA;
        private PointF bYh;
        private PointF bYi;
        private PointF bYz;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bYh = pointF;
            this.bYi = pointF2;
            this.bYz = pointF3;
            this.bYA = a(bYB, this.bYh, this.bYi);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            ft(i);
            this.bYh = pointF;
            this.bYi = pointF2;
            this.bYz = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView2.e
        protected Object H(float f) {
            if (bYB < 1.0f) {
                if (f < bYB) {
                    return J(f);
                }
                return a((f - bYB) / (1.0f - bYB), this.bYA, this.bYz, this.bYi);
            }
            return a(f, this.bYh, this.bYi);
        }

        public PointF a(float f, PointF pointF, PointF pointF2) {
            PointF pointF3 = new PointF();
            pointF3.x = pointF.x + ((pointF2.x - pointF.x) * f);
            pointF3.y = pointF.y + ((pointF2.y - pointF.y) * f);
            return pointF3;
        }

        public PointF J(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bYh.x;
            pointF.y = (1.0f - f) * this.bYh.y;
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
        return this.bYH;
    }

    public void setAnimateEndListener(b bVar) {
        this.bYH = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bYn = z;
    }

    private Bitmap fr(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap fs(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bYm = new ArrayList<>();
        this.bYm.add(fs(a.b.liveshow_video_heart_like1));
        this.bYm.add(fs(a.b.liveshow_video_heart_like2));
        this.bYm.add(fs(a.b.liveshow_video_heart_like3));
        this.bYm.add(fs(a.b.liveshow_video_heart_like4));
        this.bYm.add(fs(a.b.liveshow_video_heart_like5));
    }

    public void release() {
        if (this.bYp != null) {
            this.bYp.shutdown();
            this.bYp = null;
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
