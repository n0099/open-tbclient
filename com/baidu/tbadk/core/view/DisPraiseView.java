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
        EU();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void EU() {
        this.agreeType = 5;
        this.aFV = e.j.action_dislike;
        this.aFY = e.d.cp_cont_j;
        this.aFZ = e.d.cp_link_tip_a;
        this.aFW = e.f.icon_card_dislike_n;
        this.aFX = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bb) this.mData).Bg();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int EW() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).Bh() != 0 && EX()) {
            ((bb) this.mData).cY(5);
            ((bb) this.mData).cW(0);
            ((bb) this.mData).C(((bb) this.mData).Bf());
            ((bb) this.mData).D(((bb) this.mData).Bg() - 1);
            i = 1;
        } else {
            int Bi = ((bb) this.mData).Bi();
            if ((((bb) this.mData).Bh() != 0 && Bi == 2) || Bi == 1) {
                ((bb) this.mData).C(((bb) this.mData).Bf() - 1);
            }
            ((bb) this.mData).cW(1);
            ((bb) this.mData).D(((bb) this.mData).Bg() + 1);
            ((bb) this.mData).cY(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int L(View view) {
        int L = super.L(view);
        bA(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean EX() {
        return this.mData != 0 && ((bb) this.mData).Bi() == 5;
    }
}
