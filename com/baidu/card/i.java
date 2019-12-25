package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class i extends h {
    private com.baidu.tbadk.core.data.a JB;
    private ThreadForumEnterButton JN;

    public i(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds14));
        this.JN = new ThreadForumEnterButton(context);
        this.JN.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.mE() != null) {
                    i.this.mE().a(view, i.this.JB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JB = aVar;
        this.JN.q(aVar.axx());
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.JN.onChangeSkinType();
    }
}
