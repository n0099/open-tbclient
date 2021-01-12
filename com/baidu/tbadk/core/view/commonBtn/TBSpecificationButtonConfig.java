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
    WebpType fkI;
    protected int fkJ;
    int fkK;
    int fkL;
    IconType fkN;
    private int fkO;
    boolean fkP;
    protected a fkW;
    boolean fkU = true;
    int akf = 0;
    GradientDrawable.Orientation fkV = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] fkM = new int[2];
    int fkQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int fkR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int fkS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int fkT = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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
        void buA();

        void buy();

        void buz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable aj(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable buB() {
        return pH(this.fkM[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable buC() {
        return pH(this.fkM[1]);
    }

    private Drawable pH(int i) {
        Drawable drawable;
        if (this.fkN == IconType.SVG) {
            drawable = SvgManager.bsx().c(i, ao.getColor(this.akf, this.fkO > 0 ? this.fkO : this.fkJ), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.fkN == IconType.WEBP) {
            if (this.fkI == WebpType.MASK) {
                drawable = WebPManager.a(i, null);
            } else {
                drawable = WebPManager.a(i, ao.getColor(this.akf, this.fkO > 0 ? this.fkO : this.fkJ), (WebPManager.ResourceStateType) null);
            }
        } else {
            drawable = ao.getDrawable(this.akf, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.iconSize, this.iconSize);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.fkM[0] != i || this.fkM[1] != i2 || this.fkN != iconType) {
            this.fkM[0] = i;
            this.fkM[1] = i2;
            this.fkN = iconType;
            if (this.fkW != null) {
                this.fkW.buz();
            }
        }
    }

    public void a(WebpType webpType) {
        this.fkI = webpType;
    }

    public void setIconSize(int i) {
        if (i > 0 && this.iconSize != i) {
            this.iconSize = i;
            if (this.fkW != null) {
                this.fkW.buy();
            }
        }
    }

    public void pI(@ColorRes int i) {
        if (this.fkO != i) {
            this.fkO = i;
            if (this.fkW != null) {
                this.fkW.buz();
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

    public void pJ(int i) {
        this.fkQ = i;
        this.fkR = i;
    }

    public void ba(int i, int i2) {
        this.fkQ = i;
        this.fkR = i2;
    }

    public void pK(int i) {
        this.fkS = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.fkV = orientation;
    }

    public void pL(int i) {
        this.fkT = i;
    }
}
