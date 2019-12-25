package com.baidu.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class z extends h {
    private com.baidu.tbadk.core.data.a JB;
    private RichTextLayout KG;
    private String mFrom;
    private int mSkinType;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.KG = new RichTextLayout(tbPageContext.getPageActivity());
        this.KG.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.KG;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JB = aVar;
        this.KG.setTransmit(mF().booleanValue());
        this.KG.A(aVar);
        this.KG.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z.this.Jz != null) {
                    z.this.Jz.a(z.this.JB);
                }
            }
        });
    }

    public void e(int i, int i2, int i3, int i4) {
        this.KG.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, new a.b() { // from class: com.baidu.card.z.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (z.this.JB != null && z.this.JB.axx() != null && !z.this.mF().booleanValue()) {
                    bj axx = z.this.JB.axx();
                    com.baidu.tieba.card.l.zs(axx.getId());
                    com.baidu.tieba.card.l.a(z.this.KG.mTitle, axx.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(z.this.KG.JZ, axx.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && mF().booleanValue()) {
            am.setBackgroundColor(this.KG, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.Jz = aVar;
    }
}
