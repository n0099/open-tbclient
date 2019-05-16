package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class v extends f {
    private com.baidu.tbadk.core.data.a Vq;
    private ThreadSmartAppLayout Wc;

    public v(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds21));
        this.Wc = new ThreadSmartAppLayout(context);
        this.Wc.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.qf() != null) {
                    v.this.qf().a(view, v.this.Vq);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Wc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vq = aVar;
        this.Wc.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Wc != null) {
            this.Wc.onChangeSkinType();
        }
    }
}
