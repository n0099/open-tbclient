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
import com.baidu.live.v.a;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = HeartSurfaceView.class.getSimpleName();
    private Bitmap aCA;
    private Bitmap aCB;
    private PointF aCC;
    private PointF aCD;
    private PointF aCE;
    private PointF aCF;
    private volatile int aCG;
    private ArrayList<Bitmap> aCH;
    private boolean aCI;
    private b aCJ;
    private ExecutorService aCK;
    private SurfaceHolder aCw;
    private c[] aCx;
    private volatile boolean aCy;
    private volatile boolean aCz;
    private Bitmap mBitmap;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Paint mPaint;
    private Random mRandom;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void H(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface d {
        void onOver();

        void onUpdate(Object obj);

        void zp();
    }

    static /* synthetic */ int g(HeartSurfaceView heartSurfaceView) {
        int i = heartSurfaceView.aCG;
        heartSurfaceView.aCG = i - 1;
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
        this.aCy = false;
        this.aCz = false;
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.widget.HeartSurfaceView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (HeartSurfaceView.this.aCC == null || HeartSurfaceView.this.mViewWidth != HeartSurfaceView.this.getWidth() || HeartSurfaceView.this.mViewHeight != HeartSurfaceView.this.getHeight()) {
                    HeartSurfaceView.this.mViewWidth = HeartSurfaceView.this.getWidth();
                    HeartSurfaceView.this.mViewHeight = HeartSurfaceView.this.getHeight();
                    float dimensionPixelSize = HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0096a.liveshow_heart_start_x);
                    HeartSurfaceView.this.aCC = new PointF(dimensionPixelSize, HeartSurfaceView.this.mViewHeight - HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0096a.liveshow_heart_padding_bottom));
                    HeartSurfaceView.this.aCD = new PointF(dimensionPixelSize, HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0096a.liveshow_heart_padding_top));
                    HeartSurfaceView.this.aCE = new PointF(0.0f, HeartSurfaceView.this.mViewHeight * 0.5f);
                    HeartSurfaceView.this.aCF = new PointF(HeartSurfaceView.this.getResources().getDimensionPixelSize(a.C0096a.liveshow_heart_padding_right) + HeartSurfaceView.this.mViewWidth, HeartSurfaceView.this.mViewHeight * 0.5f);
                }
            }
        };
        initial();
    }

    private void initial() {
        this.aCw = getHolder();
        this.aCw.addCallback(this);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aCx = new c[30];
        this.aCA = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_blue));
        this.aCB = drawableToBitmap(getResources().getDrawable(a.b.liveshow_heart_red));
        this.mRandom = new Random();
        this.aCy = true;
        this.aCz = false;
        this.aCH = new ArrayList<>();
        this.aCH.add(cJ(a.b.liveshow_video_heart_like1));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like2));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like3));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like4));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like5));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like6));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like7));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like8));
        this.aCH.add(cJ(a.b.liveshow_video_heart_like9));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aCy = true;
        if (this.aCK == null) {
            this.aCK = Executors.newFixedThreadPool(5);
        }
        zm();
        zl();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c[] cVarArr;
        if (this.aCx != null) {
            for (c cVar : this.aCx) {
                if (cVar != null && cVar.zo()) {
                    cVar.bs(false);
                }
            }
        }
        this.aCz = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.aCz = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (i != 0) {
            this.aCz = false;
        }
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.aCy = false;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        release();
    }

    private void zl() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aCy) {
                    SystemClock.sleep(10L);
                    while (HeartSurfaceView.this.aCy && HeartSurfaceView.this.aCG > 0) {
                        if (HeartSurfaceView.this.zn()) {
                            HeartSurfaceView.g(HeartSurfaceView.this);
                        }
                        SystemClock.sleep(150L);
                    }
                }
            }
        };
        if (this.aCK != null) {
            this.aCK.execute(runnable);
        }
    }

    private void zm() {
        Runnable runnable = new Runnable() { // from class: com.baidu.live.widget.HeartSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                while (HeartSurfaceView.this.aCy) {
                    try {
                        while (HeartSurfaceView.this.aCy && !HeartSurfaceView.this.aCz) {
                            SystemClock.sleep(300L);
                        }
                        if (HeartSurfaceView.this.aCy) {
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
        if (this.aCK != null) {
            this.aCK.execute(runnable);
        }
    }

    public void addHeart(int i) {
        if (this.aCG < 120) {
            this.aCG += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zn() {
        PointF pointF;
        if (!this.aCz || this.aCE == null || this.aCF == null || this.aCC == null || this.aCD == null) {
            return false;
        }
        float nextFloat = this.mRandom.nextFloat();
        if (nextFloat == 0.0f) {
            nextFloat = 1.0f;
        }
        float f2 = ((this.aCF.x / 2.0f) * nextFloat) + (this.aCF.x / 4.0f);
        if (this.mRandom.nextBoolean()) {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aCE.y);
        } else {
            pointF = new PointF(f2, ((nextFloat * 0.6f) + 0.7f) * this.aCF.y);
        }
        Bitmap bitmap = this.aCH.get(this.mRandom.nextInt(this.aCH.size()));
        float width = bitmap.getWidth() + ((this.aCD.x + bitmap.getWidth()) * this.mRandom.nextFloat());
        if (this.aCI) {
            if (this.mBitmap != null && this.mRandom.nextFloat() <= 0.1f) {
                bitmap = this.mBitmap;
            }
            width = bitmap.getWidth() + ((this.aCD.x + (bitmap.getWidth() / 2)) * this.mRandom.nextFloat());
            this.aCI = false;
        }
        return a(bitmap, this.aCC, new PointF(width, this.aCD.y + ((this.mViewHeight / 6) * this.mRandom.nextFloat())), pointF);
    }

    private boolean a(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
        for (int i = 0; i < this.aCx.length; i++) {
            if (this.aCx[i] == null) {
                this.aCx[i] = new c(bitmap, pointF, pointF2, pointF3);
                this.aCx[i].aCJ = this.aCJ;
                return true;
            } else if (!this.aCx[i].zo()) {
                this.aCx[i].b(bitmap, pointF, pointF2, pointF3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Canvas lockCanvas;
        c[] cVarArr;
        if (this.aCC != null && this.aCz && (lockCanvas = this.aCw.lockCanvas()) != null) {
            try {
                try {
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (c cVar : this.aCx) {
                        if (this.aCy && this.aCz) {
                            if (cVar != null && cVar.zo()) {
                                cVar.O(currentTimeMillis);
                                this.mPaint.setAlpha(cVar.alpha);
                                lockCanvas.drawBitmap(cVar.bitmap, (Rect) null, cVar.aCM, this.mPaint);
                            }
                        }
                    }
                    try {
                        this.aCw.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        this.aCw.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    this.aCw.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private PointF aCC;
        public b aCJ;
        public RectF aCM;
        private f aCN;
        private g aCO;
        private a aCP;
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
            this.aCC = pointF;
            this.aCM = new RectF(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aCM.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aCP = new a(Constants.HTTP_DNS_INAVAILABLE_TIME);
            this.aCP.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.1
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.alpha = ((Integer) obj).intValue();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void zp() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    c.this.bs(false);
                }
            });
            this.aCN = new f(pointF, pointF2, pointF3, 1200);
            this.aCN.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.2
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    PointF pointF4 = (PointF) obj;
                    c.this.aCM.set(pointF4.x, pointF4.y, pointF4.x + (c.this.mWidth * c.this.mScale), pointF4.y + (c.this.mHeight * c.this.mScale));
                    c.this.aCM.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void zp() {
                    c.this.aCP.start();
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                    if (c.this.aCJ != null) {
                        c.this.aCJ.H((int) c.this.aCM.left, (int) c.this.aCM.top);
                    }
                }
            });
            this.aCN.start();
            this.aCO = new g(240, 0.75f);
            this.aCO.a(new d() { // from class: com.baidu.live.widget.HeartSurfaceView.c.3
                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onUpdate(Object obj) {
                    c.this.mScale = ((Float) obj).floatValue();
                    c.this.aCM.set(c.this.aCC.x, c.this.aCC.y, c.this.aCC.x + (c.this.mWidth * c.this.mScale), c.this.aCC.y + (c.this.mHeight * c.this.mScale));
                    c.this.aCM.offset(((-c.this.mWidth) * c.this.mScale) / 2.0f, ((-c.this.mHeight) * c.this.mScale) / 2.0f);
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void zp() {
                }

                @Override // com.baidu.live.widget.HeartSurfaceView.d
                public void onOver() {
                }
            });
            this.aCO.start();
            bs(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Bitmap bitmap, PointF pointF, PointF pointF2, PointF pointF3) {
            this.bitmap = bitmap;
            this.mHeight = this.bitmap.getHeight();
            this.mWidth = this.bitmap.getWidth();
            this.alpha = 255;
            this.mScale = 0.0f;
            this.aCC = pointF;
            this.aCM.set(pointF.x, pointF.y, pointF.x + this.mWidth, pointF.y + this.mHeight);
            this.aCM.offset((-this.mWidth) / 2, (-this.mHeight) / 2);
            this.aCN.a(pointF, pointF2, pointF3, TbConfig.HEAD_IMG_SIZE);
            this.aCN.start();
            this.aCO.start();
            bs(true);
        }

        public boolean zo() {
            return this.mIsAlive;
        }

        public synchronized void bs(boolean z) {
            this.mIsAlive = z;
        }

        public void O(long j) {
            if (this.aCO.zo()) {
                this.aCO.O(j);
            }
            if (this.aCN.zo()) {
                this.aCN.O(j);
            }
            if (this.aCP.zo()) {
                this.aCP.O(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class e {
        private int aCR;
        private volatile boolean aCS;
        private d aCT;
        private volatile boolean aCU = false;
        private long mStartTime;

        protected abstract Object getValue(float f);

        public e(int i) {
            this.aCR = i;
        }

        public void cL(int i) {
            this.aCR = i;
        }

        public boolean zo() {
            return this.aCU;
        }

        public void start() {
            this.mStartTime = System.currentTimeMillis();
            this.aCS = true;
            this.aCU = true;
        }

        public void a(d dVar) {
            this.aCT = dVar;
        }

        public void O(long j) {
            float f = ((float) (j - this.mStartTime)) / this.aCR;
            float f2 = f >= 0.0f ? f : 0.0f;
            if (f2 >= 1.0f) {
                this.aCU = false;
                if (this.aCT != null) {
                    this.aCT.onUpdate(getValue(f2));
                    this.aCT.onOver();
                    return;
                }
                return;
            }
            if (f2 < 0.5d) {
                this.aCS = true;
            } else if (this.aCS) {
                if (this.aCT != null) {
                    this.aCT.zp();
                }
                this.aCS = false;
            }
            if (this.aCT != null) {
                this.aCT.onUpdate(getValue(f2));
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
    /* loaded from: classes2.dex */
    public static class g extends e {
        private float aCY;
        private float aCZ;
        private float aDa;

        public g(int i, float f) {
            super(i);
            this.aCY = 0.3f;
            this.aCZ = 1.0f;
            this.aDa = f;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            float f2 = 1.0f;
            if (f < this.aDa) {
                f2 = (((this.aCZ - this.aCY) / this.aDa) * f) + this.aCY;
            } else {
                float f3 = (((-this.aCZ) / this.aDa) * f) + (2.0f * this.aCZ);
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
        private static float aCX = 0.0f;
        private PointF aCC;
        private PointF aCD;
        private PointF aCV;
        private PointF aCW;

        public f(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            super(i);
            this.aCC = pointF;
            this.aCD = pointF2;
            this.aCV = pointF3;
            this.aCW = M(aCX);
        }

        public void a(PointF pointF, PointF pointF2, PointF pointF3, int i) {
            cL(i);
            this.aCC = pointF;
            this.aCD = pointF2;
            this.aCV = pointF3;
        }

        @Override // com.baidu.live.widget.HeartSurfaceView.e
        protected Object getValue(float f) {
            if (f < aCX) {
                return M(f);
            }
            return a((f - aCX) / (1.0f - aCX), this.aCW, this.aCV, this.aCD);
        }

        public PointF M(float f) {
            PointF pointF = new PointF();
            pointF.x = this.aCC.x;
            pointF.y = (1.0f - f) * this.aCC.y;
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
        return this.aCJ;
    }

    public void setAnimateEndListener(b bVar) {
        this.aCJ = bVar;
    }

    public void setUserPortrait(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setClickBySelf(boolean z) {
        this.aCI = z;
    }

    private Bitmap cJ(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    private Bitmap cK(int i) {
        return drawableToBitmap(getResources().getDrawable(i));
    }

    public void setUpResNormalMode() {
        this.aCH = new ArrayList<>();
        this.aCH.add(cK(a.b.liveshow_video_heart_like1));
        this.aCH.add(cK(a.b.liveshow_video_heart_like2));
        this.aCH.add(cK(a.b.liveshow_video_heart_like3));
        this.aCH.add(cK(a.b.liveshow_video_heart_like4));
        this.aCH.add(cK(a.b.liveshow_video_heart_like5));
        this.aCH.add(cK(a.b.liveshow_video_heart_like6));
        this.aCH.add(cK(a.b.liveshow_video_heart_like7));
        this.aCH.add(cK(a.b.liveshow_video_heart_like8));
        this.aCH.add(cK(a.b.liveshow_video_heart_like9));
    }

    public void release() {
        if (this.aCK != null) {
            this.aCK.shutdown();
            this.aCK = null;
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
