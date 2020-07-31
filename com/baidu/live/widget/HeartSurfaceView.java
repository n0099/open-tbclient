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
import com.baidu.live.y.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder bpK;
    private c[] bpL;
    private volatile boolean bpM;
    private volatile boolean bpN;
    private Bitmap bpO;
    private Bitmap bpP;
    private PointF bpQ;
    private PointF bpR;
    private PointF bpS;
    private PointF bpT;
    private volatile int bpU;
    private ArrayList<Bitmap> bpV;
    private boolean bpW;
    private b bpX;
    private ExecutorService bpY;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void M(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface d {
        void La();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bpU;
        heartSurfaceView.bpU = i - 1;
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
        this.bpM = false;
        this.bpN = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bpQ == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0196a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bpQ = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0196a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bpR = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0196a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bpS = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bpT = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0196a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bpK = getHolder();
        this.bpK.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bpL = new c[30];
        this.bpO = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bpP = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bpM = true;
        this.bpN = false;
        this.bpV = new ArrayList<>();
        this.bpV.add(dG(a.b.liveshow_video_heart_like1));
        this.bpV.add(dG(a.b.liveshow_video_heart_like2));
        this.bpV.add(dG(a.b.liveshow_video_heart_like3));
        this.bpV.add(dG(a.b.liveshow_video_heart_like4));
        this.bpV.add(dG(a.b.liveshow_video_heart_like5));
        this.bpV.add(dG(a.b.liveshow_video_heart_like6));
        this.bpV.add(dG(a.b.liveshow_video_heart_like7));
        this.bpV.add(dG(a.b.liveshow_video_heart_like8));
        this.bpV.add(dG(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bpM = true;
        if (this.bpY == null) {
            this.bpY = Executors.newFixedThreadPool(5);
        }
        KX();
        KW();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bpL != null) {
            for (c cVar : this.bpL) {
                if (cVar != null && cVar.KZ()) {
                    cVar.cE(false);
                }
            }
        }
        this.bpN = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bpN = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bpN = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bpM = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void KW() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bpM) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bpM && HeartSurfaceView.this.bpU > 0) {
                        if (HeartSurfaceView.this.KY()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bpY != null) {
            this.bpY.execute(runnable);
        }
    }

    private void KX() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bpM) {
                    try {
                        while (HeartSurfaceView.this.bpM && !HeartSurfaceView.this.bpN) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bpM) {
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
        if (this.bpY != null) {
            this.bpY.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bpU < 120) {
            this.bpU += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KY() {
        PointF pointF;
        if (!this.bpN || this.bpS == null || this.bpT == null || this.bpQ == null || this.bpR == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bpT.x / 2.0f) * nextFloat) + (this.bpT.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bpS.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bpT.y);
        }
        Bitmap bitmap = this.bpV.get(this.mRandom.nextInt(this.bpV.size()));
        float width = bitmap.getWidth() + ((this.bpR.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bpW) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bpR.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bpW = false;
        }
        return a(bitmap, this.bpQ, new PointF(width, this.bpR.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bpL.length; i++) {
            if (this.bpL[i] == null) {
                this.bpL[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bpL[i].bpX = this.bpX;
                return true;
            } else if (!this.bpL[i].KZ()) {
                this.bpL[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bpQ != null && this.bpN && (lockCanvas = this.bpK.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bpL) {
                        if (this.bpM && this.bpN) {
                            if (cVar != null && cVar.KZ()) {
                                cVar.aD(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bqa, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bpK.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bpK.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bpK.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        public Bitmap bitmap;
        private PointF bpQ;
        public b bpX;
        public RectF bqa;
        private f bqb;
        private g bqc;
        private a bqd;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bpQ = pointF;
            this.bqa = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bqa.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bqd = new a(600);
            this.bqd.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void La() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.cE(false);
                }
            });
            this.bqb = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bqb.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bqa.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bqa.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void La() {
                    c.this.bqd.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bpX != null) {
                        c.this.bpX.M((int) c.this.bqa.left, (int) c.this.bqa.top);
                    }
                }
            });
            this.bqb.start();
            this.bqc = new g(240, 0.75f);
            this.bqc.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bqa.set(c.this.bpQ.x, c.this.bpQ.y, c.this.bpQ.x + (c.this.mWidth * c.this.mScale), c.this.bpQ.y + (c.this.mHeight * c.this.mScale));
                    c.this.bqa.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void La() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bqc.start();
            cE(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bpQ = pointF;
            this.bqa.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bqa.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bqb.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bqb.start();
            this.bqc.start();
            cE(true);
        }

        public boolean KZ() {
            return this.mIsAlive;
        }

        public synchronized void cE(boolean z) {
            this.mIsAlive = z;
        }

        public void aD(long j) {
            if (this.bqc.KZ()) {
                this.bqc.aD(j);
            }
            if (this.bqb.KZ()) {
                this.bqb.aD(j);
            }
            if (this.bqd.KZ()) {
                this.bqd.aD(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class e {
        private int bqf;
        private volatile boolean bqg;
        private d bqh;
        private volatile boolean bqi = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bqf = i;
        }

        public void dI(int i) {
            this.bqf = i;
        }

        public boolean KZ() {
            return this.bqi;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bqg = true;
            this.bqi = true;
        }

        public void a(d dVar) {
            this.bqh = dVar;
        }

        public void aD(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bqf;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bqi = false;
                if (this.bqh != null) {
                    this.bqh.onUpdate(getValue(f2));
                    this.bqh.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bqg = true;
            } else if (this.bqg) {
                if (this.bqh != null) {
                    this.bqh.La();
                }
                this.bqg = false;
            }
            if (this.bqh != null) {
                this.bqh.onUpdate(getValue(f2));
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
        private float bqm;
        private float bqn;
        private float bqo;

        public g(int i, float f) {
            super(i);
            this.bqm = 0.3f;
            this.bqn = 1.0f;
            this.bqo = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bqo) {
                f2 = (((this.bqn - this.bqm) / this.bqo) * f) + this.bqm;
            } else {
                float f3 = (((-this.bqn) / this.bqo) * f) + (2.0f * this.bqn);
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
        private static float bql = 0.0f;
        private PointF bpQ;
        private PointF bpR;
        private PointF bqj;
        private PointF bqk;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bpQ = pointF;
            this.bpR = pointF2;
            this.bqj = pointF3;
            this.bqk = v(bql);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            dI(i);
            this.bpQ = pointF;
            this.bpR = pointF2;
            this.bqj = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bql) {
                return v(f);
            }
            return a((f - bql) / (1.0f - bql), this.bqk, this.bqj, this.bpR);
        }

        public PointF v(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bpQ.x;
            pointF.y = (1.0f - f) * this.bpQ.y;
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
        return this.bpX;
    }

    public void setAnimateEndListener(b bVar) {
        this.bpX = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bpW = z;
    }

    private Bitmap dG(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap dH(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bpV = new ArrayList<>();
        this.bpV.add(dH(a.b.liveshow_video_heart_like1));
        this.bpV.add(dH(a.b.liveshow_video_heart_like2));
        this.bpV.add(dH(a.b.liveshow_video_heart_like3));
        this.bpV.add(dH(a.b.liveshow_video_heart_like4));
        this.bpV.add(dH(a.b.liveshow_video_heart_like5));
        this.bpV.add(dH(a.b.liveshow_video_heart_like6));
        this.bpV.add(dH(a.b.liveshow_video_heart_like7));
        this.bpV.add(dH(a.b.liveshow_video_heart_like8));
        this.bpV.add(dH(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bpY != null) {
            this.bpY.shutdown();
            this.bpY = null;
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
