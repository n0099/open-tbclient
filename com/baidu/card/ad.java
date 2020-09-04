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
    private RecommendForumLayout ago;
    private int mSkinType;

    public ad(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ago = new RecommendForumLayout(tbPageContext);
        this.ago.setPageUniqueId(bdUniqueId);
        this.ago.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ago;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ago.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ago.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bj bjVar) {
        this.ago.setData(bjVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.ago.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.ago.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bi> fVar) {
        this.ago.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.ago.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.ago.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.ago.setShowSquareEntrance(z);
    }
}
