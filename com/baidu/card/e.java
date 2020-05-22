package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public class e extends b<AbsThreadDataSupport> {
    private CardUserInfoLayout adC;
    private int adD;
    private a adE;
    private AbsThreadDataSupport adw;

    /* loaded from: classes8.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.adD = 34053;
        this.adC = new CardUserInfoLayout(context);
        this.adC.setShowFlag(this.adD);
        this.adC.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.adE != null) {
                    e.this.adE.a(e.this.adw, view);
                }
                if (e.this.rs() != null) {
                    e.this.rs().a(view, e.this.adw);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void aZ(int i) {
        this.adC.setShowFlag(this.adD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adC;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adC.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void aX(int i) {
        this.adD |= i;
        aZ(this.adD);
    }

    @Override // com.baidu.card.b
    public void aY(int i) {
        this.adD &= i ^ (-1);
        aZ(this.adD);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.adC.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.adE = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        this.adC.setData(absThreadDataSupport.aOi());
    }

    public void aC(boolean z) {
        if (this.adC != null && this.adC.getAvatar() != null) {
            this.adC.getAvatar().setClickable(z);
        }
    }

    public void aD(boolean z) {
        if (this.adC != null && this.adC.getUserName() != null) {
            this.adC.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.adC.setPageContext(tbPageContext);
    }
}
