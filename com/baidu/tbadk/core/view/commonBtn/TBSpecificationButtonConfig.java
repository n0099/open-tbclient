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
    protected int ffJ;
    int ffK;
    int ffL;
    IconType ffN;
    private int ffP;
    boolean ffQ;
    protected a ffX;
    boolean ffV = true;
    int aku = 0;
    GradientDrawable.Orientation ffW = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] ffM = new int[2];
    int ffR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int ffS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int ffT = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int ffU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int ffO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void bvX();

        void bvY();

        void bvZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ah(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bwa() {
        return rb(this.ffM[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bwb() {
        return rb(this.ffM[1]);
    }

    private Drawable rb(int i) {
        Drawable drawable;
        if (this.ffN == IconType.SVG) {
            drawable = SvgManager.btW().c(i, ap.getColor(this.aku, this.ffP > 0 ? this.ffP : this.ffJ), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.ffN == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.aku, this.ffP > 0 ? this.ffP : this.ffJ), (WebPManager.ResourceStateType) null);
        } else {
            drawable = ap.getDrawable(this.aku, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.ffO, this.ffO);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.ffM[0] != i || this.ffM[1] != i2 || this.ffN != iconType) {
            this.ffM[0] = i;
            this.ffM[1] = i2;
            this.ffN = iconType;
            if (this.ffX != null) {
                this.ffX.bvY();
            }
        }
    }

    public void rc(int i) {
        if (i > 0 && this.ffO != i) {
            this.ffO = i;
            if (this.ffX != null) {
                this.ffX.bvX();
            }
        }
    }

    public void rd(@ColorRes int i) {
        if (this.ffP != i) {
            this.ffP = i;
            if (this.ffX != null) {
                this.ffX.bvY();
            }
        }
    }

    public void bb(int i, int i2) {
        if (i > 0) {
            this.minWidth = i;
        }
        if (i2 > 0) {
            this.minHeight = i2;
        }
    }

    public void re(int i) {
        this.ffR = i;
        this.ffS = i;
    }

    public void bc(int i, int i2) {
        this.ffR = i;
        this.ffS = i2;
    }

    public void rf(int i) {
        this.ffT = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.ffW = orientation;
    }

    public void rg(int i) {
        this.ffU = i;
    }
}
