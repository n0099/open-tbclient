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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class MessageRedDotView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Drawable f13382e;

    /* renamed from: f  reason: collision with root package name */
    public int f13383f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13384g;

    /* renamed from: h  reason: collision with root package name */
    public String f13385h;
    public int i;
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
        this.i = 1;
        this.w = false;
        this.x = false;
        d();
    }

    public final void a(Canvas canvas) {
        if (k.isEmpty(this.f13385h) || this.f13382e == null) {
            return;
        }
        Paint paint = this.j;
        String str = this.f13385h;
        paint.getTextBounds(str, 0, str.length(), this.k);
        Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
        int intrinsicWidth = (this.f13382e.getIntrinsicWidth() / 2) + this.q;
        float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
        if (this.w) {
            Rect bounds = this.f13382e.getBounds();
            float f2 = fontMetrics.descent;
            float height = (bounds.height() / 2) - (f2 - (((-fontMetrics.ascent) + f2) / 2.0f));
            intrinsicWidth = bounds.width() / 2;
            dimension = height;
        }
        canvas.drawText(this.f13385h, intrinsicWidth, dimension, this.j);
    }

    public final void b(Canvas canvas) {
        int i;
        int i2;
        Drawable drawable = this.f13382e;
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = (drawable.getIntrinsicWidth() / 2) + this.q;
        int intrinsicHeight = (this.f13382e.getIntrinsicHeight() / 2) + this.q;
        if (this.w) {
            Rect bounds = this.f13382e.getBounds();
            int width = bounds.width() / 2;
            intrinsicHeight = bounds.height() / 2;
            intrinsicWidth = width;
        }
        int i3 = this.s;
        float f2 = intrinsicHeight - (i3 / 2);
        float f3 = intrinsicHeight + (i3 / 2);
        this.v.set(intrinsicWidth - (i3 / 2), f2, intrinsicWidth + (i3 / 2), f3);
        canvas.drawOval(this.v, this.u);
        RectF rectF = this.v;
        int i4 = this.t;
        rectF.set((i - i4) - this.s, f2, i - i4, f3);
        canvas.drawOval(this.v, this.u);
        RectF rectF2 = this.v;
        int i5 = this.t;
        rectF2.set(i2 + i5, f2, i2 + i5 + this.s, f3);
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
        int i = this.f13383f;
        if (i > 0) {
            this.f13382e = SkinManager.getDrawable(i);
        } else {
            Drawable drawable = this.f13382e;
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
        if (this.f13384g) {
            this.f13384g = false;
            requestLayout();
        }
        invalidate();
    }

    @Deprecated
    public void f(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.f13385h = null;
        } else if (i < 10) {
            this.f13385h = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.f13385h = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else {
            int i3 = this.i;
            if (i3 == 1) {
                this.f13385h = StringHelper.STRING_MORE;
                i2 = R.drawable.icon_news_red_dot_three_dot_number;
            } else if (i3 == 2) {
                this.f13385h = "99+";
                i2 = R.drawable.icon_news_red_dot_three_number;
            } else {
                i2 = 0;
            }
        }
        if (i2 != this.f13383f) {
            this.f13384g = true;
        } else {
            this.f13384g = false;
        }
        this.f13383f = i2;
        e();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f13382e;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.f13382e.getIntrinsicHeight();
            if (this.w) {
                this.f13382e.setBounds(0, 0, l.g(getContext(), R.dimen.tbds4) + intrinsicWidth, l.g(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                Drawable drawable2 = this.f13382e;
                int i = this.q;
                drawable2.setBounds(i, i, intrinsicWidth + i, intrinsicHeight + i);
            }
            this.f13382e.draw(canvas);
            if (!this.w && this.x) {
                RectF rectF = this.p;
                int i2 = this.q;
                rectF.set(i2, i2, intrinsicWidth + i2, i2 + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    RectF rectF2 = this.p;
                    int i3 = this.r;
                    canvas.drawRoundRect(rectF2, i3, i3, this.l);
                } else {
                    canvas.drawOval(this.p, this.l);
                }
            }
            if (k.isEmpty(this.f13385h)) {
                return;
            }
            if (this.f13385h.equals(StringHelper.STRING_MORE)) {
                b(canvas);
            } else {
                a(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f13382e != null) {
            int i3 = this.m;
            int i4 = this.n;
            this.q = i3 >= i4 ? this.o + i3 : i4 + this.o;
            setMeasuredDimension(this.f13382e.getIntrinsicWidth() + (this.q * 2), this.f13382e.getIntrinsicHeight() + (this.q * 2));
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

    public void setThreeDotMode(int i) {
        this.i = i;
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 1;
        this.w = false;
        this.x = false;
        d();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 1;
        this.w = false;
        this.x = false;
        d();
    }
}
