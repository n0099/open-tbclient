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
    private boolean bkA;
    private b bkB;
    private ExecutorService bkC;
    private SurfaceHolder bko;
    private c[] bkp;
    private volatile boolean bkq;
    private volatile boolean bkr;
    private Bitmap bks;
    private Bitmap bkt;
    private PointF bku;
    private PointF bkv;
    private PointF bkw;
    private PointF bkx;
    private volatile int bky;
    private ArrayList<Bitmap> bkz;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void K(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface d {
        void JK();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bky;
        heartSurfaceView.bky = i - 1;
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
        this.bkq = false;
        this.bkr = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bku == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0188a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bku = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0188a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bkv = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0188a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bkw = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bkx = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0188a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bko = getHolder();
        this.bko.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bkp = new c[30];
        this.bks = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bkt = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bkq = true;
        this.bkr = false;
        this.bkz = new ArrayList<>();
        this.bkz.add(du(a.b.liveshow_video_heart_like1));
        this.bkz.add(du(a.b.liveshow_video_heart_like2));
        this.bkz.add(du(a.b.liveshow_video_heart_like3));
        this.bkz.add(du(a.b.liveshow_video_heart_like4));
        this.bkz.add(du(a.b.liveshow_video_heart_like5));
        this.bkz.add(du(a.b.liveshow_video_heart_like6));
        this.bkz.add(du(a.b.liveshow_video_heart_like7));
        this.bkz.add(du(a.b.liveshow_video_heart_like8));
        this.bkz.add(du(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bkq = true;
        if (this.bkC == null) {
            this.bkC = Executors.newFixedThreadPool(5);
        }
        JH();
        JG();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bkp != null) {
            for (c cVar : this.bkp) {
                if (cVar != null && cVar.JJ()) {
                    cVar.cw(false);
                }
            }
        }
        this.bkr = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bkr = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bkr = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bkq = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void JG() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bkq) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bkq && HeartSurfaceView.this.bky > 0) {
                        if (HeartSurfaceView.this.JI()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bkC != null) {
            this.bkC.execute(runnable);
        }
    }

    private void JH() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bkq) {
                    try {
                        while (HeartSurfaceView.this.bkq && !HeartSurfaceView.this.bkr) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bkq) {
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
        if (this.bkC != null) {
            this.bkC.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bky < 120) {
            this.bky += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JI() {
        PointF pointF;
        if (!this.bkr || this.bkw == null || this.bkx == null || this.bku == null || this.bkv == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bkx.x / 2.0f) * nextFloat) + (this.bkx.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bkw.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bkx.y);
        }
        Bitmap bitmap = this.bkz.get(this.mRandom.nextInt(this.bkz.size()));
        float width = bitmap.getWidth() + ((this.bkv.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bkA) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bkv.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bkA = false;
        }
        return a(bitmap, this.bku, new PointF(width, this.bkv.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bkp.length; i++) {
            if (this.bkp[i] == null) {
                this.bkp[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bkp[i].bkB = this.bkB;
                return true;
            } else if (!this.bkp[i].JJ()) {
                this.bkp[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bku != null && this.bkr && (lockCanvas = this.bko.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bkp) {
                        if (this.bkq && this.bkr) {
                            if (cVar != null && cVar.JJ()) {
                                cVar.aD(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bkE, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bko.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bko.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bko.unlockCanvasAndPost(lockCanvas);
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
        public b bkB;
        public RectF bkE;
        private f bkF;
        private g bkG;
        private a bkH;
        private PointF bku;
        private int mHeight;
        private volatile boolean mIsAlive;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.bku = pointF;
            this.bkE = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bkE.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bkH = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.bkH.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void JK() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.cw(false);
                }
            });
            this.bkF = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bkF.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bkE.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bkE.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void JK() {
                    c.this.bkH.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bkB != null) {
                        c.this.bkB.K((int) c.this.bkE.left, (int) c.this.bkE.top);
                    }
                }
            });
            this.bkF.start();
            this.bkG = new g(240, 0.75f);
            this.bkG.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bkE.set(c.this.bku.x, c.this.bku.y, c.this.bku.x + (c.this.mWidth * c.this.mScale), c.this.bku.y + (c.this.mHeight * c.this.mScale));
                    c.this.bkE.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void JK() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bkG.start();
            cw(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bku = pointF;
            this.bkE.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bkE.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bkF.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bkF.start();
            this.bkG.start();
            cw(true);
        }

        public boolean JJ() {
            return this.mIsAlive;
        }

        public synchronized void cw(boolean z) {
            this.mIsAlive = z;
        }

        public void aD(long j) {
            if (this.bkG.JJ()) {
                this.bkG.aD(j);
            }
            if (this.bkF.JJ()) {
                this.bkF.aD(j);
            }
            if (this.bkH.JJ()) {
                this.bkH.aD(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int bkJ;
        private volatile boolean bkK;
        private d bkL;
        private volatile boolean bkM = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bkJ = i;
        }

        public void dw(int i) {
            this.bkJ = i;
        }

        public boolean JJ() {
            return this.bkM;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bkK = true;
            this.bkM = true;
        }

        public void a(d dVar) {
            this.bkL = dVar;
        }

        public void aD(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bkJ;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bkM = false;
                if (this.bkL != null) {
                    this.bkL.onUpdate(getValue(f2));
                    this.bkL.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bkK = true;
            } else if (this.bkK) {
                if (this.bkL != null) {
                    this.bkL.JK();
                }
                this.bkK = false;
            }
            if (this.bkL != null) {
                this.bkL.onUpdate(getValue(f2));
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
        private float bkQ;
        private float bkR;
        private float bkS;

        public g(int i, float f) {
            super(i);
            this.bkQ = 0.3f;
            this.bkR = 1.0f;
            this.bkS = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bkS) {
                f2 = (((this.bkR - this.bkQ) / this.bkS) * f) + this.bkQ;
            } else {
                float f3 = (((-this.bkR) / this.bkS) * f) + (2.0f * this.bkR);
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
        private static float bkP = 0.0f;
        private PointF bkN;
        private PointF bkO;
        private PointF bku;
        private PointF bkv;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bku = pointF;
            this.bkv = pointF2;
            this.bkN = pointF3;
            this.bkO = t(bkP);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            dw(i);
            this.bku = pointF;
            this.bkv = pointF2;
            this.bkN = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bkP) {
                return t(f);
            }
            return a((f - bkP) / (1.0f - bkP), this.bkO, this.bkN, this.bkv);
        }

        public PointF t(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bku.x;
            pointF.y = (1.0f - f) * this.bku.y;
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
        return this.bkB;
    }

    public void setAnimateEndListener(b bVar) {
        this.bkB = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bkA = z;
    }

    private Bitmap du(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap dv(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bkz = new ArrayList<>();
        this.bkz.add(dv(a.b.liveshow_video_heart_like1));
        this.bkz.add(dv(a.b.liveshow_video_heart_like2));
        this.bkz.add(dv(a.b.liveshow_video_heart_like3));
        this.bkz.add(dv(a.b.liveshow_video_heart_like4));
        this.bkz.add(dv(a.b.liveshow_video_heart_like5));
        this.bkz.add(dv(a.b.liveshow_video_heart_like6));
        this.bkz.add(dv(a.b.liveshow_video_heart_like7));
        this.bkz.add(dv(a.b.liveshow_video_heart_like8));
        this.bkz.add(dv(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bkC != null) {
            this.bkC.shutdown();
            this.bkC = null;
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
