package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class o extends i {
    private AbsThreadDataSupport afI;
    private NewGridImageLayout agh;
    private int agi;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agh = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFromForPb(int i) {
        this.agi = i;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.agh;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<AbsThreadDataSupport> abVar) {
        this.agh.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        this.agh.setFrom(this.mFrom);
        this.agh.setFromForPb(this.agi);
        this.agh.setTransmit(tC().booleanValue());
        this.agh.H(absThreadDataSupport);
        this.agh.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.afG != null) {
                    o.this.afG.a(o.this.afI);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.agh != null) {
            this.agh.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && tC().booleanValue()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.agh, R.color.cp_bg_line_g);
        }
        if (this.agh != null) {
            this.agh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void bt(int i) {
        this.agh.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (tC().booleanValue()) {
            this.agh.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.agh != null) {
            this.agh.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.o.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (o.this.afI != null && o.this.afI.bjZ() != null && !o.this.tC().booleanValue()) {
                    com.baidu.tieba.card.n.IZ(o.this.afI.bjZ().getId());
                    com.baidu.tieba.card.n.a(o.this.agh.mTitle, o.this.afI.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(o.this.agh.agm, o.this.afI.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.agh.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.afG = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agh.setNeedFrsTabName(z);
    }

    public void aH(boolean z) {
        this.agh.alc = z;
    }
}
