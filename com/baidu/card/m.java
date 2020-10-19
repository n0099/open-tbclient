package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes21.dex */
public class m extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    private CardForumHeadLayout afR;

    public m(Context context) {
        super(context);
        this.afR = new CardForumHeadLayout(context);
        this.afR.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.tB() != null) {
                    m.this.tB().a(view, m.this.afH);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (this.afR != null && absThreadDataSupport != null) {
            this.afH = absThreadDataSupport;
            this.afR.setData(absThreadDataSupport.bfG());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afR != null) {
            this.afR.onChangeSkinType();
        }
    }
}
