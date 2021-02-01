package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class d extends com.baidu.card.a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agj;
    private CardUserInfoLayout agp;
    private int agq;
    private a agr;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.agq = 34053;
        this.agp = new CardUserInfoLayout(context);
        this.agp.setShowFlag(this.agq);
        this.agp.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.agr != null) {
                    d.this.agr.a(d.this.agj, view);
                }
                if (d.this.sO() != null) {
                    d.this.sO().a(view, d.this.agj);
                }
            }
        });
    }

    @Override // com.baidu.card.a
    public void bs(int i) {
        this.agp.setShowFlag(this.agq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.agp;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agp.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.a
    public void bq(int i) {
        this.agq |= i;
        bs(this.agq);
    }

    @Override // com.baidu.card.a
    public void br(int i) {
        this.agq &= i ^ (-1);
        bs(this.agq);
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agp.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.agr = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        this.agp.setData(aVar.bln());
    }

    public void aC(boolean z) {
        if (this.agp != null && this.agp.getAvatar() != null) {
            this.agp.getAvatar().setClickable(z);
        }
    }

    public void aD(boolean z) {
        if (this.agp != null && this.agp.getUserName() != null) {
            this.agp.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.agp.setPageContext(tbPageContext);
    }
}
