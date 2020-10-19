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
    private AbsThreadDataSupport afH;
    private RichTextLayout agZ;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agZ = new RichTextLayout(tbPageContext.getPageActivity());
        this.agZ.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agZ;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        this.agZ.setTransmit(tC().booleanValue());
        this.agZ.H(absThreadDataSupport);
        this.agZ.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.afF != null) {
                    af.this.afF.a(af.this.afH);
                }
            }
        });
        this.agZ.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.agZ.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (af.this.afH != null && af.this.afH.bfG() != null && !af.this.tC().booleanValue()) {
                    bw bfG = af.this.afH.bfG();
                    com.baidu.tieba.card.m.Ij(bfG.getId());
                    com.baidu.tieba.card.m.a(af.this.agZ.mTitle, bfG.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(af.this.agZ.agl, bfG.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agZ, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.afF = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agZ.setNeedFrsTabName(z);
    }
}
