package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends b<com.baidu.tbadk.core.data.a> {
    private CardUserInfoLayout VG;
    private int VH;
    private com.baidu.tbadk.core.data.a VI;
    private a VJ;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.VH = 1285;
        this.VG = new CardUserInfoLayout(context);
        this.VG.setShowFlag(this.VH);
        this.VG.setUserAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.VJ != null) {
                    d.this.VJ.a(d.this.VI, view);
                }
                if (d.this.qC() != null) {
                    d.this.qC().a(view, d.this.VI);
                }
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.VG.setShowFlag(this.VH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.VG;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.VG.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.VH |= i;
        bo(this.VH);
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.VH &= i ^ (-1);
        bo(this.VH);
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.VG.setPageUniqueId(bdUniqueId);
    }

    public void a(a aVar) {
        this.VJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VI = aVar;
        this.VG.setData(aVar.acC());
    }

    public void ay(boolean z) {
        if (this.VG != null && this.VG.getAvatar() != null) {
            this.VG.getAvatar().setClickable(z);
        }
    }

    public void az(boolean z) {
        if (this.VG != null && this.VG.getUserName() != null) {
            this.VG.getUserName().setClickable(z);
        }
    }

    public void aA(boolean z) {
        if (this.VG != null && this.VG.getAvatar() != null) {
            this.VG.getAvatar().aA(z);
        }
    }
}
