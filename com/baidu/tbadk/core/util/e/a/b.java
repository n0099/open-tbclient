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
    private boolean eWA;
    private boolean eWB;
    private int eWH;
    private int eWI;
    private int eWJ;
    private int eWK;
    private int eWL;
    private int eWM;
    private int eWN;
    private int eWO;
    private int eWP;
    private int eWQ;
    private StateListDrawable eWo;
    private int[] eWt;
    private float eWu;
    private boolean eWx;
    private boolean eWy;
    private boolean eWz;
    private int height;
    private int width;
    private int eWp = 1;
    private int eWq = 1;
    private float eWr = 1.0f;
    private float eWs = 1.0f;
    private int eWv = 0;
    private String eWw = "TOP_BOTTOM";
    private float eWC = 0.0f;
    private float eWD = 0.0f;
    private float eWE = 0.0f;
    private float eWF = 0.0f;
    private int eOB = 0;
    private int mCornerRadius = 0;
    private int eWG = 0;
    private boolean eWR = false;
    private boolean eWS = false;
    private boolean eWT = false;
    private boolean eWU = false;
    private boolean eWV = false;
    private boolean eWW = false;
    private boolean eWX = false;
    private boolean eWY = false;

    public static b buA() {
        return new b();
    }

    public b g(Drawable drawable) {
        this.emn = drawable;
        if (!this.eWj) {
            this.eWf = drawable;
        }
        if (!this.eWk) {
            this.eWi = drawable;
        }
        if (!this.eWl) {
            this.eWg = drawable;
        }
        if (!this.eWm) {
            this.eWh = drawable;
        }
        return this;
    }

    public b h(Drawable drawable) {
        this.eWi = drawable;
        this.eWk = true;
        return this;
    }

    public b qd(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b qe(@DrawableRes int i) {
        return h(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public b qf(int i) {
        this.eOB = i;
        return this;
    }

    public b qg(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eWH = color;
        this.eWx = true;
        if (!this.eWR) {
            this.eWI = color;
        }
        if (!this.eWS) {
            this.eWJ = color;
        }
        if (!this.eWT) {
            this.eWK = color;
        }
        if (!this.eWU) {
            this.eWL = color;
        }
        return this;
    }

    public b qh(int i) {
        this.eWH = i;
        this.eWx = true;
        if (!this.eWR) {
            this.eWI = i;
        }
        if (!this.eWS) {
            this.eWJ = i;
        }
        if (!this.eWT) {
            this.eWK = i;
        }
        if (!this.eWU) {
            this.eWL = i;
        }
        return this;
    }

    public b Ct(String str) {
        int sI = com.baidu.tbadk.core.util.e.c.a.sI(str);
        this.eWH = sI;
        this.eWx = true;
        if (!this.eWR) {
            this.eWI = sI;
        }
        if (!this.eWS) {
            this.eWJ = sI;
        }
        if (!this.eWT) {
            this.eWK = sI;
        }
        if (!this.eWU) {
            this.eWL = sI;
        }
        return this;
    }

    public b qi(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.eWH = color;
        this.eWx = true;
        if (!this.eWR) {
            this.eWI = color;
        }
        if (!this.eWS) {
            this.eWJ = color;
        }
        if (!this.eWT) {
            this.eWK = color;
        }
        if (!this.eWU) {
            this.eWL = color;
        }
        return this;
    }

    public b qj(int i) {
        this.eWH = i;
        this.eWx = true;
        if (!this.eWR) {
            this.eWI = i;
        }
        if (!this.eWS) {
            this.eWJ = i;
        }
        if (!this.eWT) {
            this.eWK = i;
        }
        if (!this.eWU) {
            this.eWL = i;
        }
        return this;
    }

    public b qk(@ColorRes int i) {
        this.eWJ = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eWS = true;
        this.eWx = true;
        return this;
    }

    public b ql(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eWM = color;
        this.eWy = true;
        if (!this.eWV) {
            this.eWN = color;
        }
        if (!this.eWW) {
            this.eWO = color;
        }
        if (!this.eWX) {
            this.eWP = color;
        }
        if (!this.eWY) {
            this.eWQ = color;
        }
        return this;
    }

    public b qm(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b qn(int i) {
        this.eWG = i;
        return this;
    }

    public b aT(@ColorRes int i, @ColorRes int i2) {
        this.eWA = true;
        this.eWt = new int[2];
        this.eWt[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eWt[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.eWv = 0;
        this.eWw = "TOP_BOTTOM";
        return this;
    }

    public b l(@ColorRes int... iArr) {
        this.eWA = true;
        this.eWv = 0;
        this.eWw = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eWt = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eWt[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b m(@ColorRes int... iArr) {
        this.eWA = true;
        this.eWv = 0;
        this.eWw = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.eWt = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eWt[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.eWA = true;
        this.eWv = 0;
        this.eWw = str;
        if (iArr.length > 1) {
            this.eWt = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.eWt[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b ac(float f) {
        this.eWB = true;
        this.eWC = f;
        this.eWD = f;
        this.eWE = f;
        this.eWF = f;
        return this;
    }

    public b ad(float f) {
        this.eWB = true;
        this.eWC = f;
        return this;
    }

    public b ae(float f) {
        this.eWB = true;
        this.eWD = f;
        return this;
    }

    public b af(float f) {
        this.eWB = true;
        this.eWE = f;
        return this;
    }

    public b ag(float f) {
        this.eWB = true;
        this.eWF = f;
        return this;
    }

    public b qo(int i) {
        this.mType = i;
        return this;
    }

    public b qp(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.eWn = true;
        return this;
    }

    private GradientDrawable.Orientation buB() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.eWw;
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

    private GradientDrawable v(int i, int i2, int i3, int i4) {
        GradientDrawable gradientDrawable;
        if (this.eWA && this.eWt != null && this.eWt.length > 1) {
            gradientDrawable = new GradientDrawable(buB(), this.eWt);
            gradientDrawable.setGradientType(this.eWv);
            switch (this.eWv) {
                case 1:
                    gradientDrawable.setGradientRadius(this.eWu);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.eWx) {
            gradientDrawable.setColor(i2);
        }
        if (this.eWy) {
            gradientDrawable.setStroke(this.eWG, i3);
        } else if (this.eWz) {
            gradientDrawable.setStroke(this.eWp, i4, this.eWr, this.eWs);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.eWB) {
            gradientDrawable.setCornerRadii(new float[]{this.eWD, this.eWD, this.eWC, this.eWC, this.eWE, this.eWE, this.eWF, this.eWF});
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

    public void bq(View view) {
        if (view != null) {
            buC();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.eWo);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.eWo);
            }
        }
    }

    public StateListDrawable buC() {
        this.eWo = buD();
        return this.eWo;
    }

    public StateListDrawable buD() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable buE = buE();
        if (buE != null) {
            stateListDrawable.addState(new int[]{-16842910}, buE);
        }
        Drawable buF = buF();
        if (buF != null) {
            stateListDrawable.addState(new int[]{16842919}, buF);
        }
        Drawable buG = buG();
        if (buG != null) {
            stateListDrawable.addState(new int[]{16842913}, buG);
        }
        Drawable buH = buH();
        if (buH != null) {
            stateListDrawable.addState(new int[]{16842908}, buH);
        }
        Drawable buI = buI();
        if (buI == null) {
            buI = new ColorDrawable(0);
        }
        if (buI != null) {
            stateListDrawable.addState(new int[0], buI);
        }
        return stateListDrawable;
    }

    public Drawable buE() {
        Drawable drawable = this.eWf;
        if (this.eWj) {
            drawable = this.eWf;
        }
        if (this.eWR || this.eWV) {
            return v(this.eOB, this.eWI, this.eWN, this.eWq);
        }
        return drawable;
    }

    public Drawable buF() {
        Drawable drawable = this.eWi;
        if (this.eWk) {
            return this.eWi;
        }
        if (this.eWS || this.eWW) {
            return v(this.eOB, this.eWJ, this.eWO, this.eWq);
        }
        return drawable;
    }

    public Drawable buG() {
        Drawable drawable = this.eWg;
        if (this.eWl) {
            return this.eWg;
        }
        if (this.eWT || this.eWX) {
            return v(this.eOB, this.eWK, this.eWP, this.eWq);
        }
        return drawable;
    }

    public Drawable buH() {
        Drawable drawable = this.eWh;
        if (this.eWm) {
            return this.eWh;
        }
        if (this.eWU || this.eWY) {
            return v(this.eOB, this.eWL, this.eWQ, this.eWq);
        }
        return drawable;
    }

    public Drawable buI() {
        Drawable drawable = this.emn;
        if (this.emn == null) {
            return v(this.eOB, this.eWH, this.eWM, this.eWq);
        }
        return drawable;
    }
}
