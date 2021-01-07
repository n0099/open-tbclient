package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class TBSpecificationButtonConfig {
    protected a fpG;
    WebpType fpr;
    protected int fpt;
    int fpu;
    int fpv;
    IconType fpx;
    private int fpy;
    boolean fpz;
    boolean fpE = true;
    int akW = 0;
    GradientDrawable.Orientation fpF = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] fpw = new int[2];
    int fpA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int fpB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int fpC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int fpD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int iconSize = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* loaded from: classes.dex */
    public enum WebpType {
        MASK,
        PURE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void bys();

        void byt();

        void byu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable aj(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable byv() {
        return rn(this.fpw[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable byw() {
        return rn(this.fpw[1]);
    }

    private Drawable rn(int i) {
        Drawable drawable;
        if (this.fpx == IconType.SVG) {
            drawable = SvgManager.bwr().c(i, ao.getColor(this.akW, this.fpy > 0 ? this.fpy : this.fpt), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.fpx == IconType.WEBP) {
            if (this.fpr == WebpType.MASK) {
                drawable = WebPManager.a(i, null);
            } else {
                drawable = WebPManager.a(i, ao.getColor(this.akW, this.fpy > 0 ? this.fpy : this.fpt), (WebPManager.ResourceStateType) null);
            }
        } else {
            drawable = ao.getDrawable(this.akW, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.iconSize, this.iconSize);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.fpw[0] != i || this.fpw[1] != i2 || this.fpx != iconType) {
            this.fpw[0] = i;
            this.fpw[1] = i2;
            this.fpx = iconType;
            if (this.fpG != null) {
                this.fpG.byt();
            }
        }
    }

    public void a(WebpType webpType) {
        this.fpr = webpType;
    }

    public void setIconSize(int i) {
        if (i > 0 && this.iconSize != i) {
            this.iconSize = i;
            if (this.fpG != null) {
                this.fpG.bys();
            }
        }
    }

    public void ro(@ColorRes int i) {
        if (this.fpy != i) {
            this.fpy = i;
            if (this.fpG != null) {
                this.fpG.byt();
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

    public void rp(int i) {
        this.fpA = i;
        this.fpB = i;
    }

    public void ba(int i, int i2) {
        this.fpA = i;
        this.fpB = i2;
    }

    public void rq(int i) {
        this.fpC = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.fpF = orientation;
    }

    public void rr(int i) {
        this.fpD = i;
    }
}
