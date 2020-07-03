package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public class i extends d implements n<bu>, o {
    private FollowUserDecorView ael;
    private boolean aem = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public i(TbPageContext tbPageContext) {
        this.ael = new FollowUserDecorView(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        rR();
    }

    private void rR() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = bh(R.dimen.tbds50);
        a(layoutParams);
        F(this.ael);
    }

    public void setMarginRight(int i) {
        if (rL() != null) {
            rL().rightMargin = i;
        }
        this.ael.setLayoutParams(rL());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bu buVar) {
        if (buVar == null || buVar.aSp() == null) {
            this.ael.setVisibility(8);
            return;
        }
        setMarginRight(bh((this.aem && buVar.aPZ()) ? R.dimen.tbds104 : R.dimen.tbds44));
        this.ael.setVisibility(0);
        this.ael.setData(buVar);
        this.ael.setTag(buVar);
    }

    public void a(AbsThreadDataSupport absThreadDataSupport, boolean z) {
        this.aem = z;
        boolean aQb = absThreadDataSupport.aQb();
        setSvgIconResId(aQb ? R.drawable.icon_pure_add12_svg : 0);
        setClickableUnLike(aQb ? false : true);
    }

    private int bh(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ael.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ael.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.ael.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.ael.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.ael.setClickableUnLike(z);
    }
}
