package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class q extends h {
    private static final int TOP_MARGIN = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private ItemCardView aer;

    public q(Context context) {
        super(context);
        this.aer = new ItemCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().aYo() != null) {
            this.aer.setVisibility(0);
            this.aer.setData(absThreadDataSupport.aTN().aYo(), 13);
            return;
        }
        this.aer.setVisibility(8);
    }

    public void rV() {
        setTopMargin(TOP_MARGIN);
        bi(0);
        a(this.aer, TOP_MARGIN, 0);
    }

    private void a(View view, int i, int i2) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i || marginLayoutParams.bottomMargin != i2) {
                marginLayoutParams.topMargin = i;
                marginLayoutParams.bottomMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aer.onChangeSkinType();
    }
}
