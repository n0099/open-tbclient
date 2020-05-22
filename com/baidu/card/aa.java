package com.baidu.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class aa extends h {
    private AbsThreadDataSupport adw;
    private RichTextLayout aeE;
    private String mFrom;
    private int mSkinType;

    public aa(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.aeE = new RichTextLayout(tbPageContext.getPageActivity());
        this.aeE.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.aeE;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        this.aeE.setTransmit(rt().booleanValue());
        this.aeE.D(absThreadDataSupport);
        this.aeE.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.aa.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.adu != null) {
                    aa.this.adu.a(aa.this.adw);
                }
            }
        });
        this.aeE.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.aeE.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rr() {
        a(1, new a.b() { // from class: com.baidu.card.aa.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (aa.this.adw != null && aa.this.adw.aOi() != null && !aa.this.rt().booleanValue()) {
                    bk aOi = aa.this.adw.aOi();
                    com.baidu.tieba.card.m.Dn(aOi.getId());
                    com.baidu.tieba.card.m.a(aa.this.aeE.mTitle, aOi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(aa.this.aeE.adV, aOi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rt().booleanValue()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.aeE, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.adu = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeE.setNeedFrsTabName(z);
    }
}
