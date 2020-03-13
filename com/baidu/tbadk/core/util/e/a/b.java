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
public class b extends a {
    private float centerX;
    private float centerY;
    private boolean dcB;
    private boolean dcC;
    private boolean dcD;
    private boolean dcE;
    private boolean dcF;
    private int dcM;
    private int dcN;
    private int dcO;
    private int dcP;
    private int dcQ;
    private int dcR;
    private int dcS;
    private int dcT;
    private int dcU;
    private int dcV;
    private StateListDrawable dcr;
    private int[] dcx;
    private float dcy;
    private int height;
    private int width;
    private int dcs = 1;
    private int dct = 1;
    private float dcv = 1.0f;
    private float dcw = 1.0f;
    private int dcz = 0;
    private String dcA = "TOP_BOTTOM";
    private float dcG = 0.0f;
    private float dcH = 0.0f;
    private float dcI = 0.0f;
    private float dcJ = 0.0f;
    private int dcK = 0;
    private int mCornerRadius = 0;
    private int dcL = 0;
    private boolean dcW = false;
    private boolean dcX = false;
    private boolean dcY = false;
    private boolean dcZ = false;
    private boolean dda = false;
    private boolean ddb = false;
    private boolean ddc = false;
    private boolean ddd = false;

    public static b aHc() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.czK = drawable;
        if (!this.dcm) {
            this.dci = drawable;
        }
        if (!this.dcn) {
            this.dcl = drawable;
        }
        if (!this.dco) {
            this.dcj = drawable;
        }
        if (!this.dcp) {
            this.dck = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.dcl = drawable;
        this.dcn = true;
        return this;
    }

