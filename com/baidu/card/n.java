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
    private AbsThreadDataSupport aeY;
    private NewGridImageLayout afw;
    private int afx;
    private String mFrom;
    private int mSkinType;

    public n(Context context) {
        super(context);
        this.mSkinType = 3;
        this.afw = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.afx = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afw;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afw.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        this.afw.setFrom(this.mFrom);
        this.afw.setFromForPb(this.afx);
        this.afw.setTransmit(tx().booleanValue());
        this.afw.F(absThreadDataSupport);
        this.afw.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.aeW != null) {
                    n.this.aeW.a(n.this.aeY);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.afw != null) {
            this.afw.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tx().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.afw, R.color.cp_bg_line_g);
        }
        if (this.afw != null) {
            this.afw.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bp(int i) {
        this.afw.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (tx().booleanValue()) {
            this.afw.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.afw != null) {
            this.afw.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.n.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (n.this.aeY != null && n.this.aeY.bce() != null && !n.this.tx().booleanValue()) {
                    com.baidu.tieba.card.m.GZ(n.this.aeY.bce().getId());
                    com.baidu.tieba.card.m.a(n.this.afw.mTitle, n.this.aeY.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(n.this.afw.afB, n.this.aeY.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.afw.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.aeW = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afw.setNeedFrsTabName(z);
    }

    public void aH(boolean z) {
        this.afw.akk = z;
    }
}
