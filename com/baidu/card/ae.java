package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes21.dex */
public class ae extends b<bj> {
    private RecommendForumLayout agY;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agY = new RecommendForumLayout(tbPageContext);
        this.agY.setPageUniqueId(bdUniqueId);
        this.agY.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agY;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.agY.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agY.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bj bjVar) {
        this.agY.setData(bjVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.agY.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.agY.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bi> fVar) {
        this.agY.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.agY.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.agY.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.agY.setShowSquareEntrance(z);
    }
}
