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
public class an extends h {
    private ItemCardView aer;
    private FrameLayout agl;

    public an(Context context) {
        super(context);
        b((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.agl == null) {
            this.agl = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.agl, R.color.cp_bg_line_g);
            this.agl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.agl.removeAllViews();
        if (this.aer == null) {
            this.aer = new ItemCardView(this.mContext);
            this.aer.setBackGroundColor(R.color.cp_bg_line_e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.agl.addView(this.aer, layoutParams);
        return this.agl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null && absThreadDataSupport.aTN().dUi.item != null) {
            if (absThreadDataSupport.aTN().dUi.dOO) {
                this.agl.setVisibility(8);
                return;
            }
            this.agl.setVisibility(0);
            this.aer.setData(absThreadDataSupport.aTN().dUi.item, 13);
            return;
        }
        this.agl.setVisibility(8);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.agl, R.color.cp_bg_line_g);
        if (this.aer != null) {
            this.aer.onChangeSkinType();
        }
    }
}
