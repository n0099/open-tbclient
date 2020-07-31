package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class j extends h {
    private AbsThreadDataSupport adQ;
    private ForumEnterLayout aed;
    private final View.OnClickListener mOnClickListener;

    public j(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.rL() != null) {
                    j.this.rL().a(view, j.this.adQ);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.a.aE(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        bi(dimens2);
        this.aed = new ForumEnterLayout(context);
        this.aed.setOnAfterClickListener(this.mOnClickListener);
    }

    public void rT() {
        if (com.baidu.tbadk.a.d.aRL()) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, com.baidu.tbadk.a.b.a.aE(R.dimen.tbds21, R.dimen.tbds0));
            setTopMargin(dimens);
            bi(dimens2);
            return;
        }
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
        setTopMargin(dimens3);
        bi(0);
        a(this.aed, dimens3, 0);
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
        return this.aed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.aed.setSourceForPb(this.adL.sc());
        this.aed.setData(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aed.onChangeSkinType(tbPageContext, i);
    }
}
