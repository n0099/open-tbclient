package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class e extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeY;
    private CardUserInfoLayout afe;
    private int aff;
    private a afg;

    /* loaded from: classes15.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.aff = 34053;
        this.afe = new CardUserInfoLayout(context);
        this.afe.setShowFlag(this.aff);
        this.afe.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.afg != null) {
                    e.this.afg.a(e.this.aeY, view);
                }
                if (e.this.tw() != null) {
                    e.this.tw().a(view, e.this.aeY);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.afe.setShowFlag(this.aff);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afe;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afe.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bk(int i) {
        this.aff |= i;
        bm(this.aff);
    }

    @Override // com.baidu.card.b
    public void bl(int i) {
        this.aff &= i ^ (-1);
        bm(this.aff);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afe.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.afg = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        this.afe.setData(absThreadDataSupport.bce());
    }

    public void aE(boolean z) {
        if (this.afe != null && this.afe.getAvatar() != null) {
            this.afe.getAvatar().setClickable(z);
        }
    }

    public void aF(boolean z) {
        if (this.afe != null && this.afe.getUserName() != null) {
            this.afe.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.afe.setPageContext(tbPageContext);
    }
}
