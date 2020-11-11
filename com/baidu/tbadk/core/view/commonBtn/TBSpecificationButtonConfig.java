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
    protected int eZe;
    int eZf;
    int eZg;
    IconType eZi;
    private int eZk;
    boolean eZl;
    protected a eZs;
    boolean eZq = true;
    int ajq = 0;
    GradientDrawable.Orientation eZr = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] eZh = new int[2];
    int eZm = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eZn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eZo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int eZp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int eZj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void bth();

        void bti();

        void btj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ag(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable btk() {
        return qc(this.eZh[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable btl() {
        return qc(this.eZh[1]);
    }

    private Drawable qc(int i) {
        Drawable drawable;
        if (this.eZi == IconType.SVG) {
            drawable = SvgManager.brn().c(i, ap.getColor(this.ajq, this.eZk > 0 ? this.eZk : this.eZe), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.eZi == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.ajq, this.eZk > 0 ? this.eZk : this.eZe), null);
        } else {
            drawable = ap.getDrawable(this.ajq, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eZj, this.eZj);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.eZh[0] != i || this.eZh[1] != i2 || this.eZi != iconType) {
            this.eZh[0] = i;
            this.eZh[1] = i2;
            this.eZi = iconType;
            if (this.eZs != null) {
                this.eZs.bti();
            }
        }
    }

    public void qd(int i) {
        if (i > 0 && this.eZj != i) {
            this.eZj = i;
            if (this.eZs != null) {
                this.eZs.bth();
            }
        }
    }

    public void qe(@ColorRes int i) {
        if (this.eZk != i) {
            this.eZk = i;
            if (this.eZs != null) {
                this.eZs.bti();
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

    public void qf(int i) {
        this.eZm = i;
        this.eZn = i;
    }

    public void ba(int i, int i2) {
        this.eZm = i;
        this.eZn = i2;
    }

    public void qg(int i) {
        this.eZo = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.eZr = orientation;
    }

    public void qh(int i) {
        this.eZp = i;
    }
}
