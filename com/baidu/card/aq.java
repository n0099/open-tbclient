package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aq extends c implements p<bz>, q {
    private static final int ahJ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    private Align ahL;
    public UnfollowedDecorView ajj;

    public aq(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.ajj = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.ajj.setId(R.id.decor_item_right_id);
        H(this.ajj);
        a(align);
    }

    public void a(Align align) {
        if (align != this.ahL) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams.topMargin = dimenPixelSize2;
                a(layoutParams);
                this.ajj.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ajj.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ajj.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams2.bottomMargin = 0;
                a(layoutParams2);
                this.ajj.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ajj.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ajj.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = ahJ;
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens2;
                layoutParams3.bottomMargin = dimens3;
                a(layoutParams3);
                this.ajj.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
                this.ajj.setPadding(dimens, dimens, dimens, dimens);
                this.ajj.setLayoutParams(layoutParams3);
            }
            this.ahL = align;
        }
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        if (aVar.isSupportTop()) {
            a(Align.ALIGN_RIGHT_TOP);
        } else if (aVar.isSupportBottom()) {
            if (this.agw != null) {
                this.agw.a(this);
            }
        } else {
            a(Align.ALIGN_RIGHT_TOP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(bz bzVar) {
        this.ajj.r(bzVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajj.onChangeSkinType();
    }
}
