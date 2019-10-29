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
    public void anw() {
        super.anw();
        this.cnd = R.color.cp_cont_a;
        this.cne = R.color.cp_cont_h_alpha70;
        this.drawableResId = R.drawable.icon_card_like_video_n;
        this.cnc = R.drawable.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, R.layout.praise_view_middlevideo, this);
            this.cnf = (TextView) inflate.findViewById(R.id.thread_info_praise_num);
            this.cng = (ImageView) inflate.findViewById(R.id.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).ajY();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.textResId);
        if (num > 0) {
            string = aq.numFormatOverWan(num);
        }
        this.cnf.setText(string);
        this.cnf.setContentDescription(context.getString(this.textResId) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).bmt() && anz()) {
            this.cng.setImageDrawable(ad(this.cnc, this.drawableResId));
            this.cnf.setTextColor(createColorStateList(this.cne, this.cnd));
            return;
        }
        this.cng.setImageDrawable(ad(this.drawableResId, this.cnc));
        this.cnf.setTextColor(createColorStateList(this.cnd, this.cne));
    }

    public boolean anz() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).akb() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).akb() == 1);
    }
}
