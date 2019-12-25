package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class e extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JB;
    private CardUserInfoLayout JH;
    private int JI;
    private a JJ;

    /* loaded from: classes5.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public e(Context context) {
        super(context);
        this.JI = 1285;
        this.JH = new CardUserInfoLayout(context);
        this.JH.setShowFlag(this.JI);
        this.JH.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.JJ != null) {
                    e.this.JJ.a(e.this.JB, view);
                }
                if (e.this.mE() != null) {
                    e.this.mE().a(view, e.this.JB);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aJ(int i) {
        this.JH.setShowFlag(this.JI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JH;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.JH.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aH(int i) {
        this.JI |= i;
        aJ(this.JI);
    }

    @Override // com.baidu.card.b
    public void aI(int i) {
        this.JI &= i ^ (-1);
        aJ(this.JI);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.JH.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.JJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JB = aVar;
        this.JH.setData(aVar.axx());
    }

    public void Y(boolean z) {
        if (this.JH != null && this.JH.getAvatar() != null) {
            this.JH.getAvatar().setClickable(z);
        }
    }

    public void Z(boolean z) {
        if (this.JH != null && this.JH.getUserName() != null) {
            this.JH.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.JH.setPageContext(tbPageContext);
    }
}
