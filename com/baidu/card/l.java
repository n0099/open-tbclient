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
    private com.baidu.tbadk.core.data.a ade;
    private NewGridImageLayout adx;
    private String mFrom;
    private int mSkinType;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.adx = new NewGridImageLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.card.b
    public View getView() {
        return this.adx;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.adx.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        this.adx.setFrom(this.mFrom);
        this.adx.setTransmit(rm().booleanValue());
        this.adx.B(aVar);
        this.adx.setJumpToPbListener(new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.adb != null) {
                    l.this.adb.a(l.this.ade);
                }
            }
        });
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        if (this.adx != null) {
            this.adx.setObjectPool(bVar, bVar2);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i && rm().booleanValue()) {
            am.setBackgroundColor(this.adx, R.color.cp_bg_line_g);
        }
        if (this.adx != null) {
            this.adx.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    public void ba(int i) {
        this.adx.setBackgroundColor(i);
    }

    public void e(int i, int i2, int i3, int i4) {
        if (rm().booleanValue()) {
            this.adx.setPadding(i, i2, i3, i4);
        }
    }

    public void setCornerStyle(int i) {
        if (this.adx != null) {
            this.adx.setCornerStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, new a.b() { // from class: com.baidu.card.l.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (l.this.ade != null && l.this.ade.aIu() != null && !l.this.rm().booleanValue()) {
                    com.baidu.tieba.card.l.BE(l.this.ade.aIu().getId());
                    com.baidu.tieba.card.l.a(l.this.adx.mTitle, l.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(l.this.adx.adB, l.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.adx.setFromCDN(z);
    }

    public void a(b.a aVar) {
        this.adb = aVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.adx.setNeedFrsTabName(z);
    }
}
