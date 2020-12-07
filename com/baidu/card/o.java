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
/* loaded from: classes21.dex */
public class o extends i {
    private com.baidu.tbadk.core.data.a agJ;
    private NewGridImageLayout ahk;
    private int ahl;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahk = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.ahl = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.ahk;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahk.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.ahk.setFrom(this.mFrom);
        this.ahk.setFromForPb(this.ahl);
        this.ahk.setTransmit(tF().booleanValue());
        this.ahk.H(aVar);
        this.ahk.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.agH != null) {
                    o.this.agH.a(o.this.agJ);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.ahk != null) {
            this.ahk.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tF().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ahk, R.color.CAM_X0206);
        }
        if (this.ahk != null) {
            this.ahk.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bx(int i) {
        this.ahk.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (tF().booleanValue()) {
            this.ahk.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.ahk != null) {
            this.ahk.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tD() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (o.this.agJ != null && o.this.agJ.bmn() != null && !o.this.tF().booleanValue()) {
                    com.baidu.tieba.card.n.Jq(o.this.agJ.bmn().getId());
                    com.baidu.tieba.card.n.a(o.this.ahk.mTitle, o.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.n.a(o.this.ahk.ahp, o.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ahk.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.agH = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahk.setNeedFrsTabName(z);
    }

    public void aG(boolean z) {
        this.ahk.amh = z;
    }

    public void aH(boolean z) {
        if (this.ahk != null && this.ahk.amf != null) {
            this.ahk.amf.setIsTransform(z);
        }
    }
}
