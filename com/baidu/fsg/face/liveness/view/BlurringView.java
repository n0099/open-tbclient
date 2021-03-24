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
    public int f6027a;

    /* renamed from: b  reason: collision with root package name */
    public int f6028b;

    /* renamed from: c  reason: collision with root package name */
    public View f6029c;

    /* renamed from: d  reason: collision with root package name */
    public int f6030d;

    /* renamed from: e  reason: collision with root package name */
    public int f6031e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6032f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f6033g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f6034h;
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
        this.l.copyFrom(this.f6033g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.f6034h);
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
        if (this.f6029c != null) {
            if (prepare()) {
                if (this.f6029c.getBackground() != null && (this.f6029c.getBackground() instanceof ColorDrawable)) {
                    this.f6033g.eraseColor(((ColorDrawable) this.f6029c.getBackground()).getColor());
                } else {
                    this.f6033g.eraseColor(0);
                }
                this.f6029c.draw(this.i);
                blur();
                canvas.save();
                canvas.translate(this.f6029c.getX() - getX(), this.f6029c.getY() - getY());
                int i = this.f6027a;
                canvas.scale(i, i);
                canvas.drawBitmap(this.f6034h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.f6028b);
        }
    }

    public boolean prepare() {
        int width = this.f6029c.getWidth();
        int height = this.f6029c.getHeight();
        if (this.i == null || this.f6032f || this.f6030d != width || this.f6031e != height) {
            this.f6032f = false;
            this.f6030d = width;
            this.f6031e = height;
            int i = this.f6027a;
            int i2 = width / i;
            int i3 = height / i;
            int i4 = (i2 - (i2 % 4)) + 4;
            int i5 = (i3 - (i3 % 4)) + 4;
            Bitmap bitmap = this.f6034h;
            if (bitmap == null || bitmap.getWidth() != i4 || this.f6034h.getHeight() != i5) {
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                this.f6033g = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                this.f6034h = createBitmap2;
                if (createBitmap2 == null) {
                    return false;
                }
            }
            Canvas canvas = new Canvas(this.f6033g);
            this.i = canvas;
            int i6 = this.f6027a;
            canvas.scale(1.0f / i6, 1.0f / i6);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.j, this.f6033g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.l = createFromBitmap;
            this.m = Allocation.createTyped(this.j, createFromBitmap.getType());
        }
        return true;
    }

    public void setBlurRadius(int i) {
        this.k.setRadius(i);
    }

    public void setBlurredView(View view) {
        this.f6029c = view;
    }

    public void setDownsampleFactor(int i) {
        if (i > 0) {
            if (this.f6027a != i) {
                this.f6027a = i;
                this.f6032f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int i) {
        this.f6028b = i;
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
