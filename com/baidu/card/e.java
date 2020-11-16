package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes20.dex */
public class e extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a afN;
    private CardUserInfoLayout afT;
    private int afU;
    private a afV;

    /* loaded from: classes20.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public e(Context context) {
        super(context);
        this.afU = 34053;
        this.afT = new CardUserInfoLayout(context);
        this.afT.setShowFlag(this.afU);
        this.afT.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.afV != null) {
                    e.this.afV.a(e.this.afN, view);
                }
                if (e.this.tB() != null) {
                    e.this.tB().a(view, e.this.afN);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bq(int i) {
        this.afT.setShowFlag(this.afU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afT;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afT.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.afU |= i;
        bq(this.afU);
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.afU &= i ^ (-1);
        bq(this.afU);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afT.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.afV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        this.afT.setData(aVar.bjd());
    }

    public void aE(boolean z) {
        if (this.afT != null && this.afT.getAvatar() != null) {
            this.afT.getAvatar().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.afT != null && this.afT.getUserName() != null) {
            this.afT.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.afT.setPageContext(tbPageContext);
    }
}
