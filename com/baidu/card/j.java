package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes21.dex */
public class j extends d implements p<bw>, q {
    private FollowUserDecorView afU;
    private boolean afV = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public j(TbPageContext tbPageContext, boolean z) {
        this.afU = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.afU.setUseNewStyle(z);
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
        H((View) this.afU);
    }

    public void setMarginRight(int i) {
        if (tD() != null) {
            tD().rightMargin = i;
        }
        this.afU.setLayoutParams(tD());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bw bwVar) {
        if (bwVar == null || bwVar.bka() == null) {
            this.afU.setVisibility(8);
            return;
        }
        setMarginRight(aT(this.afV ? R.dimen.tbds120 : R.dimen.tbds44));
        this.afU.setVisibility(0);
        this.afU.setData(bwVar);
        this.afU.setTag(bwVar);
    }

    public void a(AbsThreadDataSupport absThreadDataSupport, boolean z) {
        this.afV = z;
        setSvgIconResId(0);
        setClickableUnLike(true);
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afU.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afU.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.afU.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.afU.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.afU.setClickableUnLike(z);
    }
}
