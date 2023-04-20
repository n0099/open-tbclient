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
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b41;
import com.baidu.tieba.ji0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.v41;
import com.baidu.tieba.w01;
import com.baidu.tieba.zp0;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class NadExpressBottomView extends ViewGroup {
    public static final int l = b41.c.a(ji0.b(), 3.0f);
    public static final int m = b41.c.a(ji0.b(), 0.0f);
    public static final int n = e(R.dimen.NAD_F_M_W_X007);
    public static final int o = e(R.dimen.nad_label_source_max_width);
    public static final int p = e(R.dimen.nad_ad_label_source_max_width);
    public static final int q = e(R.dimen.nad_label_tag_max_width) - (l * 2);
    public static final int r = e(R.dimen.NAD_F_T_X033);
    public static final int s = e(R.dimen.NAD_F_T_X033);
    public static final int t = e(R.dimen.nad_tag_height);
    public static final int u = d(R.color.NAD_FC2);
    public static final int v = d(R.color.NAD_FC1);
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

    public final void i() {
        AdImageView adImageView = new AdImageView(getContext());
        this.a = adImageView;
        adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.a.setImageDrawable(getResources().getDrawable(R.drawable.nad_unlike_btn_icon));
        this.a.setId(R.id.nad_base_delete_id);
        this.a.setContentDescription("不感兴趣");
        v41.a(getContext(), this.a, 15.0f);
        setWillNotDraw(false);
        TextPaint textPaint = new TextPaint();
        this.e = textPaint;
        textPaint.setAntiAlias(true);
        this.e.setTextSize(r);
        this.e.setColor(u);
        TextPaint textPaint2 = new TextPaint();
        this.f = textPaint2;
        textPaint2.setAntiAlias(true);
        this.f.setTextSize(s);
        this.f.setColor(v);
        addView(this.a);
    }

    public NadExpressBottomView(Context context) {
        this(context, null);
    }

    public static int d(int i) {
        return ContextCompat.getColor(ji0.b(), i);
    }

    public static int e(int i) {
        return ji0.b().getResources().getDimensionPixelSize(i);
    }

    public final float g(TextPaint textPaint) {
        return textPaint.getFontMetrics().bottom - textPaint.getFontMetrics().top;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        c(canvas);
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

    public final float f(TextPaint textPaint, int i) {
        return ((i - g(textPaint)) / 2.0f) - textPaint.getFontMetrics().top;
    }

    public final float h(String str, TextPaint textPaint) {
        return textPaint.measureText(str);
    }

    public final void k(int i, int i2) {
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
        k(i, i2);
        setMeasuredDimension(this.i, this.j);
    }

    public NadExpressBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList<>(4);
        this.h = 0;
        this.i = 0;
        this.j = s;
        i();
    }

    public final String a(String str, float f, TextPaint textPaint) {
        return TextUtils.ellipsize(str, textPaint, f, TextUtils.TruncateAt.END).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[LOOP:0: B:10:0x001e->B:29:0x00b2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[EDGE_INSN: B:33:0x00b6->B:30:0x00b6 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        int i;
        float h;
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
            if (TextUtils.equals((CharSequence) w01.d(this.g, i3), this.c)) {
                i = (int) (i + h((String) w01.d(this.g, i3), this.f) + n);
                i2 = l * 2;
            } else {
                if (!TextUtils.isEmpty(this.b) && TextUtils.equals((CharSequence) w01.d(this.g, i3), this.k)) {
                    i2 = this.i - i;
                    float h2 = h((String) w01.d(this.g, i3), this.e) + n;
                    float f = i2;
                    if (f > h2) {
                        h = i + h2;
                    } else {
                        String b = v41.b(this.d, this.b, f, this.e);
                        this.k = b;
                        w01.a(this.g, b, i3);
                    }
                } else {
                    h = i + h((String) w01.d(this.g, i3), this.e) + n;
                }
                i = (int) h;
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

    public final void c(Canvas canvas) {
        float f;
        float h;
        int i;
        int i2;
        int min = Math.min(this.h, this.g.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            int measuredHeight = getMeasuredHeight();
            if (TextUtils.equals((CharSequence) w01.d(this.g, i4), this.c)) {
                canvas.drawText(this.c, l + i3, ((((measuredHeight - i2) / 2.0f) + (t / 2.0f)) - ((this.f.getFontMetrics().top + this.f.getFontMetrics().bottom) / 2.0f)) - 1.0f, this.f);
                f = i3;
                h = h(this.c, this.f) + l;
                i = n;
            } else {
                String str = (String) w01.d(this.g, i4);
                if (!TextUtils.isEmpty(str)) {
                    f = i3;
                    canvas.drawText(str, f, f(this.e, measuredHeight), this.e);
                    h = h(str, this.e);
                    i = n;
                }
            }
            i3 = (int) (f + h + i);
        }
    }

    public final void j() {
        this.g.clear();
        if (!TextUtils.isEmpty(this.c)) {
            String a = a(this.c, q, this.f);
            this.c = a;
            w01.b(this.g, a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            String b = v41.b(this.d, this.b, p, this.e);
            this.k = b;
            w01.b(this.g, b);
        } else if (!TextUtils.isEmpty(this.d)) {
            String a2 = a(this.d, o, this.e);
            this.d = a2;
            w01.b(this.g, a2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v41.a(getContext(), this.a, 15.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b();
        int i5 = i3 - i;
        if (this.a.getVisibility() != 8) {
            int measuredHeight = this.a.getMeasuredHeight();
            int measuredWidth = this.a.getMeasuredWidth();
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            int i7 = (i5 - m) - measuredWidth;
            this.a.layout(i7, i6, measuredWidth + i7, measuredHeight + i6);
        }
    }

    public void update(AdBaseModel adBaseModel) {
        zp0.a aVar;
        if (adBaseModel == null) {
            return;
        }
        pp0 pp0Var = adBaseModel.f;
        this.b = pp0Var.h;
        this.d = pp0Var.e;
        this.c = pp0Var.i;
        setNeedShowUnlikeIcon(true);
        j();
        this.j = s;
        zp0 zp0Var = adBaseModel.p;
        if (zp0Var != null && (aVar = zp0Var.j) != null) {
            int i = aVar.f;
            int i2 = aVar.g;
            int i3 = aVar.i;
            if (i != 0) {
                this.e.setTextSize(e(i));
                this.j = e(i);
            }
            if (i2 != 0) {
                this.e.setColor(d(i2));
            }
            if (i3 != 0) {
                this.a.setImageDrawable(getResources().getDrawable(i3));
            }
        }
        requestLayout();
    }
}
