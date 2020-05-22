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
    private NewGridImageLayout adR;
    private AbsThreadDataSupport adw;
    private String mFrom;
    private int mSkinType;

    public m(Context context) {
        super(context);
        this.mSkinType = 3;
        this.adR = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.adR;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.adR.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        this.adR.setFrom(this.mFrom);
        this.adR.setTransmit(rt().booleanValue());
        this.adR.D(absThreadDataSupport);
        this.adR.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.adu != null) {
                    m.this.adu.a(m.this.adw);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.adR != null) {
            this.adR.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rt().booleanValue()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.adR, R.color.cp_bg_line_g);
        }
        if (this.adR != null) {
            this.adR.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    public void bc(int i) {
        this.adR.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (rt().booleanValue()) {
            this.adR.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.adR != null) {
            this.adR.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rr() {
        a(1, new a.b() { // from class: com.baidu.card.m.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (m.this.adw != null && m.this.adw.aOi() != null && !m.this.rt().booleanValue()) {
                    com.baidu.tieba.card.m.Dn(m.this.adw.aOi().getId());
                    com.baidu.tieba.card.m.a(m.this.adR.mTitle, m.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(m.this.adR.adV, m.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.adR.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.adu = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.adR.setNeedFrsTabName(z);
    }
}
