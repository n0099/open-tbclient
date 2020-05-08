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
/* loaded from: classes.dex */
public class c extends a {
    private float centerX;
    private float centerY;
    private int dCD;
    private int dCE;
    private int dCF;
    private int dCG;
    private int dCH;
    private int dCI;
    private int dCJ;
    private int dCK;
    private int dCL;
    private int dCM;
    private StateListDrawable dCj;
    private int[] dCo;
    private float dCp;
    private boolean dCs;
    private boolean dCt;
    private boolean dCu;
    private boolean dCv;
    private boolean dCw;
    private int height;
    private int width;
    private int dCk = 1;
    private int dCl = 1;
    private float dCm = 1.0f;
    private float dCn = 1.0f;
    private int dCq = 0;
    private String dCr = "TOP_BOTTOM";
    private float dCx = 0.0f;
    private float dCy = 0.0f;
    private float dCz = 0.0f;
    private float dCA = 0.0f;
    private int dCB = 0;
    private int mCornerRadius = 0;
    private int dCC = 0;
    private boolean dCN = false;
    private boolean dCO = false;
    private boolean dCP = false;
    private boolean dCQ = false;
    private boolean dCR = false;
    private boolean dCS = false;
    private boolean dCT = false;
    private boolean dCU = false;

    public static c aPv() {
        return new c();
    }

    public c f(Drawable drawable) {
        this.cYY = drawable;
        if (!this.dBT) {
            this.dBP = drawable;
        }
        if (!this.dBU) {
            this.dBS = drawable;
        }
        if (!this.dBV) {
            this.dBQ = drawable;
        }
        if (!this.dBW) {
            this.dBR = drawable;
        }
        return this;
    }

    public c g(Drawable drawable) {
        this.dBS = drawable;
        this.dBU = true;
        return this;
    }

