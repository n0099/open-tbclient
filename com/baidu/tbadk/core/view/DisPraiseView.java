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
        DD();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void DD() {
        this.agreeType = 5;
        this.aBR = e.j.action_dislike;
        this.aBU = e.d.cp_cont_j;
        this.aBV = e.d.cp_link_tip_a;
        this.aBS = e.f.icon_card_dislike_n;
        this.aBT = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bb) this.mData).zP();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int DF() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).zQ() != 0 && DG()) {
            ((bb) this.mData).cK(5);
            ((bb) this.mData).cI(0);
            ((bb) this.mData).x(((bb) this.mData).zO());
            ((bb) this.mData).y(((bb) this.mData).zP() - 1);
            i = 1;
        } else {
            int zR = ((bb) this.mData).zR();
            if ((((bb) this.mData).zQ() != 0 && zR == 2) || zR == 1) {
                ((bb) this.mData).x(((bb) this.mData).zO() - 1);
            }
            ((bb) this.mData).cI(1);
            ((bb) this.mData).y(((bb) this.mData).zP() + 1);
            ((bb) this.mData).cK(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int L(View view) {
        int L = super.L(view);
        by(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean DG() {
        return this.mData != 0 && ((bb) this.mData).zR() == 5;
    }
}
