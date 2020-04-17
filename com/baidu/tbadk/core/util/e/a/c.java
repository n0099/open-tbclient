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
    private int dCA;
    private int dCB;
    private int dCC;
    private int dCD;
    private int dCE;
    private int dCF;
    private int dCG;
    private int dCH;
    private int dCI;
    private StateListDrawable dCf;
    private int[] dCk;
    private float dCl;
    private boolean dCo;
    private boolean dCp;
    private boolean dCq;
    private boolean dCr;
    private boolean dCs;
    private int dCz;
    private int height;
    private int width;
    private int dCg = 1;
    private int dCh = 1;
    private float dCi = 1.0f;
    private float dCj = 1.0f;
    private int dCm = 0;
    private String dCn = "TOP_BOTTOM";
    private float dCt = 0.0f;
    private float dCu = 0.0f;
    private float dCv = 0.0f;
    private float dCw = 0.0f;
    private int dCx = 0;
    private int mCornerRadius = 0;
    private int dCy = 0;
    private boolean dCJ = false;
    private boolean dCK = false;
    private boolean dCL = false;
    private boolean dCM = false;
    private boolean dCN = false;
    private boolean dCO = false;
    private boolean dCP = false;
    private boolean dCQ = false;

    public static c aPy() {
        return new c();
    }

    public c f(Drawable drawable) {
        this.cYT = drawable;
        if (!this.dBP) {
            this.dBL = drawable;
        }
        if (!this.dBQ) {
            this.dBO = drawable;
        }
        if (!this.dBR) {
            this.dBM = drawable;
        }
        if (!this.dBS) {
            this.dBN = drawable;
        }
        return this;
    }

    public c g(Drawable drawable) {
        this.dBO = drawable;
        this.dBQ = true;
        return this;
    }

    public c kJ(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c kK(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c kL(int i) {
        this.dCx = i;
        return this;
    }

    public c kM(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCz = color;
        this.dCo = true;
        if (!this.dCJ) {
            this.dCA = color;
        }
        if (!this.dCK) {
            this.dCB = color;
        }
        if (!this.dCL) {
            this.dCC = color;
        }
        if (!this.dCM) {
            this.dCD = color;
        }
        return this;
    }

    public c va(String str) {
        int dA = com.baidu.tbadk.core.util.e.c.a.dA(str);
        this.dCz = dA;
        this.dCo = true;
        if (!this.dCJ) {
            this.dCA = dA;
        }
        if (!this.dCK) {
            this.dCB = dA;
        }
        if (!this.dCL) {
            this.dCC = dA;
        }
        if (!this.dCM) {
            this.dCD = dA;
        }
        return this;
    }

    public c kN(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dCz = color;
        this.dCo = true;
        if (!this.dCJ) {
            this.dCA = color;
        }
        if (!this.dCK) {
            this.dCB = color;
        }
        if (!this.dCL) {
            this.dCC = color;
        }
        if (!this.dCM) {
            this.dCD = color;
        }
        return this;
    }

    public c kO(@ColorRes int i) {
        this.dCB = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCK = true;
        this.dCo = true;
        return this;
    }

    public c kP(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCE = color;
        this.dCp = true;
        if (!this.dCN) {
            this.dCF = color;
        }
        if (!this.dCO) {
            this.dCG = color;
        }
        if (!this.dCP) {
            this.dCH = color;
        }
        if (!this.dCQ) {
            this.dCI = color;
        }
        return this;
    }

    public c kQ(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public c kR(int i) {
        this.dCy = i;
        return this;
    }

    public c i(@ColorRes int... iArr) {
        this.dCr = true;
        this.dCm = 0;
        this.dCn = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dCk = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dCk[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c j(@ColorRes int... iArr) {
        this.dCr = true;
        this.dCm = 0;
        this.dCn = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dCk = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dCk[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c b(String str, @ColorRes int... iArr) {
        this.dCr = true;
        this.dCm = 0;
        this.dCn = str;
        if (iArr.length > 1) {
            this.dCk = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dCk[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c P(float f) {
        this.dCs = true;
        this.dCt = f;
        this.dCu = f;
        this.dCv = f;
        this.dCw = f;
        return this;
    }

    public c Q(float f) {
        this.dCs = true;
        this.dCt = f;
        return this;
    }

    public c R(float f) {
        this.dCs = true;
        this.dCu = f;
        return this;
    }

    public c S(float f) {
        this.dCs = true;
        this.dCv = f;
        return this;
    }

    public c T(float f) {
        this.dCs = true;
        this.dCw = f;
        return this;
    }

    public c kS(int i) {
        this.mType = i;
        return this;
    }

    public c kT(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dBT = true;
        return this;
    }

    private GradientDrawable.Orientation aPz() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dCn;
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
        if (this.dCr && this.dCk != null && this.dCk.length > 1) {
            gradientDrawable = new GradientDrawable(aPz(), this.dCk);
            gradientDrawable.setGradientType(this.dCm);
            switch (this.dCm) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dCl);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dCo) {
            gradientDrawable.setColor(i2);
        }
        if (this.dCp) {
            gradientDrawable.setStroke(this.dCy, i3);
        } else if (this.dCq) {
            gradientDrawable.setStroke(this.dCg, i4, this.dCi, this.dCj);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dCs) {
            gradientDrawable.setCornerRadii(new float[]{this.dCu, this.dCu, this.dCt, this.dCt, this.dCv, this.dCv, this.dCw, this.dCw});
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
            aPA();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dCf);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dCf);
            }
        }
    }

    public StateListDrawable aPA() {
        this.dCf = aPB();
        return this.dCf;
    }

    public StateListDrawable aPB() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aPC = aPC();
        if (aPC != null) {
            stateListDrawable.addState(new int[]{-16842910}, aPC);
        }
        Drawable aPD = aPD();
        if (aPD != null) {
            stateListDrawable.addState(new int[]{16842919}, aPD);
        }
        Drawable aPE = aPE();
        if (aPE != null) {
            stateListDrawable.addState(new int[]{16842913}, aPE);
        }
        Drawable aPF = aPF();
        if (aPF != null) {
            stateListDrawable.addState(new int[]{16842908}, aPF);
        }
        Drawable aPG = aPG();
        if (aPG == null) {
            aPG = new ColorDrawable(0);
        }
        if (aPG != null) {
            stateListDrawable.addState(new int[0], aPG);
        }
        return stateListDrawable;
    }

    public Drawable aPC() {
        Drawable drawable = this.dBL;
        if (this.dBP) {
            drawable = this.dBL;
        }
        if (this.dCJ || this.dCN) {
            return r(this.dCx, this.dCA, this.dCF, this.dCh);
        }
        return drawable;
    }

    public Drawable aPD() {
        Drawable drawable = this.dBO;
        if (this.dBQ) {
            return this.dBO;
        }
        if (this.dCK || this.dCO) {
            return r(this.dCx, this.dCB, this.dCG, this.dCh);
        }
        return drawable;
    }

    public Drawable aPE() {
        Drawable drawable = this.dBM;
        if (this.dBR) {
            return this.dBM;
        }
        if (this.dCL || this.dCP) {
            return r(this.dCx, this.dCC, this.dCH, this.dCh);
        }
        return drawable;
    }

    public Drawable aPF() {
        Drawable drawable = this.dBN;
        if (this.dBS) {
            return this.dBN;
        }
        if (this.dCM || this.dCQ) {
            return r(this.dCx, this.dCD, this.dCI, this.dCh);
        }
        return drawable;
    }

    public Drawable aPG() {
        Drawable drawable = this.cYT;
        if (this.cYT == null) {
            return r(this.dCx, this.dCz, this.dCE, this.dCh);
        }
        return drawable;
    }
}
