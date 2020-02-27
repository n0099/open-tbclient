package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ab extends h {
    private com.baidu.tbadk.core.data.a Kc;
    private ThreadSmartAppLayout Ll;

    public ab(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.Ll = new ThreadSmartAppLayout(context);
        this.Ll.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ab.this.mT() != null) {
                    ab.this.mT().a(view, ab.this.Kc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Ll;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.Ll.A(aVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Ll != null) {
            this.Ll.onChangeSkinType();
        }
    }
}
