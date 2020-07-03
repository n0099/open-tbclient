package com.baidu.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ad extends h {
    private AbsThreadDataSupport aea;
    private RichTextLayout afm;
    private String mFrom;
    private int mSkinType;

    public ad(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.afm = new RichTextLayout(tbPageContext.getPageActivity());
        this.afm.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afm;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.afm.setTransmit(rK().booleanValue());
        this.afm.D(absThreadDataSupport);
        this.afm.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ad.this.adY != null) {
                    ad.this.adY.a(ad.this.aea);
                }
            }
        });
        this.afm.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.afm.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        a(1, new a.b() { // from class: com.baidu.card.ad.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (ad.this.aea != null && ad.this.aea.aPS() != null && !ad.this.rK().booleanValue()) {
                    bu aPS = ad.this.aea.aPS();
                    com.baidu.tieba.card.m.DO(aPS.getId());
                    com.baidu.tieba.card.m.a(ad.this.afm.mTitle, aPS.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(ad.this.afm.aeA, aPS.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rK().booleanValue()) {
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.afm, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.adY = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afm.setNeedFrsTabName(z);
    }
}
