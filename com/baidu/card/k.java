package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class k extends i {
    private com.baidu.tbadk.core.data.a agJ;
    private ForumEnterLayout aha;
    private final View.OnClickListener mOnClickListener;

    public k(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.tE() != null) {
                    k.this.tE().a(view, k.this.agJ);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.a.aN(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        bv(dimens2);
        this.aha = new ForumEnterLayout(context);
        this.aha.setOnAfterClickListener(this.mOnClickListener);
    }

    public void tM() {
        if (com.baidu.tbadk.a.d.bkq()) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_H_X003);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, com.baidu.tbadk.a.b.a.aN(R.dimen.tbds21, R.dimen.tbds0));
            setTopMargin(dimens);
            bv(dimens2);
            return;
        }
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
        setTopMargin(dimens3);
        bv(0);
        a(this.aha, dimens3, 0);
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
        return this.aha;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.aha.setSourceForPb(this.agE.tV());
        this.aha.setData(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aha.onChangeSkinType(tbPageContext, i);
    }
}
