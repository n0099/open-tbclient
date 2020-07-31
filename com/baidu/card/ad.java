package com.baidu.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ad extends h {
    private AbsThreadDataSupport adQ;
    private RichTextLayout afd;
    private String mFrom;
    private int mSkinType;

    public ad(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.afd = new RichTextLayout(tbPageContext.getPageActivity());
        this.afd.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.afd;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.afd.setTransmit(rM().booleanValue());
        this.afd.D(absThreadDataSupport);
        this.afd.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ad.this.adO != null) {
                    ad.this.adO.a(ad.this.adQ);
                }
            }
        });
        this.afd.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.afd.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        a(1, new a.b() { // from class: com.baidu.card.ad.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (ad.this.adQ != null && ad.this.adQ.aTN() != null && !ad.this.rM().booleanValue()) {
                    bv aTN = ad.this.adQ.aTN();
                    com.baidu.tieba.card.m.Ez(aTN.getId());
                    com.baidu.tieba.card.m.a(ad.this.afd.mTitle, aTN.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(ad.this.afd.aeq, aTN.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rM().booleanValue()) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.afd, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.adO = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afd.setNeedFrsTabName(z);
    }
}
