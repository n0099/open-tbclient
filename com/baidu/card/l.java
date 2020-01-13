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
/* loaded from: classes6.dex */
public class l extends h {
    private com.baidu.tbadk.core.data.a JH;
    private NewGridImageLayout Ka;
    private String mFrom;
    private int mSkinType;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Ka = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.Ka;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.Ka.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        this.Ka.setFrom(this.mFrom);
        this.Ka.setTransmit(mF().booleanValue());
        this.Ka.A(aVar);
        this.Ka.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.JF != null) {
                    l.this.JF.a(l.this.JH);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.Ka != null) {
            this.Ka.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && mF().booleanValue()) {
            am.setBackgroundColor(this.Ka, R.color.cp_bg_line_g);
        }
        if (this.Ka != null) {
            this.Ka.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    public void aK(int i) {
        this.Ka.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (mF().booleanValue()) {
            this.Ka.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.Ka != null) {
            this.Ka.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, new a.b() { // from class: com.baidu.card.l.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (l.this.JH != null && l.this.JH.axQ() != null && !l.this.mF().booleanValue()) {
                    com.baidu.tieba.card.l.zC(l.this.JH.axQ().getId());
                    com.baidu.tieba.card.l.a(l.this.Ka.mTitle, l.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(l.this.Ka.Kf, l.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.Ka.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.JF = aVar;
    }
}
