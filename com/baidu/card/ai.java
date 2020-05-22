package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.b;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ai extends h {
    private AbsThreadDataSupport adw;
    private BjhArticleLayout afI;
    private LinearLayout mRootView;
    private int mSkinType;

    public ai(Context context) {
        super(context);
        this.mSkinType = 3;
    }

    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.mContext);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.afI == null) {
            this.afI = new BjhArticleLayout(this.mContext);
            this.afI.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ai.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ai.this.adu != null) {
                        ai.this.adu.a(ai.this.adw);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds22);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40);
        this.mRootView.addView(this.afI, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        if (this.afI != null) {
            this.afI.D(this.adw);
        }
    }

    public void a(b.a aVar) {
        this.adu = aVar;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        if (this.afI != null) {
            this.afI.setSubClickListener(aaVar);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.afI != null) {
                this.afI.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
