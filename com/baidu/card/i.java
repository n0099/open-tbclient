package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public class i extends d implements n<bk>, o {
    private FollowUserDecorView adH;
    private boolean adI = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public i(TbPageContext tbPageContext) {
        this.adH = new FollowUserDecorView(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        rA();
    }

    private void rA() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = bb(R.dimen.tbds50);
        a(layoutParams);
        F(this.adH);
    }

    public void setMarginRight(int i) {
        if (ru() != null) {
            ru().rightMargin = i;
        }
        this.adH.setLayoutParams(ru());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null) {
            this.adH.setVisibility(8);
            return;
        }
        setMarginRight(bb((this.adI && bkVar.aOp()) ? R.dimen.tbds104 : R.dimen.tbds44));
        this.adH.setVisibility(0);
        this.adH.setData(bkVar);
        this.adH.setTag(bkVar);
    }

    public void a(AbsThreadDataSupport absThreadDataSupport, boolean z) {
        this.adI = z;
        boolean aOr = absThreadDataSupport.aOr();
        setSvgIconResId(aOr ? R.drawable.icon_pure_add12_svg : 0);
        setClickableUnLike(aOr ? false : true);
    }

    private int bb(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adH.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.adH.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.adH.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.adH.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.adH.setClickableUnLike(z);
    }
}
