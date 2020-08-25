package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes15.dex */
public class i extends d implements o<bw>, p {
    private FollowUserDecorView afh;
    private boolean afi = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public i(TbPageContext tbPageContext, boolean z) {
        this.afh = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.afh.setUseNewStyle(z);
        setInsertIndex(-1);
        aG(z);
    }

    private void aG(boolean z) {
        if (z) {
            this.mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds76);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = aP(R.dimen.tbds50);
        if (z) {
            layoutParams.topMargin = aP(R.dimen.tbds52);
        }
        a(layoutParams);
        H(this.afh);
    }

    public void setMarginRight(int i) {
        if (ty() != null) {
            ty().rightMargin = i;
        }
        this.afh.setLayoutParams(ty());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bw bwVar) {
        if (bwVar == null || bwVar.beE() == null) {
            this.afh.setVisibility(8);
            return;
        }
        setMarginRight(aP(this.afi ? R.dimen.tbds120 : R.dimen.tbds44));
        this.afh.setVisibility(0);
        this.afh.setData(bwVar);
        this.afh.setTag(bwVar);
    }

    public void a(AbsThreadDataSupport absThreadDataSupport, boolean z) {
        this.afi = z;
        setSvgIconResId(0);
        setClickableUnLike(true);
    }

    private int aP(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afh.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afh.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.afh.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.afh.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.afh.setClickableUnLike(z);
    }
}
