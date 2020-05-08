package com.baidu.card;

import android.content.Context;
/* loaded from: classes8.dex */
public class g extends al {
    private boolean ado;

    public g(Context context) {
        super(context);
        this.ado = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.ado = false;
        this.ado = z;
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.afB, this.ado);
    }
}
