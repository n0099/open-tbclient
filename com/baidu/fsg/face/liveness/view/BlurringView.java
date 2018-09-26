package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class BlurringView extends View {
    private int a;
    private int b;
    private View c;
    private int d;
    private int e;
    private boolean f;
    private Bitmap g;
    private Bitmap h;
    private Canvas i;
    private RenderScript j;
    private ScriptIntrinsicBlur k;
    private Allocation l;
    private Allocation m;

    public BlurringView(Context context) {
        this(context, null);
    }

    public BlurringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int parseColor = Color.parseColor("#96FFFFFF");
        a(context);
        setBlurRadius(11);
        setDownsampleFactor(6);
        setOverlayColor(parseColor);
    }

    public void setBlurredView(View view) {
        this.c = view;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c != null) {
            if (prepare()) {
                if (this.c.getBackground() != null && (this.c.getBackground() instanceof ColorDrawable)) {
                    this.g.eraseColor(((ColorDrawable) this.c.getBackground()).getColor());
                } else {
                    this.g.eraseColor(0);
                }
                this.c.draw(this.i);
                blur();
                canvas.save();
                canvas.translate(this.c.getX() - getX(), this.c.getY() - getY());
                canvas.scale(this.a, this.a);
                canvas.drawBitmap(this.h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.b);
        }
    }

    public void setBlurRadius(int i) {
        this.k.setRadius(i);
    }

    public void setDownsampleFactor(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
        if (this.a != i) {
            this.a = i;
            this.f = true;
        }
    }

    public void setOverlayColor(int i) {
        this.b = i;
    }

    private void a(Context context) {
        this.j = RenderScript.create(context);
        this.k = ScriptIntrinsicBlur.create(this.j, Element.U8_4(this.j));
    }

    protected boolean prepare() {
        int width = this.c.getWidth();
        int height = this.c.getHeight();
        if (this.i == null || this.f || this.d != width || this.e != height) {
            this.f = false;
            this.d = width;
            this.e = height;
            int i = width / this.a;
            int i2 = height / this.a;
            int i3 = (i - (i % 4)) + 4;
            int i4 = (i2 - (i2 % 4)) + 4;
            if (this.h == null || this.h.getWidth() != i3 || this.h.getHeight() != i4) {
                this.g = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                if (this.g == null) {
                    return false;
                }
                this.h = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                if (this.h == null) {
                    return false;
                }
            }
            this.i = new Canvas(this.g);
            this.i.scale(1.0f / this.a, 1.0f / this.a);
            this.l = Allocation.createFromBitmap(this.j, this.g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.m = Allocation.createTyped(this.j, this.l.getType());
        }
        return true;
    }

    protected void blur() {
        this.l.copyFrom(this.g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.h);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null) {
            this.j.destroy();
        }
    }
}
