package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class m extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahi;
    private CardForumHeadLayout ahs;

    public m(Context context) {
        super(context);
        this.ahs = new CardForumHeadLayout(context);
        this.ahs.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.tc() != null) {
                    m.this.tc().a(view, m.this.ahi);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (this.ahs != null && aVar != null) {
            this.ahi = aVar;
            this.ahs.setData(aVar.boO());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahs != null) {
            this.ahs.onChangeSkinType();
        }
    }
}
