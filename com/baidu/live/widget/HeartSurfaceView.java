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
    private SurfaceHolder bcM;
    private c[] bcN;
    private volatile boolean bcO;
    private volatile boolean bcP;
    private Bitmap bcQ;
    private Bitmap bcR;
    private PointF bcS;
    private PointF bcT;
    private PointF bcU;
    private PointF bcV;
    private volatile int bcW;
    private ArrayList<Bitmap> bcX;
    private boolean bcY;
    private b bcZ;
    private ExecutorService bda;
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
        void HR();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bcW;
        heartSurfaceView.bcW = i - 1;
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
        this.bcO = false;
        this.bcP = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bcS == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0155a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bcS = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0155a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bcT = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0155a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bcU = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bcV = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0155a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bcM = getHolder();
        this.bcM.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bcN = new c[30];
        this.bcQ = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bcR = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bcO = true;
        this.bcP = false;
        this.bcX = new ArrayList<>();
        this.bcX.add(dp(a.b.liveshow_video_heart_like1));
        this.bcX.add(dp(a.b.liveshow_video_heart_like2));
        this.bcX.add(dp(a.b.liveshow_video_heart_like3));
        this.bcX.add(dp(a.b.liveshow_video_heart_like4));
        this.bcX.add(dp(a.b.liveshow_video_heart_like5));
        this.bcX.add(dp(a.b.liveshow_video_heart_like6));
        this.bcX.add(dp(a.b.liveshow_video_heart_like7));
        this.bcX.add(dp(a.b.liveshow_video_heart_like8));
        this.bcX.add(dp(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bcO = true;
        if (this.bda == null) {
            this.bda = Executors.newFixedThreadPool(5);
        }
        HO();
        HN();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bcN != null) {
            for (c cVar : this.bcN) {
                if (cVar != null && cVar.HQ()) {
                    cVar.ck(false);
                }
            }
        }
        this.bcP = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bcP = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bcP = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bcO = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void HN() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bcO) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bcO && HeartSurfaceView.this.bcW > 0) {
                        if (HeartSurfaceView.this.HP()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bda != null) {
            this.bda.execute(runnable);
        }
    }

    private void HO() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bcO) {
                    try {
                        while (HeartSurfaceView.this.bcO && !HeartSurfaceView.this.bcP) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bcO) {
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
        if (this.bda != null) {
            this.bda.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bcW < 120) {
            this.bcW += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HP() {
        PointF pointF;
        if (!this.bcP || this.bcU == null || this.bcV == null || this.bcS == null || this.bcT == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bcV.x / 2.0f) * nextFloat) + (this.bcV.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bcU.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bcV.y);
        }
        Bitmap bitmap = this.bcX.get(this.mRandom.nextInt(this.bcX.size()));
        float width = bitmap.getWidth() + ((this.bcT.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bcY) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bcT.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bcY = false;
        }
        return a(bitmap, this.bcS, new PointF(width, this.bcT.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bcN.length; i++) {
            if (this.bcN[i] == null) {
                this.bcN[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bcN[i].bcZ = this.bcZ;
                return true;
            } else if (!this.bcN[i].HQ()) {
                this.bcN[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bcS != null && this.bcP && (lockCanvas = this.bcM.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bcN) {
                        if (this.bcO && this.bcP) {
                            if (cVar != null && cVar.HQ()) {
                                cVar.ay(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bdc, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bcM.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bcM.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bcM.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private PointF bcS;
        public b bcZ;
        public RectF bdc;
        private f bdd;
        private g bde;
        private a bdf;
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
            this.bcS = pointF;
            this.bdc = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bdc.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bdf = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.bdf.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void HR() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.ck(false);
                }
            });
            this.bdd = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bdd.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bdc.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bdc.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void HR() {
                    c.this.bdf.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bcZ != null) {
                        c.this.bcZ.H((int) c.this.bdc.left, (int) c.this.bdc.top);
                    }
                }
            });
            this.bdd.start();
            this.bde = new g(240, 0.75f);
            this.bde.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bdc.set(c.this.bcS.x, c.this.bcS.y, c.this.bcS.x + (c.this.mWidth * c.this.mScale), c.this.bcS.y + (c.this.mHeight * c.this.mScale));
                    c.this.bdc.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void HR() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bde.start();
            ck(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bcS = pointF;
            this.bdc.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bdc.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bdd.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bdd.start();
            this.bde.start();
            ck(true);
        }

        public boolean HQ() {
            return this.mIsAlive;
        }

        public synchronized void ck(boolean z) {
            this.mIsAlive = z;
        }

        public void ay(long j) {
            if (this.bde.HQ()) {
                this.bde.ay(j);
            }
            if (this.bdd.HQ()) {
                this.bdd.ay(j);
            }
            if (this.bdf.HQ()) {
                this.bdf.ay(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int bdh;
        private volatile boolean bdi;
        private d bdj;
        private volatile boolean bdk = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bdh = i;
        }

        public void dr(int i) {
            this.bdh = i;
        }

        public boolean HQ() {
            return this.bdk;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bdi = true;
            this.bdk = true;
        }

        public void a(d dVar) {
            this.bdj = dVar;
        }

        public void ay(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bdh;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bdk = false;
                if (this.bdj != null) {
                    this.bdj.onUpdate(getValue(f2));
                    this.bdj.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bdi = true;
            } else if (this.bdi) {
                if (this.bdj != null) {
                    this.bdj.HR();
                }
                this.bdi = false;
            }
            if (this.bdj != null) {
                this.bdj.onUpdate(getValue(f2));
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
        private float bdo;
        private float bdp;
        private float bdq;

        public g(int i, float f) {
            super(i);
            this.bdo = 0.3f;
            this.bdp = 1.0f;
            this.bdq = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bdq) {
                f2 = (((this.bdp - this.bdo) / this.bdq) * f) + this.bdo;
            } else {
                float f3 = (((-this.bdp) / this.bdq) * f) + (2.0f * this.bdp);
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
        private static float bdn = 0.0f;
        private PointF bcS;
        private PointF bcT;
        private PointF bdl;
        private PointF bdm;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bcS = pointF;
            this.bcT = pointF2;
            this.bdl = pointF3;
            this.bdm = t(bdn);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            dr(i);
            this.bcS = pointF;
            this.bcT = pointF2;
            this.bdl = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bdn) {
                return t(f);
            }
            return a((f - bdn) / (1.0f - bdn), this.bdm, this.bdl, this.bcT);
        }

        public PointF t(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bcS.x;
            pointF.y = (1.0f - f) * this.bcS.y;
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
        return this.bcZ;
    }

    public void setAnimateEndListener(b bVar) {
        this.bcZ = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bcY = z;
    }

    private Bitmap dp(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap dq(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bcX = new ArrayList<>();
        this.bcX.add(dq(a.b.liveshow_video_heart_like1));
        this.bcX.add(dq(a.b.liveshow_video_heart_like2));
        this.bcX.add(dq(a.b.liveshow_video_heart_like3));
        this.bcX.add(dq(a.b.liveshow_video_heart_like4));
        this.bcX.add(dq(a.b.liveshow_video_heart_like5));
        this.bcX.add(dq(a.b.liveshow_video_heart_like6));
        this.bcX.add(dq(a.b.liveshow_video_heart_like7));
        this.bcX.add(dq(a.b.liveshow_video_heart_like8));
        this.bcX.add(dq(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bda != null) {
            this.bda.shutdown();
            this.bda = null;
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
