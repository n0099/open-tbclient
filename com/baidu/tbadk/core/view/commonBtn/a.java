package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean cVh;
    int djA;
    int djB;
    private int djE;
    boolean djF;
    protected InterfaceC0380a djL;
    protected int djz;
    boolean djK = true;
    final int[] djC = new int[2];
    int djG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int djH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int djI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int djJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bjo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int djD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0380a {
        void aIm();

        void aIn();

        void aIo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ak(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIp() {
        return lq(this.djC[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIq() {
        return lq(this.djC[1]);
    }

    private Drawable lq(int i) {
        Drawable drawable;
        if (this.cVh) {
            drawable = SvgManager.aGA().a(i, this.djE > 0 ? this.djE : this.djz, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.djD, this.djD);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.djC[0] != i || this.djC[1] != i2 || this.cVh != z) {
            this.djC[0] = i;
            this.djC[1] = i2;
            this.cVh = z;
            if (this.djL != null) {
                this.djL.aIn();
            }
        }
    }

    public void lr(int i) {
        if (i > 0 && this.djD != i) {
            this.djD = i;
            if (this.djL != null) {
                this.djL.aIm();
            }
        }
    }
}
