package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public class k extends b<AbsThreadDataSupport> {
    private CardForumHeadLayout adL;
    private AbsThreadDataSupport adw;

    public k(Context context) {
        super(context);
        this.adL = new CardForumHeadLayout(context);
        this.adL.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.rs() != null) {
                    k.this.rs().a(view, k.this.adw);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (this.adL != null && absThreadDataSupport != null) {
            this.adw = absThreadDataSupport;
            this.adL.setData(absThreadDataSupport.aOi());
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.adL != null) {
            this.adL.onChangeSkinType();
        }
    }
}
