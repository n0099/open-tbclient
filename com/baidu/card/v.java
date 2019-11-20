package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class v extends f {
    private com.baidu.tbadk.core.data.a EX;
    private ThreadSmartAppLayout FK;

    public v(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.FK = new ThreadSmartAppLayout(context);
        this.FK.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.lH() != null) {
                    v.this.lH().a(view, v.this.EX);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.FK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.EX = aVar;
        this.FK.z(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.FK != null) {
            this.FK.onChangeSkinType();
        }
    }
}
