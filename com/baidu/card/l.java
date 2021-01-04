package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumGoodsEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l extends h {
    private ForumGoodsEnterLayout ahN;
    private int ahO;
    private com.baidu.tbadk.core.data.a ahi;
    private final View.OnClickListener mOnClickListener;

    public l(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.tc() != null) {
                    l.this.tc().a(view, l.this.ahi);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.b.aK(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        bv(dimens2);
        this.ahN = new ForumGoodsEnterLayout(context);
        this.ahN.setOnAfterClickListener(this.mOnClickListener);
    }

    public void tk() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_H_X003);
        setTopMargin(dimens);
        bv(0);
        e(this.ahN, dimens, 0);
    }

    public void bw(int i) {
        this.ahO = i;
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
        return this.ahN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        this.ahN.setSourceForPb(this.ahd.tu());
        this.ahN.setFrstype(this.ahO);
        this.ahN.setData(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahN.onChangeSkinType(tbPageContext, i);
    }
}
