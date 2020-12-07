package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes21.dex */
public class m extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private CardForumHeadLayout agT;

    public m(Context context) {
        super(context);
        this.agT = new CardForumHeadLayout(context);
        this.agT.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.tE() != null) {
                    m.this.tE().a(view, m.this.agJ);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (this.agT != null && aVar != null) {
            this.agJ = aVar;
            this.agT.setData(aVar.bmn());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agT != null) {
            this.agT.onChangeSkinType();
        }
    }
}
