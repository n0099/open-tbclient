package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport afH;
    private int ahw;
    private View.OnClickListener ajT;
    private ThreadForumEnterGoodsButton ajY;
    private int ake;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.ahw = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahw = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahw = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ajY = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        this.afH = absThreadDataSupport;
        bw bfG = absThreadDataSupport.bfG();
        if (c(absThreadDataSupport) || d(absThreadDataSupport) || absThreadDataSupport.bfG() == null || !absThreadDataSupport.bfG().bkp() || this.ake == 3) {
            z = false;
        } else {
            this.ajY.setVisibility(0);
            this.ajY.setFrom(2);
            this.ajY.r(bfG);
            this.ajY.setAfterClickListener(this.ajT);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajY.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.ake = i;
    }

    public void setSourceForPb(int i) {
        this.ahw = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || absThreadDataSupport.bfG().bkm() == null || absThreadDataSupport.bfG().bkm().getOptions() == null || absThreadDataSupport.bfG().bkm().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || !absThreadDataSupport.bfG().bgN() || absThreadDataSupport.bfG().biz() == null) ? false : true;
    }
}
