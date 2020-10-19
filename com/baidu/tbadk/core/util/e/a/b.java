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
    private StateListDrawable eBK;
    private int[] eBP;
    private float eBQ;
    private boolean eBT;
    private boolean eBU;
    private boolean eBV;
    private boolean eBW;
    private boolean eBX;
    private int eCe;
    private int eCf;
    private int eCg;
    private int eCh;
    private int eCi;
    private int eCj;
    private int eCk;
    private int eCl;
    private int eCm;
    private int eCn;
    private int height;
    private int width;
    private int eBL = 1;
    private int eBM = 1;
    private float eBN = 1.0f;
    private float eBO = 1.0f;
    private int eBR = 0;
    private String eBS = "TOP_BOTTOM";
    private float eBY = 0.0f;
    private float eBZ = 0.0f;
    private float eCa = 0.0f;
    private float eCb = 0.0f;
    private int eCc = 0;
    private int mCornerRadius = 0;
    private int eCd = 0;
    private boolean eCo = false;
    private boolean eCp = false;
    private boolean eCq = false;
    private boolean eCr = false;
    private boolean eCs = false;
    private boolean eCt = false;
    private boolean eCu = false;
    private boolean eCv = false;

    public static b bnw() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.dSG = drawable;
        if (!this.eBF) {
            this.eBB = drawable;
        }
        if (!this.eBG) {
            this.eBE = drawable;
        }
        if (!this.eBH) {
            this.eBC = drawable;
        }
        if (!this.eBI) {
            this.eBD = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.eBE = drawable;
        this.eBG = true;
        return this;
    }

    public b oM(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b oN(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b oO(int i) {
        this.eCc = i;
        return this;
    }

    public b oP(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eCe = color;
        this.eBT = true;
        if (!this.eCo) {
            this.eCf = color;
        }
        if (!this.eCp) {
            this.eCg = color;
        }
        if (!this.eCq) {
            this.eCh = color;
        }
        if (!this.eCr) {
            this.eCi = color;
        }
        return this;
    }

    public b aP(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.eCe = color;
        this.eBT = true;
        if (!this.eCo) {
            this.eCf = color;
        }
        if (!this.eCp) {
            this.eCg = color;
        }
        if (!this.eCq) {
            this.eCh = color;
        }
        if (!this.eCr) {
            this.eCi = color;
        }
        return this;
    }

    public b BF(String str) {
        int fv = com.baidu.tbadk.core.util.e.c.a.fv(str);
        this.eCe = fv;
        this.eBT = true;
        if (!this.eCo) {
            this.eCf = fv;
        }
        if (!this.eCp) {
            this.eCg = fv;
        }
        if (!this.eCq) {
            this.eCh = fv;
        }
        if (!this.eCr) {
            this.eCi = fv;
        }
        return this;
    }

    public b oQ(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.eCe = color;
        this.eBT = true;
        if (!this.eCo) {
            this.eCf = color;
        }
        if (!this.eCp) {
            this.eCg = color;
        }
        if (!this.eCq) {
            this.eCh = color;
        }
        if (!this.eCr) {
            this.eCi = color;
        }
        return this;
    }

    public b oR(@ColorRes int i) {
        this.eCg = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eCp = true;
        this.eBT = true;
        return this;
    }

    public b oS(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eCj = color;
        this.eBU = true;
        if (!this.eCs) {
            this.eCk = color;
        }
        if (!this.eCt) {
            this.eCl = color;
        }
        if (!this.eCu) {
            this.eCm = color;
        }
        if (!this.eCv) {
            this.eCn = color;
        }
        return this;
    }

    public b oT(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b oU(int i) {
        this.eCd = i;
        return this;
    }

    public b aQ(@ColorRes int i, @ColorRes int i2) {
        this.eBW = true;
        this.eBP = new int[2];
        this.eBP[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eBP[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.eBR = 0;
        this.eBS = "TOP_BOTTOM";
        return this;
    }

    public b i(@ColorRes int... iArr) {
        this.eBW = true;
        this.eBR = 0;
        this.eBS = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eBP = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eBP[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b j(@ColorRes int... iArr) {
        this.eBW = true;
        this.eBR = 0;
        this.eBS = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eBP = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eBP[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.eBW = true;
        this.eBR = 0;
        this.eBS = str;
        if (iArr.length > 1) {
            this.eBP = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eBP[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b X(float f) {
        this.eBX = true;
        this.eBY = f;
        this.eBZ = f;
        this.eCa = f;
        this.eCb = f;
        return this;
    }

    public b Y(float f) {
        this.eBX = true;
        this.eBY = f;
        return this;
    }

    public b Z(float f) {
        this.eBX = true;
        this.eBZ = f;
        return this;
    }

    public b aa(float f) {
        this.eBX = true;
        this.eCa = f;
        return this;
    }

    public b ab(float f) {
        this.eBX = true;
        this.eCb = f;
        return this;
    }

    public b oV(int i) {
        this.mType = i;
        return this;
    }

    public b oW(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.eBJ = true;
        return this;
    }

    private GradientDrawable.Orientation bnx() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.eBS;
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
        if (this.eBW && this.eBP != null && this.eBP.length > 1) {
            gradientDrawable = new GradientDrawable(bnx(), this.eBP);
            gradientDrawable.setGradientType(this.eBR);
            switch (this.eBR) {
                case 1:
                    gradientDrawable.setGradientRadius(this.eBQ);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.eBT) {
            gradientDrawable.setColor(i2);
        }
        if (this.eBU) {
            gradientDrawable.setStroke(this.eCd, i3);
        } else if (this.eBV) {
            gradientDrawable.setStroke(this.eBL, i4, this.eBN, this.eBO);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.eBX) {
            gradientDrawable.setCornerRadii(new float[]{this.eBZ, this.eBZ, this.eBY, this.eBY, this.eCa, this.eCa, this.eCb, this.eCb});
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

    public void bf(View view) {
        if (view != null) {
            bny();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.eBK);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.eBK);
            }
        }
    }

    public StateListDrawable bny() {
        this.eBK = bnz();
        return this.eBK;
    }

    public StateListDrawable bnz() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable bnA = bnA();
        if (bnA != null) {
            stateListDrawable.addState(new int[]{-16842910}, bnA);
        }
        Drawable bnB = bnB();
        if (bnB != null) {
            stateListDrawable.addState(new int[]{16842919}, bnB);
        }
        Drawable bnC = bnC();
        if (bnC != null) {
            stateListDrawable.addState(new int[]{16842913}, bnC);
        }
        Drawable bnD = bnD();
        if (bnD != null) {
            stateListDrawable.addState(new int[]{16842908}, bnD);
        }
        Drawable bnE = bnE();
        if (bnE == null) {
            bnE = new ColorDrawable(0);
        }
        if (bnE != null) {
            stateListDrawable.addState(new int[0], bnE);
        }
        return stateListDrawable;
    }

    public Drawable bnA() {
        Drawable drawable = this.eBB;
        if (this.eBF) {
            drawable = this.eBB;
        }
        if (this.eCo || this.eCs) {
            return r(this.eCc, this.eCf, this.eCk, this.eBM);
        }
        return drawable;
    }

    public Drawable bnB() {
        Drawable drawable = this.eBE;
        if (this.eBG) {
            return this.eBE;
        }
        if (this.eCp || this.eCt) {
            return r(this.eCc, this.eCg, this.eCl, this.eBM);
        }
        return drawable;
    }

    public Drawable bnC() {
        Drawable drawable = this.eBC;
        if (this.eBH) {
            return this.eBC;
        }
        if (this.eCq || this.eCu) {
            return r(this.eCc, this.eCh, this.eCm, this.eBM);
        }
        return drawable;
    }

    public Drawable bnD() {
        Drawable drawable = this.eBD;
        if (this.eBI) {
            return this.eBD;
        }
        if (this.eCr || this.eCv) {
            return r(this.eCc, this.eCi, this.eCn, this.eBM);
        }
        return drawable;
    }

    public Drawable bnE() {
        Drawable drawable = this.dSG;
        if (this.dSG == null) {
            return r(this.eCc, this.eCe, this.eCj, this.eBM);
        }
        return drawable;
    }
}
