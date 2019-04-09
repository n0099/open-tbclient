package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class VideoAggregationPraiseView extends BasePraiseView<com.baidu.tieba.frs.aggregation.g> {
    public VideoAggregationPraiseView(Context context) {
        this(context, null);
    }

    public VideoAggregationPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aed() {
        super.aed();
        this.bOk = d.C0277d.cp_btn_a;
        this.bOl = d.C0277d.cp_cont_h_alpha70;
        this.bOi = d.f.icon_card_like_video_n;
        this.bOj = d.f.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, d.h.praise_view_middlevideo, this);
            this.bOm = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
            this.bOn = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).aah();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GP() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bOh);
        if (num > 0) {
            string = ap.az(num);
        }
        this.bOm.setText(string);
        this.bOm.setContentDescription(context.getString(this.bOh) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).beU() && aeg()) {
            this.bOn.setImageDrawable(W(this.bOj, this.bOi));
            this.bOm.setTextColor(createColorStateList(this.bOl, this.bOk));
            return;
        }
        this.bOn.setImageDrawable(W(this.bOi, this.bOj));
        this.bOm.setTextColor(createColorStateList(this.bOk, this.bOl));
    }

    public boolean aeg() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).aak() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).aak() == 1);
    }
}
