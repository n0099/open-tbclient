package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class j extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ade;
    private CardForumHeadLayout adr;

    public j(Context context) {
        super(context);
        this.adr = new CardForumHeadLayout(context);
        this.adr.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.rl() != null) {
                    j.this.rl().a(view, j.this.ade);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        if (this.adr != null && aVar != null) {
            this.ade = aVar;
            this.adr.setData(aVar.aIu());
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.adr != null) {
            this.adr.onChangeSkinType();
        }
    }
}
