package com.baidu.card;

import android.content.Context;
/* loaded from: classes21.dex */
public class h extends at {
    private boolean afT;

    public h(Context context) {
        super(context);
        this.afT = false;
    }

    public h(Context context, boolean z) {
        super(context);
        this.afT = false;
        this.afT = z;
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.aiw, this.afT);
    }
}
