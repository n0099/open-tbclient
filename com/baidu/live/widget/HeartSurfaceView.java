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
import com.baidu.live.n.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder atI;
    private c[] atJ;
    private volatile boolean atK;
    private volatile boolean atL;
    private Bitmap atM;
    private Bitmap atN;
    private PointF atO;
    private PointF atP;
    private PointF atQ;
    private PointF atR;
    private volatile int atS;
    private ArrayList<Bitmap> atT;
    private boolean atU;
    private b atV;
    private ExecutorService atW;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    public interface b {
        void A(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface d {
        void A(Object obj);

        void onOver();

        void wU();
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.atS;
        heartSurfaceView.atS = i - 1;
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
        this.atK = false;
        this.atL = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.atO == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_start_x);
                    HeartSurfaceView.this.atO = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.atP = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.atQ = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.atR = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0070a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.atI = getHolder();
        this.atI.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.atJ = new c[30];
        this.atM = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.atN = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.atK = true;
        this.atL = false;
        this.atT = new ArrayList<>();
        this.atT.add(ct(a.b.liveshow_video_heart_like1));
        this.atT.add(ct(a.b.liveshow_video_heart_like2));
        this.atT.add(ct(a.b.liveshow_video_heart_like3));
        this.atT.add(ct(a.b.liveshow_video_heart_like4));
        this.atT.add(ct(a.b.liveshow_video_heart_like5));
        this.atT.add(ct(a.b.liveshow_video_heart_like6));
        this.atT.add(ct(a.b.liveshow_video_heart_like7));
        this.atT.add(ct(a.b.liveshow_video_heart_like8));
        this.atT.add(ct(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.atK = true;
        if (this.atW == null) {
            this.atW = Executors.newFixedThreadPool(5);
        }
        wR();
        wQ();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.atJ != null) {
            for (c cVar : this.atJ) {
                if (cVar != null && cVar.wT()) {
                    cVar.aW(false);
                }
            }
        }
        this.atL = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.atL = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.atL = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.atK = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void wQ() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.atK) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.atK && HeartSurfaceView.this.atS > 0) {
                        if (HeartSurfaceView.this.wS()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.atW != null) {
            this.atW.execute(runnable);
        }
    }

    private void wR() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.atK) {
                    try {
                        while (HeartSurfaceView.this.atK && !HeartSurfaceView.this.atL) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.atK) {
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
        if (this.atW != null) {
            this.atW.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.atS < 120) {
            this.atS += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wS() {
        PointF pointF;
        if (!this.atL || this.atQ == null || this.atR == null || this.atO == null || this.atP == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.atR.x / 2.0f) * nextFloat) + (this.atR.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.atQ.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.atR.y);
        }
        Bitmap bitmap = this.atT.get(this.mRandom.nextInt(this.atT.size()));
        float width = bitmap.getWidth() + ((this.atP.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.atU) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.atP.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.atU = false;
        }
        return a(bitmap, this.atO, new PointF(width, this.atP.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.atJ.length; i++) {
            if (this.atJ[i] == null) {
                this.atJ[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.atJ[i].atV = this.atV;
                return true;
            } else if (!this.atJ[i].wT()) {
                this.atJ[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.atO != null && this.atL && (lockCanvas = this.atI.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.atJ) {
                        if (this.atK && this.atL) {
                            if (cVar != null && cVar.wT()) {
                                cVar.J(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.atY, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.atI.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.atI.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.atI.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {
        private PointF atO;
        public b atV;
        public RectF atY;
        private f atZ;
        private g aua;
        private a aub;
        private volatile boolean auc;
        public Bitmap bitmap;
        private int mHeight;
        private int mWidth;
        public int alpha = 255;
        private float mScale = 0.0f;

        public c(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.atO = pointF;
            this.atY = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.atY.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aub = new a(600);
            this.aub.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void A(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void wU() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.aW(false);
                }
            });
            this.atZ = new f(pointF, pointF2, pointF3, 1200);
            this.atZ.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void A(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.atY.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.atY.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void wU() {
                    c.this.aub.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.atV != null) {
                        c.this.atV.A((int) c.this.atY.left, (int) c.this.atY.top);
                    }
                }
            });
            this.atZ.start();
            this.aua = new g(240, 0.75f);
            this.aua.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void A(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.atY.set(c.this.atO.x, c.this.atO.y, c.this.atO.x + (c.this.mWidth * c.this.mScale), c.this.atO.y + (c.this.mHeight * c.this.mScale));
                    c.this.atY.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void wU() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aua.start();
            aW(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.atO = pointF;
            this.atY.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.atY.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.atZ.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.atZ.start();
            this.aua.start();
            aW(true);
        }

        public boolean wT() {
            return this.auc;
        }

        public synchronized void aW(boolean z) {
            this.auc = z;
        }

        public void J(long j) {
            if (this.aua.wT()) {
                this.aua.J(j);
            }
            if (this.atZ.wT()) {
                this.atZ.J(j);
            }
            if (this.aub.wT()) {
                this.aub.J(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static abstract class e {
        private int aue;
        private volatile boolean auf;
        private d aug;
        private volatile boolean auh = false;
        private long mStartTime;

        protected abstract Object L(float f);

        public e(int i) {
            this.aue = i;
        }

        public void cv(int i) {
            this.aue = i;
        }

        public boolean wT() {
            return this.auh;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.auf = true;
            this.auh = true;
        }

        public void a(d dVar) {
            this.aug = dVar;
        }

        public void J(long j) {
            float f = ((float) (j - this.mStartTime)) / this.aue;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.auh = false;
                if (this.aug != null) {
                    this.aug.A(L(f2));
                    this.aug.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.auf = true;
            } else if (this.auf) {
                if (this.aug != null) {
                    this.aug.wU();
                }
                this.auf = false;
            }
            if (this.aug != null) {
                this.aug.A(L(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends e {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object L(float f) {
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
    /* loaded from: classes6.dex */
    public static class g extends e {
        private float aul;
        private float aum;
        private float aun;

        public g(int i, float f) {
            super(i);
            this.aul = 0.3f;
            this.aum = 1.0f;
            this.aun = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object L(float f) {
            float f2 = 1.0f;
            if (f < this.aun) {
                f2 = (((this.aum - this.aul) / this.aun) * f) + this.aul;
            } else {
                float f3 = (((-this.aum) / this.aun) * f) + (2.0f * this.aum);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class f extends e {
        private static float auk = 0.0f;
        private PointF atO;
        private PointF atP;
        private PointF aui;
        private PointF auj;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.atO = pointF;
            this.atP = pointF2;
            this.aui = pointF3;
            this.auj = M(auk);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            cv(i);
            this.atO = pointF;
            this.atP = pointF2;
            this.aui = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object L(float f) {
            if (f < auk) {
                return M(f);
            }
            return a((f - auk) / (1.0f - auk), this.auj, this.aui, this.atP);
        }

        public PointF M(float f) {
            PointF pointF = new PointF();
            pointF.x = this.atO.x;
            pointF.y = (1.0f - f) * this.atO.y;
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
        return this.atV;
    }

    public void setAnimateEndListener(b bVar) {
        this.atV = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.atU = z;
    }

    private Bitmap ct(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap cu(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.atT = new ArrayList<>();
        this.atT.add(cu(a.b.liveshow_video_heart_like1));
        this.atT.add(cu(a.b.liveshow_video_heart_like2));
        this.atT.add(cu(a.b.liveshow_video_heart_like3));
        this.atT.add(cu(a.b.liveshow_video_heart_like4));
        this.atT.add(cu(a.b.liveshow_video_heart_like5));
        this.atT.add(cu(a.b.liveshow_video_heart_like6));
        this.atT.add(cu(a.b.liveshow_video_heart_like7));
        this.atT.add(cu(a.b.liveshow_video_heart_like8));
        this.atT.add(cu(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.atW != null) {
            this.atW.shutdown();
            this.atW = null;
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
