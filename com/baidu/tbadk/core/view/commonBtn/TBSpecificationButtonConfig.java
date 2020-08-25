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
/* loaded from: classes2.dex */
public abstract class TBSpecificationButtonConfig {
    protected int ewB;
    int ewC;
    int ewD;
    IconType ewF;
    private int ewH;
    boolean ewI;
    protected a ewP;
    boolean ewN = true;
    int aiB = 0;
    GradientDrawable.Orientation ewO = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] ewE = new int[2];
    int ewJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int ewK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int ewL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int ewM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int ewG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes2.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void blj();

        void blk();

        void bll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable aa(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable blm() {
        return oW(this.ewE[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bln() {
        return oW(this.ewE[1]);
    }

    private Drawable oW(int i) {
        Drawable drawable;
        if (this.ewF == IconType.SVG) {
            drawable = SvgManager.bjq().c(i, ap.getColor(this.aiB, this.ewH > 0 ? this.ewH : this.ewB), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.ewF == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.aiB, this.ewH > 0 ? this.ewH : this.ewB), null);
        } else {
            drawable = ap.getDrawable(this.aiB, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.ewG, this.ewG);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.ewE[0] != i || this.ewE[1] != i2 || this.ewF != iconType) {
            this.ewE[0] = i;
            this.ewE[1] = i2;
            this.ewF = iconType;
            if (this.ewP != null) {
                this.ewP.blk();
            }
        }
    }

    public void oX(int i) {
        if (i > 0 && this.ewG != i) {
            this.ewG = i;
            if (this.ewP != null) {
                this.ewP.blj();
            }
        }
    }

    public void oY(@ColorRes int i) {
        if (this.ewH != i) {
            this.ewH = i;
            if (this.ewP != null) {
                this.ewP.blk();
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
        this.ewJ = i;
        this.ewK = i;
    }

    public void ba(int i, int i2) {
        this.ewJ = i;
        this.ewK = i2;
    }

    public void pa(int i) {
        this.ewL = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.ewO = orientation;
    }
}