    public b kz(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b kA(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b kB(int i) {
        this.dcK = i;
        return this;
    }

    public b kC(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dcM = color;
        this.dcB = true;
        if (!this.dcW) {
            this.dcN = color;
        }
        if (!this.dcX) {
            this.dcO = color;
        }
        if (!this.dcY) {
            this.dcP = color;
        }
        if (!this.dcZ) {
            this.dcQ = color;
        }
        return this;
    }

    public b tN(String str) {
        int cG = com.baidu.tbadk.core.util.e.c.a.cG(str);
        this.dcM = cG;
        this.dcB = true;
        if (!this.dcW) {
            this.dcN = cG;
        }
        if (!this.dcX) {
            this.dcO = cG;
        }
        if (!this.dcY) {
            this.dcP = cG;
        }
        if (!this.dcZ) {
            this.dcQ = cG;
        }
        return this;
    }

    public b kD(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dcM = color;
        this.dcB = true;
        if (!this.dcW) {
            this.dcN = color;
        }
        if (!this.dcX) {
            this.dcO = color;
        }
        if (!this.dcY) {
            this.dcP = color;
        }
        if (!this.dcZ) {
            this.dcQ = color;
        }
        return this;
    }

    public b kE(@ColorRes int i) {
        this.dcO = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dcX = true;
        this.dcB = true;
        return this;
    }

    public b kF(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dcR = color;
        this.dcC = true;
        if (!this.dda) {
            this.dcS = color;
        }
        if (!this.ddb) {
            this.dcT = color;
        }
        if (!this.ddc) {
            this.dcU = color;
        }
        if (!this.ddd) {
            this.dcV = color;
        }
        return this;
    }

    public b kG(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b kH(int i) {
        this.dcL = i;
        return this;
    }

    public b h(@ColorRes int... iArr) {
        this.dcE = true;
        this.dcz = 0;
        this.dcA = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dcx = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcx[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b i(@ColorRes int... iArr) {
        this.dcE = true;
        this.dcz = 0;
        this.dcA = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dcx = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcx[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.dcE = true;
        this.dcz = 0;
        this.dcA = str;
        if (iArr.length > 1) {
            this.dcx = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcx[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b af(float f) {
        this.dcF = true;
        this.dcG = f;
        this.dcH = f;
        this.dcI = f;
        this.dcJ = f;
        return this;
    }

    public b ag(float f) {
        this.dcF = true;
        this.dcG = f;
        return this;
    }

    public b ah(float f) {
        this.dcF = true;
        this.dcH = f;
        return this;
    }

    public b ai(float f) {
        this.dcF = true;
        this.dcI = f;
        return this;
    }

    public b aj(float f) {
        this.dcF = true;
        this.dcJ = f;
        return this;
    }

    public b kI(int i) {
        this.mType = i;
        return this;
    }

    public b kJ(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dcq = true;
        return this;
    }

    private GradientDrawable.Orientation aHd() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dcA;
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

    private GradientDrawable s(int i, int i2, int i3, int i4) {
        GradientDrawable gradientDrawable;
        if (this.dcE && this.dcx != null && this.dcx.length > 1) {
            gradientDrawable = new GradientDrawable(aHd(), this.dcx);
            gradientDrawable.setGradientType(this.dcz);
            switch (this.dcz) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dcy);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dcB) {
            gradientDrawable.setColor(i2);
        }
        if (this.dcC) {
            gradientDrawable.setStroke(this.dcL, i3);
        } else if (this.dcD) {
            gradientDrawable.setStroke(this.dcs, i4, this.dcv, this.dcw);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dcF) {
            gradientDrawable.setCornerRadii(new float[]{this.dcH, this.dcH, this.dcG, this.dcG, this.dcI, this.dcI, this.dcJ, this.dcJ});
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

    public void aQ(View view) {
        if (view != null) {
            aHe();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dcr);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dcr);
            }
        }
    }

    public StateListDrawable aHe() {
        this.dcr = aHf();
        return this.dcr;
    }

    public StateListDrawable aHf() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aHg = aHg();
        if (aHg != null) {
            stateListDrawable.addState(new int[]{-16842910}, aHg);
        }
        Drawable aHh = aHh();
        if (aHh != null) {
            stateListDrawable.addState(new int[]{16842919}, aHh);
        }
        Drawable aHi = aHi();
        if (aHi != null) {
            stateListDrawable.addState(new int[]{16842913}, aHi);
        }
        Drawable aHj = aHj();
        if (aHj != null) {
            stateListDrawable.addState(new int[]{16842908}, aHj);
        }
        Drawable aHk = aHk();
        if (aHk == null) {
            aHk = new ColorDrawable(0);
        }
        if (aHk != null) {
            stateListDrawable.addState(new int[0], aHk);
        }
        return stateListDrawable;
    }

    public Drawable aHg() {
        Drawable drawable = this.dci;
        if (this.dcm) {
            drawable = this.dci;
        }
        if (this.dcW || this.dda) {
            return s(this.dcK, this.dcN, this.dcS, this.dct);
        }
        return drawable;
    }

    public Drawable aHh() {
        Drawable drawable = this.dcl;
        if (this.dcn) {
            return this.dcl;
        }
        if (this.dcX || this.ddb) {
            return s(this.dcK, this.dcO, this.dcT, this.dct);
        }
        return drawable;
    }

    public Drawable aHi() {
        Drawable drawable = this.dcj;
        if (this.dco) {
            return this.dcj;
        }
        if (this.dcY || this.ddc) {
            return s(this.dcK, this.dcP, this.dcU, this.dct);
        }
        return drawable;
    }

    public Drawable aHj() {
        Drawable drawable = this.dck;
        if (this.dcp) {
            return this.dck;
        }
        if (this.dcZ || this.ddd) {
            return s(this.dcK, this.dcQ, this.dcV, this.dct);
        }
        return drawable;
    }

    public Drawable aHk() {
        Drawable drawable = this.czK;
        if (this.czK == null) {
            return s(this.dcK, this.dcM, this.dcR, this.dct);
        }
        return drawable;
    }
}
