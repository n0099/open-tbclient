package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class e extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private CardUserInfoLayout adW;
    private int adX;
    private a adY;

    /* loaded from: classes15.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.adX = 34053;
        this.adW = new CardUserInfoLayout(context);
        this.adW.setShowFlag(this.adX);
        this.adW.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.adY != null) {
                    e.this.adY.a(e.this.adQ, view);
                }
                if (e.this.rL() != null) {
                    e.this.rL().a(view, e.this.adQ);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bh(int i) {
        this.adW.setShowFlag(this.adX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adW;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adW.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bf(int i) {
        this.adX |= i;
        bh(this.adX);
    }

    @Override // com.baidu.card.b
    public void bg(int i) {
        this.adX &= i ^ (-1);
        bh(this.adX);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.adW.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.adY = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.adW.setData(absThreadDataSupport.aTN());
    }

    public void aD(boolean z) {
        if (this.adW != null && this.adW.getAvatar() != null) {
            this.adW.getAvatar().setClickable(z);
        }
    }

    public void aE(boolean z) {
        if (this.adW != null && this.adW.getUserName() != null) {
            this.adW.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.adW.setPageContext(tbPageContext);
    }
}
