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
    public void anu() {
        super.anu();
        this.cmm = R.color.cp_cont_a;
        this.cmn = R.color.cp_cont_h_alpha70;
        this.drawableResId = R.drawable.icon_card_like_video_n;
        this.cml = R.drawable.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, R.layout.praise_view_middlevideo, this);
            this.cmo = (TextView) inflate.findViewById(R.id.thread_info_praise_num);
            this.cmp = (ImageView) inflate.findViewById(R.id.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).ajW();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.textResId);
        if (num > 0) {
            string = aq.numFormatOverWan(num);
        }
        this.cmo.setText(string);
        this.cmo.setContentDescription(context.getString(this.textResId) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).bmr() && anx()) {
            this.cmp.setImageDrawable(ab(this.cml, this.drawableResId));
            this.cmo.setTextColor(createColorStateList(this.cmn, this.cmm));
            return;
        }
        this.cmp.setImageDrawable(ab(this.drawableResId, this.cml));
        this.cmo.setTextColor(createColorStateList(this.cmm, this.cmn));
    }

    public boolean anx() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).ajZ() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).ajZ() == 1);
    }
}
