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
public class c extends a {
    private float centerX;
    private float centerY;
    private StateListDrawable edC;
    private int[] edH;
    private float edI;
    private boolean edL;
    private boolean edM;
    private boolean edN;
    private boolean edO;
    private boolean edP;
    private int edW;
    private int edX;
    private int edY;
    private int edZ;
    private int eea;
    private int eeb;
    private int eec;
    private int eed;
    private int eee;
    private int eef;
    private int height;
    private int width;
    private int edD = 1;
    private int edE = 1;
    private float edF = 1.0f;
    private float edG = 1.0f;
    private int edJ = 0;
    private String edK = "TOP_BOTTOM";
    private float edQ = 0.0f;
    private float edR = 0.0f;
    private float edS = 0.0f;
    private float edT = 0.0f;
    private int edU = 0;
    private int mCornerRadius = 0;
    private int edV = 0;
    private boolean eeg = false;
    private boolean eeh = false;
    private boolean eei = false;
    private boolean eej = false;
    private boolean eek = false;
    private boolean eel = false;
    private boolean eem = false;
    private boolean een = false;

    public static c bbv() {
        return new c();
    }

    public c f(Drawable drawable) {
        this.duE = drawable;
        if (!this.edn) {
            this.edj = drawable;
        }
        if (!this.edo) {
            this.edm = drawable;
        }
        if (!this.edp) {
            this.edk = drawable;
        }
        if (!this.edq) {
            this.edl = drawable;
        }
        return this;
    }

    public c g(Drawable drawable) {
        this.edm = drawable;
        this.edo = true;
        return this;
    }

