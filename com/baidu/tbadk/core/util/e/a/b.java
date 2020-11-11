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
    private StateListDrawable ePV;
    private int[] eQa;
    private float eQb;
    private boolean eQe;
    private boolean eQf;
    private boolean eQg;
    private boolean eQh;
    private boolean eQi;
    private int eQp;
    private int eQq;
    private int eQr;
    private int eQs;
    private int eQt;
    private int eQu;
    private int eQv;
    private int eQw;
    private int eQx;
    private int eQy;
    private int height;
    private int width;
    private int ePW = 1;
    private int ePX = 1;
    private float ePY = 1.0f;
    private float ePZ = 1.0f;
    private int eQc = 0;
    private String eQd = "TOP_BOTTOM";
    private float eQj = 0.0f;
    private float eQk = 0.0f;
    private float eQl = 0.0f;
    private float eQm = 0.0f;
    private int eQn = 0;
    private int mCornerRadius = 0;
    private int eQo = 0;
    private boolean eQz = false;
    private boolean eQA = false;
    private boolean eQB = false;
    private boolean eQC = false;
    private boolean eQD = false;
    private boolean eQE = false;
    private boolean eQF = false;
    private boolean eQG = false;

    public static b brP() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.egU = drawable;
        if (!this.ePQ) {
            this.ePM = drawable;
        }
        if (!this.ePR) {
            this.ePP = drawable;
        }
        if (!this.ePS) {
            this.ePN = drawable;
        }
        if (!this.ePT) {
            this.ePO = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.ePP = drawable;
        this.ePR = true;
        return this;
    }

    public b ph(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b pi(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b pj(int i) {
        this.eQn = i;
        return this;
    }

    public b pk(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eQp = color;
        this.eQe = true;
        if (!this.eQz) {
            this.eQq = color;
        }
        if (!this.eQA) {
            this.eQr = color;
        }
        if (!this.eQB) {
            this.eQs = color;
        }
        if (!this.eQC) {
            this.eQt = color;
        }
        return this;
    }

    public b aQ(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.eQp = color;
        this.eQe = true;
        if (!this.eQz) {
            this.eQq = color;
        }
        if (!this.eQA) {
            this.eQr = color;
        }
        if (!this.eQB) {
            this.eQs = color;
        }
        if (!this.eQC) {
            this.eQt = color;
        }
        return this;
    }

    public b Cm(String str) {
        int fv = com.baidu.tbadk.core.util.e.c.a.fv(str);
        this.eQp = fv;
        this.eQe = true;
        if (!this.eQz) {
            this.eQq = fv;
        }
        if (!this.eQA) {
            this.eQr = fv;
        }
        if (!this.eQB) {
            this.eQs = fv;
        }
        if (!this.eQC) {
            this.eQt = fv;
        }
        return this;
    }

    public b pl(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.eQp = color;
        this.eQe = true;
        if (!this.eQz) {
            this.eQq = color;
        }
        if (!this.eQA) {
            this.eQr = color;
        }
        if (!this.eQB) {
            this.eQs = color;
        }
        if (!this.eQC) {
            this.eQt = color;
        }
        return this;
    }

    public b pm(@ColorRes int i) {
        this.eQr = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eQA = true;
        this.eQe = true;
        return this;
    }

    public b po(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eQu = color;
        this.eQf = true;
        if (!this.eQD) {
            this.eQv = color;
        }
        if (!this.eQE) {
            this.eQw = color;
        }
        if (!this.eQF) {
            this.eQx = color;
        }
        if (!this.eQG) {
            this.eQy = color;
        }
        return this;
    }

    public b pp(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b pq(int i) {
        this.eQo = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.eQh = true;
        this.eQa = new int[2];
        this.eQa[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eQa[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.eQc = 0;
        this.eQd = "TOP_BOTTOM";
        return this;
    }

    public b i(@ColorRes int... iArr) {
        this.eQh = true;
        this.eQc = 0;
        this.eQd = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eQa = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eQa[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b j(@ColorRes int... iArr) {
        this.eQh = true;
        this.eQc = 0;
        this.eQd = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eQa = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eQa[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.eQh = true;
        this.eQc = 0;
        this.eQd = str;
        if (iArr.length > 1) {
            this.eQa = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eQa[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b ab(float f) {
        this.eQi = true;
        this.eQj = f;
        this.eQk = f;
        this.eQl = f;
        this.eQm = f;
        return this;
    }

    public b ac(float f) {
        this.eQi = true;
        this.eQj = f;
        return this;
    }

    public b ad(float f) {
        this.eQi = true;
        this.eQk = f;
        return this;
    }

    public b ae(float f) {
        this.eQi = true;
        this.eQl = f;
        return this;
    }

    public b af(float f) {
        this.eQi = true;
        this.eQm = f;
        return this;
    }

    public b pr(int i) {
        this.mType = i;
        return this;
    }

    public b ps(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.ePU = true;
        return this;
    }

    private GradientDrawable.Orientation brQ() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.eQd;
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
        if (this.eQh && this.eQa != null && this.eQa.length > 1) {
            gradientDrawable = new GradientDrawable(brQ(), this.eQa);
            gradientDrawable.setGradientType(this.eQc);
            switch (this.eQc) {
                case 1:
                    gradientDrawable.setGradientRadius(this.eQb);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.eQe) {
            gradientDrawable.setColor(i2);
        }
        if (this.eQf) {
            gradientDrawable.setStroke(this.eQo, i3);
        } else if (this.eQg) {
            gradientDrawable.setStroke(this.ePW, i4, this.ePY, this.ePZ);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.eQi) {
            gradientDrawable.setCornerRadii(new float[]{this.eQk, this.eQk, this.eQj, this.eQj, this.eQl, this.eQl, this.eQm, this.eQm});
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

    public void bk(View view) {
        if (view != null) {
            brR();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.ePV);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.ePV);
            }
        }
    }

    public StateListDrawable brR() {
        this.ePV = brS();
        return this.ePV;
    }

    public StateListDrawable brS() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable brT = brT();
        if (brT != null) {
            stateListDrawable.addState(new int[]{-16842910}, brT);
        }
        Drawable brU = brU();
        if (brU != null) {
            stateListDrawable.addState(new int[]{16842919}, brU);
        }
        Drawable brV = brV();
        if (brV != null) {
            stateListDrawable.addState(new int[]{16842913}, brV);
        }
        Drawable brW = brW();
        if (brW != null) {
            stateListDrawable.addState(new int[]{16842908}, brW);
        }
        Drawable brX = brX();
        if (brX == null) {
            brX = new ColorDrawable(0);
        }
        if (brX != null) {
            stateListDrawable.addState(new int[0], brX);
        }
        return stateListDrawable;
    }

    public Drawable brT() {
        Drawable drawable = this.ePM;
        if (this.ePQ) {
            drawable = this.ePM;
        }
        if (this.eQz || this.eQD) {
            return r(this.eQn, this.eQq, this.eQv, this.ePX);
        }
        return drawable;
    }

    public Drawable brU() {
        Drawable drawable = this.ePP;
        if (this.ePR) {
            return this.ePP;
        }
        if (this.eQA || this.eQE) {
            return r(this.eQn, this.eQr, this.eQw, this.ePX);
        }
        return drawable;
    }

    public Drawable brV() {
        Drawable drawable = this.ePN;
        if (this.ePS) {
            return this.ePN;
        }
        if (this.eQB || this.eQF) {
            return r(this.eQn, this.eQs, this.eQx, this.ePX);
        }
        return drawable;
    }

    public Drawable brW() {
        Drawable drawable = this.ePO;
        if (this.ePT) {
            return this.ePO;
        }
        if (this.eQC || this.eQG) {
            return r(this.eQn, this.eQt, this.eQy, this.ePX);
        }
        return drawable;
    }

    public Drawable brX() {
        Drawable drawable = this.egU;
        if (this.egU == null) {
            return r(this.eQn, this.eQp, this.eQu, this.ePX);
        }
        return drawable;
    }
}
