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
    public void akg() {
        super.akg();
        this.bXb = R.color.cp_btn_a;
        this.bXc = R.color.cp_cont_h_alpha70;
        this.bWZ = R.drawable.icon_card_like_video_n;
        this.bXa = R.drawable.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, R.layout.praise_view_middlevideo, this);
            this.bXd = (TextView) inflate.findViewById(R.id.thread_info_praise_num);
            this.bXe = (ImageView) inflate.findViewById(R.id.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).afQ();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JS() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bWY);
        if (num > 0) {
            string = aq.aO(num);
        }
        this.bXd.setText(string);
        this.bXd.setContentDescription(context.getString(this.bWY) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).boq() && akj()) {
            this.bXe.setImageDrawable(Z(this.bXa, this.bWZ));
            this.bXd.setTextColor(createColorStateList(this.bXc, this.bXb));
            return;
        }
        this.bXe.setImageDrawable(Z(this.bWZ, this.bXa));
        this.bXd.setTextColor(createColorStateList(this.bXb, this.bXc));
    }

    public boolean akj() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).afT() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).afT() == 1);
    }
}
