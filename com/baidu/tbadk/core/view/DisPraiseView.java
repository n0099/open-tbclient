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
        aki();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aki();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aki() {
        this.agreeType = 5;
        this.bXe = R.string.action_dislike;
        this.bXh = R.color.cp_cont_j;
        this.bXi = R.color.cp_link_tip_a;
        this.bXf = R.drawable.icon_card_dislike_n;
        this.bXg = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bh) this.mData).afS();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int akk() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).afT() != 0 && akl()) {
            ((bh) this.mData).hr(5);
            ((bh) this.mData).hp(0);
            ((bh) this.mData).as(((bh) this.mData).afR());
            ((bh) this.mData).at(((bh) this.mData).afS() - 1);
            i = 1;
        } else {
            int afU = ((bh) this.mData).afU();
            if ((((bh) this.mData).afT() != 0 && afU == 2) || afU == 1) {
                ((bh) this.mData).as(((bh) this.mData).afR() - 1);
            }
            ((bh) this.mData).hp(1);
            ((bh) this.mData).at(((bh) this.mData).afS() + 1);
            ((bh) this.mData).hr(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aN(View view) {
        int aN = super.aN(view);
        ei(aN == 0);
        return aN;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean akl() {
        return this.mData != 0 && ((bh) this.mData).afU() == 5;
    }
}
