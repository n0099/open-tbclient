package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a agr;
    private int aiu;
    private View.OnClickListener akI;
    private ThreadForumEnterGoodsButton akN;
    private int akT;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.aiu = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiu = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiu = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.akN = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.agr = aVar;
        bz bkV = aVar.bkV();
        if (c(aVar) || d(aVar) || aVar.bkV() == null || !aVar.bkV().bpJ() || this.akT == 3) {
            z = false;
        } else {
            this.akN.setVisibility(0);
            this.akN.setFrom(2);
            this.akN.r(bkV);
            this.akN.setAfterClickListener(this.akI);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akN.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.akT = i;
    }

    public void setSourceForPb(int i) {
        this.aiu = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akI = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || aVar.bkV().bpG() == null || aVar.bkV().bpG().getOptions() == null || aVar.bkV().bpG().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || !aVar.bkV().bmc() || aVar.bkV().bnO() == null) ? false : true;
    }
}
