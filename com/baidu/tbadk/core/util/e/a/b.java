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
    private int[] epD;
    private float epE;
    private boolean epH;
    private boolean epI;
    private boolean epJ;
    private boolean epK;
    private boolean epL;
    private int epS;
    private int epT;
    private int epU;
    private int epV;
    private int epW;
    private int epX;
    private int epY;
    private int epZ;
    private StateListDrawable epy;
    private int eqa;
    private int eqb;
    private int height;
    private int width;
    private int epz = 1;
    private int epA = 1;
    private float epB = 1.0f;
    private float epC = 1.0f;
    private int epF = 0;
    private String epG = "TOP_BOTTOM";
    private float epM = 0.0f;
    private float epN = 0.0f;
    private float epO = 0.0f;
    private float epP = 0.0f;
    private int epQ = 0;
    private int mCornerRadius = 0;
    private int epR = 0;
    private boolean eqc = false;
    private boolean eqd = false;
    private boolean eqe = false;
    private boolean eqf = false;
    private boolean eqg = false;
    private boolean eqh = false;
    private boolean eqi = false;
    private boolean eqj = false;

    public static b bkM() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.dGF = drawable;
        if (!this.ept) {
            this.epp = drawable;
        }
        if (!this.epu) {
            this.eps = drawable;
        }
        if (!this.epv) {
            this.epq = drawable;
        }
        if (!this.epw) {
            this.epr = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.eps = drawable;
        this.epu = true;
        return this;
    }

    public b oo(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b op(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b oq(int i) {
        this.epQ = i;
        return this;
    }

    public b or(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.epS = color;
        this.epH = true;
        if (!this.eqc) {
            this.epT = color;
        }
        if (!this.eqd) {
            this.epU = color;
        }
        if (!this.eqe) {
            this.epV = color;
        }
        if (!this.eqf) {
            this.epW = color;
        }
        return this;
    }

    public b aQ(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.epS = color;
        this.epH = true;
        if (!this.eqc) {
            this.epT = color;
        }
        if (!this.eqd) {
            this.epU = color;
        }
        if (!this.eqe) {
            this.epV = color;
        }
        if (!this.eqf) {
            this.epW = color;
        }
        return this;
    }

    public b AT(String str) {
        int fq = com.baidu.tbadk.core.util.e.c.a.fq(str);
        this.epS = fq;
        this.epH = true;
        if (!this.eqc) {
            this.epT = fq;
        }
        if (!this.eqd) {
            this.epU = fq;
        }
        if (!this.eqe) {
            this.epV = fq;
        }
        if (!this.eqf) {
            this.epW = fq;
        }
        return this;
    }

    public b os(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.epS = color;
        this.epH = true;
        if (!this.eqc) {
            this.epT = color;
        }
        if (!this.eqd) {
            this.epU = color;
        }
        if (!this.eqe) {
            this.epV = color;
        }
        if (!this.eqf) {
            this.epW = color;
        }
        return this;
    }

    public b ot(@ColorRes int i) {
        this.epU = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eqd = true;
        this.epH = true;
        return this;
    }

    public b ou(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.epX = color;
        this.epI = true;
        if (!this.eqg) {
            this.epY = color;
        }
        if (!this.eqh) {
            this.epZ = color;
        }
        if (!this.eqi) {
            this.eqa = color;
        }
        if (!this.eqj) {
            this.eqb = color;
        }
        return this;
    }

    public b ov(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b ow(int i) {
        this.epR = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.epK = true;
        this.epD = new int[2];
        this.epD[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.epD[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.epF = 0;
        this.epG = "TOP_BOTTOM";
        return this;
    }

    public b i(@ColorRes int... iArr) {
        this.epK = true;
        this.epF = 0;
        this.epG = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.epD = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.epD[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b j(@ColorRes int... iArr) {
        this.epK = true;
        this.epF = 0;
        this.epG = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.epD = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.epD[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.epK = true;
        this.epF = 0;
        this.epG = str;
        if (iArr.length > 1) {
            this.epD = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.epD[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b V(float f) {
        this.epL = true;
        this.epM = f;
        this.epN = f;
        this.epO = f;
        this.epP = f;
        return this;
    }

    public b W(float f) {
        this.epL = true;
        this.epM = f;
        return this;
    }

    public b X(float f) {
        this.epL = true;
        this.epN = f;
        return this;
    }

    public b Y(float f) {
        this.epL = true;
        this.epO = f;
        return this;
    }

    public b Z(float f) {
        this.epL = true;
        this.epP = f;
        return this;
    }

    public b ox(int i) {
        this.mType = i;
        return this;
    }

    public b oy(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.epx = true;
        return this;
    }

    private GradientDrawable.Orientation bkN() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.epG;
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
        if (this.epK && this.epD != null && this.epD.length > 1) {
            gradientDrawable = new GradientDrawable(bkN(), this.epD);
            gradientDrawable.setGradientType(this.epF);
            switch (this.epF) {
                case 1:
                    gradientDrawable.setGradientRadius(this.epE);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.epH) {
            gradientDrawable.setColor(i2);
        }
        if (this.epI) {
            gradientDrawable.setStroke(this.epR, i3);
        } else if (this.epJ) {
            gradientDrawable.setStroke(this.epz, i4, this.epB, this.epC);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.epL) {
            gradientDrawable.setCornerRadii(new float[]{this.epN, this.epN, this.epM, this.epM, this.epO, this.epO, this.epP, this.epP});
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

    public void bb(View view) {
        if (view != null) {
            bkO();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.epy);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.epy);
            }
        }
    }

    public StateListDrawable bkO() {
        this.epy = bkP();
        return this.epy;
    }

    public StateListDrawable bkP() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable bkQ = bkQ();
        if (bkQ != null) {
            stateListDrawable.addState(new int[]{-16842910}, bkQ);
        }
        Drawable bkR = bkR();
        if (bkR != null) {
            stateListDrawable.addState(new int[]{16842919}, bkR);
        }
        Drawable bkS = bkS();
        if (bkS != null) {
            stateListDrawable.addState(new int[]{16842913}, bkS);
        }
        Drawable bkT = bkT();
        if (bkT != null) {
            stateListDrawable.addState(new int[]{16842908}, bkT);
        }
        Drawable bkU = bkU();
        if (bkU == null) {
            bkU = new ColorDrawable(0);
        }
        if (bkU != null) {
            stateListDrawable.addState(new int[0], bkU);
        }
        return stateListDrawable;
    }

    public Drawable bkQ() {
        Drawable drawable = this.epp;
        if (this.ept) {
            drawable = this.epp;
        }
        if (this.eqc || this.eqg) {
            return r(this.epQ, this.epT, this.epY, this.epA);
        }
        return drawable;
    }

    public Drawable bkR() {
        Drawable drawable = this.eps;
        if (this.epu) {
            return this.eps;
        }
        if (this.eqd || this.eqh) {
            return r(this.epQ, this.epU, this.epZ, this.epA);
        }
        return drawable;
    }

    public Drawable bkS() {
        Drawable drawable = this.epq;
        if (this.epv) {
            return this.epq;
        }
        if (this.eqe || this.eqi) {
            return r(this.epQ, this.epV, this.eqa, this.epA);
        }
        return drawable;
    }

    public Drawable bkT() {
        Drawable drawable = this.epr;
        if (this.epw) {
            return this.epr;
        }
        if (this.eqf || this.eqj) {
            return r(this.epQ, this.epW, this.eqb, this.epA);
        }
        return drawable;
    }

    public Drawable bkU() {
        Drawable drawable = this.dGF;
        if (this.dGF == null) {
            return r(this.epQ, this.epS, this.epX, this.epA);
        }
        return drawable;
    }
}
