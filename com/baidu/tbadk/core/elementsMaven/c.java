package com.baidu.tbadk.core.elementsMaven;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes.dex */
public class c {
    private View eHF;
    private Drawable eHG;

    private c(View view) {
        this.eHF = view;
        this.eHG = a.bi(this.eHF);
    }

    public static c bj(View view) {
        return new c(view);
    }

    public c oT(int i) {
        if (this.eHF instanceof TextView) {
            ((TextView) this.eHF).setTextColor(a.getColor(i));
        }
        return this;
    }

    public c oU(int i) {
        if (this.eHF instanceof TextView) {
            ((TextView) this.eHF).setTextSize(0, a.oG(i));
        }
        return this;
    }

    public c oV(int i) {
        if (this.eHF instanceof TextView) {
            ((TextView) this.eHF).setTypeface(a.AO(a.getString(i)));
        }
        return this;
    }

    public c oW(int i) {
        if (!(this.eHF instanceof EMTextView)) {
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        ((EMTextView) this.eHF).setLineSpacing(a.oG(i), ((EMTextView) this.eHF).getLineSpacingMultiplier());
        return this;
    }

    public c oX(int i) {
        if (this.eHF instanceof TextView) {
            ((TextView) this.eHF).setLinkTextColor(a.getColor(i));
        }
        return this;
    }

    public c oY(int i) {
        if (this.eHF instanceof TextView) {
            ((TextView) this.eHF).setTextColor(a.oI(i));
        }
        return this;
    }

    public void aN(int i, int i2) {
        if (this.eHF != null) {
            this.eHG = a.a(this.eHG, i, i2);
            this.eHF.setBackgroundDrawable(this.eHG);
        }
    }

    public void setBackGroundColor(int i) {
        if (this.eHF != null) {
            this.eHG = a.a(this.eHG, i);
            if (this.eHG != null) {
                this.eHF.setBackgroundDrawable(this.eHG);
            }
        }
    }

    public void oZ(int i) {
        if (this.eHF != null) {
            this.eHG = a.a(this.eHG, a.getStringArray(i));
            if (this.eHG != null) {
                this.eHF.setBackgroundDrawable(this.eHG);
            }
        }
    }

    public void k(int[] iArr) {
        if (this.eHF != null) {
            this.eHG = a.a(this.eHG, iArr);
            if (this.eHG != null) {
                this.eHF.setBackgroundDrawable(this.eHG);
            }
        }
    }

    public c pa(int i) {
        if (this.eHF != null) {
            this.eHG = a.b(this.eHG, i);
        }
        return this;
    }

    public c pb(int i) {
        if (this.eHF != null) {
            this.eHG = a.c(this.eHG, i);
        }
        return this;
    }

    public c pc(int i) {
        if (this.eHF != null) {
            this.eHG = a.d(this.eHG, i);
            if (this.eHG != null) {
                this.eHF.setBackgroundDrawable(this.eHG);
            }
        }
        return this;
    }

    public c pd(int i) {
        if (this.eHF != null) {
            this.eHG = a.e(this.eHG, i);
        }
        return this;
    }

    public c pe(int i) {
        if (this.eHF != null) {
            this.eHG = a.f(this.eHG, i);
        }
        return this;
    }
}
