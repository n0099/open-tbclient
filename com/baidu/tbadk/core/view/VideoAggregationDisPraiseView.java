package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        aku();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aku();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void aku() {
        this.agreeType = 5;
        this.bXX = R.string.action_dislike;
        this.bYa = R.color.cp_cont_a;
        this.bYb = R.color.cp_link_tip_a_alpha70;
        this.bXY = R.drawable.icon_card_dislike_white_n;
        this.bXZ = R.drawable.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).afW();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean akx() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).afY() == 5;
    }
}
