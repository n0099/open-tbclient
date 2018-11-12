package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        DD();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void DD() {
        this.agreeType = 5;
        this.aBR = e.j.action_dislike;
        this.aBU = e.d.cp_cont_i_alpha70;
        this.aBV = e.d.cp_link_tip_a_alpha70;
        this.aBS = e.f.icon_card_dislike_white_n;
        this.aBT = e.f.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).zP();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int DF() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBr() && DG()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cK(5);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cI(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).x(((com.baidu.tieba.frs.aggregation.g) this.mData).zO());
            ((com.baidu.tieba.frs.aggregation.g) this.mData).y(((com.baidu.tieba.frs.aggregation.g) this.mData).zP() - 1);
            i = 1;
        } else {
            int zR = ((com.baidu.tieba.frs.aggregation.g) this.mData).zR();
            if ((((com.baidu.tieba.frs.aggregation.g) this.mData).aBr() && zR == 2) || zR == 1) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).x(((com.baidu.tieba.frs.aggregation.g) this.mData).zO() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cI(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).y(((com.baidu.tieba.frs.aggregation.g) this.mData).zP() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cK(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int L(View view) {
        int L = super.L(view);
        by(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean DG() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).zR() == 5;
    }
}
