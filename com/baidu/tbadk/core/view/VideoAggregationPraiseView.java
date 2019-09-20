package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
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
    public void aku() {
        super.aku();
        this.bYa = R.color.cp_cont_a;
        this.bYb = R.color.cp_cont_h_alpha70;
        this.bXY = R.drawable.icon_card_like_video_n;
        this.bXZ = R.drawable.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, R.layout.praise_view_middlevideo, this);
            this.bYc = (TextView) inflate.findViewById(R.id.thread_info_praise_num);
            this.bYd = (ImageView) inflate.findViewById(R.id.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).afV();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JW() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bXX);
        if (num > 0) {
            string = aq.aO(num);
        }
        this.bYc.setText(string);
        this.bYc.setContentDescription(context.getString(this.bXX) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).bpo() && akx()) {
            this.bYd.setImageDrawable(Z(this.bXZ, this.bXY));
            this.bYc.setTextColor(createColorStateList(this.bYb, this.bYa));
            return;
        }
        this.bYd.setImageDrawable(Z(this.bXY, this.bXZ));
        this.bYc.setTextColor(createColorStateList(this.bYa, this.bYb));
    }

    public boolean akx() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).afY() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).afY() == 1);
    }
}
