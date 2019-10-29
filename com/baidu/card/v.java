package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class v extends f {
    private com.baidu.tbadk.core.data.a Fx;
    private ThreadSmartAppLayout Gl;

    public v(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.Gl = new ThreadSmartAppLayout(context);
        this.Gl.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.lH() != null) {
                    v.this.lH().a(view, v.this.Fx);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Gl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        this.Gl.z(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Gl != null) {
            this.Gl.onChangeSkinType();
        }
    }
}
