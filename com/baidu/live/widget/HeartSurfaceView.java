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
    private SurfaceHolder aGE;
    private c[] aGF;
    private volatile boolean aGG;
    private volatile boolean aGH;
    private Bitmap aGI;
    private Bitmap aGJ;
    private PointF aGK;
    private PointF aGL;
    private PointF aGM;
    private PointF aGN;
    private volatile int aGO;
    private ArrayList<Bitmap> aGP;
    private boolean aGQ;
    private b aGR;
    private ExecutorService aGS;
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
        int i = heartSurfaceView.aGO;
        heartSurfaceView.aGO = i - 1;
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
        this.aGG = false;
        this.aGH = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.aGK == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_start_x);
                    HeartSurfaceView.this.aGK = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.aGL = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.aGM = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.aGN = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.aGE = getHolder();
        this.aGE.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aGF = new c[30];
        this.aGI = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.aGJ = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.aGG = true;
        this.aGH = false;
        this.aGP = new ArrayList<>();
        this.aGP.add(cZ(a.b.liveshow_video_heart_like1));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like2));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like3));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like4));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like5));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like6));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like7));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like8));
        this.aGP.add(cZ(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aGG = true;
        if (this.aGS == null) {
            this.aGS = Executors.newFixedThreadPool(5);
        }
        BE();
        BD();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.aGF != null) {
            for (c cVar : this.aGF) {
                if (cVar != null && cVar.BG()) {
                    cVar.bA(false);
                }
            }
        }
        this.aGH = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aGH = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.aGH = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.aGG = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void BD() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGG) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.aGG && HeartSurfaceView.this.aGO > 0) {
                        if (HeartSurfaceView.this.BF()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.aGS != null) {
            this.aGS.execute(runnable);
        }
    }

    private void BE() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGG) {
                    try {
                        while (HeartSurfaceView.this.aGG && !HeartSurfaceView.this.aGH) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.aGG) {
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
        if (this.aGS != null) {
            this.aGS.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.aGO < 120) {
            this.aGO += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BF() {
        PointF pointF;
        if (!this.aGH || this.aGM == null || this.aGN == null || this.aGK == null || this.aGL == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.aGN.x / 2.0f) * nextFloat) + (this.aGN.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aGM.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aGN.y);
        }
        Bitmap bitmap = this.aGP.get(this.mRandom.nextInt(this.aGP.size()));
        float width = bitmap.getWidth() + ((this.aGL.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.aGQ) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.aGL.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.aGQ = false;
        }
        return a(bitmap, this.aGK, new PointF(width, this.aGL.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.aGF.length; i++) {
            if (this.aGF[i] == null) {
                this.aGF[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.aGF[i].aGR = this.aGR;
                return true;
            } else if (!this.aGF[i].BG()) {
                this.aGF[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.aGK != null && this.aGH && (lockCanvas = this.aGE.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.aGF) {
                        if (this.aGG && this.aGH) {
                            if (cVar != null && cVar.BG()) {
                                cVar.S(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.aGU, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.aGE.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.aGE.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.aGE.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private PointF aGK;
        public b aGR;
        public RectF aGU;
        private f aGV;
        private g aGW;
        private a aGX;
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
            this.aGK = pointF;
            this.aGU = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aGU.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aGX = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.aGX.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
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
            this.aGV = new f(pointF, pointF2, pointF3, 1200);
            this.aGV.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.aGU.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.aGU.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BH() {
                    c.this.aGX.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.aGR != null) {
                        c.this.aGR.I((int) c.this.aGU.left, (int) c.this.aGU.top);
                    }
                }
            });
            this.aGV.start();
            this.aGW = new g(240, 0.75f);
            this.aGW.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.aGU.set(c.this.aGK.x, c.this.aGK.y, c.this.aGK.x + (c.this.mWidth * c.this.mScale), c.this.aGK.y + (c.this.mHeight * c.this.mScale));
                    c.this.aGU.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BH() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aGW.start();
            bA(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.aGK = pointF;
            this.aGU.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aGU.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aGV.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.aGV.start();
            this.aGW.start();
            bA(true);
        }

        public boolean BG() {
            return this.mIsAlive;
        }

        public synchronized void bA(boolean z) {
            this.mIsAlive = z;
        }

        public void S(long j) {
            if (this.aGW.BG()) {
                this.aGW.S(j);
            }
            if (this.aGV.BG()) {
                this.aGV.S(j);
            }
            if (this.aGX.BG()) {
                this.aGX.S(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int aGZ;
        private volatile boolean aHa;
        private d aHb;
        private volatile boolean aHc = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.aGZ = i;
        }

        public void db(int i) {
            this.aGZ = i;
        }

        public boolean BG() {
            return this.aHc;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.aHa = true;
            this.aHc = true;
        }

        public void a(d dVar) {
            this.aHb = dVar;
        }

        public void S(long j) {
            float f = ((float) (j - this.mStartTime)) / this.aGZ;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.aHc = false;
                if (this.aHb != null) {
                    this.aHb.onUpdate(getValue(f2));
                    this.aHb.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.aHa = true;
            } else if (this.aHa) {
                if (this.aHb != null) {
                    this.aHb.BH();
                }
                this.aHa = false;
            }
            if (this.aHb != null) {
                this.aHb.onUpdate(getValue(f2));
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
        private float aHg;
        private float aHh;
        private float aHi;

        public g(int i, float f) {
            super(i);
            this.aHg = 0.3f;
            this.aHh = 1.0f;
            this.aHi = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.aHi) {
                f2 = (((this.aHh - this.aHg) / this.aHi) * f) + this.aHg;
            } else {
                float f3 = (((-this.aHh) / this.aHi) * f) + (2.0f * this.aHh);
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
        private static float aHf = 0.0f;
        private PointF aGK;
        private PointF aGL;
        private PointF aHd;
        private PointF aHe;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.aGK = pointF;
            this.aGL = pointF2;
            this.aHd = pointF3;
            this.aHe = M(aHf);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            db(i);
            this.aGK = pointF;
            this.aGL = pointF2;
            this.aHd = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < aHf) {
                return M(f);
            }
            return a((f - aHf) / (1.0f - aHf), this.aHe, this.aHd, this.aGL);
        }

        public PointF M(float f) {
            PointF pointF = new PointF();
            pointF.x = this.aGK.x;
            pointF.y = (1.0f - f) * this.aGK.y;
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
        return this.aGR;
    }

    public void setAnimateEndListener(b bVar) {
        this.aGR = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.aGQ = z;
    }

    private Bitmap cZ(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap da(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.aGP = new ArrayList<>();
        this.aGP.add(da(a.b.liveshow_video_heart_like1));
        this.aGP.add(da(a.b.liveshow_video_heart_like2));
        this.aGP.add(da(a.b.liveshow_video_heart_like3));
        this.aGP.add(da(a.b.liveshow_video_heart_like4));
        this.aGP.add(da(a.b.liveshow_video_heart_like5));
        this.aGP.add(da(a.b.liveshow_video_heart_like6));
        this.aGP.add(da(a.b.liveshow_video_heart_like7));
        this.aGP.add(da(a.b.liveshow_video_heart_like8));
        this.aGP.add(da(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.aGS != null) {
            this.aGS.shutdown();
            this.aGS = null;
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
