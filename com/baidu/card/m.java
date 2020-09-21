package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes20.dex */
public class m extends b<AbsThreadDataSupport> {
    private CardForumHeadLayout afA;
    private AbsThreadDataSupport afq;

    public m(Context context) {
        super(context);
        this.afA = new CardForumHeadLayout(context);
        this.afA.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.tB() != null) {
                    m.this.tB().a(view, m.this.afq);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (this.afA != null && absThreadDataSupport != null) {
            this.afq = absThreadDataSupport;
            this.afA.setData(absThreadDataSupport.bcY());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afA != null) {
            this.afA.onChangeSkinType();
        }
    }
}
