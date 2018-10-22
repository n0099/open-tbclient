package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        Dw();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Dw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void Dw() {
        this.agreeType = 5;
        this.aBc = e.j.action_dislike;
        this.aBf = e.d.cp_cont_i_alpha70;
        this.aBg = e.d.cp_link_tip_a_alpha70;
        this.aBd = e.f.icon_card_dislike_white_n;
        this.aBe = e.f.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).zI();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int Dy() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBU() && Dz()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cw(5);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cu(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).v(((com.baidu.tieba.frs.aggregation.g) this.mData).zH());
            ((com.baidu.tieba.frs.aggregation.g) this.mData).w(((com.baidu.tieba.frs.aggregation.g) this.mData).zI() - 1);
            i = 1;
        } else {
            int zK = ((com.baidu.tieba.frs.aggregation.g) this.mData).zK();
            if ((((com.baidu.tieba.frs.aggregation.g) this.mData).aBU() && zK == 2) || zK == 1) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).v(((com.baidu.tieba.frs.aggregation.g) this.mData).zH() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cu(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).w(((com.baidu.tieba.frs.aggregation.g) this.mData).zI() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cw(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public int L(View view) {
        int L = super.L(view);
        bi(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean Dz() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).zK() == 5;
    }
}
