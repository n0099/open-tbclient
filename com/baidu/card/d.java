package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout Fv;
    private int Fw;
    private com.baidu.tbadk.core.data.a Fx;
    private a Fy;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.Fw = 1285;
        this.Fv = new CardUserInfoLayout(context);
        this.Fv.setShowFlag(this.Fw);
        this.Fv.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Fy != null) {
                    d.this.Fy.a(d.this.Fx, view);
                }
                if (d.this.lH() != null) {
                    d.this.lH().a(view, d.this.Fx);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aD(int i) {
        this.Fv.setShowFlag(this.Fw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Fv;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Fv.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aB(int i) {
        this.Fw |= i;
        aD(this.Fw);
    }

    @Override // com.baidu.card.b
    public void aC(int i) {
        this.Fw &= i ^ (-1);
        aD(this.Fw);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Fv.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.Fy = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        this.Fv.setData(aVar.agI());
    }

    public void T(boolean z) {
        if (this.Fv != null && this.Fv.getAvatar() != null) {
            this.Fv.getAvatar().setClickable(z);
        }
    }

    public void U(boolean z) {
        if (this.Fv != null && this.Fv.getUserName() != null) {
            this.Fv.getUserName().setClickable(z);
        }
    }

    public void V(boolean z) {
        if (this.Fv != null && this.Fv.getAvatar() != null) {
            this.Fv.getAvatar().V(z);
        }
    }
}
