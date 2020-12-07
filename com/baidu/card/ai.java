package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ai extends i {
    private com.baidu.tbadk.core.data.a agJ;
    private ThreadSmartAppLayout aig;

    public ai(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.aig = new ThreadSmartAppLayout(context);
        this.aig.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ai.this.tE() != null) {
                    ai.this.tE().a(view, ai.this.agJ);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.aig.H(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aig != null) {
            this.aig.onChangeSkinType();
        }
    }
}
