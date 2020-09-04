package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ah extends h {
    private AbsThreadDataSupport aeY;
    private ThreadSmartAppLayout agt;

    public ah(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.agt = new ThreadSmartAppLayout(context);
        this.agt.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.tw() != null) {
                    ah.this.tw().a(view, ah.this.aeY);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        this.agt.F(absThreadDataSupport);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agt != null) {
            this.agt.onChangeSkinType();
        }
    }
}
