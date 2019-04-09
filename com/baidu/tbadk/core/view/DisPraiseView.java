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
        aed();
    }

    public DisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aed() {
        this.agreeType = 5;
        this.bOh = d.j.action_dislike;
        this.bOk = d.C0277d.cp_cont_j;
        this.bOl = d.C0277d.cp_link_tip_a;
        this.bOi = d.f.icon_card_dislike_n;
        this.bOj = d.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bg) this.mData).aai();
    }

    @Override // com.baidu.tbadk.core.view.PraiseView
    public int aef() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).aaj() != 0 && aeg()) {
            ((bg) this.mData).gz(5);
            ((bg) this.mData).gx(0);
            ((bg) this.mData).af(((bg) this.mData).aah());
            ((bg) this.mData).ag(((bg) this.mData).aai() - 1);
            i = 1;
        } else {
            int aak = ((bg) this.mData).aak();
            if ((((bg) this.mData).aaj() != 0 && aak == 2) || aak == 1) {
                ((bg) this.mData).af(((bg) this.mData).aah() - 1);
            }
            ((bg) this.mData).gx(1);
            ((bg) this.mData).ag(((bg) this.mData).aai() + 1);
            ((bg) this.mData).gz(5);
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
    public boolean aeg() {
        return this.mData != 0 && ((bg) this.mData).aak() == 5;
    }
}
