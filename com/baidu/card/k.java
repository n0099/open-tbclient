package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumGoodsEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class k extends h {
    private AbsThreadDataSupport aeW;
    private ForumGoodsEnterLayout afl;
    private int afm;
    private final View.OnClickListener mOnClickListener;

    public k(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.tw() != null) {
                    k.this.tw().a(view, k.this.aeW);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.a.aL(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        bn(dimens2);
        this.afl = new ForumGoodsEnterLayout(context);
        this.afl.setOnAfterClickListener(this.mOnClickListener);
    }

    public void tE() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30);
        setTopMargin(dimens);
        bn(0);
        a(this.afl, dimens, 0);
    }

    public void bo(int i) {
        this.afm = i;
    }

    public void a(View view, int i, int i2) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i || marginLayoutParams.bottomMargin != i2) {
                marginLayoutParams.topMargin = i;
                marginLayoutParams.bottomMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.afl.setSourceForPb(this.aeR.tN());
        this.afl.setFrstype(this.afm);
        this.afl.setData(absThreadDataSupport);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afl.onChangeSkinType(tbPageContext, i);
    }
}
