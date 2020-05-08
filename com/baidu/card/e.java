package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class e extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ade;
    private CardUserInfoLayout adk;
    private int adl;
    private a adm;

    /* loaded from: classes8.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public e(Context context) {
        super(context);
        this.adl = 34053;
        this.adk = new CardUserInfoLayout(context);
        this.adk.setShowFlag(this.adl);
        this.adk.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.adm != null) {
                    e.this.adm.a(e.this.ade, view);
                }
                if (e.this.rl() != null) {
                    e.this.rl().a(view, e.this.ade);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aY(int i) {
        this.adk.setShowFlag(this.adl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adk;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adk.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aW(int i) {
        this.adl |= i;
        aY(this.adl);
    }

    @Override // com.baidu.card.b
    public void aX(int i) {
        this.adl &= i ^ (-1);
        aY(this.adl);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.adk.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.adm = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        this.adk.setData(aVar.aIu());
    }

    public void aA(boolean z) {
        if (this.adk != null && this.adk.getAvatar() != null) {
            this.adk.getAvatar().setClickable(z);
        }
    }

    public void aB(boolean z) {
        if (this.adk != null && this.adk.getUserName() != null) {
            this.adk.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.adk.setPageContext(tbPageContext);
    }
}
