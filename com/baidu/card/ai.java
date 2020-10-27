package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ai extends i {
    private AbsThreadDataSupport afI;
    private ThreadSmartAppLayout ahe;

    public ai(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.ahe = new ThreadSmartAppLayout(context);
        this.ahe.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ai.this.tB() != null) {
                    ai.this.tB().a(view, ai.this.afI);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        this.ahe.H(absThreadDataSupport);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahe != null) {
            this.ahe.onChangeSkinType();
        }
    }
}
