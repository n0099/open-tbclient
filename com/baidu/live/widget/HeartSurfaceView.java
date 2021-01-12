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
/* loaded from: classes10.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder bSB;
    private c[] bSC;
    private volatile boolean bSD;
    private volatile boolean bSE;
    private Bitmap bSF;
    private Bitmap bSG;
    private PointF bSH;
    private PointF bSI;
    private PointF bSJ;
    private PointF bSK;
    private volatile int bSL;
    private ArrayList<Bitmap> bSM;
    private boolean bSN;
    private b bSO;
    private ExecutorService bSP;
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
        void WH();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bSL;
        heartSurfaceView.bSL = i - 1;
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
        this.bSD = false;
        this.bSE = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bSH == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0158a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bSH = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0158a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bSI = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0158a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bSJ = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bSK = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0158a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bSB = getHolder();
        this.bSB.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bSC = new c[30];
        this.bSF = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bSG = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bSD = true;
        this.bSE = false;
        this.bSM = new ArrayList<>();
        this.bSM.add(fk(a.b.liveshow_video_heart_like1));
        this.bSM.add(fk(a.b.liveshow_video_heart_like2));
        this.bSM.add(fk(a.b.liveshow_video_heart_like3));
        this.bSM.add(fk(a.b.liveshow_video_heart_like4));
        this.bSM.add(fk(a.b.liveshow_video_heart_like5));
        this.bSM.add(fk(a.b.liveshow_video_heart_like6));
        this.bSM.add(fk(a.b.liveshow_video_heart_like7));
        this.bSM.add(fk(a.b.liveshow_video_heart_like8));
        this.bSM.add(fk(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bSD = true;
        if (this.bSP == null) {
            this.bSP = Executors.newFixedThreadPool(5);
        }
        WF();
        WE();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bSC != null) {
            for (c cVar : this.bSC) {
                if (cVar != null && cVar.isAlive()) {
                    cVar.dA(false);
                }
            }
        }
        this.bSE = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bSE = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bSE = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bSD = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void WE() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bSD) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bSD && HeartSurfaceView.this.bSL > 0) {
                        if (HeartSurfaceView.this.WG()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bSP != null) {
            this.bSP.execute(runnable);
        }
    }

    private void WF() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bSD) {
                    try {
                        while (HeartSurfaceView.this.bSD && !HeartSurfaceView.this.bSE) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bSD) {
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
        if (this.bSP != null) {
            this.bSP.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bSL < 120) {
            this.bSL += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WG() {
        PointF pointF;
        if (!this.bSE || this.bSJ == null || this.bSK == null || this.bSH == null || this.bSI == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bSK.x / 2.0f) * nextFloat) + (this.bSK.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bSJ.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bSK.y);
        }
        Bitmap bitmap = this.bSM.get(this.mRandom.nextInt(this.bSM.size()));
        float width = bitmap.getWidth() + ((this.bSI.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bSN) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bSI.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bSN = false;
        }
        return a(bitmap, this.bSH, new PointF(width, this.bSI.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bSC.length; i++) {
            if (this.bSC[i] == null) {
                this.bSC[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bSC[i].bSO = this.bSO;
                return true;
            } else if (!this.bSC[i].isAlive()) {
                this.bSC[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bSH != null && this.bSE && (lockCanvas = this.bSB.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bSC) {
                        if (this.bSD && this.bSE) {
                            if (cVar != null && cVar.isAlive()) {
                                cVar.bC(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bSR, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bSB.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bSB.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bSB.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        private PointF bSH;
        public b bSO;
        public RectF bSR;
        private f bSS;
        private g bST;
        private a bSU;
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
            this.bSH = pointF;
            this.bSR = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bSR.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bSU = new a(600);
            this.bSU.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void WH() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.dA(false);
                }
            });
            this.bSS = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bSS.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bSR.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bSR.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void WH() {
                    c.this.bSU.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bSO != null) {
                        c.this.bSO.P((int) c.this.bSR.left, (int) c.this.bSR.top);
                    }
                }
            });
            this.bSS.start();
            this.bST = new g(240, 0.75f);
            this.bST.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bSR.set(c.this.bSH.x, c.this.bSH.y, c.this.bSH.x + (c.this.mWidth * c.this.mScale), c.this.bSH.y + (c.this.mHeight * c.this.mScale));
                    c.this.bSR.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void WH() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bST.start();
            dA(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bSH = pointF;
            this.bSR.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bSR.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bSS.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bSS.start();
            this.bST.start();
            dA(true);
        }

        public boolean isAlive() {
            return this.mIsAlive;
        }

        public synchronized void dA(boolean z) {
            this.mIsAlive = z;
        }

        public void bC(long j) {
            if (this.bST.isAlive()) {
                this.bST.bC(j);
            }
            if (this.bSS.isAlive()) {
                this.bSS.bC(j);
            }
            if (this.bSU.isAlive()) {
                this.bSU.bC(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static abstract class e {
        private volatile boolean bSW;
        private d bSX;
        private volatile boolean bSY = false;
        private long mStartTime;
        private int mTotalDuration;

        protected abstract Object D(float f);

        public e(int i) {
            this.mTotalDuration = i;
        }

        public void fm(int i) {
            this.mTotalDuration = i;
        }

        public boolean isAlive() {
            return this.bSY;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bSW = true;
            this.bSY = true;
        }

        public void a(d dVar) {
            this.bSX = dVar;
        }

        public void bC(long j) {
            float f = ((float) (j - this.mStartTime)) / this.mTotalDuration;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bSY = false;
                if (this.bSX != null) {
                    this.bSX.onUpdate(D(f2));
                    this.bSX.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bSW = true;
            } else if (this.bSW) {
                if (this.bSX != null) {
                    this.bSX.WH();
                }
                this.bSW = false;
            }
            if (this.bSX != null) {
                this.bSX.onUpdate(D(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    public static class g extends e {
        private float bTc;
        private float bTd;
        private float bTe;

        public g(int i, float f) {
            super(i);
            this.bTc = 0.3f;
            this.bTd = 1.0f;
            this.bTe = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            float f2 = 1.0f;
            if (f < this.bTe) {
                f2 = (((this.bTd - this.bTc) / this.bTe) * f) + this.bTc;
            } else {
                float f3 = (((-this.bTd) / this.bTe) * f) + (2.0f * this.bTd);
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
        private static float bTb = 0.0f;
        private PointF bSH;
        private PointF bSI;
        private PointF bSZ;
        private PointF bTa;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bSH = pointF;
            this.bSI = pointF2;
            this.bSZ = pointF3;
            this.bTa = E(bTb);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            fm(i);
            this.bSH = pointF;
            this.bSI = pointF2;
            this.bSZ = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            if (f < bTb) {
                return E(f);
            }
            return a((f - bTb) / (1.0f - bTb), this.bTa, this.bSZ, this.bSI);
        }

        public PointF E(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bSH.x;
            pointF.y = (1.0f - f) * this.bSH.y;
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
        return this.bSO;
    }

    public void setAnimateEndListener(b bVar) {
        this.bSO = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bSN = z;
    }

    private Bitmap fk(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap fl(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bSM = new ArrayList<>();
        this.bSM.add(fl(a.b.liveshow_video_heart_like1));
        this.bSM.add(fl(a.b.liveshow_video_heart_like2));
        this.bSM.add(fl(a.b.liveshow_video_heart_like3));
        this.bSM.add(fl(a.b.liveshow_video_heart_like4));
        this.bSM.add(fl(a.b.liveshow_video_heart_like5));
        this.bSM.add(fl(a.b.liveshow_video_heart_like6));
        this.bSM.add(fl(a.b.liveshow_video_heart_like7));
        this.bSM.add(fl(a.b.liveshow_video_heart_like8));
        this.bSM.add(fl(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bSP != null) {
            this.bSP.shutdown();
            this.bSP = null;
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
