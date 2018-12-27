package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class PostDisPraiseView extends PostPraiseView {
    public PostDisPraiseView(Context context) {
        super(context);
        EH();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void EH() {
        this.agreeType = 5;
        this.aFs = e.j.action_dislike;
        this.aFv = e.d.cp_cont_j;
        this.aFw = e.d.cp_link_tip_a;
        this.aFt = e.f.icon_card_dislike_n;
        this.aFu = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).AT();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int EJ() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aDQ() && EK()) {
            ((PostData) this.mData).cY(5);
            ((PostData) this.mData).ny(false);
            ((PostData) this.mData).C(((PostData) this.mData).AS());
            ((PostData) this.mData).D(((PostData) this.mData).AT() - 1);
            i = 1;
        } else {
            int AV = ((PostData) this.mData).AV();
            if ((((PostData) this.mData).aDQ() && AV == 2) || AV == 1) {
                ((PostData) this.mData).C(((PostData) this.mData).AS() - 1);
            }
            ((PostData) this.mData).ny(true);
            ((PostData) this.mData).D(((PostData) this.mData).AT() + 1);
            ((PostData) this.mData).cY(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int L(View view) {
        int L = super.L(view);
        bz(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean EK() {
        return this.mData != 0 && ((PostData) this.mData).AV() == 5;
    }
}
