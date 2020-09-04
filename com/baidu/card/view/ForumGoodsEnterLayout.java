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
/* loaded from: classes15.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport aeY;
    private int agM;
    private ThreadForumEnterGoodsButton ajh;
    private View.OnClickListener ajm;
    private int ajo;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.agM = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agM = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agM = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ajh = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        this.aeY = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        if (c(absThreadDataSupport) || absThreadDataSupport.bce() == null || !absThreadDataSupport.bce().bgM() || this.ajo == 3) {
            z = false;
        } else {
            this.ajh.setVisibility(0);
            this.ajh.setFrom(2);
            this.ajh.q(bce);
            this.ajh.setAfterClickListener(this.ajm);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajh.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.ajo = i;
    }

    public void setSourceForPb(int i) {
        this.agM = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajm = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bgJ() == null || absThreadDataSupport.bce().bgJ().getOptions() == null || absThreadDataSupport.bce().bgJ().getOptions().size() <= 0) ? false : true;
    }
}
