package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class i extends h {
    private com.baidu.tbadk.core.data.a Kc;
    private ThreadForumEnterButton Ko;

    public i(Context context) {
        super(context);
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21);
        setTopMargin(dimens);
        aN(dimens2);
        this.Ko = new ThreadForumEnterButton(context);
        this.Ko.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.mT() != null) {
                    i.this.mT().a(view, i.this.Kc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Ko;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.Ko.q(aVar.aAj());
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Ko.onChangeSkinType();
    }
}
