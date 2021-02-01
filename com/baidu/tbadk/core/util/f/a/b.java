package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class b extends a {
    private float centerX;
    private float centerY;
    private int[] fdB;
    private float fdC;
    private boolean fdF;
    private boolean fdG;
    private boolean fdH;
    private boolean fdI;
    private boolean fdJ;
    private int fdP;
    private int fdQ;
    private int fdR;
    private int fdS;
    private int fdT;
    private int fdU;
    private int fdV;
    private int fdW;
    private int fdX;
    private int fdY;
    private StateListDrawable fdw;
    private int height;
    private int width;
    private int fdx = 1;
    private int fdy = 1;
    private float fdz = 1.0f;
    private float fdA = 1.0f;
    private int fdD = 0;
    private String fdE = "TOP_BOTTOM";
    private float fdK = 0.0f;
    private float fdL = 0.0f;
    private float fdM = 0.0f;
    private float fdN = 0.0f;
    private int eWf = 0;
    private int mCornerRadius = 0;
    private int fdO = 0;
    private boolean fdZ = false;
    private boolean fea = false;
    private boolean feb = false;
    private boolean fec = false;
    private boolean fed = false;
    private boolean fee = false;
    private boolean fef = false;
    private boolean feg = false;

    public static b btw() {
        return new b();
    }

    public b l(Drawable drawable) {
        this.eto = drawable;
        if (!this.fdr) {
            this.fdn = drawable;
        }
        if (!this.fds) {
            this.fdq = drawable;
        }
        if (!this.fdt) {
            this.fdo = drawable;
        }
        if (!this.fdu) {
            this.fdp = drawable;
        }
        return this;
    }

    public b m(Drawable drawable) {
        this.fdq = drawable;
        this.fds = true;
        return this;
    }

    public b oM(@DrawableRes int i) {
        return l(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b oN(@DrawableRes int i) {
        return m(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b oO(int i) {
        this.eWf = i;
        return this;
    }

    public b oP(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fdP = color;
        this.fdF = true;
        if (!this.fdZ) {
            this.fdQ = color;
        }
        if (!this.fea) {
            this.fdR = color;
        }
        if (!this.feb) {
            this.fdS = color;
        }
        if (!this.fec) {
            this.fdT = color;
        }
        return this;
    }

    public b oQ(int i) {
        this.fdP = i;
        this.fdF = true;
        if (!this.fdZ) {
            this.fdQ = i;
        }
        if (!this.fea) {
            this.fdR = i;
        }
        if (!this.feb) {
            this.fdS = i;
        }
        if (!this.fec) {
            this.fdT = i;
        }
        return this;
    }

    public b aN(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.fdP = color;
        this.fdF = true;
        if (!this.fdZ) {
            this.fdQ = color;
        }
        if (!this.fea) {
            this.fdR = color;
        }
        if (!this.feb) {
            this.fdS = color;
        }
        if (!this.fec) {
            this.fdT = color;
        }
        return this;
    }

    public b Bw(String str) {
        int rM = com.baidu.tbadk.core.util.f.c.a.rM(str);
        this.fdP = rM;
        this.fdF = true;
        if (!this.fdZ) {
            this.fdQ = rM;
        }
        if (!this.fea) {
            this.fdR = rM;
        }
        if (!this.feb) {
            this.fdS = rM;
        }
        if (!this.fec) {
            this.fdT = rM;
        }
        return this;
    }

    public b oR(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.fdP = color;
        this.fdF = true;
        if (!this.fdZ) {
            this.fdQ = color;
        }
        if (!this.fea) {
            this.fdR = color;
        }
        if (!this.feb) {
            this.fdS = color;
        }
        if (!this.fec) {
            this.fdT = color;
        }
        return this;
    }

    public b oS(int i) {
        this.fdP = i;
        this.fdF = true;
        if (!this.fdZ) {
            this.fdQ = i;
        }
        if (!this.fea) {
            this.fdR = i;
        }
        if (!this.feb) {
            this.fdS = i;
        }
        if (!this.fec) {
            this.fdT = i;
        }
        return this;
    }

    public b oT(@ColorRes int i) {
        this.fdR = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fea = true;
        this.fdF = true;
        return this;
    }

    public b oU(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fdU = color;
        this.fdG = true;
        if (!this.fed) {
            this.fdV = color;
        }
        if (!this.fee) {
            this.fdW = color;
        }
        if (!this.fef) {
            this.fdX = color;
        }
        if (!this.feg) {
            this.fdY = color;
        }
        return this;
    }

    public b oV(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b oW(int i) {
        this.fdO = i;
        return this;
    }

    public b aO(@ColorRes int i, @ColorRes int i2) {
        this.fdI = true;
        this.fdB = new int[2];
        this.fdB[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fdB[1] = com.baidu.tbadk.core.util.f.c.a.getColor(i2);
        this.fdD = 0;
        this.fdE = "TOP_BOTTOM";
        return this;
    }

    public b m(@ColorRes int... iArr) {
        this.fdI = true;
        this.fdD = 0;
        this.fdE = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.fdB = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.fdB[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b n(@ColorRes int... iArr) {
        this.fdI = true;
        this.fdD = 0;
        this.fdE = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.fdB = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.fdB[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.fdI = true;
        this.fdD = 0;
        this.fdE = str;
        if (iArr.length > 1) {
            this.fdB = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.fdB[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b af(float f) {
        this.fdJ = true;
        this.fdK = f;
        this.fdL = f;
        this.fdM = f;
        this.fdN = f;
        return this;
    }

    public b ag(float f) {
        this.fdJ = true;
        this.fdK = f;
        return this;
    }

    public b ah(float f) {
        this.fdJ = true;
        this.fdL = f;
        return this;
    }

    public b ai(float f) {
        this.fdJ = true;
        this.fdM = f;
        return this;
    }

    public b aj(float f) {
        this.fdJ = true;
        this.fdN = f;
        return this;
    }

    public b oX(int i) {
        this.mType = i;
        return this;
    }

    public b oY(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.fdv = true;
        return this;
    }

    private GradientDrawable.Orientation btx() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.fdE;
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

    private GradientDrawable w(int i, int i2, int i3, int i4) {
        GradientDrawable gradientDrawable;
        if (this.fdI && this.fdB != null && this.fdB.length > 1) {
            gradientDrawable = new GradientDrawable(btx(), this.fdB);
            gradientDrawable.setGradientType(this.fdD);
            switch (this.fdD) {
                case 1:
                    gradientDrawable.setGradientRadius(this.fdC);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.fdF) {
            gradientDrawable.setColor(i2);
        }
        if (this.fdG) {
            gradientDrawable.setStroke(this.fdO, i3);
        } else if (this.fdH) {
            gradientDrawable.setStroke(this.fdx, i4, this.fdz, this.fdA);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.fdJ) {
            gradientDrawable.setCornerRadii(new float[]{this.fdL, this.fdL, this.fdK, this.fdK, this.fdM, this.fdM, this.fdN, this.fdN});
        }
        if (this.width > 0 && this.height > 0) {
            gradientDrawable.setSize(this.width, this.height);
        }
        if (this.centerX > 0.0f || this.centerY > 0.0f) {
            gradientDrawable.setGradientCenter(this.centerX, this.centerY);
        }
        k(gradientDrawable);
        return gradientDrawable;
    }

    public void bv(View view) {
        if (view != null) {
            bty();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.fdw);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.fdw);
            }
        }
    }

    public StateListDrawable bty() {
        this.fdw = btz();
        return this.fdw;
    }

    public StateListDrawable btz() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable btA = btA();
        if (btA != null) {
            stateListDrawable.addState(new int[]{-16842910}, btA);
        }
        Drawable btB = btB();
        if (btB != null) {
            stateListDrawable.addState(new int[]{16842919}, btB);
        }
        Drawable btC = btC();
        if (btC != null) {
            stateListDrawable.addState(new int[]{16842913}, btC);
        }
        Drawable btD = btD();
        if (btD != null) {
            stateListDrawable.addState(new int[]{16842908}, btD);
        }
        Drawable btE = btE();
        if (btE == null) {
            btE = new ColorDrawable(0);
        }
        if (btE != null) {
            stateListDrawable.addState(new int[0], btE);
        }
        return stateListDrawable;
    }

    public Drawable btA() {
        Drawable drawable = this.fdn;
        if (this.fdr) {
            drawable = this.fdn;
        }
        if (this.fdZ || this.fed) {
            return w(this.eWf, this.fdQ, this.fdV, this.fdy);
        }
        return drawable;
    }

    public Drawable btB() {
        Drawable drawable = this.fdq;
        if (this.fds) {
            return this.fdq;
        }
        if (this.fea || this.fee) {
            return w(this.eWf, this.fdR, this.fdW, this.fdy);
        }
        return drawable;
    }

    public Drawable btC() {
        Drawable drawable = this.fdo;
        if (this.fdt) {
            return this.fdo;
        }
        if (this.feb || this.fef) {
            return w(this.eWf, this.fdS, this.fdX, this.fdy);
        }
        return drawable;
    }

    public Drawable btD() {
        Drawable drawable = this.fdp;
        if (this.fdu) {
            return this.fdp;
        }
        if (this.fec || this.feg) {
            return w(this.eWf, this.fdT, this.fdY, this.fdy);
        }
        return drawable;
    }

    public Drawable btE() {
        Drawable drawable = this.eto;
        if (this.eto == null) {
            return w(this.eWf, this.fdP, this.fdU, this.fdy);
        }
        return drawable;
    }
}
