package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class m extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahB;
    private CardForumHeadLayout ahL;

    public m(Context context) {
        super(context);
        this.ahL = new CardForumHeadLayout(context);
        this.ahL.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.sO() != null) {
                    m.this.sO().a(view, m.this.ahB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (this.ahL != null && aVar != null) {
            this.ahB = aVar;
            this.ahL.setData(aVar.blp());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahL != null) {
            this.ahL.onChangeSkinType();
        }
    }
}
