package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends f {
    private com.baidu.tbadk.core.data.a VJ;
    private ThreadForumEnterButton VO;

    public g(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26));
        this.VO = new ThreadForumEnterButton(context);
        this.VO.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.qB() != null) {
                    g.this.qB().a(view, g.this.VJ);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.VO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VJ = aVar;
        this.VO.w(aVar.acx());
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.VO.onChangeSkinType();
    }
}
