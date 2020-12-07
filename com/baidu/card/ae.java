package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes21.dex */
public class ae extends b<bl> {
    private RecommendForumLayout aia;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.aia = new RecommendForumLayout(tbPageContext);
        this.aia.setPageUniqueId(bdUniqueId);
        this.aia.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aia;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.aia.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aia.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bl blVar) {
        this.aia.setData(blVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.aia.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.aia.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bk> fVar) {
        this.aia.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.aia.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.aia.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.aia.setShowSquareEntrance(z);
    }
}
