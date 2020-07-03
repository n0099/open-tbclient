package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public class e extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aea;
    private CardUserInfoLayout aeg;
    private int aeh;
    private a aei;

    /* loaded from: classes8.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport, View view);
    }

    public e(Context context) {
        super(context);
        this.aeh = 34053;
        this.aeg = new CardUserInfoLayout(context);
        this.aeg.setShowFlag(this.aeh);
        this.aeg.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aei != null) {
                    e.this.aei.a(e.this.aea, view);
                }
                if (e.this.rJ() != null) {
                    e.this.rJ().a(view, e.this.aea);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bf(int i) {
        this.aeg.setShowFlag(this.aeh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeg;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeg.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bd(int i) {
        this.aeh |= i;
        bf(this.aeh);
    }

    @Override // com.baidu.card.b
    public void be(int i) {
        this.aeh &= i ^ (-1);
        bf(this.aeh);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aeg.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.aei = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.aeg.setData(absThreadDataSupport.aPS());
    }

    public void aD(boolean z) {
        if (this.aeg != null && this.aeg.getAvatar() != null) {
            this.aeg.getAvatar().setClickable(z);
        }
    }

    public void aE(boolean z) {
        if (this.aeg != null && this.aeg.getUserName() != null) {
            this.aeg.getUserName().setClickable(z);
        }
    }

    public void b(TbPageContext tbPageContext) {
        this.aeg.setPageContext(tbPageContext);
    }
}
