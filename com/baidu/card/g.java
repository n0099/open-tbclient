package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends f {
    private ThreadForumEnterButton FC;
    private com.baidu.tbadk.core.data.a Fx;

    public g(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.FC = new ThreadForumEnterButton(context);
        this.FC.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.lH() != null) {
                    g.this.lH().a(view, g.this.Fx);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.FC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        this.FC.y(aVar.agI());
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.FC.onChangeSkinType();
    }
}
