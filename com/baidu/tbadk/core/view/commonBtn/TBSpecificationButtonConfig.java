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
    protected a eYA;
    protected int eYm;
    int eYn;
    int eYo;
    IconType eYq;
    private int eYs;
    boolean eYt;
    boolean eYy = true;
    int ajv = 0;
    GradientDrawable.Orientation eYz = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] eYp = new int[2];
    int eYu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eYv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eYw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int eYx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int eYr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void bsx();

        void bsy();

        void bsz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ah(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bsA() {
        return qA(this.eYp[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bsB() {
        return qA(this.eYp[1]);
    }

    private Drawable qA(int i) {
        Drawable drawable;
        if (this.eYq == IconType.SVG) {
            drawable = SvgManager.bqB().c(i, ap.getColor(this.ajv, this.eYs > 0 ? this.eYs : this.eYm), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.eYq == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.ajv, this.eYs > 0 ? this.eYs : this.eYm), (WebPManager.ResourceStateType) null);
        } else {
            drawable = ap.getDrawable(this.ajv, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eYr, this.eYr);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.eYp[0] != i || this.eYp[1] != i2 || this.eYq != iconType) {
            this.eYp[0] = i;
            this.eYp[1] = i2;
            this.eYq = iconType;
            if (this.eYA != null) {
                this.eYA.bsy();
            }
        }
    }

    public void qB(int i) {
        if (i > 0 && this.eYr != i) {
            this.eYr = i;
            if (this.eYA != null) {
                this.eYA.bsx();
            }
        }
    }

    public void qC(@ColorRes int i) {
        if (this.eYs != i) {
            this.eYs = i;
            if (this.eYA != null) {
                this.eYA.bsy();
            }
        }
    }

    public void aZ(int i, int i2) {
        if (i > 0) {
            this.minWidth = i;
        }
        if (i2 > 0) {
            this.minHeight = i2;
        }
    }

    public void qD(int i) {
        this.eYu = i;
        this.eYv = i;
    }

    public void ba(int i, int i2) {
        this.eYu = i;
        this.eYv = i2;
    }

    public void qE(int i) {
        this.eYw = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.eYz = orientation;
    }

    public void qF(int i) {
        this.eYx = i;
    }
}
