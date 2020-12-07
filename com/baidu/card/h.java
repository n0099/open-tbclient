package com.baidu.card;

import android.content.Context;
/* loaded from: classes21.dex */
public class h extends at {
    private boolean agX;

    public h(Context context) {
        super(context);
        this.agX = false;
    }

    public h(Context context, boolean z) {
        super(context);
        this.agX = false;
        this.agX = z;
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tK() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ajA, this.agX);
    }
}
