package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class w extends d implements m<com.baidu.tbadk.core.data.al>, n {
    private static final int KY = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    NEGFeedBackView KZ;

    public w(TbPageContext tbPageContext, boolean z) {
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(KY, KY);
        layoutParams.addRule(11);
        if (z) {
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        a(layoutParams);
        this.KZ = new NEGFeedBackView(tbPageContext);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        this.KZ.setPadding(dimens, dimens, dimens, dimens);
        F(this.KZ);
    }

    public void aP(int i) {
        if (this.KZ != null && (this.KZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.KZ.getLayoutParams();
            layoutParams.topMargin = i;
            this.KZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.d
    /* renamed from: nc */
    public NEGFeedBackView mY() {
        return this.KZ;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.KZ.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.KZ.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.KZ.setHeadText(str);
    }

    public void ae(boolean z) {
        this.KZ.ae(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            this.KZ.setVisibility(8);
            return;
        }
        this.KZ.setData(alVar);
        this.KZ.setFirstRowSingleColumn(true);
        this.KZ.setVisibility(0);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.KZ.onChangeSkinType();
    }
}
