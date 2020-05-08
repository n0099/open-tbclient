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
    private com.baidu.tbadk.core.data.a ade;
    private RichTextLayout aeh;
    private String mFrom;
    private int mSkinType;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.aeh = new RichTextLayout(tbPageContext.getPageActivity());
        this.aeh.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aeh;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        this.aeh.setTransmit(rm().booleanValue());
        this.aeh.B(aVar);
        this.aeh.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z.this.adb != null) {
                    z.this.adb.a(z.this.ade);
                }
            }
        });
        this.aeh.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.aeh.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, new a.b() { // from class: com.baidu.card.z.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (z.this.ade != null && z.this.ade.aIu() != null && !z.this.rm().booleanValue()) {
                    bj aIu = z.this.ade.aIu();
                    com.baidu.tieba.card.l.BE(aIu.getId());
                    com.baidu.tieba.card.l.a(z.this.aeh.mTitle, aIu.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(z.this.aeh.adB, aIu.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rm().booleanValue()) {
            am.setBackgroundColor(this.aeh, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.adb = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeh.setNeedFrsTabName(z);
    }
}
