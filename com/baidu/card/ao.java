package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ao extends h {
    private ItemCardView afA;
    private FrameLayout aht;

    public ao(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.aht == null) {
            this.aht = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aht, R.color.cp_bg_line_g);
            this.aht.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.aht.removeAllViews();
        if (this.afA == null) {
            this.afA = new ItemCardView(this.mContext);
            this.afA.setBackGroundColor(R.color.cp_bg_line_e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.aht.addView(this.afA, layoutParams);
        return this.aht;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null && absThreadDataSupport.bce().edE.item != null) {
            if (absThreadDataSupport.bce().edE.dYh) {
                this.aht.setVisibility(8);
                return;
            }
            this.aht.setVisibility(0);
            this.afA.setData(absThreadDataSupport.bce().edE.item, 13);
            return;
        }
        this.aht.setVisibility(8);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aht, R.color.cp_bg_line_g);
        if (this.afA != null) {
            this.afA.onChangeSkinType();
        }
    }
}
