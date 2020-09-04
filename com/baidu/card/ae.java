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
    private AbsThreadDataSupport aeY;
    private RichTextLayout agp;
    private String mFrom;
    private int mSkinType;

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agp = new RichTextLayout(tbPageContext.getPageActivity());
        this.agp.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agp;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        this.agp.setTransmit(tx().booleanValue());
        this.agp.F(absThreadDataSupport);
        this.agp.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ae.this.aeW != null) {
                    ae.this.aeW.a(ae.this.aeY);
                }
            }
        });
        this.agp.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.agp.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.ae.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (ae.this.aeY != null && ae.this.aeY.bce() != null && !ae.this.tx().booleanValue()) {
                    bw bce = ae.this.aeY.bce();
                    com.baidu.tieba.card.m.GZ(bce.getId());
                    com.baidu.tieba.card.m.a(ae.this.agp.mTitle, bce.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(ae.this.agp.afB, bce.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tx().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agp, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.aeW = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agp.setNeedFrsTabName(z);
    }
}
