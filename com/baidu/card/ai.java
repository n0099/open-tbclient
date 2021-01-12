package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ai extends h {
    private com.baidu.tbadk.core.data.a agr;
    private ThreadSmartAppLayout aia;

    public ai(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.aia = new ThreadSmartAppLayout(context);
        this.aia.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ai.this.sR() != null) {
                    ai.this.sR().a(view, ai.this.agr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aia;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        this.aia.C(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aia != null) {
            this.aia.onChangeSkinType();
        }
    }
}
