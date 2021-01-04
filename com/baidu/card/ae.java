package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes.dex */
public class ae extends a<bm> {
    private RecommendForumLayout aiN;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.aiN = new RecommendForumLayout(tbPageContext);
        this.aiN.setPageUniqueId(bdUniqueId);
        this.aiN.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aiN;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.aiN.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aiN.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void D(bm bmVar) {
        this.aiN.setData(bmVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.aiN.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.aiN.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bl> fVar) {
        this.aiN.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.aiN.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.aiN.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.aiN.setShowSquareEntrance(z);
    }
}
