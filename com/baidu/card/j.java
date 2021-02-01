package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes.dex */
public class j extends c implements p<cb>, q {
    private FollowUserDecorView agH;
    private boolean agI = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public j(TbPageContext tbPageContext, boolean z) {
        this.agH = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.agH.setUseNewStyle(z);
        setInsertIndex(-1);
        aE(z);
    }

    private void aE(boolean z) {
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
        H(this.agH);
    }

    public void setMarginRight(int i) {
        if (sQ() != null) {
            sQ().rightMargin = i;
        }
        this.agH.setLayoutParams(sQ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(cb cbVar) {
        if (cbVar == null || cbVar.bnQ() == null) {
            this.agH.setVisibility(8);
            return;
        }
        setMarginRight(getDimens(this.agI ? R.dimen.tbds120 : R.dimen.tbds44));
        this.agH.setVisibility(0);
        this.agH.setData(cbVar);
        this.agH.setTag(cbVar);
    }

    public void a(com.baidu.tbadk.core.data.a aVar, boolean z) {
        this.agI = z;
        setSvgIconResId(0);
        setClickableUnLike(true);
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agH.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agH.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.agH.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.agH.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.agH.setClickableUnLike(z);
    }
}
