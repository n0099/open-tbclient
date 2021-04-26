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
    public int f6234a;

    /* renamed from: b  reason: collision with root package name */
    public int f6235b;

    /* renamed from: c  reason: collision with root package name */
    public View f6236c;

    /* renamed from: d  reason: collision with root package name */
    public int f6237d;

    /* renamed from: e  reason: collision with root package name */
    public int f6238e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6239f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f6240g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f6241h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f6242i;
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
        this.l.copyFrom(this.f6240g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.f6241h);
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
        if (this.f6236c != null) {
            if (prepare()) {
                if (this.f6236c.getBackground() != null && (this.f6236c.getBackground() instanceof ColorDrawable)) {
                    this.f6240g.eraseColor(((ColorDrawable) this.f6236c.getBackground()).getColor());
                } else {
                    this.f6240g.eraseColor(0);
                }
                this.f6236c.draw(this.f6242i);
                blur();
                canvas.save();
                canvas.translate(this.f6236c.getX() - getX(), this.f6236c.getY() - getY());
                int i2 = this.f6234a;
                canvas.scale(i2, i2);
                canvas.drawBitmap(this.f6241h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.f6235b);
        }
    }

    public boolean prepare() {
        int width = this.f6236c.getWidth();
        int height = this.f6236c.getHeight();
        if (this.f6242i == null || this.f6239f || this.f6237d != width || this.f6238e != height) {
            this.f6239f = false;
            this.f6237d = width;
            this.f6238e = height;
            int i2 = this.f6234a;
            int i3 = width / i2;
            int i4 = height / i2;
            int i5 = (i3 - (i3 % 4)) + 4;
            int i6 = (i4 - (i4 % 4)) + 4;
            Bitmap bitmap = this.f6241h;
            if (bitmap == null || bitmap.getWidth() != i5 || this.f6241h.getHeight() != i6) {
                Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f6240g = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f6241h = createBitmap2;
                if (createBitmap2 == null) {
                    return false;
                }
            }
            Canvas canvas = new Canvas(this.f6240g);
            this.f6242i = canvas;
            int i7 = this.f6234a;
            canvas.scale(1.0f / i7, 1.0f / i7);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.j, this.f6240g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.l = createFromBitmap;
            this.m = Allocation.createTyped(this.j, createFromBitmap.getType());
        }
        return true;
    }

    public void setBlurRadius(int i2) {
        this.k.setRadius(i2);
    }

    public void setBlurredView(View view) {
        this.f6236c = view;
    }

    public void setDownsampleFactor(int i2) {
        if (i2 > 0) {
            if (this.f6234a != i2) {
                this.f6234a = i2;
                this.f6239f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int i2) {
        this.f6235b = i2;
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
