package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class w extends d implements m<com.baidu.tbadk.core.data.al>, n {
    private static final int Kx = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    NEGFeedBackView Ky;

    public w(TbPageContext tbPageContext, boolean z) {
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Kx, Kx);
        layoutParams.addRule(11);
        if (z) {
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        a(layoutParams);
        this.Ky = new NEGFeedBackView(tbPageContext);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        this.Ky.setPadding(dimens, dimens, dimens, dimens);
        F(this.Ky);
    }

    public void aL(int i) {
        if (this.Ky != null && (this.Ky.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ky.getLayoutParams();
            layoutParams.topMargin = i;
            this.Ky.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: mL */
    public NEGFeedBackView mJ() {
        return this.Ky;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.Ky.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.Ky.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.Ky.setHeadText(str);
    }

    public void ab(boolean z) {
        this.Ky.ab(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            this.Ky.setVisibility(8);
            return;
        }
        this.Ky.setData(alVar);
        this.Ky.setFirstRowSingleColumn(true);
        this.Ky.setVisibility(0);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Ky.onChangeSkinType();
    }
}
