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
import com.baidu.live.z.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder bvA;
    private c[] bvB;
    private volatile boolean bvC;
    private volatile boolean bvD;
    private Bitmap bvE;
    private Bitmap bvF;
    private PointF bvG;
    private PointF bvH;
    private PointF bvI;
    private PointF bvJ;
    private volatile int bvK;
    private ArrayList<Bitmap> bvL;
    private boolean bvM;
    private b bvN;
    private ExecutorService bvO;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes7.dex */
    public interface b {
        void Q(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface d {
        void Ra();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bvK;
        heartSurfaceView.bvK = i - 1;
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
        this.bvC = false;
        this.bvD = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bvG == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bvG = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bvH = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bvI = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bvJ = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bvA = getHolder();
        this.bvA.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bvB = new c[30];
        this.bvE = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bvF = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bvC = true;
        this.bvD = false;
        this.bvL = new ArrayList<>();
        this.bvL.add(fB(a.b.liveshow_video_heart_like1));
        this.bvL.add(fB(a.b.liveshow_video_heart_like2));
        this.bvL.add(fB(a.b.liveshow_video_heart_like3));
        this.bvL.add(fB(a.b.liveshow_video_heart_like4));
        this.bvL.add(fB(a.b.liveshow_video_heart_like5));
        this.bvL.add(fB(a.b.liveshow_video_heart_like6));
        this.bvL.add(fB(a.b.liveshow_video_heart_like7));
        this.bvL.add(fB(a.b.liveshow_video_heart_like8));
        this.bvL.add(fB(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bvC = true;
        if (this.bvO == null) {
            this.bvO = Executors.newFixedThreadPool(5);
        }
        QX();
        QW();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bvB != null) {
            for (c cVar : this.bvB) {
                if (cVar != null && cVar.QZ()) {
                    cVar.cM(false);
                }
            }
        }
        this.bvD = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bvD = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bvD = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bvC = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void QW() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bvC) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bvC && HeartSurfaceView.this.bvK > 0) {
                        if (HeartSurfaceView.this.QY()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bvO != null) {
            this.bvO.execute(runnable);
        }
    }

    private void QX() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bvC) {
                    try {
                        while (HeartSurfaceView.this.bvC && !HeartSurfaceView.this.bvD) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bvC) {
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
        if (this.bvO != null) {
            this.bvO.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bvK < 120) {
            this.bvK += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QY() {
        PointF pointF;
        if (!this.bvD || this.bvI == null || this.bvJ == null || this.bvG == null || this.bvH == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bvJ.x / 2.0f) * nextFloat) + (this.bvJ.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bvI.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bvJ.y);
        }
        Bitmap bitmap = this.bvL.get(this.mRandom.nextInt(this.bvL.size()));
        float width = bitmap.getWidth() + ((this.bvH.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bvM) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bvH.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bvM = false;
        }
        return a(bitmap, this.bvG, new PointF(width, this.bvH.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bvB.length; i++) {
            if (this.bvB[i] == null) {
                this.bvB[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bvB[i].bvN = this.bvN;
                return true;
            } else if (!this.bvB[i].QZ()) {
                this.bvB[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bvG != null && this.bvD && (lockCanvas = this.bvA.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bvB) {
                        if (this.bvC && this.bvD) {
                            if (cVar != null && cVar.QZ()) {
                                cVar.aE(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bvQ, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bvA.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bvA.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bvA.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class c {
        public Bitmap bitmap;
        private PointF bvG;
        public b bvN;
        public RectF bvQ;
        private f bvR;
        private g bvS;
        private a bvT;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bvG = pointF;
            this.bvQ = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bvQ.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bvT = new a(600);
            this.bvT.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Ra() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.cM(false);
                }
            });
            this.bvR = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bvR.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bvQ.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bvQ.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Ra() {
                    c.this.bvT.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bvN != null) {
                        c.this.bvN.Q((int) c.this.bvQ.left, (int) c.this.bvQ.top);
                    }
                }
            });
            this.bvR.start();
            this.bvS = new g(240, 0.75f);
            this.bvS.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bvQ.set(c.this.bvG.x, c.this.bvG.y, c.this.bvG.x + (c.this.mWidth * c.this.mScale), c.this.bvG.y + (c.this.mHeight * c.this.mScale));
                    c.this.bvQ.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Ra() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bvS.start();
            cM(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bvG = pointF;
            this.bvQ.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bvQ.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bvR.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bvR.start();
            this.bvS.start();
            cM(true);
        }

        public boolean QZ() {
            return this.mIsAlive;
        }

        public synchronized void cM(boolean z) {
            this.mIsAlive = z;
        }

        public void aE(long j) {
            if (this.bvS.QZ()) {
                this.bvS.aE(j);
            }
            if (this.bvR.QZ()) {
                this.bvR.aE(j);
            }
            if (this.bvT.QZ()) {
                this.bvT.aE(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static abstract class e {
        private int bvV;
        private volatile boolean bvW;
        private d bvX;
        private volatile boolean bvY = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bvV = i;
        }

        public void fD(int i) {
            this.bvV = i;
        }

        public boolean QZ() {
            return this.bvY;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bvW = true;
            this.bvY = true;
        }

        public void a(d dVar) {
            this.bvX = dVar;
        }

        public void aE(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bvV;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bvY = false;
                if (this.bvX != null) {
                    this.bvX.onUpdate(getValue(f2));
                    this.bvX.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bvW = true;
            } else if (this.bvW) {
                if (this.bvX != null) {
                    this.bvX.Ra();
                }
                this.bvW = false;
            }
            if (this.bvX != null) {
                this.bvX.onUpdate(getValue(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public static class g extends e {
        private float bwc;
        private float bwd;
        private float bwe;

        public g(int i, float f) {
            super(i);
            this.bwc = 0.3f;
            this.bwd = 1.0f;
            this.bwe = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bwe) {
                f2 = (((this.bwd - this.bwc) / this.bwe) * f) + this.bwc;
            } else {
                float f3 = (((-this.bwd) / this.bwe) * f) + (2.0f * this.bwd);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class f extends e {
        private static float bwb = 0.0f;
        private PointF bvG;
        private PointF bvH;
        private PointF bvZ;
        private PointF bwa;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bvG = pointF;
            this.bvH = pointF2;
            this.bvZ = pointF3;
            this.bwa = A(bwb);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            fD(i);
            this.bvG = pointF;
            this.bvH = pointF2;
            this.bvZ = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bwb) {
                return A(f);
            }
            return a((f - bwb) / (1.0f - bwb), this.bwa, this.bvZ, this.bvH);
        }

        public PointF A(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bvG.x;
            pointF.y = (1.0f - f) * this.bvG.y;
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
        return this.bvN;
    }

    public void setAnimateEndListener(b bVar) {
        this.bvN = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bvM = z;
    }

    private Bitmap fB(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap fC(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bvL = new ArrayList<>();
        this.bvL.add(fC(a.b.liveshow_video_heart_like1));
        this.bvL.add(fC(a.b.liveshow_video_heart_like2));
        this.bvL.add(fC(a.b.liveshow_video_heart_like3));
        this.bvL.add(fC(a.b.liveshow_video_heart_like4));
        this.bvL.add(fC(a.b.liveshow_video_heart_like5));
        this.bvL.add(fC(a.b.liveshow_video_heart_like6));
        this.bvL.add(fC(a.b.liveshow_video_heart_like7));
        this.bvL.add(fC(a.b.liveshow_video_heart_like8));
        this.bvL.add(fC(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bvO != null) {
            this.bvO.shutdown();
            this.bvO = null;
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
