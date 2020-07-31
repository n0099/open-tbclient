package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ap extends d implements n<bv>, o {
    private static final int aeQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    private Align aeS;
    public UnfollowedDecorView agq;

    public ap(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.agq = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.agq.setId(R.id.decor_item_right_id);
        H(this.agq);
        a(align);
    }

    public void a(Align align) {
        if (align != this.aeS) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                a(layoutParams);
                this.agq.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agq.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.agq.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens5, dimens5);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = dimens7;
                layoutParams2.bottomMargin = 0;
                a(layoutParams2);
                this.agq.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agq.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.agq.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = aeQ;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.agq.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.agq.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.agq.setLayoutParams(layoutParams3);
            }
            this.aeS = align;
        }
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.aTR()) {
            a(Align.ALIGN_RIGHT_TOP);
        } else if (absThreadDataSupport.aTS()) {
            if (this.adV != null) {
                this.adV.a(this);
            }
        } else {
            a(Align.ALIGN_RIGHT_TOP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bv bvVar) {
        this.agq.q(bvVar);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agq.onChangeSkinType();
    }
}