    public c kJ(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c kK(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c kL(int i) {
        this.dCB = i;
        return this;
    }

    public c kM(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCD = color;
        this.dCs = true;
        if (!this.dCN) {
            this.dCE = color;
        }
        if (!this.dCO) {
            this.dCF = color;
        }
        if (!this.dCP) {
            this.dCG = color;
        }
        if (!this.dCQ) {
            this.dCH = color;
        }
        return this;
    }

    public c vd(String str) {
        int dA = com.baidu.tbadk.core.util.e.c.a.dA(str);
        this.dCD = dA;
        this.dCs = true;
        if (!this.dCN) {
            this.dCE = dA;
        }
        if (!this.dCO) {
            this.dCF = dA;
        }
        if (!this.dCP) {
            this.dCG = dA;
        }
        if (!this.dCQ) {
            this.dCH = dA;
        }
        return this;
    }

    public c kN(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dCD = color;
        this.dCs = true;
        if (!this.dCN) {
            this.dCE = color;
        }
        if (!this.dCO) {
            this.dCF = color;
        }
        if (!this.dCP) {
            this.dCG = color;
        }
        if (!this.dCQ) {
            this.dCH = color;
        }
        return this;
    }

    public c kO(@ColorRes int i) {
        this.dCF = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCO = true;
        this.dCs = true;
        return this;
    }

    public c kP(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCI = color;
        this.dCt = true;
        if (!this.dCR) {
            this.dCJ = color;
        }
        if (!this.dCS) {
            this.dCK = color;
        }
        if (!this.dCT) {
            this.dCL = color;
        }
        if (!this.dCU) {
            this.dCM = color;
        }
        return this;
    }

    public c kQ(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public c kR(int i) {
        this.dCC = i;
        return this;
    }

    public c i(@ColorRes int... iArr) {
        this.dCv = true;
        this.dCq = 0;
        this.dCr = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dCo = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dCo[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c j(@ColorRes int... iArr) {
        this.dCv = true;
        this.dCq = 0;
        this.dCr = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dCo = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dCo[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c b(String str, @ColorRes int... iArr) {
        this.dCv = true;
        this.dCq = 0;
        this.dCr = str;
        if (iArr.length > 1) {
            this.dCo = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dCo[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c P(float f) {
        this.dCw = true;
        this.dCx = f;
        this.dCy = f;
        this.dCz = f;
        this.dCA = f;
        return this;
    }

    public c Q(float f) {
        this.dCw = true;
        this.dCx = f;
        return this;
    }

    public c R(float f) {
        this.dCw = true;
        this.dCy = f;
        return this;
    }

    public c S(float f) {
        this.dCw = true;
        this.dCz = f;
        return this;
    }

    public c T(float f) {
        this.dCw = true;
        this.dCA = f;
        return this;
    }

    public c kS(int i) {
        this.mType = i;
        return this;
    }

    public c kT(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dBX = true;
        return this;
    }

    private GradientDrawable.Orientation aPw() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dCr;
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
        if (this.dCv && this.dCo != null && this.dCo.length > 1) {
            gradientDrawable = new GradientDrawable(aPw(), this.dCo);
            gradientDrawable.setGradientType(this.dCq);
            switch (this.dCq) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dCp);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dCs) {
            gradientDrawable.setColor(i2);
        }
        if (this.dCt) {
            gradientDrawable.setStroke(this.dCC, i3);
        } else if (this.dCu) {
            gradientDrawable.setStroke(this.dCk, i4, this.dCm, this.dCn);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dCw) {
            gradientDrawable.setCornerRadii(new float[]{this.dCy, this.dCy, this.dCx, this.dCx, this.dCz, this.dCz, this.dCA, this.dCA});
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

    public void aR(View view) {
        if (view != null) {
            aPx();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dCj);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dCj);
            }
        }
    }

    public StateListDrawable aPx() {
        this.dCj = aPy();
        return this.dCj;
    }

    public StateListDrawable aPy() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aPz = aPz();
        if (aPz != null) {
            stateListDrawable.addState(new int[]{-16842910}, aPz);
        }
        Drawable aPA = aPA();
        if (aPA != null) {
            stateListDrawable.addState(new int[]{16842919}, aPA);
        }
        Drawable aPB = aPB();
        if (aPB != null) {
            stateListDrawable.addState(new int[]{16842913}, aPB);
        }
        Drawable aPC = aPC();
        if (aPC != null) {
            stateListDrawable.addState(new int[]{16842908}, aPC);
        }
        Drawable aPD = aPD();
        if (aPD == null) {
            aPD = new ColorDrawable(0);
        }
        if (aPD != null) {
            stateListDrawable.addState(new int[0], aPD);
        }
        return stateListDrawable;
    }

    public Drawable aPz() {
        Drawable drawable = this.dBP;
        if (this.dBT) {
            drawable = this.dBP;
        }
        if (this.dCN || this.dCR) {
            return r(this.dCB, this.dCE, this.dCJ, this.dCl);
        }
        return drawable;
    }

    public Drawable aPA() {
        Drawable drawable = this.dBS;
        if (this.dBU) {
            return this.dBS;
        }
        if (this.dCO || this.dCS) {
            return r(this.dCB, this.dCF, this.dCK, this.dCl);
        }
        return drawable;
    }

    public Drawable aPB() {
        Drawable drawable = this.dBQ;
        if (this.dBV) {
            return this.dBQ;
        }
        if (this.dCP || this.dCT) {
            return r(this.dCB, this.dCG, this.dCL, this.dCl);
        }
        return drawable;
    }

    public Drawable aPC() {
        Drawable drawable = this.dBR;
        if (this.dBW) {
            return this.dBR;
        }
        if (this.dCQ || this.dCU) {
            return r(this.dCB, this.dCH, this.dCM, this.dCl);
        }
        return drawable;
    }

    public Drawable aPD() {
        Drawable drawable = this.cYY;
        if (this.cYY == null) {
            return r(this.dCB, this.dCD, this.dCI, this.dCl);
        }
        return drawable;
    }
}
