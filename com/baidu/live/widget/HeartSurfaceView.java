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
import com.baidu.down.utils.Constants;
import com.baidu.live.y.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder aGF;
    private c[] aGG;
    private volatile boolean aGH;
    private volatile boolean aGI;
    private Bitmap aGJ;
    private Bitmap aGK;
    private PointF aGL;
    private PointF aGM;
    private PointF aGN;
    private PointF aGO;
    private volatile int aGP;
    private ArrayList<Bitmap> aGQ;
    private boolean aGR;
    private b aGS;
    private ExecutorService aGT;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void I(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface d {
        void BH();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.aGP;
        heartSurfaceView.aGP = i - 1;
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
        this.aGH = false;
        this.aGI = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.aGL == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_start_x);
                    HeartSurfaceView.this.aGL = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.aGM = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.aGN = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.aGO = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.aGF = getHolder();
        this.aGF.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aGG = new c[30];
        this.aGJ = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.aGK = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.aGH = true;
        this.aGI = false;
        this.aGQ = new ArrayList<>();
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like1));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like2));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like3));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like4));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like5));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like6));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like7));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like8));
        this.aGQ.add(cZ(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aGH = true;
        if (this.aGT == null) {
            this.aGT = Executors.newFixedThreadPool(5);
        }
        BE();
        BD();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.aGG != null) {
            for (c cVar : this.aGG) {
                if (cVar != null && cVar.BG()) {
                    cVar.bA(false);
                }
            }
        }
        this.aGI = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aGI = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.aGI = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.aGH = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void BD() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGH) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.aGH && HeartSurfaceView.this.aGP > 0) {
                        if (HeartSurfaceView.this.BF()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.aGT != null) {
            this.aGT.execute(runnable);
        }
    }

    private void BE() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGH) {
                    try {
                        while (HeartSurfaceView.this.aGH && !HeartSurfaceView.this.aGI) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.aGH) {
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
        if (this.aGT != null) {
            this.aGT.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.aGP < 120) {
            this.aGP += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BF() {
        PointF pointF;
        if (!this.aGI || this.aGN == null || this.aGO == null || this.aGL == null || this.aGM == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.aGO.x / 2.0f) * nextFloat) + (this.aGO.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aGN.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aGO.y);
        }
        Bitmap bitmap = this.aGQ.get(this.mRandom.nextInt(this.aGQ.size()));
        float width = bitmap.getWidth() + ((this.aGM.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.aGR) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.aGM.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.aGR = false;
        }
        return a(bitmap, this.aGL, new PointF(width, this.aGM.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.aGG.length; i++) {
            if (this.aGG[i] == null) {
                this.aGG[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.aGG[i].aGS = this.aGS;
                return true;
            } else if (!this.aGG[i].BG()) {
                this.aGG[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.aGL != null && this.aGI && (lockCanvas = this.aGF.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.aGG) {
                        if (this.aGH && this.aGI) {
                            if (cVar != null && cVar.BG()) {
                                cVar.S(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.aGV, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.aGF.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.aGF.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.aGF.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private PointF aGL;
        public b aGS;
        public RectF aGV;
        private f aGW;
        private g aGX;
        private a aGY;
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
            this.aGL = pointF;
            this.aGV = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aGV.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aGY = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.aGY.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BH() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.bA(false);
                }
            });
            this.aGW = new f(pointF, pointF2, pointF3, 1200);
            this.aGW.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.aGV.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.aGV.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BH() {
                    c.this.aGY.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.aGS != null) {
                        c.this.aGS.I((int) c.this.aGV.left, (int) c.this.aGV.top);
                    }
                }
            });
            this.aGW.start();
            this.aGX = new g(240, 0.75f);
            this.aGX.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.aGV.set(c.this.aGL.x, c.this.aGL.y, c.this.aGL.x + (c.this.mWidth * c.this.mScale), c.this.aGL.y + (c.this.mHeight * c.this.mScale));
                    c.this.aGV.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BH() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aGX.start();
            bA(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.aGL = pointF;
            this.aGV.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aGV.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aGW.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.aGW.start();
            this.aGX.start();
            bA(true);
        }

        public boolean BG() {
            return this.mIsAlive;
        }

        public synchronized void bA(boolean z) {
            this.mIsAlive = z;
        }

        public void S(long j) {
            if (this.aGX.BG()) {
                this.aGX.S(j);
            }
            if (this.aGW.BG()) {
                this.aGW.S(j);
            }
            if (this.aGY.BG()) {
                this.aGY.S(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int aHa;
        private volatile boolean aHb;
        private d aHc;
        private volatile boolean aHd = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.aHa = i;
        }

        public void db(int i) {
            this.aHa = i;
        }

        public boolean BG() {
            return this.aHd;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.aHb = true;
            this.aHd = true;
        }

        public void a(d dVar) {
            this.aHc = dVar;
        }

        public void S(long j) {
            float f = ((float) (j - this.mStartTime)) / this.aHa;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.aHd = false;
                if (this.aHc != null) {
                    this.aHc.onUpdate(getValue(f2));
                    this.aHc.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.aHb = true;
            } else if (this.aHb) {
                if (this.aHc != null) {
                    this.aHc.BH();
                }
                this.aHb = false;
            }
            if (this.aHc != null) {
                this.aHc.onUpdate(getValue(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
    public static class g extends e {
        private float aHh;
        private float aHi;
        private float aHj;

        public g(int i, float f) {
            super(i);
            this.aHh = 0.3f;
            this.aHi = 1.0f;
            this.aHj = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.aHj) {
                f2 = (((this.aHi - this.aHh) / this.aHj) * f) + this.aHh;
            } else {
                float f3 = (((-this.aHi) / this.aHj) * f) + (2.0f * this.aHi);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class f extends e {
        private static float aHg = 0.0f;
        private PointF aGL;
        private PointF aGM;
        private PointF aHe;
        private PointF aHf;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.aGL = pointF;
            this.aGM = pointF2;
            this.aHe = pointF3;
            this.aHf = M(aHg);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            db(i);
            this.aGL = pointF;
            this.aGM = pointF2;
            this.aHe = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < aHg) {
                return M(f);
            }
            return a((f - aHg) / (1.0f - aHg), this.aHf, this.aHe, this.aGM);
        }

        public PointF M(float f) {
            PointF pointF = new PointF();
            pointF.x = this.aGL.x;
            pointF.y = (1.0f - f) * this.aGL.y;
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
        return this.aGS;
    }

    public void setAnimateEndListener(b bVar) {
        this.aGS = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.aGR = z;
    }

    private Bitmap cZ(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap da(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.aGQ = new ArrayList<>();
        this.aGQ.add(da(a.b.liveshow_video_heart_like1));
        this.aGQ.add(da(a.b.liveshow_video_heart_like2));
        this.aGQ.add(da(a.b.liveshow_video_heart_like3));
        this.aGQ.add(da(a.b.liveshow_video_heart_like4));
        this.aGQ.add(da(a.b.liveshow_video_heart_like5));
        this.aGQ.add(da(a.b.liveshow_video_heart_like6));
        this.aGQ.add(da(a.b.liveshow_video_heart_like7));
        this.aGQ.add(da(a.b.liveshow_video_heart_like8));
        this.aGQ.add(da(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.aGT != null) {
            this.aGT.shutdown();
            this.aGT = null;
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
