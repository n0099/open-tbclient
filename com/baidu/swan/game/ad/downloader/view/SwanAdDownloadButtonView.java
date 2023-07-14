package com.baidu.swan.game.ad.downloader.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SwanAdDownloadButtonView extends View {
    public Paint a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public boolean f;
    public Paint g;
    public int h;
    public float i;
    public String j;
    public int k;
    public State l;
    public float m;

    /* loaded from: classes4.dex */
    public enum State {
        PREPARE,
        DOWNLOADING,
        FINISH
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[State.values().length];
            a = iArr;
            try {
                iArr[State.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[State.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SwanAdDownloadButtonView(Context context) {
        super(context);
        this.a = new Paint();
        this.g = new Paint();
        this.h = -1;
        this.k = 100;
        this.l = State.PREPARE;
        this.m = -1.0f;
        this.a.setAntiAlias(true);
        this.g.setAntiAlias(true);
        this.i = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0707e2);
        this.b = context.getResources().getColor(R.color.obfuscated_res_0x7f060ade);
        this.c = context.getResources().getColor(R.color.obfuscated_res_0x7f060adf);
    }

    public final void a(Canvas canvas, RectF rectF) {
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.FILL);
        float f = this.m;
        if (f <= 0.0f) {
            if (this.d) {
                f = rectF.height() / 2.0f;
            } else {
                f = 0.0f;
            }
        }
        canvas.drawRoundRect(rectF, f, f, this.a);
    }

    public final void b(Canvas canvas, RectF rectF) {
        int i = a.a[this.l.ordinal()];
        float f = 0.0f;
        if (i != 1) {
            if (i == 2) {
                this.a.setColor(this.c);
                this.a.setStyle(Paint.Style.FILL);
                float f2 = this.m;
                if (f2 > 0.0f) {
                    f = f2;
                } else if (this.d) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.a);
                return;
            }
            return;
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        float f3 = this.e / this.k;
        paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.c, 0}, new float[]{f3, f3 + 1.0E-4f}, Shader.TileMode.CLAMP));
        float f4 = this.m;
        if (f4 > 0.0f) {
            f = f4;
        } else if (this.d) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    public final void c(Canvas canvas) {
        this.g.setTextSize(this.i);
        float height = (canvas.getHeight() / 2) - ((this.g.descent() / 2.0f) + (this.g.ascent() / 2.0f));
        float measureText = this.g.measureText(this.j);
        this.g.setColor(this.h);
        canvas.drawText(this.j, (getMeasuredWidth() - measureText) / 2.0f, height, this.g);
    }

    public final void d(Canvas canvas) {
        float f = 0;
        RectF rectF = new RectF(f, f, getWidth(), getHeight());
        a(canvas, rectF);
        b(canvas, rectF);
        c(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.j)) {
            if (!this.f) {
                e(canvas);
            } else {
                d(canvas);
            }
        }
    }

    public SwanAdDownloadButtonView f(boolean z) {
        this.d = z;
        return this;
    }

    public SwanAdDownloadButtonView g(boolean z) {
        this.f = z;
        return this;
    }

    public SwanAdDownloadButtonView h(int i) {
        this.b = i;
        return this;
    }

    public SwanAdDownloadButtonView i(int i) {
        this.h = i;
        return this;
    }

    public SwanAdDownloadButtonView j(float f) {
        this.i = f;
        return this;
    }

    public void setMax(int i) {
        this.k = i;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        int i2 = this.k;
        if (i > i2) {
            i = i2;
        }
        this.e = i;
        if (i == 0) {
            this.l = State.PREPARE;
        } else if (i == this.k) {
            this.l = State.FINISH;
        } else {
            this.l = State.DOWNLOADING;
        }
    }

    public void setRadius(float f) {
        this.m = f;
    }

    public void setText(String str) {
        this.j = str;
    }

    public final void e(Canvas canvas) {
        float f = 0;
        RectF rectF = new RectF(f, f, getWidth() + 0, getHeight() + 0);
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.FILL);
        float f2 = this.m;
        if (f2 <= 0.0f) {
            if (this.d) {
                f2 = rectF.height() / 2.0f;
            } else {
                f2 = 0.0f;
            }
        }
        canvas.drawRoundRect(rectF, f2, f2, this.a);
        this.g.setColor(this.h);
        this.g.setTextSize(this.i);
        Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
        float f3 = fontMetrics.descent;
        canvas.drawText(this.j, (getMeasuredWidth() - this.g.measureText(this.j)) / 2.0f, ((getHeight() / 2) - f3) + ((f3 - fontMetrics.ascent) / 2.0f), this.g);
    }

    public int getMax() {
        return this.k;
    }
}
