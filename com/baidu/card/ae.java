package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes20.dex */
public class ae extends b<bk> {
    private RecommendForumLayout ahb;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ahb = new RecommendForumLayout(tbPageContext);
        this.ahb.setPageUniqueId(bdUniqueId);
        this.ahb.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahb;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ahb.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahb.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bk bkVar) {
        this.ahb.setData(bkVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.ahb.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.ahb.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bj> fVar) {
        this.ahb.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.ahb.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.ahb.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.ahb.setShowSquareEntrance(z);
    }
}
