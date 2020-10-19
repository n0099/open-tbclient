package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ab extends d implements p<com.baidu.tbadk.core.data.ar>, q {
    private static final int agM = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView agN;
    private Align agO;
    public boolean agP;

    public ab(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public ab(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.agN = new NEGFeedBackView(tbPageContext);
        this.agN.setId(R.id.decor_item_right_id);
        H((View) this.agN);
        a(align);
    }

    public void a(Align align) {
        if (this.agO != align) {
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
                this.agN.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agN.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.agN.setLayoutParams(layoutParams);
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
                this.agN.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.agN.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.agN.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = agM;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.agN.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.agN.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.agN.setLayoutParams(layoutParams3);
            }
            this.agO = align;
        }
    }

    private void e(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.bfO()) {
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
            this.agN.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.agN.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.agN.setLayoutParams(layoutParams);
            return;
        }
        int i = agM;
        int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens6;
        layoutParams2.topMargin = dimens7;
        a(layoutParams2);
        this.agN.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
        this.agN.setPadding(dimens5, dimens5, dimens5, dimens5);
        this.agN.setLayoutParams(layoutParams2);
    }

    private void bu(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agN.getLayoutParams();
        if (this.agN.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimens3;
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.agN.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.agN.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.agN.setLayoutParams(layoutParams2);
        }
    }

    private boolean f(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport instanceof com.baidu.tieba.card.data.l) && ((com.baidu.tieba.card.data.l) absThreadDataSupport).eph;
    }

    public void g(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfI() != null) {
            if (absThreadDataSupport.bfI().bgG() > 0 || absThreadDataSupport.bfG() == null) {
                if (this.agP) {
                    tN();
                } else {
                    e(absThreadDataSupport);
                }
            } else if (absThreadDataSupport.bfO() || absThreadDataSupport.bfP()) {
                if (absThreadDataSupport.bfK()) {
                    bu(aT((!f(absThreadDataSupport) || com.baidu.tbadk.a.d.bdB()) ? R.dimen.tbds42 : R.dimen.tbds64));
                } else if (absThreadDataSupport.bfL()) {
                    if (this.afM != null) {
                        this.afM.a(this);
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
        this.agN.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
        this.agN.setPadding(0, 0, 0, 0);
        this.agN.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: tO */
    public NEGFeedBackView tG() {
        return this.agN;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.agN.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.agN.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.agN.setHeadText(str);
    }

    public void aJ(boolean z) {
        this.agN.aJ(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(com.baidu.tbadk.core.data.ar arVar) {
        if (arVar == null) {
            this.agN.setVisibility(8);
            return;
        }
        this.agN.setData(arVar);
        this.agN.setFirstRowSingleColumn(true);
        this.agN.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agN.onChangeSkinType();
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
