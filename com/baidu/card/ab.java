package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ab extends d implements p<com.baidu.tbadk.core.data.at>, q {
    private static final int ahO = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView ahP;
    private Align ahQ;
    public boolean ahR;

    public ab(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public ab(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.ahP = new NEGFeedBackView(tbPageContext);
        this.ahP.setId(R.id.decor_item_right_id);
        H((View) this.ahP);
        a(align);
    }

    public void a(Align align) {
        if (this.ahQ != align) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams.topMargin = dimenPixelSize2;
                a(layoutParams);
                this.ahP.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ahP.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ahP.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams2.bottomMargin = 0;
                a(layoutParams2);
                this.ahP.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ahP.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ahP.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = ahO;
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens2;
                layoutParams3.bottomMargin = dimens3;
                a(layoutParams3);
                this.ahP.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
                this.ahP.setPadding(dimens, dimens, dimens, dimens);
                this.ahP.setLayoutParams(layoutParams3);
            }
            this.ahQ = align;
        }
    }

    private void e(com.baidu.tbadk.core.data.a aVar) {
        if (aVar.bmt()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams.topMargin = dimenPixelSize2;
            a(layoutParams);
            this.ahP.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.ahP.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.ahP.setLayoutParams(layoutParams);
            return;
        }
        int i = ahO;
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.topMargin = dimens3;
        a(layoutParams2);
        this.ahP.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
        this.ahP.setPadding(dimens, dimens, dimens, dimens);
        this.ahP.setLayoutParams(layoutParams2);
    }

    private void by(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahP.getLayoutParams();
        if (this.ahP.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.ahP.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.ahP.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.ahP.setLayoutParams(layoutParams2);
        }
    }

    private boolean f(com.baidu.tbadk.core.data.a aVar) {
        return (aVar instanceof com.baidu.tieba.card.data.k) && ((com.baidu.tieba.card.data.k) aVar).eIO;
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bmp() != null) {
            if (aVar.bmp().bno() > 0 || aVar.bmn() == null) {
                if (this.ahR) {
                    tQ();
                } else {
                    e(aVar);
                }
            } else if (aVar.bmt() || aVar.bmu()) {
                if (aVar.isSupportTop()) {
                    by((!f(aVar) || com.baidu.tbadk.a.d.bkq()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds60) : getDimens(R.dimen.tbds64));
                } else if (aVar.isSupportBottom()) {
                    if (this.agO != null) {
                        this.agO.a(this);
                    }
                } else {
                    a(Align.ALIGN_RIGHT_TOP);
                }
            } else {
                a(Align.ALIGN_RIGHT_BOTTOM);
            }
        }
    }

    private void tQ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds57);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = dimens2;
        layoutParams.topMargin = dimens3;
        a(layoutParams);
        this.ahP.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
        this.ahP.setPadding(0, 0, 0, 0);
        this.ahP.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: tR */
    public NEGFeedBackView tJ() {
        return this.ahP;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.ahP.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.ahP.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.ahP.setHeadText(str);
    }

    public void aJ(boolean z) {
        this.ahP.aJ(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(com.baidu.tbadk.core.data.at atVar) {
        if (atVar == null) {
            this.ahP.setVisibility(8);
            return;
        }
        this.ahP.setData(atVar);
        this.ahP.setFirstRowSingleColumn(true);
        this.ahP.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahP.onChangeSkinType();
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
