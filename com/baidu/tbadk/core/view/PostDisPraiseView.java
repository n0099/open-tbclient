package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PostDisPraiseView extends PostPraiseView {
    public PostDisPraiseView(Context context) {
        super(context);
        Bq();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Bq() {
        this.agreeType = 5;
        this.awr = e.j.action_dislike;
        this.awu = e.d.cp_cont_j;
        this.awv = e.d.cp_link_tip_a;
        this.aws = e.f.icon_card_dislike_n;
        this.awt = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).xz();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int Bs() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).ayA() && Bt()) {
            ((PostData) this.mData).cm(5);
            ((PostData) this.mData).mR(false);
            ((PostData) this.mData).t(((PostData) this.mData).xy());
            ((PostData) this.mData).u(((PostData) this.mData).xz() - 1);
            i = 1;
        } else {
            int xB = ((PostData) this.mData).xB();
            if ((((PostData) this.mData).ayA() && xB == 2) || xB == 1) {
                ((PostData) this.mData).t(((PostData) this.mData).xy() - 1);
            }
            ((PostData) this.mData).mR(true);
            ((PostData) this.mData).u(((PostData) this.mData).xz() + 1);
            ((PostData) this.mData).cm(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int L(View view) {
        int L = super.L(view);
        aY(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean Bt() {
        return this.mData != 0 && ((PostData) this.mData).xB() == 5;
    }
}
