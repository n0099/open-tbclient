package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumGoodsEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class l extends i {
    private ForumGoodsEnterLayout afG;
    private int afH;
    private AbsThreadDataSupport afq;
    private final View.OnClickListener mOnClickListener;

    public l(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.tB() != null) {
                    l.this.tB().a(view, l.this.afq);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.a.aL(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        br(dimens2);
        this.afG = new ForumGoodsEnterLayout(context);
        this.afG.setOnAfterClickListener(this.mOnClickListener);
    }

    public void tJ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30);
        setTopMargin(dimens);
        br(0);
        a(this.afG, dimens, 0);
    }

    public void bs(int i) {
        this.afH = i;
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
        return this.afG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.afG.setSourceForPb(this.afl.tS());
        this.afG.setFrstype(this.afH);
        this.afG.setData(absThreadDataSupport);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afG.onChangeSkinType(tbPageContext, i);
    }
}
