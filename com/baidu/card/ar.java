package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ar extends d implements p<by>, q {
    private static final int ahO = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    private Align ahQ;
    public UnfollowedDecorView ajp;

    public ar(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.ajp = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.ajp.setId(R.id.decor_item_right_id);
        H((View) this.ajp);
        a(align);
    }

    public void a(Align align) {
        if (align != this.ahQ) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams.topMargin = dimenPixelSize2;
                a(layoutParams);
                this.ajp.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ajp.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ajp.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams2.bottomMargin = 0;
                a(layoutParams2);
                this.ajp.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.ajp.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.ajp.setLayoutParams(layoutParams2);
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
                this.ajp.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
                this.ajp.setPadding(dimens, dimens, dimens, dimens);
                this.ajp.setLayoutParams(layoutParams3);
            }
            this.ahQ = align;
        }
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        if (aVar.isSupportTop()) {
            a(Align.ALIGN_RIGHT_TOP);
        } else if (aVar.isSupportBottom()) {
            if (this.agO != null) {
                this.agO.a(this);
            }
        } else {
            a(Align.ALIGN_RIGHT_TOP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(by byVar) {
        this.ajp.r(byVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajp.onChangeSkinType();
    }
}
