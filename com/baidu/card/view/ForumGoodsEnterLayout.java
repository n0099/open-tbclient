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
    private AbsThreadDataSupport aeW;
    private int agK;
    private ThreadForumEnterGoodsButton ajf;
    private View.OnClickListener ajk;
    private int ajm;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.agK = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agK = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agK = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ajf = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        this.aeW = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        if (c(absThreadDataSupport) || absThreadDataSupport.bce() == null || !absThreadDataSupport.bce().bgM() || this.ajm == 3) {
            z = false;
        } else {
            this.ajf.setVisibility(0);
            this.ajf.setFrom(2);
            this.ajf.q(bce);
            this.ajf.setAfterClickListener(this.ajk);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajf.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.ajm = i;
    }

    public void setSourceForPb(int i) {
        this.agK = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajk = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bgJ() == null || absThreadDataSupport.bce().bgJ().getOptions() == null || absThreadDataSupport.bce().bgJ().getOptions().size() <= 0) ? false : true;
    }
}
