package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class k extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private CardForumHeadLayout aef;

    public k(Context context) {
        super(context);
        this.aef = new CardForumHeadLayout(context);
        this.aef.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.rL() != null) {
                    k.this.rL().a(view, k.this.adQ);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aef;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (this.aef != null && absThreadDataSupport != null) {
            this.adQ = absThreadDataSupport;
            this.aef.setData(absThreadDataSupport.aTN());
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aef != null) {
            this.aef.onChangeSkinType();
        }
    }
}
