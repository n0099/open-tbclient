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
    public int f6031a;

    /* renamed from: b  reason: collision with root package name */
    public int f6032b;

    /* renamed from: c  reason: collision with root package name */
    public View f6033c;

    /* renamed from: d  reason: collision with root package name */
    public int f6034d;

    /* renamed from: e  reason: collision with root package name */
    public int f6035e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6036f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f6037g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f6038h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f6039i;
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
        this.l.copyFrom(this.f6037g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.f6038h);
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
        if (this.f6033c != null) {
            if (prepare()) {
                if (this.f6033c.getBackground() != null && (this.f6033c.getBackground() instanceof ColorDrawable)) {
                    this.f6037g.eraseColor(((ColorDrawable) this.f6033c.getBackground()).getColor());
                } else {
                    this.f6037g.eraseColor(0);
                }
                this.f6033c.draw(this.f6039i);
                blur();
                canvas.save();
                canvas.translate(this.f6033c.getX() - getX(), this.f6033c.getY() - getY());
                int i2 = this.f6031a;
                canvas.scale(i2, i2);
                canvas.drawBitmap(this.f6038h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.f6032b);
        }
    }

    public boolean prepare() {
        int width = this.f6033c.getWidth();
        int height = this.f6033c.getHeight();
        if (this.f6039i == null || this.f6036f || this.f6034d != width || this.f6035e != height) {
            this.f6036f = false;
            this.f6034d = width;
            this.f6035e = height;
            int i2 = this.f6031a;
            int i3 = width / i2;
            int i4 = height / i2;
            int i5 = (i3 - (i3 % 4)) + 4;
            int i6 = (i4 - (i4 % 4)) + 4;
            Bitmap bitmap = this.f6038h;
            if (bitmap == null || bitmap.getWidth() != i5 || this.f6038h.getHeight() != i6) {
                Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f6037g = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f6038h = createBitmap2;
                if (createBitmap2 == null) {
                    return false;
                }
            }
            Canvas canvas = new Canvas(this.f6037g);
            this.f6039i = canvas;
            int i7 = this.f6031a;
            canvas.scale(1.0f / i7, 1.0f / i7);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.j, this.f6037g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.l = createFromBitmap;
            this.m = Allocation.createTyped(this.j, createFromBitmap.getType());
        }
        return true;
    }

    public void setBlurRadius(int i2) {
        this.k.setRadius(i2);
    }

    public void setBlurredView(View view) {
        this.f6033c = view;
    }

    public void setDownsampleFactor(int i2) {
        if (i2 > 0) {
            if (this.f6031a != i2) {
                this.f6031a = i2;
                this.f6036f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int i2) {
        this.f6032b = i2;
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
