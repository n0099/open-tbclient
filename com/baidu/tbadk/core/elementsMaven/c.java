package com.baidu.tbadk.core.elementsMaven;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes.dex */
public class c {
    private View eOP;
    private Drawable eOQ;

    private c(View view) {
        this.eOP = view;
        this.eOQ = a.bk(this.eOP);
    }

    public static c bm(View view) {
        return new c(view);
    }

    public c ps(int i) {
        if (this.eOP instanceof TextView) {
            ((TextView) this.eOP).setTextColor(a.getColor(i));
        }
        return this;
    }

    public c pt(int i) {
        if (this.eOP instanceof TextView) {
            ((TextView) this.eOP).setTextSize(0, a.pe(i));
        }
        return this;
    }

    public c pu(int i) {
        if (this.eOP instanceof TextView) {
            ((TextView) this.eOP).setTypeface(a.Bv(a.getString(i)));
        }
        return this;
    }

    public c pv(int i) {
        if (!(this.eOP instanceof EMTextView)) {
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        ((EMTextView) this.eOP).setLineSpacing(a.pe(i), ((EMTextView) this.eOP).getLineSpacingMultiplier());
        return this;
    }

    public c pw(int i) {
        if (this.eOP instanceof TextView) {
            ((TextView) this.eOP).setLinkTextColor(a.getColor(i));
        }
        return this;
    }

    public c px(int i) {
        if (this.eOP instanceof TextView) {
            ((TextView) this.eOP).setTextColor(a.pg(i));
        }
        return this;
    }

    public void aP(int i, int i2) {
        if (this.eOP != null) {
            this.eOQ = a.a(this.eOQ, i, i2);
            this.eOP.setBackgroundDrawable(this.eOQ);
        }
    }

    public void setBackGroundColor(int i) {
        Drawable a2;
        if (this.eOP != null && (a2 = a.a(this.eOQ, i)) != null) {
            this.eOQ = a2;
            this.eOP.setBackgroundDrawable(this.eOQ);
        }
    }

    public void py(int i) {
        Drawable a2;
        if (this.eOP != null && (a2 = a.a(this.eOQ, a.getStringArray(i))) != null) {
            this.eOQ = a2;
            this.eOP.setBackgroundDrawable(this.eOQ);
        }
    }

    public void k(int[] iArr) {
        Drawable a2;
        if (this.eOP != null && (a2 = a.a(this.eOQ, iArr)) != null) {
            this.eOQ = a2;
            this.eOP.setBackgroundDrawable(this.eOQ);
        }
    }

    public c pz(int i) {
        if (this.eOP != null) {
            this.eOQ = a.b(this.eOQ, i);
        }
        return this;
    }

    public c pA(int i) {
        if (this.eOP != null) {
            this.eOQ = a.c(this.eOQ, i);
        }
        return this;
    }

    public c pB(int i) {
        Drawable a2;
        if (this.eOP != null && (a2 = a.a(this.eOP, this.eOQ, a.getStringArray(i))) != null) {
            this.eOQ = a2;
            this.eOP.setBackgroundDrawable(this.eOQ);
            pF(1);
        }
        return this;
    }

    public c pC(int i) {
        Drawable d;
        if (this.eOP != null && (d = a.d(this.eOQ, i)) != null) {
            this.eOQ = d;
            this.eOP.setBackgroundDrawable(this.eOQ);
        }
        return this;
    }

    public c pD(int i) {
        if (this.eOP != null) {
            this.eOQ = a.e(this.eOQ, i);
        }
        return this;
    }

    public c pE(int i) {
        if (this.eOP != null) {
            this.eOQ = a.f(this.eOQ, i);
        }
        return this;
    }

    public c pF(int i) {
        if (this.eOP != null) {
            this.eOP.setLayerType(i, null);
        }
        return this;
    }
}
