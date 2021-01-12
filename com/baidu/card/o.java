package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class o extends h {
    private com.baidu.tbadk.core.data.a agr;
    private NewGridImageLayout ahe;
    private int ahf;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahe = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.ahf = i;
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.ahe;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ahe.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        this.ahe.setFrom(this.mFrom);
        this.ahe.setFromForPb(this.ahf);
        this.ahe.setTransmit(sS().booleanValue());
        this.ahe.C(aVar);
        this.ahe.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.agp != null) {
                    o.this.agp.a(o.this.agr);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.ahe != null) {
            this.ahe.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && sS().booleanValue()) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ahe, R.color.CAM_X0206);
        }
        if (this.ahe != null) {
            this.ahe.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bv(int i) {
        this.ahe.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (sS().booleanValue()) {
            this.ahe.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.ahe != null) {
            this.ahe.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (o.this.agr != null && o.this.agr.bkV() != null && !o.this.sS().booleanValue()) {
                    com.baidu.tieba.card.m.Ic(o.this.agr.bkV().getId());
                    com.baidu.tieba.card.m.a(o.this.ahe.mTitle, o.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(o.this.ahe.ahj, o.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ahe.setFromCDN(z);
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agp = interfaceC0088a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahe.setNeedFrsTabName(z);
    }

    public void aF(boolean z) {
        this.ahe.alS = z;
    }

    public void aG(boolean z) {
        if (this.ahe != null && this.ahe.alQ != null) {
            this.ahe.alQ.setIsTransform(z);
        }
    }
}
