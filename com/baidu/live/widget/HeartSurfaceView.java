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
    private ArrayList<Bitmap> bpA;
    private boolean bpB;
    private b bpC;
    private ExecutorService bpD;
    private SurfaceHolder bpp;
    private c[] bpq;
    private volatile boolean bpr;
    private volatile boolean bps;
    private Bitmap bpt;
    private Bitmap bpu;
    private PointF bpv;
    private PointF bpw;
    private PointF bpx;
    private PointF bpy;
    private volatile int bpz;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void M(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface d {
        void KT();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bpz;
        heartSurfaceView.bpz = i - 1;
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
        this.bpr = false;
        this.bps = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bpv == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0194a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bpv = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0194a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bpw = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0194a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bpx = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bpy = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0194a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bpp = getHolder();
        this.bpp.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bpq = new c[30];
        this.bpt = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bpu = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bpr = true;
        this.bps = false;
        this.bpA = new ArrayList<>();
        this.bpA.add(dG(a.b.liveshow_video_heart_like1));
        this.bpA.add(dG(a.b.liveshow_video_heart_like2));
        this.bpA.add(dG(a.b.liveshow_video_heart_like3));
        this.bpA.add(dG(a.b.liveshow_video_heart_like4));
        this.bpA.add(dG(a.b.liveshow_video_heart_like5));
        this.bpA.add(dG(a.b.liveshow_video_heart_like6));
        this.bpA.add(dG(a.b.liveshow_video_heart_like7));
        this.bpA.add(dG(a.b.liveshow_video_heart_like8));
        this.bpA.add(dG(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bpr = true;
        if (this.bpD == null) {
            this.bpD = Executors.newFixedThreadPool(5);
        }
        KQ();
        KP();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bpq != null) {
            for (c cVar : this.bpq) {
                if (cVar != null && cVar.KS()) {
                    cVar.cC(false);
                }
            }
        }
        this.bps = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bps = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bps = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bpr = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void KP() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bpr) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bpr && HeartSurfaceView.this.bpz > 0) {
                        if (HeartSurfaceView.this.KR()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bpD != null) {
            this.bpD.execute(runnable);
        }
    }

    private void KQ() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bpr) {
                    try {
                        while (HeartSurfaceView.this.bpr && !HeartSurfaceView.this.bps) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bpr) {
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
        if (this.bpD != null) {
            this.bpD.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bpz < 120) {
            this.bpz += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KR() {
        PointF pointF;
        if (!this.bps || this.bpx == null || this.bpy == null || this.bpv == null || this.bpw == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bpy.x / 2.0f) * nextFloat) + (this.bpy.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bpx.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bpy.y);
        }
        Bitmap bitmap = this.bpA.get(this.mRandom.nextInt(this.bpA.size()));
        float width = bitmap.getWidth() + ((this.bpw.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bpB) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bpw.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bpB = false;
        }
        return a(bitmap, this.bpv, new PointF(width, this.bpw.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bpq.length; i++) {
            if (this.bpq[i] == null) {
                this.bpq[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bpq[i].bpC = this.bpC;
                return true;
            } else if (!this.bpq[i].KS()) {
                this.bpq[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bpv != null && this.bps && (lockCanvas = this.bpp.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bpq) {
                        if (this.bpr && this.bps) {
                            if (cVar != null && cVar.KS()) {
                                cVar.aD(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bpF, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bpp.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bpp.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bpp.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        public Bitmap bitmap;
        public b bpC;
        public RectF bpF;
        private f bpG;
        private g bpH;
        private a bpI;
        private PointF bpv;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bpv = pointF;
            this.bpF = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bpF.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bpI = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.bpI.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void KT() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.cC(false);
                }
            });
            this.bpG = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bpG.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bpF.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bpF.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void KT() {
                    c.this.bpI.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bpC != null) {
                        c.this.bpC.M((int) c.this.bpF.left, (int) c.this.bpF.top);
                    }
                }
            });
            this.bpG.start();
            this.bpH = new g(240, 0.75f);
            this.bpH.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bpF.set(c.this.bpv.x, c.this.bpv.y, c.this.bpv.x + (c.this.mWidth * c.this.mScale), c.this.bpv.y + (c.this.mHeight * c.this.mScale));
                    c.this.bpF.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void KT() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bpH.start();
            cC(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bpv = pointF;
            this.bpF.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bpF.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bpG.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bpG.start();
            this.bpH.start();
            cC(true);
        }

        public boolean KS() {
            return this.mIsAlive;
        }

        public synchronized void cC(boolean z) {
            this.mIsAlive = z;
        }

        public void aD(long j) {
            if (this.bpH.KS()) {
                this.bpH.aD(j);
            }
            if (this.bpG.KS()) {
                this.bpG.aD(j);
            }
            if (this.bpI.KS()) {
                this.bpI.aD(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int bpK;
        private volatile boolean bpL;
        private d bpM;
        private volatile boolean bpN = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bpK = i;
        }

        public void dI(int i) {
            this.bpK = i;
        }

        public boolean KS() {
            return this.bpN;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bpL = true;
            this.bpN = true;
        }

        public void a(d dVar) {
            this.bpM = dVar;
        }

        public void aD(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bpK;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bpN = false;
                if (this.bpM != null) {
                    this.bpM.onUpdate(getValue(f2));
                    this.bpM.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bpL = true;
            } else if (this.bpL) {
                if (this.bpM != null) {
                    this.bpM.KT();
                }
                this.bpL = false;
            }
            if (this.bpM != null) {
                this.bpM.onUpdate(getValue(f2));
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
        private float bpR;
        private float bpS;
        private float bpT;

        public g(int i, float f) {
            super(i);
            this.bpR = 0.3f;
            this.bpS = 1.0f;
            this.bpT = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bpT) {
                f2 = (((this.bpS - this.bpR) / this.bpT) * f) + this.bpR;
            } else {
                float f3 = (((-this.bpS) / this.bpT) * f) + (2.0f * this.bpS);
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
        private static float bpQ = 0.0f;
        private PointF bpO;
        private PointF bpP;
        private PointF bpv;
        private PointF bpw;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bpv = pointF;
            this.bpw = pointF2;
            this.bpO = pointF3;
            this.bpP = v(bpQ);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            dI(i);
            this.bpv = pointF;
            this.bpw = pointF2;
            this.bpO = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bpQ) {
                return v(f);
            }
            return a((f - bpQ) / (1.0f - bpQ), this.bpP, this.bpO, this.bpw);
        }

        public PointF v(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bpv.x;
            pointF.y = (1.0f - f) * this.bpv.y;
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
        return this.bpC;
    }

    public void setAnimateEndListener(b bVar) {
        this.bpC = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bpB = z;
    }

    private Bitmap dG(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap dH(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bpA = new ArrayList<>();
        this.bpA.add(dH(a.b.liveshow_video_heart_like1));
        this.bpA.add(dH(a.b.liveshow_video_heart_like2));
        this.bpA.add(dH(a.b.liveshow_video_heart_like3));
        this.bpA.add(dH(a.b.liveshow_video_heart_like4));
        this.bpA.add(dH(a.b.liveshow_video_heart_like5));
        this.bpA.add(dH(a.b.liveshow_video_heart_like6));
        this.bpA.add(dH(a.b.liveshow_video_heart_like7));
        this.bpA.add(dH(a.b.liveshow_video_heart_like8));
        this.bpA.add(dH(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bpD != null) {
            this.bpD.shutdown();
            this.bpD = null;
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
