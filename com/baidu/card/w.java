package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class w extends d implements m<com.baidu.tbadk.core.data.al>, n {
    private static final int adV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    NEGFeedBackView adW;

    public w(TbPageContext tbPageContext, boolean z) {
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(adV, adV);
        layoutParams.addRule(11);
        if (z) {
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        a(layoutParams);
        this.adW = new NEGFeedBackView(tbPageContext);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        this.adW.setPadding(dimens, dimens, dimens, dimens);
        F(this.adW);
    }

    public void bb(int i) {
        if (this.adW != null && (this.adW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adW.getLayoutParams();
            layoutParams.topMargin = i;
            this.adW.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: rv */
    public NEGFeedBackView rq() {
        return this.adW;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.adW.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.adW.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.adW.setHeadText(str);
    }

    public void aD(boolean z) {
        this.adW.aD(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            this.adW.setVisibility(8);
            return;
        }
        this.adW.setData(alVar);
        this.adW.setFirstRowSingleColumn(true);
        this.adW.setVisibility(0);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adW.onChangeSkinType();
    }
}
