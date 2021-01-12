package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class d extends com.baidu.card.a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agr;
    private CardUserInfoLayout agx;
    private int agy;
    private a agz;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.agy = 34053;
        this.agx = new CardUserInfoLayout(context);
        this.agx.setShowFlag(this.agy);
        this.agx.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.agz != null) {
                    d.this.agz.a(d.this.agr, view);
                }
                if (d.this.sR() != null) {
                    d.this.sR().a(view, d.this.agr);
                }
            }
        });
    }

    @Override // com.baidu.card.a
    public void bs(int i) {
        this.agx.setShowFlag(this.agy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.agx;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agx.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.a
    public void bq(int i) {
        this.agy |= i;
        bs(this.agy);
    }

    @Override // com.baidu.card.a
    public void br(int i) {
        this.agy &= i ^ (-1);
        bs(this.agy);
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agx.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.agz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        this.agx.setData(aVar.bkV());
    }

    public void aC(boolean z) {
        if (this.agx != null && this.agx.getAvatar() != null) {
            this.agx.getAvatar().setClickable(z);
        }
    }

    public void aD(boolean z) {
        if (this.agx != null && this.agx.getUserName() != null) {
            this.agx.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.agx.setPageContext(tbPageContext);
    }
}
