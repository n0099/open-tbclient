package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes21.dex */
public class m extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    private CardForumHeadLayout afS;

    public m(Context context) {
        super(context);
        this.afS = new CardForumHeadLayout(context);
        this.afS.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.tB() != null) {
                    m.this.tB().a(view, m.this.afI);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (this.afS != null && absThreadDataSupport != null) {
            this.afI = absThreadDataSupport;
            this.afS.setData(absThreadDataSupport.bjZ());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afS != null) {
            this.afS.onChangeSkinType();
        }
    }
}
