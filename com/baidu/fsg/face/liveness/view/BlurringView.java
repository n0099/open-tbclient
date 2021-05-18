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
    public int f6088a;

    /* renamed from: b  reason: collision with root package name */
    public int f6089b;

    /* renamed from: c  reason: collision with root package name */
    public View f6090c;

    /* renamed from: d  reason: collision with root package name */
    public int f6091d;

    /* renamed from: e  reason: collision with root package name */
    public int f6092e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6093f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f6094g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f6095h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f6096i;
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
        this.l.copyFrom(this.f6094g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.f6095h);
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
        if (this.f6090c != null) {
            if (prepare()) {
                if (this.f6090c.getBackground() != null && (this.f6090c.getBackground() instanceof ColorDrawable)) {
                    this.f6094g.eraseColor(((ColorDrawable) this.f6090c.getBackground()).getColor());
                } else {
                    this.f6094g.eraseColor(0);
                }
                this.f6090c.draw(this.f6096i);
                blur();
                canvas.save();
                canvas.translate(this.f6090c.getX() - getX(), this.f6090c.getY() - getY());
                int i2 = this.f6088a;
                canvas.scale(i2, i2);
                canvas.drawBitmap(this.f6095h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.f6089b);
        }
    }

    public boolean prepare() {
        int width = this.f6090c.getWidth();
        int height = this.f6090c.getHeight();
        if (this.f6096i == null || this.f6093f || this.f6091d != width || this.f6092e != height) {
            this.f6093f = false;
            this.f6091d = width;
            this.f6092e = height;
            int i2 = this.f6088a;
            int i3 = width / i2;
            int i4 = height / i2;
            int i5 = (i3 - (i3 % 4)) + 4;
            int i6 = (i4 - (i4 % 4)) + 4;
            Bitmap bitmap = this.f6095h;
            if (bitmap == null || bitmap.getWidth() != i5 || this.f6095h.getHeight() != i6) {
                Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f6094g = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f6095h = createBitmap2;
                if (createBitmap2 == null) {
                    return false;
                }
            }
            Canvas canvas = new Canvas(this.f6094g);
            this.f6096i = canvas;
            int i7 = this.f6088a;
            canvas.scale(1.0f / i7, 1.0f / i7);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.j, this.f6094g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.l = createFromBitmap;
            this.m = Allocation.createTyped(this.j, createFromBitmap.getType());
        }
        return true;
    }

    public void setBlurRadius(int i2) {
        this.k.setRadius(i2);
    }

    public void setBlurredView(View view) {
        this.f6090c = view;
    }

    public void setDownsampleFactor(int i2) {
        if (i2 > 0) {
            if (this.f6088a != i2) {
                this.f6088a = i2;
                this.f6093f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int i2) {
        this.f6089b = i2;
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
