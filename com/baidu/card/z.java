package com.baidu.card;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class z extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agr;
    private MutiImgTextLayout ahG;
    private String mFrom;
    private int mSkinType;

    public z(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahG = new MutiImgTextLayout(context);
        this.ahG.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahG;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ahG.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        this.ahG.setFrom(this.mFrom);
        this.ahG.C(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        a(1, new a.b() { // from class: com.baidu.card.z.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (z.this.agr != null && z.this.agr.bkV() != null) {
                    com.baidu.tieba.card.m.Ic(z.this.agr.bkV().getId());
                    com.baidu.tieba.card.m.a(z.this.ahG.mTitle, z.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(z.this.ahG.ahj, z.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ahG.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahG.setNeedFrsTabName(z);
    }
}
