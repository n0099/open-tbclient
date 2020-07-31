package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class z extends d implements n<com.baidu.tbadk.core.data.aq>, o {
    private static final int aeQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public NEGFeedBackView aeR;
    private Align aeS;
    public boolean aeT;

    public z(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public z(TbPageContext tbPageContext, Align align) {
        setInsertIndex(-1);
        this.aeR = new NEGFeedBackView(tbPageContext);
        this.aeR.setId(R.id.decor_item_right_id);
        H(this.aeR);
        a(align);
    }

    public void a(Align align) {
        if (this.aeS != align) {
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
                this.aeR.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.aeR.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.aeR.setLayoutParams(layoutParams);
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
                this.aeR.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                this.aeR.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.aeR.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                int i = aeQ;
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = dimens9;
                layoutParams3.bottomMargin = dimens10;
                a(layoutParams3);
                this.aeR.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                this.aeR.setPadding(dimens8, dimens8, dimens8, dimens8);
                this.aeR.setLayoutParams(layoutParams3);
            }
            this.aeS = align;
        }
    }

    private void d(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.aTU()) {
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
            this.aeR.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.aeR.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.aeR.setLayoutParams(layoutParams);
            return;
        }
        int i = aeQ;
        int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = dimens6;
        layoutParams2.topMargin = dimens7;
        a(layoutParams2);
        this.aeR.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
        this.aeR.setPadding(dimens5, dimens5, dimens5, dimens5);
        this.aeR.setLayoutParams(layoutParams2);
    }

    private void bl(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aeR.getLayoutParams();
        if (this.aeR.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimens3;
            layoutParams2.topMargin = i;
            a(layoutParams2);
            this.aeR.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            this.aeR.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.aeR.setLayoutParams(layoutParams2);
        }
    }

    private boolean e(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport instanceof com.baidu.tieba.card.data.k) && ((com.baidu.tieba.card.data.k) absThreadDataSupport).hau;
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTP() != null) {
            if (absThreadDataSupport.aTP().aUK() > 0 || absThreadDataSupport.aTN() == null) {
                if (this.aeT) {
                    rX();
                } else {
                    d(absThreadDataSupport);
                }
            } else if (absThreadDataSupport.aTU() || absThreadDataSupport.aTV()) {
                if (absThreadDataSupport.aTR()) {
                    bl(bj((!e(absThreadDataSupport) || com.baidu.tbadk.a.d.aRL()) ? R.dimen.tbds42 : R.dimen.tbds64));
                } else if (absThreadDataSupport.aTS()) {
                    if (this.adV != null) {
                        this.adV.a(this);
                    }
                } else {
                    a(Align.ALIGN_RIGHT_TOP);
                }
            } else {
                a(Align.ALIGN_RIGHT_BOTTOM);
            }
        }
    }

    private void rX() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = dimens2;
        layoutParams.topMargin = dimens3;
        a(layoutParams);
        this.aeR.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
        this.aeR.setPadding(0, 0, 0, 0);
        this.aeR.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: rY */
    public NEGFeedBackView rQ() {
        return this.aeR;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.aeR.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.aeR.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.aeR.setHeadText(str);
    }

    public void aI(boolean z) {
        this.aeR.aI(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar == null) {
            this.aeR.setVisibility(8);
            return;
        }
        this.aeR.setData(aqVar);
        this.aeR.setFirstRowSingleColumn(true);
        this.aeR.setVisibility(0);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeR.onChangeSkinType();
    }

    private int bj(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
