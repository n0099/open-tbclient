package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ai extends i {
    private com.baidu.tbadk.core.data.a afN;
    private ThreadSmartAppLayout ahg;

    public ai(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.ahg = new ThreadSmartAppLayout(context);
        this.ahg.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ai.this.tB() != null) {
                    ai.this.tB().a(view, ai.this.afN);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        this.ahg.H(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahg != null) {
            this.ahg.onChangeSkinType();
        }
    }
}
