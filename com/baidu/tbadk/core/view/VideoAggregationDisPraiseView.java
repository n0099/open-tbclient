package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        EH();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void EH() {
        this.agreeType = 5;
        this.aFs = e.j.action_dislike;
        this.aFv = e.d.cp_cont_i_alpha70;
        this.aFw = e.d.cp_link_tip_a_alpha70;
        this.aFt = e.f.icon_card_dislike_white_n;
        this.aFu = e.f.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).AT();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int EJ() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aDQ() && EK()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(5);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).AS());
            ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).AT() - 1);
            i = 1;
        } else {
            int AV = ((com.baidu.tieba.frs.aggregation.g) this.mData).AV();
            if ((((com.baidu.tieba.frs.aggregation.g) this.mData).aDQ() && AV == 2) || AV == 1) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).AS() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).AT() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int L(View view) {
        int L = super.L(view);
        bz(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean EK() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).AV() == 5;
    }
}
