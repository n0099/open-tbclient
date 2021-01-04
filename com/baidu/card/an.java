package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class an extends h {
    private com.baidu.tbadk.core.data.a ahi;
    private BjhArticleLayout ajU;
    private LinearLayout mRootView;
    private int mSkinType;

    public an(Context context) {
        super(context);
        this.mSkinType = 3;
    }

    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.mContext);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.ajU == null) {
            this.ajU = new BjhArticleLayout(this.mContext);
            this.ajU.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.an.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.ahg != null) {
                        an.this.ahg.a(an.this.ahi);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        this.mRootView.addView(this.ajU, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        if (this.ajU != null) {
            this.ajU.D(this.ahi);
        }
    }

    public void a(a.InterfaceC0089a interfaceC0089a) {
        this.ahg = interfaceC0089a;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        if (this.ajU != null) {
            this.ajU.setSubClickListener(aaVar);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.ajU != null) {
                this.ajU.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
