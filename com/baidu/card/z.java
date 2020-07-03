package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class z extends d implements n<com.baidu.tbadk.core.data.ap>, o {
    private static final int afa = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView afb;
    private Align afc;

    public z(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public z(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.afb = new NEGFeedBackView(tbPageContext);
        this.afb.setId(R.id.decor_item_right_id);
        F(this.afb);
        a(align);
    }

    public void a(Align align) {
        if (this.afc != align) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                a(layoutParams);
                this.afb.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                this.afb.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.afb.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens5, dimens5);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = dimens7;
                layoutParams2.bottomMargin = 0;
                a(layoutParams2);
                this.afb.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                this.afb.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.afb.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = afa;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.afb.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.afb.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.afb.setLayoutParams(layoutParams3);
            }
            this.afc = align;
        }
    }

    private void d(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.aPZ()) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            a(layoutParams);
            this.afb.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
            this.afb.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.afb.setLayoutParams(layoutParams);
            return;
        }
        int i = afa;
        int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens6;
        layoutParams2.topMargin = dimens7;
        a(layoutParams2);
        this.afb.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
        this.afb.setPadding(dimens5, dimens5, dimens5, dimens5);
        this.afb.setLayoutParams(layoutParams2);
    }

    private void bj(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afb.getLayoutParams();
        if (this.afb.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimens3;
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.afb.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
            this.afb.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.afb.setLayoutParams(layoutParams2);
        }
    }

    private boolean e(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport instanceof com.baidu.tieba.card.data.k) && ((com.baidu.tieba.card.data.k) absThreadDataSupport).gUQ;
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPU() != null) {
            if (absThreadDataSupport.aPU().aQO() > 0 || absThreadDataSupport.aPS() == null) {
                d(absThreadDataSupport);
            } else if (absThreadDataSupport.aPZ()) {
                if (absThreadDataSupport.aPW()) {
                    bj(bh(e(absThreadDataSupport) ? R.dimen.tbds64 : R.dimen.tbds42));
                } else if (absThreadDataSupport.aPX()) {
                    if (this.aef != null) {
                        this.aef.a(this);
                    }
                } else {
                    a(Align.ALIGN_RIGHT_TOP);
                }
            } else {
                a(Align.ALIGN_RIGHT_BOTTOM);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: rW */
    public NEGFeedBackView rO() {
        return this.afb;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.afb.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.afb.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.afb.setHeadText(str);
    }

    public void aG(boolean z) {
        this.afb.aG(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            this.afb.setVisibility(8);
            return;
        }
        this.afb.setData(apVar);
        this.afb.setFirstRowSingleColumn(true);
        this.afb.setVisibility(0);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afb.onChangeSkinType();
    }

    private int bh(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
