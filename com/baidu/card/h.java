package com.baidu.card;

import android.content.Context;
/* loaded from: classes20.dex */
public class h extends at {
    private boolean afY;

    public h(Context context) {
        super(context);
        this.afY = false;
    }

    public h(Context context, boolean z) {
        super(context);
        this.afY = false;
        this.afY = z;
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.aiB, this.afY);
    }
}
