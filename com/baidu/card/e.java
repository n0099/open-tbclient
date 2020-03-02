package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class e extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Kc;
    private CardUserInfoLayout Kj;
    private int Kk;
    private a Kl;

    /* loaded from: classes8.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public e(Context context) {
        super(context);
        this.Kk = 34053;
        this.Kj = new CardUserInfoLayout(context);
        this.Kj.setShowFlag(this.Kk);
        this.Kj.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Kl != null) {
                    e.this.Kl.a(e.this.Kc, view);
                }
                if (e.this.mT() != null) {
                    e.this.mT().a(view, e.this.Kc);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aM(int i) {
        this.Kj.setShowFlag(this.Kk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Kj;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Kj.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aK(int i) {
        this.Kk |= i;
        aM(this.Kk);
    }

    @Override // com.baidu.card.b
    public void aL(int i) {
        this.Kk &= i ^ (-1);
        aM(this.Kk);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Kj.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.Kl = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.Kj.setData(aVar.aAg());
    }

    public void ab(boolean z) {
        if (this.Kj != null && this.Kj.getAvatar() != null) {
            this.Kj.getAvatar().setClickable(z);
        }
    }

    public void ac(boolean z) {
        if (this.Kj != null && this.Kj.getUserName() != null) {
            this.Kj.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.Kj.setPageContext(tbPageContext);
    }
}
