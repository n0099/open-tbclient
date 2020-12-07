package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.b;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ao extends i {
    private com.baidu.tbadk.core.data.a agJ;
    private BjhArticleLayout aji;
    private LinearLayout mRootView;
    private int mSkinType;

    public ao(Context context) {
        super(context);
        this.mSkinType = 3;
    }

    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.aji == null) {
            this.aji = new BjhArticleLayout(this.mContext);
            this.aji.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ao.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ao.this.agH != null) {
                        ao.this.agH.a(ao.this.agJ);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        this.mRootView.addView(this.aji, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        if (this.aji != null) {
            this.aji.H(this.agJ);
        }
    }

    public void a(b.a aVar) {
        this.agH = aVar;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        if (this.aji != null) {
            this.aji.setSubClickListener(abVar);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.aji != null) {
                this.aji.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
