package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes8.dex */
public class ac extends b<bh> {
    private RecommendForumLayout afl;
    private int mSkinType;

    public ac(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.afl = new RecommendForumLayout(tbPageContext);
        this.afl.setPageUniqueId(bdUniqueId);
        this.afl.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afl;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.afl.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afl.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bh bhVar) {
        this.afl.setData(bhVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.afl.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.afl.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bg> fVar) {
        this.afl.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.afl.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.afl.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.afl.setShowSquareEntrance(z);
    }
}
