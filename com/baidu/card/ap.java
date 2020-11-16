package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ap extends i {
    private ItemCardView ags;
    private FrameLayout ail;

    public ap(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.ail == null) {
            this.ail = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ail, R.color.CAM_X0206);
            this.ail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.ail.removeAllViews();
        if (this.ags == null) {
            this.ags = new ItemCardView(this.mContext);
            this.ags.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.ail.addView(this.ags, layoutParams);
        return this.ail;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bjd() != null && aVar.bjd().eEF != null && aVar.bjd().eEF.item != null) {
            if (aVar.bjd().eEF.ezh) {
                this.ail.setVisibility(8);
                return;
            }
            this.ail.setVisibility(0);
            this.ags.setData(aVar.bjd().eEF.item, 13);
            return;
        }
        this.ail.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ail, R.color.CAM_X0206);
        if (this.ags != null) {
            this.ags.onChangeSkinType();
        }
    }
}
