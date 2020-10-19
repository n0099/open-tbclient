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
/* loaded from: classes21.dex */
public class o extends i {
    private AbsThreadDataSupport afH;
    private NewGridImageLayout agg;
    private int agh;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agg = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.agh = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agg;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.agg.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        this.agg.setFrom(this.mFrom);
        this.agg.setFromForPb(this.agh);
        this.agg.setTransmit(tC().booleanValue());
        this.agg.H(absThreadDataSupport);
        this.agg.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.afF != null) {
                    o.this.afF.a(o.this.afH);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.agg != null) {
            this.agg.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agg, R.color.cp_bg_line_g);
        }
        if (this.agg != null) {
            this.agg.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bt(int i) {
        this.agg.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (tC().booleanValue()) {
            this.agg.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.agg != null) {
            this.agg.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (o.this.afH != null && o.this.afH.bfG() != null && !o.this.tC().booleanValue()) {
                    com.baidu.tieba.card.m.Ij(o.this.afH.bfG().getId());
                    com.baidu.tieba.card.m.a(o.this.agg.mTitle, o.this.afH.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(o.this.agg.agl, o.this.afH.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.agg.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.afF = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agg.setNeedFrsTabName(z);
    }

    public void aH(boolean z) {
        this.agg.alb = z;
    }
}
