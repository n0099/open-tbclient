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
        EH();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void EH() {
        this.agreeType = 5;
        this.aFs = e.j.action_dislike;
        this.aFv = e.d.cp_cont_j;
        this.aFw = e.d.cp_link_tip_a;
        this.aFt = e.f.icon_card_dislike_n;
        this.aFu = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bb) this.mData).AT();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int EJ() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).AU() != 0 && EK()) {
            ((bb) this.mData).cY(5);
            ((bb) this.mData).cW(0);
            ((bb) this.mData).C(((bb) this.mData).AS());
            ((bb) this.mData).D(((bb) this.mData).AT() - 1);
            i = 1;
        } else {
            int AV = ((bb) this.mData).AV();
            if ((((bb) this.mData).AU() != 0 && AV == 2) || AV == 1) {
                ((bb) this.mData).C(((bb) this.mData).AS() - 1);
            }
            ((bb) this.mData).cW(1);
            ((bb) this.mData).D(((bb) this.mData).AT() + 1);
            ((bb) this.mData).cY(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int L(View view) {
        int L = super.L(view);
        bz(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean EK() {
        return this.mData != 0 && ((bb) this.mData).AV() == 5;
    }
}
