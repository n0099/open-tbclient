package com.baidu.tbadk.core.util.f.a;

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
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
/* loaded from: classes.dex */
public class b extends a {
    private StateListDrawable cXQ;
    private int[] cXV;
    private float cXW;
    private boolean cXZ;
    private boolean cYa;
    private boolean cYb;
    private boolean cYc;
    private boolean cYd;
    private int cYk;
    private int cYl;
    private int cYm;
    private int cYn;
    private int cYo;
    private int cYp;
    private int cYq;
    private int cYr;
    private int cYs;
    private int cYt;
    private float centerX;
    private float centerY;
    private int height;
    private int width;
    private int cXR = 1;
    private int cXS = 1;
    private float cXT = 1.0f;
    private float cXU = 1.0f;
    private int cXX = 0;
    private String cXY = "TOP_BOTTOM";
    private float cYe = 0.0f;
    private float cYf = 0.0f;
    private float cYg = 0.0f;
    private float cYh = 0.0f;
    private int cYi = 0;
    private int mCornerRadius = 0;
    private int cYj = 0;
    private boolean cYu = false;
    private boolean cYv = false;
    private boolean cYw = false;
    private boolean cYx = false;
    private boolean cYy = false;
    private boolean cYz = false;
    private boolean cYA = false;
    private boolean cYB = false;

    public static b aEu() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.cvz = drawable;
        if (!this.cXL) {
            this.cXH = drawable;
        }
        if (!this.cXM) {
            this.cXK = drawable;
        }
        if (!this.cXN) {
            this.cXI = drawable;
        }
        if (!this.cXO) {
            this.cXJ = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.cXK = drawable;
        this.cXM = true;
        return this;
    }

