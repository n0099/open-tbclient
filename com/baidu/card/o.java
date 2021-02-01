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
    private NewGridImageLayout agT;
    private int agU;
    private com.baidu.tbadk.core.data.a agj;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agT = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.agU = i;
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.agT;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.agT.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        this.agT.setFrom(this.mFrom);
        this.agT.setFromForPb(this.agU);
        this.agT.setTransmit(sP().booleanValue());
        this.agT.C(aVar);
        this.agT.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.agh != null) {
                    o.this.agh.a(o.this.agj);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.agT != null) {
            this.agT.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && sP().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agT, R.color.CAM_X0206);
        }
        if (this.agT != null) {
            this.agT.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bv(int i) {
        this.agT.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (sP().booleanValue()) {
            this.agT.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.agT != null) {
            this.agT.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (o.this.agj != null && o.this.agj.bln() != null && !o.this.sP().booleanValue()) {
                    com.baidu.tieba.card.m.IM(o.this.agj.bln().getId());
                    com.baidu.tieba.card.m.a(o.this.agT.mTitle, o.this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(o.this.agT.agY, o.this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.agT.setFromCDN(z);
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agh = interfaceC0088a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agT.setNeedFrsTabName(z);
    }

    public void aF(boolean z) {
        this.agT.alI = z;
    }

    public void aG(boolean z) {
        if (this.agT != null && this.agT.alG != null) {
            this.agT.alG.setIsTransform(z);
        }
    }
}
