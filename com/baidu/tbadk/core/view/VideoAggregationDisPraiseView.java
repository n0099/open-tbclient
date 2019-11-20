package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        anu();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        anu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void anu() {
        this.agreeType = 5;
        this.textResId = R.string.action_dislike;
        this.cmm = R.color.cp_cont_a;
        this.cmn = R.color.cp_link_tip_a_alpha70;
        this.drawableResId = R.drawable.icon_card_dislike_white_n;
        this.cml = R.drawable.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).ajX();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean anx() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).ajZ() == 5;
    }
}
