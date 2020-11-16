package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class o extends i {
    private com.baidu.tbadk.core.data.a afN;
    private NewGridImageLayout agm;
    private int agn;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agm = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.agn = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agm;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.agm.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        this.agm.setFrom(this.mFrom);
        this.agm.setFromForPb(this.agn);
        this.agm.setTransmit(tC().booleanValue());
        this.agm.H(aVar);
        this.agm.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.afL != null) {
                    o.this.afL.a(o.this.afN);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.agm != null) {
            this.agm.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agm, R.color.CAM_X0206);
        }
        if (this.agm != null) {
            this.agm.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bt(int i) {
        this.agm.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (tC().booleanValue()) {
            this.agm.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.agm != null) {
            this.agm.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (o.this.afN != null && o.this.afN.bjd() != null && !o.this.tC().booleanValue()) {
                    com.baidu.tieba.card.n.IA(o.this.afN.bjd().getId());
                    com.baidu.tieba.card.n.a(o.this.agm.mTitle, o.this.afN.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.n.a(o.this.agm.agr, o.this.afN.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.agm.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.afL = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agm.setNeedFrsTabName(z);
    }

    public void aH(boolean z) {
        this.agm.alg = z;
    }

    public void aI(boolean z) {
        if (this.agm != null && this.agm.ale != null) {
            this.agm.ale.setIsTransform(z);
        }
    }
}
