package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public class k extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aea;
    private CardForumHeadLayout aep;

    public k(Context context) {
        super(context);
        this.aep = new CardForumHeadLayout(context);
        this.aep.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.rJ() != null) {
                    k.this.rJ().a(view, k.this.aea);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aep;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (this.aep != null && absThreadDataSupport != null) {
            this.aea = absThreadDataSupport;
            this.aep.setData(absThreadDataSupport.aPS());
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aep != null) {
            this.aep.onChangeSkinType();
        }
    }
}
