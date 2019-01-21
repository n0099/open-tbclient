package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        EU();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void EU() {
        this.agreeType = 5;
        this.aFV = e.j.action_dislike;
        this.aFY = e.d.cp_cont_i_alpha70;
        this.aFZ = e.d.cp_link_tip_a_alpha70;
        this.aFW = e.f.icon_card_dislike_white_n;
        this.aFX = e.f.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).Bg();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int EW() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aEn() && EX()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(5);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).Bf());
            ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).Bg() - 1);
            i = 1;
        } else {
            int Bi = ((com.baidu.tieba.frs.aggregation.g) this.mData).Bi();
            if ((((com.baidu.tieba.frs.aggregation.g) this.mData).aEn() && Bi == 2) || Bi == 1) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).Bf() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).Bg() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int L(View view) {
        int L = super.L(view);
        bA(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean EX() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).Bi() == 5;
    }
}
