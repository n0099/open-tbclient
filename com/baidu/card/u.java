package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class u extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JH;
    public MutiImgSingleVerticalLayout Ky;
    private String mFrom;
    private int mSkinType;

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Ky = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Ky;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.Ky.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        this.Ky.setFrom(this.mFrom);
        this.Ky.A(aVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, new a.b() { // from class: com.baidu.card.u.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (u.this.JH != null && u.this.JH.axQ() != null) {
                    com.baidu.tieba.card.l.zC(u.this.JH.axQ().getId());
                    com.baidu.tieba.card.l.a(u.this.Ky.mTitle, u.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(u.this.Ky.Kf, u.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.Ky.setFromCDN(z);
    }
}
