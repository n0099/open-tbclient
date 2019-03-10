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
    public void aeg() {
        super.aeg();
        this.bOg = d.C0236d.cp_btn_a;
        this.bOh = d.C0236d.cp_cont_h_alpha70;
        this.bOe = d.f.icon_card_like_video_n;
        this.bOf = d.f.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, d.h.praise_view_middlevideo, this);
            this.bOi = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
            this.bOj = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).aak();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GR() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bOd);
        if (num > 0) {
            string = ap.az(num);
        }
        this.bOi.setText(string);
        this.bOi.setContentDescription(context.getString(this.bOd) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).beX() && aej()) {
            this.bOj.setImageDrawable(W(this.bOf, this.bOe));
            this.bOi.setTextColor(createColorStateList(this.bOh, this.bOg));
            return;
        }
        this.bOj.setImageDrawable(W(this.bOe, this.bOf));
        this.bOi.setTextColor(createColorStateList(this.bOg, this.bOh));
    }

    public boolean aej() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).aan() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).aan() == 1);
    }
}
