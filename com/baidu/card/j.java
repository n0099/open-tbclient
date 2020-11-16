package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes20.dex */
public class j extends d implements p<bx>, q {
    private FollowUserDecorView afZ;
    private boolean aga = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public j(TbPageContext tbPageContext, boolean z) {
        this.afZ = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.afZ.setUseNewStyle(z);
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
        layoutParams.topMargin = getDimens(R.dimen.tbds50);
        if (z) {
            layoutParams.topMargin = getDimens(R.dimen.tbds52);
        }
        a(layoutParams);
        H((View) this.afZ);
    }

    public void setMarginRight(int i) {
        if (tD() != null) {
            tD().rightMargin = i;
        }
        this.afZ.setLayoutParams(tD());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bx bxVar) {
        if (bxVar == null || bxVar.blC() == null) {
            this.afZ.setVisibility(8);
            return;
        }
        setMarginRight(getDimens(this.aga ? R.dimen.tbds120 : R.dimen.tbds44));
        this.afZ.setVisibility(0);
        this.afZ.setData(bxVar);
        this.afZ.setTag(bxVar);
    }

    public void a(com.baidu.tbadk.core.data.a aVar, boolean z) {
        this.aga = z;
        setSvgIconResId(0);
        setClickableUnLike(true);
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afZ.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afZ.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.afZ.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.afZ.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.afZ.setClickableUnLike(z);
    }
}
