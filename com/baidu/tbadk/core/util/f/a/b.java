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
/* loaded from: classes.dex */
public class b extends a {
    private int cYA;
    private int cYB;
    private int cYC;
    private int cYD;
    private StateListDrawable cYa;
    private int[] cYf;
    private float cYg;
    private boolean cYj;
    private boolean cYk;
    private boolean cYl;
    private boolean cYm;
    private boolean cYn;
    private int cYu;
    private int cYv;
    private int cYw;
    private int cYx;
    private int cYy;
    private int cYz;
    private float centerX;
    private float centerY;
    private int height;
    private int width;
    private int cYb = 1;
    private int cYc = 1;
    private float cYd = 1.0f;
    private float cYe = 1.0f;
    private int cYh = 0;
    private String cYi = "TOP_BOTTOM";
    private float cYo = 0.0f;
    private float cYp = 0.0f;
    private float cYq = 0.0f;
    private float cYr = 0.0f;
    private int cYs = 0;
    private int mCornerRadius = 0;
    private int cYt = 0;
    private boolean cYE = false;
    private boolean cYF = false;
    private boolean cYG = false;
    private boolean cYH = false;
    private boolean cYI = false;
    private boolean cYJ = false;
    private boolean cYK = false;
    private boolean cYL = false;

    public static b aEN() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.cvK = drawable;
        if (!this.cXV) {
            this.cXR = drawable;
        }
        if (!this.cXW) {
            this.cXU = drawable;
        }
        if (!this.cXX) {
            this.cXS = drawable;
        }
        if (!this.cXY) {
            this.cXT = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.cXU = drawable;
        this.cXW = true;
        return this;
    }

    public b ki(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kj(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kk(int i) {
        this.cYs = i;
        return this;
    }

    public b kl(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.cYu = color;
        this.cYj = true;
        if (!this.cYE) {
            this.cYv = color;
        }
        if (!this.cYF) {
            this.cYw = color;
        }
        if (!this.cYG) {
            this.cYx = color;
        }
        if (!this.cYH) {
            this.cYy = color;
        }
        return this;
    }

    public b tw(String str) {
        int cy = com.baidu.tbadk.core.util.f.c.a.cy(str);
        this.cYu = cy;
        this.cYj = true;
        if (!this.cYE) {
            this.cYv = cy;
        }
        if (!this.cYF) {
            this.cYw = cy;
        }
        if (!this.cYG) {
            this.cYx = cy;
        }
        if (!this.cYH) {
            this.cYy = cy;
        }
        return this;
    }

    public b km(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.cYu = color;
        this.cYj = true;
        if (!this.cYE) {
            this.cYv = color;
        }
        if (!this.cYF) {
            this.cYw = color;
        }
        if (!this.cYG) {
            this.cYx = color;
        }
        if (!this.cYH) {
            this.cYy = color;
        }
        return this;
    }

    public b kn(@ColorRes int i) {
        this.cYw = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.cYF = true;
        this.cYj = true;
        return this;
    }

    public b ko(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.cYz = color;
        this.cYk = true;
        if (!this.cYI) {
            this.cYA = color;
        }
        if (!this.cYJ) {
            this.cYB = color;
        }
        if (!this.cYK) {
            this.cYC = color;
        }
        if (!this.cYL) {
            this.cYD = color;
        }
        return this;
    }

    public b kp(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b kq(int i) {
        this.cYt = i;
        return this;
    }

    public b h(@ColorRes int... iArr) {
        this.cYm = true;
        this.cYh = 0;
        this.cYi = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.cYf = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.cYf[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b i(@ColorRes int... iArr) {
        this.cYm = true;
        this.cYh = 0;
        this.cYi = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.cYf = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.cYf[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.cYm = true;
        this.cYh = 0;
        this.cYi = str;
        if (iArr.length > 1) {
            this.cYf = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.cYf[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b ag(float f) {
        this.cYn = true;
        this.cYo = f;
        this.cYp = f;
        this.cYq = f;
        this.cYr = f;
        return this;
    }

    public b ah(float f) {
        this.cYn = true;
        this.cYo = f;
        return this;
    }

    public b ai(float f) {
        this.cYn = true;
        this.cYp = f;
        return this;
    }

    public b aj(float f) {
        this.cYn = true;
        this.cYq = f;
        return this;
    }

    public b ak(float f) {
        this.cYn = true;
        this.cYr = f;
        return this;
    }

    public b kr(int i) {
        this.mType = i;
        return this;
    }

    public b ks(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.cXZ = true;
        return this;
    }

    private GradientDrawable.Orientation aEO() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.cYi;
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
        if (this.cYm && this.cYf != null && this.cYf.length > 1) {
            gradientDrawable = new GradientDrawable(aEO(), this.cYf);
            gradientDrawable.setGradientType(this.cYh);
            switch (this.cYh) {
                case 1:
                    gradientDrawable.setGradientRadius(this.cYg);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.cYj) {
            gradientDrawable.setColor(i2);
        }
        if (this.cYk) {
            gradientDrawable.setStroke(this.cYt, i3);
        } else if (this.cYl) {
            gradientDrawable.setStroke(this.cYb, i4, this.cYd, this.cYe);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.cYn) {
            gradientDrawable.setCornerRadii(new float[]{this.cYp, this.cYp, this.cYo, this.cYo, this.cYq, this.cYq, this.cYr, this.cYr});
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
            aEP();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.cYa);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.cYa);
            }
        }
    }

    public StateListDrawable aEP() {
        this.cYa = aEQ();
        return this.cYa;
    }

    public StateListDrawable aEQ() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aER = aER();
        if (aER != null) {
            stateListDrawable.addState(new int[]{-16842910}, aER);
        }
        Drawable aES = aES();
        if (aES != null) {
            stateListDrawable.addState(new int[]{16842919}, aES);
        }
        Drawable aET = aET();
        if (aET != null) {
            stateListDrawable.addState(new int[]{16842913}, aET);
        }
        Drawable aEU = aEU();
        if (aEU != null) {
            stateListDrawable.addState(new int[]{16842908}, aEU);
        }
        Drawable aEV = aEV();
        if (aEV == null) {
            aEV = new ColorDrawable(0);
        }
        if (aEV != null) {
            stateListDrawable.addState(new int[0], aEV);
        }
        return stateListDrawable;
    }

    public Drawable aER() {
        Drawable drawable = this.cXR;
        if (this.cXV) {
            drawable = this.cXR;
        }
        if (this.cYE || this.cYI) {
            return s(this.cYs, this.cYv, this.cYA, this.cYc);
        }
        return drawable;
    }

    public Drawable aES() {
        Drawable drawable = this.cXU;
        if (this.cXW) {
            return this.cXU;
        }
        if (this.cYF || this.cYJ) {
            return s(this.cYs, this.cYw, this.cYB, this.cYc);
        }
        return drawable;
    }

    public Drawable aET() {
        Drawable drawable = this.cXS;
        if (this.cXX) {
            return this.cXS;
        }
        if (this.cYG || this.cYK) {
            return s(this.cYs, this.cYx, this.cYC, this.cYc);
        }
        return drawable;
    }

    public Drawable aEU() {
        Drawable drawable = this.cXT;
        if (this.cXY) {
            return this.cXT;
        }
        if (this.cYH || this.cYL) {
            return s(this.cYs, this.cYy, this.cYD, this.cYc);
        }
        return drawable;
    }

    public Drawable aEV() {
        Drawable drawable = this.cvK;
        if (this.cvK == null) {
            return s(this.cYs, this.cYu, this.cYz, this.cYc);
        }
        return drawable;
    }
}
