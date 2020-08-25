package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class l extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    private CardForumHeadLayout afo;

    public l(Context context) {
        super(context);
        this.afo = new CardForumHeadLayout(context);
        this.afo.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.tw() != null) {
                    l.this.tw().a(view, l.this.aeW);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (this.afo != null && absThreadDataSupport != null) {
            this.aeW = absThreadDataSupport;
            this.afo.setData(absThreadDataSupport.bce());
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afo != null) {
            this.afo.onChangeSkinType();
        }
    }
}
