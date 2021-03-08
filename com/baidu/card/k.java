package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class k extends h {
    private com.baidu.tbadk.core.data.a ahB;
    private ForumEnterLayout aib;
    private final View.OnClickListener mOnClickListener;

    public k(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.sO() != null) {
                    k.this.sO().a(view, k.this.ahB);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.b.aH(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        bu(dimens2);
        this.aib = new ForumEnterLayout(context);
        this.aib.setOnAfterClickListener(this.mOnClickListener);
    }

    public void sW() {
        if (com.baidu.tbadk.a.d.biZ()) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_H_X003);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, com.baidu.tbadk.a.b.b.aH(R.dimen.tbds21, R.dimen.tbds0));
            setTopMargin(dimens);
            bu(dimens2);
            return;
        }
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
        setTopMargin(dimens3);
        bu(0);
        e(this.aib, dimens3, 0);
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
        return this.aib;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        this.aib.setSourceForPb(this.ahw.tf());
        this.aib.setData(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aib.onChangeSkinType(tbPageContext, i);
    }
}
