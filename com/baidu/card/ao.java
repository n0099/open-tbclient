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
    private ItemCardView ahk;
    private FrameLayout ajf;

    public ao(Context context) {
        super(context);
        c(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.ajf == null) {
            this.ajf = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ajf, R.color.CAM_X0206);
            this.ajf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.ajf.removeAllViews();
        if (this.ahk == null) {
            this.ahk = new ItemCardView(this.mContext);
            this.ahk.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.ajf.addView(this.ahk, layoutParams);
        return this.ajf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bkV() != null && aVar.bkV().eQQ != null && aVar.bkV().eQQ.item != null) {
            if (aVar.bkV().eQQ.eLl) {
                this.ajf.setVisibility(8);
                return;
            }
            this.ajf.setVisibility(0);
            this.ahk.setData(aVar.bkV().eQQ.item, 13);
            return;
        }
        this.ajf.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ajf, R.color.CAM_X0206);
        if (this.ahk != null) {
            this.ahk.onChangeSkinType();
        }
    }
}
