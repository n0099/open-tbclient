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
    private com.baidu.tbadk.core.data.a agj;
    private BjhArticleLayout aiR;
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
        if (this.aiR == null) {
            this.aiR = new BjhArticleLayout(this.mContext);
            this.aiR.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.an.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.agh != null) {
                        an.this.agh.a(an.this.agj);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        this.mRootView.addView(this.aiR, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        if (this.aiR != null) {
            this.aiR.C(this.agj);
        }
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agh = interfaceC0088a;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        if (this.aiR != null) {
            this.aiR.setSubClickListener(abVar);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.aiR != null) {
                this.aiR.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
