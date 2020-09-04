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
/* loaded from: classes.dex */
public class b extends a {
    private float centerX;
    private float centerY;
    private int enB;
    private int enC;
    private int enD;
    private int enE;
    private int enF;
    private int enG;
    private int enH;
    private int enI;
    private int enJ;
    private int enK;
    private StateListDrawable eng;
    private int[] enl;
    private float enm;
    private boolean enp;
    private boolean enq;
    private boolean enr;
    private boolean ens;
    private boolean ent;
    private int height;
    private int width;
    private int enh = 1;
    private int eni = 1;
    private float enj = 1.0f;
    private float enk = 1.0f;
    private int enn = 0;
    private String eno = "TOP_BOTTOM";
    private float enu = 0.0f;
    private float enw = 0.0f;
    private float enx = 0.0f;
    private float eny = 0.0f;
    private int enz = 0;
    private int mCornerRadius = 0;
    private int enA = 0;
    private boolean enL = false;
    private boolean enM = false;
    private boolean enN = false;
    private boolean enO = false;
    private boolean enP = false;
    private boolean enQ = false;
    private boolean enR = false;
    private boolean enS = false;

    public static b bjR() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.dEE = drawable;
        if (!this.ena) {
            this.emW = drawable;
        }
        if (!this.enb) {
            this.emZ = drawable;
        }
        if (!this.enc) {
            this.emX = drawable;
        }
        if (!this.ene) {
            this.emY = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.emZ = drawable;
        this.enb = true;
        return this;
    }

    public b oc(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b od(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b oe(int i) {
        this.enz = i;
        return this;
    }

    public b of(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enB = color;
        this.enp = true;
        if (!this.enL) {
            this.enC = color;
        }
        if (!this.enM) {
            this.enD = color;
        }
        if (!this.enN) {
            this.enE = color;
        }
        if (!this.enO) {
            this.enF = color;
        }
        return this;
    }

    public b aQ(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.enB = color;
        this.enp = true;
        if (!this.enL) {
            this.enC = color;
        }
        if (!this.enM) {
            this.enD = color;
        }
        if (!this.enN) {
            this.enE = color;
        }
        if (!this.enO) {
            this.enF = color;
        }
        return this;
    }

    public b Ax(String str) {
        int fo = com.baidu.tbadk.core.util.e.c.a.fo(str);
        this.enB = fo;
        this.enp = true;
        if (!this.enL) {
            this.enC = fo;
        }
        if (!this.enM) {
            this.enD = fo;
        }
        if (!this.enN) {
            this.enE = fo;
        }
        if (!this.enO) {
            this.enF = fo;
        }
        return this;
    }

    public b og(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.enB = color;
        this.enp = true;
        if (!this.enL) {
            this.enC = color;
        }
        if (!this.enM) {
            this.enD = color;
        }
        if (!this.enN) {
            this.enE = color;
        }
        if (!this.enO) {
            this.enF = color;
        }
        return this;
    }

    public b oh(@ColorRes int i) {
        this.enD = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enM = true;
        this.enp = true;
        return this;
    }

    public b oi(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enG = color;
        this.enq = true;
        if (!this.enP) {
            this.enH = color;
        }
        if (!this.enQ) {
            this.enI = color;
        }
        if (!this.enR) {
            this.enJ = color;
        }
        if (!this.enS) {
            this.enK = color;
        }
        return this;
    }

    public b oj(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b ok(int i) {
        this.enA = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.ens = true;
        this.enl = new int[2];
        this.enl[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.enl[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.enn = 0;
        this.eno = "TOP_BOTTOM";
        return this;
    }

    public b i(@ColorRes int... iArr) {
        this.ens = true;
        this.enn = 0;
        this.eno = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.enl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.enl[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b j(@ColorRes int... iArr) {
        this.ens = true;
        this.enn = 0;
        this.eno = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.enl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.enl[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.ens = true;
        this.enn = 0;
        this.eno = str;
        if (iArr.length > 1) {
            this.enl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.enl[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b V(float f) {
        this.ent = true;
        this.enu = f;
        this.enw = f;
        this.enx = f;
        this.eny = f;
        return this;
    }

    public b W(float f) {
        this.ent = true;
        this.enu = f;
        return this;
    }

    public b X(float f) {
        this.ent = true;
        this.enw = f;
        return this;
    }

    public b Y(float f) {
        this.ent = true;
        this.enx = f;
        return this;
    }

    public b Z(float f) {
        this.ent = true;
        this.eny = f;
        return this;
    }

    public b ol(int i) {
        this.mType = i;
        return this;
    }

    public b om(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.enf = true;
        return this;
    }

    private GradientDrawable.Orientation bjS() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.eno;
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
        if (this.ens && this.enl != null && this.enl.length > 1) {
            gradientDrawable = new GradientDrawable(bjS(), this.enl);
            gradientDrawable.setGradientType(this.enn);
            switch (this.enn) {
                case 1:
                    gradientDrawable.setGradientRadius(this.enm);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.enp) {
            gradientDrawable.setColor(i2);
        }
        if (this.enq) {
            gradientDrawable.setStroke(this.enA, i3);
        } else if (this.enr) {
            gradientDrawable.setStroke(this.enh, i4, this.enj, this.enk);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.ent) {
            gradientDrawable.setCornerRadii(new float[]{this.enw, this.enw, this.enu, this.enu, this.enx, this.enx, this.eny, this.eny});
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
                    ((ImageView) view).setImageDrawable(this.eng);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.eng);
            }
        }
    }

    public StateListDrawable bjT() {
        this.eng = bjU();
        return this.eng;
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
        Drawable drawable = this.emW;
        if (this.ena) {
            drawable = this.emW;
        }
        if (this.enL || this.enP) {
            return r(this.enz, this.enC, this.enH, this.eni);
        }
        return drawable;
    }

    public Drawable bjW() {
        Drawable drawable = this.emZ;
        if (this.enb) {
            return this.emZ;
        }
        if (this.enM || this.enQ) {
            return r(this.enz, this.enD, this.enI, this.eni);
        }
        return drawable;
    }

    public Drawable bjX() {
        Drawable drawable = this.emX;
        if (this.enc) {
            return this.emX;
        }
        if (this.enN || this.enR) {
            return r(this.enz, this.enE, this.enJ, this.eni);
        }
        return drawable;
    }

    public Drawable bjY() {
        Drawable drawable = this.emY;
        if (this.ene) {
            return this.emY;
        }
        if (this.enO || this.enS) {
            return r(this.enz, this.enF, this.enK, this.eni);
        }
        return drawable;
    }

    public Drawable bjZ() {
        Drawable drawable = this.dEE;
        if (this.dEE == null) {
            return r(this.enz, this.enB, this.enG, this.eni);
        }
        return drawable;
    }
}
