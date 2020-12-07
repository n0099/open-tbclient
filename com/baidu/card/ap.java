package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ap extends i {
    private ItemCardView ahq;
    private FrameLayout ajk;

    public ap(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.ajk == null) {
            this.ajk = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ajk, R.color.CAM_X0206);
            this.ajk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.ajk.removeAllViews();
        if (this.ahq == null) {
            this.ahq = new ItemCardView(this.mContext);
            this.ahq.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.ajk.addView(this.ahq, layoutParams);
        return this.ajk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bmn() != null && aVar.bmn().eLH != null && aVar.bmn().eLH.item != null) {
            if (aVar.bmn().eLH.eGg) {
                this.ajk.setVisibility(8);
                return;
            }
            this.ajk.setVisibility(0);
            this.ahq.setData(aVar.bmn().eLH.item, 13);
            return;
        }
        this.ajk.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ajk, R.color.CAM_X0206);
        if (this.ahq != null) {
            this.ahq.onChangeSkinType();
        }
    }
}
