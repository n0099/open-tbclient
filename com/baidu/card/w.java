package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class w extends d implements m<com.baidu.tbadk.core.data.al>, n {
    private static final int adY = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    NEGFeedBackView adZ;

    public w(TbPageContext tbPageContext, boolean z) {
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(adY, adY);
        layoutParams.addRule(11);
        if (z) {
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        a(layoutParams);
        this.adZ = new NEGFeedBackView(tbPageContext);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        this.adZ.setPadding(dimens, dimens, dimens, dimens);
        F(this.adZ);
    }

    public void bb(int i) {
        if (this.adZ != null && (this.adZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adZ.getLayoutParams();
            layoutParams.topMargin = i;
            this.adZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: rv */
    public NEGFeedBackView rq() {
        return this.adZ;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.adZ.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.adZ.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.adZ.setHeadText(str);
    }

    public void aD(boolean z) {
        this.adZ.aD(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void B(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            this.adZ.setVisibility(8);
            return;
        }
        this.adZ.setData(alVar);
        this.adZ.setFirstRowSingleColumn(true);
        this.adZ.setVisibility(0);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adZ.onChangeSkinType();
    }
}
