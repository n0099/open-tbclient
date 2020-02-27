package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class j extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Kc;
    private CardForumHeadLayout Kq;

    public j(Context context) {
        super(context);
        this.Kq = new CardForumHeadLayout(context);
        this.Kq.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mT() != null) {
                    j.this.mT().a(view, j.this.Kc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Kq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (this.Kq != null && aVar != null) {
            this.Kc = aVar;
            this.Kq.setData(aVar.aAe());
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Kq != null) {
            this.Kq.onChangeSkinType();
        }
    }
}
