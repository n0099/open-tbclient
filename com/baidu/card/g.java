package com.baidu.card;

import android.content.Context;
/* loaded from: classes8.dex */
public class g extends ar {
    private boolean aek;

    public g(Context context) {
        super(context);
        this.aek = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.aek = false;
        this.aek = z;
    }

    @Override // com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rP() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agI, this.aek);
    }
}
