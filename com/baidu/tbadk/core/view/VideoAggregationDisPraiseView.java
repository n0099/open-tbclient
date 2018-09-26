package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        Bq();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void Bq() {
        this.agreeType = 5;
        this.awr = e.j.action_dislike;
        this.awu = e.d.cp_cont_i_alpha70;
        this.awv = e.d.cp_link_tip_a_alpha70;
        this.aws = e.f.icon_card_dislike_white_n;
        this.awt = e.f.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).xz();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int Bs() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).ayA() && Bt()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cm(5);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).ck(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).t(((com.baidu.tieba.frs.aggregation.g) this.mData).xy());
            ((com.baidu.tieba.frs.aggregation.g) this.mData).u(((com.baidu.tieba.frs.aggregation.g) this.mData).xz() - 1);
            i = 1;
        } else {
            int xB = ((com.baidu.tieba.frs.aggregation.g) this.mData).xB();
            if ((((com.baidu.tieba.frs.aggregation.g) this.mData).ayA() && xB == 2) || xB == 1) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).t(((com.baidu.tieba.frs.aggregation.g) this.mData).xy() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).ck(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).u(((com.baidu.tieba.frs.aggregation.g) this.mData).xz() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cm(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int L(View view) {
        int L = super.L(view);
        aY(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean Bt() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).xB() == 5;
    }
}
