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
    private com.baidu.tbadk.core.data.a agj;
    private int aii;
    private ThreadForumEnterGoodsButton akC;
    private int akJ;
    private View.OnClickListener akx;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.aii = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aii = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aii = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.akC = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.agj = aVar;
        cb bln = aVar.bln();
        if (c(aVar) || d(aVar) || aVar.bln() == null || !aVar.bln().bqb() || this.akJ == 3) {
            z = false;
        } else {
            this.akC.setVisibility(0);
            this.akC.setFrom(2);
            this.akC.r(bln);
            this.akC.setAfterClickListener(this.akx);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akC.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.akJ = i;
    }

    public void setSourceForPb(int i) {
        this.aii = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akx = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || aVar.bln().bpY() == null || aVar.bln().bpY().getOptions() == null || aVar.bln().bpY().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || !aVar.bln().bmv() || aVar.bln().boh() == null) ? false : true;
    }
}
