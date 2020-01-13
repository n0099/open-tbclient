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
/* loaded from: classes6.dex */
public class z extends h {
    private com.baidu.tbadk.core.data.a JH;
    private RichTextLayout KL;
    private String mFrom;
    private int mSkinType;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.KL = new RichTextLayout(tbPageContext.getPageActivity());
        this.KL.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.KL;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        this.KL.setTransmit(mF().booleanValue());
        this.KL.A(aVar);
        this.KL.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z.this.JF != null) {
                    z.this.JF.a(z.this.JH);
                }
            }
        });
    }

    public void e(int i, int i2, int i3, int i4) {
        this.KL.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, new a.b() { // from class: com.baidu.card.z.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (z.this.JH != null && z.this.JH.axQ() != null && !z.this.mF().booleanValue()) {
                    bj axQ = z.this.JH.axQ();
                    com.baidu.tieba.card.l.zC(axQ.getId());
                    com.baidu.tieba.card.l.a(z.this.KL.mTitle, axQ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(z.this.KL.Kf, axQ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && mF().booleanValue()) {
            am.setBackgroundColor(this.KL, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.JF = aVar;
    }
}