    public b ki(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kj(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kk(@DrawableSelector.Shape int i) {
        this.cYi = i;
        return this;
    }

    public b kl(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.cYk = color;
        this.cXZ = true;
        if (!this.cYu) {
            this.cYl = color;
        }
        if (!this.cYv) {
            this.cYm = color;
        }
        if (!this.cYw) {
            this.cYn = color;
        }
        if (!this.cYx) {
            this.cYo = color;
        }
        return this;
    }

    public b ts(String str) {
        int cy = com.baidu.tbadk.core.util.f.c.a.cy(str);
        this.cYk = cy;
        this.cXZ = true;
        if (!this.cYu) {
            this.cYl = cy;
        }
        if (!this.cYv) {
            this.cYm = cy;
        }
        if (!this.cYw) {
            this.cYn = cy;
        }
        if (!this.cYx) {
            this.cYo = cy;
        }
        return this;
    }

    public b km(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.cYk = color;
        this.cXZ = true;
        if (!this.cYu) {
            this.cYl = color;
        }
        if (!this.cYv) {
            this.cYm = color;
        }
        if (!this.cYw) {
            this.cYn = color;
        }
        if (!this.cYx) {
            this.cYo = color;
        }
        return this;
    }

    public b kn(@ColorRes int i) {
        this.cYm = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.cYv = true;
        this.cXZ = true;
        return this;
    }

    public b ko(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.cYp = color;
        this.cYa = true;
        if (!this.cYy) {
            this.cYq = color;
        }
        if (!this.cYz) {
            this.cYr = color;
        }
        if (!this.cYA) {
            this.cYs = color;
        }
        if (!this.cYB) {
            this.cYt = color;
        }
        return this;
    }

    public b kp(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b kq(int i) {
        this.cYj = i;
        return this;
    }

    public b h(@ColorRes int... iArr) {
        this.cYc = true;
        this.cXX = 0;
        this.cXY = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.cXV = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.cXV[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b i(@ColorRes int... iArr) {
        this.cYc = true;
        this.cXX = 0;
        this.cXY = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.cXV = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.cXV[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.cYc = true;
        this.cXX = 0;
        this.cXY = str;
        if (iArr.length > 1) {
            this.cXV = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.cXV[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b ah(float f) {
        this.cYd = true;
        this.cYe = f;
        this.cYf = f;
        this.cYg = f;
        this.cYh = f;
        return this;
    }

    public b ai(float f) {
        this.cYd = true;
        this.cYe = f;
        return this;
    }

    public b aj(float f) {
        this.cYd = true;
        this.cYf = f;
        return this;
    }

    public b ak(float f) {
        this.cYd = true;
        this.cYg = f;
        return this;
    }

    public b al(float f) {
        this.cYd = true;
        this.cYh = f;
        return this;
    }

    public b kr(int i) {
        this.mType = i;
        return this;
    }

    public b ks(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.cXP = true;
        return this;
    }

    private GradientDrawable.Orientation aEv() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.cXY;
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
        if (this.cYc && this.cXV != null && this.cXV.length > 1) {
            gradientDrawable = new GradientDrawable(aEv(), this.cXV);
            gradientDrawable.setGradientType(this.cXX);
            switch (this.cXX) {
                case 1:
                    gradientDrawable.setGradientRadius(this.cXW);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.cXZ) {
            gradientDrawable.setColor(i2);
        }
        if (this.cYa) {
            gradientDrawable.setStroke(this.cYj, i3);
        } else if (this.cYb) {
            gradientDrawable.setStroke(this.cXR, i4, this.cXT, this.cXU);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.cYd) {
            gradientDrawable.setCornerRadii(new float[]{this.cYf, this.cYf, this.cYe, this.cYe, this.cYg, this.cYg, this.cYh, this.cYh});
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

    public void aM(View view) {
        if (view != null) {
            aEw();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.cXQ);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.cXQ);
            }
        }
    }

    public StateListDrawable aEw() {
        this.cXQ = aEx();
        return this.cXQ;
    }

    public StateListDrawable aEx() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aEy = aEy();
        if (aEy != null) {
            stateListDrawable.addState(new int[]{-16842910}, aEy);
        }
        Drawable aEz = aEz();
        if (aEz != null) {
            stateListDrawable.addState(new int[]{16842919}, aEz);
        }
        Drawable aEA = aEA();
        if (aEA != null) {
            stateListDrawable.addState(new int[]{16842913}, aEA);
        }
        Drawable aEB = aEB();
        if (aEB != null) {
            stateListDrawable.addState(new int[]{16842908}, aEB);
        }
        Drawable aEC = aEC();
        if (aEC == null) {
            aEC = new ColorDrawable(0);
        }
        if (aEC != null) {
            stateListDrawable.addState(new int[0], aEC);
        }
        return stateListDrawable;
    }

    public Drawable aEy() {
        Drawable drawable = this.cXH;
        if (this.cXL) {
            drawable = this.cXH;
        }
        if (this.cYu || this.cYy) {
            return s(this.cYi, this.cYl, this.cYq, this.cXS);
        }
        return drawable;
    }

    public Drawable aEz() {
        Drawable drawable = this.cXK;
        if (this.cXM) {
            return this.cXK;
        }
        if (this.cYv || this.cYz) {
            return s(this.cYi, this.cYm, this.cYr, this.cXS);
        }
        return drawable;
    }

    public Drawable aEA() {
        Drawable drawable = this.cXI;
        if (this.cXN) {
            return this.cXI;
        }
        if (this.cYw || this.cYA) {
            return s(this.cYi, this.cYn, this.cYs, this.cXS);
        }
        return drawable;
    }

    public Drawable aEB() {
        Drawable drawable = this.cXJ;
        if (this.cXO) {
            return this.cXJ;
        }
        if (this.cYx || this.cYB) {
            return s(this.cYi, this.cYo, this.cYt, this.cXS);
        }
        return drawable;
    }

    public Drawable aEC() {
        Drawable drawable = this.cvz;
        if (this.cvz == null) {
            return s(this.cYi, this.cYk, this.cYp, this.cXS);
        }
        return drawable;
    }
}
