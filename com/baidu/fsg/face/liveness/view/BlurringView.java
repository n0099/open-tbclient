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
/* loaded from: classes2.dex */
public class BlurringView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f6063a;

    /* renamed from: b  reason: collision with root package name */
    public int f6064b;

    /* renamed from: c  reason: collision with root package name */
    public View f6065c;

    /* renamed from: d  reason: collision with root package name */
    public int f6066d;

    /* renamed from: e  reason: collision with root package name */
    public int f6067e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6068f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f6069g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f6070h;
    public Canvas i;
    public RenderScript j;
    public ScriptIntrinsicBlur k;
    public Allocation l;
    public Allocation m;

    public BlurringView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        RenderScript create = RenderScript.create(context);
        this.j = create;
        this.k = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
    }

    public void blur() {
        this.l.copyFrom(this.f6069g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.f6070h);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RenderScript renderScript = this.j;
        if (renderScript != null) {
            renderScript.destroy();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6065c != null) {
            if (prepare()) {
                if (this.f6065c.getBackground() != null && (this.f6065c.getBackground() instanceof ColorDrawable)) {
                    this.f6069g.eraseColor(((ColorDrawable) this.f6065c.getBackground()).getColor());
                } else {
                    this.f6069g.eraseColor(0);
                }
                this.f6065c.draw(this.i);
                blur();
                canvas.save();
                canvas.translate(this.f6065c.getX() - getX(), this.f6065c.getY() - getY());
                int i = this.f6063a;
                canvas.scale(i, i);
                canvas.drawBitmap(this.f6070h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.f6064b);
        }
    }

    public boolean prepare() {
        int width = this.f6065c.getWidth();
        int height = this.f6065c.getHeight();
        if (this.i == null || this.f6068f || this.f6066d != width || this.f6067e != height) {
            this.f6068f = false;
            this.f6066d = width;
            this.f6067e = height;
            int i = this.f6063a;
            int i2 = width / i;
            int i3 = height / i;
            int i4 = (i2 - (i2 % 4)) + 4;
            int i5 = (i3 - (i3 % 4)) + 4;
            Bitmap bitmap = this.f6070h;
            if (bitmap == null || bitmap.getWidth() != i4 || this.f6070h.getHeight() != i5) {
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                this.f6069g = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                this.f6070h = createBitmap2;
                if (createBitmap2 == null) {
                    return false;
                }
            }
            Canvas canvas = new Canvas(this.f6069g);
            this.i = canvas;
            int i6 = this.f6063a;
            canvas.scale(1.0f / i6, 1.0f / i6);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.j, this.f6069g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.l = createFromBitmap;
            this.m = Allocation.createTyped(this.j, createFromBitmap.getType());
        }
        return true;
    }

    public void setBlurRadius(int i) {
        this.k.setRadius(i);
    }

    public void setBlurredView(View view) {
        this.f6065c = view;
    }

    public void setDownsampleFactor(int i) {
        if (i > 0) {
            if (this.f6063a != i) {
                this.f6063a = i;
                this.f6068f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int i) {
        this.f6064b = i;
    }

    public BlurringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int parseColor = Color.parseColor("#96FFFFFF");
        a(context);
        setBlurRadius(11);
        setDownsampleFactor(6);
        setOverlayColor(parseColor);
    }
}
