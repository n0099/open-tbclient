package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class TBSpecificationButtonConfig {
    protected int eKT;
    int eKU;
    int eKV;
    IconType eKX;
    private int eKZ;
    boolean eLa;
    protected a eLh;
    boolean eLf = true;
    int ajp = 0;
    GradientDrawable.Orientation eLg = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] eKW = new int[2];
    int eLb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eLc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eLd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int eLe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int eKY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void boO();

        void boP();

        void boQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ac(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable boR() {
        return pH(this.eKW[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable boS() {
        return pH(this.eKW[1]);
    }

    private Drawable pH(int i) {
        Drawable drawable;
        if (this.eKX == IconType.SVG) {
            drawable = SvgManager.bmU().c(i, ap.getColor(this.ajp, this.eKZ > 0 ? this.eKZ : this.eKT), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.eKX == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.ajp, this.eKZ > 0 ? this.eKZ : this.eKT), null);
        } else {
            drawable = ap.getDrawable(this.ajp, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eKY, this.eKY);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.eKW[0] != i || this.eKW[1] != i2 || this.eKX != iconType) {
            this.eKW[0] = i;
            this.eKW[1] = i2;
            this.eKX = iconType;
            if (this.eLh != null) {
                this.eLh.boP();
            }
        }
    }

    public void pI(int i) {
        if (i > 0 && this.eKY != i) {
            this.eKY = i;
            if (this.eLh != null) {
                this.eLh.boO();
            }
        }
    }

    public void pJ(@ColorRes int i) {
        if (this.eKZ != i) {
            this.eKZ = i;
            if (this.eLh != null) {
                this.eLh.boP();
            }
        }
    }

    public void aY(int i, int i2) {
        if (i > 0) {
            this.minWidth = i;
        }
        if (i2 > 0) {
            this.minHeight = i2;
        }
    }

    public void pK(int i) {
        this.eLb = i;
        this.eLc = i;
    }

    public void aZ(int i, int i2) {
        this.eLb = i;
        this.eLc = i2;
    }

    public void pL(int i) {
        this.eLd = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.eLg = orientation;
    }

    public void pM(int i) {
        this.eLe = i;
    }
}
