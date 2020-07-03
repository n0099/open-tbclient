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
    private int dXC;
    private int dXD;
    private int dXE;
    private int dXF;
    private int dXG;
    private int dXH;
    private int dXI;
    private int dXJ;
    private int dXK;
    private int dXL;
    private StateListDrawable dXi;
    private int[] dXn;
    private float dXo;
    private boolean dXr;
    private boolean dXs;
    private boolean dXt;
    private boolean dXu;
    private boolean dXv;
    private int height;
    private int width;
    private int dXj = 1;
    private int dXk = 1;
    private float dXl = 1.0f;
    private float dXm = 1.0f;
    private int dXp = 0;
    private String dXq = "TOP_BOTTOM";
    private float dXw = 0.0f;
    private float dXx = 0.0f;
    private float dXy = 0.0f;
    private float dXz = 0.0f;
    private int dXA = 0;
    private int mCornerRadius = 0;
    private int dXB = 0;
    private boolean dXM = false;
    private boolean dXN = false;
    private boolean dXO = false;
    private boolean dXP = false;
    private boolean dXQ = false;
    private boolean dXR = false;
    private boolean dXS = false;
    private boolean dXT = false;

    public static c aXu() {
        return new c();
    }

    public c f(Drawable drawable) {
        this.doN = drawable;
        if (!this.dWS) {
            this.dWO = drawable;
        }
        if (!this.dWT) {
            this.dWR = drawable;
        }
        if (!this.dWU) {
            this.dWP = drawable;
        }
        if (!this.dWV) {
            this.dWQ = drawable;
        }
        return this;
    }

    public c g(Drawable drawable) {
        this.dWR = drawable;
        this.dWT = true;
        return this;
    }

    public c lE(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c lF(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c lG(int i) {
        this.dXA = i;
        return this;
    }

    public c lH(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dXC = color;
        this.dXr = true;
        if (!this.dXM) {
            this.dXD = color;
        }
        if (!this.dXN) {
            this.dXE = color;
        }
        if (!this.dXO) {
            this.dXF = color;
        }
        if (!this.dXP) {
            this.dXG = color;
        }
        return this;
    }

    public c xa(String str) {
        int dV = com.baidu.tbadk.core.util.e.c.a.dV(str);
        this.dXC = dV;
        this.dXr = true;
        if (!this.dXM) {
            this.dXD = dV;
        }
        if (!this.dXN) {
            this.dXE = dV;
        }
        if (!this.dXO) {
            this.dXF = dV;
        }
        if (!this.dXP) {
            this.dXG = dV;
        }
        return this;
    }

    public c lI(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dXC = color;
        this.dXr = true;
        if (!this.dXM) {
            this.dXD = color;
        }
        if (!this.dXN) {
            this.dXE = color;
        }
        if (!this.dXO) {
            this.dXF = color;
        }
        if (!this.dXP) {
            this.dXG = color;
        }
        return this;
    }

    public c lJ(@ColorRes int i) {
        this.dXE = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dXN = true;
        this.dXr = true;
        return this;
    }

    public c lK(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dXH = color;
        this.dXs = true;
        if (!this.dXQ) {
            this.dXI = color;
        }
        if (!this.dXR) {
            this.dXJ = color;
        }
        if (!this.dXS) {
            this.dXK = color;
        }
        if (!this.dXT) {
            this.dXL = color;
        }
        return this;
    }

    public c lL(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public c lM(int i) {
        this.dXB = i;
        return this;
    }

    public c aI(@ColorRes int i, @ColorRes int i2) {
        this.dXu = true;
        this.dXn = new int[2];
        this.dXn[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dXn[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.dXp = 0;
        this.dXq = "TOP_BOTTOM";
        return this;
    }

    public c i(@ColorRes int... iArr) {
        this.dXu = true;
        this.dXp = 0;
        this.dXq = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dXn = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dXn[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c j(@ColorRes int... iArr) {
        this.dXu = true;
        this.dXp = 0;
        this.dXq = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dXn = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dXn[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c b(String str, @ColorRes int... iArr) {
        this.dXu = true;
        this.dXp = 0;
        this.dXq = str;
        if (iArr.length > 1) {
            this.dXn = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dXn[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c Q(float f) {
        this.dXv = true;
        this.dXw = f;
        this.dXx = f;
        this.dXy = f;
        this.dXz = f;
        return this;
    }

    public c R(float f) {
        this.dXv = true;
        this.dXw = f;
        return this;
    }

    public c S(float f) {
        this.dXv = true;
        this.dXx = f;
        return this;
    }

    public c T(float f) {
        this.dXv = true;
        this.dXy = f;
        return this;
    }

    public c U(float f) {
        this.dXv = true;
        this.dXz = f;
        return this;
    }

    public c lN(int i) {
        this.mType = i;
        return this;
    }

    public c lO(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dWW = true;
        return this;
    }

    private GradientDrawable.Orientation aXv() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dXq;
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
        if (this.dXu && this.dXn != null && this.dXn.length > 1) {
            gradientDrawable = new GradientDrawable(aXv(), this.dXn);
            gradientDrawable.setGradientType(this.dXp);
            switch (this.dXp) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dXo);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dXr) {
            gradientDrawable.setColor(i2);
        }
        if (this.dXs) {
            gradientDrawable.setStroke(this.dXB, i3);
        } else if (this.dXt) {
            gradientDrawable.setStroke(this.dXj, i4, this.dXl, this.dXm);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dXv) {
            gradientDrawable.setCornerRadii(new float[]{this.dXx, this.dXx, this.dXw, this.dXw, this.dXy, this.dXy, this.dXz, this.dXz});
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
            aXw();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dXi);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dXi);
            }
        }
    }

    public StateListDrawable aXw() {
        this.dXi = aXx();
        return this.dXi;
    }

    public StateListDrawable aXx() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aXy = aXy();
        if (aXy != null) {
            stateListDrawable.addState(new int[]{-16842910}, aXy);
        }
        Drawable aXz = aXz();
        if (aXz != null) {
            stateListDrawable.addState(new int[]{16842919}, aXz);
        }
        Drawable aXA = aXA();
        if (aXA != null) {
            stateListDrawable.addState(new int[]{16842913}, aXA);
        }
        Drawable aXB = aXB();
        if (aXB != null) {
            stateListDrawable.addState(new int[]{16842908}, aXB);
        }
        Drawable aXC = aXC();
        if (aXC == null) {
            aXC = new ColorDrawable(0);
        }
        if (aXC != null) {
            stateListDrawable.addState(new int[0], aXC);
        }
        return stateListDrawable;
    }

    public Drawable aXy() {
        Drawable drawable = this.dWO;
        if (this.dWS) {
            drawable = this.dWO;
        }
        if (this.dXM || this.dXQ) {
            return r(this.dXA, this.dXD, this.dXI, this.dXk);
        }
        return drawable;
    }

    public Drawable aXz() {
        Drawable drawable = this.dWR;
        if (this.dWT) {
            return this.dWR;
        }
        if (this.dXN || this.dXR) {
            return r(this.dXA, this.dXE, this.dXJ, this.dXk);
        }
        return drawable;
    }

    public Drawable aXA() {
        Drawable drawable = this.dWP;
        if (this.dWU) {
            return this.dWP;
        }
        if (this.dXO || this.dXS) {
            return r(this.dXA, this.dXF, this.dXK, this.dXk);
        }
        return drawable;
    }

    public Drawable aXB() {
        Drawable drawable = this.dWQ;
        if (this.dWV) {
            return this.dWQ;
        }
        if (this.dXP || this.dXT) {
            return r(this.dXA, this.dXG, this.dXL, this.dXk);
        }
        return drawable;
    }

    public Drawable aXC() {
        Drawable drawable = this.doN;
        if (this.doN == null) {
            return r(this.dXA, this.dXC, this.dXH, this.dXk);
        }
        return drawable;
    }
}
