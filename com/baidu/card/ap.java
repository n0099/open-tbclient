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
    private static final int afz = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private AbsThreadDataSupport aeY;
    private TextView afB;
    private OriginalThreadCardView ahw;
    private boolean ahx;
    private OriginalThreadCardView.a ahy;
    private View mRootView;
    private TextView mTitle;

    public ap(Context context) {
        super(context);
        this.ahx = false;
        this.ahy = new OriginalThreadCardView.a() { // from class: com.baidu.card.ap.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ap.this.aeY != null && ap.this.aeY.bce() != null) {
                    if (ap.this.tw() != null) {
                        ap.this.tw().a(ap.this.ahw, ap.this.aeY);
                    }
                    String id = ap.this.aeY.bce().getId();
                    com.baidu.tieba.card.m.GZ(id);
                    ap.this.di(id);
                    ap.this.aeT.b(new a.C0095a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.afB = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.ahw = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.ahw.setSubClickListener(this.ahy);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afB, R.dimen.tbds7, R.dimen.tbds10);
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
            this.aeY = absThreadDataSupport;
            ay.a(this.mTitle, absThreadDataSupport.bce(), this.ahx);
            ay.a(this.afB, this.mTitle, absThreadDataSupport.bce(), afz, this.ahx);
            this.ahw.b(absThreadDataSupport.bce().edI);
        }
    }

    public void bz(int i) {
        this.ahw.hlS = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        com.baidu.tieba.card.m.a(this.afB, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.ahw.setReadState(com.baidu.tieba.card.m.Ha(str));
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahw.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahx = z;
    }
}
