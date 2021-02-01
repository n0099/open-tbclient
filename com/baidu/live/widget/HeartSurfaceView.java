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
import com.baidu.live.ah.a;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder bWD;
    private c[] bWE;
    private volatile boolean bWF;
    private volatile boolean bWG;
    private PointF bWH;
    private PointF bWI;
    private PointF bWJ;
    private PointF bWK;
    private volatile int bWL;
    private ArrayList<Bitmap> bWM;
    private boolean bWN;
    private b bWO;
    private ExecutorService bWP;
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
        void Yx();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bWL;
        heartSurfaceView.bWL = i - 1;
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
        this.bWF = false;
        this.bWG = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bWH == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0157a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bWH = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0157a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bWI = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0157a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bWJ = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bWK = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0157a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bWD = getHolder();
        this.bWD.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bWE = new c[30];
        this.mRandom = new Random();
        this.bWF = true;
        this.bWG = false;
        this.bWM = new ArrayList<>();
        this.bWM.add(fq(a.b.liveshow_video_heart_like1));
        this.bWM.add(fq(a.b.liveshow_video_heart_like2));
        this.bWM.add(fq(a.b.liveshow_video_heart_like3));
        this.bWM.add(fq(a.b.liveshow_video_heart_like4));
        this.bWM.add(fq(a.b.liveshow_video_heart_like5));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bWF = true;
        if (this.bWP == null) {
            this.bWP = Executors.newFixedThreadPool(5);
        }
        Yv();
        Yu();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bWE != null) {
            for (c cVar : this.bWE) {
                if (cVar != null && cVar.isAlive()) {
                    cVar.dI(false);
                }
            }
        }
        this.bWG = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bWG = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bWG = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bWF = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void Yu() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bWF) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bWF && HeartSurfaceView.this.bWL > 0) {
                        if (HeartSurfaceView.this.Yw()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bWP != null) {
            this.bWP.execute(runnable);
        }
    }

    private void Yv() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bWF) {
                    try {
                        while (HeartSurfaceView.this.bWF && !HeartSurfaceView.this.bWG) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bWF) {
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
        if (this.bWP != null) {
            this.bWP.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yw() {
        PointF pointF;
        if (!this.bWG || this.bWJ == null || this.bWK == null || this.bWH == null || this.bWI == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bWK.x / 2.0f) * nextFloat) + (this.bWK.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bWJ.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bWK.y);
        }
        Bitmap bitmap = this.bWM.get(this.mRandom.nextInt(this.bWM.size()));
        float width = bitmap.getWidth() + ((this.bWI.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bWN) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bWI.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bWN = false;
        }
        return a(bitmap, this.bWH, new PointF(width, this.bWI.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bWE.length; i++) {
            if (this.bWE[i] == null) {
                this.bWE[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bWE[i].bWO = this.bWO;
                return true;
            } else if (!this.bWE[i].isAlive()) {
                this.bWE[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bWH != null && this.bWG && (lockCanvas = this.bWD.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bWE) {
                        if (this.bWF && this.bWG) {
                            if (cVar != null && cVar.isAlive()) {
                                cVar.bG(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bWR, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bWD.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bWD.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bWD.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private PointF bWH;
        public b bWO;
        public RectF bWR;
        private f bWS;
        private g bWT;
        private a bWU;
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
            this.bWH = pointF;
            this.bWR = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bWR.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bWU = new a(600);
            this.bWU.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Yx() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.dI(false);
                }
            });
            this.bWS = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bWS.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bWR.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bWR.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Yx() {
                    c.this.bWU.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bWO != null) {
                        c.this.bWO.P((int) c.this.bWR.left, (int) c.this.bWR.top);
                    }
                }
            });
            this.bWS.start();
            this.bWT = new g(240, 0.75f);
            this.bWT.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bWR.set(c.this.bWH.x, c.this.bWH.y, c.this.bWH.x + (c.this.mWidth * c.this.mScale), c.this.bWH.y + (c.this.mHeight * c.this.mScale));
                    c.this.bWR.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void Yx() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bWT.start();
            dI(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bWH = pointF;
            this.bWR.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bWR.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bWS.a(pointF, pointF2, pointF3, 960);
            this.bWS.start();
            this.bWT.start();
            dI(true);
        }

        public boolean isAlive() {
            return this.mIsAlive;
        }

        public synchronized void dI(boolean z) {
            this.mIsAlive = z;
        }

        public void bG(long j) {
            if (this.bWT.isAlive()) {
                this.bWT.bG(j);
            }
            if (this.bWS.isAlive()) {
                this.bWS.bG(j);
            }
            if (this.bWU.isAlive()) {
                this.bWU.bG(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static abstract class e {
        private volatile boolean bWW;
        private d bWX;
        private volatile boolean bWY = false;
        private long mStartTime;
        private int mTotalDuration;

        protected abstract Object D(float f);

        public e(int i) {
            this.mTotalDuration = i;
        }

        public void fs(int i) {
            this.mTotalDuration = i;
        }

        public boolean isAlive() {
            return this.bWY;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bWW = true;
            this.bWY = true;
        }

        public void a(d dVar) {
            this.bWX = dVar;
        }

        public void bG(long j) {
            float f = ((float) (j - this.mStartTime)) / this.mTotalDuration;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bWY = false;
                if (this.bWX != null) {
                    this.bWX.onUpdate(D(f2));
                    this.bWX.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bWW = true;
            } else if (this.bWW) {
                if (this.bWX != null) {
                    this.bWX.Yx();
                }
                this.bWW = false;
            }
            if (this.bWX != null) {
                this.bWX.onUpdate(D(f2));
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
        private float bXc;
        private float bXd;
        private float bXe;

        public g(int i, float f) {
            super(i);
            this.bXc = 0.3f;
            this.bXd = 1.0f;
            this.bXe = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            float f2 = 1.0f;
            if (f < this.bXe) {
                f2 = (((this.bXd - this.bXc) / this.bXe) * f) + this.bXc;
            } else {
                float f3 = (((-this.bXd) / this.bXe) * f) + (2.0f * this.bXd);
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
        private static float bXb = 0.0f;
        private PointF bWH;
        private PointF bWI;
        private PointF bWZ;
        private PointF bXa;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bWH = pointF;
            this.bWI = pointF2;
            this.bWZ = pointF3;
            this.bXa = E(bXb);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            fs(i);
            this.bWH = pointF;
            this.bWI = pointF2;
            this.bWZ = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object D(float f) {
            if (f < bXb) {
                return E(f);
            }
            return a((f - bXb) / (1.0f - bXb), this.bXa, this.bWZ, this.bWI);
        }

        public PointF E(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bWH.x;
            pointF.y = (1.0f - f) * this.bWH.y;
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
        return this.bWO;
    }

    public void setAnimateEndListener(b bVar) {
        this.bWO = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bWN = z;
    }

    private Bitmap fq(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap fr(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bWM = new ArrayList<>();
        this.bWM.add(fr(a.b.liveshow_video_heart_like1));
        this.bWM.add(fr(a.b.liveshow_video_heart_like2));
        this.bWM.add(fr(a.b.liveshow_video_heart_like3));
        this.bWM.add(fr(a.b.liveshow_video_heart_like4));
        this.bWM.add(fr(a.b.liveshow_video_heart_like5));
    }

    public void release() {
        if (this.bWP != null) {
            this.bWP.shutdown();
            this.bWP = null;
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
