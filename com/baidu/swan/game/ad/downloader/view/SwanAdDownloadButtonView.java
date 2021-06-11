package com.baidu.swan.game.ad.downloader.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import d.a.l0.f.i.b;
import d.a.l0.f.i.c;
/* loaded from: classes3.dex */
public class SwanAdDownloadButtonView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f11602e;

    /* renamed from: f  reason: collision with root package name */
    public int f11603f;

    /* renamed from: g  reason: collision with root package name */
    public int f11604g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11605h;

    /* renamed from: i  reason: collision with root package name */
    public int f11606i;
    public boolean j;
    public Paint k;
    public int l;
    public float m;
    public String n;
    public int o;
    public State p;
    public float q;

    /* loaded from: classes3.dex */
    public enum State {
        PREPARE,
        DOWNLOADING,
        FINISH
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11607a;

        static {
            int[] iArr = new int[State.values().length];
            f11607a = iArr;
            try {
                iArr[State.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11607a[State.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SwanAdDownloadButtonView(Context context) {
        super(context);
        this.f11602e = new Paint();
        this.k = new Paint();
        this.l = -1;
        this.o = 100;
        this.p = State.PREPARE;
        this.q = -1.0f;
        this.f11602e.setAntiAlias(true);
        this.k.setAntiAlias(true);
        this.m = getResources().getDimensionPixelOffset(c.swan_ad_dimens_14dp);
        this.f11603f = context.getResources().getColor(b.swanapp_ad_download_button_default_bg_color);
        this.f11604g = context.getResources().getColor(b.swanapp_ad_download_button_default_fg_color);
    }

    public final void a(Canvas canvas, RectF rectF) {
        this.f11602e.setColor(this.f11603f);
        this.f11602e.setStyle(Paint.Style.FILL);
        float f2 = this.q;
        if (f2 <= 0.0f) {
            f2 = this.f11605h ? rectF.height() / 2.0f : 0.0f;
        }
        canvas.drawRoundRect(rectF, f2, f2, this.f11602e);
    }

    public final void b(Canvas canvas, RectF rectF) {
        int i2 = a.f11607a[this.p.ordinal()];
        float f2 = 0.0f;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            this.f11602e.setColor(this.f11604g);
            this.f11602e.setStyle(Paint.Style.FILL);
            float f3 = this.q;
            if (f3 > 0.0f) {
                f2 = f3;
            } else if (this.f11605h) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.f11602e);
            return;
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        float f4 = this.f11606i / this.o;
        paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.f11604g, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
        float f5 = this.q;
        if (f5 > 0.0f) {
            f2 = f5;
        } else if (this.f11605h) {
            f2 = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f2, f2, paint);
    }

    public final void c(Canvas canvas) {
        this.k.setTextSize(this.m);
        float height = (canvas.getHeight() / 2) - ((this.k.descent() / 2.0f) + (this.k.ascent() / 2.0f));
        float measureText = this.k.measureText(this.n);
        this.k.setColor(this.l);
        canvas.drawText(this.n, (getMeasuredWidth() - measureText) / 2.0f, height, this.k);
    }

    public final void d(Canvas canvas) {
        float f2 = 0;
        RectF rectF = new RectF(f2, f2, getWidth(), getHeight());
        a(canvas, rectF);
        b(canvas, rectF);
        c(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() == 0 || getHeight() == 0 || TextUtils.isEmpty(this.n)) {
            return;
        }
        if (!this.j) {
            e(canvas);
        } else {
            d(canvas);
        }
    }

    public final void e(Canvas canvas) {
        float f2 = 0;
        RectF rectF = new RectF(f2, f2, getWidth() + 0, getHeight() + 0);
        this.f11602e.setColor(this.f11603f);
        this.f11602e.setStyle(Paint.Style.FILL);
        float f3 = this.q;
        if (f3 <= 0.0f) {
            f3 = this.f11605h ? rectF.height() / 2.0f : 0.0f;
        }
        canvas.drawRoundRect(rectF, f3, f3, this.f11602e);
        this.k.setColor(this.l);
        this.k.setTextSize(this.m);
        Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
        float f4 = fontMetrics.descent;
        canvas.drawText(this.n, (getMeasuredWidth() - this.k.measureText(this.n)) / 2.0f, ((getHeight() / 2) - f4) + ((f4 - fontMetrics.ascent) / 2.0f), this.k);
    }

    public SwanAdDownloadButtonView f(boolean z) {
        this.f11605h = z;
        return this;
    }

    public SwanAdDownloadButtonView g(boolean z) {
        this.j = z;
        return this;
    }

    public int getMax() {
        return this.o;
    }

    public SwanAdDownloadButtonView h(int i2) {
        this.f11603f = i2;
        return this;
    }

    public SwanAdDownloadButtonView i(int i2) {
        this.l = i2;
        return this;
    }

    public SwanAdDownloadButtonView j(float f2) {
        this.m = f2;
        return this;
    }

    public void setMax(int i2) {
        this.o = i2;
    }

    public void setProgress(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.o;
        if (i2 > i3) {
            i2 = i3;
        }
        this.f11606i = i2;
        if (i2 == 0) {
            this.p = State.PREPARE;
        } else if (i2 == this.o) {
            this.p = State.FINISH;
        } else {
            this.p = State.DOWNLOADING;
        }
    }

    public void setRadius(float f2) {
        this.q = f2;
    }

    public void setText(String str) {
        this.n = str;
    }
}
