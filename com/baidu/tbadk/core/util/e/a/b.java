package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes2.dex */
public class b extends a {
    private float centerX;
    private float centerY;
    private int enA;
    private int enB;
    private int enC;
    private int enD;
    private int enE;
    private int enF;
    private int enG;
    private StateListDrawable enb;
    private int[] enh;
    private float eni;
    private boolean enl;
    private boolean enm;
    private boolean enn;
    private boolean eno;
    private boolean enp;
    private int enx;
    private int eny;
    private int enz;
    private int height;
    private int width;
    private int enc = 1;
    private int ene = 1;
    private float enf = 1.0f;
    private float eng = 1.0f;
    private int enj = 0;
    private String enk = "TOP_BOTTOM";
    private float enq = 0.0f;
    private float enr = 0.0f;
    private float ens = 0.0f;
    private float ent = 0.0f;
    private int enu = 0;
    private int mCornerRadius = 0;
    private int enw = 0;
    private boolean enH = false;
    private boolean enI = false;
    private boolean enJ = false;
    private boolean enK = false;
    private boolean enL = false;
    private boolean enM = false;
    private boolean enN = false;
    private boolean enO = false;

    public static b bjR() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.dEA = drawable;
        if (!this.emW) {
            this.emS = drawable;
        }
        if (!this.emX) {
            this.emV = drawable;
        }
        if (!this.emY) {
            this.emT = drawable;
        }
        if (!this.emZ) {
            this.emU = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.emV = drawable;
        this.emX = true;
        return this;
    }

