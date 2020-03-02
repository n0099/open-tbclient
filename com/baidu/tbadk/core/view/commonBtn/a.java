package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean cVi;
    protected int djA;
    int djB;
    int djC;
    private int djF;
    boolean djG;
    protected InterfaceC0380a djM;
    boolean djL = true;
    final int[] djD = new int[2];
    int djH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int djI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int djJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int djK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bjp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int djE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0380a {
        void aIo();

        void aIp();

        void aIq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ak(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIr() {
        return lq(this.djD[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIs() {
        return lq(this.djD[1]);
    }

    private Drawable lq(int i) {
        Drawable drawable;
        if (this.cVi) {
            drawable = SvgManager.aGC().a(i, this.djF > 0 ? this.djF : this.djA, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.djE, this.djE);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.djD[0] != i || this.djD[1] != i2 || this.cVi != z) {
            this.djD[0] = i;
            this.djD[1] = i2;
            this.cVi = z;
            if (this.djM != null) {
                this.djM.aIp();
            }
        }
    }

    public void lr(int i) {
        if (i > 0 && this.djE != i) {
            this.djE = i;
            if (this.djM != null) {
                this.djM.aIo();
            }
        }
    }
}
