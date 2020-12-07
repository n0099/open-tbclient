package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class y extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    public MutiImgSingleVerticalLayout ahJ;
    private String mFrom;
    private int mSkinType;

    public y(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahJ = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahJ;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahJ.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.ahJ.setFrom(this.mFrom);
        this.ahJ.H(aVar);
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
        a(1, new a.b() { // from class: com.baidu.card.y.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (y.this.agJ != null && y.this.agJ.bmn() != null) {
                    com.baidu.tieba.card.n.Jq(y.this.agJ.bmn().getId());
                    com.baidu.tieba.card.n.a(y.this.ahJ.mTitle, y.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.n.a(y.this.ahJ.ahp, y.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ahJ.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahJ.setNeedFrsTabName(z);
    }
}
