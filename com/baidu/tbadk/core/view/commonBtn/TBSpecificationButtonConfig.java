package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class TBSpecificationButtonConfig {
    WebpType foA;
    protected int foB;
    int foC;
    int foD;
    IconType foF;
    private int foG;
    boolean foH;
    protected a foO;
    boolean foM = true;
    int aln = 0;
    GradientDrawable.Orientation foN = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] foE = new int[2];
    int foI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int foJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int foK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int foL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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
        void buV();

        void buW();

        void buX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ao(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable buY() {
        return pN(this.foE[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable buZ() {
        return pN(this.foE[1]);
    }

    private Drawable pN(int i) {
        Drawable drawable;
        if (this.foF == IconType.SVG) {
            drawable = SvgManager.bsU().c(i, ap.getColor(this.aln, this.foG > 0 ? this.foG : this.foB), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.foF == IconType.WEBP) {
            if (this.foA == WebpType.MASK) {
                drawable = WebPManager.a(i, null);
            } else {
                drawable = WebPManager.a(i, ap.getColor(this.aln, this.foG > 0 ? this.foG : this.foB), (WebPManager.ResourceStateType) null);
            }
        } else {
            drawable = ap.getDrawable(this.aln, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.iconSize, this.iconSize);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.foE[0] != i || this.foE[1] != i2 || this.foF != iconType) {
            this.foE[0] = i;
            this.foE[1] = i2;
            this.foF = iconType;
            if (this.foO != null) {
                this.foO.buW();
            }
        }
    }

    public void a(WebpType webpType) {
        this.foA = webpType;
    }

    public void setIconSize(int i) {
        if (i > 0 && this.iconSize != i) {
            this.iconSize = i;
            if (this.foO != null) {
                this.foO.buV();
            }
        }
    }

    public void pO(@ColorRes int i) {
        if (this.foG != i) {
            this.foG = i;
            if (this.foO != null) {
                this.foO.buW();
            }
        }
    }

    public void aW(int i, int i2) {
        if (i > 0) {
            this.minWidth = i;
        }
        if (i2 > 0) {
            this.minHeight = i2;
        }
    }

    public void pP(int i) {
        this.foI = i;
        this.foJ = i;
    }

    public void aX(int i, int i2) {
        this.foI = i;
        this.foJ = i2;
    }

    public void pQ(int i) {
        this.foK = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.foN = orientation;
    }

    public void pR(int i) {
        this.foL = i;
    }
}
