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
    protected int ewF;
    int ewG;
    int ewH;
    IconType ewJ;
    private int ewL;
    boolean ewM;
    protected a ewT;
    boolean ewR = true;
    int aiD = 0;
    GradientDrawable.Orientation ewS = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] ewI = new int[2];
    int ewN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int ewO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int ewP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int ewQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int ewK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void blj();

        void blk();

        void bll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable aa(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable blm() {
        return oW(this.ewI[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bln() {
        return oW(this.ewI[1]);
    }

    private Drawable oW(int i) {
        Drawable drawable;
        if (this.ewJ == IconType.SVG) {
            drawable = SvgManager.bjq().c(i, ap.getColor(this.aiD, this.ewL > 0 ? this.ewL : this.ewF), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.ewJ == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.aiD, this.ewL > 0 ? this.ewL : this.ewF), null);
        } else {
            drawable = ap.getDrawable(this.aiD, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.ewK, this.ewK);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.ewI[0] != i || this.ewI[1] != i2 || this.ewJ != iconType) {
            this.ewI[0] = i;
            this.ewI[1] = i2;
            this.ewJ = iconType;
            if (this.ewT != null) {
                this.ewT.blk();
            }
        }
    }

    public void oX(int i) {
        if (i > 0 && this.ewK != i) {
            this.ewK = i;
            if (this.ewT != null) {
                this.ewT.blj();
            }
        }
    }

    public void oY(@ColorRes int i) {
        if (this.ewL != i) {
            this.ewL = i;
            if (this.ewT != null) {
                this.ewT.blk();
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

    public void oZ(int i) {
        this.ewN = i;
        this.ewO = i;
    }

    public void ba(int i, int i2) {
        this.ewN = i;
        this.ewO = i2;
    }

    public void pa(int i) {
        this.ewP = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.ewS = orientation;
    }
}
