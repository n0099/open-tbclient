package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumGoodsEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l extends h {
    private com.baidu.tbadk.core.data.a ahB;
    private ForumGoodsEnterLayout aie;
    private int aif;
    private final View.OnClickListener mOnClickListener;

    public l(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.sO() != null) {
                    l.this.sO().a(view, l.this.ahB);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.b.aH(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        bu(dimens2);
        this.aie = new ForumGoodsEnterLayout(context);
        this.aie.setOnAfterClickListener(this.mOnClickListener);
    }

    public void sW() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_H_X003);
        setTopMargin(dimens);
        bu(0);
        e(this.aie, dimens, 0);
    }

    public void bv(int i) {
        this.aif = i;
    }

    public void e(View view, int i, int i2) {
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
    @Override // com.baidu.card.a
    public View getView() {
        return this.aie;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        this.aie.setSourceForPb(this.ahw.tf());
        this.aie.setFrstype(this.aif);
        this.aie.setData(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aie.onChangeSkinType(tbPageContext, i);
    }
}
