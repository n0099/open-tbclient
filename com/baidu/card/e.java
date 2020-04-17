package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class e extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ada;
    private CardUserInfoLayout adh;
    private int adi;
    private a adj;

    /* loaded from: classes8.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public e(Context context) {
        super(context);
        this.adi = 34053;
        this.adh = new CardUserInfoLayout(context);
        this.adh.setShowFlag(this.adi);
        this.adh.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.adj != null) {
                    e.this.adj.a(e.this.ada, view);
                }
                if (e.this.rl() != null) {
                    e.this.rl().a(view, e.this.ada);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aY(int i) {
        this.adh.setShowFlag(this.adi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adh;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adh.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aW(int i) {
        this.adi |= i;
        aY(this.adi);
    }

    @Override // com.baidu.card.b
    public void aX(int i) {
        this.adi &= i ^ (-1);
        aY(this.adi);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.adh.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.adj = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        this.adh.setData(aVar.aIw());
    }

    public void aA(boolean z) {
        if (this.adh != null && this.adh.getAvatar() != null) {
            this.adh.getAvatar().setClickable(z);
        }
    }

    public void aB(boolean z) {
        if (this.adh != null && this.adh.getUserName() != null) {
            this.adh.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.adh.setPageContext(tbPageContext);
    }
}
