package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.b;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ah extends h {
    private com.baidu.tbadk.core.data.a ade;
    private BjhArticleLayout afl;
    private LinearLayout mRootView;
    private int mSkinType;

    public ah(Context context) {
        super(context);
        this.mSkinType = 3;
    }

    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.mContext);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.afl == null) {
            this.afl = new BjhArticleLayout(this.mContext);
            this.afl.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ah.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ah.this.adb != null) {
                        ah.this.adb.a(ah.this.ade);
                    }
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds22);
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40);
        this.mRootView.addView(this.afl, layoutParams);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        if (this.afl != null) {
            this.afl.B(this.ade);
        }
    }

    public void a(b.a aVar) {
        this.adb = aVar;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        if (this.afl != null) {
            this.afl.setSubClickListener(zVar);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.afl != null) {
                this.afl.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
