package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean dVO;
    int emA;
    private int emD;
    boolean emE;
    protected InterfaceC0497a emL;
    protected int emy;
    int emz;
    boolean emJ = true;
    GradientDrawable.Orientation emK = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] emB = new int[2];
    int emF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int emG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int emH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int emI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int emC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0497a {
        void bcM();

        void bcN();

        void bcO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable V(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bcP() {
        return mQ(this.emB[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable bcQ() {
        return mQ(this.emB[1]);
    }

    private Drawable mQ(int i) {
        Drawable drawable;
        if (this.dVO) {
            drawable = SvgManager.baR().a(i, this.emD > 0 ? this.emD : this.emy, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = ao.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.emC, this.emC);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.emB[0] != i || this.emB[1] != i2 || this.dVO != z) {
            this.emB[0] = i;
            this.emB[1] = i2;
            this.dVO = z;
            if (this.emL != null) {
                this.emL.bcN();
            }
        }
    }

    public void mR(int i) {
        if (i > 0 && this.emC != i) {
            this.emC = i;
            if (this.emL != null) {
                this.emL.bcM();
            }
        }
    }

    public void mS(@ColorRes int i) {
        if (this.emD != i) {
            this.emD = i;
            if (this.emL != null) {
                this.emL.bcN();
            }
        }
    }

    public void aR(int i, int i2) {
        if (i > 0) {
            this.minWidth = i;
        }
        if (i2 > 0) {
            this.minHeight = i2;
        }
    }

    public void mT(int i) {
        this.emF = i;
        this.emG = i;
    }

    public void aS(int i, int i2) {
        this.emF = i;
        this.emG = i2;
    }

    public void mU(int i) {
        this.emH = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.emK = orientation;
    }
}
