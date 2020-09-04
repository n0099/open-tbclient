package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class aa extends d implements o<com.baidu.tbadk.core.data.ar>, p {
    private static final int agb = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView agc;
    private Align agd;
    public boolean agf;

    public aa(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public aa(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.agc = new NEGFeedBackView(tbPageContext);
        this.agc.setId(R.id.decor_item_right_id);
        H(this.agc);
        a(align);
    }

    public void a(Align align) {
        if (this.agd != align) {
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
                this.agc.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agc.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.agc.setLayoutParams(layoutParams);
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
                this.agc.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agc.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.agc.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = agb;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.agc.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.agc.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.agc.setLayoutParams(layoutParams3);
            }
            this.agd = align;
        }
    }

    private void d(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.bcl()) {
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
            this.agc.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.agc.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.agc.setLayoutParams(layoutParams);
            return;
        }
        int i = agb;
        int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens6;
        layoutParams2.topMargin = dimens7;
        a(layoutParams2);
        this.agc.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
        this.agc.setPadding(dimens5, dimens5, dimens5, dimens5);
        this.agc.setLayoutParams(layoutParams2);
    }

    private void bq(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agc.getLayoutParams();
        if (this.agc.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimens3;
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.agc.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.agc.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.agc.setLayoutParams(layoutParams2);
        }
    }

    private boolean e(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport instanceof com.baidu.tieba.card.data.l) && ((com.baidu.tieba.card.data.l) absThreadDataSupport).eaS;
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcg() != null) {
            if (absThreadDataSupport.bcg().bdd() > 0 || absThreadDataSupport.bce() == null) {
                if (this.agf) {
                    tI();
                } else {
                    d(absThreadDataSupport);
                }
            } else if (absThreadDataSupport.bcl() || absThreadDataSupport.bcm()) {
                if (absThreadDataSupport.bci()) {
                    bq(aP((!e(absThreadDataSupport) || com.baidu.tbadk.a.d.bad()) ? R.dimen.tbds42 : R.dimen.tbds64));
                } else if (absThreadDataSupport.bcj()) {
                    if (this.afd != null) {
                        this.afd.a(this);
                    }
                } else {
                    a(Align.ALIGN_RIGHT_TOP);
                }
            } else {
                a(Align.ALIGN_RIGHT_BOTTOM);
            }
        }
    }

    private void tI() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = dimens2;
        layoutParams.topMargin = dimens3;
        a(layoutParams);
        this.agc.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
        this.agc.setPadding(0, 0, 0, 0);
        this.agc.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: tJ */
    public NEGFeedBackView tB() {
        return this.agc;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.agc.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.agc.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.agc.setHeadText(str);
    }

    public void aJ(boolean z) {
        this.agc.aJ(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(com.baidu.tbadk.core.data.ar arVar) {
        if (arVar == null) {
            this.agc.setVisibility(8);
            return;
        }
        this.agc.setData(arVar);
        this.agc.setFirstRowSingleColumn(true);
        this.agc.setVisibility(0);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agc.onChangeSkinType();
    }

    private int aP(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
