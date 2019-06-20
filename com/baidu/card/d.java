package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout Vn;
    private int Vo;
    private com.baidu.tbadk.core.data.a Vp;
    private a Vq;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.Vo = 1285;
        this.Vn = new CardUserInfoLayout(context);
        this.Vn.setShowFlag(this.Vo);
        this.Vn.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Vq != null) {
                    d.this.Vq.a(d.this.Vp, view);
                }
                if (d.this.qf() != null) {
                    d.this.qf().a(view, d.this.Vp);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.Vn.setShowFlag(this.Vo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Vn;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Vn.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.Vo |= i;
        bo(this.Vo);
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.Vo &= i ^ (-1);
        bo(this.Vo);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Vn.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.Vq = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vp = aVar;
        this.Vn.setData(aVar.abv());
    }

    public void av(boolean z) {
        if (this.Vn != null && this.Vn.getAvatar() != null) {
            this.Vn.getAvatar().setClickable(z);
        }
    }

    public void aw(boolean z) {
        if (this.Vn != null && this.Vn.getUserName() != null) {
            this.Vn.getUserName().setClickable(z);
        }
    }

    public void ax(boolean z) {
        if (this.Vn != null && this.Vn.getAvatar() != null) {
            this.Vn.getAvatar().ax(z);
        }
    }
}
