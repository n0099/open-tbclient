package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class o extends i {
    private NewGridImageLayout afO;
    private int afP;
    private AbsThreadDataSupport afq;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.afO = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.afP = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afO;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afO.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.afO.setFrom(this.mFrom);
        this.afO.setFromForPb(this.afP);
        this.afO.setTransmit(tC().booleanValue());
        this.afO.G(absThreadDataSupport);
        this.afO.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.afo != null) {
                    o.this.afo.a(o.this.afq);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.afO != null) {
            this.afO.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.afO, R.color.cp_bg_line_g);
        }
        if (this.afO != null) {
            this.afO.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bt(int i) {
        this.afO.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (tC().booleanValue()) {
            this.afO.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.afO != null) {
            this.afO.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (o.this.afq != null && o.this.afq.bcY() != null && !o.this.tC().booleanValue()) {
                    com.baidu.tieba.card.m.Hw(o.this.afq.bcY().getId());
                    com.baidu.tieba.card.m.a(o.this.afO.mTitle, o.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(o.this.afO.afT, o.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.afO.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.afo = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afO.setNeedFrsTabName(z);
    }

    public void aH(boolean z) {
        this.afO.akJ = z;
    }
}
