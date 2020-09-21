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
/* loaded from: classes20.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport afq;
    private int ahf;
    private View.OnClickListener ajB;
    private ThreadForumEnterGoodsButton ajG;
    private int ajM;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.ahf = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahf = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahf = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ajG = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        if (c(absThreadDataSupport) || d(absThreadDataSupport) || absThreadDataSupport.bcY() == null || !absThreadDataSupport.bcY().bhG() || this.ajM == 3) {
            z = false;
        } else {
            this.ajG.setVisibility(0);
            this.ajG.setFrom(2);
            this.ajG.r(bcY);
            this.ajG.setAfterClickListener(this.ajB);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajG.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.ajM = i;
    }

    public void setSourceForPb(int i) {
        this.ahf = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajB = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || absThreadDataSupport.bcY().bhD() == null || absThreadDataSupport.bcY().bhD().getOptions() == null || absThreadDataSupport.bcY().bhD().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || !absThreadDataSupport.bcY().bee() || absThreadDataSupport.bcY().bfQ() == null) ? false : true;
    }
}
