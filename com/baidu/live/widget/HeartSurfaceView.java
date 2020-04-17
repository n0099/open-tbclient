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
    private SurfaceHolder bcH;
    private c[] bcI;
    private volatile boolean bcJ;
    private volatile boolean bcK;
    private Bitmap bcL;
    private Bitmap bcM;
    private PointF bcN;
    private PointF bcO;
    private PointF bcP;
    private PointF bcQ;
    private volatile int bcR;
    private ArrayList<Bitmap> bcS;
    private boolean bcT;
    private b bcU;
    private ExecutorService bcV;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void H(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface d {
        void HS();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bcR;
        heartSurfaceView.bcR = i - 1;
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
        this.bcJ = false;
        this.bcK = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bcN == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0134a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bcN = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0134a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bcO = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0134a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bcP = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bcQ = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0134a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bcH = getHolder();
        this.bcH.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bcI = new c[30];
        this.bcL = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bcM = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bcJ = true;
        this.bcK = false;
        this.bcS = new ArrayList<>();
        this.bcS.add(dp(a.b.liveshow_video_heart_like1));
        this.bcS.add(dp(a.b.liveshow_video_heart_like2));
        this.bcS.add(dp(a.b.liveshow_video_heart_like3));
        this.bcS.add(dp(a.b.liveshow_video_heart_like4));
        this.bcS.add(dp(a.b.liveshow_video_heart_like5));
        this.bcS.add(dp(a.b.liveshow_video_heart_like6));
        this.bcS.add(dp(a.b.liveshow_video_heart_like7));
        this.bcS.add(dp(a.b.liveshow_video_heart_like8));
        this.bcS.add(dp(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bcJ = true;
        if (this.bcV == null) {
            this.bcV = Executors.newFixedThreadPool(5);
        }
        HP();
        HO();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bcI != null) {
            for (c cVar : this.bcI) {
                if (cVar != null && cVar.HR()) {
                    cVar.ck(false);
                }
            }
        }
        this.bcK = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bcK = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bcK = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bcJ = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void HO() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bcJ) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bcJ && HeartSurfaceView.this.bcR > 0) {
                        if (HeartSurfaceView.this.HQ()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bcV != null) {
            this.bcV.execute(runnable);
        }
    }

    private void HP() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bcJ) {
                    try {
                        while (HeartSurfaceView.this.bcJ && !HeartSurfaceView.this.bcK) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bcJ) {
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
        if (this.bcV != null) {
            this.bcV.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bcR < 120) {
            this.bcR += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HQ() {
        PointF pointF;
        if (!this.bcK || this.bcP == null || this.bcQ == null || this.bcN == null || this.bcO == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bcQ.x / 2.0f) * nextFloat) + (this.bcQ.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bcP.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bcQ.y);
        }
        Bitmap bitmap = this.bcS.get(this.mRandom.nextInt(this.bcS.size()));
        float width = bitmap.getWidth() + ((this.bcO.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bcT) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bcO.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bcT = false;
        }
        return a(bitmap, this.bcN, new PointF(width, this.bcO.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bcI.length; i++) {
            if (this.bcI[i] == null) {
                this.bcI[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bcI[i].bcU = this.bcU;
                return true;
            } else if (!this.bcI[i].HR()) {
                this.bcI[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bcN != null && this.bcK && (lockCanvas = this.bcH.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bcI) {
                        if (this.bcJ && this.bcK) {
                            if (cVar != null && cVar.HR()) {
                                cVar.ay(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bcX, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bcH.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bcH.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bcH.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private PointF bcN;
        public b bcU;
        public RectF bcX;
        private f bcY;
        private g bcZ;
        private a bda;
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
            this.bcN = pointF;
            this.bcX = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bcX.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bda = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.bda.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void HS() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.ck(false);
                }
            });
            this.bcY = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bcY.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bcX.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bcX.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void HS() {
                    c.this.bda.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bcU != null) {
                        c.this.bcU.H((int) c.this.bcX.left, (int) c.this.bcX.top);
                    }
                }
            });
            this.bcY.start();
            this.bcZ = new g(240, 0.75f);
            this.bcZ.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bcX.set(c.this.bcN.x, c.this.bcN.y, c.this.bcN.x + (c.this.mWidth * c.this.mScale), c.this.bcN.y + (c.this.mHeight * c.this.mScale));
                    c.this.bcX.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void HS() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bcZ.start();
            ck(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bcN = pointF;
            this.bcX.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bcX.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bcY.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bcY.start();
            this.bcZ.start();
            ck(true);
        }

        public boolean HR() {
            return this.mIsAlive;
        }

        public synchronized void ck(boolean z) {
            this.mIsAlive = z;
        }

        public void ay(long j) {
            if (this.bcZ.HR()) {
                this.bcZ.ay(j);
            }
            if (this.bcY.HR()) {
                this.bcY.ay(j);
            }
            if (this.bda.HR()) {
                this.bda.ay(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int bdc;
        private volatile boolean bdd;
        private d bde;
        private volatile boolean bdf = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bdc = i;
        }

        public void dr(int i) {
            this.bdc = i;
        }

        public boolean HR() {
            return this.bdf;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bdd = true;
            this.bdf = true;
        }

        public void a(d dVar) {
            this.bde = dVar;
        }

        public void ay(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bdc;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bdf = false;
                if (this.bde != null) {
                    this.bde.onUpdate(getValue(f2));
                    this.bde.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bdd = true;
            } else if (this.bdd) {
                if (this.bde != null) {
                    this.bde.HS();
                }
                this.bdd = false;
            }
            if (this.bde != null) {
                this.bde.onUpdate(getValue(f2));
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
        private float bdj;
        private float bdk;
        private float bdl;

        public g(int i, float f) {
            super(i);
            this.bdj = 0.3f;
            this.bdk = 1.0f;
            this.bdl = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bdl) {
                f2 = (((this.bdk - this.bdj) / this.bdl) * f) + this.bdj;
            } else {
                float f3 = (((-this.bdk) / this.bdl) * f) + (2.0f * this.bdk);
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
        private static float bdi = 0.0f;
        private PointF bcN;
        private PointF bcO;
        private PointF bdg;
        private PointF bdh;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bcN = pointF;
            this.bcO = pointF2;
            this.bdg = pointF3;
            this.bdh = t(bdi);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            dr(i);
            this.bcN = pointF;
            this.bcO = pointF2;
            this.bdg = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bdi) {
                return t(f);
            }
            return a((f - bdi) / (1.0f - bdi), this.bdh, this.bdg, this.bcO);
        }

        public PointF t(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bcN.x;
            pointF.y = (1.0f - f) * this.bcN.y;
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
        return this.bcU;
    }

    public void setAnimateEndListener(b bVar) {
        this.bcU = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bcT = z;
    }

    private Bitmap dp(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap dq(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bcS = new ArrayList<>();
        this.bcS.add(dq(a.b.liveshow_video_heart_like1));
        this.bcS.add(dq(a.b.liveshow_video_heart_like2));
        this.bcS.add(dq(a.b.liveshow_video_heart_like3));
        this.bcS.add(dq(a.b.liveshow_video_heart_like4));
        this.bcS.add(dq(a.b.liveshow_video_heart_like5));
        this.bcS.add(dq(a.b.liveshow_video_heart_like6));
        this.bcS.add(dq(a.b.liveshow_video_heart_like7));
        this.bcS.add(dq(a.b.liveshow_video_heart_like8));
        this.bcS.add(dq(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bcV != null) {
            this.bcV.shutdown();
            this.bcV = null;
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
