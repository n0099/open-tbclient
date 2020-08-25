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
public class an extends h {
    private AbsThreadDataSupport aeW;
    private BjhArticleLayout ahr;
    private LinearLayout mRootView;
    private int mSkinType;

    public an(Context context) {
        super(context);
        this.mSkinType = 3;
    }

    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.mContext);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.ahr == null) {
            this.ahr = new BjhArticleLayout(this.mContext);
            this.ahr.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.an.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.aeU != null) {
                        an.this.aeU.a(an.this.aeW);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds22);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40);
        this.mRootView.addView(this.ahr, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        if (this.ahr != null) {
            this.ahr.F(this.aeW);
        }
    }

    public void a(b.a aVar) {
        this.aeU = aVar;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        if (this.ahr != null) {
            this.ahr.setSubClickListener(aaVar);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.ahr != null) {
                this.ahr.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
