package com.baidu.nadcore.download.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.tieba.jl0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.t41;
/* loaded from: classes3.dex */
public class AdDownloadViewLP extends View implements jl0<AdDownloadViewLP> {
    public final Paint a;
    public int b;
    public int c;
    public ValueAnimator d;
    public int e;
    public boolean f;
    public int g;
    public boolean h;
    public final Paint i;
    public int j;
    public float k;
    public String l;
    public int m;
    public State n;
    public float o;

    /* loaded from: classes3.dex */
    public enum State {
        PREPARE,
        DOWNLOADING,
        FINISH
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jl0
    @NonNull
    public AdDownloadViewLP getRealView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AdDownloadViewLP.this.b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            AdDownloadViewLP.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
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

    public AdDownloadViewLP(Context context) {
        super(context);
        this.a = new Paint();
        this.b = -2210218;
        this.c = -1;
        this.e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        i();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.l)) {
            if (this.c != -1) {
                j();
            }
            if (!this.h) {
                h(canvas);
            } else {
                g(canvas);
            }
        }
    }

    public final void g(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        d(canvas, rectF);
        e(canvas, rectF);
        f(canvas);
    }

    public AdDownloadViewLP k(boolean z) {
        this.f = z;
        return this;
    }

    public AdDownloadViewLP l(boolean z) {
        this.h = z;
        return this;
    }

    public AdDownloadViewLP m(int i) {
        this.b = i;
        return this;
    }

    public AdDownloadViewLP n(int i) {
        this.j = i;
        return this;
    }

    public AdDownloadViewLP o(float f) {
        this.k = f;
        return this;
    }

    public void setAbsorbColor(int i) {
        this.c = i;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        int i2 = this.m;
        if (i > i2) {
            i = i2;
        }
        this.g = i;
        if (i == 0) {
            this.n = State.PREPARE;
        } else if (i == this.m) {
            this.n = State.FINISH;
        } else {
            this.n = State.DOWNLOADING;
        }
    }

    public AdDownloadViewLP(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = -2210218;
        this.c = -1;
        this.e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        i();
    }

    public final void d(Canvas canvas, RectF rectF) {
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.FILL);
        float f = this.o;
        if (f <= 0.0f) {
            if (this.f) {
                f = rectF.height() / 2.0f;
            } else {
                f = 0.0f;
            }
        }
        canvas.drawRoundRect(rectF, f, f, this.a);
    }

    @Override // com.baidu.tieba.jl0
    public void update(String str, @NonNull qk0 qk0Var) {
        this.l = str;
        if (qk0Var.c == AdDownloadStatus.DOWNLOADING) {
            this.l = "已下载 : " + this.l;
        }
        setProgress((int) qk0Var.i);
        postInvalidate();
    }

    public AdDownloadViewLP(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = -2210218;
        this.c = -1;
        this.e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        i();
    }

    @Override // com.baidu.tieba.jl0
    public void b(@NonNull ViewGroup viewGroup) {
        if (!(viewGroup instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.width = (int) (t41.c.e(getContext()) * t41.c.h(R.dimen.nad_default_round_width_size));
        layoutParams.height = (int) (t41.c.c(getContext()) * t41.c.h(R.dimen.nad_default_round_height_size));
        layoutParams.addRule(13, -1);
        viewGroup.addView(this, layoutParams);
        viewGroup.setVisibility(0);
        viewGroup.bringToFront();
    }

    public final void f(Canvas canvas) {
        this.i.setTextSize(this.k);
        float height = (canvas.getHeight() / 2.0f) - ((this.i.descent() / 2.0f) + (this.i.ascent() / 2.0f));
        float measureText = this.i.measureText(this.l);
        this.i.setColor(this.j);
        canvas.drawText(this.l, (getMeasuredWidth() - measureText) / 2.0f, height, this.i);
    }

    public final void e(Canvas canvas, RectF rectF) {
        int i = b.a[this.n.ordinal()];
        float f = 0.0f;
        if (i != 1) {
            if (i == 2) {
                this.a.setColor(this.e);
                this.a.setStyle(Paint.Style.FILL);
                float f2 = this.o;
                if (f2 > 0.0f) {
                    f = f2;
                } else if (this.f) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.a);
                return;
            }
            return;
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        float f3 = this.g / this.m;
        paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.e, 0}, new float[]{f3, f3 + 1.0E-4f}, Shader.TileMode.CLAMP));
        float f4 = this.o;
        if (f4 > 0.0f) {
            f = f4;
        } else if (this.f) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    public final void i() {
        o(getContext().getResources().getDimensionPixelSize(R.dimen.nad_dimens_16dp));
        m(getContext().getResources().getColor(R.color.nad_download_button_color));
        n(-1);
        l(true);
        k(true);
    }

    public final void h(Canvas canvas) {
        float f = 0;
        RectF rectF = new RectF(f, f, getWidth() + 0, getHeight() + 0);
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.FILL);
        float f2 = this.o;
        if (f2 <= 0.0f) {
            if (this.f) {
                f2 = rectF.height() / 2.0f;
            } else {
                f2 = 0.0f;
            }
        }
        canvas.drawRoundRect(rectF, f2, f2, this.a);
        this.i.setColor(this.j);
        this.i.setTextSize(this.k);
        Paint.FontMetrics fontMetrics = this.i.getFontMetrics();
        float f3 = fontMetrics.descent;
        canvas.drawText(this.l, (getMeasuredWidth() - this.i.measureText(this.l)) / 2.0f, ((getHeight() / 2.0f) - f3) + ((f3 - fontMetrics.ascent) / 2.0f), this.i);
    }

    public final void j() {
        if (this.d != null) {
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.b), Integer.valueOf(this.c));
        this.d = ofObject;
        ofObject.setDuration(500L);
        this.d.addUpdateListener(new a());
        this.d.start();
    }
}
