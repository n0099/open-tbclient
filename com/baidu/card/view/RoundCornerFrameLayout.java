package com.baidu.card.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.SimpleColorFilter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.r.u.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public class RoundCornerFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public RectF f4504e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f4505f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f4506g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f4507h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f4508i;
    public int j;
    public ColorFilter k;
    public ColorFilter l;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.f4505f = new float[8];
        this.f4507h = null;
        this.j = 3;
        b();
    }

    public final void a() {
        if (getMeasuredHeight() <= 0 || getMeasuredWidth() <= 0) {
            return;
        }
        this.f4504e.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        try {
            this.f4508i = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e2) {
            BdLog.e(e2);
            System.gc();
            TbadkCoreApplication.getInst().onLowMemory();
            try {
                this.f4508i = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError unused) {
                BdLog.e(e2);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                return;
            }
        }
        Canvas canvas = new Canvas(this.f4508i);
        canvas.drawColor(-16777216);
        this.f4506g.setColor(-1);
        Path path = new Path();
        path.addRoundRect(this.f4504e, this.f4505f, Path.Direction.CW);
        canvas.drawPath(path, this.f4506g);
        this.f4507h.setImageBitmap(this.f4508i);
        if (this.f4507h.getParent() == null) {
            addView(this.f4507h);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        ImageView imageView = this.f4507h;
        if (imageView == null || view == imageView) {
            return;
        }
        if (imageView.getParent() != null) {
            ((ViewGroup) this.f4507h.getParent()).removeView(this.f4507h);
        }
        super.addView(this.f4507h);
    }

    public final void b() {
        setWillNotDraw(false);
        this.f4504e = new RectF();
        this.f4505f = a.u(R.string.J_X05);
        Paint paint = new Paint();
        this.f4506g = paint;
        paint.setStrokeWidth(0.0f);
        this.f4506g.setStrokeCap(Paint.Cap.ROUND);
        this.f4506g.setAntiAlias(true);
        this.f4506g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        ImageView imageView = new ImageView(getContext());
        this.f4507h = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void c(int i2) {
        if (this.f4507h == null || this.j == i2) {
            return;
        }
        this.j = i2;
        this.k = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0201));
        this.l = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0205));
        this.f4507h.setColorFilter(this.k);
    }

    public void d(boolean z) {
        ImageView imageView = this.f4507h;
        if (imageView != null) {
            imageView.setColorFilter(z ? this.l : this.k);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (!(i2 == i4 && i3 == i5) && i2 > 0 && i3 > 0) {
            Bitmap bitmap = this.f4508i;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f4508i.recycle();
            }
            a();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        ImageView imageView = this.f4507h;
        if (imageView != null) {
            if (imageView.getParent() != null) {
                ((ViewGroup) this.f4507h.getParent()).removeView(this.f4507h);
            }
            super.addView(this.f4507h);
        }
    }

    public void setCorner(float f2) {
        Arrays.fill(this.f4505f, f2);
        Bitmap bitmap = this.f4508i;
        if (bitmap != null) {
            bitmap.recycle();
            a();
        }
    }

    public void setCornerId(int i2) {
        this.f4505f = a.u(i2);
        Bitmap bitmap = this.f4508i;
        if (bitmap != null) {
            bitmap.recycle();
            a();
        }
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4505f = new float[8];
        this.f4507h = null;
        this.j = 3;
        b();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4505f = new float[8];
        this.f4507h = null;
        this.j = 3;
        b();
    }
}
