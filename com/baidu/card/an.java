package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class an extends h {
    private ItemCardView aeB;
    private FrameLayout agu;

    public an(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.agu == null) {
            this.agu = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.agu, R.color.cp_bg_line_g);
            this.agu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.agu.removeAllViews();
        if (this.aeB == null) {
            this.aeB = new ItemCardView(this.mContext);
            this.aeB.setBackGroundColor(R.color.cp_bg_line_e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.agu.addView(this.aeB, layoutParams);
        return this.agu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null && absThreadDataSupport.aPS().dNX.item != null) {
            if (absThreadDataSupport.aPS().dNX.dID) {
                this.agu.setVisibility(8);
                return;
            }
            this.agu.setVisibility(0);
            this.aeB.setData(absThreadDataSupport.aPS().dNX.item, 13);
            return;
        }
        this.agu.setVisibility(8);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.an.setBackgroundColor(this.agu, R.color.cp_bg_line_g);
        if (this.aeB != null) {
            this.aeB.onChangeSkinType();
        }
    }
}
