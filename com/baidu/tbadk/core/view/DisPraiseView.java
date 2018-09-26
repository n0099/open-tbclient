package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class DisPraiseView extends PraiseView {
    public DisPraiseView(Context context) {
        super(context);
        Bq();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Bq() {
        this.agreeType = 5;
        this.awr = e.j.action_dislike;
        this.awu = e.d.cp_cont_j;
        this.awv = e.d.cp_link_tip_a;
        this.aws = e.f.icon_card_dislike_n;
        this.awt = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bb) this.mData).xz();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int Bs() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).xA() != 0 && Bt()) {
            ((bb) this.mData).cm(5);
            ((bb) this.mData).ck(0);
            ((bb) this.mData).t(((bb) this.mData).xy());
            ((bb) this.mData).u(((bb) this.mData).xz() - 1);
            i = 1;
        } else {
            int xB = ((bb) this.mData).xB();
            if ((((bb) this.mData).xA() != 0 && xB == 2) || xB == 1) {
                ((bb) this.mData).t(((bb) this.mData).xy() - 1);
            }
            ((bb) this.mData).ck(1);
            ((bb) this.mData).u(((bb) this.mData).xz() + 1);
            ((bb) this.mData).cm(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int L(View view) {
        int L = super.L(view);
        aY(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean Bt() {
        return this.mData != 0 && ((bb) this.mData).xB() == 5;
    }
}
