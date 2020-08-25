package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ah extends h {
    private AbsThreadDataSupport aeW;
    private ThreadSmartAppLayout agr;

    public ah(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.agr = new ThreadSmartAppLayout(context);
        this.agr.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.tw() != null) {
                    ah.this.tw().a(view, ah.this.aeW);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.agr.F(absThreadDataSupport);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agr != null) {
            this.agr.onChangeSkinType();
        }
    }
}
