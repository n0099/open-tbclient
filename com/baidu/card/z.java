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
/* loaded from: classes8.dex */
public class z extends h {
    private com.baidu.tbadk.core.data.a Kc;
    private RichTextLayout Li;
    private String mFrom;
    private int mSkinType;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.Li = new RichTextLayout(tbPageContext.getPageActivity());
        this.Li.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.Li;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.Li.setTransmit(mU().booleanValue());
        this.Li.A(aVar);
        this.Li.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z.this.Ka != null) {
                    z.this.Ka.a(z.this.Kc);
                }
            }
        });
    }

    public void e(int i, int i2, int i3, int i4) {
        this.Li.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        a(1, new a.b() { // from class: com.baidu.card.z.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (z.this.Kc != null && z.this.Kc.aAg() != null && !z.this.mU().booleanValue()) {
                    bj aAg = z.this.Kc.aAg();
                    com.baidu.tieba.card.l.zT(aAg.getId());
                    com.baidu.tieba.card.l.a(z.this.Li.mTitle, aAg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(z.this.Li.KA, aAg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && mU().booleanValue()) {
            am.setBackgroundColor(this.Li, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.Ka = aVar;
    }
}
