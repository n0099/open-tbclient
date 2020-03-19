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
    private StateListDrawable dcF;
    private int[] dcK;
    private float dcL;
    private boolean dcO;
    private boolean dcP;
    private boolean dcQ;
    private boolean dcR;
    private boolean dcS;
    private int dcZ;
    private int dda;
    private int ddb;
    private int ddc;
    private int ddd;
    private int dde;
    private int ddf;
    private int ddg;
    private int ddh;
    private int ddi;
    private int height;
    private int width;
    private int dcG = 1;
    private int dcH = 1;
    private float dcI = 1.0f;
    private float dcJ = 1.0f;
    private int dcM = 0;
    private String dcN = "TOP_BOTTOM";
    private float dcT = 0.0f;
    private float dcU = 0.0f;
    private float dcV = 0.0f;
    private float dcW = 0.0f;
    private int dcX = 0;
    private int mCornerRadius = 0;
    private int dcY = 0;
    private boolean ddj = false;
    private boolean ddk = false;
    private boolean ddl = false;
    private boolean ddm = false;
    private boolean ddn = false;
    private boolean ddo = false;
    private boolean ddp = false;
    private boolean ddq = false;

    public static b aHg() {
        return new b();
    }

    public b f(Drawable drawable) {
        this.czV = drawable;
        if (!this.dcA) {
            this.dcw = drawable;
        }
        if (!this.dcB) {
            this.dcz = drawable;
        }
        if (!this.dcC) {
            this.dcx = drawable;
        }
        if (!this.dcD) {
            this.dcy = drawable;
        }
        return this;
    }

    public b g(Drawable drawable) {
        this.dcz = drawable;
        this.dcB = true;
        return this;
    }

    public b kz(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b kA(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b kB(int i) {
        this.dcX = i;
        return this;
    }

    public b kC(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dcZ = color;
        this.dcO = true;
        if (!this.ddj) {
            this.dda = color;
        }
        if (!this.ddk) {
            this.ddb = color;
        }
        if (!this.ddl) {
            this.ddc = color;
        }
        if (!this.ddm) {
            this.ddd = color;
        }
        return this;
    }

    public b tN(String str) {
        int cF = com.baidu.tbadk.core.util.e.c.a.cF(str);
        this.dcZ = cF;
        this.dcO = true;
        if (!this.ddj) {
            this.dda = cF;
        }
        if (!this.ddk) {
            this.ddb = cF;
        }
        if (!this.ddl) {
            this.ddc = cF;
        }
        if (!this.ddm) {
            this.ddd = cF;
        }
        return this;
    }

    public b kD(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.dcZ = color;
        this.dcO = true;
        if (!this.ddj) {
            this.dda = color;
        }
        if (!this.ddk) {
            this.ddb = color;
        }
        if (!this.ddl) {
            this.ddc = color;
        }
        if (!this.ddm) {
            this.ddd = color;
        }
        return this;
    }

    public b kE(@ColorRes int i) {
        this.ddb = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.ddk = true;
        this.dcO = true;
        return this;
    }

    public b kF(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dde = color;
        this.dcP = true;
        if (!this.ddn) {
            this.ddf = color;
        }
        if (!this.ddo) {
            this.ddg = color;
        }
        if (!this.ddp) {
            this.ddh = color;
        }
        if (!this.ddq) {
            this.ddi = color;
        }
        return this;
    }

    public b kG(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b kH(int i) {
        this.dcY = i;
        return this;
    }

    public b h(@ColorRes int... iArr) {
        this.dcR = true;
        this.dcM = 0;
        this.dcN = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dcK = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcK[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b i(@ColorRes int... iArr) {
        this.dcR = true;
        this.dcM = 0;
        this.dcN = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.dcK = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcK[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.dcR = true;
        this.dcM = 0;
        this.dcN = str;
        if (iArr.length > 1) {
            this.dcK = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.dcK[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b af(float f) {
        this.dcS = true;
        this.dcT = f;
        this.dcU = f;
        this.dcV = f;
        this.dcW = f;
        return this;
    }

    public b ag(float f) {
        this.dcS = true;
        this.dcT = f;
        return this;
    }

    public b ah(float f) {
        this.dcS = true;
        this.dcU = f;
        return this;
    }

    public b ai(float f) {
        this.dcS = true;
        this.dcV = f;
        return this;
    }

    public b aj(float f) {
        this.dcS = true;
        this.dcW = f;
        return this;
    }

    public b kI(int i) {
        this.mType = i;
        return this;
    }

    public b kJ(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.dcE = true;
        return this;
    }

    private GradientDrawable.Orientation aHh() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.dcN;
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
        if (this.dcR && this.dcK != null && this.dcK.length > 1) {
            gradientDrawable = new GradientDrawable(aHh(), this.dcK);
            gradientDrawable.setGradientType(this.dcM);
            switch (this.dcM) {
                case 1:
                    gradientDrawable.setGradientRadius(this.dcL);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.dcO) {
            gradientDrawable.setColor(i2);
        }
        if (this.dcP) {
            gradientDrawable.setStroke(this.dcY, i3);
        } else if (this.dcQ) {
            gradientDrawable.setStroke(this.dcG, i4, this.dcI, this.dcJ);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.dcS) {
            gradientDrawable.setCornerRadii(new float[]{this.dcU, this.dcU, this.dcT, this.dcT, this.dcV, this.dcV, this.dcW, this.dcW});
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
            aHi();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.dcF);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.dcF);
            }
        }
    }

    public StateListDrawable aHi() {
        this.dcF = aHj();
        return this.dcF;
    }

    public StateListDrawable aHj() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable aHk = aHk();
        if (aHk != null) {
            stateListDrawable.addState(new int[]{-16842910}, aHk);
        }
        Drawable aHl = aHl();
        if (aHl != null) {
            stateListDrawable.addState(new int[]{16842919}, aHl);
        }
        Drawable aHm = aHm();
        if (aHm != null) {
            stateListDrawable.addState(new int[]{16842913}, aHm);
        }
        Drawable aHn = aHn();
        if (aHn != null) {
            stateListDrawable.addState(new int[]{16842908}, aHn);
        }
        Drawable aHo = aHo();
        if (aHo == null) {
            aHo = new ColorDrawable(0);
        }
        if (aHo != null) {
            stateListDrawable.addState(new int[0], aHo);
        }
        return stateListDrawable;
    }

    public Drawable aHk() {
        Drawable drawable = this.dcw;
        if (this.dcA) {
            drawable = this.dcw;
        }
        if (this.ddj || this.ddn) {
            return s(this.dcX, this.dda, this.ddf, this.dcH);
        }
        return drawable;
    }

    public Drawable aHl() {
        Drawable drawable = this.dcz;
        if (this.dcB) {
            return this.dcz;
        }
        if (this.ddk || this.ddo) {
            return s(this.dcX, this.ddb, this.ddg, this.dcH);
        }
        return drawable;
    }

    public Drawable aHm() {
        Drawable drawable = this.dcx;
        if (this.dcC) {
            return this.dcx;
        }
        if (this.ddl || this.ddp) {
            return s(this.dcX, this.ddc, this.ddh, this.dcH);
        }
        return drawable;
    }

    public Drawable aHn() {
        Drawable drawable = this.dcy;
        if (this.dcD) {
            return this.dcy;
        }
        if (this.ddm || this.ddq) {
            return s(this.dcX, this.ddd, this.ddi, this.dcH);
        }
        return drawable;
    }

    public Drawable aHo() {
        Drawable drawable = this.czV;
        if (this.czV == null) {
            return s(this.dcX, this.dcZ, this.dde, this.dcH);
        }
        return drawable;
    }
}
