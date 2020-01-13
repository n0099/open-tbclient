package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class j extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JH;
    private CardForumHeadLayout JU;

    public j(Context context) {
        super(context);
        this.JU = new CardForumHeadLayout(context);
        this.JU.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mE() != null) {
                    j.this.mE().a(view, j.this.JH);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (this.JU != null && aVar != null) {
            this.JH = aVar;
            this.JU.setData(aVar.axQ());
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.JU != null) {
            this.JU.onChangeSkinType();
        }
    }
}
