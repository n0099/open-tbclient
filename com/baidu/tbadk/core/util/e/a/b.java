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
    private int eKA;
    private int eKB;
    private int eKC;
    private int eKD;
    private int eKE;
    private int eKF;
    private int eKG;
    private int eKH;
    private int eKI;
    private int eKJ;
    private StateListDrawable eKg;
    private int[] eKl;
    private float eKm;
    private boolean eKp;
    private boolean eKq;
    private boolean eKr;
    private boolean eKs;
    private boolean eKt;
    private int height;
    private int width;
    private int eKh = 1;
    private int eKi = 1;
    private float eKj = 1.0f;
    private float eKk = 1.0f;
    private int eKn = 0;
    private String eKo = "TOP_BOTTOM";
    private float eKu = 0.0f;
    private float eKv = 0.0f;
    private float eKw = 0.0f;
    private float eKx = 0.0f;
    private int eKy = 0;
    private int mCornerRadius = 0;
    private int eKz = 0;
    private boolean eKK = false;
    private boolean eKL = false;
    private boolean eKM = false;
    private boolean eKN = false;
    private boolean eKO = false;
    private boolean eKP = false;
    private boolean eKQ = false;
    private boolean eKR = false;

    public static b bpp() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.ebc = drawable;
        if (!this.eKb) {
            this.eJX = drawable;
        }
        if (!this.eKc) {
            this.eKa = drawable;
        }
        if (!this.eKd) {
            this.eJY = drawable;
        }
        if (!this.eKe) {
            this.eJZ = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.eKa = drawable;
        this.eKc = true;
        return this;
    }

    public b oX(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b oY(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b oZ(int i) {
        this.eKy = i;
        return this;
    }

    public b pa(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eKA = color;
        this.eKp = true;
        if (!this.eKK) {
            this.eKB = color;
        }
        if (!this.eKL) {
            this.eKC = color;
        }
        if (!this.eKM) {
            this.eKD = color;
        }
        if (!this.eKN) {
            this.eKE = color;
        }
        return this;
    }

    public b aQ(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.eKA = color;
        this.eKp = true;
        if (!this.eKK) {
            this.eKB = color;
        }
        if (!this.eKL) {
            this.eKC = color;
        }
        if (!this.eKM) {
            this.eKD = color;
        }
        if (!this.eKN) {
            this.eKE = color;
        }
        return this;
    }

    public b BY(String str) {
        int fv = com.baidu.tbadk.core.util.e.c.a.fv(str);
        this.eKA = fv;
        this.eKp = true;
        if (!this.eKK) {
            this.eKB = fv;
        }
        if (!this.eKL) {
            this.eKC = fv;
        }
        if (!this.eKM) {
            this.eKD = fv;
        }
        if (!this.eKN) {
            this.eKE = fv;
        }
        return this;
    }

    public b pb(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.eKA = color;
        this.eKp = true;
        if (!this.eKK) {
            this.eKB = color;
        }
        if (!this.eKL) {
            this.eKC = color;
        }
        if (!this.eKM) {
            this.eKD = color;
        }
        if (!this.eKN) {
            this.eKE = color;
        }
        return this;
    }

    public b pc(@ColorRes int i) {
        this.eKC = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eKL = true;
        this.eKp = true;
        return this;
    }

    public b pd(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eKF = color;
        this.eKq = true;
        if (!this.eKO) {
            this.eKG = color;
        }
        if (!this.eKP) {
            this.eKH = color;
        }
        if (!this.eKQ) {
            this.eKI = color;
        }
        if (!this.eKR) {
            this.eKJ = color;
        }
        return this;
    }

    public b pe(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b pf(int i) {
        this.eKz = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.eKs = true;
        this.eKl = new int[2];
        this.eKl[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eKl[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.eKn = 0;
        this.eKo = "TOP_BOTTOM";
        return this;
    }

    public b i(@ColorRes int... iArr) {
        this.eKs = true;
        this.eKn = 0;
        this.eKo = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eKl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eKl[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b j(@ColorRes int... iArr) {
        this.eKs = true;
        this.eKn = 0;
        this.eKo = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eKl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eKl[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.eKs = true;
        this.eKn = 0;
        this.eKo = str;
        if (iArr.length > 1) {
            this.eKl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eKl[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b Z(float f) {
        this.eKt = true;
        this.eKu = f;
        this.eKv = f;
        this.eKw = f;
        this.eKx = f;
        return this;
    }

    public b aa(float f) {
        this.eKt = true;
        this.eKu = f;
        return this;
    }

    public b ab(float f) {
        this.eKt = true;
        this.eKv = f;
        return this;
    }

    public b ac(float f) {
        this.eKt = true;
        this.eKw = f;
        return this;
    }

    public b ad(float f) {
        this.eKt = true;
        this.eKx = f;
        return this;
    }

    public b pg(int i) {
        this.mType = i;
        return this;
    }

    public b ph(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.eKf = true;
        return this;
    }

    private GradientDrawable.Orientation bpq() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.eKo;
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
        if (this.eKs && this.eKl != null && this.eKl.length > 1) {
            gradientDrawable = new GradientDrawable(bpq(), this.eKl);
            gradientDrawable.setGradientType(this.eKn);
            switch (this.eKn) {
                case 1:
                    gradientDrawable.setGradientRadius(this.eKm);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.eKp) {
            gradientDrawable.setColor(i2);
        }
        if (this.eKq) {
            gradientDrawable.setStroke(this.eKz, i3);
        } else if (this.eKr) {
            gradientDrawable.setStroke(this.eKh, i4, this.eKj, this.eKk);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.eKt) {
            gradientDrawable.setCornerRadii(new float[]{this.eKv, this.eKv, this.eKu, this.eKu, this.eKw, this.eKw, this.eKx, this.eKx});
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

    public void bg(View view) {
        if (view != null) {
            bpr();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.eKg);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.eKg);
            }
        }
    }

    public StateListDrawable bpr() {
        this.eKg = bps();
        return this.eKg;
    }

    public StateListDrawable bps() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable bpt = bpt();
        if (bpt != null) {
            stateListDrawable.addState(new int[]{-16842910}, bpt);
        }
        Drawable bpu = bpu();
        if (bpu != null) {
            stateListDrawable.addState(new int[]{16842919}, bpu);
        }
        Drawable bpv = bpv();
        if (bpv != null) {
            stateListDrawable.addState(new int[]{16842913}, bpv);
        }
        Drawable bpw = bpw();
        if (bpw != null) {
            stateListDrawable.addState(new int[]{16842908}, bpw);
        }
        Drawable bpx = bpx();
        if (bpx == null) {
            bpx = new ColorDrawable(0);
        }
        if (bpx != null) {
            stateListDrawable.addState(new int[0], bpx);
        }
        return stateListDrawable;
    }

    public Drawable bpt() {
        Drawable drawable = this.eJX;
        if (this.eKb) {
            drawable = this.eJX;
        }
        if (this.eKK || this.eKO) {
            return r(this.eKy, this.eKB, this.eKG, this.eKi);
        }
        return drawable;
    }

    public Drawable bpu() {
        Drawable drawable = this.eKa;
        if (this.eKc) {
            return this.eKa;
        }
        if (this.eKL || this.eKP) {
            return r(this.eKy, this.eKC, this.eKH, this.eKi);
        }
        return drawable;
    }

    public Drawable bpv() {
        Drawable drawable = this.eJY;
        if (this.eKd) {
            return this.eJY;
        }
        if (this.eKM || this.eKQ) {
            return r(this.eKy, this.eKD, this.eKI, this.eKi);
        }
        return drawable;
    }

    public Drawable bpw() {
        Drawable drawable = this.eJZ;
        if (this.eKe) {
            return this.eJZ;
        }
        if (this.eKN || this.eKR) {
            return r(this.eKy, this.eKE, this.eKJ, this.eKi);
        }
        return drawable;
    }

    public Drawable bpx() {
        Drawable drawable = this.ebc;
        if (this.ebc == null) {
            return r(this.eKy, this.eKA, this.eKF, this.eKi);
        }
        return drawable;
    }
}
