package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a ahB;
    private int ajA;
    private View.OnClickListener alQ;
    private ThreadForumEnterGoodsButton alV;
    private int amc;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.ajA = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajA = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajA = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.alV = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.ahB = aVar;
        cb blp = aVar.blp();
        if (c(aVar) || d(aVar) || aVar.blp() == null || !aVar.blp().bqd() || this.amc == 3) {
            z = false;
        } else {
            this.alV.setVisibility(0);
            this.alV.setFrom(2);
            this.alV.r(blp);
            this.alV.setAfterClickListener(this.alQ);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.alV.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.amc = i;
    }

    public void setSourceForPb(int i) {
        this.ajA = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.alQ = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || aVar.blp().bqa() == null || aVar.blp().bqa().getOptions() == null || aVar.blp().bqa().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || !aVar.blp().bmx() || aVar.blp().boj() == null) ? false : true;
    }
}
