package com.baidu.live.business.view.smarttab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tieba.s60;
/* loaded from: classes3.dex */
public class TabTextView extends AppCompatTextView {
    public final int a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public CharSequence g;
    public CharSequence h;
    public boolean i;
    public boolean j;
    public float k;
    public float l;
    public boolean m;
    public boolean n;
    public LinearGradient o;
    public boolean p;

    public TabTextView(Context context) {
        this(context, null);
    }

    private void setBold(boolean z) {
        if (z) {
            if (this.m) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        } else if (this.n) {
            setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            setTypeface(Typeface.DEFAULT);
        }
    }

    @Override // android.view.View
    public void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        e(z);
        setBold(z);
        d(z);
    }

    public final void e(boolean z) {
        if (this.p) {
            if (z) {
                float f = this.l;
                if (f != -1.0f) {
                    setTextSize(0, f);
                    return;
                }
                return;
            }
            float f2 = this.k;
            if (f2 != -1.0f) {
                setTextSize(0, f2);
            }
        }
    }

    public void setDefaultTextSize(float f) {
        this.k = f;
    }

    public void setGradientColorEnable(boolean z) {
        this.i = z;
    }

    public void setSelectedBold(boolean z) {
        this.m = z;
    }

    public void setSelectedColorEnable(boolean z) {
        this.j = z;
    }

    public void setSelectedTextSize(float f) {
        this.l = f;
    }

    public void setUnselectedBold(boolean z) {
        this.n = z;
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
        this.j = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s60.LiveFeedPageTabTextView);
        this.a = obtainStyledAttributes.getColor(7, 0);
        this.b = obtainStyledAttributes.getColor(1, 0);
        this.d = obtainStyledAttributes.getColor(4, 0);
        this.c = obtainStyledAttributes.getColor(2, 0);
        this.k = obtainStyledAttributes.getDimension(0, -1.0f);
        this.l = obtainStyledAttributes.getDimension(5, -1.0f);
        this.m = obtainStyledAttributes.getBoolean(3, true);
        this.n = obtainStyledAttributes.getBoolean(8, false);
        this.p = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
        h();
    }

    public final void d(boolean z) {
        if (z) {
            if (j()) {
                if (this.o == null) {
                    if (getMeasuredWidth() == 0) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    this.o = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.a, this.b}, (float[]) null, Shader.TileMode.CLAMP);
                }
                getPaint().setShader(this.o);
                return;
            }
            int i = this.d;
            if (i != 0 && !this.i && this.j) {
                setTextColor(i);
                int i2 = this.f;
                if (i2 != 0) {
                    setBackgroundResource(i2);
                }
                if (!TextUtils.isEmpty(this.h)) {
                    setText(this.h);
                    return;
                }
                return;
            }
            return;
        }
        getPaint().setShader(null);
        int i3 = this.c;
        if (i3 != 0 && !this.i && this.j) {
            setTextColor(i3);
            int i4 = this.e;
            if (i4 != 0) {
                setBackgroundResource(i4);
            }
            if (!TextUtils.isEmpty(this.g)) {
                setText(this.g);
            }
        }
    }

    public void g() {
        getPaint().setShader(null);
    }

    public final void h() {
        float f = this.k;
        if (f != -1.0f) {
            setTextSize(0, f);
        }
        int i = this.c;
        if (i != 0) {
            setTextColor(i);
        }
    }

    public final boolean j() {
        if (this.a != -1 && this.b != -1 && this.i) {
            return true;
        }
        return false;
    }
}
