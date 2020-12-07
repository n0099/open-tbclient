package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class v extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private MutiImgMutiPicLayout ahE;
    private String mFrom;
    private int mSkinType;

    public v(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahE = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahE;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahE.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.ahE.setFrom(this.mFrom);
        this.ahE.H(aVar);
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
        a(1, new a.b() { // from class: com.baidu.card.v.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (v.this.agJ != null && v.this.agJ.bmn() != null) {
                    com.baidu.tieba.card.n.Jq(v.this.agJ.bmn().getId());
                    com.baidu.tieba.card.n.a(v.this.ahE.mTitle, v.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.n.a(v.this.ahE.ahp, v.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
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
