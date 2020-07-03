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
/* loaded from: classes8.dex */
public class m extends h {
    private AbsThreadDataSupport aea;
    private NewGridImageLayout aev;
    private int aew;
    private String mFrom;
    private int mSkinType;

    public m(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aev = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.aew = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aev;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aev.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.aev.setFrom(this.mFrom);
        this.aev.setFromForPb(this.aew);
        this.aev.setTransmit(rK().booleanValue());
        this.aev.D(absThreadDataSupport);
        this.aev.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.adY != null) {
                    m.this.adY.a(m.this.aea);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.aev != null) {
            this.aev.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rK().booleanValue()) {
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.aev, R.color.cp_bg_line_g);
        }
        if (this.aev != null) {
            this.aev.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bi(int i) {
        this.aev.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (rK().booleanValue()) {
            this.aev.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.aev != null) {
            this.aev.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        a(1, new a.b() { // from class: com.baidu.card.m.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (m.this.aea != null && m.this.aea.aPS() != null && !m.this.rK().booleanValue()) {
                    com.baidu.tieba.card.m.DO(m.this.aea.aPS().getId());
                    com.baidu.tieba.card.m.a(m.this.aev.mTitle, m.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(m.this.aev.aeA, m.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aev.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.adY = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aev.setNeedFrsTabName(z);
    }
}
