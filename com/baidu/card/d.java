package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class d extends com.baidu.card.a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahi;
    private CardUserInfoLayout aho;
    private int ahp;
    private a ahq;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.ahp = 34053;
        this.aho = new CardUserInfoLayout(context);
        this.aho.setShowFlag(this.ahp);
        this.aho.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ahq != null) {
                    d.this.ahq.a(d.this.ahi, view);
                }
                if (d.this.tc() != null) {
                    d.this.tc().a(view, d.this.ahi);
                }
            }
        });
    }

    @Override // com.baidu.card.a
    public void bu(int i) {
        this.aho.setShowFlag(this.ahp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aho;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aho.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.a
    public void bs(int i) {
        this.ahp |= i;
        bu(this.ahp);
    }

    @Override // com.baidu.card.a
    public void bt(int i) {
        this.ahp &= i ^ (-1);
        bu(this.ahp);
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aho.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.ahq = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        this.aho.setData(aVar.boO());
    }

    public void aC(boolean z) {
        if (this.aho != null && this.aho.getAvatar() != null) {
            this.aho.getAvatar().setClickable(z);
        }
    }

    public void aD(boolean z) {
        if (this.aho != null && this.aho.getUserName() != null) {
            this.aho.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.aho.setPageContext(tbPageContext);
    }
}
