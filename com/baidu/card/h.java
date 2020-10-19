package com.baidu.card;

import android.content.Context;
/* loaded from: classes21.dex */
public class h extends at {
    private boolean afS;

    public h(Context context) {
        super(context);
        this.afS = false;
    }

    public h(Context context, boolean z) {
        super(context);
        this.afS = false;
        this.afS = z;
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.aiv, this.afS);
    }
}
