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
    protected int dJT;
    int dJU;
    int dJV;
    private int dJY;
    boolean dJZ;
    protected InterfaceC0411a dKg;
    boolean duH;
    boolean dKe = true;
    GradientDrawable.Orientation dKf = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] dJW = new int[2];
    int dKa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int dKb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int dKc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int dKd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bHL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int dJX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0411a {
        void aQP();

        void aQQ();

        void aQR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable U(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aQS() {
        return lC(this.dJW[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aQT() {
        return lC(this.dJW[1]);
    }

    private Drawable lC(int i) {
        Drawable drawable;
        if (this.duH) {
            drawable = SvgManager.aOU().a(i, this.dJY > 0 ? this.dJY : this.dJT, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.dJX, this.dJX);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.dJW[0] != i || this.dJW[1] != i2 || this.duH != z) {
            this.dJW[0] = i;
            this.dJW[1] = i2;
            this.duH = z;
            if (this.dKg != null) {
                this.dKg.aQQ();
            }
        }
    }

    public void lD(int i) {
        if (i > 0 && this.dJX != i) {
            this.dJX = i;
            if (this.dKg != null) {
                this.dKg.aQP();
            }
        }
    }

    public void aK(int i, int i2) {
        if (i > 0) {
            this.dKd = i;
        }
        if (i2 > 0) {
            this.bHL = i2;
        }
    }

    public void lE(int i) {
        this.dKa = i;
    }

    public void lF(int i) {
        this.dKb = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.dKf = orientation;
    }
}
