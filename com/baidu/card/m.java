package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class m extends a<com.baidu.tbadk.core.data.a> {
    private CardForumHeadLayout agB;
    private com.baidu.tbadk.core.data.a agr;

    public m(Context context) {
        super(context);
        this.agB = new CardForumHeadLayout(context);
        this.agB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.sR() != null) {
                    m.this.sR().a(view, m.this.agr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.agB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (this.agB != null && aVar != null) {
            this.agr = aVar;
            this.agB.setData(aVar.bkV());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agB != null) {
            this.agB.onChangeSkinType();
        }
    }
}
