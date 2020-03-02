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
    private float centerX;
    private float centerY;
    private int dcA;
    private int dcB;
    private int dcC;
    private int dcD;
    private int dcE;
    private int dcF;
    private int dcG;
    private int dcH;
    private int dcI;
    private StateListDrawable dce;
    private int[] dcj;
    private float dck;
    private boolean dcn;
    private boolean dco;
    private boolean dcp;
    private boolean dcq;
    private boolean dcr;
    private int dcz;
    private int height;
    private int width;
    private int dcf = 1;
    private int dcg = 1;
    private float dch = 1.0f;
    private float dci = 1.0f;
    private int dcl = 0;
    private String dcm = "TOP_BOTTOM";
    private float dcs = 0.0f;
    private float dct = 0.0f;
    private float dcv = 0.0f;
    private float dcw = 0.0f;
    private int dcx = 0;
    private int mCornerRadius = 0;
    private int dcy = 0;
    private boolean dcJ = false;
    private boolean dcK = false;
    private boolean dcL = false;
    private boolean dcM = false;
    private boolean dcN = false;
    private boolean dcO = false;
    private boolean dcP = false;
    private boolean dcQ = false;

    public static b aHb() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.czJ = drawable;
        if (!this.dbZ) {
            this.dbV = drawable;
        }
        if (!this.dca) {
            this.dbY = drawable;
        }
        if (!this.dcb) {
            this.dbW = drawable;
        }
        if (!this.dcc) {
            this.dbX = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.dbY = drawable;
        this.dca = true;
        return this;
    }

    public b kz(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kA(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kB(int i) {
        this.dcx = i;
        return this;
    }

    public b kC(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.dcz = color;
        this.dcn = true;
        if (!this.dcJ) {
            this.dcA = color;
        }
        if (!this.dcK) {
            this.dcB = color;
        }
        if (!this.dcL) {
            this.dcC = color;
        }
        if (!this.dcM) {
            this.dcD = color;
        }
        return this;
    }

    public b tM(String str) {
        int cG = com.baidu.tbadk.core.util.f.c.a.cG(str);
        this.dcz = cG;
        this.dcn = true;
        if (!this.dcJ) {
            this.dcA = cG;
        }
        if (!this.dcK) {
            this.dcB = cG;
        }
        if (!this.dcL) {
            this.dcC = cG;
        }
        if (!this.dcM) {
            this.dcD = cG;
        }
        return this;
    }

    public b kD(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dcz = color;
        this.dcn = true;
        if (!this.dcJ) {
            this.dcA = color;
        }
        if (!this.dcK) {
            this.dcB = color;
        }
        if (!this.dcL) {
            this.dcC = color;
        }
        if (!this.dcM) {
            this.dcD = color;
        }
        return this;
    }

    public b kE(@ColorRes int i) {
        this.dcB = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.dcK = true;
        this.dcn = true;
        return this;
    }

    public b kF(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.dcE = color;
        this.dco = true;
        if (!this.dcN) {
            this.dcF = color;
        }
        if (!this.dcO) {
            this.dcG = color;
        }
        if (!this.dcP) {
            this.dcH = color;
        }
        if (!this.dcQ) {
            this.dcI = color;
        }
        return this;
    }

    public b kG(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b kH(int i) {
        this.dcy = i;
        return this;
    }

    public b h(@ColorRes int... iArr) {
        this.dcq = true;
        this.dcl = 0;
        this.dcm = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dcj = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcj[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b i(@ColorRes int... iArr) {
        this.dcq = true;
        this.dcl = 0;
        this.dcm = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dcj = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcj[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.dcq = true;
        this.dcl = 0;
        this.dcm = str;
        if (iArr.length > 1) {
            this.dcj = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcj[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b af(float f) {
        this.dcr = true;
        this.dcs = f;
        this.dct = f;
        this.dcv = f;
        this.dcw = f;
        return this;
    }

    public b ag(float f) {
        this.dcr = true;
        this.dcs = f;
        return this;
    }

    public b ah(float f) {
        this.dcr = true;
        this.dct = f;
        return this;
    }

    public b ai(float f) {
        this.dcr = true;
        this.dcv = f;
        return this;
    }

    public b aj(float f) {
        this.dcr = true;
        this.dcw = f;
        return this;
    }

    public b kI(int i) {
        this.mType = i;
        return this;
    }

    public b kJ(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dcd = true;
        return this;
    }

    private GradientDrawable.Orientation aHc() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dcm;
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
        if (this.dcq && this.dcj != null && this.dcj.length > 1) {
            gradientDrawable = new GradientDrawable(aHc(), this.dcj);
            gradientDrawable.setGradientType(this.dcl);
            switch (this.dcl) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dck);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dcn) {
            gradientDrawable.setColor(i2);
        }
        if (this.dco) {
            gradientDrawable.setStroke(this.dcy, i3);
        } else if (this.dcp) {
            gradientDrawable.setStroke(this.dcf, i4, this.dch, this.dci);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dcr) {
            gradientDrawable.setCornerRadii(new float[]{this.dct, this.dct, this.dcs, this.dcs, this.dcv, this.dcv, this.dcw, this.dcw});
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
            aHd();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dce);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dce);
            }
        }
    }

    public StateListDrawable aHd() {
        this.dce = aHe();
        return this.dce;
    }

    public StateListDrawable aHe() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aHf = aHf();
        if (aHf != null) {
            stateListDrawable.addState(new int[]{-16842910}, aHf);
        }
        Drawable aHg = aHg();
        if (aHg != null) {
            stateListDrawable.addState(new int[]{16842919}, aHg);
        }
        Drawable aHh = aHh();
        if (aHh != null) {
            stateListDrawable.addState(new int[]{16842913}, aHh);
        }
        Drawable aHi = aHi();
        if (aHi != null) {
            stateListDrawable.addState(new int[]{16842908}, aHi);
        }
        Drawable aHj = aHj();
        if (aHj == null) {
            aHj = new ColorDrawable(0);
        }
        if (aHj != null) {
            stateListDrawable.addState(new int[0], aHj);
        }
        return stateListDrawable;
    }

    public Drawable aHf() {
        Drawable drawable = this.dbV;
        if (this.dbZ) {
            drawable = this.dbV;
        }
        if (this.dcJ || this.dcN) {
            return s(this.dcx, this.dcA, this.dcF, this.dcg);
        }
        return drawable;
    }

    public Drawable aHg() {
        Drawable drawable = this.dbY;
        if (this.dca) {
            return this.dbY;
        }
        if (this.dcK || this.dcO) {
            return s(this.dcx, this.dcB, this.dcG, this.dcg);
        }
        return drawable;
    }

    public Drawable aHh() {
        Drawable drawable = this.dbW;
        if (this.dcb) {
            return this.dbW;
        }
        if (this.dcL || this.dcP) {
            return s(this.dcx, this.dcC, this.dcH, this.dcg);
        }
        return drawable;
    }

    public Drawable aHi() {
        Drawable drawable = this.dbX;
        if (this.dcc) {
            return this.dbX;
        }
        if (this.dcM || this.dcQ) {
            return s(this.dcx, this.dcD, this.dcI, this.dcg);
        }
        return drawable;
    }

    public Drawable aHj() {
        Drawable drawable = this.czJ;
        if (this.czJ == null) {
            return s(this.dcx, this.dcz, this.dcE, this.dcg);
        }
        return drawable;
    }
}
