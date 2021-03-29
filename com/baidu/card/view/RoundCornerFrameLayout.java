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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.a.o;
import d.b.h0.r.u.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public class RoundCornerFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public RectF f4516e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f4517f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f4518g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f4519h;
    public Bitmap i;
    public int j;
    public ColorFilter k;
    public ColorFilter l;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        this.f4517f = new float[8];
        this.f4519h = null;
        this.j = 3;
        b();
    }

    public final void a() {
        if (getMeasuredHeight() <= 0 || getMeasuredWidth() <= 0) {
            return;
        }
        this.f4516e.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        try {
            this.i = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e2) {
            BdLog.e(e2);
            System.gc();
            TbadkCoreApplication.getInst().onLowMemory();
            try {
                this.i = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError unused) {
                BdLog.e(e2);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                return;
            }
        }
        Canvas canvas = new Canvas(this.i);
        canvas.drawColor(-16777216);
        this.f4518g.setColor(-1);
        Path path = new Path();
        path.addRoundRect(this.f4516e, this.f4517f, Path.Direction.CW);
        canvas.drawPath(path, this.f4518g);
        this.f4519h.setImageBitmap(this.i);
        if (this.f4519h.getParent() == null) {
            addView(this.f4519h);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        ImageView imageView = this.f4519h;
        if (imageView == null || view == imageView) {
            return;
        }
        if (imageView.getParent() != null) {
            ((ViewGroup) this.f4519h.getParent()).removeView(this.f4519h);
        }
        super.addView(this.f4519h);
    }

    public final void b() {
        setWillNotDraw(false);
        this.f4516e = new RectF();
        this.f4517f = a.u(R.string.J_X05);
        Paint paint = new Paint();
        this.f4518g = paint;
        paint.setStrokeWidth(0.0f);
        this.f4518g.setStrokeCap(Paint.Cap.ROUND);
        this.f4518g.setAntiAlias(true);
        this.f4518g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        ImageView imageView = new ImageView(getContext());
        this.f4519h = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void c(int i) {
        if (this.f4519h == null || this.j == i) {
            return;
        }
        this.j = i;
        this.k = new o(SkinManager.getColor(R.color.CAM_X0201));
        this.l = new o(SkinManager.getColor(R.color.CAM_X0205));
        this.f4519h.setColorFilter(this.k);
    }

    public void d(boolean z) {
        ImageView imageView = this.f4519h;
        if (imageView != null) {
            imageView.setColorFilter(z ? this.l : this.k);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == i3 && i2 == i4) && i > 0 && i2 > 0) {
            Bitmap bitmap = this.i;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.i.recycle();
            }
            a();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        ImageView imageView = this.f4519h;
        if (imageView != null) {
            if (imageView.getParent() != null) {
                ((ViewGroup) this.f4519h.getParent()).removeView(this.f4519h);
            }
            super.addView(this.f4519h);
        }
    }

    public void setCorner(float f2) {
        Arrays.fill(this.f4517f, f2);
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            bitmap.recycle();
            a();
        }
    }

    public void setCornerId(int i) {
        this.f4517f = a.u(i);
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            bitmap.recycle();
            a();
        }
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4517f = new float[8];
        this.f4519h = null;
        this.j = 3;
        b();
    }

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4517f = new float[8];
        this.f4519h = null;
        this.j = 3;
        b();
    }
}
