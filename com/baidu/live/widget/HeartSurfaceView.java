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
    private SurfaceHolder aGD;
    private c[] aGE;
    private volatile boolean aGF;
    private volatile boolean aGG;
    private Bitmap aGH;
    private Bitmap aGI;
    private PointF aGJ;
    private PointF aGK;
    private PointF aGL;
    private PointF aGM;
    private volatile int aGN;
    private ArrayList<Bitmap> aGO;
    private boolean aGP;
    private b aGQ;
    private ExecutorService aGR;
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
        void BF();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.aGN;
        heartSurfaceView.aGN = i - 1;
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
        this.aGF = false;
        this.aGG = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.aGJ == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_start_x);
                    HeartSurfaceView.this.aGJ = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.aGK = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.aGL = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.aGM = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.aGD = getHolder();
        this.aGD.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aGE = new c[30];
        this.aGH = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.aGI = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.aGF = true;
        this.aGG = false;
        this.aGO = new ArrayList<>();
        this.aGO.add(cZ(a.b.liveshow_video_heart_like1));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like2));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like3));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like4));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like5));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like6));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like7));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like8));
        this.aGO.add(cZ(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aGF = true;
        if (this.aGR == null) {
            this.aGR = Executors.newFixedThreadPool(5);
        }
        BC();
        BB();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.aGE != null) {
            for (c cVar : this.aGE) {
                if (cVar != null && cVar.BE()) {
                    cVar.bA(false);
                }
            }
        }
        this.aGG = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aGG = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.aGG = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.aGF = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void BB() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGF) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.aGF && HeartSurfaceView.this.aGN > 0) {
                        if (HeartSurfaceView.this.BD()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.aGR != null) {
            this.aGR.execute(runnable);
        }
    }

    private void BC() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGF) {
                    try {
                        while (HeartSurfaceView.this.aGF && !HeartSurfaceView.this.aGG) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.aGF) {
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
        if (this.aGR != null) {
            this.aGR.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.aGN < 120) {
            this.aGN += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BD() {
        PointF pointF;
        if (!this.aGG || this.aGL == null || this.aGM == null || this.aGJ == null || this.aGK == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.aGM.x / 2.0f) * nextFloat) + (this.aGM.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aGL.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aGM.y);
        }
        Bitmap bitmap = this.aGO.get(this.mRandom.nextInt(this.aGO.size()));
        float width = bitmap.getWidth() + ((this.aGK.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.aGP) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.aGK.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.aGP = false;
        }
        return a(bitmap, this.aGJ, new PointF(width, this.aGK.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.aGE.length; i++) {
            if (this.aGE[i] == null) {
                this.aGE[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.aGE[i].aGQ = this.aGQ;
                return true;
            } else if (!this.aGE[i].BE()) {
                this.aGE[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.aGJ != null && this.aGG && (lockCanvas = this.aGD.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.aGE) {
                        if (this.aGF && this.aGG) {
                            if (cVar != null && cVar.BE()) {
                                cVar.S(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.aGT, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.aGD.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.aGD.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.aGD.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private PointF aGJ;
        public b aGQ;
        public RectF aGT;
        private f aGU;
        private g aGV;
        private a aGW;
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
            this.aGJ = pointF;
            this.aGT = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aGT.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aGW = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.aGW.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BF() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.bA(false);
                }
            });
            this.aGU = new f(pointF, pointF2, pointF3, 1200);
            this.aGU.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.aGT.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.aGT.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BF() {
                    c.this.aGW.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.aGQ != null) {
                        c.this.aGQ.I((int) c.this.aGT.left, (int) c.this.aGT.top);
                    }
                }
            });
            this.aGU.start();
            this.aGV = new g(240, 0.75f);
            this.aGV.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.aGT.set(c.this.aGJ.x, c.this.aGJ.y, c.this.aGJ.x + (c.this.mWidth * c.this.mScale), c.this.aGJ.y + (c.this.mHeight * c.this.mScale));
                    c.this.aGT.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BF() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aGV.start();
            bA(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.aGJ = pointF;
            this.aGT.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aGT.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aGU.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.aGU.start();
            this.aGV.start();
            bA(true);
        }

        public boolean BE() {
            return this.mIsAlive;
        }

        public synchronized void bA(boolean z) {
            this.mIsAlive = z;
        }

        public void S(long j) {
            if (this.aGV.BE()) {
                this.aGV.S(j);
            }
            if (this.aGU.BE()) {
                this.aGU.S(j);
            }
            if (this.aGW.BE()) {
                this.aGW.S(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int aGY;
        private volatile boolean aGZ;
        private d aHa;
        private volatile boolean aHb = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.aGY = i;
        }

        public void db(int i) {
            this.aGY = i;
        }

        public boolean BE() {
            return this.aHb;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.aGZ = true;
            this.aHb = true;
        }

        public void a(d dVar) {
            this.aHa = dVar;
        }

        public void S(long j) {
            float f = ((float) (j - this.mStartTime)) / this.aGY;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.aHb = false;
                if (this.aHa != null) {
                    this.aHa.onUpdate(getValue(f2));
                    this.aHa.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.aGZ = true;
            } else if (this.aGZ) {
                if (this.aHa != null) {
                    this.aHa.BF();
                }
                this.aGZ = false;
            }
            if (this.aHa != null) {
                this.aHa.onUpdate(getValue(f2));
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
        private float aHf;
        private float aHg;
        private float aHh;

        public g(int i, float f) {
            super(i);
            this.aHf = 0.3f;
            this.aHg = 1.0f;
            this.aHh = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.aHh) {
                f2 = (((this.aHg - this.aHf) / this.aHh) * f) + this.aHf;
            } else {
                float f3 = (((-this.aHg) / this.aHh) * f) + (2.0f * this.aHg);
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
        private static float aHe = 0.0f;
        private PointF aGJ;
        private PointF aGK;
        private PointF aHc;
        private PointF aHd;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.aGJ = pointF;
            this.aGK = pointF2;
            this.aHc = pointF3;
            this.aHd = M(aHe);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            db(i);
            this.aGJ = pointF;
            this.aGK = pointF2;
            this.aHc = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < aHe) {
                return M(f);
            }
            return a((f - aHe) / (1.0f - aHe), this.aHd, this.aHc, this.aGK);
        }

        public PointF M(float f) {
            PointF pointF = new PointF();
            pointF.x = this.aGJ.x;
            pointF.y = (1.0f - f) * this.aGJ.y;
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
        return this.aGQ;
    }

    public void setAnimateEndListener(b bVar) {
        this.aGQ = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.aGP = z;
    }

    private Bitmap cZ(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap da(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.aGO = new ArrayList<>();
        this.aGO.add(da(a.b.liveshow_video_heart_like1));
        this.aGO.add(da(a.b.liveshow_video_heart_like2));
        this.aGO.add(da(a.b.liveshow_video_heart_like3));
        this.aGO.add(da(a.b.liveshow_video_heart_like4));
        this.aGO.add(da(a.b.liveshow_video_heart_like5));
        this.aGO.add(da(a.b.liveshow_video_heart_like6));
        this.aGO.add(da(a.b.liveshow_video_heart_like7));
        this.aGO.add(da(a.b.liveshow_video_heart_like8));
        this.aGO.add(da(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.aGR != null) {
            this.aGR.shutdown();
            this.aGR = null;
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
