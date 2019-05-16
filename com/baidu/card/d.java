package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout Vo;
    private int Vp;
    private com.baidu.tbadk.core.data.a Vq;
    private a Vr;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.Vp = 1285;
        this.Vo = new CardUserInfoLayout(context);
        this.Vo.setShowFlag(this.Vp);
        this.Vo.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Vr != null) {
                    d.this.Vr.a(d.this.Vq, view);
                }
                if (d.this.qf() != null) {
                    d.this.qf().a(view, d.this.Vq);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.Vo.setShowFlag(this.Vp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Vo;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Vo.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.Vp |= i;
        bo(this.Vp);
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.Vp &= i ^ (-1);
        bo(this.Vp);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Vo.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.Vr = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vq = aVar;
        this.Vo.setData(aVar.abv());
    }

    public void av(boolean z) {
        if (this.Vo != null && this.Vo.getAvatar() != null) {
            this.Vo.getAvatar().setClickable(z);
        }
    }

    public void aw(boolean z) {
        if (this.Vo != null && this.Vo.getUserName() != null) {
            this.Vo.getUserName().setClickable(z);
        }
    }

    public void ax(boolean z) {
        if (this.Vo != null && this.Vo.getAvatar() != null) {
            this.Vo.getAvatar().ax(z);
        }
    }
}
