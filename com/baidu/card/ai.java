package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ai extends h {
    private com.baidu.tbadk.core.data.a ahB;
    private ThreadSmartAppLayout ajh;

    public ai(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.ajh = new ThreadSmartAppLayout(context);
        this.ajh.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ai.this.sO() != null) {
                    ai.this.sO().a(view, ai.this.ahB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ajh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        this.ajh.E(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajh != null) {
            this.ajh.onChangeSkinType();
        }
    }
}
