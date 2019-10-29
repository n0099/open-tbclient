package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class DisPraiseView extends PraiseView {
    public DisPraiseView(Context context) {
        super(context);
        anw();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        anw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void anw() {
        this.agreeType = 5;
        this.textResId = R.string.action_dislike;
        this.cnd = R.color.cp_cont_j;
        this.cne = R.color.cp_link_tip_a;
        this.drawableResId = R.drawable.icon_card_dislike_n;
        this.cnc = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bh) this.mData).ajZ();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int any() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).aka() != 0 && anz()) {
            ((bh) this.mData).hR(5);
            ((bh) this.mData).hP(0);
            ((bh) this.mData).aL(((bh) this.mData).ajY());
            ((bh) this.mData).aM(((bh) this.mData).ajZ() - 1);
            i = 1;
        } else {
            int akb = ((bh) this.mData).akb();
            if ((((bh) this.mData).aka() != 0 && akb == 2) || akb == 1) {
                ((bh) this.mData).aL(((bh) this.mData).ajY() - 1);
            }
            ((bh) this.mData).hP(1);
            ((bh) this.mData).aM(((bh) this.mData).ajZ() + 1);
            ((bh) this.mData).hR(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aO(View view) {
        int aO = super.aO(view);
        eq(aO == 0);
        return aO;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean anz() {
        return this.mData != 0 && ((bh) this.mData).akb() == 5;
    }
}
