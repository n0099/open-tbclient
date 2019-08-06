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
    public void aki() {
        super.aki();
        this.bXh = R.color.cp_btn_a;
        this.bXi = R.color.cp_cont_h_alpha70;
        this.bXf = R.drawable.icon_card_like_video_n;
        this.bXg = R.drawable.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, R.layout.praise_view_middlevideo, this);
            this.bXj = (TextView) inflate.findViewById(R.id.thread_info_praise_num);
            this.bXk = (ImageView) inflate.findViewById(R.id.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).afR();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JS() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bXe);
        if (num > 0) {
            string = aq.aO(num);
        }
        this.bXj.setText(string);
        this.bXj.setContentDescription(context.getString(this.bXe) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).boD() && akl()) {
            this.bXk.setImageDrawable(Z(this.bXg, this.bXf));
            this.bXj.setTextColor(createColorStateList(this.bXi, this.bXh));
            return;
        }
        this.bXk.setImageDrawable(Z(this.bXf, this.bXg));
        this.bXj.setTextColor(createColorStateList(this.bXh, this.bXi));
    }

    public boolean akl() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).afU() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).afU() == 1);
    }
}
