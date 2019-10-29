package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        anw();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        anw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void anw() {
        this.agreeType = 5;
        this.textResId = R.string.action_dislike;
        this.cnd = R.color.cp_cont_a;
        this.cne = R.color.cp_link_tip_a_alpha70;
        this.drawableResId = R.drawable.icon_card_dislike_white_n;
        this.cnc = R.drawable.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).ajZ();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean anz() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).akb() == 5;
    }
}
