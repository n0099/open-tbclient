package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class w extends d implements m<com.baidu.tbadk.core.data.al>, n {
    private static final int KD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    NEGFeedBackView KE;

    public w(TbPageContext tbPageContext, boolean z) {
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(KD, KD);
        layoutParams.addRule(11);
        if (z) {
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        a(layoutParams);
        this.KE = new NEGFeedBackView(tbPageContext);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        this.KE.setPadding(dimens, dimens, dimens, dimens);
        F(this.KE);
    }

    public void aL(int i) {
        if (this.KE != null && (this.KE.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.KE.getLayoutParams();
            layoutParams.topMargin = i;
            this.KE.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: mM */
    public NEGFeedBackView mJ() {
        return this.KE;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.KE.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.KE.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.KE.setHeadText(str);
    }

    public void ab(boolean z) {
        this.KE.ab(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            this.KE.setVisibility(8);
            return;
        }
        this.KE.setData(alVar);
        this.KE.setFirstRowSingleColumn(true);
        this.KE.setVisibility(0);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.KE.onChangeSkinType();
    }
}
