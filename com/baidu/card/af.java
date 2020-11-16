package com.baidu.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class af extends i {
    private com.baidu.tbadk.core.data.a afN;
    private RichTextLayout ahc;
    private String mFrom;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ahc = new RichTextLayout(tbPageContext.getPageActivity());
        this.ahc.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.ahc;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        this.ahc.setTransmit(tC().booleanValue());
        this.ahc.H(aVar);
        this.ahc.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (af.this.afL != null) {
                    af.this.afL.a(af.this.afN);
                }
            }
        });
        this.ahc.setFrom(this.mFrom);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.ahc.setPadding(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.af.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (af.this.afN != null && af.this.afN.bjd() != null && !af.this.tC().booleanValue()) {
                    bx bjd = af.this.afN.bjd();
                    com.baidu.tieba.card.n.IA(bjd.getId());
                    com.baidu.tieba.card.n.a(af.this.ahc.mTitle, bjd.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.n.a(af.this.ahc.agr, bjd.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ahc, R.color.CAM_X0206);
        }
        this.mSkinType = i;
    }

    public void a(b.a aVar) {
        this.afL = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahc.setNeedFrsTabName(z);
    }
}
