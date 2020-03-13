package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean cVj;
    protected int djN;
    int djO;
    int djP;
    private int djS;
    boolean djT;
    protected InterfaceC0380a djZ;
    boolean djY = true;
    final int[] djQ = new int[2];
    int djU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int djV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int djW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int djX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bjq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int djR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0380a {
        void aIp();

        void aIq();

        void aIr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ak(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIs() {
        return lq(this.djQ[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIt() {
        return lq(this.djQ[1]);
    }

    private Drawable lq(int i) {
        Drawable drawable;
        if (this.cVj) {
            drawable = SvgManager.aGC().a(i, this.djS > 0 ? this.djS : this.djN, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.djR, this.djR);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.djQ[0] != i || this.djQ[1] != i2 || this.cVj != z) {
            this.djQ[0] = i;
            this.djQ[1] = i2;
            this.cVj = z;
            if (this.djZ != null) {
                this.djZ.aIq();
            }
        }
    }

    public void lr(int i) {
        if (i > 0 && this.djR != i) {
            this.djR = i;
            if (this.djZ != null) {
                this.djZ.aIp();
            }
        }
    }
}
