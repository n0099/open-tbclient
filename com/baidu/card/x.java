package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class x extends d implements n<com.baidu.tbadk.core.data.ak>, o {
    private static final int aet = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView aeu;
    private Align aev;

    public x(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public x(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.aeu = new NEGFeedBackView(tbPageContext);
        this.aeu.setId(R.id.decor_item_right_id);
        F(this.aeu);
        a(align);
    }

    public void a(Align align) {
        if (this.aev != align) {
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
                this.aeu.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                this.aeu.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.aeu.setLayoutParams(layoutParams);
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
                this.aeu.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                this.aeu.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.aeu.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = aet;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.aeu.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.aeu.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.aeu.setLayoutParams(layoutParams3);
            }
            this.aev = align;
        }
    }

    private void c(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.aOp()) {
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
            this.aeu.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
            this.aeu.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.aeu.setLayoutParams(layoutParams);
            return;
        }
        int i = aet;
        int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens6;
        layoutParams2.topMargin = dimens7;
        a(layoutParams2);
        this.aeu.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
        this.aeu.setPadding(dimens5, dimens5, dimens5, dimens5);
        this.aeu.setLayoutParams(layoutParams2);
    }

    private void bd(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aeu.getLayoutParams();
        if (this.aeu.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimens3;
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.aeu.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
            this.aeu.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.aeu.setLayoutParams(layoutParams2);
        }
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport instanceof com.baidu.tieba.card.data.k) && ((com.baidu.tieba.card.data.k) absThreadDataSupport).gHQ;
    }

    public void e(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aOk() != null) {
            if (absThreadDataSupport.aOk().aPd() > 0 || absThreadDataSupport.aOi() == null) {
                c(absThreadDataSupport);
            } else if (absThreadDataSupport.aOp()) {
                if (absThreadDataSupport.aOm()) {
                    bd(bb(d(absThreadDataSupport) ? R.dimen.tbds64 : R.dimen.tbds42));
                } else if (absThreadDataSupport.aOn()) {
                    if (this.adB != null) {
                        this.adB.a(this);
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
    /* renamed from: rE */
    public NEGFeedBackView rx() {
        return this.aeu;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.aeu.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.aeu.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.aeu.setHeadText(str);
    }

    public void aF(boolean z) {
        this.aeu.aF(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(com.baidu.tbadk.core.data.ak akVar) {
        if (akVar == null) {
            this.aeu.setVisibility(8);
            return;
        }
        this.aeu.setData(akVar);
        this.aeu.setFirstRowSingleColumn(true);
        this.aeu.setVisibility(0);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeu.onChangeSkinType();
    }

    private int bb(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
