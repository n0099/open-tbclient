package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends f {
    private com.baidu.tbadk.core.data.a Vq;
    private ThreadForumEnterButton Vu;

    public g(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26));
        this.Vu = new ThreadForumEnterButton(context);
        this.Vu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.qf() != null) {
                    g.this.qf().a(view, g.this.Vq);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Vu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vq = aVar;
        this.Vu.w(aVar.abv());
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Vu.onChangeSkinType();
    }
}
