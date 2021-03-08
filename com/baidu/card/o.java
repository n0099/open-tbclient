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
    private com.baidu.tbadk.core.data.a ahB;
    private NewGridImageLayout aim;
    private int ain;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aim = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.ain = i;
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.aim;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aim.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        this.aim.setFrom(this.mFrom);
        this.aim.setFromForPb(this.ain);
        this.aim.setTransmit(sP().booleanValue());
        this.aim.E(aVar);
        this.aim.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ahz != null) {
                    o.this.ahz.a(o.this.ahB);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.aim != null) {
            this.aim.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && sP().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aim, R.color.CAM_X0206);
        }
        if (this.aim != null) {
            this.aim.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bw(int i) {
        this.aim.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (sP().booleanValue()) {
            this.aim.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.aim != null) {
            this.aim.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (o.this.ahB != null && o.this.ahB.blp() != null && !o.this.sP().booleanValue()) {
                    com.baidu.tieba.card.m.IW(o.this.ahB.blp().getId());
                    com.baidu.tieba.card.m.a(o.this.aim.mTitle, o.this.ahB.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(o.this.aim.air, o.this.ahB.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aim.setFromCDN(z);
    }

    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.ahz = interfaceC0094a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aim.setNeedFrsTabName(z);
    }

    public void aF(boolean z) {
        this.aim.ana = z;
    }

    public void aG(boolean z) {
        if (this.aim != null && this.aim.amY != null) {
            this.aim.amY.setIsTransform(z);
        }
    }
}
