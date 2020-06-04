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
    boolean dIG;
    protected InterfaceC0478a dYA;
    protected int dYn;
    int dYo;
    int dYp;
    private int dYs;
    boolean dYt;
    boolean dYy = true;
    GradientDrawable.Orientation dYz = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] dYq = new int[2];
    int dYu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int dYv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int dYw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds4);
    int dYx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int bQI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int dYr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.core.view.commonBtn.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0478a {
        void aWV();

        void aWW();

        void aWX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable T(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aWY() {
        return mg(this.dYq[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable aWZ() {
        return mg(this.dYq[1]);
    }

    private Drawable mg(int i) {
        Drawable drawable;
        if (this.dIG) {
            drawable = SvgManager.aUW().a(i, this.dYs > 0 ? this.dYs : this.dYn, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            drawable = am.getDrawable(i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.dYr, this.dYr);
        }
        return drawable;
    }

    public void k(int i, int i2, boolean z) {
        if (this.dYq[0] != i || this.dYq[1] != i2 || this.dIG != z) {
            this.dYq[0] = i;
            this.dYq[1] = i2;
            this.dIG = z;
            if (this.dYA != null) {
                this.dYA.aWW();
            }
        }
    }

    public void mh(int i) {
        if (i > 0 && this.dYr != i) {
            this.dYr = i;
            if (this.dYA != null) {
                this.dYA.aWV();
            }
        }
    }

    public void aN(int i, int i2) {
        if (i > 0) {
            this.dYx = i;
        }
        if (i2 > 0) {
            this.bQI = i2;
        }
    }

    public void mi(int i) {
        this.dYu = i;
    }

    public void mj(int i) {
        this.dYv = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.dYz = orientation;
    }
}
