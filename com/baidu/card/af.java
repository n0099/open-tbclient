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
    private com.baidu.tbadk.core.data.a agj;
    private RichTextLayout ahK;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ahK = new RichTextLayout(tbPageContext.getPageActivity());
        this.ahK.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.a
    public View getView() {
        return this.ahK;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        this.ahK.setTransmit(sP().booleanValue());
        this.ahK.C(aVar);
        this.ahK.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.agh != null) {
                    af.this.agh.a(af.this.agj);
                }
            }
        });
        this.ahK.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.ahK.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (af.this.agj != null && af.this.agj.bln() != null && !af.this.sP().booleanValue()) {
                    cb bln = af.this.agj.bln();
                    com.baidu.tieba.card.m.IM(bln.getId());
                    com.baidu.tieba.card.m.a(af.this.ahK.mTitle, bln.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(af.this.ahK.agY, bln.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && sP().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ahK, R.color.CAM_X0206);
        }
        this.mSkinType = i;
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agh = interfaceC0088a;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahK.setNeedFrsTabName(z);
    }
}
