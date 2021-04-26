package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class MessageRedDotView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Drawable f12987e;

    /* renamed from: f  reason: collision with root package name */
    public int f12988f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12989g;

    /* renamed from: h  reason: collision with root package name */
    public String f12990h;

    /* renamed from: i  reason: collision with root package name */
    public int f12991i;
    public Paint j;
    public Rect k;
    public Paint l;
    public int m;
    public int n;
    public int o;
    public RectF p;
    public int q;
    public int r;
    public int s;
    public int t;
    public Paint u;
    public RectF v;
    public boolean w;
    public boolean x;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.f12991i = 1;
        this.w = false;
        this.x = false;
        d();
    }

    public final void a(Canvas canvas) {
        if (k.isEmpty(this.f12990h) || this.f12987e == null) {
            return;
        }
        Paint paint = this.j;
        String str = this.f12990h;
        paint.getTextBounds(str, 0, str.length(), this.k);
        Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
        int intrinsicWidth = (this.f12987e.getIntrinsicWidth() / 2) + this.q;
        float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
        if (this.w) {
            Rect bounds = this.f12987e.getBounds();
            float f2 = fontMetrics.descent;
            float height = (bounds.height() / 2) - (f2 - (((-fontMetrics.ascent) + f2) / 2.0f));
            intrinsicWidth = bounds.width() / 2;
            dimension = height;
        }
        canvas.drawText(this.f12990h, intrinsicWidth, dimension, this.j);
    }

    public final void b(Canvas canvas) {
        int i2;
        int i3;
        Drawable drawable = this.f12987e;
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = (drawable.getIntrinsicWidth() / 2) + this.q;
        int intrinsicHeight = (this.f12987e.getIntrinsicHeight() / 2) + this.q;
        if (this.w) {
            Rect bounds = this.f12987e.getBounds();
            int width = bounds.width() / 2;
            intrinsicHeight = bounds.height() / 2;
            intrinsicWidth = width;
        }
        int i4 = this.s;
        float f2 = intrinsicHeight - (i4 / 2);
        float f3 = intrinsicHeight + (i4 / 2);
        this.v.set(intrinsicWidth - (i4 / 2), f2, intrinsicWidth + (i4 / 2), f3);
        canvas.drawOval(this.v, this.u);
        RectF rectF = this.v;
        int i5 = this.t;
        rectF.set((i2 - i5) - this.s, f2, i2 - i5, f3);
        canvas.drawOval(this.v, this.u);
        RectF rectF2 = this.v;
        int i6 = this.t;
        rectF2.set(i3 + i6, f2, i3 + i6 + this.s, f3);
        canvas.drawOval(this.v, this.u);
    }

    public final void c() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            l.g(getContext(), R.dimen.tbds2);
        }
    }

    public final void d() {
        setLayerType(1, null);
        c();
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
        if (!this.w && this.x) {
            this.j.setTextSize(l.g(getContext(), R.dimen.tbfontsize26));
            this.j.setTypeface(Typeface.MONOSPACE);
        } else {
            this.j.setTextSize(l.g(getContext(), R.dimen.tbfontsize28));
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.j.setTextAlign(Paint.Align.CENTER);
        this.k = new Rect();
        l.g(getContext(), R.dimen.tbds13);
        l.g(getContext(), R.dimen.tbds42);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setAntiAlias(true);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(SkinManager.getColor(R.color.transparent));
        this.m = 0;
        this.o = l.g(getContext(), R.dimen.tbds8);
        int g2 = l.g(getContext(), R.dimen.tbds3);
        this.n = g2;
        this.l.setShadowLayer(this.o, this.m, g2, SkinManager.getColor(R.color.cp_cont_h_alpha66));
        this.p = new RectF();
        this.r = l.g(getContext(), R.dimen.tbds21);
        this.s = l.g(getContext(), R.dimen.tbds8);
        this.t = l.g(getContext(), R.dimen.tbds6);
        Paint paint3 = new Paint();
        this.u = paint3;
        paint3.setAntiAlias(true);
        this.u.setStyle(Paint.Style.FILL);
        this.u.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.v = new RectF();
    }

    public void e() {
        TbadkApplication.getInst().getSkinType();
        int i2 = this.f12988f;
        if (i2 > 0) {
            this.f12987e = SkinManager.getDrawable(i2);
        } else {
            Drawable drawable = this.f12987e;
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(SkinManager.getColor(R.color.CAM_X0301));
            }
        }
        this.u.setColor(SkinManager.getColor(R.color.CAM_X0101));
        Paint paint = this.j;
        if (paint != null) {
            paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
        }
        this.l.setShadowLayer(this.o, this.m, this.n, SkinManager.getColor(R.color.cp_cont_h_alpha66));
        if (this.f12989g) {
            this.f12989g = false;
            requestLayout();
        }
        invalidate();
    }

    @Deprecated
    public void f(int i2) {
        int i3;
        if (i2 <= 0) {
            i3 = R.drawable.icon_news_red_dot;
            this.f12990h = null;
        } else if (i2 < 10) {
            this.f12990h = String.valueOf(i2);
            i3 = R.drawable.icon_news_red_dot_one_number;
        } else if (i2 < 100) {
            this.f12990h = String.valueOf(i2);
            i3 = R.drawable.icon_news_red_dot_two_number;
        } else {
            int i4 = this.f12991i;
            if (i4 == 1) {
                this.f12990h = StringHelper.STRING_MORE;
                i3 = R.drawable.icon_news_red_dot_three_dot_number;
            } else if (i4 == 2) {
                this.f12990h = "99+";
                i3 = R.drawable.icon_news_red_dot_three_number;
            } else {
                i3 = 0;
            }
        }
        if (i3 != this.f12988f) {
            this.f12989g = true;
        } else {
            this.f12989g = false;
        }
        this.f12988f = i3;
        e();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f12987e;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.f12987e.getIntrinsicHeight();
            if (this.w) {
                this.f12987e.setBounds(0, 0, l.g(getContext(), R.dimen.tbds4) + intrinsicWidth, l.g(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                Drawable drawable2 = this.f12987e;
                int i2 = this.q;
                drawable2.setBounds(i2, i2, intrinsicWidth + i2, intrinsicHeight + i2);
            }
            this.f12987e.draw(canvas);
            if (!this.w && this.x) {
                RectF rectF = this.p;
                int i3 = this.q;
                rectF.set(i3, i3, intrinsicWidth + i3, i3 + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    RectF rectF2 = this.p;
                    int i4 = this.r;
                    canvas.drawRoundRect(rectF2, i4, i4, this.l);
                } else {
                    canvas.drawOval(this.p, this.l);
                }
            }
            if (k.isEmpty(this.f12990h)) {
                return;
            }
            if (this.f12990h.equals(StringHelper.STRING_MORE)) {
                b(canvas);
            } else {
                a(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f12987e != null) {
            int i4 = this.m;
            int i5 = this.n;
            this.q = i4 >= i5 ? this.o + i4 : i5 + this.o;
            setMeasuredDimension(this.f12987e.getIntrinsicWidth() + (this.q * 2), this.f12987e.getIntrinsicHeight() + (this.q * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public void setEnterForumStyle(boolean z) {
        this.w = z;
    }

    public void setShadowEnabled(boolean z) {
        this.x = z;
    }

    public void setThreeDotMode(int i2) {
        this.f12991i = i2;
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12991i = 1;
        this.w = false;
        this.x = false;
        d();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12991i = 1;
        this.w = false;
        this.x = false;
        d();
    }
}
