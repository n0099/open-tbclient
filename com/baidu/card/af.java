package com.baidu.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class af extends h {
    private com.baidu.tbadk.core.data.a agr;
    private RichTextLayout ahW;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ahW = new RichTextLayout(tbPageContext.getPageActivity());
        this.ahW.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.ahW;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        this.ahW.setTransmit(sS().booleanValue());
        this.ahW.C(aVar);
        this.ahW.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.agp != null) {
                    af.this.agp.a(af.this.agr);
                }
            }
        });
        this.ahW.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.ahW.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (af.this.agr != null && af.this.agr.bkV() != null && !af.this.sS().booleanValue()) {
                    bz bkV = af.this.agr.bkV();
                    com.baidu.tieba.card.m.Ic(bkV.getId());
                    com.baidu.tieba.card.m.a(af.this.ahW.mTitle, bkV.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(af.this.ahW.ahj, bkV.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && sS().booleanValue()) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ahW, R.color.CAM_X0206);
        }
        this.mSkinType = i;
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agp = interfaceC0088a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahW.setNeedFrsTabName(z);
    }
}
