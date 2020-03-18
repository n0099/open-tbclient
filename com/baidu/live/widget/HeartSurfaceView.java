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
    private SurfaceHolder aGT;
    private c[] aGU;
    private volatile boolean aGV;
    private volatile boolean aGW;
    private Bitmap aGX;
    private Bitmap aGY;
    private PointF aGZ;
    private PointF aHa;
    private PointF aHb;
    private PointF aHc;
    private volatile int aHd;
    private ArrayList<Bitmap> aHe;
    private boolean aHf;
    private b aHg;
    private ExecutorService aHh;
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
        void BO();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.aHd;
        heartSurfaceView.aHd = i - 1;
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
        this.aGV = false;
        this.aGW = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.aGZ == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_start_x);
                    HeartSurfaceView.this.aGZ = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.aHa = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.aHb = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.aHc = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0107a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.aGT = getHolder();
        this.aGT.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aGU = new c[30];
        this.aGX = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.aGY = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.aGV = true;
        this.aGW = false;
        this.aHe = new ArrayList<>();
        this.aHe.add(cZ(a.b.liveshow_video_heart_like1));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like2));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like3));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like4));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like5));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like6));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like7));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like8));
        this.aHe.add(cZ(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aGV = true;
        if (this.aHh == null) {
            this.aHh = Executors.newFixedThreadPool(5);
        }
        BL();
        BK();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.aGU != null) {
            for (c cVar : this.aGU) {
                if (cVar != null && cVar.BN()) {
                    cVar.bB(false);
                }
            }
        }
        this.aGW = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aGW = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.aGW = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.aGV = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void BK() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGV) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.aGV && HeartSurfaceView.this.aHd > 0) {
                        if (HeartSurfaceView.this.BM()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.aHh != null) {
            this.aHh.execute(runnable);
        }
    }

    private void BL() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aGV) {
                    try {
                        while (HeartSurfaceView.this.aGV && !HeartSurfaceView.this.aGW) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.aGV) {
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
        if (this.aHh != null) {
            this.aHh.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.aHd < 120) {
            this.aHd += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BM() {
        PointF pointF;
        if (!this.aGW || this.aHb == null || this.aHc == null || this.aGZ == null || this.aHa == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.aHc.x / 2.0f) * nextFloat) + (this.aHc.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aHb.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aHc.y);
        }
        Bitmap bitmap = this.aHe.get(this.mRandom.nextInt(this.aHe.size()));
        float width = bitmap.getWidth() + ((this.aHa.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.aHf) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.aHa.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.aHf = false;
        }
        return a(bitmap, this.aGZ, new PointF(width, this.aHa.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.aGU.length; i++) {
            if (this.aGU[i] == null) {
                this.aGU[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.aGU[i].aHg = this.aHg;
                return true;
            } else if (!this.aGU[i].BN()) {
                this.aGU[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.aGZ != null && this.aGW && (lockCanvas = this.aGT.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.aGU) {
                        if (this.aGV && this.aGW) {
                            if (cVar != null && cVar.BN()) {
                                cVar.S(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.aHj, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.aGT.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.aGT.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.aGT.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private PointF aGZ;
        public b aHg;
        public RectF aHj;
        private f aHk;
        private g aHl;
        private a aHm;
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
            this.aGZ = pointF;
            this.aHj = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aHj.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aHm = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.aHm.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BO() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.bB(false);
                }
            });
            this.aHk = new f(pointF, pointF2, pointF3, 1200);
            this.aHk.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.aHj.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.aHj.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BO() {
                    c.this.aHm.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.aHg != null) {
                        c.this.aHg.I((int) c.this.aHj.left, (int) c.this.aHj.top);
                    }
                }
            });
            this.aHk.start();
            this.aHl = new g(240, 0.75f);
            this.aHl.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.aHj.set(c.this.aGZ.x, c.this.aGZ.y, c.this.aGZ.x + (c.this.mWidth * c.this.mScale), c.this.aGZ.y + (c.this.mHeight * c.this.mScale));
                    c.this.aHj.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void BO() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aHl.start();
            bB(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.aGZ = pointF;
            this.aHj.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aHj.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aHk.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.aHk.start();
            this.aHl.start();
            bB(true);
        }

        public boolean BN() {
            return this.mIsAlive;
        }

        public synchronized void bB(boolean z) {
            this.mIsAlive = z;
        }

        public void S(long j) {
            if (this.aHl.BN()) {
                this.aHl.S(j);
            }
            if (this.aHk.BN()) {
                this.aHk.S(j);
            }
            if (this.aHm.BN()) {
                this.aHm.S(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private int aHo;
        private volatile boolean aHp;
        private d aHq;
        private volatile boolean aHr = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.aHo = i;
        }

        public void db(int i) {
            this.aHo = i;
        }

        public boolean BN() {
            return this.aHr;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.aHp = true;
            this.aHr = true;
        }

        public void a(d dVar) {
            this.aHq = dVar;
        }

        public void S(long j) {
            float f = ((float) (j - this.mStartTime)) / this.aHo;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.aHr = false;
                if (this.aHq != null) {
                    this.aHq.onUpdate(getValue(f2));
                    this.aHq.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.aHp = true;
            } else if (this.aHp) {
                if (this.aHq != null) {
                    this.aHq.BO();
                }
                this.aHp = false;
            }
            if (this.aHq != null) {
                this.aHq.onUpdate(getValue(f2));
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
        private float aHv;
        private float aHw;
        private float aHx;

        public g(int i, float f) {
            super(i);
            this.aHv = 0.3f;
            this.aHw = 1.0f;
            this.aHx = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.aHx) {
                f2 = (((this.aHw - this.aHv) / this.aHx) * f) + this.aHv;
            } else {
                float f3 = (((-this.aHw) / this.aHx) * f) + (2.0f * this.aHw);
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
        private static float aHu = 0.0f;
        private PointF aGZ;
        private PointF aHa;
        private PointF aHs;
        private PointF aHt;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.aGZ = pointF;
            this.aHa = pointF2;
            this.aHs = pointF3;
            this.aHt = M(aHu);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            db(i);
            this.aGZ = pointF;
            this.aHa = pointF2;
            this.aHs = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < aHu) {
                return M(f);
            }
            return a((f - aHu) / (1.0f - aHu), this.aHt, this.aHs, this.aHa);
        }

        public PointF M(float f) {
            PointF pointF = new PointF();
            pointF.x = this.aGZ.x;
            pointF.y = (1.0f - f) * this.aGZ.y;
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
        return this.aHg;
    }

    public void setAnimateEndListener(b bVar) {
        this.aHg = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.aHf = z;
    }

    private Bitmap cZ(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap da(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.aHe = new ArrayList<>();
        this.aHe.add(da(a.b.liveshow_video_heart_like1));
        this.aHe.add(da(a.b.liveshow_video_heart_like2));
        this.aHe.add(da(a.b.liveshow_video_heart_like3));
        this.aHe.add(da(a.b.liveshow_video_heart_like4));
        this.aHe.add(da(a.b.liveshow_video_heart_like5));
        this.aHe.add(da(a.b.liveshow_video_heart_like6));
        this.aHe.add(da(a.b.liveshow_video_heart_like7));
        this.aHe.add(da(a.b.liveshow_video_heart_like8));
        this.aHe.add(da(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.aHh != null) {
            this.aHh.shutdown();
            this.aHh = null;
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
