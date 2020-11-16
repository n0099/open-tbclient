package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ab extends d implements p<com.baidu.tbadk.core.data.as>, q {
    private static final int agP = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView agQ;
    private Align agR;
    public boolean agS;

    public ab(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public ab(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.agQ = new NEGFeedBackView(tbPageContext);
        this.agQ.setId(R.id.decor_item_right_id);
        H((View) this.agQ);
        a(align);
    }

    public void a(Align align) {
        if (this.agR != align) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams.topMargin = dimenPixelSize2;
                a(layoutParams);
                this.agQ.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.agQ.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.agQ.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams2.bottomMargin = 0;
                a(layoutParams2);
                this.agQ.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.agQ.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.agQ.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = agP;
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens2;
                layoutParams3.bottomMargin = dimens3;
                a(layoutParams3);
                this.agQ.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
                this.agQ.setPadding(dimens, dimens, dimens, dimens);
                this.agQ.setLayoutParams(layoutParams3);
            }
            this.agR = align;
        }
    }

    private void e(com.baidu.tbadk.core.data.a aVar) {
        if (aVar.bjj()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams.topMargin = dimenPixelSize2;
            a(layoutParams);
            this.agQ.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.agQ.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.agQ.setLayoutParams(layoutParams);
            return;
        }
        int i = agP;
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.topMargin = dimens3;
        a(layoutParams2);
        this.agQ.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
        this.agQ.setPadding(dimens, dimens, dimens, dimens);
        this.agQ.setLayoutParams(layoutParams2);
    }

    private void bu(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agQ.getLayoutParams();
        if (this.agQ.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.agQ.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.agQ.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.agQ.setLayoutParams(layoutParams2);
        }
    }

    private boolean f(com.baidu.tbadk.core.data.a aVar) {
        return (aVar instanceof com.baidu.tieba.card.data.k) && ((com.baidu.tieba.card.data.k) aVar).eBN;
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bjf() != null) {
            if (aVar.bjf().bkb() > 0 || aVar.bjd() == null) {
                if (this.agS) {
                    tN();
                } else {
                    e(aVar);
                }
            } else if (aVar.bjj() || aVar.bjk()) {
                if (aVar.isSupportTop()) {
                    bu((!f(aVar) || com.baidu.tbadk.a.d.bhm()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds60) : getDimens(R.dimen.tbds64));
                } else if (aVar.isSupportBottom()) {
                    if (this.afS != null) {
                        this.afS.a(this);
                    }
                } else {
                    a(Align.ALIGN_RIGHT_TOP);
                }
            } else {
                a(Align.ALIGN_RIGHT_BOTTOM);
            }
        }
    }

    private void tN() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds57);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = dimens2;
        layoutParams.topMargin = dimens3;
        a(layoutParams);
        this.agQ.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
        this.agQ.setPadding(0, 0, 0, 0);
        this.agQ.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: tO */
    public NEGFeedBackView tG() {
        return this.agQ;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.agQ.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.agQ.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.agQ.setHeadText(str);
    }

    public void aK(boolean z) {
        this.agQ.aK(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(com.baidu.tbadk.core.data.as asVar) {
        if (asVar == null) {
            this.agQ.setVisibility(8);
            return;
        }
        this.agQ.setData(asVar);
        this.agQ.setFirstRowSingleColumn(true);
        this.agQ.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agQ.onChangeSkinType();
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
