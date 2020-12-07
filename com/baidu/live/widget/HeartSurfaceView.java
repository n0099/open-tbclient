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
import com.baidu.live.ai.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder bRF;
    private c[] bRG;
    private volatile boolean bRH;
    private volatile boolean bRI;
    private Bitmap bRJ;
    private Bitmap bRK;
    private PointF bRL;
    private PointF bRM;
    private PointF bRN;
    private PointF bRO;
    private volatile int bRP;
    private ArrayList<Bitmap> bRQ;
    private boolean bRR;
    private b bRS;
    private ExecutorService bRT;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void P(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface d {
        void Zl();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bRP;
        heartSurfaceView.bRP = i - 1;
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
        this.bRH = false;
        this.bRI = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bRL == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0174a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bRL = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0174a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bRM = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0174a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bRN = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bRO = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0174a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bRF = getHolder();
        this.bRF.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bRG = new c[30];
        this.bRJ = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bRK = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bRH = true;
        this.bRI = false;
        this.bRQ = new ArrayList<>();
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like1));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like2));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like3));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like4));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like5));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like6));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like7));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like8));
        this.bRQ.add(gQ(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bRH = true;
        if (this.bRT == null) {
            this.bRT = Executors.newFixedThreadPool(5);
        }
        Zi();
        Zh();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bRG != null) {
            for (c cVar : this.bRG) {
                if (cVar != null && cVar.Zk()) {
                    cVar.dB(false);
                }
            }
        }
        this.bRI = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bRI = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bRI = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bRH = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void Zh() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bRH) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bRH && HeartSurfaceView.this.bRP > 0) {
                        if (HeartSurfaceView.this.Zj()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bRT != null) {
            this.bRT.execute(runnable);
        }
    }

    private void Zi() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bRH) {
                    try {
                        while (HeartSurfaceView.this.bRH && !HeartSurfaceView.this.bRI) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bRH) {
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
        if (this.bRT != null) {
            this.bRT.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bRP < 120) {
            this.bRP += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zj() {
        PointF pointF;
        if (!this.bRI || this.bRN == null || this.bRO == null || this.bRL == null || this.bRM == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bRO.x / 2.0f) * nextFloat) + (this.bRO.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bRN.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bRO.y);
        }
        Bitmap bitmap = this.bRQ.get(this.mRandom.nextInt(this.bRQ.size()));
        float width = bitmap.getWidth() + ((this.bRM.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bRR) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bRM.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bRR = false;
        }
        return a(bitmap, this.bRL, new PointF(width, this.bRM.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bRG.length; i++) {
            if (this.bRG[i] == null) {
                this.bRG[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bRG[i].bRS = this.bRS;
                return true;
            } else if (!this.bRG[i].Zk()) {
                this.bRG[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bRL != null && this.bRI && (lockCanvas = this.bRF.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bRG) {
                        if (this.bRH && this.bRI) {
                            if (cVar != null && cVar.Zk()) {
                                cVar.bC(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bRV, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bRF.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bRF.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bRF.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private PointF bRL;
        public b bRS;
        public RectF bRV;
        private f bRW;
        private g bRX;
        private a bRY;
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
            this.bRL = pointF;
            this.bRV = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bRV.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bRY = new a(600);
            this.bRY.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Zl() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.dB(false);
                }
            });
            this.bRW = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bRW.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bRV.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bRV.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Zl() {
                    c.this.bRY.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bRS != null) {
                        c.this.bRS.P((int) c.this.bRV.left, (int) c.this.bRV.top);
                    }
                }
            });
            this.bRW.start();
            this.bRX = new g(240, 0.75f);
            this.bRX.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bRV.set(c.this.bRL.x, c.this.bRL.y, c.this.bRL.x + (c.this.mWidth * c.this.mScale), c.this.bRL.y + (c.this.mHeight * c.this.mScale));
                    c.this.bRV.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Zl() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bRX.start();
            dB(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bRL = pointF;
            this.bRV.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bRV.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bRW.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bRW.start();
            this.bRX.start();
            dB(true);
        }

        public boolean Zk() {
            return this.mIsAlive;
        }

        public synchronized void dB(boolean z) {
            this.mIsAlive = z;
        }

        public void bC(long j) {
            if (this.bRX.Zk()) {
                this.bRX.bC(j);
            }
            if (this.bRW.Zk()) {
                this.bRW.bC(j);
            }
            if (this.bRY.Zk()) {
                this.bRY.bC(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class e {
        private int bSa;
        private volatile boolean bSb;
        private d bSc;
        private volatile boolean bSd = false;
        private long mStartTime;

        protected abstract Object D(float f);

        public e(int i) {
            this.bSa = i;
        }

        public void gS(int i) {
            this.bSa = i;
        }

        public boolean Zk() {
            return this.bSd;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bSb = true;
            this.bSd = true;
        }

        public void a(d dVar) {
            this.bSc = dVar;
        }

        public void bC(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bSa;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bSd = false;
                if (this.bSc != null) {
                    this.bSc.onUpdate(D(f2));
                    this.bSc.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bSb = true;
            } else if (this.bSb) {
                if (this.bSc != null) {
                    this.bSc.Zl();
                }
                this.bSb = false;
            }
            if (this.bSc != null) {
                this.bSc.onUpdate(D(f2));
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
    /* loaded from: classes4.dex */
    public static class g extends e {
        private float bSh;
        private float bSi;
        private float bSj;

        public g(int i, float f) {
            super(i);
            this.bSh = 0.3f;
            this.bSi = 1.0f;
            this.bSj = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            float f2 = 1.0f;
            if (f < this.bSj) {
                f2 = (((this.bSi - this.bSh) / this.bSj) * f) + this.bSh;
            } else {
                float f3 = (((-this.bSi) / this.bSj) * f) + (2.0f * this.bSi);
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
        private static float bSg = 0.0f;
        private PointF bRL;
        private PointF bRM;
        private PointF bSe;
        private PointF bSf;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bRL = pointF;
            this.bRM = pointF2;
            this.bSe = pointF3;
            this.bSf = E(bSg);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            gS(i);
            this.bRL = pointF;
            this.bRM = pointF2;
            this.bSe = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            if (f < bSg) {
                return E(f);
            }
            return a((f - bSg) / (1.0f - bSg), this.bSf, this.bSe, this.bRM);
        }

        public PointF E(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bRL.x;
            pointF.y = (1.0f - f) * this.bRL.y;
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
        return this.bRS;
    }

    public void setAnimateEndListener(b bVar) {
        this.bRS = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bRR = z;
    }

    private Bitmap gQ(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap gR(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bRQ = new ArrayList<>();
        this.bRQ.add(gR(a.b.liveshow_video_heart_like1));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like2));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like3));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like4));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like5));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like6));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like7));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like8));
        this.bRQ.add(gR(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bRT != null) {
            this.bRT.shutdown();
            this.bRT = null;
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
