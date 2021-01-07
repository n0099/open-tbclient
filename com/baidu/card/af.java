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
    private com.baidu.tbadk.core.data.a ahi;
    private RichTextLayout aiO;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.aiO = new RichTextLayout(tbPageContext.getPageActivity());
        this.aiO.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.aiO;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        this.aiO.setTransmit(td().booleanValue());
        this.aiO.D(aVar);
        this.aiO.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.ahg != null) {
                    af.this.ahg.a(af.this.ahi);
                }
            }
        });
        this.aiO.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.aiO.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                if (af.this.ahi != null && af.this.ahi.boP() != null && !af.this.td().booleanValue()) {
                    bz boP = af.this.ahi.boP();
                    com.baidu.tieba.card.m.Jn(boP.getId());
                    com.baidu.tieba.card.m.a(af.this.aiO.mTitle, boP.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(af.this.aiO.aia, boP.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && td().booleanValue()) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.aiO, R.color.CAM_X0206);
        }
        this.mSkinType = i;
    }

    public void a(a.InterfaceC0089a interfaceC0089a) {
        this.ahg = interfaceC0089a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aiO.setNeedFrsTabName(z);
    }
}
