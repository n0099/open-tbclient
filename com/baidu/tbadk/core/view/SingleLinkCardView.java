package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SingleLinkCardView extends RelativeLayout {
    private TbImageView eiW;
    private TextView eiX;

    public SingleLinkCardView(Context context) {
        this(context, null);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.single_link_card_layout, this);
        this.eiW = (TbImageView) findViewById(R.id.iv_single_link_icon);
        this.eiW.setDrawCorner(true);
        this.eiW.setConrers(15);
        this.eiW.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eiX = (TextView) findViewById(R.id.tv_single_link_text);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.bg_link_card);
        ao.setViewTextColor(this.eiX, R.color.cp_cont_j);
    }

    public void a(PbLinkData pbLinkData) {
        this.eiW.startLoad(pbLinkData.picUrl, 10, false);
        this.eiX.setText(pbLinkData.title);
    }

    public void setMarginTop(int i) {
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
        requestLayout();
    }
}
