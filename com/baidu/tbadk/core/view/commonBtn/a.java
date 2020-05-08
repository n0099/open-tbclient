package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected int dJX;
    int dJY;
    int dJZ;
    private int dKc;
    boolean dKd;
    protected InterfaceC0432a dKk;
    boolean duL;
    boolean dKi = true;
    GradientDrawable.Orientation dKj = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] dKa = new int[2];
    int dKe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int dKf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int dKg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int dKh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bHQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int dKb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0432a {
        void aQM();

        void aQN();

        void aQO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable U(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aQP() {
        return lC(this.dKa[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aQQ() {
        return lC(this.dKa[1]);
    }

    private Drawable lC(int i) {
        Drawable drawable;
        if (this.duL) {
            drawable = SvgManager.aOR().a(i, this.dKc > 0 ? this.dKc : this.dJX, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.dKb, this.dKb);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.dKa[0] != i || this.dKa[1] != i2 || this.duL != z) {
            this.dKa[0] = i;
            this.dKa[1] = i2;
            this.duL = z;
            if (this.dKk != null) {
                this.dKk.aQN();
            }
        }
    }

    public void lD(int i) {
        if (i > 0 && this.dKb != i) {
            this.dKb = i;
            if (this.dKk != null) {
                this.dKk.aQM();
            }
        }
    }

    public void aK(int i, int i2) {
        if (i > 0) {
            this.dKh = i;
        }
        if (i2 > 0) {
            this.bHQ = i2;
        }
    }

    public void lE(int i) {
        this.dKe = i;
    }

    public void lF(int i) {
        this.dKf = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.dKj = orientation;
    }
}
