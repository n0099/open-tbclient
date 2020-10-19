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
import com.baidu.live.aa.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder bFC;
    private c[] bFD;
    private volatile boolean bFE;
    private volatile boolean bFF;
    private Bitmap bFG;
    private Bitmap bFH;
    private PointF bFI;
    private PointF bFJ;
    private PointF bFK;
    private PointF bFL;
    private volatile int bFM;
    private ArrayList<Bitmap> bFN;
    private boolean bFO;
    private b bFP;
    private ExecutorService bFQ;
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
        void TK();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bFM;
        heartSurfaceView.bFM = i - 1;
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
        this.bFE = false;
        this.bFF = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bFI == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0168a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bFI = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0168a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bFJ = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0168a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bFK = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bFL = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0168a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bFC = getHolder();
        this.bFC.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bFD = new c[30];
        this.bFG = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bFH = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bFE = true;
        this.bFF = false;
        this.bFN = new ArrayList<>();
        this.bFN.add(gd(a.b.liveshow_video_heart_like1));
        this.bFN.add(gd(a.b.liveshow_video_heart_like2));
        this.bFN.add(gd(a.b.liveshow_video_heart_like3));
        this.bFN.add(gd(a.b.liveshow_video_heart_like4));
        this.bFN.add(gd(a.b.liveshow_video_heart_like5));
        this.bFN.add(gd(a.b.liveshow_video_heart_like6));
        this.bFN.add(gd(a.b.liveshow_video_heart_like7));
        this.bFN.add(gd(a.b.liveshow_video_heart_like8));
        this.bFN.add(gd(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bFE = true;
        if (this.bFQ == null) {
            this.bFQ = Executors.newFixedThreadPool(5);
        }
        TH();
        TG();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bFD != null) {
            for (c cVar : this.bFD) {
                if (cVar != null && cVar.TJ()) {
                    cVar.cV(false);
                }
            }
        }
        this.bFF = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bFF = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bFF = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bFE = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void TG() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bFE) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bFE && HeartSurfaceView.this.bFM > 0) {
                        if (HeartSurfaceView.this.TI()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bFQ != null) {
            this.bFQ.execute(runnable);
        }
    }

    private void TH() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bFE) {
                    try {
                        while (HeartSurfaceView.this.bFE && !HeartSurfaceView.this.bFF) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bFE) {
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
        if (this.bFQ != null) {
            this.bFQ.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bFM < 120) {
            this.bFM += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TI() {
        PointF pointF;
        if (!this.bFF || this.bFK == null || this.bFL == null || this.bFI == null || this.bFJ == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bFL.x / 2.0f) * nextFloat) + (this.bFL.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bFK.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bFL.y);
        }
        Bitmap bitmap = this.bFN.get(this.mRandom.nextInt(this.bFN.size()));
        float width = bitmap.getWidth() + ((this.bFJ.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bFO) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bFJ.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bFO = false;
        }
        return a(bitmap, this.bFI, new PointF(width, this.bFJ.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bFD.length; i++) {
            if (this.bFD[i] == null) {
                this.bFD[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bFD[i].bFP = this.bFP;
                return true;
            } else if (!this.bFD[i].TJ()) {
                this.bFD[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bFI != null && this.bFF && (lockCanvas = this.bFC.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bFD) {
                        if (this.bFE && this.bFF) {
                            if (cVar != null && cVar.TJ()) {
                                cVar.aG(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bFS, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bFC.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bFC.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bFC.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private PointF bFI;
        public b bFP;
        public RectF bFS;
        private f bFT;
        private g bFU;
        private a bFV;
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
            this.bFI = pointF;
            this.bFS = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bFS.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bFV = new a(600);
            this.bFV.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void TK() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.cV(false);
                }
            });
            this.bFT = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bFT.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bFS.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bFS.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void TK() {
                    c.this.bFV.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bFP != null) {
                        c.this.bFP.Q((int) c.this.bFS.left, (int) c.this.bFS.top);
                    }
                }
            });
            this.bFT.start();
            this.bFU = new g(240, 0.75f);
            this.bFU.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bFS.set(c.this.bFI.x, c.this.bFI.y, c.this.bFI.x + (c.this.mWidth * c.this.mScale), c.this.bFI.y + (c.this.mHeight * c.this.mScale));
                    c.this.bFS.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void TK() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bFU.start();
            cV(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bFI = pointF;
            this.bFS.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bFS.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bFT.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bFT.start();
            this.bFU.start();
            cV(true);
        }

        public boolean TJ() {
            return this.mIsAlive;
        }

        public synchronized void cV(boolean z) {
            this.mIsAlive = z;
        }

        public void aG(long j) {
            if (this.bFU.TJ()) {
                this.bFU.aG(j);
            }
            if (this.bFT.TJ()) {
                this.bFT.aG(j);
            }
            if (this.bFV.TJ()) {
                this.bFV.aG(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class e {
        private int bFX;
        private volatile boolean bFY;
        private d bFZ;
        private volatile boolean bGa = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bFX = i;
        }

        public void gf(int i) {
            this.bFX = i;
        }

        public boolean TJ() {
            return this.bGa;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bFY = true;
            this.bGa = true;
        }

        public void a(d dVar) {
            this.bFZ = dVar;
        }

        public void aG(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bFX;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bGa = false;
                if (this.bFZ != null) {
                    this.bFZ.onUpdate(getValue(f2));
                    this.bFZ.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bFY = true;
            } else if (this.bFY) {
                if (this.bFZ != null) {
                    this.bFZ.TK();
                }
                this.bFY = false;
            }
            if (this.bFZ != null) {
                this.bFZ.onUpdate(getValue(f2));
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
        private float bGe;
        private float bGf;
        private float bGg;

        public g(int i, float f) {
            super(i);
            this.bGe = 0.3f;
            this.bGf = 1.0f;
            this.bGg = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bGg) {
                f2 = (((this.bGf - this.bGe) / this.bGg) * f) + this.bGe;
            } else {
                float f3 = (((-this.bGf) / this.bGg) * f) + (2.0f * this.bGf);
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
        private static float bGd = 0.0f;
        private PointF bFI;
        private PointF bFJ;
        private PointF bGb;
        private PointF bGc;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bFI = pointF;
            this.bFJ = pointF2;
            this.bGb = pointF3;
            this.bGc = C(bGd);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            gf(i);
            this.bFI = pointF;
            this.bFJ = pointF2;
            this.bGb = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bGd) {
                return C(f);
            }
            return a((f - bGd) / (1.0f - bGd), this.bGc, this.bGb, this.bFJ);
        }

        public PointF C(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bFI.x;
            pointF.y = (1.0f - f) * this.bFI.y;
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
        return this.bFP;
    }

    public void setAnimateEndListener(b bVar) {
        this.bFP = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bFO = z;
    }

    private Bitmap gd(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap ge(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bFN = new ArrayList<>();
        this.bFN.add(ge(a.b.liveshow_video_heart_like1));
        this.bFN.add(ge(a.b.liveshow_video_heart_like2));
        this.bFN.add(ge(a.b.liveshow_video_heart_like3));
        this.bFN.add(ge(a.b.liveshow_video_heart_like4));
        this.bFN.add(ge(a.b.liveshow_video_heart_like5));
        this.bFN.add(ge(a.b.liveshow_video_heart_like6));
        this.bFN.add(ge(a.b.liveshow_video_heart_like7));
        this.bFN.add(ge(a.b.liveshow_video_heart_like8));
        this.bFN.add(ge(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bFQ != null) {
            this.bFQ.shutdown();
            this.bFQ = null;
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