    public b oc(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b od(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b oe(int i) {
        this.enu = i;
        return this;
    }

    public b of(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enx = color;
        this.enl = true;
        if (!this.enH) {
            this.eny = color;
        }
        if (!this.enI) {
            this.enz = color;
        }
        if (!this.enJ) {
            this.enA = color;
        }
        if (!this.enK) {
            this.enB = color;
        }
        return this;
    }

    public b aQ(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.enx = color;
        this.enl = true;
        if (!this.enH) {
            this.eny = color;
        }
        if (!this.enI) {
            this.enz = color;
        }
        if (!this.enJ) {
            this.enA = color;
        }
        if (!this.enK) {
            this.enB = color;
        }
        return this;
    }

    public b Aw(String str) {
        int fn = com.baidu.tbadk.core.util.e.c.a.fn(str);
        this.enx = fn;
        this.enl = true;
        if (!this.enH) {
            this.eny = fn;
        }
        if (!this.enI) {
            this.enz = fn;
        }
        if (!this.enJ) {
            this.enA = fn;
        }
        if (!this.enK) {
            this.enB = fn;
        }
        return this;
    }

    public b og(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.enx = color;
        this.enl = true;
        if (!this.enH) {
            this.eny = color;
        }
        if (!this.enI) {
            this.enz = color;
        }
        if (!this.enJ) {
            this.enA = color;
        }
        if (!this.enK) {
            this.enB = color;
        }
        return this;
    }

    public b oh(@ColorRes int i) {
        this.enz = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enI = true;
        this.enl = true;
        return this;
    }

    public b oi(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enC = color;
        this.enm = true;
        if (!this.enL) {
            this.enD = color;
        }
        if (!this.enM) {
            this.enE = color;
        }
        if (!this.enN) {
            this.enF = color;
        }
        if (!this.enO) {
            this.enG = color;
        }
        return this;
    }

    public b oj(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b ok(int i) {
        this.enw = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.eno = true;
        this.enh = new int[2];
        this.enh[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enh[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.enj = 0;
        this.enk = "TOP_BOTTOM";
        return this;
    }

    public b i(@ColorRes int... iArr) {
        this.eno = true;
        this.enj = 0;
        this.enk = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.enh = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.enh[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b j(@ColorRes int... iArr) {
        this.eno = true;
        this.enj = 0;
        this.enk = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.enh = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.enh[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.eno = true;
        this.enj = 0;
        this.enk = str;
        if (iArr.length > 1) {
            this.enh = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.enh[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b V(float f) {
        this.enp = true;
        this.enq = f;
        this.enr = f;
        this.ens = f;
        this.ent = f;
        return this;
    }

    public b W(float f) {
        this.enp = true;
        this.enq = f;
        return this;
    }

    public b X(float f) {
        this.enp = true;
        this.enr = f;
        return this;
    }

    public b Y(float f) {
        this.enp = true;
        this.ens = f;
        return this;
    }

    public b Z(float f) {
        this.enp = true;
        this.ent = f;
        return this;
    }

    public b ol(int i) {
        this.mType = i;
        return this;
    }

    public b om(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.ena = true;
        return this;
    }

    private GradientDrawable.Orientation bjS() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.enk;
        char c = 65535;
        switch (str.hashCode()) {
            case -1196165855:
                if (str.equals("BOTTOM_TOP")) {
                    c = 4;
                    break;
                }
                break;
            case -873241494:
                if (str.equals("RIGHT_LEFT")) {
                    c = 2;
                    break;
                }
                break;
            case -434150460:
                if (str.equals("LEFT_RIGHT")) {
                    c = 6;
                    break;
                }
                break;
            case 63310483:
                if (str.equals("BL_TR")) {
                    c = 5;
                    break;
                }
                break;
            case 63489223:
                if (str.equals("BR_TL")) {
                    c = 3;
                    break;
                }
                break;
            case 79933303:
                if (str.equals("TL_BR")) {
                    c = 7;
                    break;
                }
                break;
            case 80112043:
                if (str.equals("TR_BL")) {
                    c = 1;
                    break;
                }
                break;
            case 1982197877:
                if (str.equals("TOP_BOTTOM")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case 1:
                return GradientDrawable.Orientation.TR_BL;
            case 2:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 3:
                return GradientDrawable.Orientation.BR_TL;
            case 4:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 5:
                return GradientDrawable.Orientation.BL_TR;
            case 6:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 7:
                return GradientDrawable.Orientation.TL_BR;
            default:
                return GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }

    private GradientDrawable r(int i, int i2, int i3, int i4) {
        GradientDrawable gradientDrawable;
        if (this.eno && this.enh != null && this.enh.length > 1) {
            gradientDrawable = new GradientDrawable(bjS(), this.enh);
            gradientDrawable.setGradientType(this.enj);
            switch (this.enj) {
                case 1:
                    gradientDrawable.setGradientRadius(this.eni);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.enl) {
            gradientDrawable.setColor(i2);
        }
        if (this.enm) {
            gradientDrawable.setStroke(this.enw, i3);
        } else if (this.enn) {
            gradientDrawable.setStroke(this.enc, i4, this.enf, this.eng);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.enp) {
            gradientDrawable.setCornerRadii(new float[]{this.enr, this.enr, this.enq, this.enq, this.ens, this.ens, this.ent, this.ent});
        }
        if (this.width > 0 && this.height > 0) {
            gradientDrawable.setSize(this.width, this.height);
        }
        if (this.centerX > 0.0f || this.centerY > 0.0f) {
            gradientDrawable.setGradientCenter(this.centerX, this.centerY);
        }
        e(gradientDrawable);
        return gradientDrawable;
    }

    public void aZ(View view) {
        if (view != null) {
            bjT();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.enb);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.enb);
            }
        }
    }

    public StateListDrawable bjT() {
        this.enb = bjU();
        return this.enb;
    }

    public StateListDrawable bjU() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable bjV = bjV();
        if (bjV != null) {
            stateListDrawable.addState(new int[]{-16842910}, bjV);
        }
        Drawable bjW = bjW();
        if (bjW != null) {
            stateListDrawable.addState(new int[]{16842919}, bjW);
        }
        Drawable bjX = bjX();
        if (bjX != null) {
            stateListDrawable.addState(new int[]{16842913}, bjX);
        }
        Drawable bjY = bjY();
        if (bjY != null) {
            stateListDrawable.addState(new int[]{16842908}, bjY);
        }
        Drawable bjZ = bjZ();
        if (bjZ == null) {
            bjZ = new ColorDrawable(0);
        }
        if (bjZ != null) {
            stateListDrawable.addState(new int[0], bjZ);
        }
        return stateListDrawable;
    }

    public Drawable bjV() {
        Drawable drawable = this.emS;
        if (this.emW) {
            drawable = this.emS;
        }
        if (this.enH || this.enL) {
            return r(this.enu, this.eny, this.enD, this.ene);
        }
        return drawable;
    }

    public Drawable bjW() {
        Drawable drawable = this.emV;
        if (this.emX) {
            return this.emV;
        }
        if (this.enI || this.enM) {
            return r(this.enu, this.enz, this.enE, this.ene);
        }
        return drawable;
    }

    public Drawable bjX() {
        Drawable drawable = this.emT;
        if (this.emY) {
            return this.emT;
        }
        if (this.enJ || this.enN) {
            return r(this.enu, this.enA, this.enF, this.ene);
        }
        return drawable;
    }

    public Drawable bjY() {
        Drawable drawable = this.emU;
        if (this.emZ) {
            return this.emU;
        }
        if (this.enK || this.enO) {
            return r(this.enu, this.enB, this.enG, this.ene);
        }
        return drawable;
    }

    public Drawable bjZ() {
        Drawable drawable = this.dEA;
        if (this.dEA == null) {
            return r(this.enu, this.enx, this.enC, this.ene);
        }
        return drawable;
    }
}
