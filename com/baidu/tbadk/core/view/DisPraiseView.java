package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class DisPraiseView extends PraiseView {
    public DisPraiseView(Context context) {
        super(context);
        aeg();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aeg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aeg() {
        this.agreeType = 5;
        this.bOd = d.j.action_dislike;
        this.bOg = d.C0236d.cp_cont_j;
        this.bOh = d.C0236d.cp_link_tip_a;
        this.bOe = d.f.icon_card_dislike_n;
        this.bOf = d.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bg) this.mData).aal();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aei() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).aam() != 0 && aej()) {
            ((bg) this.mData).gA(5);
            ((bg) this.mData).gy(0);
            ((bg) this.mData).af(((bg) this.mData).aak());
            ((bg) this.mData).ag(((bg) this.mData).aal() - 1);
            i = 1;
        } else {
            int aan = ((bg) this.mData).aan();
            if ((((bg) this.mData).aam() != 0 && aan == 2) || aan == 1) {
                ((bg) this.mData).af(((bg) this.mData).aak() - 1);
            }
            ((bg) this.mData).gy(1);
            ((bg) this.mData).ag(((bg) this.mData).aal() + 1);
            ((bg) this.mData).gA(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aF(View view) {
        int aF = super.aF(view);
        dI(aF == 0);
        return aF;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public boolean aej() {
        return this.mData != 0 && ((bg) this.mData).aan() == 5;
    }
}
