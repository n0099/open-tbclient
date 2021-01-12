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
    private RecommendForumLayout ahV;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ahV = new RecommendForumLayout(tbPageContext);
        this.ahV.setPageUniqueId(bdUniqueId);
        this.ahV.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahV;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ahV.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahV.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(bm bmVar) {
        this.ahV.setData(bmVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.ahV.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.ahV.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bl> fVar) {
        this.ahV.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.ahV.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.ahV.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.ahV.setShowSquareEntrance(z);
    }
}
