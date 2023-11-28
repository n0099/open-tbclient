package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hf0;
import com.baidu.tieba.ly0;
import com.baidu.tieba.s21;
import com.baidu.tieba.u11;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NadExpressBottomView extends ViewGroup {
    public static final int l = u11.c.a(hf0.b(), 3.0f);
    public static final int m = u11.c.a(hf0.b(), 0.0f);
    public static final int n = d(R.dimen.NAD_F_M_W_X007);
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public AdImageView a;
    public String b;
    public String c;
    public String d;
    public TextPaint e;
    public TextPaint f;
    public ArrayList<String> g;
    public int h;
    public int i;
    public int j;
    public String k;

    static {
        d(R.dimen.nad_label_source_max_width);
        d(R.dimen.nad_ad_label_source_max_width);
        d(R.dimen.nad_label_tag_max_width);
        o = d(R.dimen.NAD_F_T_X033);
        p = d(R.dimen.NAD_F_T_X033);
        q = d(R.dimen.nad_tag_height);
        r = c(R.color.NAD_FC2);
        s = c(R.color.NAD_FC1);
    }

    public NadExpressBottomView(Context context) {
        this(context, null);
    }

    public static int c(int i) {
        return ContextCompat.getColor(hf0.b(), i);
    }

    public static int d(int i) {
        return hf0.b().getResources().getDimensionPixelSize(i);
    }

    public final float f(TextPaint textPaint) {
        return textPaint.getFontMetrics().bottom - textPaint.getFontMetrics().top;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        b(canvas);
        canvas.restore();
    }

    public void setNeedShowUnlikeIcon(boolean z) {
        int i;
        AdImageView adImageView = this.a;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        adImageView.setVisibility(i);
        this.a.setClickable(z);
    }

    public NadExpressBottomView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final float e(TextPaint textPaint, int i) {
        return ((i - f(textPaint)) / 2.0f) - textPaint.getFontMetrics().top;
    }

    public final float g(String str, TextPaint textPaint) {
        return textPaint.measureText(str);
    }

    public final void i(int i, int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                if (childAt.getMeasuredHeight() > this.j) {
                    this.j = childAt.getMeasuredHeight();
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.i = View.MeasureSpec.getSize(i);
        i(i, i2);
        setMeasuredDimension(this.i, this.j);
    }

    public NadExpressBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList<>(4);
        this.h = 0;
        this.i = 0;
        this.j = p;
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[LOOP:0: B:10:0x001e->B:29:0x00b2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[EDGE_INSN: B:33:0x00b6->B:30:0x00b6 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int i;
        float g;
        int i2;
        int i3 = 0;
        if (this.a.getVisibility() != 8) {
            i = this.a.getMeasuredWidth() + m + 0;
        } else {
            i = 0;
        }
        if (i > this.i) {
            this.h = 0;
            return;
        }
        while (i3 < this.g.size()) {
            if (TextUtils.equals((CharSequence) ly0.d(this.g, i3), this.c)) {
                i = (int) (i + g((String) ly0.d(this.g, i3), this.f) + n);
                i2 = l * 2;
            } else {
                if (!TextUtils.isEmpty(this.b) && TextUtils.equals((CharSequence) ly0.d(this.g, i3), this.k)) {
                    i2 = this.i - i;
                    float g2 = g((String) ly0.d(this.g, i3), this.e) + n;
                    float f = i2;
                    if (f > g2) {
                        g = i + g2;
                    } else {
                        String b = s21.b(this.d, this.b, f, this.e);
                        this.k = b;
                        ly0.a(this.g, b, i3);
                    }
                } else {
                    g = i + g((String) ly0.d(this.g, i3), this.e) + n;
                }
                i = (int) g;
                if (i <= this.i) {
                    break;
                }
                i3++;
            }
            i += i2;
            if (i <= this.i) {
            }
        }
        this.h = i3;
    }

    public final void b(Canvas canvas) {
        float f;
        float g;
        int i;
        int i2;
        int min = Math.min(this.h, this.g.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            int measuredHeight = getMeasuredHeight();
            if (TextUtils.equals((CharSequence) ly0.d(this.g, i4), this.c)) {
                canvas.drawText(this.c, l + i3, ((((measuredHeight - i2) / 2.0f) + (q / 2.0f)) - ((this.f.getFontMetrics().top + this.f.getFontMetrics().bottom) / 2.0f)) - 1.0f, this.f);
                f = i3;
                g = g(this.c, this.f) + l;
                i = n;
            } else {
                String str = (String) ly0.d(this.g, i4);
                if (!TextUtils.isEmpty(str)) {
                    f = i3;
                    canvas.drawText(str, f, e(this.e, measuredHeight), this.e);
                    g = g(str, this.e);
                    i = n;
                }
            }
            i3 = (int) (f + g + i);
        }
    }

    public final void h() {
        AdImageView adImageView = new AdImageView(getContext());
        this.a = adImageView;
        adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.a.setImageDrawable(getResources().getDrawable(R.drawable.nad_unlike_btn_icon));
        this.a.setId(R.id.nad_base_delete_id);
        this.a.setContentDescription("不感兴趣");
        s21.a(getContext(), this.a, 15.0f);
        setWillNotDraw(false);
        TextPaint textPaint = new TextPaint();
        this.e = textPaint;
        textPaint.setAntiAlias(true);
        this.e.setTextSize(o);
        this.e.setColor(r);
        TextPaint textPaint2 = new TextPaint();
        this.f = textPaint2;
        textPaint2.setAntiAlias(true);
        this.f.setTextSize(p);
        this.f.setColor(s);
        addView(this.a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s21.a(getContext(), this.a, 15.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a();
        int i5 = i3 - i;
        if (this.a.getVisibility() != 8) {
            int measuredHeight = this.a.getMeasuredHeight();
            int measuredWidth = this.a.getMeasuredWidth();
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            int i7 = (i5 - m) - measuredWidth;
            this.a.layout(i7, i6, measuredWidth + i7, measuredHeight + i6);
        }
    }
}
