package com.baidu.tbadk.core.elementsMaven;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes.dex */
public class c {
    private View eXS;
    private Drawable eXT;

    private c(View view) {
        this.eXS = view;
        this.eXT = a.bp(this.eXS);
    }

    public static c br(View view) {
        return new c(view);
    }

    public c nZ(int i) {
        if (this.eXS instanceof TextView) {
            ((TextView) this.eXS).setTextColor(a.getColor(i));
        }
        return this;
    }

    public c oa(int i) {
        if (this.eXS instanceof TextView) {
            ((TextView) this.eXS).setTextSize(0, a.nM(i));
        }
        return this;
    }

    public c ob(int i) {
        if (this.eXS instanceof TextView) {
            ((TextView) this.eXS).setTypeface(a.AG(a.getString(i)));
        }
        return this;
    }

    public c oc(int i) {
        if (!(this.eXS instanceof EMTextView)) {
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        ((EMTextView) this.eXS).setLineSpacing(a.nM(i), ((EMTextView) this.eXS).getLineSpacingMultiplier());
        return this;
    }

    public c od(int i) {
        if (this.eXS instanceof TextView) {
            ((TextView) this.eXS).setLinkTextColor(a.getColor(i));
        }
        return this;
    }

    public c oe(int i) {
        if (this.eXS instanceof TextView) {
            ((TextView) this.eXS).setTextColor(a.nO(i));
        }
        return this;
    }

    public void aJ(int i, int i2) {
        if (this.eXS != null) {
            this.eXT = a.b(this.eXT, i, i2);
            this.eXS.setBackgroundDrawable(this.eXT);
        }
    }

    public void setBackGroundColor(int i) {
        Drawable a2;
        if (this.eXS != null && (a2 = a.a(this.eXT, i)) != null) {
            this.eXT = a2;
            this.eXS.setBackgroundDrawable(this.eXT);
        }
    }

    public void of(int i) {
        Drawable a2;
        if (this.eXS != null && (a2 = a.a(this.eXT, a.getStringArray(i))) != null) {
            this.eXT = a2;
            this.eXS.setBackgroundDrawable(this.eXT);
        }
    }

    public void l(int[] iArr) {
        Drawable a2;
        if (this.eXS != null && (a2 = a.a(this.eXT, iArr)) != null) {
            this.eXT = a2;
            this.eXS.setBackgroundDrawable(this.eXT);
        }
    }

    public c og(int i) {
        if (this.eXS != null) {
            this.eXT = a.b(this.eXT, i);
        }
        return this;
    }

    public c oh(int i) {
        if (this.eXS != null) {
            this.eXT = a.c(this.eXT, i);
        }
        return this;
    }

    public c oi(int i) {
        Drawable a2;
        if (this.eXS != null && (a2 = a.a(this.eXS, this.eXT, a.getStringArray(i))) != null) {
            this.eXT = a2;
            this.eXS.setBackgroundDrawable(this.eXT);
            on(1);
        }
        return this;
    }

    public c oj(int i) {
        if (this.eXS instanceof TextView) {
            float[] nP = a.nP(i);
            ((TextView) this.eXS).setShadowLayer(nP[1], nP[2], nP[3], (int) nP[0]);
        }
        return this;
    }

    public c ok(int i) {
        Drawable d;
        if (this.eXS != null && (d = a.d(this.eXT, i)) != null) {
            this.eXT = d;
            this.eXS.setBackgroundDrawable(this.eXT);
        }
        return this;
    }

    public c ol(int i) {
        if (this.eXS != null) {
            this.eXT = a.e(this.eXT, i);
        }
        return this;
    }

    public c om(int i) {
        if (this.eXS != null) {
            this.eXT = a.f(this.eXT, i);
        }
        return this;
    }

    public c on(int i) {
        if (this.eXS != null) {
            this.eXS.setLayerType(i, null);
        }
        return this;
    }
}
