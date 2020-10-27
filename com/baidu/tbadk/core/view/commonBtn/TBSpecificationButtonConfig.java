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
    protected a eTD;
    protected int eTp;
    int eTq;
    int eTr;
    IconType eTt;
    private int eTv;
    boolean eTw;
    boolean eTB = true;
    int ajq = 0;
    GradientDrawable.Orientation eTC = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] eTs = new int[2];
    int eTx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eTy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int eTz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int eTA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int eTu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void bqH();

        void bqI();

        void bqJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ae(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bqK() {
        return pS(this.eTs[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bqL() {
        return pS(this.eTs[1]);
    }

    private Drawable pS(int i) {
        Drawable drawable;
        if (this.eTt == IconType.SVG) {
            drawable = SvgManager.boN().c(i, ap.getColor(this.ajq, this.eTv > 0 ? this.eTv : this.eTp), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.eTt == IconType.WEBP) {
            drawable = WebPManager.a(i, ap.getColor(this.ajq, this.eTv > 0 ? this.eTv : this.eTp), null);
        } else {
            drawable = ap.getDrawable(this.ajq, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eTu, this.eTu);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.eTs[0] != i || this.eTs[1] != i2 || this.eTt != iconType) {
            this.eTs[0] = i;
            this.eTs[1] = i2;
            this.eTt = iconType;
            if (this.eTD != null) {
                this.eTD.bqI();
            }
        }
    }

    public void pT(int i) {
        if (i > 0 && this.eTu != i) {
            this.eTu = i;
            if (this.eTD != null) {
                this.eTD.bqH();
            }
        }
    }

    public void pU(@ColorRes int i) {
        if (this.eTv != i) {
            this.eTv = i;
            if (this.eTD != null) {
                this.eTD.bqI();
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

    public void pV(int i) {
        this.eTx = i;
        this.eTy = i;
    }

    public void ba(int i, int i2) {
        this.eTx = i;
        this.eTy = i2;
    }

    public void pW(int i) {
        this.eTz = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.eTC = orientation;
    }

    public void pX(int i) {
        this.eTA = i;
    }
}
