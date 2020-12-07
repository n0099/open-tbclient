package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes21.dex */
public class e extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private CardUserInfoLayout agP;
    private int agQ;
    private a agR;

    /* loaded from: classes21.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public e(Context context) {
        super(context);
        this.agQ = 34053;
        this.agP = new CardUserInfoLayout(context);
        this.agP.setShowFlag(this.agQ);
        this.agP.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.agR != null) {
                    e.this.agR.a(e.this.agJ, view);
                }
                if (e.this.tE() != null) {
                    e.this.tE().a(view, e.this.agJ);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bu(int i) {
        this.agP.setShowFlag(this.agQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agP;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agP.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bs(int i) {
        this.agQ |= i;
        bu(this.agQ);
    }

    @Override // com.baidu.card.b
    public void bt(int i) {
        this.agQ &= i ^ (-1);
        bu(this.agQ);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agP.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.agR = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.agP.setData(aVar.bmn());
    }

    public void aD(boolean z) {
        if (this.agP != null && this.agP.getAvatar() != null) {
            this.agP.getAvatar().setClickable(z);
        }
    }

    public void aE(boolean z) {
        if (this.agP != null && this.agP.getUserName() != null) {
            this.agP.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.agP.setPageContext(tbPageContext);
    }
}
