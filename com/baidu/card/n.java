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
/* loaded from: classes15.dex */
public class n extends h {
    private AbsThreadDataSupport aeW;
    private NewGridImageLayout afu;
    private int afv;
    private String mFrom;
    private int mSkinType;

    public n(Context context) {
        super(context);
        this.mSkinType = 3;
        this.afu = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.afv = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afu;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afu.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.afu.setFrom(this.mFrom);
        this.afu.setFromForPb(this.afv);
        this.afu.setTransmit(tx().booleanValue());
        this.afu.F(absThreadDataSupport);
        this.afu.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.aeU != null) {
                    n.this.aeU.a(n.this.aeW);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.afu != null) {
            this.afu.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tx().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.afu, R.color.cp_bg_line_g);
        }
        if (this.afu != null) {
            this.afu.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bp(int i) {
        this.afu.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (tx().booleanValue()) {
            this.afu.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.afu != null) {
            this.afu.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.n.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (n.this.aeW != null && n.this.aeW.bce() != null && !n.this.tx().booleanValue()) {
                    com.baidu.tieba.card.m.GY(n.this.aeW.bce().getId());
                    com.baidu.tieba.card.m.a(n.this.afu.mTitle, n.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(n.this.afu.afz, n.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.afu.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.aeU = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afu.setNeedFrsTabName(z);
    }

    public void aH(boolean z) {
        this.afu.aki = z;
    }
}
