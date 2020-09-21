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
/* loaded from: classes20.dex */
public class af extends i {
    private AbsThreadDataSupport afq;
    private RichTextLayout agI;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agI = new RichTextLayout(tbPageContext.getPageActivity());
        this.agI.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agI;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.agI.setTransmit(tC().booleanValue());
        this.agI.G(absThreadDataSupport);
        this.agI.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.afo != null) {
                    af.this.afo.a(af.this.afq);
                }
            }
        });
        this.agI.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.agI.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (af.this.afq != null && af.this.afq.bcY() != null && !af.this.tC().booleanValue()) {
                    bw bcY = af.this.afq.bcY();
                    com.baidu.tieba.card.m.Hw(bcY.getId());
                    com.baidu.tieba.card.m.a(af.this.agI.mTitle, bcY.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(af.this.agI.afT, bcY.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agI, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.afo = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agI.setNeedFrsTabName(z);
    }
}
