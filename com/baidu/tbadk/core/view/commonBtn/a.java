package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean cQV;
    protected int dfh;
    int dfi;
    int dfj;
    private int dfm;
    boolean dfn;
    protected InterfaceC0368a dft;
    boolean dfs = true;
    final int[] dfk = new int[2];
    int dfo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int dfp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int dfq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int dfr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bek = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int dfl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0368a {
        void aFE();

        void aFF();

        void aFG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable am(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aFH() {
        return kZ(this.dfk[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aFI() {
        return kZ(this.dfk[1]);
    }

    private Drawable kZ(int i) {
        Drawable drawable;
        if (this.cQV) {
            drawable = SvgManager.aDW().a(i, this.dfm > 0 ? this.dfm : this.dfh, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.dfl, this.dfl);
        }
        return drawable;
    }

    public void j(int i, int i2, boolean z) {
        if (this.dfk[0] != i || this.dfk[1] != i2 || this.cQV != z) {
            this.dfk[0] = i;
            this.dfk[1] = i2;
            this.cQV = z;
            if (this.dft != null) {
                this.dft.aFF();
            }
        }
    }

    public void la(int i) {
        if (i > 0 && this.dfl != i) {
            this.dfl = i;
            if (this.dft != null) {
                this.dft.aFE();
            }
        }
    }
}
