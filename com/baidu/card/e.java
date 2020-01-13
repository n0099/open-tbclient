package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class e extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JH;
    private CardUserInfoLayout JN;
    private int JO;
    private a JP;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public e(Context context) {
        super(context);
        this.JO = 34053;
        this.JN = new CardUserInfoLayout(context);
        this.JN.setShowFlag(this.JO);
        this.JN.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.JP != null) {
                    e.this.JP.a(e.this.JH, view);
                }
                if (e.this.mE() != null) {
                    e.this.mE().a(view, e.this.JH);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aJ(int i) {
        this.JN.setShowFlag(this.JO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JN;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.JN.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aH(int i) {
        this.JO |= i;
        aJ(this.JO);
    }

    @Override // com.baidu.card.b
    public void aI(int i) {
        this.JO &= i ^ (-1);
        aJ(this.JO);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.JN.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.JP = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        this.JN.setData(aVar.axQ());
    }

    public void Y(boolean z) {
        if (this.JN != null && this.JN.getAvatar() != null) {
            this.JN.getAvatar().setClickable(z);
        }
    }

    public void Z(boolean z) {
        if (this.JN != null && this.JN.getUserName() != null) {
            this.JN.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.JN.setPageContext(tbPageContext);
    }
}
