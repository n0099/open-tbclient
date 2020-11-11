package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ap extends i {
    private ItemCardView agn;
    private FrameLayout aii;

    public ap(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.aii == null) {
            this.aii = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aii, R.color.cp_bg_line_g);
            this.aii.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.aii.removeAllViews();
        if (this.agn == null) {
            this.agn = new ItemCardView(this.mContext);
            this.agn.setBackGroundColor(R.color.cp_bg_line_e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.aii.addView(this.agn, layoutParams);
        return this.aii;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null && absThreadDataSupport.bjZ().eGn.item != null) {
            if (absThreadDataSupport.bjZ().eGn.eAQ) {
                this.aii.setVisibility(8);
                return;
            }
            this.aii.setVisibility(0);
            this.agn.setData(absThreadDataSupport.bjZ().eGn.item, 13);
            return;
        }
        this.aii.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aii, R.color.cp_bg_line_g);
        if (this.agn != null) {
            this.agn.onChangeSkinType();
        }
    }
}
