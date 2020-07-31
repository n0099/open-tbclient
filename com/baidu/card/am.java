package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.b;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class am extends h {
    private AbsThreadDataSupport adQ;
    private BjhArticleLayout agj;
    private LinearLayout mRootView;
    private int mSkinType;

    public am(Context context) {
        super(context);
        this.mSkinType = 3;
    }

    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.mContext);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.agj == null) {
            this.agj = new BjhArticleLayout(this.mContext);
            this.agj.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.am.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (am.this.adO != null) {
                        am.this.adO.a(am.this.adQ);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds22);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40);
        this.mRootView.addView(this.agj, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        if (this.agj != null) {
            this.agj.D(this.adQ);
        }
    }

    public void a(b.a aVar) {
        this.adO = aVar;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        if (this.agj != null) {
            this.agj.setSubClickListener(aaVar);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.agj != null) {
                this.agj.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
