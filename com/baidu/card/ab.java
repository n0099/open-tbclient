package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ab extends c implements p<av>, q {
    private static final int ahx = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public boolean ahA;
    public NEGFeedBackView ahy;
    private Align ahz;

    public ab(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public ab(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.ahy = new NEGFeedBackView(tbPageContext);
        this.ahy.setId(R.id.decor_item_right_id);
        H(this.ahy);
        a(align);
    }

    public void a(Align align) {
        if (this.ahz != align) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams.topMargin = dimenPixelSize2;
                a(layoutParams);
                this.ahy.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ahy.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ahy.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams2.bottomMargin = 0;
                a(layoutParams2);
                this.ahy.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ahy.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ahy.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = ahx;
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens2;
                layoutParams3.bottomMargin = dimens3;
                a(layoutParams3);
                this.ahy.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
                this.ahy.setPadding(dimens, dimens, dimens, dimens);
                this.ahy.setLayoutParams(layoutParams3);
            }
            this.ahz = align;
        }
    }

    private void e(com.baidu.tbadk.core.data.a aVar) {
        if (aVar.blt()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams.topMargin = dimenPixelSize2;
            a(layoutParams);
            this.ahy.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.ahy.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.ahy.setLayoutParams(layoutParams);
            return;
        }
        int i = ahx;
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.topMargin = dimens3;
        a(layoutParams2);
        this.ahy.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
        this.ahy.setPadding(dimens, dimens, dimens, dimens);
        this.ahy.setLayoutParams(layoutParams2);
    }

    private void bw(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahy.getLayoutParams();
        if (this.ahy.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.ahy.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.ahy.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.ahy.setLayoutParams(layoutParams2);
        }
    }

    private boolean f(com.baidu.tbadk.core.data.a aVar) {
        return (aVar instanceof com.baidu.tieba.card.data.k) && ((com.baidu.tieba.card.data.k) aVar).eQi;
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.blp() != null) {
            if (aVar.blp().bmn() > 0 || aVar.bln() == null) {
                if (this.ahA) {
                    ta();
                } else {
                    e(aVar);
                }
            } else if (aVar.blt() || aVar.blu()) {
                if (aVar.isSupportTop()) {
                    bw((!f(aVar) || com.baidu.tbadk.a.d.biX()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds60) : getDimens(R.dimen.tbds64));
                } else if (aVar.isSupportBottom()) {
                    if (this.ago != null) {
                        this.ago.a(this);
                    }
                } else {
                    a(Align.ALIGN_RIGHT_TOP);
                }
            } else {
                a(Align.ALIGN_RIGHT_BOTTOM);
            }
        }
    }

    private void ta() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds57);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = dimens2;
        layoutParams.topMargin = dimens3;
        a(layoutParams);
        this.ahy.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
        this.ahy.setPadding(0, 0, 0, 0);
        this.ahy.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.c
    /* renamed from: tb */
    public NEGFeedBackView sT() {
        return this.ahy;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.ahy.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.ahy.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.ahy.setHeadText(str);
    }

    public void aI(boolean z) {
        this.ahy.aI(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(av avVar) {
        if (avVar == null) {
            this.ahy.setVisibility(8);
            return;
        }
        this.ahy.setData(avVar);
        this.ahy.setFirstRowSingleColumn(true);
        this.ahy.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahy.onChangeSkinType();
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
