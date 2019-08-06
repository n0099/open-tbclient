package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        aki();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aki();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void aki() {
        this.agreeType = 5;
        this.bXe = R.string.action_dislike;
        this.bXh = R.color.cp_btn_a;
        this.bXi = R.color.cp_link_tip_a_alpha70;
        this.bXf = R.drawable.icon_card_dislike_white_n;
        this.bXg = R.drawable.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).afS();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean akl() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).afU() == 5;
    }
}
