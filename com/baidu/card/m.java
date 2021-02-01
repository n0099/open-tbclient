package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class m extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agj;
    private CardForumHeadLayout agt;

    public m(Context context) {
        super(context);
        this.agt = new CardForumHeadLayout(context);
        this.agt.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.sO() != null) {
                    m.this.sO().a(view, m.this.agj);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.agt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (this.agt != null && aVar != null) {
            this.agj = aVar;
            this.agt.setData(aVar.bln());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agt != null) {
            this.agt.onChangeSkinType();
        }
    }
}
