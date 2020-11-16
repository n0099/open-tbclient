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
    private StateListDrawable eOZ;
    private int ePA;
    private int ePB;
    private int[] ePe;
    private float ePf;
    private boolean ePi;
    private boolean ePj;
    private boolean ePk;
    private boolean ePl;
    private boolean ePm;
    private int ePs;
    private int ePt;
    private int ePu;
    private int ePv;
    private int ePw;
    private int ePx;
    private int ePy;
    private int ePz;
    private int height;
    private int width;
    private int ePa = 1;
    private int ePb = 1;
    private float ePc = 1.0f;
    private float ePd = 1.0f;
    private int ePg = 0;
    private String ePh = "TOP_BOTTOM";
    private float ePn = 0.0f;
    private float ePo = 0.0f;
    private float ePp = 0.0f;
    private float ePq = 0.0f;
    private int eHr = 0;
    private int mCornerRadius = 0;
    private int ePr = 0;
    private boolean ePC = false;
    private boolean ePD = false;
    private boolean ePE = false;
    private boolean ePF = false;
    private boolean ePG = false;
    private boolean ePH = false;
    private boolean ePI = false;
    private boolean ePJ = false;

    public static b brd() {
        return new b();
    }

    public b g(Drawable drawable) {
        this.efm = drawable;
        if (!this.eOU) {
            this.eOQ = drawable;
        }
        if (!this.eOV) {
            this.eOT = drawable;
        }
        if (!this.eOW) {
            this.eOR = drawable;
        }
        if (!this.eOX) {
            this.eOS = drawable;
        }
        return this;
    }

    public b h(Drawable drawable) {
        this.eOT = drawable;
        this.eOV = true;
        return this;
    }

    public b pD(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b pE(@DrawableRes int i) {
        return h(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b pF(int i) {
        this.eHr = i;
        return this;
    }

    public b pG(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.ePs = color;
        this.ePi = true;
        if (!this.ePC) {
            this.ePt = color;
        }
        if (!this.ePD) {
            this.ePu = color;
        }
        if (!this.ePE) {
            this.ePv = color;
        }
        if (!this.ePF) {
            this.ePw = color;
        }
        return this;
    }

    public b pH(int i) {
        this.ePs = i;
        this.ePi = true;
        if (!this.ePC) {
            this.ePt = i;
        }
        if (!this.ePD) {
            this.ePu = i;
        }
        if (!this.ePE) {
            this.ePv = i;
        }
        if (!this.ePF) {
            this.ePw = i;
        }
        return this;
    }

    public b pI(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.ePs = color;
        this.ePi = true;
        if (!this.ePC) {
            this.ePt = color;
        }
        if (!this.ePD) {
            this.ePu = color;
        }
        if (!this.ePE) {
            this.ePv = color;
        }
        if (!this.ePF) {
            this.ePw = color;
        }
        return this;
    }

    public b pJ(int i) {
        this.ePs = i;
        this.ePi = true;
        if (!this.ePC) {
            this.ePt = i;
        }
        if (!this.ePD) {
            this.ePu = i;
        }
        if (!this.ePE) {
            this.ePv = i;
        }
        if (!this.ePF) {
            this.ePw = i;
        }
        return this;
    }

    public b pK(@ColorRes int i) {
        this.ePu = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.ePD = true;
        this.ePi = true;
        return this;
    }

    public b pL(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.ePx = color;
        this.ePj = true;
        if (!this.ePG) {
            this.ePy = color;
        }
        if (!this.ePH) {
            this.ePz = color;
        }
        if (!this.ePI) {
            this.ePA = color;
        }
        if (!this.ePJ) {
            this.ePB = color;
        }
        return this;
    }

    public b pM(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b pN(int i) {
        this.ePr = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.ePl = true;
        this.ePe = new int[2];
        this.ePe[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.ePe[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.ePg = 0;
        this.ePh = "TOP_BOTTOM";
        return this;
    }

    public b l(@ColorRes int... iArr) {
        this.ePl = true;
        this.ePg = 0;
        this.ePh = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.ePe = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ePe[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b m(@ColorRes int... iArr) {
        this.ePl = true;
        this.ePg = 0;
        this.ePh = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.ePe = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ePe[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.ePl = true;
        this.ePg = 0;
        this.ePh = str;
        if (iArr.length > 1) {
            this.ePe = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ePe[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b ac(float f) {
        this.ePm = true;
        this.ePn = f;
        this.ePo = f;
        this.ePp = f;
        this.ePq = f;
        return this;
    }

    public b ad(float f) {
        this.ePm = true;
        this.ePn = f;
        return this;
    }

    public b ae(float f) {
        this.ePm = true;
        this.ePo = f;
        return this;
    }

    public b af(float f) {
        this.ePm = true;
        this.ePp = f;
        return this;
    }

    public b ag(float f) {
        this.ePm = true;
        this.ePq = f;
        return this;
    }

    public b pO(int i) {
        this.mType = i;
        return this;
    }

    public b pP(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.eOY = true;
        return this;
    }

    private GradientDrawable.Orientation bre() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.ePh;
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
        if (this.ePl && this.ePe != null && this.ePe.length > 1) {
            gradientDrawable = new GradientDrawable(bre(), this.ePe);
            gradientDrawable.setGradientType(this.ePg);
            switch (this.ePg) {
                case 1:
                    gradientDrawable.setGradientRadius(this.ePf);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.ePi) {
            gradientDrawable.setColor(i2);
        }
        if (this.ePj) {
            gradientDrawable.setStroke(this.ePr, i3);
        } else if (this.ePk) {
            gradientDrawable.setStroke(this.ePa, i4, this.ePc, this.ePd);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.ePm) {
            gradientDrawable.setCornerRadii(new float[]{this.ePo, this.ePo, this.ePn, this.ePn, this.ePp, this.ePp, this.ePq, this.ePq});
        }
        if (this.width > 0 && this.height > 0) {
            gradientDrawable.setSize(this.width, this.height);
        }
        if (this.centerX > 0.0f || this.centerY > 0.0f) {
            gradientDrawable.setGradientCenter(this.centerX, this.centerY);
        }
        f(gradientDrawable);
        return gradientDrawable;
    }

    public void bn(View view) {
        if (view != null) {
            brf();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.eOZ);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.eOZ);
            }
        }
    }

    public StateListDrawable brf() {
        this.eOZ = brg();
        return this.eOZ;
    }

    public StateListDrawable brg() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable brh = brh();
        if (brh != null) {
            stateListDrawable.addState(new int[]{-16842910}, brh);
        }
        Drawable bri = bri();
        if (bri != null) {
            stateListDrawable.addState(new int[]{16842919}, bri);
        }
        Drawable brj = brj();
        if (brj != null) {
            stateListDrawable.addState(new int[]{16842913}, brj);
        }
        Drawable brk = brk();
        if (brk != null) {
            stateListDrawable.addState(new int[]{16842908}, brk);
        }
        Drawable brl = brl();
        if (brl == null) {
            brl = new ColorDrawable(0);
        }
        if (brl != null) {
            stateListDrawable.addState(new int[0], brl);
        }
        return stateListDrawable;
    }

    public Drawable brh() {
        Drawable drawable = this.eOQ;
        if (this.eOU) {
            drawable = this.eOQ;
        }
        if (this.ePC || this.ePG) {
            return r(this.eHr, this.ePt, this.ePy, this.ePb);
        }
        return drawable;
    }

    public Drawable bri() {
        Drawable drawable = this.eOT;
        if (this.eOV) {
            return this.eOT;
        }
        if (this.ePD || this.ePH) {
            return r(this.eHr, this.ePu, this.ePz, this.ePb);
        }
        return drawable;
    }

    public Drawable brj() {
        Drawable drawable = this.eOR;
        if (this.eOW) {
            return this.eOR;
        }
        if (this.ePE || this.ePI) {
            return r(this.eHr, this.ePv, this.ePA, this.ePb);
        }
        return drawable;
    }

    public Drawable brk() {
        Drawable drawable = this.eOS;
        if (this.eOX) {
            return this.eOS;
        }
        if (this.ePF || this.ePJ) {
            return r(this.eHr, this.ePw, this.ePB, this.ePb);
        }
        return drawable;
    }

    public Drawable brl() {
        Drawable drawable = this.efm;
        if (this.efm == null) {
            return r(this.eHr, this.ePs, this.ePx, this.ePb);
        }
        return drawable;
    }
}
