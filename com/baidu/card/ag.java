package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ag extends h {
    private AbsThreadDataSupport aea;
    private ThreadSmartAppLayout afq;

    public ag(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.afq = new ThreadSmartAppLayout(context);
        this.afq.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ag.this.rJ() != null) {
                    ag.this.rJ().a(view, ag.this.aea);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.afq.D(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afq != null) {
            this.afq.onChangeSkinType();
        }
    }
}
