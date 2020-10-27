package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes21.dex */
public class e extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    private CardUserInfoLayout afO;
    private int afP;
    private a afQ;

    /* loaded from: classes21.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.afP = 34053;
        this.afO = new CardUserInfoLayout(context);
        this.afO.setShowFlag(this.afP);
        this.afO.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.afQ != null) {
                    e.this.afQ.a(e.this.afI, view);
                }
                if (e.this.tB() != null) {
                    e.this.tB().a(view, e.this.afI);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bq(int i) {
        this.afO.setShowFlag(this.afP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afO;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afO.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.afP |= i;
        bq(this.afP);
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.afP &= i ^ (-1);
        bq(this.afP);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afO.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.afQ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        this.afO.setData(absThreadDataSupport.bhz());
    }

    public void aE(boolean z) {
        if (this.afO != null && this.afO.getAvatar() != null) {
            this.afO.getAvatar().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.afO != null && this.afO.getUserName() != null) {
            this.afO.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.afO.setPageContext(tbPageContext);
    }
}
