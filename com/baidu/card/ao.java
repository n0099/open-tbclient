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
    private ItemCardView afC;
    private FrameLayout ahv;

    public ao(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.ahv == null) {
            this.ahv = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ahv, R.color.cp_bg_line_g);
            this.ahv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.ahv.removeAllViews();
        if (this.afC == null) {
            this.afC = new ItemCardView(this.mContext);
            this.afC.setBackGroundColor(R.color.cp_bg_line_e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.ahv.addView(this.afC, layoutParams);
        return this.ahv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edI != null && absThreadDataSupport.bce().edI.item != null) {
            if (absThreadDataSupport.bce().edI.dYl) {
                this.ahv.setVisibility(8);
                return;
            }
            this.ahv.setVisibility(0);
            this.afC.setData(absThreadDataSupport.bce().edI.item, 13);
            return;
        }
        this.ahv.setVisibility(8);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ahv, R.color.cp_bg_line_g);
        if (this.afC != null) {
            this.afC.onChangeSkinType();
        }
    }
}
