package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout Xv;
    private int Xw;
    private com.baidu.tbadk.core.data.a Xx;
    private a Xy;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.Xw = 1285;
        this.Xv = new CardUserInfoLayout(context);
        this.Xv.setShowFlag(this.Xw);
        this.Xv.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xy != null) {
                    d.this.Xy.a(d.this.Xx, view);
                }
                if (d.this.rk() != null) {
                    d.this.rk().a(view, d.this.Xx);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bw(int i) {
        this.Xv.setShowFlag(this.Xw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Xv;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xv.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bu(int i) {
        this.Xw |= i;
        bw(this.Xw);
    }

    @Override // com.baidu.card.b
    public void bv(int i) {
        this.Xw &= i ^ (-1);
        bw(this.Xw);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Xv.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.Xy = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xx = aVar;
        this.Xv.setData(aVar.WR());
    }

    public void aD(boolean z) {
        if (this.Xv != null && this.Xv.getAvatar() != null) {
            this.Xv.getAvatar().setClickable(z);
        }
    }

    public void aE(boolean z) {
        if (this.Xv != null && this.Xv.getUserName() != null) {
            this.Xv.getUserName().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.Xv != null && this.Xv.getAvatar() != null) {
            this.Xv.getAvatar().aF(z);
        }
    }
}
