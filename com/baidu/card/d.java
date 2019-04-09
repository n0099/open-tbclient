package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private a XA;
    private CardUserInfoLayout Xx;
    private int Xy;
    private com.baidu.tbadk.core.data.a Xz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.Xy = 1285;
        this.Xx = new CardUserInfoLayout(context);
        this.Xx.setShowFlag(this.Xy);
        this.Xx.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.XA != null) {
                    d.this.XA.a(d.this.Xz, view);
                }
                if (d.this.rk() != null) {
                    d.this.rk().a(view, d.this.Xz);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bv(int i) {
        this.Xx.setShowFlag(this.Xy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Xx;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xx.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bt(int i) {
        this.Xy |= i;
        bv(this.Xy);
    }

    @Override // com.baidu.card.b
    public void bu(int i) {
        this.Xy &= i ^ (-1);
        bv(this.Xy);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Xx.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.XA = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xz = aVar;
        this.Xx.setData(aVar.WO());
    }

    public void aD(boolean z) {
        if (this.Xx != null && this.Xx.getAvatar() != null) {
            this.Xx.getAvatar().setClickable(z);
        }
    }

    public void aE(boolean z) {
        if (this.Xx != null && this.Xx.getUserName() != null) {
            this.Xx.getUserName().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.Xx != null && this.Xx.getAvatar() != null) {
            this.Xx.getAvatar().aF(z);
        }
    }
}
