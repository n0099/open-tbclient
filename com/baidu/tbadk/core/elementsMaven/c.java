package com.baidu.tbadk.core.elementsMaven;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes.dex */
public class c {
    private View eYO;
    private Drawable eYP;

    private c(View view) {
        this.eYO = view;
        this.eYP = a.bt(this.eYO);
    }

    public static c bv(View view) {
        return new c(view);
    }

    public c pC(int i) {
        if (this.eYO instanceof TextView) {
            ((TextView) this.eYO).setTextColor(a.getColor(i));
        }
        return this;
    }

    public c pD(int i) {
        if (this.eYO instanceof TextView) {
            ((TextView) this.eYO).setTextSize(0, a.pp(i));
        }
        return this;
    }

    public c pE(int i) {
        if (this.eYO instanceof TextView) {
            ((TextView) this.eYO).setTypeface(a.Bu(a.getString(i)));
        }
        return this;
    }

    public c pF(int i) {
        if (!(this.eYO instanceof EMTextView)) {
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        ((EMTextView) this.eYO).setLineSpacing(a.pp(i), ((EMTextView) this.eYO).getLineSpacingMultiplier());
        return this;
    }

    public c pG(int i) {
        if (this.eYO instanceof TextView) {
            ((TextView) this.eYO).setLinkTextColor(a.getColor(i));
        }
        return this;
    }

    public c pH(int i) {
        if (this.eYO instanceof TextView) {
            ((TextView) this.eYO).setTextColor(a.pr(i));
        }
        return this;
    }

    public void aM(int i, int i2) {
        if (this.eYO != null) {
            this.eYP = a.b(this.eYP, i, i2);
            this.eYO.setBackgroundDrawable(this.eYP);
        }
    }

    public void setBackGroundColor(int i) {
        Drawable a2;
        if (this.eYO != null && (a2 = a.a(this.eYP, i)) != null) {
            this.eYP = a2;
            this.eYO.setBackgroundDrawable(this.eYP);
        }
    }

    public void pI(int i) {
        Drawable a2;
        if (this.eYO != null && (a2 = a.a(this.eYP, a.getStringArray(i))) != null) {
            this.eYP = a2;
            this.eYO.setBackgroundDrawable(this.eYP);
        }
    }

    public void l(int[] iArr) {
        Drawable a2;
        if (this.eYO != null && (a2 = a.a(this.eYP, iArr)) != null) {
            this.eYP = a2;
            this.eYO.setBackgroundDrawable(this.eYP);
        }
    }

    public c pJ(int i) {
        if (this.eYO != null) {
            this.eYP = a.b(this.eYP, i);
        }
        return this;
    }

    public c pK(int i) {
        if (this.eYO != null) {
            this.eYP = a.c(this.eYP, i);
        }
        return this;
    }

    public c pL(int i) {
        Drawable a2;
        if (this.eYO != null && (a2 = a.a(this.eYO, this.eYP, a.getStringArray(i))) != null) {
            this.eYP = a2;
            this.eYO.setBackgroundDrawable(this.eYP);
            pP(1);
        }
        return this;
    }

    public c pM(int i) {
        Drawable d;
        if (this.eYO != null && (d = a.d(this.eYP, i)) != null) {
            this.eYP = d;
            this.eYO.setBackgroundDrawable(this.eYP);
        }
        return this;
    }

    public c pN(int i) {
        if (this.eYO != null) {
            this.eYP = a.e(this.eYP, i);
        }
        return this;
    }

    public c pO(int i) {
        if (this.eYO != null) {
            this.eYP = a.f(this.eYP, i);
        }
        return this;
    }

    public c pP(int i) {
        if (this.eYO != null) {
            this.eYO.setLayerType(i, null);
        }
        return this;
    }
}
