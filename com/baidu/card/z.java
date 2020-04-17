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
    private com.baidu.tbadk.core.data.a ada;
    private RichTextLayout aee;
    private String mFrom;
    private int mSkinType;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.aee = new RichTextLayout(tbPageContext.getPageActivity());
        this.aee.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aee;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        this.aee.setTransmit(rm().booleanValue());
        this.aee.A(aVar);
        this.aee.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z.this.acY != null) {
                    z.this.acY.a(z.this.ada);
                }
            }
        });
        this.aee.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.aee.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, new a.b() { // from class: com.baidu.card.z.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0074a c0074a) {
                if (z.this.ada != null && z.this.ada.aIw() != null && !z.this.rm().booleanValue()) {
                    bj aIw = z.this.ada.aIw();
                    com.baidu.tieba.card.l.BB(aIw.getId());
                    com.baidu.tieba.card.l.a(z.this.aee.mTitle, aIw.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(z.this.aee.ady, aIw.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rm().booleanValue()) {
            am.setBackgroundColor(this.aee, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.acY = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aee.setNeedFrsTabName(z);
    }
}
