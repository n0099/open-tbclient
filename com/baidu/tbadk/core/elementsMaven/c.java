package com.baidu.tbadk.core.elementsMaven;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes.dex */
public class c {
    private View eUd;
    private Drawable eUe;

    private c(View view) {
        this.eUd = view;
        this.eUe = a.bt(this.eUd);
    }

    public static c bv(View view) {
        return new c(view);
    }

    public c nV(int i) {
        if (this.eUd instanceof TextView) {
            ((TextView) this.eUd).setTextColor(a.getColor(i));
        }
        return this;
    }

    public c nW(int i) {
        if (this.eUd instanceof TextView) {
            ((TextView) this.eUd).setTextSize(0, a.nI(i));
        }
        return this;
    }

    public c nX(int i) {
        if (this.eUd instanceof TextView) {
            ((TextView) this.eUd).setTypeface(a.Ai(a.getString(i)));
        }
        return this;
    }

    public c nY(int i) {
        if (!(this.eUd instanceof EMTextView)) {
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        ((EMTextView) this.eUd).setLineSpacing(a.nI(i), ((EMTextView) this.eUd).getLineSpacingMultiplier());
        return this;
    }

    public c nZ(int i) {
        if (this.eUd instanceof TextView) {
            ((TextView) this.eUd).setLinkTextColor(a.getColor(i));
        }
        return this;
    }

    public c oa(int i) {
        if (this.eUd instanceof TextView) {
            ((TextView) this.eUd).setTextColor(a.nK(i));
        }
        return this;
    }

    public void aM(int i, int i2) {
        if (this.eUd != null) {
            this.eUe = a.b(this.eUe, i, i2);
            this.eUd.setBackgroundDrawable(this.eUe);
        }
    }

    public void setBackGroundColor(int i) {
        Drawable a2;
        if (this.eUd != null && (a2 = a.a(this.eUe, i)) != null) {
            this.eUe = a2;
            this.eUd.setBackgroundDrawable(this.eUe);
        }
    }

    public void ob(int i) {
        Drawable a2;
        if (this.eUd != null && (a2 = a.a(this.eUe, a.getStringArray(i))) != null) {
            this.eUe = a2;
            this.eUd.setBackgroundDrawable(this.eUe);
        }
    }

    public void l(int[] iArr) {
        Drawable a2;
        if (this.eUd != null && (a2 = a.a(this.eUe, iArr)) != null) {
            this.eUe = a2;
            this.eUd.setBackgroundDrawable(this.eUe);
        }
    }

    public c oc(int i) {
        if (this.eUd != null) {
            this.eUe = a.b(this.eUe, i);
        }
        return this;
    }

    public c od(int i) {
        if (this.eUd != null) {
            this.eUe = a.c(this.eUe, i);
        }
        return this;
    }

    public c oe(int i) {
        Drawable a2;
        if (this.eUd != null && (a2 = a.a(this.eUd, this.eUe, a.getStringArray(i))) != null) {
            this.eUe = a2;
            this.eUd.setBackgroundDrawable(this.eUe);
            oi(1);
        }
        return this;
    }

    public c of(int i) {
        Drawable d;
        if (this.eUd != null && (d = a.d(this.eUe, i)) != null) {
            this.eUe = d;
            this.eUd.setBackgroundDrawable(this.eUe);
        }
        return this;
    }

    public c og(int i) {
        if (this.eUd != null) {
            this.eUe = a.e(this.eUe, i);
        }
        return this;
    }

    public c oh(int i) {
        if (this.eUd != null) {
            this.eUe = a.f(this.eUe, i);
        }
        return this;
    }

    public c oi(int i) {
        if (this.eUd != null) {
            this.eUd.setLayerType(i, null);
        }
        return this;
    }
}
