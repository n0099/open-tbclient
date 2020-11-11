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
    private SurfaceHolder bOj;
    private c[] bOk;
    private volatile boolean bOl;
    private volatile boolean bOm;
    private Bitmap bOn;
    private Bitmap bOo;
    private PointF bOp;
    private PointF bOq;
    private PointF bOr;
    private PointF bOs;
    private volatile int bOt;
    private ArrayList<Bitmap> bOu;
    private boolean bOv;
    private b bOw;
    private ExecutorService bOx;
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
        void Xv();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bOt;
        heartSurfaceView.bOt = i - 1;
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
        this.bOl = false;
        this.bOm = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bOp == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0171a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bOp = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0171a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bOq = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0171a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bOr = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bOs = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0171a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bOj = getHolder();
        this.bOj.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bOk = new c[30];
        this.bOn = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bOo = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bOl = true;
        this.bOm = false;
        this.bOu = new ArrayList<>();
        this.bOu.add(gw(a.b.liveshow_video_heart_like1));
        this.bOu.add(gw(a.b.liveshow_video_heart_like2));
        this.bOu.add(gw(a.b.liveshow_video_heart_like3));
        this.bOu.add(gw(a.b.liveshow_video_heart_like4));
        this.bOu.add(gw(a.b.liveshow_video_heart_like5));
        this.bOu.add(gw(a.b.liveshow_video_heart_like6));
        this.bOu.add(gw(a.b.liveshow_video_heart_like7));
        this.bOu.add(gw(a.b.liveshow_video_heart_like8));
        this.bOu.add(gw(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bOl = true;
        if (this.bOx == null) {
            this.bOx = Executors.newFixedThreadPool(5);
        }
        Xs();
        Xr();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bOk != null) {
            for (c cVar : this.bOk) {
                if (cVar != null && cVar.Xu()) {
                    cVar.dl(false);
                }
            }
        }
        this.bOm = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bOm = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bOm = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bOl = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void Xr() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bOl) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bOl && HeartSurfaceView.this.bOt > 0) {
                        if (HeartSurfaceView.this.Xt()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bOx != null) {
            this.bOx.execute(runnable);
        }
    }

    private void Xs() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bOl) {
                    try {
                        while (HeartSurfaceView.this.bOl && !HeartSurfaceView.this.bOm) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bOl) {
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
        if (this.bOx != null) {
            this.bOx.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bOt < 120) {
            this.bOt += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xt() {
        PointF pointF;
        if (!this.bOm || this.bOr == null || this.bOs == null || this.bOp == null || this.bOq == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bOs.x / 2.0f) * nextFloat) + (this.bOs.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bOr.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bOs.y);
        }
        Bitmap bitmap = this.bOu.get(this.mRandom.nextInt(this.bOu.size()));
        float width = bitmap.getWidth() + ((this.bOq.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bOv) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bOq.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bOv = false;
        }
        return a(bitmap, this.bOp, new PointF(width, this.bOq.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bOk.length; i++) {
            if (this.bOk[i] == null) {
                this.bOk[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bOk[i].bOw = this.bOw;
                return true;
            } else if (!this.bOk[i].Xu()) {
                this.bOk[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bOp != null && this.bOm && (lockCanvas = this.bOj.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bOk) {
                        if (this.bOl && this.bOm) {
                            if (cVar != null && cVar.Xu()) {
                                cVar.be(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bOz, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bOj.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bOj.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bOj.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private f bOA;
        private g bOB;
        private a bOC;
        private PointF bOp;
        public b bOw;
        public RectF bOz;
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
            this.bOp = pointF;
            this.bOz = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bOz.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bOC = new a(600);
            this.bOC.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Xv() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.dl(false);
                }
            });
            this.bOA = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bOA.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bOz.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bOz.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Xv() {
                    c.this.bOC.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bOw != null) {
                        c.this.bOw.Q((int) c.this.bOz.left, (int) c.this.bOz.top);
                    }
                }
            });
            this.bOA.start();
            this.bOB = new g(240, 0.75f);
            this.bOB.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bOz.set(c.this.bOp.x, c.this.bOp.y, c.this.bOp.x + (c.this.mWidth * c.this.mScale), c.this.bOp.y + (c.this.mHeight * c.this.mScale));
                    c.this.bOz.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Xv() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bOB.start();
            dl(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bOp = pointF;
            this.bOz.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bOz.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bOA.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bOA.start();
            this.bOB.start();
            dl(true);
        }

        public boolean Xu() {
            return this.mIsAlive;
        }

        public synchronized void dl(boolean z) {
            this.mIsAlive = z;
        }

        public void be(long j) {
            if (this.bOB.Xu()) {
                this.bOB.be(j);
            }
            if (this.bOA.Xu()) {
                this.bOA.be(j);
            }
            if (this.bOC.Xu()) {
                this.bOC.be(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class e {
        private int bOE;
        private volatile boolean bOF;
        private d bOG;
        private volatile boolean bOH = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bOE = i;
        }

        public void gy(int i) {
            this.bOE = i;
        }

        public boolean Xu() {
            return this.bOH;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bOF = true;
            this.bOH = true;
        }

        public void a(d dVar) {
            this.bOG = dVar;
        }

        public void be(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bOE;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bOH = false;
                if (this.bOG != null) {
                    this.bOG.onUpdate(getValue(f2));
                    this.bOG.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bOF = true;
            } else if (this.bOF) {
                if (this.bOG != null) {
                    this.bOG.Xv();
                }
                this.bOF = false;
            }
            if (this.bOG != null) {
                this.bOG.onUpdate(getValue(f2));
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
        private float bOL;
        private float bOM;
        private float bON;

        public g(int i, float f) {
            super(i);
            this.bOL = 0.3f;
            this.bOM = 1.0f;
            this.bON = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bON) {
                f2 = (((this.bOM - this.bOL) / this.bON) * f) + this.bOL;
            } else {
                float f3 = (((-this.bOM) / this.bON) * f) + (2.0f * this.bOM);
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
        private static float bOK = 0.0f;
        private PointF bOI;
        private PointF bOJ;
        private PointF bOp;
        private PointF bOq;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bOp = pointF;
            this.bOq = pointF2;
            this.bOI = pointF3;
            this.bOJ = F(bOK);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            gy(i);
            this.bOp = pointF;
            this.bOq = pointF2;
            this.bOI = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bOK) {
                return F(f);
            }
            return a((f - bOK) / (1.0f - bOK), this.bOJ, this.bOI, this.bOq);
        }

        public PointF F(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bOp.x;
            pointF.y = (1.0f - f) * this.bOp.y;
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
        return this.bOw;
    }

    public void setAnimateEndListener(b bVar) {
        this.bOw = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bOv = z;
    }

    private Bitmap gw(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap gx(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bOu = new ArrayList<>();
        this.bOu.add(gx(a.b.liveshow_video_heart_like1));
        this.bOu.add(gx(a.b.liveshow_video_heart_like2));
        this.bOu.add(gx(a.b.liveshow_video_heart_like3));
        this.bOu.add(gx(a.b.liveshow_video_heart_like4));
        this.bOu.add(gx(a.b.liveshow_video_heart_like5));
        this.bOu.add(gx(a.b.liveshow_video_heart_like6));
        this.bOu.add(gx(a.b.liveshow_video_heart_like7));
        this.bOu.add(gx(a.b.liveshow_video_heart_like8));
        this.bOu.add(gx(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bOx != null) {
            this.bOx.shutdown();
            this.bOx = null;
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
