package com.baidu.swan.game.guide.download;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.l0.f.j.e;
import d.a.l0.f.j.f;
/* loaded from: classes3.dex */
public class GamenowDownloadButtomView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f11655e;

    /* renamed from: f  reason: collision with root package name */
    public int f11656f;

    /* renamed from: g  reason: collision with root package name */
    public int f11657g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11658h;

    /* renamed from: i  reason: collision with root package name */
    public int f11659i;
    public boolean j;
    public Paint k;
    public int l;
    public float m;
    public String n;
    public int o;
    public DownloadState p;
    public float q;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11660a;

        static {
            int[] iArr = new int[DownloadState.values().length];
            f11660a = iArr;
            try {
                iArr[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11660a[DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11660a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public GamenowDownloadButtomView(Context context) {
        super(context);
        this.f11655e = new Paint();
        this.k = new Paint();
        this.l = -1;
        this.o = 100;
        this.p = DownloadState.NOT_START;
        this.q = -1.0f;
        this.f11655e.setAntiAlias(true);
        this.k.setAntiAlias(true);
        this.m = getResources().getDimensionPixelOffset(f.aiapps_game_dimens_14dp);
        this.f11656f = context.getResources().getColor(e.aiapps_download_button_default_bg_color);
        this.f11657g = context.getResources().getColor(e.aiapps_download_button_default_fg_color);
    }

    public final void a(Canvas canvas, RectF rectF) {
        int i2 = a.f11660a[this.p.ordinal()];
        float f2 = 0.0f;
        if (i2 != 1 && i2 != 2) {
            this.f11655e.setColor(this.f11656f);
            this.f11655e.setStyle(Paint.Style.FILL);
            float f3 = this.q;
            if (f3 > 0.0f) {
                f2 = f3;
            } else if (this.f11658h) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.f11655e);
            return;
        }
        this.f11655e.setColor(this.f11656f);
        this.f11655e.setStyle(Paint.Style.STROKE);
        this.f11655e.setStrokeWidth(1.0f);
        float f4 = this.q;
        if (f4 > 0.0f) {
            f2 = f4;
        } else if (this.f11658h) {
            f2 = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f2, f2, this.f11655e);
    }

    public final void b(Canvas canvas, RectF rectF) {
        int i2 = a.f11660a[this.p.ordinal()];
        float f2 = 0.0f;
        if (i2 == 1 || i2 == 2) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            float f3 = 1;
            RectF rectF2 = new RectF(f3, f3, getWidth() - 2, getHeight() - 2);
            float f4 = this.f11659i / this.o;
            paint.setShader(new LinearGradient(0.0f, 0.0f, rectF2.width(), 0.0f, new int[]{this.f11657g, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
            float f5 = this.q;
            if (f5 > 0.0f) {
                f2 = f5;
            } else if (this.f11658h) {
                f2 = rectF2.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF2, f2, f2, paint);
        } else if (i2 != 3) {
            this.f11655e.setColor(this.f11656f);
            this.f11655e.setStyle(Paint.Style.FILL);
            float f6 = this.q;
            if (f6 > 0.0f) {
                f2 = f6;
            } else if (this.f11658h) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.f11655e);
        } else {
            this.f11655e.setColor(this.f11657g);
            this.f11655e.setStyle(Paint.Style.FILL);
            float f7 = this.q;
            if (f7 > 0.0f) {
                f2 = f7;
            } else if (this.f11658h) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.f11655e);
        }
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
        this.f11655e.setColor(this.f11656f);
        this.f11655e.setStyle(Paint.Style.FILL);
        float f3 = this.q;
        if (f3 <= 0.0f) {
            f3 = this.f11658h ? rectF.height() / 2.0f : 0.0f;
        }
        canvas.drawRoundRect(rectF, f3, f3, this.f11655e);
        this.k.setColor(this.l);
        this.k.setTextSize(this.m);
        Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
        float f4 = fontMetrics.descent;
        canvas.drawText(this.n, (getMeasuredWidth() - this.k.measureText(this.n)) / 2.0f, ((getHeight() / 2) - f4) + ((f4 - fontMetrics.ascent) / 2.0f), this.k);
    }

    public GamenowDownloadButtomView f(boolean z) {
        this.f11658h = z;
        return this;
    }

    public GamenowDownloadButtomView g(boolean z) {
        this.j = z;
        return this;
    }

    public int getMax() {
        return this.o;
    }

    public GamenowDownloadButtomView h(int i2) {
        this.f11656f = i2;
        return this;
    }

    public GamenowDownloadButtomView i(int i2) {
        this.f11657g = i2;
        return this;
    }

    public GamenowDownloadButtomView j(int i2) {
        this.l = i2;
        return this;
    }

    public GamenowDownloadButtomView k(float f2) {
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
        this.f11659i = i2;
    }

    public void setRadius(float f2) {
        this.q = f2;
    }

    public void setState(DownloadState downloadState) {
        this.p = downloadState;
    }

    public void setText(String str) {
        this.n = str;
    }
}
