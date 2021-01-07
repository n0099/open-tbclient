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
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class b extends a {
    private float centerX;
    private float centerY;
    private StateListDrawable ffP;
    private int[] ffU;
    private float ffV;
    private boolean ffY;
    private boolean ffZ;
    private boolean fga;
    private boolean fgb;
    private boolean fgc;
    private int fgi;
    private int fgj;
    private int fgk;
    private int fgl;
    private int fgm;
    private int fgn;
    private int fgo;
    private int fgp;
    private int fgq;
    private int fgr;
    private int height;
    private int width;
    private int ffQ = 1;
    private int ffR = 1;
    private float ffS = 1.0f;
    private float ffT = 1.0f;
    private int ffW = 0;
    private String ffX = "TOP_BOTTOM";
    private float fgd = 0.0f;
    private float fge = 0.0f;
    private float fgf = 0.0f;
    private float fgg = 0.0f;
    private int eYA = 0;
    private int mCornerRadius = 0;
    private int fgh = 0;
    private boolean fgs = false;
    private boolean fgt = false;
    private boolean fgu = false;
    private boolean fgv = false;
    private boolean fgw = false;
    private boolean fgx = false;
    private boolean fgy = false;
    private boolean fgz = false;

    public static b bwW() {
        return new b();
    }

    public b l(Drawable drawable) {
        this.evU = drawable;
        if (!this.ffK) {
            this.ffG = drawable;
        }
        if (!this.ffL) {
            this.ffJ = drawable;
        }
        if (!this.ffM) {
            this.ffH = drawable;
        }
        if (!this.ffN) {
            this.ffI = drawable;
        }
        return this;
    }

    public b m(Drawable drawable) {
        this.ffJ = drawable;
        this.ffL = true;
        return this;
    }

    public b qo(@DrawableRes int i) {
        return l(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b qp(@DrawableRes int i) {
        return m(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b qq(int i) {
        this.eYA = i;
        return this;
    }

    public b qr(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fgi = color;
        this.ffY = true;
        if (!this.fgs) {
            this.fgj = color;
        }
        if (!this.fgt) {
            this.fgk = color;
        }
        if (!this.fgu) {
            this.fgl = color;
        }
        if (!this.fgv) {
            this.fgm = color;
        }
        return this;
    }

    public b qs(int i) {
        this.fgi = i;
        this.ffY = true;
        if (!this.fgs) {
            this.fgj = i;
        }
        if (!this.fgt) {
            this.fgk = i;
        }
        if (!this.fgu) {
            this.fgl = i;
        }
        if (!this.fgv) {
            this.fgm = i;
        }
        return this;
    }

    public b aQ(@ColorRes int i, int i2) {
        int color = ao.getColor(i2, i);
        this.fgi = color;
        this.ffY = true;
        if (!this.fgs) {
            this.fgj = color;
        }
        if (!this.fgt) {
            this.fgk = color;
        }
        if (!this.fgu) {
            this.fgl = color;
        }
        if (!this.fgv) {
            this.fgm = color;
        }
        return this;
    }

    public b Cq(String str) {
        int sF = com.baidu.tbadk.core.util.f.c.a.sF(str);
        this.fgi = sF;
        this.ffY = true;
        if (!this.fgs) {
            this.fgj = sF;
        }
        if (!this.fgt) {
            this.fgk = sF;
        }
        if (!this.fgu) {
            this.fgl = sF;
        }
        if (!this.fgv) {
            this.fgm = sF;
        }
        return this;
    }

    public b qt(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.fgi = color;
        this.ffY = true;
        if (!this.fgs) {
            this.fgj = color;
        }
        if (!this.fgt) {
            this.fgk = color;
        }
        if (!this.fgu) {
            this.fgl = color;
        }
        if (!this.fgv) {
            this.fgm = color;
        }
        return this;
    }

    public b qu(int i) {
        this.fgi = i;
        this.ffY = true;
        if (!this.fgs) {
            this.fgj = i;
        }
        if (!this.fgt) {
            this.fgk = i;
        }
        if (!this.fgu) {
            this.fgl = i;
        }
        if (!this.fgv) {
            this.fgm = i;
        }
        return this;
    }

    public b qv(@ColorRes int i) {
        this.fgk = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fgt = true;
        this.ffY = true;
        return this;
    }

    public b qw(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fgn = color;
        this.ffZ = true;
        if (!this.fgw) {
            this.fgo = color;
        }
        if (!this.fgx) {
            this.fgp = color;
        }
        if (!this.fgy) {
            this.fgq = color;
        }
        if (!this.fgz) {
            this.fgr = color;
        }
        return this;
    }

    public b qx(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b qy(int i) {
        this.fgh = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.fgb = true;
        this.ffU = new int[2];
        this.ffU[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.ffU[1] = com.baidu.tbadk.core.util.f.c.a.getColor(i2);
        this.ffW = 0;
        this.ffX = "TOP_BOTTOM";
        return this;
    }

    public b m(@ColorRes int... iArr) {
        this.fgb = true;
        this.ffW = 0;
        this.ffX = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.ffU = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ffU[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b n(@ColorRes int... iArr) {
        this.fgb = true;
        this.ffW = 0;
        this.ffX = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.ffU = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ffU[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.fgb = true;
        this.ffW = 0;
        this.ffX = str;
        if (iArr.length > 1) {
            this.ffU = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.ffU[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b ae(float f) {
        this.fgc = true;
        this.fgd = f;
        this.fge = f;
        this.fgf = f;
        this.fgg = f;
        return this;
    }

    public b af(float f) {
        this.fgc = true;
        this.fgd = f;
        return this;
    }

    public b ag(float f) {
        this.fgc = true;
        this.fge = f;
        return this;
    }

    public b ah(float f) {
        this.fgc = true;
        this.fgf = f;
        return this;
    }

    public b ai(float f) {
        this.fgc = true;
        this.fgg = f;
        return this;
    }

    public b qz(int i) {
        this.mType = i;
        return this;
    }

    public b qA(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.ffO = true;
        return this;
    }

    private GradientDrawable.Orientation bwX() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.ffX;
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
        if (this.fgb && this.ffU != null && this.ffU.length > 1) {
            gradientDrawable = new GradientDrawable(bwX(), this.ffU);
            gradientDrawable.setGradientType(this.ffW);
            switch (this.ffW) {
                case 1:
                    gradientDrawable.setGradientRadius(this.ffV);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.ffY) {
            gradientDrawable.setColor(i2);
        }
        if (this.ffZ) {
            gradientDrawable.setStroke(this.fgh, i3);
        } else if (this.fga) {
            gradientDrawable.setStroke(this.ffQ, i4, this.ffS, this.ffT);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.fgc) {
            gradientDrawable.setCornerRadii(new float[]{this.fge, this.fge, this.fgd, this.fgd, this.fgf, this.fgf, this.fgg, this.fgg});
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

    public void bz(View view) {
        if (view != null) {
            bwY();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.ffP);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.ffP);
            }
        }
    }

    public StateListDrawable bwY() {
        this.ffP = bwZ();
        return this.ffP;
    }

    public StateListDrawable bwZ() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable bxa = bxa();
        if (bxa != null) {
            stateListDrawable.addState(new int[]{-16842910}, bxa);
        }
        Drawable bxb = bxb();
        if (bxb != null) {
            stateListDrawable.addState(new int[]{16842919}, bxb);
        }
        Drawable bxc = bxc();
        if (bxc != null) {
            stateListDrawable.addState(new int[]{16842913}, bxc);
        }
        Drawable bxd = bxd();
        if (bxd != null) {
            stateListDrawable.addState(new int[]{16842908}, bxd);
        }
        Drawable bxe = bxe();
        if (bxe == null) {
            bxe = new ColorDrawable(0);
        }
        if (bxe != null) {
            stateListDrawable.addState(new int[0], bxe);
        }
        return stateListDrawable;
    }

    public Drawable bxa() {
        Drawable drawable = this.ffG;
        if (this.ffK) {
            drawable = this.ffG;
        }
        if (this.fgs || this.fgw) {
            return w(this.eYA, this.fgj, this.fgo, this.ffR);
        }
        return drawable;
    }

    public Drawable bxb() {
        Drawable drawable = this.ffJ;
        if (this.ffL) {
            return this.ffJ;
        }
        if (this.fgt || this.fgx) {
            return w(this.eYA, this.fgk, this.fgp, this.ffR);
        }
        return drawable;
    }

    public Drawable bxc() {
        Drawable drawable = this.ffH;
        if (this.ffM) {
            return this.ffH;
        }
        if (this.fgu || this.fgy) {
            return w(this.eYA, this.fgl, this.fgq, this.ffR);
        }
        return drawable;
    }

    public Drawable bxd() {
        Drawable drawable = this.ffI;
        if (this.ffN) {
            return this.ffI;
        }
        if (this.fgv || this.fgz) {
            return w(this.eYA, this.fgm, this.fgr, this.ffR);
        }
        return drawable;
    }

    public Drawable bxe() {
        Drawable drawable = this.evU;
        if (this.evU == null) {
            return w(this.eYA, this.fgi, this.fgn, this.ffR);
        }
        return drawable;
    }
}
