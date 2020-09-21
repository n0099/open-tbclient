package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes20.dex */
public class e extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afq;
    private CardUserInfoLayout afw;
    private int afx;
    private a afy;

    /* loaded from: classes20.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.afx = 34053;
        this.afw = new CardUserInfoLayout(context);
        this.afw.setShowFlag(this.afx);
        this.afw.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.afy != null) {
                    e.this.afy.a(e.this.afq, view);
                }
                if (e.this.tB() != null) {
                    e.this.tB().a(view, e.this.afq);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bq(int i) {
        this.afw.setShowFlag(this.afx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afw;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afw.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.afx |= i;
        bq(this.afx);
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.afx &= i ^ (-1);
        bq(this.afx);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afw.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.afy = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.afw.setData(absThreadDataSupport.bcY());
    }

    public void aE(boolean z) {
        if (this.afw != null && this.afw.getAvatar() != null) {
            this.afw.getAvatar().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.afw != null && this.afw.getUserName() != null) {
            this.afw.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.afw.setPageContext(tbPageContext);
    }
}
