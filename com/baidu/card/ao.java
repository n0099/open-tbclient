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
    private ItemCardView agZ;
    private FrameLayout aiT;

    public ao(Context context) {
        super(context);
        c(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.aiT == null) {
            this.aiT = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aiT, R.color.CAM_X0206);
            this.aiT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.aiT.removeAllViews();
        if (this.agZ == null) {
            this.agZ = new ItemCardView(this.mContext);
            this.agZ.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.aiT.addView(this.agZ, layoutParams);
        return this.aiT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bln() != null && aVar.bln().eTc != null && aVar.bln().eTc.item != null) {
            if (aVar.bln().eTc.eNx) {
                this.aiT.setVisibility(8);
                return;
            }
            this.aiT.setVisibility(0);
            this.agZ.setData(aVar.bln().eTc.item, 13);
            return;
        }
        this.aiT.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aiT, R.color.CAM_X0206);
        if (this.agZ != null) {
            this.agZ.onChangeSkinType();
        }
    }
}
