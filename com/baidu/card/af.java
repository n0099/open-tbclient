package com.baidu.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class af extends h {
    private com.baidu.tbadk.core.data.a ahB;
    private RichTextLayout ajd;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ajd = new RichTextLayout(tbPageContext.getPageActivity());
        this.ajd.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.ajd;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        this.ajd.setTransmit(sP().booleanValue());
        this.ajd.E(aVar);
        this.ajd.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.ahz != null) {
                    af.this.ahz.a(af.this.ahB);
                }
            }
        });
        this.ajd.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.ajd.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (af.this.ahB != null && af.this.ahB.blp() != null && !af.this.sP().booleanValue()) {
                    cb blp = af.this.ahB.blp();
                    com.baidu.tieba.card.m.IW(blp.getId());
                    com.baidu.tieba.card.m.a(af.this.ajd.mTitle, blp.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(af.this.ajd.air, blp.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && sP().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ajd, R.color.CAM_X0206);
        }
        this.mSkinType = i;
    }

    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.ahz = interfaceC0094a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajd.setNeedFrsTabName(z);
    }
}
