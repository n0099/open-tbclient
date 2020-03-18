package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    boolean cVw;
    protected int dka;
    int dkb;
    int dkc;
    private int dkf;
    boolean dkg;
    protected InterfaceC0380a dkm;
    boolean dkl = true;
    final int[] dkd = new int[2];
    int dkh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int dki = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int dkj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int dkk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bjD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int dke = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0380a {
        void aIt();

        void aIu();

        void aIv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ak(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIw() {
        return lq(this.dkd[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aIx() {
        return lq(this.dkd[1]);
    }

    private Drawable lq(int i) {
        Drawable drawable;
        if (this.cVw) {
            drawable = SvgManager.aGG().a(i, this.dkf > 0 ? this.dkf : this.dka, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.dke, this.dke);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.dkd[0] != i || this.dkd[1] != i2 || this.cVw != z) {
            this.dkd[0] = i;
            this.dkd[1] = i2;
            this.cVw = z;
            if (this.dkm != null) {
                this.dkm.aIu();
            }
        }
    }

    public void lr(int i) {
        if (i > 0 && this.dke != i) {
            this.dke = i;
            if (this.dkm != null) {
                this.dkm.aIt();
            }
        }
    }

    public void aG(int i, int i2) {
        if (i > 0) {
            this.dkk = i;
        }
        if (i2 > 0) {
            this.bjD = i2;
        }
    }

    public void ls(int i) {
        this.dkh = i;
    }

    public void lt(int i) {
        this.dki = i;
    }
}
