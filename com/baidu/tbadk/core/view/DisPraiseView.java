package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class DisPraiseView extends PraiseView {
    public DisPraiseView(Context context) {
        super(context);
        ajc();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ajc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void ajc() {
        this.agreeType = 5;
        this.bVW = R.string.action_dislike;
        this.bVZ = R.color.cp_cont_j;
        this.bWa = R.color.cp_link_tip_a;
        this.bVX = R.drawable.icon_card_dislike_n;
        this.bVY = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bg) this.mData).aeP();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aje() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).aeQ() != 0 && ajf()) {
            ((bg) this.mData).hl(5);
            ((bg) this.mData).hj(0);
            ((bg) this.mData).ar(((bg) this.mData).aeO());
            ((bg) this.mData).as(((bg) this.mData).aeP() - 1);
            i = 1;
        } else {
            int aeR = ((bg) this.mData).aeR();
            if ((((bg) this.mData).aeQ() != 0 && aeR == 2) || aeR == 1) {
                ((bg) this.mData).ar(((bg) this.mData).aeO() - 1);
            }
            ((bg) this.mData).hj(1);
            ((bg) this.mData).as(((bg) this.mData).aeP() + 1);
            ((bg) this.mData).hl(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aL(View view) {
        int aL = super.aL(view);
        ee(aL == 0);
        return aL;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean ajf() {
        return this.mData != 0 && ((bg) this.mData).aeR() == 5;
    }
}
