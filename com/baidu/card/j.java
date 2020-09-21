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
/* loaded from: classes20.dex */
public class j extends d implements p<bw>, q {
    private FollowUserDecorView afC;
    private boolean afD = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public j(TbPageContext tbPageContext, boolean z) {
        this.afC = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.afC.setUseNewStyle(z);
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
        layoutParams.topMargin = aT(R.dimen.tbds50);
        if (z) {
            layoutParams.topMargin = aT(R.dimen.tbds52);
        }
        a(layoutParams);
        H(this.afC);
    }

    public void setMarginRight(int i) {
        if (tD() != null) {
            tD().rightMargin = i;
        }
        this.afC.setLayoutParams(tD());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(bw bwVar) {
        if (bwVar == null || bwVar.bfy() == null) {
            this.afC.setVisibility(8);
            return;
        }
        setMarginRight(aT(this.afD ? R.dimen.tbds120 : R.dimen.tbds44));
        this.afC.setVisibility(0);
        this.afC.setData(bwVar);
        this.afC.setTag(bwVar);
    }

    public void a(AbsThreadDataSupport absThreadDataSupport, boolean z) {
        this.afD = z;
        setSvgIconResId(0);
        setClickableUnLike(true);
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afC.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afC.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.afC.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.afC.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.afC.setClickableUnLike(z);
    }
}
