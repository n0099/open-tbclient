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
    protected int eyM;
    int eyN;
    int eyO;
    IconType eyQ;
    private int eyS;
    boolean eyT;
    protected a eza;
    boolean eyY = true;
    int aiX = 0;
    GradientDrawable.Orientation eyZ = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] eyP = new int[2];
    int eyU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eyV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eyW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int eyX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int eyR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void bme();

        void bmf();

        void bmg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable aa(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bmh() {
        return pi(this.eyP[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bmi() {
        return pi(this.eyP[1]);
    }

    private Drawable pi(int i) {
        Drawable drawable;
        if (this.eyQ == IconType.SVG) {
            drawable = SvgManager.bkl().c(i, ap.getColor(this.aiX, this.eyS > 0 ? this.eyS : this.eyM), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.eyQ == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.aiX, this.eyS > 0 ? this.eyS : this.eyM), null);
        } else {
            drawable = ap.getDrawable(this.aiX, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eyR, this.eyR);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.eyP[0] != i || this.eyP[1] != i2 || this.eyQ != iconType) {
            this.eyP[0] = i;
            this.eyP[1] = i2;
            this.eyQ = iconType;
            if (this.eza != null) {
                this.eza.bmf();
            }
        }
    }

    public void pj(int i) {
        if (i > 0 && this.eyR != i) {
            this.eyR = i;
            if (this.eza != null) {
                this.eza.bme();
            }
        }
    }

    public void pk(@ColorRes int i) {
        if (this.eyS != i) {
            this.eyS = i;
            if (this.eza != null) {
                this.eza.bmf();
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

    public void pl(int i) {
        this.eyU = i;
        this.eyV = i;
    }

    public void ba(int i, int i2) {
        this.eyU = i;
        this.eyV = i2;
    }

    public void pm(int i) {
        this.eyW = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.eyZ = orientation;
    }

    public void po(int i) {
        this.eyX = i;
    }
}
