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
    private com.baidu.tbadk.core.data.a ahB;
    private BjhArticleLayout akj;
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
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.akj == null) {
            this.akj = new BjhArticleLayout(this.mContext);
            this.akj.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.an.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.ahz != null) {
                        an.this.ahz.a(an.this.ahB);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        this.mRootView.addView(this.akj, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        if (this.akj != null) {
            this.akj.E(this.ahB);
        }
    }

    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.ahz = interfaceC0094a;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        if (this.akj != null) {
            this.akj.setSubClickListener(abVar);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.akj != null) {
                this.akj.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
