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
    private SurfaceHolder bvD;
    private c[] bvE;
    private volatile boolean bvF;
    private volatile boolean bvG;
    private Bitmap bvH;
    private Bitmap bvI;
    private PointF bvJ;
    private PointF bvK;
    private PointF bvL;
    private PointF bvM;
    private volatile int bvN;
    private ArrayList<Bitmap> bvO;
    private boolean bvP;
    private b bvQ;
    private ExecutorService bvR;
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
        int i = heartSurfaceView.bvN;
        heartSurfaceView.bvN = i - 1;
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
        this.bvF = false;
        this.bvG = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bvJ == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bvJ = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bvK = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bvL = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bvM = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0203a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bvD = getHolder();
        this.bvD.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bvE = new c[30];
        this.bvH = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bvI = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bvF = true;
        this.bvG = false;
        this.bvO = new ArrayList<>();
        this.bvO.add(fB(a.b.liveshow_video_heart_like1));
        this.bvO.add(fB(a.b.liveshow_video_heart_like2));
        this.bvO.add(fB(a.b.liveshow_video_heart_like3));
        this.bvO.add(fB(a.b.liveshow_video_heart_like4));
        this.bvO.add(fB(a.b.liveshow_video_heart_like5));
        this.bvO.add(fB(a.b.liveshow_video_heart_like6));
        this.bvO.add(fB(a.b.liveshow_video_heart_like7));
        this.bvO.add(fB(a.b.liveshow_video_heart_like8));
        this.bvO.add(fB(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bvF = true;
        if (this.bvR == null) {
            this.bvR = Executors.newFixedThreadPool(5);
        }
        QX();
        QW();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bvE != null) {
            for (c cVar : this.bvE) {
                if (cVar != null && cVar.QZ()) {
                    cVar.cN(false);
                }
            }
        }
        this.bvG = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bvG = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bvG = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bvF = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void QW() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bvF) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bvF && HeartSurfaceView.this.bvN > 0) {
                        if (HeartSurfaceView.this.QY()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bvR != null) {
            this.bvR.execute(runnable);
        }
    }

    private void QX() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bvF) {
                    try {
                        while (HeartSurfaceView.this.bvF && !HeartSurfaceView.this.bvG) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bvF) {
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
        if (this.bvR != null) {
            this.bvR.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bvN < 120) {
            this.bvN += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QY() {
        PointF pointF;
        if (!this.bvG || this.bvL == null || this.bvM == null || this.bvJ == null || this.bvK == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bvM.x / 2.0f) * nextFloat) + (this.bvM.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bvL.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bvM.y);
        }
        Bitmap bitmap = this.bvO.get(this.mRandom.nextInt(this.bvO.size()));
        float width = bitmap.getWidth() + ((this.bvK.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bvP) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bvK.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bvP = false;
        }
        return a(bitmap, this.bvJ, new PointF(width, this.bvK.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bvE.length; i++) {
            if (this.bvE[i] == null) {
                this.bvE[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bvE[i].bvQ = this.bvQ;
                return true;
            } else if (!this.bvE[i].QZ()) {
                this.bvE[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bvJ != null && this.bvG && (lockCanvas = this.bvD.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bvE) {
                        if (this.bvF && this.bvG) {
                            if (cVar != null && cVar.QZ()) {
                                cVar.aE(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bvT, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bvD.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bvD.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bvD.unlockCanvasAndPost(lockCanvas);
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
        private PointF bvJ;
        public b bvQ;
        public RectF bvT;
        private f bvU;
        private g bvV;
        private a bvW;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bvJ = pointF;
            this.bvT = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bvT.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bvW = new a(600);
            this.bvW.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Ra() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.cN(false);
                }
            });
            this.bvU = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bvU.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bvT.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bvT.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Ra() {
                    c.this.bvW.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bvQ != null) {
                        c.this.bvQ.Q((int) c.this.bvT.left, (int) c.this.bvT.top);
                    }
                }
            });
            this.bvU.start();
            this.bvV = new g(240, 0.75f);
            this.bvV.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bvT.set(c.this.bvJ.x, c.this.bvJ.y, c.this.bvJ.x + (c.this.mWidth * c.this.mScale), c.this.bvJ.y + (c.this.mHeight * c.this.mScale));
                    c.this.bvT.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Ra() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bvV.start();
            cN(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bvJ = pointF;
            this.bvT.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bvT.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bvU.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bvU.start();
            this.bvV.start();
            cN(true);
        }

        public boolean QZ() {
            return this.mIsAlive;
        }

        public synchronized void cN(boolean z) {
            this.mIsAlive = z;
        }

        public void aE(long j) {
            if (this.bvV.QZ()) {
                this.bvV.aE(j);
            }
            if (this.bvU.QZ()) {
                this.bvU.aE(j);
            }
            if (this.bvW.QZ()) {
                this.bvW.aE(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static abstract class e {
        private int bvY;
        private volatile boolean bvZ;
        private d bwa;
        private volatile boolean bwb = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bvY = i;
        }

        public void fD(int i) {
            this.bvY = i;
        }

        public boolean QZ() {
            return this.bwb;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bvZ = true;
            this.bwb = true;
        }

        public void a(d dVar) {
            this.bwa = dVar;
        }

        public void aE(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bvY;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bwb = false;
                if (this.bwa != null) {
                    this.bwa.onUpdate(getValue(f2));
                    this.bwa.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bvZ = true;
            } else if (this.bvZ) {
                if (this.bwa != null) {
                    this.bwa.Ra();
                }
                this.bvZ = false;
            }
            if (this.bwa != null) {
                this.bwa.onUpdate(getValue(f2));
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
        private float bwf;
        private float bwg;
        private float bwh;

        public g(int i, float f) {
            super(i);
            this.bwf = 0.3f;
            this.bwg = 1.0f;
            this.bwh = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bwh) {
                f2 = (((this.bwg - this.bwf) / this.bwh) * f) + this.bwf;
            } else {
                float f3 = (((-this.bwg) / this.bwh) * f) + (2.0f * this.bwg);
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
        private static float bwe = 0.0f;
        private PointF bvJ;
        private PointF bvK;
        private PointF bwc;
        private PointF bwd;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bvJ = pointF;
            this.bvK = pointF2;
            this.bwc = pointF3;
            this.bwd = A(bwe);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            fD(i);
            this.bvJ = pointF;
            this.bvK = pointF2;
            this.bwc = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bwe) {
                return A(f);
            }
            return a((f - bwe) / (1.0f - bwe), this.bwd, this.bwc, this.bvK);
        }

        public PointF A(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bvJ.x;
            pointF.y = (1.0f - f) * this.bvJ.y;
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
        return this.bvQ;
    }

    public void setAnimateEndListener(b bVar) {
        this.bvQ = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bvP = z;
    }

    private Bitmap fB(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap fC(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bvO = new ArrayList<>();
        this.bvO.add(fC(a.b.liveshow_video_heart_like1));
        this.bvO.add(fC(a.b.liveshow_video_heart_like2));
        this.bvO.add(fC(a.b.liveshow_video_heart_like3));
        this.bvO.add(fC(a.b.liveshow_video_heart_like4));
        this.bvO.add(fC(a.b.liveshow_video_heart_like5));
        this.bvO.add(fC(a.b.liveshow_video_heart_like6));
        this.bvO.add(fC(a.b.liveshow_video_heart_like7));
        this.bvO.add(fC(a.b.liveshow_video_heart_like8));
        this.bvO.add(fC(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bvR != null) {
            this.bvR.shutdown();
            this.bvR = null;
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
