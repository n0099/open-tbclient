package com.baidu.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class z extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private MutiImgTextLayout ahL;
    private String mFrom;
    private int mSkinType;

    public z(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahL = new MutiImgTextLayout(context);
        this.ahL.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahL;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahL.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.ahL.setFrom(this.mFrom);
        this.ahL.H(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tD() {
        a(1, new a.b() { // from class: com.baidu.card.z.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (z.this.agJ != null && z.this.agJ.bmn() != null) {
                    com.baidu.tieba.card.n.Jq(z.this.agJ.bmn().getId());
                    com.baidu.tieba.card.n.a(z.this.ahL.mTitle, z.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.n.a(z.this.ahL.ahp, z.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ahL.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahL.setNeedFrsTabName(z);
    }
}
