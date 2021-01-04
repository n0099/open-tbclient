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
    private NewGridImageLayout ahV;
    private int ahW;
    private com.baidu.tbadk.core.data.a ahi;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahV = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.ahW = i;
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.ahV;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ahV.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        this.ahV.setFrom(this.mFrom);
        this.ahV.setFromForPb(this.ahW);
        this.ahV.setTransmit(td().booleanValue());
        this.ahV.D(aVar);
        this.ahV.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ahg != null) {
                    o.this.ahg.a(o.this.ahi);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.ahV != null) {
            this.ahV.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && td().booleanValue()) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ahV, R.color.CAM_X0206);
        }
        if (this.ahV != null) {
            this.ahV.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bx(int i) {
        this.ahV.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (td().booleanValue()) {
            this.ahV.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.ahV != null) {
            this.ahV.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                if (o.this.ahi != null && o.this.ahi.boO() != null && !o.this.td().booleanValue()) {
                    com.baidu.tieba.card.m.Jo(o.this.ahi.boO().getId());
                    com.baidu.tieba.card.m.a(o.this.ahV.mTitle, o.this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(o.this.ahV.aia, o.this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ahV.setFromCDN(z);
    }

    public void a(a.InterfaceC0089a interfaceC0089a) {
        this.ahg = interfaceC0089a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV.setNeedFrsTabName(z);
    }

    public void aF(boolean z) {
        this.ahV.amJ = z;
    }

    public void aG(boolean z) {
        if (this.ahV != null && this.ahV.amH != null) {
            this.ahV.amH.setIsTransform(z);
        }
    }
}
