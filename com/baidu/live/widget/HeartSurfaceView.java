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
import com.baidu.live.t.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder aBE;
    private c[] aBF;
    private volatile boolean aBG;
    private volatile boolean aBH;
    private Bitmap aBI;
    private Bitmap aBJ;
    private PointF aBK;
    private PointF aBL;
    private PointF aBM;
    private PointF aBN;
    private volatile int aBO;
    private ArrayList<Bitmap> aBP;
    private boolean aBQ;
    private b aBR;
    private ExecutorService aBS;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void D(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface d {
        void onOver();

        void onUpdate(Object obj);

        void yT();
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.aBO;
        heartSurfaceView.aBO = i - 1;
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
        this.aBG = false;
        this.aBH = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.aBK == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0087a.liveshow_heart_start_x);
                    HeartSurfaceView.this.aBK = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0087a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.aBL = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0087a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.aBM = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.aBN = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0087a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.aBE = getHolder();
        this.aBE.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aBF = new c[30];
        this.aBI = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.aBJ = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.aBG = true;
        this.aBH = false;
        this.aBP = new ArrayList<>();
        this.aBP.add(cI(a.b.liveshow_video_heart_like1));
        this.aBP.add(cI(a.b.liveshow_video_heart_like2));
        this.aBP.add(cI(a.b.liveshow_video_heart_like3));
        this.aBP.add(cI(a.b.liveshow_video_heart_like4));
        this.aBP.add(cI(a.b.liveshow_video_heart_like5));
        this.aBP.add(cI(a.b.liveshow_video_heart_like6));
        this.aBP.add(cI(a.b.liveshow_video_heart_like7));
        this.aBP.add(cI(a.b.liveshow_video_heart_like8));
        this.aBP.add(cI(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aBG = true;
        if (this.aBS == null) {
            this.aBS = Executors.newFixedThreadPool(5);
        }
        yQ();
        yP();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.aBF != null) {
            for (c cVar : this.aBF) {
                if (cVar != null && cVar.yS()) {
                    cVar.bn(false);
                }
            }
        }
        this.aBH = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aBH = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.aBH = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.aBG = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void yP() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aBG) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.aBG && HeartSurfaceView.this.aBO > 0) {
                        if (HeartSurfaceView.this.yR()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.aBS != null) {
            this.aBS.execute(runnable);
        }
    }

    private void yQ() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aBG) {
                    try {
                        while (HeartSurfaceView.this.aBG && !HeartSurfaceView.this.aBH) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.aBG) {
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
        if (this.aBS != null) {
            this.aBS.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.aBO < 120) {
            this.aBO += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yR() {
        PointF pointF;
        if (!this.aBH || this.aBM == null || this.aBN == null || this.aBK == null || this.aBL == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.aBN.x / 2.0f) * nextFloat) + (this.aBN.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aBM.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aBN.y);
        }
        Bitmap bitmap = this.aBP.get(this.mRandom.nextInt(this.aBP.size()));
        float width = bitmap.getWidth() + ((this.aBL.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.aBQ) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.aBL.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.aBQ = false;
        }
        return a(bitmap, this.aBK, new PointF(width, this.aBL.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.aBF.length; i++) {
            if (this.aBF[i] == null) {
                this.aBF[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.aBF[i].aBR = this.aBR;
                return true;
            } else if (!this.aBF[i].yS()) {
                this.aBF[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.aBK != null && this.aBH && (lockCanvas = this.aBE.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.aBF) {
                        if (this.aBG && this.aBH) {
                            if (cVar != null && cVar.yS()) {
                                cVar.L(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.aBU, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.aBE.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.aBE.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.aBE.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private PointF aBK;
        public b aBR;
        public RectF aBU;
        private f aBV;
        private g aBW;
        private a aBX;
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
            this.aBK = pointF;
            this.aBU = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aBU.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aBX = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.aBX.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void yT() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.bn(false);
                }
            });
            this.aBV = new f(pointF, pointF2, pointF3, 1200);
            this.aBV.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.aBU.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.aBU.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void yT() {
                    c.this.aBX.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.aBR != null) {
                        c.this.aBR.D((int) c.this.aBU.left, (int) c.this.aBU.top);
                    }
                }
            });
            this.aBV.start();
            this.aBW = new g(240, 0.75f);
            this.aBW.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.aBU.set(c.this.aBK.x, c.this.aBK.y, c.this.aBK.x + (c.this.mWidth * c.this.mScale), c.this.aBK.y + (c.this.mHeight * c.this.mScale));
                    c.this.aBU.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void yT() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aBW.start();
            bn(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.aBK = pointF;
            this.aBU.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aBU.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aBV.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.aBV.start();
            this.aBW.start();
            bn(true);
        }

        public boolean yS() {
            return this.mIsAlive;
        }

        public synchronized void bn(boolean z) {
            this.mIsAlive = z;
        }

        public void L(long j) {
            if (this.aBW.yS()) {
                this.aBW.L(j);
            }
            if (this.aBV.yS()) {
                this.aBV.L(j);
            }
            if (this.aBX.yS()) {
                this.aBX.L(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class e {
        private int aBZ;
        private volatile boolean aCa;
        private d aCb;
        private volatile boolean aCc = false;
        private long mStartTime;

        protected abstract Object M(float f);

        public e(int i) {
            this.aBZ = i;
        }

        public void cK(int i) {
            this.aBZ = i;
        }

        public boolean yS() {
            return this.aCc;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.aCa = true;
            this.aCc = true;
        }

        public void a(d dVar) {
            this.aCb = dVar;
        }

        public void L(long j) {
            float f = ((float) (j - this.mStartTime)) / this.aBZ;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.aCc = false;
                if (this.aCb != null) {
                    this.aCb.onUpdate(M(f2));
                    this.aCb.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.aCa = true;
            } else if (this.aCa) {
                if (this.aCb != null) {
                    this.aCb.yT();
                }
                this.aCa = false;
            }
            if (this.aCb != null) {
                this.aCb.onUpdate(M(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends e {
        public a(int i) {
            super(i);
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object M(float f) {
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
    /* loaded from: classes2.dex */
    public static class g extends e {
        private float aCg;
        private float aCh;
        private float aCi;

        public g(int i, float f) {
            super(i);
            this.aCg = 0.3f;
            this.aCh = 1.0f;
            this.aCi = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object M(float f) {
            float f2 = 1.0f;
            if (f < this.aCi) {
                f2 = (((this.aCh - this.aCg) / this.aCi) * f) + this.aCg;
            } else {
                float f3 = (((-this.aCh) / this.aCi) * f) + (2.0f * this.aCh);
                if (f3 > 1.0f) {
                    f2 = f3;
                }
            }
            return Float.valueOf(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends e {
        private static float aCf = 0.0f;
        private PointF aBK;
        private PointF aBL;
        private PointF aCd;
        private PointF aCe;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.aBK = pointF;
            this.aBL = pointF2;
            this.aCd = pointF3;
            this.aCe = N(aCf);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            cK(i);
            this.aBK = pointF;
            this.aBL = pointF2;
            this.aCd = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object M(float f) {
            if (f < aCf) {
                return N(f);
            }
            return a((f - aCf) / (1.0f - aCf), this.aCe, this.aCd, this.aBL);
        }

        public PointF N(float f) {
            PointF pointF = new PointF();
            pointF.x = this.aBK.x;
            pointF.y = (1.0f - f) * this.aBK.y;
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
        return this.aBR;
    }

    public void setAnimateEndListener(b bVar) {
        this.aBR = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.aBQ = z;
    }

    private Bitmap cI(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap cJ(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.aBP = new ArrayList<>();
        this.aBP.add(cJ(a.b.liveshow_video_heart_like1));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like2));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like3));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like4));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like5));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like6));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like7));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like8));
        this.aBP.add(cJ(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.aBS != null) {
            this.aBS.shutdown();
            this.aBS = null;
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
