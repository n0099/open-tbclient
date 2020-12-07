package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a agJ;
    private int aiz;
    private View.OnClickListener akX;
    private ThreadForumEnterGoodsButton alc;
    private int ali;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.aiz = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiz = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiz = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.alc = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.agJ = aVar;
        by bmn = aVar.bmn();
        if (c(aVar) || d(aVar) || aVar.bmn() == null || !aVar.bmn().bra() || this.ali == 3) {
            z = false;
        } else {
            this.alc.setVisibility(0);
            this.alc.setFrom(2);
            this.alc.r(bmn);
            this.alc.setAfterClickListener(this.akX);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.alc.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.ali = i;
    }

    public void setSourceForPb(int i) {
        this.aiz = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akX = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || aVar.bmn().bqX() == null || aVar.bmn().bqX().getOptions() == null || aVar.bmn().bqX().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || !aVar.bmn().bnv() || aVar.bmn().bph() == null) ? false : true;
    }
}
