package com.baidu.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ae extends h {
    private AbsThreadDataSupport aeW;
    private RichTextLayout agn;
    private String mFrom;
    private int mSkinType;

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agn = new RichTextLayout(tbPageContext.getPageActivity());
        this.agn.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agn;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.agn.setTransmit(tx().booleanValue());
        this.agn.F(absThreadDataSupport);
        this.agn.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ae.this.aeU != null) {
                    ae.this.aeU.a(ae.this.aeW);
                }
            }
        });
        this.agn.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.agn.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.ae.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (ae.this.aeW != null && ae.this.aeW.bce() != null && !ae.this.tx().booleanValue()) {
                    bw bce = ae.this.aeW.bce();
                    com.baidu.tieba.card.m.GY(bce.getId());
                    com.baidu.tieba.card.m.a(ae.this.agn.mTitle, bce.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(ae.this.agn.afz, bce.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tx().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agn, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.aeU = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn.setNeedFrsTabName(z);
    }
}
