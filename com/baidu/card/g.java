package com.baidu.card;

import android.content.Context;
/* loaded from: classes5.dex */
public class g extends al {
    private boolean JL;

    public g(Context context) {
        super(context);
        this.JL = false;
    }

    public g(Context context, boolean z) {
        super(context);
        this.JL = false;
        this.JL = z;
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Mf, this.JL);
    }
}
