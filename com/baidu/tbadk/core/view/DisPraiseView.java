package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class DisPraiseView extends PraiseView {
    public DisPraiseView(Context context) {
        super(context);
        Dw();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Dw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Dw() {
        this.agreeType = 5;
        this.aBc = e.j.action_dislike;
        this.aBf = e.d.cp_cont_j;
        this.aBg = e.d.cp_link_tip_a;
        this.aBd = e.f.icon_card_dislike_n;
        this.aBe = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bb) this.mData).zI();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int Dy() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).zJ() != 0 && Dz()) {
            ((bb) this.mData).cw(5);
            ((bb) this.mData).cu(0);
            ((bb) this.mData).v(((bb) this.mData).zH());
            ((bb) this.mData).w(((bb) this.mData).zI() - 1);
            i = 1;
        } else {
            int zK = ((bb) this.mData).zK();
            if ((((bb) this.mData).zJ() != 0 && zK == 2) || zK == 1) {
                ((bb) this.mData).v(((bb) this.mData).zH() - 1);
            }
            ((bb) this.mData).cu(1);
            ((bb) this.mData).w(((bb) this.mData).zI() + 1);
            ((bb) this.mData).cw(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int L(View view) {
        int L = super.L(view);
        bi(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean Dz() {
        return this.mData != 0 && ((bb) this.mData).zK() == 5;
    }
}
