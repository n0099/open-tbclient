package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes.dex */
public class ae extends a<bo> {
    private RecommendForumLayout ajc;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ajc = new RecommendForumLayout(tbPageContext);
        this.ajc.setPageUniqueId(bdUniqueId);
        this.ajc.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ajc;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ajc.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ajc.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(bo boVar) {
        this.ajc.setData(boVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.ajc.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.ajc.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bn> fVar) {
        this.ajc.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.ajc.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.ajc.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.ajc.setShowSquareEntrance(z);
    }
}
