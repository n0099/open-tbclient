package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes15.dex */
public class ap extends b<AbsThreadDataSupport> {
    private static final int afx = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private AbsThreadDataSupport aeW;
    private TextView afz;
    private OriginalThreadCardView ahu;
    private boolean ahv;
    private OriginalThreadCardView.a ahw;
    private View mRootView;
    private TextView mTitle;

    public ap(Context context) {
        super(context);
        this.ahv = false;
        this.ahw = new OriginalThreadCardView.a() { // from class: com.baidu.card.ap.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ap.this.aeW != null && ap.this.aeW.bce() != null) {
                    if (ap.this.tw() != null) {
                        ap.this.tw().a(ap.this.ahu, ap.this.aeW);
                    }
                    String id = ap.this.aeW.bce().getId();
                    com.baidu.tieba.card.m.GY(id);
                    ap.this.dh(id);
                    ap.this.aeR.b(new a.C0095a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.afz = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.ahu = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.ahu.setSubClickListener(this.ahw);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afz, R.dimen.tbds7, R.dimen.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            this.aeW = absThreadDataSupport;
            ay.a(this.mTitle, absThreadDataSupport.bce(), this.ahv);
            ay.a(this.afz, this.mTitle, absThreadDataSupport.bce(), afx, this.ahv);
            this.ahu.b(absThreadDataSupport.bce().edE);
        }
    }

    public void bz(int i) {
        this.ahu.hlO = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        com.baidu.tieba.card.m.a(this.afz, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.ahu.setReadState(com.baidu.tieba.card.m.GZ(str));
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahu.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahv = z;
    }
}
