package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class aq extends d implements o<bw>, p {
    private static final int afZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    private Align agb;
    public UnfollowedDecorView ahy;

    public aq(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.ahy = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.ahy.setId(R.id.decor_item_right_id);
        H(this.ahy);
        a(align);
    }

    public void a(Align align) {
        if (align != this.agb) {
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
                this.ahy.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.ahy.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.ahy.setLayoutParams(layoutParams);
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
                this.ahy.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.ahy.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.ahy.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = afZ;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.ahy.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.ahy.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.ahy.setLayoutParams(layoutParams3);
            }
            this.agb = align;
        }
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.bci()) {
            a(Align.ALIGN_RIGHT_TOP);
        } else if (absThreadDataSupport.bcj()) {
            if (this.afb != null) {
                this.afb.a(this);
            }
        } else {
            a(Align.ALIGN_RIGHT_TOP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bw bwVar) {
        this.ahy.q(bwVar);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahy.onChangeSkinType();
    }
}
