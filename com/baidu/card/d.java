package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class d extends com.baidu.card.a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahB;
    private CardUserInfoLayout ahH;
    private int ahI;
    private a ahJ;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.ahI = 34053;
        this.ahH = new CardUserInfoLayout(context);
        this.ahH.setShowFlag(this.ahI);
        this.ahH.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ahJ != null) {
                    d.this.ahJ.a(d.this.ahB, view);
                }
                if (d.this.sO() != null) {
                    d.this.sO().a(view, d.this.ahB);
                }
            }
        });
    }

    @Override // com.baidu.card.a
    public void bt(int i) {
        this.ahH.setShowFlag(this.ahI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahH;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahH.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.a
    public void br(int i) {
        this.ahI |= i;
        bt(this.ahI);
    }

    @Override // com.baidu.card.a
    public void bs(int i) {
        this.ahI &= i ^ (-1);
        bt(this.ahI);
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahH.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.ahJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        this.ahH.setData(aVar.blp());
    }

    public void aC(boolean z) {
        if (this.ahH != null && this.ahH.getAvatar() != null) {
            this.ahH.getAvatar().setClickable(z);
        }
    }

    public void aD(boolean z) {
        if (this.ahH != null && this.ahH.getUserName() != null) {
            this.ahH.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.ahH.setPageContext(tbPageContext);
    }
}
