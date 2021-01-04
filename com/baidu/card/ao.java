package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ao extends h {
    private ItemCardView aib;
    private FrameLayout ajW;

    public ao(Context context) {
        super(context);
        c(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.ajW == null) {
            this.ajW = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ajW, R.color.CAM_X0206);
            this.ajW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.ajW.removeAllViews();
        if (this.aib == null) {
            this.aib = new ItemCardView(this.mContext);
            this.aib.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.ajW.addView(this.aib, layoutParams);
        return this.ajW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.boO() != null && aVar.boO().eVB != null && aVar.boO().eVB.item != null) {
            if (aVar.boO().eVB.ePW) {
                this.ajW.setVisibility(8);
                return;
            }
            this.ajW.setVisibility(0);
            this.aib.setData(aVar.boO().eVB.item, 13);
            return;
        }
        this.ajW.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ajW, R.color.CAM_X0206);
        if (this.aib != null) {
            this.aib.onChangeSkinType();
        }
    }
}
