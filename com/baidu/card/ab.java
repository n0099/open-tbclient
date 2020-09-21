package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ab extends d implements p<com.baidu.tbadk.core.data.ar>, q {
    private static final int agv = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView agw;
    private Align agx;
    public boolean agy;

    public ab(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public ab(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.agw = new NEGFeedBackView(tbPageContext);
        this.agw.setId(R.id.decor_item_right_id);
        H(this.agw);
        a(align);
    }

    public void a(Align align) {
        if (this.agx != align) {
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
                this.agw.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agw.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.agw.setLayoutParams(layoutParams);
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
                this.agw.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agw.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.agw.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = agv;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.agw.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.agw.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.agw.setLayoutParams(layoutParams3);
            }
            this.agx = align;
        }
    }

    private void e(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.bdf()) {
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
            this.agw.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.agw.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.agw.setLayoutParams(layoutParams);
            return;
        }
        int i = agv;
        int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens6;
        layoutParams2.topMargin = dimens7;
        a(layoutParams2);
        this.agw.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
        this.agw.setPadding(dimens5, dimens5, dimens5, dimens5);
        this.agw.setLayoutParams(layoutParams2);
    }

    private void bu(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agw.getLayoutParams();
        if (this.agw.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimens3;
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.agw.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.agw.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.agw.setLayoutParams(layoutParams2);
        }
    }

    private boolean f(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport instanceof com.baidu.tieba.card.data.l) && ((com.baidu.tieba.card.data.l) absThreadDataSupport).edc;
    }

    public void g(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bda() != null) {
            if (absThreadDataSupport.bda().bdX() > 0 || absThreadDataSupport.bcY() == null) {
                if (this.agy) {
                    tN();
                } else {
                    e(absThreadDataSupport);
                }
            } else if (absThreadDataSupport.bdf() || absThreadDataSupport.bdg()) {
                if (absThreadDataSupport.bdc()) {
                    bu(aT((!f(absThreadDataSupport) || com.baidu.tbadk.a.d.baT()) ? R.dimen.tbds42 : R.dimen.tbds64));
                } else if (absThreadDataSupport.bdd()) {
                    if (this.afv != null) {
                        this.afv.a(this);
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
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = dimens2;
        layoutParams.topMargin = dimens3;
        a(layoutParams);
        this.agw.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
        this.agw.setPadding(0, 0, 0, 0);
        this.agw.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: tO */
    public NEGFeedBackView tG() {
        return this.agw;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.agw.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.agw.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.agw.setHeadText(str);
    }

    public void aJ(boolean z) {
        this.agw.aJ(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(com.baidu.tbadk.core.data.ar arVar) {
        if (arVar == null) {
            this.agw.setVisibility(8);
            return;
        }
        this.agw.setData(arVar);
        this.agw.setFirstRowSingleColumn(true);
        this.agw.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agw.onChangeSkinType();
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
