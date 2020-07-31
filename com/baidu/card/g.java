package com.baidu.card;

import android.content.Context;
/* loaded from: classes15.dex */
public class g extends ar {
    private boolean aea;

    public g(Context context) {
        super(context);
        this.aea = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.aea = false;
        this.aea = z;
    }

    @Override // com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rR() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agz, this.aea);
    }
}
