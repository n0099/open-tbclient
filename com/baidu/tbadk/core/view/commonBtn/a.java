package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean cRf;
    protected InterfaceC0370a dfF;
    protected int dft;
    int dfu;
    int dfv;
    private int dfy;
    boolean dfz;
    boolean dfE = true;
    final int[] dfw = new int[2];
    int dfA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int dfB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int dfC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int dfD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int beZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int dfx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0370a {
        void aFX();

        void aFY();

        void aFZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable al(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aGa() {
        return kZ(this.dfw[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aGb() {
        return kZ(this.dfw[1]);
    }

    private Drawable kZ(int i) {
        Drawable drawable;
        if (this.cRf) {
            drawable = SvgManager.aEp().a(i, this.dfy > 0 ? this.dfy : this.dft, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.dfx, this.dfx);
        }
        return drawable;
    }

    public void j(int i, int i2, boolean z) {
        if (this.dfw[0] != i || this.dfw[1] != i2 || this.cRf != z) {
            this.dfw[0] = i;
            this.dfw[1] = i2;
            this.cRf = z;
            if (this.dfF != null) {
                this.dfF.aFY();
            }
        }
    }

    public void la(int i) {
        if (i > 0 && this.dfx != i) {
            this.dfx = i;
            if (this.dfF != null) {
                this.dfF.aFX();
            }
        }
    }
}
