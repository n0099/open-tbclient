package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes15.dex */
public class ac extends b<bi> {
    private RecommendForumLayout afc;
    private int mSkinType;

    public ac(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.afc = new RecommendForumLayout(tbPageContext);
        this.afc.setPageUniqueId(bdUniqueId);
        this.afc.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afc;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.afc.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afc.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bi biVar) {
        this.afc.setData(biVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.afc.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.afc.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bh> fVar) {
        this.afc.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.afc.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.afc.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.afc.setShowSquareEntrance(z);
    }
}
