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
import com.baidu.live.ad.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private SurfaceHolder bID;
    private c[] bIE;
    private volatile boolean bIF;
    private volatile boolean bIG;
    private Bitmap bIH;
    private Bitmap bII;
    private PointF bIJ;
    private PointF bIK;
    private PointF bIL;
    private PointF bIM;
    private volatile int bIN;
    private ArrayList<Bitmap> bIO;
    private boolean bIP;
    private b bIQ;
    private ExecutorService bIR;
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
        void UW();

        void onOver();

        void onUpdate(Object obj);
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.bIN;
        heartSurfaceView.bIN = i - 1;
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
        this.bIF = false;
        this.bIG = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.bIJ == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0170a.liveshow_heart_start_x);
                    HeartSurfaceView.this.bIJ = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0170a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.bIK = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0170a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.bIL = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.bIM = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0170a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.bID = getHolder();
        this.bID.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bIE = new c[30];
        this.bIH = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.bII = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.bIF = true;
        this.bIG = false;
        this.bIO = new ArrayList<>();
        this.bIO.add(gl(a.b.liveshow_video_heart_like1));
        this.bIO.add(gl(a.b.liveshow_video_heart_like2));
        this.bIO.add(gl(a.b.liveshow_video_heart_like3));
        this.bIO.add(gl(a.b.liveshow_video_heart_like4));
        this.bIO.add(gl(a.b.liveshow_video_heart_like5));
        this.bIO.add(gl(a.b.liveshow_video_heart_like6));
        this.bIO.add(gl(a.b.liveshow_video_heart_like7));
        this.bIO.add(gl(a.b.liveshow_video_heart_like8));
        this.bIO.add(gl(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bIF = true;
        if (this.bIR == null) {
            this.bIR = Executors.newFixedThreadPool(5);
        }
        UT();
        US();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.bIE != null) {
            for (c cVar : this.bIE) {
                if (cVar != null && cVar.UV()) {
                    cVar.de(false);
                }
            }
        }
        this.bIG = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bIG = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.bIG = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.bIF = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void US() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bIF) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.bIF && HeartSurfaceView.this.bIN > 0) {
                        if (HeartSurfaceView.this.UU()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.bIR != null) {
            this.bIR.execute(runnable);
        }
    }

    private void UT() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.bIF) {
                    try {
                        while (HeartSurfaceView.this.bIF && !HeartSurfaceView.this.bIG) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.bIF) {
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
        if (this.bIR != null) {
            this.bIR.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.bIN < 120) {
            this.bIN += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean UU() {
        PointF pointF;
        if (!this.bIG || this.bIL == null || this.bIM == null || this.bIJ == null || this.bIK == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.bIM.x / 2.0f) * nextFloat) + (this.bIM.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bIL.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.bIM.y);
        }
        Bitmap bitmap = this.bIO.get(this.mRandom.nextInt(this.bIO.size()));
        float width = bitmap.getWidth() + ((this.bIK.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.bIP) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.bIK.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.bIP = false;
        }
        return a(bitmap, this.bIJ, new PointF(width, this.bIK.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.bIE.length; i++) {
            if (this.bIE[i] == null) {
                this.bIE[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.bIE[i].bIQ = this.bIQ;
                return true;
            } else if (!this.bIE[i].UV()) {
                this.bIE[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.bIJ != null && this.bIG && (lockCanvas = this.bID.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.bIE) {
                        if (this.bIF && this.bIG) {
                            if (cVar != null && cVar.UV()) {
                                cVar.aI(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.bIT, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.bID.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.bID.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.bID.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private PointF bIJ;
        public b bIQ;
        public RectF bIT;
        private f bIU;
        private g bIV;
        private a bIW;
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
            this.bIJ = pointF;
            this.bIT = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bIT.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bIW = new a(600);
            this.bIW.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void UW() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.de(false);
                }
            });
            this.bIU = new f(pointF, pointF2, pointF3, FeatureCodes.FACE);
            this.bIU.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.bIT.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.bIT.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void UW() {
                    c.this.bIW.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.bIQ != null) {
                        c.this.bIQ.Q((int) c.this.bIT.left, (int) c.this.bIT.top);
                    }
                }
            });
            this.bIU.start();
            this.bIV = new g(240, 0.75f);
            this.bIV.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.bIT.set(c.this.bIJ.x, c.this.bIJ.y, c.this.bIJ.x + (c.this.mWidth * c.this.mScale), c.this.bIJ.y + (c.this.mHeight * c.this.mScale));
                    c.this.bIT.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void UW() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.bIV.start();
            de(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.bIJ = pointF;
            this.bIT.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.bIT.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.bIU.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.bIU.start();
            this.bIV.start();
            de(true);
        }

        public boolean UV() {
            return this.mIsAlive;
        }

        public synchronized void de(boolean z) {
            this.mIsAlive = z;
        }

        public void aI(long j) {
            if (this.bIV.UV()) {
                this.bIV.aI(j);
            }
            if (this.bIU.UV()) {
                this.bIU.aI(j);
            }
            if (this.bIW.UV()) {
                this.bIW.aI(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class e {
        private int bIY;
        private volatile boolean bIZ;
        private d bJa;
        private volatile boolean bJb = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.bIY = i;
        }

        public void gn(int i) {
            this.bIY = i;
        }

        public boolean UV() {
            return this.bJb;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.bIZ = true;
            this.bJb = true;
        }

        public void a(d dVar) {
            this.bJa = dVar;
        }

        public void aI(long j) {
            float f = ((float) (j - this.mStartTime)) / this.bIY;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.bJb = false;
                if (this.bJa != null) {
                    this.bJa.onUpdate(getValue(f2));
                    this.bJa.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.bIZ = true;
            } else if (this.bIZ) {
                if (this.bJa != null) {
                    this.bJa.UW();
                }
                this.bIZ = false;
            }
            if (this.bJa != null) {
                this.bJa.onUpdate(getValue(f2));
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
        private float bJf;
        private float bJg;
        private float bJh;

        public g(int i, float f) {
            super(i);
            this.bJf = 0.3f;
            this.bJg = 1.0f;
            this.bJh = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.bJh) {
                f2 = (((this.bJg - this.bJf) / this.bJh) * f) + this.bJf;
            } else {
                float f3 = (((-this.bJg) / this.bJh) * f) + (2.0f * this.bJg);
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
        private static float bJe = 0.0f;
        private PointF bIJ;
        private PointF bIK;
        private PointF bJc;
        private PointF bJd;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.bIJ = pointF;
            this.bIK = pointF2;
            this.bJc = pointF3;
            this.bJd = E(bJe);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            gn(i);
            this.bIJ = pointF;
            this.bIK = pointF2;
            this.bJc = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < bJe) {
                return E(f);
            }
            return a((f - bJe) / (1.0f - bJe), this.bJd, this.bJc, this.bIK);
        }

        public PointF E(float f) {
            PointF pointF = new PointF();
            pointF.x = this.bIJ.x;
            pointF.y = (1.0f - f) * this.bIJ.y;
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
        return this.bIQ;
    }

    public void setAnimateEndListener(b bVar) {
        this.bIQ = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.bIP = z;
    }

    private Bitmap gl(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap gm(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.bIO = new ArrayList<>();
        this.bIO.add(gm(a.b.liveshow_video_heart_like1));
        this.bIO.add(gm(a.b.liveshow_video_heart_like2));
        this.bIO.add(gm(a.b.liveshow_video_heart_like3));
        this.bIO.add(gm(a.b.liveshow_video_heart_like4));
        this.bIO.add(gm(a.b.liveshow_video_heart_like5));
        this.bIO.add(gm(a.b.liveshow_video_heart_like6));
        this.bIO.add(gm(a.b.liveshow_video_heart_like7));
        this.bIO.add(gm(a.b.liveshow_video_heart_like8));
        this.bIO.add(gm(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.bIR != null) {
            this.bIR.shutdown();
            this.bIR = null;
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
