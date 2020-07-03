package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean dPw;
    protected InterfaceC0484a egC;
    protected int ego;
    int egp;
    int egq;
    private int egt;
    boolean egu;
    boolean egA = true;
    GradientDrawable.Orientation egB = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] egr = new int[2];
    int egv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int egw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int egx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int egy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int egz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bVw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int egs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0484a {
        void aYP();

        void aYQ();

        void aYR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable V(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aYS() {
        return mx(this.egr[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aYT() {
        return mx(this.egr[1]);
    }

    private Drawable mx(int i) {
        Drawable drawable;
        if (this.dPw) {
            drawable = SvgManager.aWQ().a(i, this.egt > 0 ? this.egt : this.ego, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = an.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.egs, this.egs);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.egr[0] != i || this.egr[1] != i2 || this.dPw != z) {
            this.egr[0] = i;
            this.egr[1] = i2;
            this.dPw = z;
            if (this.egC != null) {
                this.egC.aYQ();
            }
        }
    }

    public void my(int i) {
        if (i > 0 && this.egs != i) {
            this.egs = i;
            if (this.egC != null) {
                this.egC.aYP();
            }
        }
    }

    public void mz(@ColorRes int i) {
        if (this.egt != i) {
            this.egt = i;
            if (this.egC != null) {
                this.egC.aYQ();
            }
        }
    }

    public void aQ(int i, int i2) {
        if (i > 0) {
            this.egz = i;
        }
        if (i2 > 0) {
            this.bVw = i2;
        }
    }

    public void mA(int i) {
        this.egv = i;
        this.egw = i;
    }

    public void aR(int i, int i2) {
        this.egv = i;
        this.egw = i2;
    }

    public void mB(int i) {
        this.egx = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.egB = orientation;
    }
}
