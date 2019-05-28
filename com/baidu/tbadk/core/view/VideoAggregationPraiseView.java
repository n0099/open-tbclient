package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
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
    public void ajc() {
        super.ajc();
        this.bVY = R.color.cp_btn_a;
        this.bVZ = R.color.cp_cont_h_alpha70;
        this.bVW = R.drawable.icon_card_like_video_n;
        this.bVX = R.drawable.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, R.layout.praise_view_middlevideo, this);
            this.bWa = (TextView) inflate.findViewById(R.id.thread_info_praise_num);
            this.bWb = (ImageView) inflate.findViewById(R.id.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).aeO();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Jf() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bVV);
        if (num > 0) {
            string = ap.aN(num);
        }
        this.bWa.setText(string);
        this.bWa.setContentDescription(context.getString(this.bVV) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).bmp() && ajf()) {
            this.bWb.setImageDrawable(W(this.bVX, this.bVW));
            this.bWa.setTextColor(createColorStateList(this.bVZ, this.bVY));
            return;
        }
        this.bWb.setImageDrawable(W(this.bVW, this.bVX));
        this.bWa.setTextColor(createColorStateList(this.bVY, this.bVZ));
    }

    public boolean ajf() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).aeR() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).aeR() == 1);
    }
}
