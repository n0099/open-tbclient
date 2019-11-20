package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout EV;
    private int EW;
    private com.baidu.tbadk.core.data.a EX;
    private a EY;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.EW = 1285;
        this.EV = new CardUserInfoLayout(context);
        this.EV.setShowFlag(this.EW);
        this.EV.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.EY != null) {
                    d.this.EY.a(d.this.EX, view);
                }
                if (d.this.lH() != null) {
                    d.this.lH().a(view, d.this.EX);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aD(int i) {
        this.EV.setShowFlag(this.EW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.EV;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.EV.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aB(int i) {
        this.EW |= i;
        aD(this.EW);
    }

    @Override // com.baidu.card.b
    public void aC(int i) {
        this.EW &= i ^ (-1);
        aD(this.EW);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.EV.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.EY = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.EX = aVar;
        this.EV.setData(aVar.agG());
    }

    public void T(boolean z) {
        if (this.EV != null && this.EV.getAvatar() != null) {
            this.EV.getAvatar().setClickable(z);
        }
    }

    public void U(boolean z) {
        if (this.EV != null && this.EV.getUserName() != null) {
            this.EV.getUserName().setClickable(z);
        }
    }

    public void V(boolean z) {
        if (this.EV != null && this.EV.getAvatar() != null) {
            this.EV.getAvatar().V(z);
        }
    }
}
