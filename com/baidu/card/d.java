package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout VH;
    private int VI;
    private com.baidu.tbadk.core.data.a VJ;
    private a VK;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.VI = 1285;
        this.VH = new CardUserInfoLayout(context);
        this.VH.setShowFlag(this.VI);
        this.VH.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.VK != null) {
                    d.this.VK.a(d.this.VJ, view);
                }
                if (d.this.qB() != null) {
                    d.this.qB().a(view, d.this.VJ);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.VH.setShowFlag(this.VI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.VH;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.VH.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.VI |= i;
        bo(this.VI);
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.VI &= i ^ (-1);
        bo(this.VI);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.VH.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.VK = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VJ = aVar;
        this.VH.setData(aVar.acy());
    }

    public void ay(boolean z) {
        if (this.VH != null && this.VH.getAvatar() != null) {
            this.VH.getAvatar().setClickable(z);
        }
    }

    public void az(boolean z) {
        if (this.VH != null && this.VH.getUserName() != null) {
            this.VH.getUserName().setClickable(z);
        }
    }

    public void aA(boolean z) {
        if (this.VH != null && this.VH.getAvatar() != null) {
            this.VH.getAvatar().aA(z);
        }
    }
}
