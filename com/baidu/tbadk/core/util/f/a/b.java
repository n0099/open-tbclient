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
    private int fbA;
    private int fbB;
    private int fbC;
    private int fbD;
    private int fbE;
    private int fbF;
    private int fbG;
    private int fbH;
    private int fbI;
    private StateListDrawable fbg;
    private int[] fbl;
    private float fbm;
    private boolean fbp;
    private boolean fbq;
    private boolean fbr;
    private boolean fbs;
    private boolean fbt;
    private int fbz;
    private int height;
    private int width;
    private int fbh = 1;
    private int fbi = 1;
    private float fbj = 1.0f;
    private float fbk = 1.0f;
    private int fbn = 0;
    private String fbo = "TOP_BOTTOM";
    private float fbu = 0.0f;
    private float fbv = 0.0f;
    private float fbw = 0.0f;
    private float fbx = 0.0f;
    private int eTP = 0;
    private int mCornerRadius = 0;
    private int fby = 0;
    private boolean fbJ = false;
    private boolean fbK = false;
    private boolean fbL = false;
    private boolean fbM = false;
    private boolean fbN = false;
    private boolean fbO = false;
    private boolean fbP = false;
    private boolean fbQ = false;

    public static b btc() {
        return new b();
    }

    public b l(Drawable drawable) {
        this.erg = drawable;
        if (!this.fbb) {
            this.faX = drawable;
        }
        if (!this.fbc) {
            this.fba = drawable;
        }
        if (!this.fbd) {
            this.faY = drawable;
        }
        if (!this.fbe) {
            this.faZ = drawable;
        }
        return this;
    }

    public b m(Drawable drawable) {
        this.fba = drawable;
        this.fbc = true;
        return this;
    }

    public b oH(@DrawableRes int i) {
        return l(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b oI(@DrawableRes int i) {
        return m(com.baidu.tbadk.core.util.f.c.a.getDrawable(i));
    }

    public b oJ(int i) {
        this.eTP = i;
        return this;
    }

    public b oK(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fbz = color;
        this.fbp = true;
        if (!this.fbJ) {
            this.fbA = color;
        }
        if (!this.fbK) {
            this.fbB = color;
        }
        if (!this.fbL) {
            this.fbC = color;
        }
        if (!this.fbM) {
            this.fbD = color;
        }
        return this;
    }

    public b oL(int i) {
        this.fbz = i;
        this.fbp = true;
        if (!this.fbJ) {
            this.fbA = i;
        }
        if (!this.fbK) {
            this.fbB = i;
        }
        if (!this.fbL) {
            this.fbC = i;
        }
        if (!this.fbM) {
            this.fbD = i;
        }
        return this;
    }

    public b aQ(@ColorRes int i, int i2) {
        int color = ao.getColor(i2, i);
        this.fbz = color;
        this.fbp = true;
        if (!this.fbJ) {
            this.fbA = color;
        }
        if (!this.fbK) {
            this.fbB = color;
        }
        if (!this.fbL) {
            this.fbC = color;
        }
        if (!this.fbM) {
            this.fbD = color;
        }
        return this;
    }

    public b Bf(String str) {
        int rt = com.baidu.tbadk.core.util.f.c.a.rt(str);
        this.fbz = rt;
        this.fbp = true;
        if (!this.fbJ) {
            this.fbA = rt;
        }
        if (!this.fbK) {
            this.fbB = rt;
        }
        if (!this.fbL) {
            this.fbC = rt;
        }
        if (!this.fbM) {
            this.fbD = rt;
        }
        return this;
    }

    public b oM(@ColorRes int i) {
        int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
        this.fbz = color;
        this.fbp = true;
        if (!this.fbJ) {
            this.fbA = color;
        }
        if (!this.fbK) {
            this.fbB = color;
        }
        if (!this.fbL) {
            this.fbC = color;
        }
        if (!this.fbM) {
            this.fbD = color;
        }
        return this;
    }

    public b oN(int i) {
        this.fbz = i;
        this.fbp = true;
        if (!this.fbJ) {
            this.fbA = i;
        }
        if (!this.fbK) {
            this.fbB = i;
        }
        if (!this.fbL) {
            this.fbC = i;
        }
        if (!this.fbM) {
            this.fbD = i;
        }
        return this;
    }

    public b oO(@ColorRes int i) {
        this.fbB = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fbK = true;
        this.fbp = true;
        return this;
    }

    public b oP(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fbE = color;
        this.fbq = true;
        if (!this.fbN) {
            this.fbF = color;
        }
        if (!this.fbO) {
            this.fbG = color;
        }
        if (!this.fbP) {
            this.fbH = color;
        }
        if (!this.fbQ) {
            this.fbI = color;
        }
        return this;
    }

    public b oQ(int i) {
        this.mCornerRadius = i;
        return this;
    }

    public b oR(int i) {
        this.fby = i;
        return this;
    }

    public b aR(@ColorRes int i, @ColorRes int i2) {
        this.fbs = true;
        this.fbl = new int[2];
        this.fbl[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.fbl[1] = com.baidu.tbadk.core.util.f.c.a.getColor(i2);
        this.fbn = 0;
        this.fbo = "TOP_BOTTOM";
        return this;
    }

    public b m(@ColorRes int... iArr) {
        this.fbs = true;
        this.fbn = 0;
        this.fbo = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.fbl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.fbl[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b n(@ColorRes int... iArr) {
        this.fbs = true;
        this.fbn = 0;
        this.fbo = "TOP_BOTTOM";
        if (iArr.length > 1) {
            this.fbl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.fbl[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b b(String str, @ColorRes int... iArr) {
        this.fbs = true;
        this.fbn = 0;
        this.fbo = str;
        if (iArr.length > 1) {
            this.fbl = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.fbl[i] = com.baidu.tbadk.core.util.f.c.a.getColor(iArr[i]);
            }
            return this;
        }
        throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
    }

    public b ae(float f) {
        this.fbt = true;
        this.fbu = f;
        this.fbv = f;
        this.fbw = f;
        this.fbx = f;
        return this;
    }

    public b af(float f) {
        this.fbt = true;
        this.fbu = f;
        return this;
    }

    public b ag(float f) {
        this.fbt = true;
        this.fbv = f;
        return this;
    }

    public b ah(float f) {
        this.fbt = true;
        this.fbw = f;
        return this;
    }

    public b ai(float f) {
        this.fbt = true;
        this.fbx = f;
        return this;
    }

    public b oS(int i) {
        this.mType = i;
        return this;
    }

    public b oT(@IntRange(from = 0, to = 255) int i) {
        this.mAlpha = i;
        this.fbf = true;
        return this;
    }

    private GradientDrawable.Orientation btd() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        String str = this.fbo;
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
        if (this.fbs && this.fbl != null && this.fbl.length > 1) {
            gradientDrawable = new GradientDrawable(btd(), this.fbl);
            gradientDrawable.setGradientType(this.fbn);
            switch (this.fbn) {
                case 1:
                    gradientDrawable.setGradientRadius(this.fbm);
                    break;
            }
        } else {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setShape(i);
        if (this.fbp) {
            gradientDrawable.setColor(i2);
        }
        if (this.fbq) {
            gradientDrawable.setStroke(this.fby, i3);
        } else if (this.fbr) {
            gradientDrawable.setStroke(this.fbh, i4, this.fbj, this.fbk);
        }
        if (this.mCornerRadius > 0) {
            gradientDrawable.setCornerRadius(this.mCornerRadius);
        } else if (this.fbt) {
            gradientDrawable.setCornerRadii(new float[]{this.fbv, this.fbv, this.fbu, this.fbu, this.fbw, this.fbw, this.fbx, this.fbx});
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
            bte();
            if (this.mType == 2) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(this.fbg);
                }
            } else if (this.mType == 1) {
                view.setBackgroundDrawable(this.fbg);
            }
        }
    }

    public StateListDrawable bte() {
        this.fbg = btf();
        return this.fbg;
    }

    public StateListDrawable btf() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable btg = btg();
        if (btg != null) {
            stateListDrawable.addState(new int[]{-16842910}, btg);
        }
        Drawable bth = bth();
        if (bth != null) {
            stateListDrawable.addState(new int[]{16842919}, bth);
        }
        Drawable bti = bti();
        if (bti != null) {
            stateListDrawable.addState(new int[]{16842913}, bti);
        }
        Drawable btj = btj();
        if (btj != null) {
            stateListDrawable.addState(new int[]{16842908}, btj);
        }
        Drawable btk = btk();
        if (btk == null) {
            btk = new ColorDrawable(0);
        }
        if (btk != null) {
            stateListDrawable.addState(new int[0], btk);
        }
        return stateListDrawable;
    }

    public Drawable btg() {
        Drawable drawable = this.faX;
        if (this.fbb) {
            drawable = this.faX;
        }
        if (this.fbJ || this.fbN) {
            return w(this.eTP, this.fbA, this.fbF, this.fbi);
        }
        return drawable;
    }

    public Drawable bth() {
        Drawable drawable = this.fba;
        if (this.fbc) {
            return this.fba;
        }
        if (this.fbK || this.fbO) {
            return w(this.eTP, this.fbB, this.fbG, this.fbi);
        }
        return drawable;
    }

    public Drawable bti() {
        Drawable drawable = this.faY;
        if (this.fbd) {
            return this.faY;
        }
        if (this.fbL || this.fbP) {
            return w(this.eTP, this.fbC, this.fbH, this.fbi);
        }
        return drawable;
    }

    public Drawable btj() {
        Drawable drawable = this.faZ;
        if (this.fbe) {
            return this.faZ;
        }
        if (this.fbM || this.fbQ) {
            return w(this.eTP, this.fbD, this.fbI, this.fbi);
        }
        return drawable;
    }

    public Drawable btk() {
        Drawable drawable = this.erg;
        if (this.erg == null) {
            return w(this.eTP, this.fbz, this.fbE, this.fbi);
        }
        return drawable;
    }
}
