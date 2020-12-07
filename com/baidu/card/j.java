package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes21.dex */
public class j extends d implements p<by>, q {
    private FollowUserDecorView agY;
    private boolean agZ = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public j(TbPageContext tbPageContext, boolean z) {
        this.agY = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.agY.setUseNewStyle(z);
        setInsertIndex(-1);
        aF(z);
    }

    private void aF(boolean z) {
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
        H((View) this.agY);
    }

    public void setMarginRight(int i) {
        if (tG() != null) {
            tG().rightMargin = i;
        }
        this.agY.setLayoutParams(tG());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(by byVar) {
        if (byVar == null || byVar.boP() == null) {
            this.agY.setVisibility(8);
            return;
        }
        setMarginRight(getDimens(this.agZ ? R.dimen.tbds120 : R.dimen.tbds44));
        this.agY.setVisibility(0);
        this.agY.setData(byVar);
        this.agY.setTag(byVar);
    }

    public void a(com.baidu.tbadk.core.data.a aVar, boolean z) {
        this.agZ = z;
        setSvgIconResId(0);
        setClickableUnLike(true);
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agY.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agY.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.agY.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.agY.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.agY.setClickableUnLike(z);
    }
}
