package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g extends f {
    private ThreadForumEnterButton XD;
    private com.baidu.tbadk.core.data.a Xz;

    public g(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.h(context, d.e.tbds26));
        this.XD = new ThreadForumEnterButton(context);
        this.XD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.rk() != null) {
                    g.this.rk().a(view, g.this.Xz);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.XD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xz = aVar;
        this.XD.w(aVar.WO());
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.XD.onChangeSkinType();
    }
}
