package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class k extends i {
    private AbsThreadDataSupport afI;
    private ForumEnterLayout afW;
    private final View.OnClickListener mOnClickListener;

    public k(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.tB() != null) {
                    k.this.tB().a(view, k.this.afI);
                }
            }
        };
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, com.baidu.tbadk.a.b.a.aL(R.dimen.tbds21, R.dimen.tbds0));
        setTopMargin(dimens);
        br(dimens2);
        this.afW = new ForumEnterLayout(context);
        this.afW.setOnAfterClickListener(this.mOnClickListener);
    }

    public void tJ() {
        if (com.baidu.tbadk.a.d.bhU()) {
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, com.baidu.tbadk.a.b.a.aL(R.dimen.tbds21, R.dimen.tbds0));
            setTopMargin(dimens);
            br(dimens2);
            return;
        }
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
        setTopMargin(dimens3);
        br(0);
        a(this.afW, dimens3, 0);
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
        return this.afW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        this.afW.setSourceForPb(this.afD.tS());
        this.afW.setData(absThreadDataSupport);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afW.onChangeSkinType(tbPageContext, i);
    }
}
