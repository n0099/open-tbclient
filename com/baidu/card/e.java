package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class e extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    private CardUserInfoLayout afc;
    private int afd;
    private a afe;

    /* loaded from: classes15.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.afd = 34053;
        this.afc = new CardUserInfoLayout(context);
        this.afc.setShowFlag(this.afd);
        this.afc.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.afe != null) {
                    e.this.afe.a(e.this.aeW, view);
                }
                if (e.this.tw() != null) {
                    e.this.tw().a(view, e.this.aeW);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.afc.setShowFlag(this.afd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afc;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afc.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bk(int i) {
        this.afd |= i;
        bm(this.afd);
    }

    @Override // com.baidu.card.b
    public void bl(int i) {
        this.afd &= i ^ (-1);
        bm(this.afd);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afc.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.afe = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.afc.setData(absThreadDataSupport.bce());
    }

    public void aE(boolean z) {
        if (this.afc != null && this.afc.getAvatar() != null) {
            this.afc.getAvatar().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.afc != null && this.afc.getUserName() != null) {
            this.afc.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.afc.setPageContext(tbPageContext);
    }
}
