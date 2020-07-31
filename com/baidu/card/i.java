package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes15.dex */
public class i extends d implements n<bv>, o {
    private FollowUserDecorView aeb;
    private boolean aec = true;
    private int mWidth = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    private int mHeight = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public i(TbPageContext tbPageContext, boolean z) {
        this.aeb = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.aeb.setUseNewStyle(z);
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
        layoutParams.topMargin = bj(R.dimen.tbds50);
        if (z) {
            layoutParams.topMargin = bj(R.dimen.tbds52);
        }
        a(layoutParams);
        H(this.aeb);
    }

    public void setMarginRight(int i) {
        if (rN() != null) {
            rN().rightMargin = i;
        }
        this.aeb.setLayoutParams(rN());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bv bvVar) {
        if (bvVar == null || bvVar.aWl() == null) {
            this.aeb.setVisibility(8);
            return;
        }
        setMarginRight(bj(this.aec ? R.dimen.tbds120 : R.dimen.tbds44));
        this.aeb.setVisibility(0);
        this.aeb.setData(bvVar);
        this.aeb.setTag(bvVar);
    }

    public void a(AbsThreadDataSupport absThreadDataSupport, boolean z) {
        this.aec = z;
        setSvgIconResId(0);
        setClickableUnLike(true);
    }

    private int bj(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeb.onChangeSkinType(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aeb.setPageUniqueId(bdUniqueId);
    }

    public void setOnClickEvent(FollowUserButton.a aVar) {
        this.aeb.setOnClickEvent(aVar);
    }

    public void setSvgIconResId(int i) {
        this.aeb.setSvgIconResId(i);
    }

    public void setClickableUnLike(boolean z) {
        this.aeb.setClickableUnLike(z);
    }
}
