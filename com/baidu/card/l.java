package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class l extends h {
    private com.baidu.tbadk.core.data.a ada;
    private NewGridImageLayout adu;
    private String mFrom;
    private int mSkinType;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.adu = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.adu;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.adu.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        this.adu.setFrom(this.mFrom);
        this.adu.setTransmit(rm().booleanValue());
        this.adu.A(aVar);
        this.adu.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.acY != null) {
                    l.this.acY.a(l.this.ada);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.adu != null) {
            this.adu.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rm().booleanValue()) {
            am.setBackgroundColor(this.adu, R.color.cp_bg_line_g);
        }
        if (this.adu != null) {
            this.adu.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    public void ba(int i) {
        this.adu.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (rm().booleanValue()) {
            this.adu.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.adu != null) {
            this.adu.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, new a.b() { // from class: com.baidu.card.l.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0074a c0074a) {
                if (l.this.ada != null && l.this.ada.aIw() != null && !l.this.rm().booleanValue()) {
                    com.baidu.tieba.card.l.BB(l.this.ada.aIw().getId());
                    com.baidu.tieba.card.l.a(l.this.adu.mTitle, l.this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(l.this.adu.ady, l.this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.adu.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.acY = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.adu.setNeedFrsTabName(z);
    }
}
