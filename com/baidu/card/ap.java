package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ap extends i {
    private ItemCardView afU;
    private FrameLayout ahP;

    public ap(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.ahP == null) {
            this.ahP = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ahP, R.color.cp_bg_line_g);
            this.ahP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.ahP.removeAllViews();
        if (this.afU == null) {
            this.afU = new ItemCardView(this.mContext);
            this.afU.setBackGroundColor(R.color.cp_bg_line_e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.ahP.addView(this.afU, layoutParams);
        return this.ahP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null && absThreadDataSupport.bcY().efS.item != null) {
            if (absThreadDataSupport.bcY().efS.eav) {
                this.ahP.setVisibility(8);
                return;
            }
            this.ahP.setVisibility(0);
            this.afU.setData(absThreadDataSupport.bcY().efS.item, 13);
            return;
        }
        this.ahP.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ahP, R.color.cp_bg_line_g);
        if (this.afU != null) {
            this.afU.onChangeSkinType();
        }
    }
}
