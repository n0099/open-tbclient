package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class j extends h {
    private ForumEnterLayout adJ;
    private AbsThreadDataSupport adw;
    private final View.OnClickListener mOnClickListener;

    public j(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.rs() != null) {
                    j.this.rs().a(view, j.this.adw);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21);
        setTopMargin(dimens);
        ba(dimens2);
        this.adJ = new ForumEnterLayout(context);
        this.adJ.setOnAfterClickListener(this.mOnClickListener);
    }

    public void rB() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
        setTopMargin(dimens);
        ba(0);
        a(this.adJ, dimens, 0);
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
        return this.adJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        this.adJ.setSourceForPb(this.adr.rI());
        this.adJ.setData(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adJ.onChangeSkinType(tbPageContext, i);
    }
}
