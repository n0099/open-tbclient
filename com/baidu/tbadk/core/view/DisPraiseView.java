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
        aku();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aku();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aku() {
        this.agreeType = 5;
        this.bXX = R.string.action_dislike;
        this.bYa = R.color.cp_cont_j;
        this.bYb = R.color.cp_link_tip_a;
        this.bXY = R.drawable.icon_card_dislike_n;
        this.bXZ = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bh) this.mData).afW();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int akw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).afX() != 0 && akx()) {
            ((bh) this.mData).hs(5);
            ((bh) this.mData).hq(0);
            ((bh) this.mData).as(((bh) this.mData).afV());
            ((bh) this.mData).at(((bh) this.mData).afW() - 1);
            i = 1;
        } else {
            int afY = ((bh) this.mData).afY();
            if ((((bh) this.mData).afX() != 0 && afY == 2) || afY == 1) {
                ((bh) this.mData).as(((bh) this.mData).afV() - 1);
            }
            ((bh) this.mData).hq(1);
            ((bh) this.mData).at(((bh) this.mData).afW() + 1);
            ((bh) this.mData).hs(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aN(View view) {
        int aN = super.aN(view);
        el(aN == 0);
        return aN;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean akx() {
        return this.mData != 0 && ((bh) this.mData).afY() == 5;
    }
}
