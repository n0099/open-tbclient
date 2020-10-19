package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes21.dex */
public class e extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    private CardUserInfoLayout afN;
    private int afO;
    private a afP;

    /* loaded from: classes21.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.afO = 34053;
        this.afN = new CardUserInfoLayout(context);
        this.afN.setShowFlag(this.afO);
        this.afN.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.afP != null) {
                    e.this.afP.a(e.this.afH, view);
                }
                if (e.this.tB() != null) {
                    e.this.tB().a(view, e.this.afH);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bq(int i) {
        this.afN.setShowFlag(this.afO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afN;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afN.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.afO |= i;
        bq(this.afO);
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.afO &= i ^ (-1);
        bq(this.afO);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afN.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.afP = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        this.afN.setData(absThreadDataSupport.bfG());
    }

    public void aE(boolean z) {
        if (this.afN != null && this.afN.getAvatar() != null) {
            this.afN.getAvatar().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.afN != null && this.afN.getUserName() != null) {
            this.afN.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.afN.setPageContext(tbPageContext);
    }
}
