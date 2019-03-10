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
        aeg();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
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

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).aal();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aei() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).beX() && aej()) {
            ((PostData) this.mData).gA(5);
            ((PostData) this.mData).pZ(false);
            ((PostData) this.mData).af(((PostData) this.mData).aak());
            ((PostData) this.mData).ag(((PostData) this.mData).aal() - 1);
            i = 1;
        } else {
            int aan = ((PostData) this.mData).aan();
            if ((((PostData) this.mData).beX() && aan == 2) || aan == 1) {
                ((PostData) this.mData).af(((PostData) this.mData).aak() - 1);
            }
            ((PostData) this.mData).pZ(true);
            ((PostData) this.mData).ag(((PostData) this.mData).aal() + 1);
            ((PostData) this.mData).gA(5);
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
    public boolean aej() {
        return this.mData != 0 && ((PostData) this.mData).aan() == 5;
    }
}
