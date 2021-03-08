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
    private ItemCardView ais;
    private FrameLayout akl;

    public ao(Context context) {
        super(context);
        c(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.akl == null) {
            this.akl = new FrameLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.akl, R.color.CAM_X0206);
            this.akl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.akl.removeAllViews();
        if (this.ais == null) {
            this.ais = new ItemCardView(this.mContext);
            this.ais.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.akl.addView(this.ais, layoutParams);
        return this.akl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.blp() != null && aVar.blp().eUD != null && aVar.blp().eUD.item != null) {
            if (aVar.blp().eUD.eOY) {
                this.akl.setVisibility(8);
                return;
            }
            this.akl.setVisibility(0);
            this.ais.setData(aVar.blp().eUD.item, 13);
            return;
        }
        this.akl.setVisibility(8);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.akl, R.color.CAM_X0206);
        if (this.ais != null) {
            this.ais.onChangeSkinType();
        }
    }
}
