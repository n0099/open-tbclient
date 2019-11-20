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
        anu();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        anu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void anu() {
        this.agreeType = 5;
        this.textResId = R.string.action_dislike;
        this.cmm = R.color.cp_cont_j;
        this.cmn = R.color.cp_link_tip_a;
        this.drawableResId = R.drawable.icon_card_dislike_n;
        this.cml = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bh) this.mData).ajX();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int anw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).ajY() != 0 && anx()) {
            ((bh) this.mData).hQ(5);
            ((bh) this.mData).hO(0);
            ((bh) this.mData).aK(((bh) this.mData).ajW());
            ((bh) this.mData).aL(((bh) this.mData).ajX() - 1);
            i = 1;
        } else {
            int ajZ = ((bh) this.mData).ajZ();
            if ((((bh) this.mData).ajY() != 0 && ajZ == 2) || ajZ == 1) {
                ((bh) this.mData).aK(((bh) this.mData).ajW() - 1);
            }
            ((bh) this.mData).hO(1);
            ((bh) this.mData).aL(((bh) this.mData).ajX() + 1);
            ((bh) this.mData).hQ(5);
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
    public boolean anx() {
        return this.mData != 0 && ((bh) this.mData).ajZ() == 5;
    }
}
