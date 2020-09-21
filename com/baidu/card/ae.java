package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes20.dex */
public class ae extends b<bj> {
    private RecommendForumLayout agH;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agH = new RecommendForumLayout(tbPageContext);
        this.agH.setPageUniqueId(bdUniqueId);
        this.agH.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agH;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.agH.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agH.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(bj bjVar) {
        this.agH.setData(bjVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.agH.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.agH.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bi> fVar) {
        this.agH.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.agH.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.agH.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.agH.setShowSquareEntrance(z);
    }
}
