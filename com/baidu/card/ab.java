package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ab extends h {
    private com.baidu.tbadk.core.data.a JB;
    private ThreadSmartAppLayout KJ;

    public ab(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.KJ = new ThreadSmartAppLayout(context);
        this.KJ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ab.this.mE() != null) {
                    ab.this.mE().a(view, ab.this.JB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.KJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JB = aVar;
        this.KJ.A(aVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.KJ != null) {
            this.KJ.onChangeSkinType();
        }
    }
}
