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
    private boolean dQA;
    private boolean dQB;
    private boolean dQC;
    private boolean dQD;
    private int dQK;
    private int dQL;
    private int dQM;
    private int dQN;
    private int dQO;
    private int dQP;
    private int dQQ;
    private int dQR;
    private int dQS;
    private int dQT;
    private StateListDrawable dQq;
    private int[] dQv;
    private float dQw;
    private boolean dQz;
    private int height;
    private int width;
    private int dQr = 1;
    private int dQs = 1;
    private float dQt = 1.0f;
    private float dQu = 1.0f;
    private int dQx = 0;
    private String dQy = "TOP_BOTTOM";
    private float dQE = 0.0f;
    private float dQF = 0.0f;
    private float dQG = 0.0f;
    private float dQH = 0.0f;
    private int dQI = 0;
    private int mCornerRadius = 0;
    private int dQJ = 0;
    private boolean dQU = false;
    private boolean dQV = false;
    private boolean dQW = false;
    private boolean dQX = false;
    private boolean dQY = false;
    private boolean dQZ = false;
    private boolean dRa = false;
    private boolean dRb = false;

    public static c aVz() {
        return new c();
    }

    public c f(Drawable drawable) {
        this.dkc = drawable;
        if (!this.dQa) {
            this.dPW = drawable;
        }
        if (!this.dQb) {
            this.dPZ = drawable;
        }
        if (!this.dQc) {
            this.dPX = drawable;
        }
        if (!this.dQd) {
            this.dPY = drawable;
        }
        return this;
    }

    public c g(Drawable drawable) {
        this.dPZ = drawable;
        this.dQb = true;
        return this;
    }

    public c ll(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c lm(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c ln(int i) {
        this.dQI = i;
        return this;
    }

    public c lo(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dQK = color;
        this.dQz = true;
        if (!this.dQU) {
            this.dQL = color;
        }
        if (!this.dQV) {
            this.dQM = color;
        }
        if (!this.dQW) {
            this.dQN = color;
        }
        if (!this.dQX) {
            this.dQO = color;
        }
        return this;
    }

    public c wJ(String str) {
        int dT = com.baidu.tbadk.core.util.e.c.a.dT(str);
        this.dQK = dT;
        this.dQz = true;
        if (!this.dQU) {
            this.dQL = dT;
        }
        if (!this.dQV) {
            this.dQM = dT;
        }
        if (!this.dQW) {
            this.dQN = dT;
        }
        if (!this.dQX) {
            this.dQO = dT;
        }
        return this;
    }

    public c lp(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dQK = color;
        this.dQz = true;
        if (!this.dQU) {
            this.dQL = color;
        }
        if (!this.dQV) {
            this.dQM = color;
        }
        if (!this.dQW) {
            this.dQN = color;
        }
        if (!this.dQX) {
            this.dQO = color;
        }
        return this;
    }

    public c lq(@ColorRes int i) {
        this.dQM = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dQV = true;
        this.dQz = true;
        return this;
    }

    public c lr(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dQP = color;
        this.dQA = true;
        if (!this.dQY) {
            this.dQQ = color;
        }
        if (!this.dQZ) {
            this.dQR = color;
        }
        if (!this.dRa) {
            this.dQS = color;
        }
        if (!this.dRb) {
            this.dQT = color;
        }
        return this;
    }

    public c ls(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public c lt(int i) {
        this.dQJ = i;
        return this;
    }

    public c i(@ColorRes int... iArr) {
        this.dQC = true;
        this.dQx = 0;
        this.dQy = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dQv = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dQv[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c j(@ColorRes int... iArr) {
        this.dQC = true;
        this.dQx = 0;
        this.dQy = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dQv = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dQv[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c b(String str, @ColorRes int... iArr) {
        this.dQC = true;
        this.dQx = 0;
        this.dQy = str;
        if (iArr.length > 1) {
            this.dQv = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dQv[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c O(float f) {
        this.dQD = true;
        this.dQE = f;
        this.dQF = f;
        this.dQG = f;
        this.dQH = f;
        return this;
    }

    public c P(float f) {
        this.dQD = true;
        this.dQE = f;
        return this;
    }

    public c Q(float f) {
        this.dQD = true;
        this.dQF = f;
        return this;
    }

    public c R(float f) {
        this.dQD = true;
        this.dQG = f;
        return this;
    }

    public c S(float f) {
        this.dQD = true;
        this.dQH = f;
        return this;
    }

    public c lu(int i) {
        this.mType = i;
        return this;
    }

    public c lv(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dQe = true;
        return this;
    }

    private GradientDrawable.Orientation aVA() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dQy;
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
        if (this.dQC && this.dQv != null && this.dQv.length > 1) {
            gradientDrawable = new GradientDrawable(aVA(), this.dQv);
            gradientDrawable.setGradientType(this.dQx);
            switch (this.dQx) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dQw);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dQz) {
            gradientDrawable.setColor(i2);
        }
        if (this.dQA) {
            gradientDrawable.setStroke(this.dQJ, i3);
        } else if (this.dQB) {
            gradientDrawable.setStroke(this.dQr, i4, this.dQt, this.dQu);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dQD) {
            gradientDrawable.setCornerRadii(new float[]{this.dQF, this.dQF, this.dQE, this.dQE, this.dQG, this.dQG, this.dQH, this.dQH});
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
            aVB();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dQq);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dQq);
            }
        }
    }

    public StateListDrawable aVB() {
        this.dQq = aVC();
        return this.dQq;
    }

    public StateListDrawable aVC() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aVD = aVD();
        if (aVD != null) {
            stateListDrawable.addState(new int[]{-16842910}, aVD);
        }
        Drawable aVE = aVE();
        if (aVE != null) {
            stateListDrawable.addState(new int[]{16842919}, aVE);
        }
        Drawable aVF = aVF();
        if (aVF != null) {
            stateListDrawable.addState(new int[]{16842913}, aVF);
        }
        Drawable aVG = aVG();
        if (aVG != null) {
            stateListDrawable.addState(new int[]{16842908}, aVG);
        }
        Drawable aVH = aVH();
        if (aVH == null) {
            aVH = new ColorDrawable(0);
        }
        if (aVH != null) {
            stateListDrawable.addState(new int[0], aVH);
        }
        return stateListDrawable;
    }

    public Drawable aVD() {
        Drawable drawable = this.dPW;
        if (this.dQa) {
            drawable = this.dPW;
        }
        if (this.dQU || this.dQY) {
            return r(this.dQI, this.dQL, this.dQQ, this.dQs);
        }
        return drawable;
    }

    public Drawable aVE() {
        Drawable drawable = this.dPZ;
        if (this.dQb) {
            return this.dPZ;
        }
        if (this.dQV || this.dQZ) {
            return r(this.dQI, this.dQM, this.dQR, this.dQs);
        }
        return drawable;
    }

    public Drawable aVF() {
        Drawable drawable = this.dPX;
        if (this.dQc) {
            return this.dPX;
        }
        if (this.dQW || this.dRa) {
            return r(this.dQI, this.dQN, this.dQS, this.dQs);
        }
        return drawable;
    }

    public Drawable aVG() {
        Drawable drawable = this.dPY;
        if (this.dQd) {
            return this.dPY;
        }
        if (this.dQX || this.dRb) {
            return r(this.dQI, this.dQO, this.dQT, this.dQs);
        }
        return drawable;
    }

    public Drawable aVH() {
        Drawable drawable = this.dkc;
        if (this.dkc == null) {
            return r(this.dQI, this.dQK, this.dQP, this.dQs);
        }
        return drawable;
    }
}
