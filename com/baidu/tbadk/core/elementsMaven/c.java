package com.baidu.tbadk.core.elementsMaven;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes.dex */
public class c {
    private View eWt;
    private Drawable eWu;

    private c(View view) {
        this.eWt = view;
        this.eWu = a.bp(this.eWt);
    }

    public static c br(View view) {
        return new c(view);
    }

    public c nY(int i) {
        if (this.eWt instanceof TextView) {
            ((TextView) this.eWt).setTextColor(a.getColor(i));
        }
        return this;
    }

    public c nZ(int i) {
        if (this.eWt instanceof TextView) {
            ((TextView) this.eWt).setTextSize(0, a.nL(i));
        }
        return this;
    }

    public c oa(int i) {
        if (this.eWt instanceof TextView) {
            ((TextView) this.eWt).setTypeface(a.Az(a.getString(i)));
        }
        return this;
    }

    public c ob(int i) {
        if (!(this.eWt instanceof EMTextView)) {
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        ((EMTextView) this.eWt).setLineSpacing(a.nL(i), ((EMTextView) this.eWt).getLineSpacingMultiplier());
        return this;
    }

    public c oc(int i) {
        if (this.eWt instanceof TextView) {
            ((TextView) this.eWt).setLinkTextColor(a.getColor(i));
        }
        return this;
    }

    public c od(int i) {
        if (this.eWt instanceof TextView) {
            ((TextView) this.eWt).setTextColor(a.nN(i));
        }
        return this;
    }

    public void aJ(int i, int i2) {
        if (this.eWt != null) {
            this.eWu = a.b(this.eWu, i, i2);
            this.eWt.setBackgroundDrawable(this.eWu);
        }
    }

    public void setBackGroundColor(int i) {
        Drawable a2;
        if (this.eWt != null && (a2 = a.a(this.eWu, i)) != null) {
            this.eWu = a2;
            this.eWt.setBackgroundDrawable(this.eWu);
        }
    }

    public void oe(int i) {
        Drawable a2;
        if (this.eWt != null && (a2 = a.a(this.eWu, a.getStringArray(i))) != null) {
            this.eWu = a2;
            this.eWt.setBackgroundDrawable(this.eWu);
        }
    }

    public void l(int[] iArr) {
        Drawable a2;
        if (this.eWt != null && (a2 = a.a(this.eWu, iArr)) != null) {
            this.eWu = a2;
            this.eWt.setBackgroundDrawable(this.eWu);
        }
    }

    public c of(int i) {
        if (this.eWt != null) {
            this.eWu = a.b(this.eWu, i);
        }
        return this;
    }

    public c og(int i) {
        if (this.eWt != null) {
            this.eWu = a.c(this.eWu, i);
        }
        return this;
    }

    public c oh(int i) {
        Drawable a2;
        if (this.eWt != null && (a2 = a.a(this.eWt, this.eWu, a.getStringArray(i))) != null) {
            this.eWu = a2;
            this.eWt.setBackgroundDrawable(this.eWu);
            om(1);
        }
        return this;
    }

    public c oi(int i) {
        if (this.eWt instanceof TextView) {
            float[] nO = a.nO(i);
            ((TextView) this.eWt).setShadowLayer(nO[1], nO[2], nO[3], (int) nO[0]);
        }
        return this;
    }

    public c oj(int i) {
        Drawable d;
        if (this.eWt != null && (d = a.d(this.eWu, i)) != null) {
            this.eWu = d;
            this.eWt.setBackgroundDrawable(this.eWu);
        }
        return this;
    }

    public c ok(int i) {
        if (this.eWt != null) {
            this.eWu = a.e(this.eWu, i);
        }
        return this;
    }

    public c ol(int i) {
        if (this.eWt != null) {
            this.eWu = a.f(this.eWu, i);
        }
        return this;
    }

    public c om(int i) {
        if (this.eWt != null) {
            this.eWt.setLayerType(i, null);
        }
        return this;
    }
}
