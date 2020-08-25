package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes15.dex */
public class ad extends b<bj> {
    private RecommendForumLayout agm;
    private int mSkinType;

    public ad(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agm = new RecommendForumLayout(tbPageContext);
        this.agm.setPageUniqueId(bdUniqueId);
        this.agm.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agm;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.agm.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agm.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bj bjVar) {
        this.agm.setData(bjVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.agm.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.agm.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bi> fVar) {
        this.agm.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.agm.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.agm.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.agm.setShowSquareEntrance(z);
    }
}
