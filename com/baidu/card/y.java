package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class y extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agr;
    public MutiImgSingleVerticalLayout ahE;
    private String mFrom;
    private int mSkinType;

    public y(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahE = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahE;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ahE.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        this.ahE.setFrom(this.mFrom);
        this.ahE.C(aVar);
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
        a(1, new a.b() { // from class: com.baidu.card.y.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (y.this.agr != null && y.this.agr.bkV() != null) {
                    com.baidu.tieba.card.m.Ic(y.this.agr.bkV().getId());
                    com.baidu.tieba.card.m.a(y.this.ahE.mTitle, y.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(y.this.ahE.ahj, y.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ahE.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahE.setNeedFrsTabName(z);
    }
}
