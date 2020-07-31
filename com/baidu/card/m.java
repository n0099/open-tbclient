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
public class m extends h {
    private AbsThreadDataSupport adQ;
    private NewGridImageLayout ael;
    private int aem;
    private String mFrom;
    private int mSkinType;

    public m(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ael = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.aem = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.ael;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.ael.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.ael.setFrom(this.mFrom);
        this.ael.setFromForPb(this.aem);
        this.ael.setTransmit(rM().booleanValue());
        this.ael.D(absThreadDataSupport);
        this.ael.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.adO != null) {
                    m.this.adO.a(m.this.adQ);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.ael != null) {
            this.ael.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rM().booleanValue()) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ael, R.color.cp_bg_line_g);
        }
        if (this.ael != null) {
            this.ael.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bk(int i) {
        this.ael.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (rM().booleanValue()) {
            this.ael.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.ael != null) {
            this.ael.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        a(1, new a.b() { // from class: com.baidu.card.m.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (m.this.adQ != null && m.this.adQ.aTN() != null && !m.this.rM().booleanValue()) {
                    com.baidu.tieba.card.m.Ez(m.this.adQ.aTN().getId());
                    com.baidu.tieba.card.m.a(m.this.ael.mTitle, m.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(m.this.ael.aeq, m.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ael.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.adO = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ael.setNeedFrsTabName(z);
    }

    public void aG(boolean z) {
        this.ael.aiT = z;
    }
}
