package com.baidu.ar.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.f;
import com.baidu.ar.util.o;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class ScanView extends View {
    Path a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Paint f;
    private Matrix g;
    private Drawable h;
    private Thread i;
    private a j;
    private Context k;
    private Shader l;
    private int[] m;
    private int[] n;
    private int[] o;
    private boolean p;
    private boolean q;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private WeakReference<ScanView> a;

        public a(ScanView scanView) {
            this.a = null;
            this.a = new WeakReference<>(scanView);
        }

        public void a() {
            if (this.a != null) {
                this.a.clear();
            }
            this.a = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanView scanView;
            if (this.a == null || (scanView = this.a.get()) == null) {
                return;
            }
            while (scanView.c()) {
                scanView.d();
                try {
                    Thread.sleep(60L);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public ScanView(Context context) {
        super(context);
        this.b = SubsamplingScaleImageView.ORIENTATION_180;
        this.h = null;
        this.j = null;
        this.l = null;
        this.m = new int[]{Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#662cccf8")};
        this.n = new int[]{Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#66ff3957")};
        this.o = new int[]{Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#6600b9ff")};
        this.p = false;
        this.a = null;
        this.q = false;
        a(null, context);
    }

    public ScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = SubsamplingScaleImageView.ORIENTATION_180;
        this.h = null;
        this.j = null;
        this.l = null;
        this.m = new int[]{Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#662cccf8")};
        this.n = new int[]{Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#66ff3957")};
        this.o = new int[]{Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#6600b9ff")};
        this.p = false;
        this.a = null;
        this.q = false;
        a(attributeSet, context);
    }

    public ScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = SubsamplingScaleImageView.ORIENTATION_180;
        this.h = null;
        this.j = null;
        this.l = null;
        this.m = new int[]{Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#662cccf8")};
        this.n = new int[]{Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#66ff3957")};
        this.o = new int[]{Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#6600b9ff")};
        this.p = false;
        this.a = null;
        this.q = false;
        a(attributeSet, context);
    }

    @TargetApi(21)
    public ScanView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = SubsamplingScaleImageView.ORIENTATION_180;
        this.h = null;
        this.j = null;
        this.l = null;
        this.m = new int[]{Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#002cccf8"), Color.parseColor("#662cccf8")};
        this.n = new int[]{Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#00ff3957"), Color.parseColor("#66ff3957")};
        this.o = new int[]{Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#0000b9ff"), Color.parseColor("#6600b9ff")};
        this.p = false;
        this.a = null;
        this.q = false;
        a(attributeSet, context);
    }

    private Path a(float f) {
        if (this.q) {
            this.a = null;
        } else if (this.a != null) {
            return this.a;
        }
        RectF rectF = new RectF();
        rectF.set(getLeft(), getTop(), getRight(), getBottom());
        float width = rectF.width() / 2.0f;
        float height = rectF.height() / 2.0f;
        float sqrt = ((float) (Math.sqrt(Math.pow(rectF.width(), 2.0d) + Math.pow(rectF.height(), 2.0d)) + 0.5d)) - Math.min(rectF.width(), rectF.height());
        float a2 = o.a(getContext(), 30.0f);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(width - a2, height - a2);
        RectF rectF3 = new RectF(rectF2);
        rectF3.inset(-sqrt, -sqrt);
        if (this.a == null) {
            this.a = new Path();
        }
        Path path = this.a;
        if (f >= 360.0f || f <= -360.0f) {
            path.addOval(rectF3, Path.Direction.CW);
            path.addOval(rectF2, Path.Direction.CCW);
            return path;
        }
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(width + a2, height);
        path.lineTo(width + a2 + sqrt, height);
        path.arcTo(rectF3, 0.0f, f, false);
        path.arcTo(rectF2, f, -f, false);
        path.close();
        return path;
    }

    private void a(Canvas canvas) {
        if (this.h == null) {
            this.h = Res.getDrawable("bdar_drawable_scan_center");
        }
        Bitmap bitmap = ((BitmapDrawable) this.h).getBitmap();
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect((getWidth() - bitmap.getWidth()) / 2, (getHeight() - bitmap.getHeight()) / 2, (getWidth() + bitmap.getWidth()) / 2, (getHeight() + bitmap.getHeight()) / 2), (Paint) null);
    }

    private void a(AttributeSet attributeSet, Context context) {
        this.k = context;
        e();
        this.g = new Matrix();
        this.h = Res.getDrawable("bdar_drawable_scan_center");
    }

    private void e() {
        this.f = new Paint();
        this.f.setColor(-1);
        this.f.setAntiAlias(true);
    }

    public void a() {
        this.p = true;
        setVisibility(0);
        if ((this.i == null || !this.i.isAlive()) && this.j != null) {
            this.i = new Thread(this.j);
            this.i.start();
        }
    }

    public void b() {
        this.p = false;
        this.b = SubsamplingScaleImageView.ORIENTATION_180;
        setVisibility(8);
        if (this.i != null) {
            this.i.interrupt();
            this.i = null;
        }
    }

    public boolean c() {
        return this.p;
    }

    public void d() {
        this.b += 6;
        this.g = new Matrix();
        this.g.postRotate(this.b, this.c, this.d);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        this.j = new a(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        b();
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p) {
            canvas.save();
            if (f.b(this.k)) {
                this.l = new SweepGradient(this.c, this.d, this.n, (float[]) null);
            } else if (f.c(this.k)) {
                this.l = new SweepGradient(this.c, this.d, this.o, (float[]) null);
            } else {
                this.l = new SweepGradient(this.c, this.d, this.m, (float[]) null);
            }
            this.f.setShader(this.l);
            canvas.concat(this.g);
            canvas.drawPath(a(360.0f), this.f);
            canvas.restore();
            a(canvas);
        }
        this.q = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i / 2;
        this.d = i2 / 2;
        this.e = Math.max(i, i2);
        this.q = true;
    }
}