    public c lY(@DrawableRes int i) {
        return f(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c lZ(@DrawableRes int i) {
        return g(com.baidu.tbadk.core.util.e.c.a.getDrawable(i));
    }

    public c ma(int i) {
        this.edU = i;
        return this;
    }

    public c mb(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.edW = color;
        this.edL = true;
        if (!this.eeg) {
            this.edX = color;
        }
        if (!this.eeh) {
            this.edY = color;
        }
        if (!this.eei) {
            this.edZ = color;
        }
        if (!this.eej) {
            this.eea = color;
        }
        return this;
    }

    public c yi(String str) {
        int dU = com.baidu.tbadk.core.util.e.c.a.dU(str);
        this.edW = dU;
        this.edL = true;
        if (!this.eeg) {
            this.edX = dU;
        }
        if (!this.eeh) {
            this.edY = dU;
        }
        if (!this.eei) {
            this.edZ = dU;
        }
        if (!this.eej) {
            this.eea = dU;
        }
        return this;
    }

    public c mc(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.edW = color;
        this.edL = true;
        if (!this.eeg) {
            this.edX = color;
        }
        if (!this.eeh) {
            this.edY = color;
        }
        if (!this.eei) {
            this.edZ = color;
        }
        if (!this.eej) {
            this.eea = color;
        }
        return this;
    }

    public c md(@ColorRes int i) {
        this.edY = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eeh = true;
        this.edL = true;
        return this;
    }

    public c me(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.eeb = color;
        this.edM = true;
        if (!this.eek) {
            this.eec = color;
        }
        if (!this.eel) {
            this.eed = color;
        }
        if (!this.eem) {
            this.eee = color;
        }
        if (!this.een) {
            this.eef = color;
        }
        return this;
    }

    public c mf(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public c mg(int i) {
        this.edV = i;
        return this;
    }

    public c aJ(@ColorRes int i, @ColorRes int i2) {
        this.edO = true;
        this.edH = new int[2];
        this.edH[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.edH[1] = com.baidu.tbadk.core.util.e.c.a.getColor(i2);
        this.edJ = 0;
        this.edK = "TOP_BOTTOM";
        return this;
    }

    public c i(@ColorRes int... iArr) {
        this.edO = true;
        this.edJ = 0;
        this.edK = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.edH = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.edH[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c j(@ColorRes int... iArr) {
        this.edO = true;
        this.edJ = 0;
        this.edK = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.edH = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.edH[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c b(String str, @ColorRes int... iArr) {
        this.edO = true;
        this.edJ = 0;
        this.edK = str;
        if (iArr.length > 1) {
            this.edH = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.edH[i] = com.baidu.tbadk.core.util.e.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public c Q(float f) {
        this.edP = true;
        this.edQ = f;
        this.edR = f;
        this.edS = f;
        this.edT = f;
        return this;
    }

    public c R(float f) {
        this.edP = true;
        this.edQ = f;
        return this;
    }

    public c S(float f) {
        this.edP = true;
        this.edR = f;
        return this;
    }

    public c T(float f) {
        this.edP = true;
        this.edS = f;
        return this;
    }

    public c U(float f) {
        this.edP = true;
        this.edT = f;
        return this;
    }

    public c mh(int i) {
        this.mType = i;
        return this;
    }

    public c mi(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.edr = true;
        return this;
    }

    private GradientDrawable.Orientation bbw() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.edK;
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
        if (this.edO && this.edH != null && this.edH.length > 1) {
            gradientDrawable = new GradientDrawable(bbw(), this.edH);
            gradientDrawable.setGradientType(this.edJ);
            switch (this.edJ) {
                case 1:
                    gradientDrawable.setGradientRadius(this.edI);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.edL) {
            gradientDrawable.setColor(i2);
        }
        if (this.edM) {
            gradientDrawable.setStroke(this.edV, i3);
        } else if (this.edN) {
            gradientDrawable.setStroke(this.edD, i4, this.edF, this.edG);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.edP) {
            gradientDrawable.setCornerRadii(new float[]{this.edR, this.edR, this.edQ, this.edQ, this.edS, this.edS, this.edT, this.edT});
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

    public void aX(View view) {
        if (view != null) {
            bbx();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.edC);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.edC);
            }
        }
    }

    public StateListDrawable bbx() {
        this.edC = bby();
        return this.edC;
    }

    public StateListDrawable bby() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable bbz = bbz();
        if (bbz != null) {
            stateListDrawable.addState(new int[]{-16842910}, bbz);
        }
        Drawable bbA = bbA();
        if (bbA != null) {
            stateListDrawable.addState(new int[]{16842919}, bbA);
        }
        Drawable bbB = bbB();
        if (bbB != null) {
            stateListDrawable.addState(new int[]{16842913}, bbB);
        }
        Drawable bbC = bbC();
        if (bbC != null) {
            stateListDrawable.addState(new int[]{16842908}, bbC);
        }
        Drawable bbD = bbD();
        if (bbD == null) {
            bbD = new ColorDrawable(0);
        }
        if (bbD != null) {
            stateListDrawable.addState(new int[0], bbD);
        }
        return stateListDrawable;
    }

    public Drawable bbz() {
        Drawable drawable = this.edj;
        if (this.edn) {
            drawable = this.edj;
        }
        if (this.eeg || this.eek) {
            return r(this.edU, this.edX, this.eec, this.edE);
        }
        return drawable;
    }

    public Drawable bbA() {
        Drawable drawable = this.edm;
        if (this.edo) {
            return this.edm;
        }
        if (this.eeh || this.eel) {
            return r(this.edU, this.edY, this.eed, this.edE);
        }
        return drawable;
    }

    public Drawable bbB() {
        Drawable drawable = this.edk;
        if (this.edp) {
            return this.edk;
        }
        if (this.eei || this.eem) {
            return r(this.edU, this.edZ, this.eee, this.edE);
        }
        return drawable;
    }

    public Drawable bbC() {
        Drawable drawable = this.edl;
        if (this.edq) {
            return this.edl;
        }
        if (this.eej || this.een) {
            return r(this.edU, this.eea, this.eef, this.edE);
        }
        return drawable;
    }

    public Drawable bbD() {
        Drawable drawable = this.duE;
        if (this.duE == null) {
            return r(this.edU, this.edW, this.eeb, this.edE);
        }
        return drawable;
    }
}
