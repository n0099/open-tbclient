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
    private StateListDrawable dcd;
    private int[] dci;
    private float dcj;
    private boolean dcm;
    private boolean dcn;
    private boolean dco;
    private boolean dcp;
    private boolean dcq;
    private int dcy;
    private int dcz;
    private int height;
    private int width;
    private int dce = 1;
    private int dcf = 1;
    private float dcg = 1.0f;
    private float dch = 1.0f;
    private int dck = 0;
    private String dcl = "TOP_BOTTOM";
    private float dcr = 0.0f;
    private float dcs = 0.0f;
    private float dct = 0.0f;
    private float dcv = 0.0f;
    private int dcw = 0;
    private int mCornerRadius = 0;
    private int dcx = 0;
    private boolean dcI = false;
    private boolean dcJ = false;
    private boolean dcK = false;
    private boolean dcL = false;
    private boolean dcM = false;
    private boolean dcN = false;
    private boolean dcO = false;
    private boolean dcP = false;

    public static b aGZ() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.czI = drawable;
        if (!this.dbY) {
            this.dbU = drawable;
        }
        if (!this.dbZ) {
            this.dbX = drawable;
        }
        if (!this.dca) {
            this.dbV = drawable;
        }
        if (!this.dcb) {
            this.dbW = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.dbX = drawable;
        this.dbZ = true;
        return this;
    }

    public b kz(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kA(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b kB(int i) {
        this.dcw = i;
        return this;
    }

    public b kC(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.dcy = color;
        this.dcm = true;
        if (!this.dcI) {
            this.dcz = color;
        }
        if (!this.dcJ) {
            this.dcA = color;
        }
        if (!this.dcK) {
            this.dcB = color;
        }
        if (!this.dcL) {
            this.dcC = color;
        }
        return this;
    }

    public b tM(String str) {
        int cG = com.baidu.tbadk.core.util.f.c.a.cG(str);
        this.dcy = cG;
        this.dcm = true;
        if (!this.dcI) {
            this.dcz = cG;
        }
        if (!this.dcJ) {
            this.dcA = cG;
        }
        if (!this.dcK) {
            this.dcB = cG;
        }
        if (!this.dcL) {
            this.dcC = cG;
        }
        return this;
    }

    public b kD(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dcy = color;
        this.dcm = true;
        if (!this.dcI) {
            this.dcz = color;
        }
        if (!this.dcJ) {
            this.dcA = color;
        }
        if (!this.dcK) {
            this.dcB = color;
        }
        if (!this.dcL) {
            this.dcC = color;
        }
        return this;
    }

    public b kE(@ColorRes int i) {
        this.dcA = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.dcJ = true;
        this.dcm = true;
        return this;
    }

    public b kF(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.dcD = color;
        this.dcn = true;
        if (!this.dcM) {
            this.dcE = color;
        }
        if (!this.dcN) {
            this.dcF = color;
        }
        if (!this.dcO) {
            this.dcG = color;
        }
        if (!this.dcP) {
            this.dcH = color;
        }
        return this;
    }

    public b kG(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b kH(int i) {
        this.dcx = i;
        return this;
    }

    public b h(@ColorRes int... iArr) {
        this.dcp = true;
        this.dck = 0;
        this.dcl = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dci = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dci[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b i(@ColorRes int... iArr) {
        this.dcp = true;
        this.dck = 0;
        this.dcl = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dci = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dci[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.dcp = true;
        this.dck = 0;
        this.dcl = str;
        if (iArr.length > 1) {
            this.dci = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dci[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b af(float f) {
        this.dcq = true;
        this.dcr = f;
        this.dcs = f;
        this.dct = f;
        this.dcv = f;
        return this;
    }

    public b ag(float f) {
        this.dcq = true;
        this.dcr = f;
        return this;
    }

    public b ah(float f) {
        this.dcq = true;
        this.dcs = f;
        return this;
    }

    public b ai(float f) {
        this.dcq = true;
        this.dct = f;
        return this;
    }

    public b aj(float f) {
        this.dcq = true;
        this.dcv = f;
        return this;
    }

    public b kI(int i) {
        this.mType = i;
        return this;
    }

    public b kJ(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dcc = true;
        return this;
    }

    private GradientDrawable.Orientation aHa() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dcl;
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
        if (this.dcp && this.dci != null && this.dci.length > 1) {
            gradientDrawable = new GradientDrawable(aHa(), this.dci);
            gradientDrawable.setGradientType(this.dck);
            switch (this.dck) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dcj);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dcm) {
            gradientDrawable.setColor(i2);
        }
        if (this.dcn) {
            gradientDrawable.setStroke(this.dcx, i3);
        } else if (this.dco) {
            gradientDrawable.setStroke(this.dce, i4, this.dcg, this.dch);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dcq) {
            gradientDrawable.setCornerRadii(new float[]{this.dcs, this.dcs, this.dcr, this.dcr, this.dct, this.dct, this.dcv, this.dcv});
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
            aHb();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dcd);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dcd);
            }
        }
    }

    public StateListDrawable aHb() {
        this.dcd = aHc();
        return this.dcd;
    }

    public StateListDrawable aHc() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aHd = aHd();
        if (aHd != null) {
            stateListDrawable.addState(new int[]{-16842910}, aHd);
        }
        Drawable aHe = aHe();
        if (aHe != null) {
            stateListDrawable.addState(new int[]{16842919}, aHe);
        }
        Drawable aHf = aHf();
        if (aHf != null) {
            stateListDrawable.addState(new int[]{16842913}, aHf);
        }
        Drawable aHg = aHg();
        if (aHg != null) {
            stateListDrawable.addState(new int[]{16842908}, aHg);
        }
        Drawable aHh = aHh();
        if (aHh == null) {
            aHh = new ColorDrawable(0);
        }
        if (aHh != null) {
            stateListDrawable.addState(new int[0], aHh);
        }
        return stateListDrawable;
    }

    public Drawable aHd() {
        Drawable drawable = this.dbU;
        if (this.dbY) {
            drawable = this.dbU;
        }
        if (this.dcI || this.dcM) {
            return s(this.dcw, this.dcz, this.dcE, this.dcf);
        }
        return drawable;
    }

    public Drawable aHe() {
        Drawable drawable = this.dbX;
        if (this.dbZ) {
            return this.dbX;
        }
        if (this.dcJ || this.dcN) {
            return s(this.dcw, this.dcA, this.dcF, this.dcf);
        }
        return drawable;
    }

    public Drawable aHf() {
        Drawable drawable = this.dbV;
        if (this.dca) {
            return this.dbV;
        }
        if (this.dcK || this.dcO) {
            return s(this.dcw, this.dcB, this.dcG, this.dcf);
        }
        return drawable;
    }

    public Drawable aHg() {
        Drawable drawable = this.dbW;
        if (this.dcb) {
            return this.dbW;
        }
        if (this.dcL || this.dcP) {
            return s(this.dcw, this.dcC, this.dcH, this.dcf);
        }
        return drawable;
    }

    public Drawable aHh() {
        Drawable drawable = this.czI;
        if (this.czI == null) {
            return s(this.dcw, this.dcy, this.dcD, this.dcf);
        }
        return drawable;
    }
}
