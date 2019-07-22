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
        akg();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        akg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void akg() {
        this.agreeType = 5;
        this.bWY = R.string.action_dislike;
        this.bXb = R.color.cp_cont_j;
        this.bXc = R.color.cp_link_tip_a;
        this.bWZ = R.drawable.icon_card_dislike_n;
        this.bXa = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bg) this.mData).afR();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aki() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).afS() != 0 && akj()) {
            ((bg) this.mData).hr(5);
            ((bg) this.mData).hp(0);
            ((bg) this.mData).as(((bg) this.mData).afQ());
            ((bg) this.mData).at(((bg) this.mData).afR() - 1);
            i = 1;
        } else {
            int afT = ((bg) this.mData).afT();
            if ((((bg) this.mData).afS() != 0 && afT == 2) || afT == 1) {
                ((bg) this.mData).as(((bg) this.mData).afQ() - 1);
            }
            ((bg) this.mData).hp(1);
            ((bg) this.mData).at(((bg) this.mData).afR() + 1);
            ((bg) this.mData).hr(5);
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
    public boolean akj() {
        return this.mData != 0 && ((bg) this.mData).afT() == 5;
    }
}
