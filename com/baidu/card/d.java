package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout Xw;
    private int Xx;
    private com.baidu.tbadk.core.data.a Xy;
    private a Xz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.Xx = 1285;
        this.Xw = new CardUserInfoLayout(context);
        this.Xw.setShowFlag(this.Xx);
        this.Xw.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xz != null) {
                    d.this.Xz.a(d.this.Xy, view);
                }
                if (d.this.rk() != null) {
                    d.this.rk().a(view, d.this.Xy);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bv(int i) {
        this.Xw.setShowFlag(this.Xx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Xw;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xw.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bt(int i) {
        this.Xx |= i;
        bv(this.Xx);
    }

    @Override // com.baidu.card.b
    public void bu(int i) {
        this.Xx &= i ^ (-1);
        bv(this.Xx);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Xw.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.Xz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xy = aVar;
        this.Xw.setData(aVar.WO());
    }

    public void aD(boolean z) {
        if (this.Xw != null && this.Xw.getAvatar() != null) {
            this.Xw.getAvatar().setClickable(z);
        }
    }

    public void aE(boolean z) {
        if (this.Xw != null && this.Xw.getUserName() != null) {
            this.Xw.getUserName().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.Xw != null && this.Xw.getAvatar() != null) {
            this.Xw.getAvatar().aF(z);
        }
    }
}
