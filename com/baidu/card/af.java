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
/* loaded from: classes21.dex */
public class af extends i {
    private AbsThreadDataSupport afI;
    private RichTextLayout aha;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.aha = new RichTextLayout(tbPageContext.getPageActivity());
        this.aha.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aha;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        this.aha.setTransmit(tC().booleanValue());
        this.aha.H(absThreadDataSupport);
        this.aha.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.afG != null) {
                    af.this.afG.a(af.this.afI);
                }
            }
        });
        this.aha.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.aha.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (af.this.afI != null && af.this.afI.bhz() != null && !af.this.tC().booleanValue()) {
                    bw bhz = af.this.afI.bhz();
                    com.baidu.tieba.card.n.II(bhz.getId());
                    com.baidu.tieba.card.n.a(af.this.aha.mTitle, bhz.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(af.this.aha.agm, bhz.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.aha, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.afG = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aha.setNeedFrsTabName(z);
    }
}
