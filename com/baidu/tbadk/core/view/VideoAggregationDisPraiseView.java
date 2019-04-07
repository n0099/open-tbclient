package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoAggregationDisPraiseView extends VideoAggregationPraiseView {
    public VideoAggregationDisPraiseView(Context context) {
        super(context);
        aed();
    }

    public VideoAggregationDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public void aed() {
        this.agreeType = 5;
        this.bOg = d.j.action_dislike;
        this.bOj = d.C0277d.cp_btn_a;
        this.bOk = d.C0277d.cp_link_tip_a_alpha70;
        this.bOh = d.f.icon_card_dislike_white_n;
        this.bOi = d.f.icon_card_dislike_white_s;
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).aai();
    }

    @Override // com.baidu.tbadk.core.view.VideoAggregationPraiseView
    public boolean aeg() {
        return this.mData != 0 && ((com.baidu.tieba.frs.aggregation.g) this.mData).aak() == 5;
    }
}
