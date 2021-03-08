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
    private StateListDrawable feV;
    private int[] ffa;
    private float ffb;
    private boolean ffe;
    private boolean fff;
    private boolean ffg;
    private boolean ffh;
    private boolean ffi;
    private int ffo;
    private int ffp;
    private int ffq;
    private int ffr;
    private int ffs;
    private int fft;
    private int ffu;
    private int ffv;
    private int ffw;
    private int ffx;
    private int height;
    private int width;
    private int feW = 1;
    private int feX = 1;
    private float feY = 1.0f;
    private float feZ = 1.0f;
    private int ffc = 0;
    private String ffd = "TOP_BOTTOM";
    private float ffj = 0.0f;
    private float ffk = 0.0f;
    private float ffl = 0.0f;
    private float ffm = 0.0f;
    private int eXE = 0;
    private int mCornerRadius = 0;
    private int ffn = 0;
    private boolean ffy = false;
    private boolean ffz = false;
    private boolean ffA = false;
    private boolean ffB = false;
    private boolean ffC = false;
    private boolean ffD = false;
    private boolean ffE = false;
    private boolean ffF = false;

    public static b btz() {
        return new b();
    }

    public b l(Drawable drawable) {
        this.euP = drawable;
        if (!this.feQ) {
            this.feM = drawable;
        }
        if (!this.feR) {
            this.feP = drawable;
        }
        if (!this.feS) {
            this.feN = drawable;
        }
        if (!this.feT) {
            this.feO = drawable;
        }
        return this;
    }

    public b m(Drawable drawable) {
        this.feP = drawable;
        this.feR = true;
        return this;
    }

    public b oN(@DrawableRes int i) {
        return l(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b oO(@DrawableRes int i) {
        return m(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b oP(int i) {
        this.eXE = i;
        return this;
    }

    public b oQ(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.ffo = color;
        this.ffe = true;
        if (!this.ffy) {
            this.ffp = color;
        }
        if (!this.ffz) {
            this.ffq = color;
        }
        if (!this.ffA) {
            this.ffr = color;
        }
        if (!this.ffB) {
            this.ffs = color;
        }
        return this;
    }

    public b oR(int i) {
        this.ffo = i;
        this.ffe = true;
        if (!this.ffy) {
            this.ffp = i;
        }
        if (!this.ffz) {
            this.ffq = i;
        }
        if (!this.ffA) {
            this.ffr = i;
        }
        if (!this.ffB) {
            this.ffs = i;
        }
        return this;
    }

    public b aN(@ColorRes int i, int i2) {
        int color = ap.getColor(i2, i);
        this.ffo = color;
        this.ffe = true;
        if (!this.ffy) {
            this.ffp = color;
        }
        if (!this.ffz) {
            this.ffq = color;
        }
        if (!this.ffA) {
            this.ffr = color;
        }
        if (!this.ffB) {
            this.ffs = color;
        }
        return this;
    }

    public b BD(String str) {
        int rT = com.baidu.tbadk.core.util.f.c.a.rT(str);
        this.ffo = rT;
        this.ffe = true;
        if (!this.ffy) {
            this.ffp = rT;
        }
        if (!this.ffz) {
            this.ffq = rT;
        }
        if (!this.ffA) {
            this.ffr = rT;
        }
        if (!this.ffB) {
            this.ffs = rT;
        }
        return this;
    }

    public b oS(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.ffo = color;
        this.ffe = true;
        if (!this.ffy) {
            this.ffp = color;
        }
        if (!this.ffz) {
            this.ffq = color;
        }
        if (!this.ffA) {
            this.ffr = color;
        }
        if (!this.ffB) {
            this.ffs = color;
        }
        return this;
    }

    public b oT(int i) {
        this.ffo = i;
        this.ffe = true;
        if (!this.ffy) {
            this.ffp = i;
        }
        if (!this.ffz) {
            this.ffq = i;
        }
        if (!this.ffA) {
            this.ffr = i;
        }
        if (!this.ffB) {
            this.ffs = i;
        }
        return this;
    }

    public b oU(@ColorRes int i) {
        this.ffq = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.ffz = true;
        this.ffe = true;
        return this;
    }

    public b oV(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fft = color;
        this.fff = true;
        if (!this.ffC) {
            this.ffu = color;
        }
        if (!this.ffD) {
            this.ffv = color;
        }
        if (!this.ffE) {
            this.ffw = color;
        }
        if (!this.ffF) {
            this.ffx = color;
        }
        return this;
    }

    public b oW(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b oX(int i) {
        this.ffn = i;
        return this;
    }

    public b aO(@ColorRes int i, @ColorRes int i2) {
        this.ffh = true;
        this.ffa = new int[2];
        this.ffa[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.ffa[1] = com.baidu.tbadk.core.util.f.c.a.getColor(i2);
        this.ffc = 0;
        this.ffd = "TOP_BOTTOM";
        return this;
    }

    public b m(@ColorRes int... iArr) {
        this.ffh = true;
        this.ffc = 0;
        this.ffd = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.ffa = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ffa[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b n(@ColorRes int... iArr) {
        this.ffh = true;
        this.ffc = 0;
        this.ffd = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.ffa = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ffa[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.ffh = true;
        this.ffc = 0;
        this.ffd = str;
        if (iArr.length > 1) {
            this.ffa = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ffa[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b aj(float f) {
        this.ffi = true;
        this.ffj = f;
        this.ffk = f;
        this.ffl = f;
        this.ffm = f;
        return this;
    }

    public b ak(float f) {
        this.ffi = true;
        this.ffj = f;
        return this;
    }

    public b al(float f) {
        this.ffi = true;
        this.ffk = f;
        return this;
    }

    public b am(float f) {
        this.ffi = true;
        this.ffl = f;
        return this;
    }

    public b an(float f) {
        this.ffi = true;
        this.ffm = f;
        return this;
    }

    public b oY(int i) {
        this.mType = i;
        return this;
    }

    public b oZ(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.feU = true;
        return this;
    }

    private GradientDrawable.Orientation btA() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.ffd;
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
        if (this.ffh && this.ffa != null && this.ffa.length > 1) {
            gradientDrawable = new GradientDrawable(btA(), this.ffa);
            gradientDrawable.setGradientType(this.ffc);
            switch (this.ffc) {
                case 1:
                    gradientDrawable.setGradientRadius(this.ffb);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.ffe) {
            gradientDrawable.setColor(i2);
        }
        if (this.fff) {
            gradientDrawable.setStroke(this.ffn, i3);
        } else if (this.ffg) {
            gradientDrawable.setStroke(this.feW, i4, this.feY, this.feZ);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.ffi) {
            gradientDrawable.setCornerRadii(new float[]{this.ffk, this.ffk, this.ffj, this.ffj, this.ffl, this.ffl, this.ffm, this.ffm});
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
            btB();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.feV);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.feV);
            }
        }
    }

    public StateListDrawable btB() {
        this.feV = btC();
        return this.feV;
    }

    public StateListDrawable btC() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable btD = btD();
        if (btD != null) {
            stateListDrawable.addState(new int[]{-16842910}, btD);
        }
        Drawable btE = btE();
        if (btE != null) {
            stateListDrawable.addState(new int[]{16842919}, btE);
        }
        Drawable btF = btF();
        if (btF != null) {
            stateListDrawable.addState(new int[]{16842913}, btF);
        }
        Drawable btG = btG();
        if (btG != null) {
            stateListDrawable.addState(new int[]{16842908}, btG);
        }
        Drawable btH = btH();
        if (btH == null) {
            btH = new ColorDrawable(0);
        }
        if (btH != null) {
            stateListDrawable.addState(new int[0], btH);
        }
        return stateListDrawable;
    }

    public Drawable btD() {
        Drawable drawable = this.feM;
        if (this.feQ) {
            drawable = this.feM;
        }
        if (this.ffy || this.ffC) {
            return w(this.eXE, this.ffp, this.ffu, this.feX);
        }
        return drawable;
    }

    public Drawable btE() {
        Drawable drawable = this.feP;
        if (this.feR) {
            return this.feP;
        }
        if (this.ffz || this.ffD) {
            return w(this.eXE, this.ffq, this.ffv, this.feX);
        }
        return drawable;
    }

    public Drawable btF() {
        Drawable drawable = this.feN;
        if (this.feS) {
            return this.feN;
        }
        if (this.ffA || this.ffE) {
            return w(this.eXE, this.ffr, this.ffw, this.feX);
        }
        return drawable;
    }

    public Drawable btG() {
        Drawable drawable = this.feO;
        if (this.feT) {
            return this.feO;
        }
        if (this.ffB || this.ffF) {
            return w(this.eXE, this.ffs, this.ffx, this.feX);
        }
        return drawable;
    }

    public Drawable btH() {
        Drawable drawable = this.euP;
        if (this.euP == null) {
            return w(this.eXE, this.ffo, this.fft, this.feX);
        }
        return drawable;
    }
}
