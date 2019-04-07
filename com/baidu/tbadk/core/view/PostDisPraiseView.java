package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class PostDisPraiseView extends PostPraiseView {
    public PostDisPraiseView(Context context) {
        super(context);
        aed();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aed() {
        this.agreeType = 5;
        this.bOg = d.j.action_dislike;
        this.bOj = d.C0277d.cp_cont_j;
        this.bOk = d.C0277d.cp_link_tip_a;
        this.bOh = d.f.icon_card_dislike_n;
        this.bOi = d.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).aai();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aef() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).beU() && aeg()) {
            ((PostData) this.mData).gz(5);
            ((PostData) this.mData).pZ(false);
            ((PostData) this.mData).af(((PostData) this.mData).aah());
            ((PostData) this.mData).ag(((PostData) this.mData).aai() - 1);
            i = 1;
        } else {
            int aak = ((PostData) this.mData).aak();
            if ((((PostData) this.mData).beU() && aak == 2) || aak == 1) {
                ((PostData) this.mData).af(((PostData) this.mData).aah() - 1);
            }
            ((PostData) this.mData).pZ(true);
            ((PostData) this.mData).ag(((PostData) this.mData).aai() + 1);
            ((PostData) this.mData).gz(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aF(View view) {
        int aF = super.aF(view);
        dI(aF == 0);
        return aF;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean aeg() {
        return this.mData != 0 && ((PostData) this.mData).aak() == 5;
    }
}
