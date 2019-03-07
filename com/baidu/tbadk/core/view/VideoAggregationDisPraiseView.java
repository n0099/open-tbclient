package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        aeg();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aeg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void aeg() {
        this.agreeType = 5;
        this.bOd = d.j.action_dislike;
        this.bOg = d.C0236d.cp_btn_a;
        this.bOh = d.C0236d.cp_link_tip_a_alpha70;
        this.bOe = d.f.icon_card_dislike_white_n;
        this.bOf = d.f.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).aal();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean aej() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).aan() == 5;
    }
}
