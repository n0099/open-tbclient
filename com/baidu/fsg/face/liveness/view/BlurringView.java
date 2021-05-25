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
    public int f5988a;

    /* renamed from: b  reason: collision with root package name */
    public int f5989b;

    /* renamed from: c  reason: collision with root package name */
    public View f5990c;

    /* renamed from: d  reason: collision with root package name */
    public int f5991d;

    /* renamed from: e  reason: collision with root package name */
    public int f5992e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5993f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f5994g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f5995h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f5996i;
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
        this.l.copyFrom(this.f5994g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.f5995h);
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
        if (this.f5990c != null) {
            if (prepare()) {
                if (this.f5990c.getBackground() != null && (this.f5990c.getBackground() instanceof ColorDrawable)) {
                    this.f5994g.eraseColor(((ColorDrawable) this.f5990c.getBackground()).getColor());
                } else {
                    this.f5994g.eraseColor(0);
                }
                this.f5990c.draw(this.f5996i);
                blur();
                canvas.save();
                canvas.translate(this.f5990c.getX() - getX(), this.f5990c.getY() - getY());
                int i2 = this.f5988a;
                canvas.scale(i2, i2);
                canvas.drawBitmap(this.f5995h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.f5989b);
        }
    }

    public boolean prepare() {
        int width = this.f5990c.getWidth();
        int height = this.f5990c.getHeight();
        if (this.f5996i == null || this.f5993f || this.f5991d != width || this.f5992e != height) {
            this.f5993f = false;
            this.f5991d = width;
            this.f5992e = height;
            int i2 = this.f5988a;
            int i3 = width / i2;
            int i4 = height / i2;
            int i5 = (i3 - (i3 % 4)) + 4;
            int i6 = (i4 - (i4 % 4)) + 4;
            Bitmap bitmap = this.f5995h;
            if (bitmap == null || bitmap.getWidth() != i5 || this.f5995h.getHeight() != i6) {
                Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f5994g = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f5995h = createBitmap2;
                if (createBitmap2 == null) {
                    return false;
                }
            }
            Canvas canvas = new Canvas(this.f5994g);
            this.f5996i = canvas;
            int i7 = this.f5988a;
            canvas.scale(1.0f / i7, 1.0f / i7);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.j, this.f5994g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.l = createFromBitmap;
            this.m = Allocation.createTyped(this.j, createFromBitmap.getType());
        }
        return true;
    }

    public void setBlurRadius(int i2) {
        this.k.setRadius(i2);
    }

    public void setBlurredView(View view) {
        this.f5990c = view;
    }

    public void setDownsampleFactor(int i2) {
        if (i2 > 0) {
            if (this.f5988a != i2) {
                this.f5988a = i2;
                this.f5993f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int i2) {
        this.f5989b = i2;
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
