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
        DD();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void DD() {
        this.agreeType = 5;
        this.aBR = e.j.action_dislike;
        this.aBU = e.d.cp_cont_j;
        this.aBV = e.d.cp_link_tip_a;
        this.aBS = e.f.icon_card_dislike_n;
        this.aBT = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).zP();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int DF() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aBr() && DG()) {
            ((PostData) this.mData).cK(5);
            ((PostData) this.mData).nt(false);
            ((PostData) this.mData).x(((PostData) this.mData).zO());
            ((PostData) this.mData).y(((PostData) this.mData).zP() - 1);
            i = 1;
        } else {
            int zR = ((PostData) this.mData).zR();
            if ((((PostData) this.mData).aBr() && zR == 2) || zR == 1) {
                ((PostData) this.mData).x(((PostData) this.mData).zO() - 1);
            }
            ((PostData) this.mData).nt(true);
            ((PostData) this.mData).y(((PostData) this.mData).zP() + 1);
            ((PostData) this.mData).cK(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int L(View view) {
        int L = super.L(view);
        by(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean DG() {
        return this.mData != 0 && ((PostData) this.mData).zR() == 5;
    }
}
