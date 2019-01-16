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
        EU();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void EU() {
        this.agreeType = 5;
        this.aFU = e.j.action_dislike;
        this.aFX = e.d.cp_cont_j;
        this.aFY = e.d.cp_link_tip_a;
        this.aFV = e.f.icon_card_dislike_n;
        this.aFW = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).Bg();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int EW() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aEn() && EX()) {
            ((PostData) this.mData).cY(5);
            ((PostData) this.mData).nz(false);
            ((PostData) this.mData).C(((PostData) this.mData).Bf());
            ((PostData) this.mData).D(((PostData) this.mData).Bg() - 1);
            i = 1;
        } else {
            int Bi = ((PostData) this.mData).Bi();
            if ((((PostData) this.mData).aEn() && Bi == 2) || Bi == 1) {
                ((PostData) this.mData).C(((PostData) this.mData).Bf() - 1);
            }
            ((PostData) this.mData).nz(true);
            ((PostData) this.mData).D(((PostData) this.mData).Bg() + 1);
            ((PostData) this.mData).cY(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int L(View view) {
        int L = super.L(view);
        bA(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean EX() {
        return this.mData != 0 && ((PostData) this.mData).Bi() == 5;
    }
}
