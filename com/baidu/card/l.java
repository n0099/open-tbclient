package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumGoodsEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class l extends i {
    private com.baidu.tbadk.core.data.a agJ;
    private ForumGoodsEnterLayout ahc;
    private int ahd;
    private final View.OnClickListener mOnClickListener;

    public l(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.tE() != null) {
                    l.this.tE().a(view, l.this.agJ);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.a.aN(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        bv(dimens2);
        this.ahc = new ForumGoodsEnterLayout(context);
        this.ahc.setOnAfterClickListener(this.mOnClickListener);
    }

    public void tM() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_H_X003);
        setTopMargin(dimens);
        bv(0);
        a(this.ahc, dimens, 0);
    }

    public void bw(int i) {
        this.ahd = i;
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
        return this.ahc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.ahc.setSourceForPb(this.agE.tV());
        this.ahc.setFrstype(this.ahd);
        this.ahc.setData(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahc.onChangeSkinType(tbPageContext, i);
    }
}
