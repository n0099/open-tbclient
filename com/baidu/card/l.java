package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class l extends h {
    private com.baidu.tbadk.core.data.a Kc;
    private NewGridImageLayout Kw;
    private String mFrom;
    private int mSkinType;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Kw = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.Kw;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.Kw.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.Kw.setFrom(this.mFrom);
        this.Kw.setTransmit(mU().booleanValue());
        this.Kw.A(aVar);
        this.Kw.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Ka != null) {
                    l.this.Ka.a(l.this.Kc);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.Kw != null) {
            this.Kw.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && mU().booleanValue()) {
            am.setBackgroundColor(this.Kw, R.color.cp_bg_line_g);
        }
        if (this.Kw != null) {
            this.Kw.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    public void aO(int i) {
        this.Kw.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (mU().booleanValue()) {
            this.Kw.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.Kw != null) {
            this.Kw.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        a(1, new a.b() { // from class: com.baidu.card.l.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (l.this.Kc != null && l.this.Kc.aAg() != null && !l.this.mU().booleanValue()) {
                    com.baidu.tieba.card.l.zT(l.this.Kc.aAg().getId());
                    com.baidu.tieba.card.l.a(l.this.Kw.mTitle, l.this.Kc.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(l.this.Kw.KA, l.this.Kc.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.Kw.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.Ka = aVar;
    }
}
