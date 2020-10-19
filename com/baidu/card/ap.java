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
    private ItemCardView agm;
    private FrameLayout aih;

    public ap(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.aih == null) {
            this.aih = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aih, R.color.cp_bg_line_g);
            this.aih.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.aih.removeAllViews();
        if (this.agm == null) {
            this.agm = new ItemCardView(this.mContext);
            this.agm.setBackGroundColor(R.color.cp_bg_line_e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.aih.addView(this.agm, layoutParams);
        return this.aih;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null && absThreadDataSupport.bfG().erY != null && absThreadDataSupport.bfG().erY.item != null) {
            if (absThreadDataSupport.bfG().erY.emx) {
                this.aih.setVisibility(8);
                return;
            }
            this.aih.setVisibility(0);
            this.agm.setData(absThreadDataSupport.bfG().erY.item, 13);
            return;
        }
        this.aih.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aih, R.color.cp_bg_line_g);
        if (this.agm != null) {
            this.agm.onChangeSkinType();
        }
    }
}
